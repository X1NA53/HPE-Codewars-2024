package finished;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Stream;

public class prob24 {
    
    public static void main(String[] args) {
        prob24 p = new prob24();
        p.in();
    }

    
    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        while(file.hasNext()){
            String genre = file.nextLine();
            if(genre.equals("END"))
                break;
            directoryInput(genre);
        }
        file.close();
    }

    public void directoryInput(String genre){
        ArrayList<String> songsList = new ArrayList<>();
        try (Stream<Path> fileStream = Files.walk(Paths.get("student_datasets\\files"))){
            fileStream.filter(Files::isRegularFile).forEach(line -> {
                String lineString = line.getFileName().toString();
                
                if(lineString.endsWith(".mp3")){ //If file type is .mp3
                    String[] song = lineString.split(" - ");
                    if(song[2].contains(genre)) //If song's genre contains search genre
                        songsList.add(genre.toUpperCase().replaceAll(" ", "") + "_" + song[0].replaceAll(" ", "") + "_" + song[1] + ".mp3"); //Combines filename to pattern and removes spaces from song title and genre
                }
            });
        } catch (IOException e){
            e.printStackTrace();
        }
        Collections.sort(songsList);
        for (String song : songsList) {
            System.out.println(song);
        }
    }
}
