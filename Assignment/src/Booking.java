import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Booking{

    CineplexSetting CineplexControl= new CineplexSetting();


    CinemaSettings CinemaControl = new CinemaSettings();
    ShowTimeSetting ShowtimeControl = new ShowTimeSetting();
    MovieSettings MovieControl = new MovieSettings();
    SeatLayOutSetting SeatControl = new SeatLayOutSetting();
    MovieMode MovieModeControl = new MovieMode();

    CineplexDBcontrol CinplexDB = new CineplexDBcontrol();
    MovieDBcontrol MovieDB = new MovieDBcontrol();


    Payment paymentControl = new Payment();
    OrderHistoryDB orderDb= new OrderHistoryDB();
    private ArrayList<Movie> MovieList = new ArrayList<>();

    Scanner input = new Scanner(System.in);
    public void runBooking() throws IOException {
        boolean exit=true;
        ArrayList<Cineplex> cineplexList = CinplexDB.GetCineplexFromDB();

        while(exit) {
            int sel = CineplexControl.selectCineplex(cineplexList);
            if (sel > -1) {
                System.out.println("Cineplex Chosen: " + cineplexList.get(sel).getCineplexName());
                cineplexList.get(sel).assignCinemalist(printnSelectCinema(cineplexList.get(sel).getCinemalist()));
                //update database w new cineplexlist
                this.CinplexDB.OverwriteFile(cineplexList);
            }
            else
                exit=false;
        }

    }
    public ArrayList<Cinema> printnSelectCinema(ArrayList<Cinema> Cinemalist) throws IOException {

        int sel, MovieIndex = -1;
        boolean exit = true;
        while (exit) {
            sel = CinemaControl.selectCinema(Cinemalist);
            if (sel > -1) {
                System.out.println("Cinema " + Cinemalist.get(sel).getname() + " Selected");
                MovieIndex = printnSelectMovie();
                if (MovieIndex > -1) {
                    System.out.println("Movie " + MovieList.get(MovieIndex).getTitle() + " Selected");
                    if (Cinemalist.get(sel).getShowtimelist().size()>0)
                    //return new Showtime array to cinema
                        Cinemalist.get(sel).assignShowtime(printnSelectShowtime(MovieList.get(MovieIndex), Cinemalist.get(sel).getShowtimelist()));
                    else
                        System.out.println("No Show time");
                }
            }
            exit = false;
        }
        return Cinemalist;
    }
    public int printnSelectMovie(){
        this.MovieList=MovieDB.GetMovieFromDB();
        boolean exit=true;
        int sel;
        while(exit){
            MovieControl.printmovietitle(this.MovieList);
            System.out.println("Select Movie to view Show time");
            System.out.println("Enter 0 to exit");
            sel=Integer.parseInt(input.nextLine());
            try{
                if(sel==0){
                    System.out.println("Exiting...");
                    exit=false;
                }
                else if(sel>0 && sel<=this.MovieList.size())
                    if(MovieList.get(sel-1).getstatus().equals(MovieStatus.Coming_Soon) || MovieList.get(sel-1).getstatus().equals(MovieStatus.End_Of_Showing))
                        System.out.println("Movie not available for booking. Please select movies 'Now Showing' or 'Preview' to book");
                    else
                        return (sel-1);
                else
                    System.out.println("Invalid Input");
            }
            catch(Exception e){
                System.out.println("Invalid Input");
            }
        }
        return -1;
    }

    public ArrayList<Showtime> printnSelectShowtime(Movie movie, ArrayList<Showtime> showtimelist) throws IOException {
        ArrayList<Integer>StoreIndex=new ArrayList<>();
        int select;
        StoreIndex=ShowtimeControl.findshowtime(movie.getTitle(), showtimelist);
        System.out.println("ok");
        select=ShowtimeControl.SelectShowtime(StoreIndex, showtimelist);
        System.out.println("no " + select);
        //replace new showtime at index
        showtimelist.set(select,(selectseat(showtimelist.get(select))));
        return showtimelist;
    }

    public Showtime selectseat(Showtime showtime) throws IOException {

        SeatLayout layout;
        layout=showtime.getSeatlayout();

        ArrayList<Integer> StoreSeatIndex = new ArrayList<>();
        boolean check=true;
        // Pricing ticketCalc = new Pricing(showtime, StoreSeatIndex);

        int index;
        do {


           // try{
                SeatControl.printlayout(layout.getRow(), layout.getCol(), layout);

                System.out.println("[1]: Select Index of Seat");
                System.out.println("[2]: UnSelect Index of Seat");
                System.out.println("[3]: Proceed to Payment");
                System.out.println("[4]: Exit;");
                int choice = Integer.parseInt(input.nextLine());
                switch(choice) {
                    case(1):
                        System.out.println("Enter Seat Index: ");
                        index=Integer.parseInt(input.nextLine());
                        //check if there is space between seats
                        if(checkifsidebyside(StoreSeatIndex, index)){
                        //Convert index of seat to occupied
                        layout.getSeats()[index / 10][index% 10].SelectSeat();
                        SeatControl.printlayout(layout.getRow(), layout.getCol(), layout);
                        //Store seat index in array
                        StoreSeatIndex.add(index);
                        printseatselected(StoreSeatIndex);
                        }
                        break;
                    case(2):
                        System.out.println("Enter Seat Index to Unselect: ");
                        index=Integer.parseInt(input.nextLine());
                        if(CheckisinArray(StoreSeatIndex, index)){
                            StoreSeatIndex=updateArray(StoreSeatIndex, index);
                            layout.getSeats()[index / 10][index% 10].UnSelectSeat();
                            printseatselected(StoreSeatIndex);
                        }
                        else
                            System.out.println("Invalid Input");
                        break;
                    case(3):

                        //check if payment is successfull
                        if(paymentControl.runPayment(showtime, StoreSeatIndex)){
                            //update new seatstatus to layout
                            layout.updateSeatsStatus(layout.getSeats());
                            //insert new layout to showtime
                            showtime.setLayout(layout);
                            //return new showtime w new layout
                            return showtime;
                        }

                        break;
                    case(4):
                        check=false;
                        break;
                    default:
                        System.out.println("Invalid Input");
                }
          // }
           /* catch(Exception e) {
                System.out.println("Invalid bbbbInput");
            }*/
        }while(check);
        return showtime;
    }
    public boolean checkifsidebyside(ArrayList<Integer> SelectedSeats, int newSeatIndex){
        for (Integer selectedSeat : SelectedSeats) {
            // check if same row
            if ((selectedSeat / 10) == (newSeatIndex / 10)) {
                //check if there is a gap between the selected seat, use col to check
                if (((selectedSeat % 10) - (newSeatIndex % 10) > 1) || ((selectedSeat % 10) - (newSeatIndex % 10) < -1)) {
                    System.out.println("Seat Selection Invalid");
                    System.out.println("Please do not leave spaces between the seats");
                    return false;
                }
            }
        }
        return true;
    }

    //Print out all the seats user has selected
    public void printseatselected(ArrayList<Integer> list){
        String S="";
        for (Integer integer : list) {
            S = S + integer + " ";
        }
        System.out.println("Seats Selected: "+S);
    }
    public boolean CheckisinArray(ArrayList<Integer> list, int input){
        for(int x : list){
            if(x==input){
                return true;
            }
        }
        return false;
    }
    //Remove Index from SelectedSeats
    public ArrayList<Integer> updateArray(ArrayList<Integer> list, int input){
        for(int x=0;x<list.size();x++) {
            if (list.get(x) == input) {
                list.remove(x);
                break;
            }
        }
        return list;
    }
    public void viewOrderHistory(){
        ArrayList<OrderHist> orderList = orderDb.GetOrderHistFromDB();
        if(orderList.size()>0){
            for(int x = 0; x< orderList.size(); x++){
                System.out.println("Order #"+(x+1));
                orderList.get(x).printOrderDetails();
            }
        }
    }
}
