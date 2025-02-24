package finished;
import java.util.Scanner;

public class prob06 {
    
    public static void main(String[] args) {
        prob06 p = new prob06();
        p.in();
    }
        
    private void in() {
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        int total = file.nextInt();
        for (int i = 0; i < total; i++) {
            System.out.print(file.next() + " ");
            int age = file.nextInt() * 12 + file.nextInt();
            System.out.println(25 * 12 - age);
        }
        file.close();
    }
}
