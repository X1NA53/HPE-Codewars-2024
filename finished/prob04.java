package finished;
import java.util.Scanner;

public class prob04 {
    
    public static void main(String[] args) {
        prob04 p = new prob04();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        file.useDelimiter("\r\n|" + file.next());
        while (file.hasNext())
            System.out.println(file.next());
        file.close();
    }
}
