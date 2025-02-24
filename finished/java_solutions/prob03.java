package finished.java_solutions;
import java.util.Scanner;

public class prob03 {
    
    public static void main(String[] args) {
        prob03 p = new prob03();
        p.in();
    }
    
    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        
        while(file.hasNextInt()){
            int curr = file.nextInt();
            if(curr == -1)
                break;
            else if (curr == 1)
                System.out.println("You, 1 minute ago.");
            else
                System.out.println("You, " + curr + " minutes ago.");
        }
        file.close();
    }
}
