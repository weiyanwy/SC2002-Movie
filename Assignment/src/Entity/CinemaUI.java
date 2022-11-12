package Entity;
import java.util.ArrayList;
import java.util.Scanner;

import Settings.*;

public class CinemaUI {
    private ShowtimeUI showUI=new ShowtimeUI();
    CinemaSettings cinemaset= new CinemaSettings();
    ArrayList<Cinema> CinemaList= new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    public void runCinema(ArrayList<Cinema> Cinemalist){
        CinemaList=Cinemalist;

        int sel;
        boolean exit=true;
        while(exit) {
            sel=cinemaset.selectCinema(CinemaList);
            if (sel==0){
                System.out.println("Exiting....");
                break;
            }
            else if((sel>0)&&(sel<=CinemaList.size())) {
                showUI.runshowUI(Cinemalist.get(sel - 1).getShowtimelist());
            }
            else
                System.out.println("Invalid Input");

        }
    }

}
