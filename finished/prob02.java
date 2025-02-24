package finished;
import java.util.Scanner;

public class prob02 {
    public static void main(String[] args) {
        prob02 p2 = new prob02();
        p2.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        int x = file.nextInt();
        System.out.println(2 * x);
        file.close();
    }
}