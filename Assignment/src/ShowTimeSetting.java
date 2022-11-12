
import java.text.SimpleDateFormat;
import java.util.*;

public class ShowTimeSetting {

    public Calendar time = Calendar.getInstance();
    private int year;						//year of showing
    private int month;						//month of slot
    private int date;						//day of slot
    private  int hour;						//hour of slot
    private  int minute;						//minute of slot
    private  boolean is3D = false;						//check whether this slot shows 3D mode
    private boolean isPH=false;

    private SeatLayout layout;
    private SeatLayOutSetting Showtimelayout=new SeatLayOutSetting();



    public	int sel = 0;
    private ArrayList<Showtime> Showtimelist=new ArrayList<>();

    Scanner sc = new Scanner(System.in);
    public ArrayList<Showtime> runShowtimesetup(Cineplex cinplx, Cinema cinema,Movie addmovie, ArrayList<Showtime> Showtimelists) {
        if(Showtimelists.size()>0)
            this.Showtimelist=Showtimelists;
        boolean exit = true;
        do{
            try{
                System.out.println("-----Show time Setting-----");
                System.out.println("1:Create Show time and seat layout");
                System.out.println("2:Update Show time");
                System.out.println("3:Delete Show time");
                System.out.println("4:View Show time");
                System.out.println("0:Exit");
                sel=Integer.parseInt(sc.nextLine());
                switch(sel){
                    case 1:
                        Settime();
                        set3D();
                        setPH();
                        Showtimelist.add(new Showtime(this.year, this.month,this.date,this.hour,this.minute,this.is3D,this.isPH,Showtimelayout.SetSeatLayout(),cinplx, cinema, addmovie));
                        printshowtime();
                        //Collections.sort(Showtimelist, Collections.min());
                        break;

                    case 2:
                        ArrayList<Integer> storeindexpos = findshowtime(addmovie.getTitle(),this.Showtimelist);
                        if(storeindexpos.size()==0){
                            System.out.println("Cinema: "+cinema.getname() + " Movie: "+addmovie.getTitle());
                            System.out.println("No Show time");
                        }
                        else{
                            int position=SelectShowtime(storeindexpos, this.Showtimelist);
                            updatetime(position);
                        }
                        break;
                    case 3:
                        storeindexpos =findshowtime(addmovie.getTitle(),this.Showtimelist);
                        if(storeindexpos.size()==0){
                            System.out.println("Cinema "+cinema.getname() + " Movie: "+addmovie.getTitle());
                            System.out.println("No Show time");
                        }
                        else{
                            int position=SelectShowtime(storeindexpos,this.Showtimelist);
                            Showtimelist.remove(position);
                        }
                        break;
                    case 4:
                        printshowtime();
                        break;
                    case 0:
                        System.out.println("Exiting Show time Setting....");
                        exit=false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            } catch (Exception e) {
                System.out.println("Invalid Input");
            }
        }while(exit);
        return Showtimelist;
    }

    public void printshowtime(){
        for(int x=0;x<this.Showtimelist.size();x++){
            System.out.println("Cineplex: "+this.Showtimelist.get(x).getCineplexname() +   " , Cinema: "+ this.Showtimelist.get(x).getCinemaname() + " , Movie: "+this.Showtimelist.get(x).getMoviename());
            System.out.println((x+1) + " "+ this.Showtimelist.get(x).getTime() + " Type: "+ this.Showtimelist.get(x).getType());
        }
    }

    // find showtime w the same cinema name movie tile and store index of its position.
    public ArrayList<Integer> findshowtime(String Movietitle, ArrayList<Showtime> Showtimelist){
        ArrayList<Integer> storeindex = new ArrayList<>();
        for(int x=0; x<Showtimelist.size();x++){
            if(Showtimelist.get(x).getMoviename().equalsIgnoreCase(Movietitle)){// && Showtimelist.get(x).getCinemaname().equalsIgnoreCase(CinemaName)){
                // store index of showtime w same Movie name
                storeindex.add(x);
            }
        }
        return storeindex;
    }
    public int SelectShowtime(ArrayList<Integer> indexlist, ArrayList<Showtime>Showtimelist){
        int select=0;
        for(int x=0; x<indexlist.size();x++){
            System.out.println("#"+(x+1) +" Movie: "+Showtimelist.get(x).getMoviename()+ " Time:" + Showtimelist.get(indexlist.get(x)).getTime());
        }
        while(true){
            System.out.println("Enter Index of Show time:");
            select=Integer.parseInt(sc.nextLine());
            if(select>0 && select<=indexlist.size()){
                break;
            }
            else{
                System.out.println("Invalid Input");
            }
        }

        return select-1;
    }
    //Set up time for show time
    public void Settime(){
        boolean check=true;
        do {
            try {
                System.out.println("Enter Year:");
                this.year=Integer.parseInt(sc.nextLine());
                System.out.println("Enter Month numerical(1-12, jan-dec):");
                // jan starts from 0
                this.month = Integer.parseInt(sc.nextLine())-1;
                System.out.println("Enter Date (1-31)");
                this.date = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Hour of day (24hr format)");
                this.hour = Integer.parseInt(sc.nextLine());
                System.out.println("Enter mintue of day");
                this.minute=Integer.parseInt(sc.nextLine());;
                check=false;
            }
            catch(Exception a) {
                System.out.println("Invalid input");
            }
        }while(check);
    }


    public void updatetime(int index) {
        boolean check=true;
        int tempyear;
        int tempmonth;
        int tempdate;
        int temphour;
        int tempminute;
        while (check)
            try {
                System.out.println("Enter year");
                tempyear = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Month numerical(1-12, jan-dec):");
                // jan starts from 0
                tempmonth = Integer.parseInt(sc.nextLine()) - 1;
                System.out.println("Enter Date (1-31)");
                tempdate = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Hour of day (24hr format)");
                temphour = Integer.parseInt(sc.nextLine());
                System.out.println("Enter mintue of day");
                tempminute = Integer.parseInt(sc.nextLine());
                Showtimelist.get(index).setUpdateTime(tempyear,tempmonth, tempdate, temphour, tempminute);
                check = false;
                break;
            } catch (Exception a) {
                System.out.println("Invalid input");
            }
    }

    // Set seating layout

    //////////////////////////////////////////////////////////////////
    //This function set whether the timeslot has 3D mode
    public void set3D(){
        boolean check=true;
        System.out.println("Enter whether this slot is shown in 3D\n");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        do {
            try {
                System.out.println("Enter Choice:");
                sel=Integer.parseInt(sc.nextLine());
                switch (sel) {
                    case (1):
                        this.is3D = true;
                        check = false;
                        break;

                    case (2):
                        this.is3D = false;
                        check = false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }
            catch(Exception e) {
                System.out.println("Invalid Input");
            }
        }while(check);
    }
    public void setPH(){
        boolean check=true;
        System.out.println("Enter whether this Show time is on a Public Holiday\n");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        do {
            try {
                System.out.println("Enter Choice:");
                sel=Integer.parseInt(sc.nextLine());
                switch (sel) {
                    case (1):
                        this.isPH = true;
                        check = false;
                        break;

                    case (2):
                        this.isPH = false;
                        check = false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
            }
            catch(Exception e) {
                System.out.println("Invalid Input");
            }
        }while(check);
    }

   /* public void sortShowtime(ArrayList<Showtime> showtimelist){
        Showtime temp;
        for(int i=0; i<showtimelist.size();i++){
            for(int j=i+1; j>0; j--){
                if()
            }
        }
    }*/


}
