package Entity;
import java.util.ArrayList;
import java.util.Scanner;
import Controller.*;
import Settings.*;
public class ShowtimeUI {


    ArrayList<Showtime> Showtimelist= new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void runshowUI(ArrayList<Showtime> ShowList){
        Showtimelist=ShowList;
        int sel;
        boolean exit=true;
        while(exit) {
            printShowtimelist();
            System.out.println("Enter 0 to exit");
            System.out.println("Select Index of Show time to view");
            sel = Integer.parseInt(sc.nextLine());
            if (sel==0){
                System.out.println("Exiting....");
                break;
            }
            if((sel>0)&&(sel<=Showtimelist.size())){
                //layout.runshowUI(showtime[sel-1].getSeatlayout());
            }
            else
                System.out.println("Invalid Input");

        }
    }
    public void printShowtimelist(){
        for(int x=0;x<=Showtimelist.size();x++){
            System.out.println("Date and time:"+Showtimelist.get(x).getTime()+" Type: "+ Showtimelist.get(x).getCinemaType());
        }
    }

}
