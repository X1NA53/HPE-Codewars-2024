package unfin;


import java.util.*;

public class prob26 {
  
    
    public static void main(String[] args) {
        prob26 p = new prob26();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        file.useDelimiter(", ");

        ArrayList<String> vals = new ArrayList<>();
        while(file.hasNext()){
            vals.add(file.next());
        }

        for (String string : vals) {
            System.out.println(Double.parseDouble(string.replaceAll("[^0-9.-]", "")));
        }
    }
    /* 
     * 
     * 
     * 
     * 
     * 
     */
}
