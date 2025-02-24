package finished;


import java.util.*;

public class prob17 {
    Map<String, ArrayList<String>> subs = new HashMap<>();
    ArrayList<String> lines = new ArrayList<>();
    
    public static void main(String[] args) {
        prob17 p = new prob17();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        file.useDelimiter("\r\n");

        int cats = file.nextInt(); //How many lines of libs
        int i = 0;
        while(file.hasNext()){
            String line = file.next();

            if(line.startsWith("THE END."))
                break;
            if (i <= cats) {//TODO ??
                Scanner scanLine = new Scanner(line).useDelimiter("=|,");
                String cat = scanLine.next();
                subs.put(cat, new ArrayList<String>());
                while(scanLine.hasNext())
                    subs.get(cat).add(scanLine.next());
                i++;
                scanLine.close();
            }
            if(i > cats){
                lines.add(line);
            }
        }
        file.close();

        
        int numLines = lines.size();
        for (int index = 0; index < numLines; index++) { //Clean OG lines
            clean(lines.removeFirst());
        }
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public void clean(String dirty){
        StringBuilder clean = new StringBuilder();
        String cat = "";

        char[] letts = dirty.toCharArray();
        for(int i = 0; i < letts.length; i++){
            char curr = letts[i];
            if(curr == '<'){
                curr = letts[++i];
                while(curr != '>'){
                    cat += curr;
                    curr = letts[++i];
                }
                clean.append(subs.get(cat.toLowerCase()).removeFirst());
                cat = "";
                continue;
            }
            clean.append(curr);
        }
        lines.add(clean.toString());
    }
}
