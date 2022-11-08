import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
public class ShowTimeSetting {

    public Calendar time = Calendar.getInstance();
    public int year;						//year of showing
    public int month;						//month of slot
    public int date;						//day of slot
    public int hour;						//hour of slot
    public int minute;						//minute of slot
    public boolean is3D = false;						//check whether this slot shows 3D mode

    SeatLayout layout;
    SeatLayOutSetting SeatSetting;

    DBaddress address;
    private final ShowtimeDB showtimeDbcontrol=new ShowtimeDB(address.getShowtimeDBAddress());

    boolean check=true;
    public	int sel = 0;
    private ArrayList<Showtime> Showtimelist;

    Scanner sc = new Scanner(System.in);
    SimpleDateFormat dataform = new SimpleDateFormat("MM/dd HH:mm");
    public void runShowtimesetup(Cinema cinema,Movie movieclass, int movielistsize) throws IOException, ClassNotFoundException {
        Showtimelist=showtimeDbcontrol.GetShowtimeFromDB();
        int sel;
        boolean exit = true;
        do{
            try{
                System.out.println("-----Show time Setting-----");
                System.out.println("1:Create Show time and seat layout");
                System.out.println("2:Update Show time");
                System.out.println("2:Delete Show time");
                System.out.println("3:Exit");
                sel=Integer.parseInt(sc.nextLine());
                switch(sel){
                    case 1:
                        Settime();
                        set3D();
                        layout=SeatSetting.SetSeatLayout();
                        Showtime temp = new Showtime(this.month, this.date, this.hour, this.minute, this.is3D, layout, cinema, movieclass);
                        Showtimelist.add(temp);
                        showtimeDbcontrol.InsertShowtimetoDB(Showtimelist);
                    case 2:
                        ArrayList<Integer> storeindexpos = findshowtime(cinema.getname(), movieclass.getTitle());
                        if(storeindexpos.size()==0){
                            System.out.println("Cinema "+cinema.getname() + " Movie: "+movieclass.getTitle());
                            System.out.println("No Show time");
                        }
                        else{
                            int position=SelectShowtime(storeindexpos);
                            updatetime(position);
                        }
                    case 3:
                        storeindexpos =findshowtime(cinema.getname(), movieclass.getTitle());
                        if(storeindexpos.size()==0){
                            System.out.println("Cinema "+cinema.getname() + " Movie: "+movieclass.getTitle());
                            System.out.println("No Show time");
                        }
                        else{
                            int position=SelectShowtime(storeindexpos);
                            Showtimelist.remove(position);
                        }
                    case 4:
                        System.out.println("Exiting Show time Setting....");
                        exit=false;
                        break;
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }while(exit);
        showtimeDbcontrol.InsertShowtimetoDB(Showtimelist);

    }



    // find showtime w the same cinema name movie tile and store index of its position.
    public ArrayList<Integer> findshowtime(String CinemaName, String Movietitle){
        ArrayList<Integer> storeindex = new ArrayList<>();
        for(int x=0; x<Showtimelist.size();x++){
            if(Showtimelist.get(x).getMoviename().equalsIgnoreCase(Movietitle) && Showtimelist.get(x).getCinemaname().equalsIgnoreCase(CinemaName)){
                System.out.println(Showtimelist.get(x).getTime());
                // store index of showtime w same vmore name
                storeindex.add(x);
            }
        }
        return storeindex;
    }
    public int SelectShowtime(ArrayList<Integer> indexlist){
        int select=0;
        for(int x=0; x<indexlist.size();x++){
            System.out.println("#"+(x+1) + Showtimelist.get(indexlist.get(x)).getTime());
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
                break;
            }
            catch(Exception a) {
                System.out.println("Invalid input");
            }
        }while(check);
    }


    public void updatetime(int index) {

        int tempmonth;
        int tempdate;
        int temphour;
        int tempminute;
        while (true)
            try {
                System.out.println("Enter Month numerical(1-12, jan-dec):");
                // jan starts from 0
                tempmonth = Integer.parseInt(sc.nextLine()) - 1;
                System.out.println("Enter Date (1-31)");
                tempdate = Integer.parseInt(sc.nextLine());
                System.out.println("Enter Hour of day (24hr format)");
                temphour = Integer.parseInt(sc.nextLine());
                System.out.println("Enter mintue of day");
                tempminute = Integer.parseInt(sc.nextLine());
                Showtimelist.get(index).setUpdateTime(tempmonth, tempdate, temphour, tempminute);
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

        System.out.println("Enter whether this slot is shown in 3D\n");
        System.out.println("[1] Yes");
        System.out.println("[2] No");
        do {
            try {
                System.out.println("Enter Choice:");
                sel=Integer.parseInt(sc.nextLine());
                switch (sel) {
                    case (1) -> {
                        this.is3D = true;
                        check = false;
                    }
                    case (2) -> {
                        this.is3D = false;
                        check = false;
                    }
                    default -> System.out.println("Invalid Input");
                }
            }
            catch(Exception e) {
                System.out.println("Invalid Input");
            }
        }while(check);
    }


}
