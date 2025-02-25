
import java.util.Scanner;

public class prob25 {
    private char[] chars;
    
    public static void main(String[] args) {
        prob25 p = new prob25();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        int topWidth = file.nextInt();
        file.nextLine();
        String fullLine = file.nextLine();
        chars = fullLine.toCharArray();

        int startIndex = calcStart(topWidth / 4 + 1); //Num of expected rows
        int i = 0;
        for (char c : chars) {
            System.out.print(c + "" + i++ + " ");
        }
        System.out.println(chars[startIndex - 1]);
        System.out.println(startIndex);


        //(2n - 1) + (20 - 2(n - 1))
        //Rows: size/4 (inc. 0) & bottom row
        //Column: size/4 + 2 
        //But to get orig index: size/4 + 1 columns
    }


    public int calcStart(int expected){
        int sum = 0;
        for (int i = 0; i <= expected; i++) {
            sum += (2 * i - 1) + (20 - 2 * (i - 1));
        }
        return sum;
    }
}
