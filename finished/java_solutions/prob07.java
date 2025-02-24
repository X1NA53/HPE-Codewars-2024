package finished.java_solutions;
import java.util.Scanner;

public class prob07 {
    public static void main(String[] args) {
        prob07 p = new prob07();
        p.in();
    }
    
    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        file.useDelimiter(""); //Deliminate by each character
        int count = 0;
        boolean printed = false;
        String curr = file.next();
        while(file.hasNext()){
            String next = file.next();
            if(curr.equals(next)){
                ++count;
            } else {
                if(count == 3){
                    System.out.print(curr);
                    printed = true;
                }
                count = 0;
            }
            if(next.equals("."))
                break;
            curr = next;
        }
        file.close();
        if(!printed)
            System.out.println("No Four of a Kind");
    }
}
