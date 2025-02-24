import os

#args: relative folder path
#returns: list of strs .mp3 files
def get_music_files_from_folder(folder_path):
    mp3files = []
    for file in os.listdir(folder_path):
        if file.endswith(".mp3"):
            mp3files.append(file)
    return mp3files

#returns: list[str] of input genres as read in from file
def get_input():
    l = []
    out = []
    with open("input.txt","r") as file:
        l = file.readlines()
        for i in range(len(l)):
            l[i] = l[i].strip('\n')
    for song in l:
        if song == "END":
            break
        else:
            out.append(song)
    return out

#args: String: genre as read in through get_input, String: song as file name
#returns: True if song has genre, or sub genre
def song_has_genre(genre, song):
    genre_str = song.split(" - ")[2].replace(".mp3","")
    songs_genre = genre_str.split(", ")
    for hgenre in songs_genre:
        if genre.lower() in hgenre.lower(): #pop is in syth pop 
            return True
    return False

#converts name of file to correct format
#args: String: song as file name
#returns: String as wanted in output, does not include genre
def format_song_string(song):
    name = song.split(" - ")[0].replace(" ","")
    artist = song.split(" - ")[1]
    return "_"+name+"_"+artist+".mp3"

#sorts songs in alphabetical order by name
#args: list[String]: song_list is a list of songs formatted using format_song_string()
#returns: list[String] sorted list of song names
def sort_songs(song_list):
    #key is all lower of name, value is real song title
    l = {}
    out = []
    for song in song_list:
        l[song.split("_")[1].lower()] = song
    #sort dict based on lowercase name
    l = dict(sorted(l.items()))
    #return real name of song
    for key in l:
        out.append(l[key])
    return out


#Main Execution Code

if __name__ == "__main__":
    music_files = get_music_files_from_folder("student_datasets\\files")
    genre_list = get_input()
    output_songs = []

    for genre in genre_list:
        songs_in_genre = []
        for song in music_files:
            if song_has_genre(genre, song):
                songs_in_genre.append(format_song_string(song))
        #sort based on artist
        songs_in_genre = sort_songs(songs_in_genre)
        #add genre to string
        for song in songs_in_genre:
            output_songs.append(genre.upper().replace(" ","")+song)

    for song in output_songs:
        print(song)
