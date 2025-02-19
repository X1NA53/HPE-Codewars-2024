import java.util.Scanner;

public class prob22 {
    
    public static void main(String[] args) {
        prob22 p = new prob22();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        int m = file.nextInt();
        int b = file.nextInt();
        int size = file.nextInt();
        file.close();

        System.out.println("y = " + m + "x+" + b);

        //TODO calculate depending on slope
        for (int i = size; i > 0; i--) { //Rows - starting from top
            if(i == b) { //Current row is y-intercept
                System.out.print(String.format("%02d", i).charAt(0) + "*");
            } else {
                System.out.print(String.format("%02d", i));
            }
            
            int x = i / m - b; //x value of x in function
            for (int j = 1; j <= size; j++) { //Columns, not including axis
                int y = m * j + b; //TODO FIX
                if(j == x && i == y) //Current x index is x value of function
                    System.out.print(" *");
                else
                    System.out.print("  ");
            }
            System.out.println(); //New line
        }

        int xInt = 0 / m - b; //Equation converted to x= form
        for(int j = 0; j <= size; j++){//X-axis (inc. origin)
            if(j == xInt)
                System.out.print(String.format("%02d", j).charAt(0) + "*");
            else
                System.out.print(String.format("%02d", j));
        }
    }
}
