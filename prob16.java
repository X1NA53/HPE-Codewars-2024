
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
                map.put(input, ++value);
            } else //If new input
                map.put(input, 1);
        }
        file.close();

        TreeMap<Object, Object> swap = map.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey, (oldValue, newValue) -> newValue, TreeMap:: new));
        System.out.println("DONE");
        System.out.println(map.entrySet());
        System.out.println(swap);
        System.out.println(swap);
        
        Map.Entry<Integer, Integer> trend = swap.remove(swap.lastKey());
        Map.Entry<Integer, Integer> follow = returnHighest();
        System.out.println(trend);

        System.out.println(map.entrySet());//TODO

        System.out.println("Trending: " + trend.getKey() + " [" + trend.getValue() + " count]");
        System.out.println("Second place: " + follow.getKey() + " [" + follow.getValue() + " count]");
    }

    public Map.Entry<Integer, Integer> returnHighest(){
        // System.out.println(Collections.max(map.entrySet(), Map.Entry.comparingByValue()));
        // Map.Entry<Integer, Integer> highest = (Collections.sort(map.entrySet(), Map.Entry.comparingByValue()));
        // map.remove(highest.getKey());
        return null;
    }
}
