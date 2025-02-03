import java.util.*;

public class prob10 {
    
    public static void main(String[] args) {
        prob10 p = new prob10();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        ArrayList<Integer> digs = new ArrayList<>();
        //split??
        while(file.hasNext()){
            if(file.hasNextInt())
                digs.add(file.nextInt());
        }
        file.close();

        System.out.println(digs);
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
