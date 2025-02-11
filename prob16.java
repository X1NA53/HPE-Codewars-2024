
import java.util.*;

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
            System.out.println(input);//TODO
            if(input == 0)
                break;
            if(map.containsKey(input)){ //If input already present in map
                Integer value = map.get(input);
                map.put(input, ++value);
            } else //If new input
                map.put(input, 1);
        }
        file.close();
        
        Map.Entry<Integer, Integer> trend = returnHighest();
        Map.Entry<Integer, Integer> follow = returnHighest();


        System.out.println(map.entrySet());//TODO

        System.out.println("Trending: " + trend.getKey() + " [" + trend.getValue() + " count]");
        System.out.println("Second place: " + follow.getKey() + " [" + follow.getValue() + " count]");
    }

    public Map.Entry<Integer, Integer> returnHighest(){
        Map.Entry<Integer, Integer> highest = (Collections.max(map.entrySet(), Map.Entry.comparingByValue()));
        map.remove(highest.getKey());
        return highest;
    }
}
