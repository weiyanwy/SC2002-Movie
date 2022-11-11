/*import java.util.ArrayList;
import java.util.Scanner;

public class OrderHist(){
  
  /////////////////////////////////
  // PART 1: Initialise variables
  public String cinemaName;
  public String movieName;
  public String time=" ";
  public double totalPrice;
  public ArrayList<Integer> selectedSeats;
  public String Username;
  public String email;
  
  Scanner sc = new Scanner(System.in);
  ////////////////////////////////
  // PART 2: Constructors 
  public OrderHist(Showtime showtime, double totalPrice, ArrayList<Integer> Seats){
    this.cinemaName = showtime.getCinemaname();
    this.movieName = showtime.getMoviename();
    this.totalPrice = totalPrice;
    this.selectedSeats = Seats;
    this.time =  "-"+ (String)showtime.getmonth()
                + "-" +(String)showtime.getDate() + "-" + (String)showtime.getHour()
                + "-" +(String)showtime.getMinute();
  }
  
  ///////////////////////////////
  // PART 3: Functions
  public void insertInfo(){
    System.out.println("Please indicate your name:");
    this.Username = sc.nextLine();
    System.out.println("Please Indicate your e-mail");
    this.email = sc.nextLine();
  }
  
  public String returnTID(){
    String totalString;
    totalString = this.cinemaName.charAt(0) + this.cinemaName.charAt(1) +this.cinemaName.charAt(2) +
                  + this.time;
    return totalString;
  }
}*/
