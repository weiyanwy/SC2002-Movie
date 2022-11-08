import java.util.Scanner;
public class ShowtimeUI {
    Showtime[] showtime;
    private int Showtimelistsize;

    Scanner sc = new Scanner(System.in);
    public void runshowUI(Showtime[] Showtime, int Size){
        this.showtime= Showtime;
        this.Showtimelistsize=Size;
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
            if((sel>0)&&(sel<=Showtimelistsize)){
                //layout.runshowUI(showtime[sel-1].getSeatlayout());
            }
            else
                System.out.println("Invalid Input");

        }
    }
    public void printShowtimelist(){
        for(int x=1;x<=Showtimelistsize;x++){
            System.out.println("Date and time:"+showtime[x-1].getTime()+" Type: "+ showtime[x-1].getype);
        }
    }

}

    }
}
