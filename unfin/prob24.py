import os

def get_music_files_from_folder(folder_path):
    mp3files = []
    for file in os.listdir(folder_path):
        if file.endswith(".mp3"):
            mp3files.append()
    return mp3files


get_music_files_from_folder("student_datasets\\files")