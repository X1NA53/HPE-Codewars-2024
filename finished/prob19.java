package finished;

import java.text.DecimalFormat;
import java.util.Scanner;

public class prob19 {
    
    public static void main(String[] args) {
        prob19 p = new prob19();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        float marsMinutes = file.nextFloat();
        file.close();
        
        int days = (int)(marsMinutes / (61.625 * 24));
        marsMinutes %= 61.625 * 24; //Remaning after removeing days
        int hours = (int)(marsMinutes / 61.625);
        marsMinutes %= 61.625; //Remaining after hours
        int minutes = (int)(marsMinutes);
        marsMinutes -= minutes;
        float seconds = marsMinutes * 60;

        DecimalFormat df = new DecimalFormat("0.0");
        System.out.println(days + " days " + hours + " hours " + minutes + " minutes " + df.format(seconds) + " seconds");
    }
}
