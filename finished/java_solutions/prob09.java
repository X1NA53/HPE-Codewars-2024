package finished.java_solutions;
import java.util.*;

public class prob09 {
    public static void main(String[] args) {
        prob09 p = new prob09();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while(file.hasNextLine()){
            String temp = file.nextLine();
            if(temp.equals("STOP"))
                break;
            list.add(temp);
        }
        file.close();

        for (String line : list) {
            System.out.println(clean(line));
        }
    }

    public String clean(String line){
        StringBuilder fin = new StringBuilder();
        char[] chars = line.toCharArray();
        
        fin.append(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if(chars[i] == chars[i - 1])
                continue;
            fin.append(chars[i]);
        }

        return fin.toString();
    }
}
