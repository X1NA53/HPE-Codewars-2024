package finished.java_solutions;
import java.util.*;

public class prob10Err {
    //*IF PROBLEM 10 HAD CHANGING OPERATORS */
    ArrayList<ArrayList<Integer>> digis = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Character>> opers = new ArrayList<ArrayList<Character>>();

    public static void main(String[] args) {
        prob10Err p = new prob10Err();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        file.useDelimiter("|\r\n");
        while(file.hasNextLine()){
            if(!file.hasNextInt())
                break;
            ArrayList<Integer> linedigis = new ArrayList<>();
            ArrayList<Character> lineops = new ArrayList<>();
            linedigis.add(file.nextInt());
            lineops.add(file.next().charAt(0));
            linedigis.add(file.nextInt());
            lineops.add(file.next().charAt(0)); //? Redundant?
            linedigis.add(file.nextInt());
            digis.add(linedigis);
            opers.add(lineops);
        }
        file.close();

        while(!digis.isEmpty() && !opers.isEmpty()){
            System.out.println(check(digis.removeFirst(), opers.removeFirst()));
        }
    }

    public String check(ArrayList<Integer> digs, ArrayList<Character> opers){
        return null;
    }
}
