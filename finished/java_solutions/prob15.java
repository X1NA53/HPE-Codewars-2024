package finished.java_solutions;
import java.util.*;

public class prob15 {
    
    public static void main(String[] args) {
        prob15 p = new prob15();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        String formula = file.next();
        file.close();

        StringBuilder elements = new StringBuilder();
        StringBuilder subscript = new StringBuilder();

        for (char dig : formula.toCharArray()) {
            if(!Character.isDigit(dig)){ //Is letter
                elements.append(dig);
                subscript.append(" ");
            } else{ //Is number/subscript
                elements.append(" ");
                subscript.append(dig);
            }
        }
        System.out.println(elements.toString());
        System.out.println(subscript.toString());
    }
}
