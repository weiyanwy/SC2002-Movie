import java.util.HashMap;
import java.util.Scanner;


public class CineplexSetting{
    private int MovieListSize;
    private Cineplex[] Cineplexlist = new Cineplex[3];
    private int No_Cineplex=0;
    private Cinema[] Cinemalist;
    private int Cinemalistsize;

    CineplexDBcontrol CineplexDB;
    private CinemaSettings Cinemaset;
    Display UI = new Display();
    Scanner sc = new Scanner(System.in);

    String MovieDBaddress;
    String CineplexDBaddress;
    String CinemaDBaddress;
    String ShowtimeDbAddress;
    public void runCineplexSetting(int MovieListsize, String MovieDBaddres, String CineplexDB, String CinemaDB, String ShowtimeDB) {

        MovieListSize=MovieListsize;
        this.MovieDBaddress = MovieDBaddres;
        this.CineplexDBaddress=CineplexDB;
        this.CinemaDBaddress=CinemaDB;
        this.ShowtimeDbAddress=ShowtimeDB;

        int sel=1;
        do {

            try {
                UI.CineplexSettingDisplay();
                sel=Integer.parseInt(sc.nextLine());
                switch(sel) {
                    case(0):
                        //Exit
                        System.out.println("Exit");
                        sel=0;
                        break;
                    case(1):
                        System.out.println("******CREATE CINEPLEX******");
                        //Call Create Cineplex");
                        createCineplex();
                        break;
                    case(2):
                        //Call update cinema functio
                        System.out.println("*****UPDATE CINEPLEX******");
                        updateCineplex();
                        break;
                    case(3):
                        //Call remove cinema
                        System.out.println("*****REMOVE CINEPLEX*****");
                        removeCineplex();
                        break;

                    default:
                        System.out.println("Invalid Choice");
                }
            }

            catch(Exception e) {
                System.out.println("Invalid Choice");
            }
        }while(sel!=0);
        CineplexDB.
    }

    public void createCineplex() {
        String name;
        System.out.println("Enter Cinema Name:");
        name=sc.nextLine();
        //Create new Cineplex class in list
        Cineplexlist[No_Cineplex] = new Cineplex(name);
        No_Cineplex++; //increment Cineplex count
    }

    public int selectCineplex() {
        int sel = 1;
        do {
            try {
                printCinplexlist();
                System.out.println("Select Cinema");
                for(int x=0; x<this.No_Cineplex;x++) {
                    System.out.println("#" +(x+1) + " " +Cineplexlist[x].getCineplexName());
                }
                System.out.println("Enter 0 to exit:");
                sel=Integer.parseInt(sc.nextLine());
                // check if user want to exit
                if(sel==0)
                    System.out.println("Exiting....");
                // if input < Cineplex List size run next function
                else if((sel>0) && (sel<=this.No_Cineplex)) {
                    return sel-1;
                }
                else {
                    System.out.println("Invalid Input");
                }
            }
            catch(Exception e) {
                System.out.println("Invalid Input");
            }

        }while(sel!=0);
        // return -1 if user wants to exit
        return -1;
    }

    public void updateCineplex() {

        int choice;
        choice=selectCineplex();
        // run function if user dw to exit
        if(choice!=-1) {
            Cinemalist=Cinemaset.runCinemaSetting(Cineplexlist[choice].getCineplexName(), MovieListSize, MovieDBaddress, CinemaDBaddress, ShowtimeDbAddress);
            Cinemalistsize=Cinemaset.returnCinemaSize();
            Cineplexlist[choice].assignCinemalist(Cinemalist);
            Cineplexlist[choice].assigneCinematlistsize(Cinemalistsize);
            // get new updated movielist n size

        }

    }
    public void removeCineplex(){
        int choice;
        choice=selectCineplex();
        if(choice!=-1){
            Cinemaset.RemoveCinemafromCineplex(Cineplexlist[choice].getCineplexName());
            for(int x=choice; x<No_Cineplex; x++){
            // Shift data to the left
                Cineplexlist[x]=Cineplexlist[x+1];
            }
             No_Cineplex--;
            System.out.println("Removal Successful");
    }}
    public void printCinplexlist(){
        for(int x=1; x<=No_Cineplex; x++){
            System.out.println("#"+x+" "+ Cineplexlist[x-1].getCineplexName());
        }
    }

    public Cineplex[] returncineplexlist() {
        return this.Cineplexlist;
    }
    public int returnCineplexListSize() {
        return this.No_Cineplex;
    }
}
