import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Booking{

    CineplexSetting CineplexControl= new CineplexSetting();


    CinemaSettings CinemaControl = new CinemaSettings();
    ShowTimeSetting ShowtimeControl = new ShowTimeSetting();
    MovieSettings MovieControl = new MovieSettings();
    SeatLayOutSetting SeatControl = new SeatLayOutSetting();
    CineplexDBcontrol CinplexDB = new CineplexDBcontrol();
    MovieDBcontrol MovieDB = new MovieDBcontrol();


    Payment paymentControl = new Payment();
    OrderHistoryDB orderDb= new OrderHistoryDB();
    private ArrayList<Movie> MovieList = new ArrayList<>();
    private int CustAge;
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
                exit=false;
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
                    // find list of movie title showtime
                    System.out.println("Movie " + MovieList.get(MovieIndex).getTitle() + " Selected");
                    ArrayList<Integer>StoreIndex=ShowtimeControl.findshowtime(MovieList.get(MovieIndex).getTitle(), Cinemalist.get(sel).getShowtimelist());
                    if (StoreIndex.size()>0)
                    //return new Showtime array to cinema
                        Cinemalist.get(sel).assignShowtime(printnSelectShowtime(StoreIndex, Cinemalist.get(sel).getShowtimelist()));
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

    public ArrayList<Showtime> printnSelectShowtime(ArrayList<Integer> StoreIndex, ArrayList<Showtime> showtimelist) throws IOException {

        int select;
        select=ShowtimeControl.SelectShowtime(StoreIndex, showtimelist);

        //replace new showtime at index
        showtimelist.set(select,(selectseat(showtimelist.get(select))));
        return showtimelist;
    }
    public boolean CheckIfLegal(Showtime showtime) {
        System.out.println("Enter your Age: ");
        this.CustAge=Integer.parseInt(input.nextLine());
        if(showtime.getMovieRestrict().equals(MovieRestriction.R21) && CustAge<21)
            return false;
        if(showtime.getMovieRestrict().equals(MovieRestriction.M18) && CustAge<18)
            return false;
        if(showtime.getMovieRestrict().equals(MovieRestriction.NC16)&& CustAge<16)
            return false;

        return true;
    }

    public Showtime selectseat(Showtime showtime) throws IOException {

        SeatLayout layout;
        layout=showtime.getSeatlayout();

        ArrayList<Integer> StoreSeatIndex = new ArrayList<>();
        boolean check=true;
        // Pricing ticketCalc = new Pricing(showtime, StoreSeatIndex);
        if(CheckIfLegal(showtime)) {
            int index;
            do {


                try {
                    SeatControl.printlayout(layout.getRow(), layout.getCol(), layout);

                    System.out.println("[1]: Select Index of Seat");
                    System.out.println("[2]: UnSelect Index of Seat");
                    System.out.println("[3]: Proceed to Payment");
                    System.out.println("[4]: Exit;");
                    int choice = Integer.parseInt(input.nextLine());
                    switch (choice) {

                        case (1):
                            System.out.println("Enter Seat Index: ");
                            index = Integer.parseInt(input.nextLine());
                            //check if seat is occupied
                            if (layout.getSeats()[index / 10][index % 10].isOccupied())
                                System.out.println("Seat is Occupied.");
                                //check if there is space between seats
                            else {
                                if (checkifsidebyside(StoreSeatIndex, index)) {
                                    //Convert index of seat to occupied
                                    layout.getSeats()[index / 10][index % 10].SelectSeat();
                                    SeatControl.printlayout(layout.getRow(), layout.getCol(), layout);
                                    //Store seat index in array
                                    StoreSeatIndex.add(index);
                                    printseatselected(StoreSeatIndex);
                                }
                            }
                            break;
                        case (2):
                            // UNselect Seat
                            System.out.println("Enter Seat Index to Unselect: ");
                            index = Integer.parseInt(input.nextLine());
                            if (CheckisinArray(StoreSeatIndex, index)) {
                                StoreSeatIndex = updateArray(StoreSeatIndex, index);
                                // check seat status back to Available
                                layout.getSeats()[index / 10][index % 10].UnSelectSeat();
                                printseatselected(StoreSeatIndex);
                            } else
                                System.out.println("Invalid Input");
                            break;
                        case (3):

                            //check if payment is successfull
                            paymentControl.runPayment(showtime, StoreSeatIndex, this.CustAge);
                                //update new seatstatus to layout
                            layout.updateSeatsStatus(layout.getSeats());
                                //insert new layout to showtime
                            showtime.setLayout(layout);
                                //return new showtime w new layout
                            return showtime;
                        case (4):
                            check = false;
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid Input");
                }
            } while (check);
            return showtime;
        }
        System.out.println("You Have Not Met The Legal Age To Watch This Movie.");
        System.out.println("Movie: "+ showtime.getMoviename()+", Restriction: "+showtime.getMovieRestrict());
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
    // check if selected seats exist in Selected array
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
