package finished.java_solutions;
import java.util.*;

public class prob13 {
    ArrayList<String> box = new ArrayList<>();
    
    public static void main(String[] args) {
        prob13 p = new prob13();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        while(file.hasNext()){
            box.add(file.nextLine());
        }
        file.close();

        int width = box.get(0).length(); //Width of first line/width of box
        int length = box.size(); //# of rows
        int perimeter = (2 * width) + (2 * length) - 4;//*Perimeter - 4 because of duplicate corners */
        
        if(complete(perimeter))
            System.out.println("Nothing to do");
        else{
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    if(i == 0 || i == length - 1){ //First or Last row
                        System.out.print("#");
                    } else {
                        if(j == 0 || j == width - 1){//First or Last index of row
                            System.out.print("#");
                        } else
                            System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }


    // Method to calculate whether box is complete
    public boolean complete(int perimeter){
        int total = 0;
        for (String line : box) {
            for (char curr : line.toCharArray()) {
                if (curr == '#')
                    total++;
            }
        }
        return total == perimeter;
    }
}
