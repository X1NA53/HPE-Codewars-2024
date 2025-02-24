package finished.java_solutions;

import java.util.*;
import java.util.stream.*;

public class prob16 {
    TreeMap<Integer, Integer> map = new TreeMap<>();
    
    public static void main(String[] args) {
        prob16 p = new prob16();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));

        while(file.hasNextInt()){
            int input = file.nextInt();
            if(input == 0)
                break;
            if(map.containsKey(input)){ //If input already present in map
                Integer value = map.get(input);
                map.put(input, ++value); //Counting number of times each number appears
            } else //If new input
                map.put(input, 1);
        }
        file.close();

        //Swapping values and keys so sorted by # of occurances
        TreeMap<Integer, Integer> swap = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (oldValue, newValue) -> newValue, TreeMap:: new));
        
        Map.Entry<Integer, Integer> trend = swap.lastEntry();
        swap.remove(trend.getKey());
        Map.Entry<Integer, Integer> follow = swap.lastEntry();
       

        System.out.println("Trending: " + trend.getValue() + " [" + trend.getKey() + " count]");
        System.out.println("Second place: " + follow.getValue() + " [" + follow.getKey() + " count]");
    }

}
