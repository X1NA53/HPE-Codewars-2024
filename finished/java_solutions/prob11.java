package finished.java_solutions;

import java.util.*;

public class prob11 {
    //* 64 bit: long, 32 bit: int */
    
    public static void main(String[] args) {
        prob11 p = new prob11();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        ArrayList<Double> sums = new ArrayList<>();
        while(file.hasNextLine()){
            long secs = file.nextLong();
            int nanos = file.nextInt();
            if(secs == 0 && nanos == 0)
                break;
            
            sums.add(secs * 1000.0 + nanos / 1000000.0);
        }
        for (int i = 0; i < sums.size() - 1; i++) {
            System.out.println((int)(sums.get(i + 1) - sums.get(i)));
        }
        file.close();
    }
}
