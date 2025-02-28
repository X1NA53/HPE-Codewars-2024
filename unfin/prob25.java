package unfin;


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
        file.close();
        chars = fullLine.toCharArray();
        int expectedRowCols = topWidth / 4 + 1;

        int startIndex = calcIndex(expectedRowCols, topWidth); //Num of expected rows
        int i = 0;
        for (char c : chars) {
            System.out.print(c + "" + i++ + " ");
        }
        System.out.println(chars[startIndex]);
        System.out.println(startIndex);
        System.out.println(calcIndex(expectedRowCols - 2, topWidth - 4));

        //Should have a method where you send expect, topwidth, and which time calling wihch then calls the calc method
        //for sure do something recursive


        //Need to decr to go right for rows
        //But go up for column one

        //for loop to go left (down colum) and right for width * 2 - 1 && greater than size
        //and then when going out literally just add width??



        //(2n - 1) + (20 - 2(n - 1))
        //Rows: size/4 (inc. 0) & bottom row
        //Column: size/4 + 2 
        //But to get orig index: size/4 + 1 columns
    }


    public int calcIndex(int expected, int size){
        int sum = 0;
        for (int i = 1; i <= expected; i++) {
            sum += (2 * i - 1) + (size - 2 * i);
        }
        sum += size - 1;
        return sum;
    }
}
