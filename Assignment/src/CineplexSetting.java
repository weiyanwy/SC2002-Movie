import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;


public class CineplexSetting{
    private ArrayList<Cineplex> Cineplexlist;
    private ArrayList<Cinema> Cinemalist;

    CineplexDBcontrol CineplexDB = new CineplexDBcontrol();

    private CinemaSettings Cinemaset;
    Display UI = new Display();
    Scanner sc = new Scanner(System.in);

    public void runCineplexSetting() {
        this.Cineplexlist=CineplexDB.GetCineplexFromDB();
        int sel=1;
        do {
            UI.CineplexSettingDisplay();
            sel=Integer.parseInt(sc.nextLine());
            try {
                switch (sel) {
                    case (0):
                        //Exit
                        System.out.println("Exit");
                        break;
                    case (1):
                        System.out.println("******CREATE CINEPLEX******");
                        //Call Create Cineplex");
                        Cineplex Temp=createCineplex();
                        CineplexDB.insertCineplexToDB(Temp);
                        this.Cineplexlist=CineplexDB.GetCineplexFromDB();
                        printCinplexlist(this.Cineplexlist);
                        break;
                    case (2):
                        //Call update cinema functio
                        System.out.println("*****UPDATE CINEPLEX******");
                        updateCineplex();
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

    public Cineplex createCineplex() throws IOException {
        String name;
        System.out.println("Enter Cinema Name:");
        name=sc.nextLine();
        //Create new Cineplex class in list
        Cineplex Temp = new Cineplex(name);
        return Temp;
    }

    public int selectCineplex() {
        int sel = 1;
        do {
            try {
                printCinplexlist(this.Cineplexlist);
                System.out.println("Select Cinema");
                System.out.println("Enter 0 to exit:");
                sel=Integer.parseInt(sc.nextLine());
                // check if user want to exit
                if(sel==0)
                    System.out.println("Exiting....");
                // if input < Cineplex List size run next function
                else if((sel>0) && (sel<=Cineplexlist.size())) {
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
            Cinemalist=Cinemaset.runCinemaSetting(Cineplexlist.get(choice).getCinemalist());
            Cineplexlist.get(choice).assignCinemalist(Cinemalist);

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
