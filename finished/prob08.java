package finished;
import java.util.*;

public class prob08 {
    public static void main(String[] args) {
        prob08 p = new prob08();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));

        ArrayList<Character> list = new ArrayList<>();
        String temp = null;
        while(file.hasNext())
            temp = file.next();
        file.close();

        for(char c: temp.toCharArray())
            list.add(c);
        sort(list);
        for (Character character : list) {
            System.out.print(character);
        }
    }

    private void sort(ArrayList<Character> list){
        for(int i = 0; i < list.size(); i++){
            if(Character.isDigit(list.get(i))){
                int minIndexInt = i;
                int minInt = list.get(i);
                for(int j = i + 1; j < list.size(); j++){
                    if(Character.isDigit(list.get(j)) && list.get(j) < minInt){
                        minIndexInt = j;
                        minInt = list.get(j);
                    }
                }
                if(minIndexInt != i){
                    list.set(minIndexInt, list.get(i));
                    list.set(i, (char) minInt);
                }
            } else {
                int minIndexString = i;
                String minString = (String) list.get(i).toString();
                for(int j = i + 1; j < list.size(); j++){
                    if(!(Character.isDigit(list.get(j))) && ((String) list.get(j).toString()).compareTo(minString) < 1){
                        minIndexString = j;
                        minString = (String) list.get(j).toString();
                    }
                }
                if(minIndexString != i){
                    list.set(minIndexString, list.get(i));
                    list.set(i, minString.charAt(0));
                }
            }
        }
    }
}
