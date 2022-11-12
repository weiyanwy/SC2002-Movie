import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.Scanner;
public class Payment {
    private String CustName;
    private String CustEmail;
    private int CustAge;

    private double Seatprice;
    private double TotalPrice;
    private String Card;
    private String TransactionID="";

    private Pricing GetPrice= new Pricing();

    private OrderHist bookdetails;

    private OrderHistoryDB OrderDb= new OrderHistoryDB();

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dataformat = DateTimeFormatter.ofPattern("yyyyMMddhhmm");
    Scanner sc = new Scanner(System.in);

    public boolean runPayment(Showtime showtime, ArrayList<Integer> SelectedSeats) throws IOException {

        insertInfo();
        if(CheckIfLegal(showtime)) {
            this.Seatprice = GetPrice.priceCalc(CustAge, showtime);
            this.TotalPrice = Seatprice * SelectedSeats.size();
            System.out.println("Seats Selected: ");
            System.out.println("No. Seats Selected: "+ SelectedSeats.size());
            System.out.println("Price for each Seat: "+Seatprice);
            System.out.println("Total price for "+ TotalPrice);
            CardPayment(); // set card payment
            this.TransactionID += showtime.getCinemaCode()+dataformat.format(now); //Set transacitonID
            bookdetails= new OrderHist(showtime.getCineplexname(), showtime.getCinemaname() ,showtime.getMoviename(), showtime.getTime(), this.TotalPrice,
                    this.TransactionID, SelectedSeats, this.CustName, this.CustEmail);
            bookdetails.printOrderDetails();
            OrderDb.InsertBookingtoDB(bookdetails);
        }
        else {
            System.out.println("You Have Not Met The Legal Age To Watch This Movie.");
            System.out.println("Movie: "+ showtime.getMoviename()+", Restriction: "+showtime.getMovieRestrict());
            return false;
        }


        return true;
    }

    public void insertInfo(){
        System.out.println("Please indicate your name:");
        this.CustName= sc.nextLine();
        System.out.println("Please Indicate your e-mail");
        this.CustEmail = sc.nextLine();
        System.out.println("Enter your age:");
        this.CustAge=Integer.parseInt(sc.nextLine());
    }

    public boolean CheckIfLegal(Showtime showtime) {
        if(showtime.getMovieRestrict().equals(MovieRestriction.R21) && CustAge<21)
            return false;
        if(showtime.getMovieRestrict().equals(MovieRestriction.M18) && CustAge<18)
            return false;
        if(showtime.getMovieRestrict().equals(MovieRestriction.NC16)&& CustAge<16)
            return false;

        return true;
    }

    public void CardPayment(){
        boolean exit=true;
        int sel;
        do{
            System.out.println("Select Card Payment");
            System.out.println("1: Visa");
            System.out.println("2: MasterCard");
            System.out.println("Enter Choice");
            sel=Integer.parseInt(sc.nextLine());
            if(sel==1) {
                this.Card = "Visa";
                exit=false;
            }
            else if(sel==2) {
                this.Card = "MasterCard";
                exit = false;
            }
            else
                System.out.println("Invalid Value");
        }while(exit);
        System.out.println("Payment Successful");
    }
    public void UploadtoOrderHistDB(){

    }
}
