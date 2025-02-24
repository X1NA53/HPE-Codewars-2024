package finished.java_solutions;
import java.util.*;

public class prob12 {
    
    public static void main(String[] args) {
        prob12 p = new prob12();
        p.in();
    }

    public void in(){
        Scanner file = new Scanner(getClass().getResourceAsStream("input.txt"));
        ArrayList<String> socks = new ArrayList<>();

        while(file.hasNext()){
            String tempSock = file.nextLine();
            if(tempSock.startsWith("END"))
                break;
            socks.add(tempSock);
        }
        file.close();

        for (int i = 0; i < socks.size() - 1; i++) {
            while(i < 0)
                i++;
            String currSock = socks.get(i);
            for (int j = i + 1; j < socks.size(); j++) {
                String nextSock = socks.get(j);
                if(currSock.equals(nextSock)){
                    socks.remove(currSock);
                    socks.remove(currSock);
                    i =- 2;
                }
            }
        }

        if(socks.isEmpty())
            System.out.println("No lost socks");
        else
            for (String sock : socks) {
                System.out.println(sock);
            }
    }
}
