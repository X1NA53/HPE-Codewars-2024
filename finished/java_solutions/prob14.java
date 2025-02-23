package finished.java_solutions;
import java.util.*;

public class prob14 {
    
    public static void main(String[] args) {
        prob14 p = new prob14();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        ArrayList<String> lines = new ArrayList<>();

        while(file.hasNext()){
            lines.add(file.nextLine());
        }
        file.close();

        double sum = 0.0;
        ArrayList<String> cleanLine = new ArrayList<>();
        String[] nums = lines.get(0).split(" ");

        for (String string : nums) {
            try {
                Double num = Double.parseDouble(string);
                sum += num;
                cleanLine.add(string);
            } catch (NumberFormatException e){
                continue;
            }
        }

        for (String string : cleanLine) {
            System.out.print(string + " ");
        }


        System.out.println();
        if(sum == Double.parseDouble(lines.get(1).substring(9)))
            System.out.println("CHECKED");
        else{
            System.out.println("BADCHECK: " + sum);
        }
    }
}
