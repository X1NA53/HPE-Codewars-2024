package finished.java_solutions;

import java.util.*;

public class prob18 {
    
    public static void main(String[] args) {
        prob18 p = new prob18();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        int numColumns = file.nextInt();
        int[] data = new int[numColumns];
        int maxY = file.nextInt();
        file.nextLine();
        
        for(int i = 0; i < maxY; i++){ //For each row based on maxY
            String line = file.nextLine();
            char[] chars = line.toCharArray();
          
            for(int index = 1; index < chars.length; index++){
                if(chars[index] == '|'){
                    index += 3; //SKip to middle of series
                    
                    for(int j = 0; j < numColumns; j++){ //For each column
                        if(chars[index] == 'X')
                            data[j]++;
                        index +=3;
                    }
                    if(index >= chars.length)
                        break;
                }
            }
        }
        file.close();

        char col = 65;
        for (int i : data) {
            System.out.println(col++ + ": " + i);
        }
        
        
    }
}
