import java.util.Scanner;

public class prob18 {
    
    public static void main(String[] args) {
        prob18 p = new prob18();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        int[] data = new int[file.nextInt()];
        int maxY = file.nextInt();
        file.nextLine();
        //
    }
}
