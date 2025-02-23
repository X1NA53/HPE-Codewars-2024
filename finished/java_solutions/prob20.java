package finished.java_solutions;
import java.util.*;

public class prob20 {
    
    public static void main(String[] args) {
        prob20 p = new prob20();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        ArrayList<ArrayList<String>> addresses = new ArrayList<>(); //Arraylist of indivdual addresses

        while(file.hasNext()){
            String line = file.nextLine(); //Full individual address
            if(line.startsWith("END"))
                break;
            addresses.add(new ArrayList<String>());
            Scanner splitAddress = new Scanner(line).useDelimiter(", ");
            while(splitAddress.hasNext())
                addresses.getLast().add(splitAddress.next());
            splitAddress.close();

        }
        file.close();

        for (ArrayList<String> address : addresses) {
            System.out.println(address.get(0)); //Name
            System.out.println(address.get(1)); //Street Address
            System.out.println(address.get(2) + ", " + address.get(3) + " " + address.get(4)); //City, State Zip-Code
            System.out.println();
        }
    }
}
