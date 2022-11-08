import java.util.Scanner;
public class CinemaUI {
    private ShowtimeUI showUI;
    private Cinema[] Cinemalist;
    int Cinemalistsize;
    Scanner sc = new Scanner(System.in);
    public void runCinema(Cinema[] Cinemalist, int cinemalistsize){
        Cinemalist=Cinemalist;
        this.Cinemalistsize=cinemalistsize;
        int sel;
        boolean exit=true;
        while(exit) {
            printCinemalist();
            System.out.println("Enter 0 to exit");
            System.out.println("Select Index of Cinema to view");
            sel = Integer.parseInt(sc.nextLine());
            if (sel==0){
                System.out.println("Exiting....");
                break;
            }
            if((sel>0)&&(sel<=Cinemalistsize)){
                showUI.runshowUI(Cinemalist[sel-1].getShowlist, Cinemalist[sel-1].getShowlistSize);
            }
            else
                System.out.println("Invalid Input");

        }
    }
    public void printCinemalist(){
        for(int x=1;x<=Cinemalistsize;x++){
            System.out.println("Cinema #"+x+" "+Cinemalist[x-1].getname());
        }
    }

}
