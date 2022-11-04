import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Booking {
	private String MovieName;
	private String Cinemaname;
	private Showtime Show_time;
	private int[] totalseats;
	//Price class
	//private User userdetails;

	//public void createBooking(//User userdetails, Movie movie, Cineplex CinemaName, Showtime Show_Time, int[] Seats){
	public void runBooking(String moviename, String Cinemaname,Showtime Showtime, int[] Seat_Selected){
		this.MovieName=moviename;
		this.Cinemaname=Cinemaname;
		this.Show_time=Showtime;
		this.totalseats=Seat_Selected;
	}



}
