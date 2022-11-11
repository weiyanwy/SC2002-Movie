import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;


public class CineplexSetting{
    public ArrayList<Cineplex> Cineplexlist=new ArrayList<>();
    private ArrayList<Cinema> Cinemalist=new ArrayList<>();

    CineplexDBcontrol CineplexDB = new CineplexDBcontrol();

    private CinemaSettings Cinemaset=new CinemaSettings();
    Display UI = new Display();
    Scanner sc = new Scanner(System.in);

    public void runCineplexSetting() {

        this.Cineplexlist=CineplexDB.GetCineplexFromDB();
        int sel=1;
        do {
            try {
                UI.CineplexSettingDisplay();
                sel=Integer.parseInt(sc.nextLine());
                switch (sel) {
                    case (0):
                        //Exit
                        System.out.println("Exit");
                        break;
                    case (1):
                        System.out.println("******CREATE CINEPLEX******");
                        //Call Create Cineplex");
                        CineplexDB.insertCineplexToDB(createCineplex());
                        this.Cineplexlist=CineplexDB.GetCineplexFromDB();

                        break;
                    case (2):
                        //Call update cinema functio
                        System.out.println("*****UPDATE CINEPLEX******");
                        updateCineplex();
                        printCinema();
                        break;
                    case (3):
                        //Call remove cinema
                        System.out.println("*****REMOVE CINEPLEX*****");
                        removeCineplex();
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Invalid Input");
            }

        }while(sel!=0);
        CineplexDB.OverwriteFile(this.Cineplexlist);

    }
    public void printCinema(){
        for(int x=0; x<this.Cinemalist.size(); x++){
            System.out.println("Cinema" + (x+1) + " "+ this.Cinemalist.get(x).getname());
        }
    }

    public Cineplex createCineplex() throws IOException {
        String name;
        System.out.println("Enter Cineplex Name:");
        name=sc.nextLine();
        //Create new Cineplex class in list
        Cineplex Temp = new Cineplex(name);
        return Temp;
    }

    public int selectCineplex() {
        int sel=1;
        boolean exit=true;
        if(Cineplexlist.size()>0) {
            do {
                try {
                    printCinplexlist(this.Cineplexlist);
                    System.out.println("Select Cineplex");
                    System.out.println("Enter 0 to exit:");
                    sel = Integer.parseInt(sc.nextLine());
                    // check if user want to exit
                    if (sel == 0) {
                        exit = false;
                        System.out.println("Exiting....");
                    }
                    // if input < Cineplex List size run next function
                    else if ((sel > 0) && (sel <= this.Cineplexlist.size())) {

                        exit = false;
                    } else {
                        System.out.println("Invalid Input");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Input");
                }

            } while (exit);
        }
        else
            System.out.println("Cineplex List is Empty");
        // return -1 if user wants to exit
        return (sel-1);
    }

    public void updateCineplex() {

        int choice;
        choice=selectCineplex();
        // run function if user dw to exit
        if(choice>-1) {
            this.Cineplexlist.get(choice).assignCinemalist(this.Cinemaset.runCinemaSetting(Cineplexlist.get(choice).getCinemalist()));

            // get new updated movielist n size

        }

    }
    public void removeCineplex(){
        int choice;
        choice=selectCineplex();
        if(choice!=-1){
            Cineplexlist.remove(choice);
            System.out.println("Removal Successful");
        }
        else
            System.out.println("Removal Unsuccessful");
    }
    public void printCinplexlist(ArrayList<Cineplex> Cineplexlists){
        for(int x=0; x<Cineplexlists.size(); x++){
            System.out.println("#"+(x+1)+" "+ Cineplexlists.get(x).getCineplexName());
        }
    }
}
