package finished.java_solutions;
import java.util.Scanner;

public class prob05 {
    
    public static void main(String[] args) {
        prob05 p = new prob05();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        while(file.hasNextInt()){
            System.out.print((char) file.nextInt());
        }
        file.close();
    }
}
