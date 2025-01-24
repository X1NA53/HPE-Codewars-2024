package finished;


import java.util.*;

public class prob01 {
    static String name;
    public static void main(String[] args) {
        prob01 prob = new prob01();
        prob.input();
        System.out.println("Your real strength comes from being the best " + name + " you can be!");
    }

    public void input(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        name = file.next();
        file.close();
    }
}
