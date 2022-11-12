package Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import Controller.*;
import Settings.*;
public class OrderHist implements Serializable {
  
  /////////////////////////////////
  // PART 1: Initialise variables
  private String CineplexName;
  private CinemaType CinemaType;
  private String cinemaName;
  private String movieName;
  private String time="";
  private double totalPrice;
  private String TransactionID;
  private ArrayList<Integer> selectedSeats;
  private String Username;
  private String email;

  public OrderHist(String cineplexname, String cinemaname, CinemaType CinemaType, String moviename, String time, double totalprice, String transactionid, ArrayList<Integer>selectedSeats,
                   String custname, String custemail){
    this.CineplexName=cineplexname;
    this.cinemaName=cinemaname;
    this.movieName=moviename;
    this.time=time;
    this.totalPrice=totalprice;
    this.TransactionID=transactionid;
    this.selectedSeats=selectedSeats;
    this.Username=custname;
    this.email=custemail;
    this.CinemaType=CinemaType;
  }

  public void printOrderDetails(){
    System.out.println("Transaction ID: "+this.TransactionID);
    System.out.println("Cineplex: "+this.CineplexName+ ", Cinema: "+this.cinemaName + ", Cinema Type: "+this.CinemaType);
    System.out.println("Show time: "+this.time);
    System.out.println("Seats: "+ printSeatselected());
  }
  public String printSeatselected(){
    StringBuilder s = new StringBuilder();
    for (Integer selectedSeat : selectedSeats) {
      s.append(selectedSeat).append(", ");
    }
    return s.toString();
  }
}
