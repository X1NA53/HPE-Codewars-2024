package finished.java_solutions;
import java.util.*;

public class prob10 {
    
    public static void main(String[] args) {
        prob10 p = new prob10();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        ArrayList<Integer> digs = new ArrayList<>();
        while(file.hasNext()){
            String line = file.nextLine();
            if(!Character.isDigit(line.charAt(0)) && !(line.charAt(0) == '-'))
                break;
            String[] spliting = line.split("\\+|=");
            for (String string : spliting) {
                digs.add(Integer.parseInt(string));
            }
        }
        file.close();
        check(digs);
    }

    public void check(ArrayList<Integer> digs){
        while(!digs.isEmpty()){
            int num1 = digs.removeFirst();
            int num2 = digs.removeFirst();
            int sum = digs.removeFirst();
            int actualSum = num1 + num2;
            if(sum == actualSum)
                System.out.println("CORRECT");
            else
                System.out.println("WRONG: " + num1 + "+" + num2 + "=" + actualSum);
        }
    }
}
