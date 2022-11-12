package Entity;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import Controller.*;

public class Payment {
    private String CustName;
    private String CustEmail;
    private int CustAge;

    private double Seatprice;
    private double TotalPrice;
    private String Card;
    private String TransactionID="";

    Pricing GetPrice= new Pricing();
    PriceDBcontrol priceDB = new PriceDBcontrol();
    private OrderHist bookdetails;

    private OrderHistoryDB OrderDb= new OrderHistoryDB();

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dataformat = DateTimeFormatter.ofPattern("yyyyMMddhhmm");
    Scanner sc = new Scanner(System.in);

    public void runPayment(Showtime showtime, ArrayList<Integer> SelectedSeats, int CustAge) throws IOException {

        GetPrice=priceDB.GetPriceFromDB();

        insertInfo();

            this.Seatprice = GetPrice.priceCalc(CustAge, showtime);
            this.TotalPrice = Seatprice * SelectedSeats.size();
            System.out.println("Seats Selected: ");
            System.out.println("No. Seats Selected: "+ SelectedSeats.size());
            System.out.println("Price for each Seat: "+Seatprice);
            System.out.println("Total price for "+ TotalPrice);
            CardPayment(); // set card payment
            this.TransactionID += showtime.getCinemaCode()+dataformat.format(now); //Set transacitonID
            bookdetails= new OrderHist(showtime.getCineplexname(), showtime.getCinemaname(),showtime.getCinemaType() ,showtime.getMoviename(), showtime.getTime(), this.TotalPrice,
                    this.TransactionID, SelectedSeats, this.CustName, this.CustEmail);
            bookdetails.printOrderDetails();
            OrderDb.InsertBookingtoDB(bookdetails);

    }

    public void insertInfo(){
        System.out.println("Please indicate your name:");
        this.CustName= sc.nextLine();
        System.out.println("Please Indicate your e-mail");
        this.CustEmail = sc.nextLine();
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

}
