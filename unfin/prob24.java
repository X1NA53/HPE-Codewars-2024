package unfin;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;

public class prob24 {
    
    public static void main(String[] args) {
        prob24 p = new prob24();
        // p.in();
        p.directoryInput();
    }

    
    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
    }

    public void directoryInput(){
        try (Stream<Path> fileStream = Files.walk(Paths.get("student_datasets\\files"))){
            fileStream.filter(Files::isRegularFile).forEach(line -> {
                String[] song = line.getFileName().toString().split(" - ");
                for (String wordString : song) {
                    System.out.println(wordString);
                }
            });
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
