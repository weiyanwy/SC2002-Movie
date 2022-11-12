package Entity;
import java.io.Serializable;
import java.util.*;
import java.text.SimpleDateFormat;
import Controller.*;
import Settings.*;

public class Showtime implements Serializable,Cloneable{
	//####################################################
	//
	// PART 1: INITIATE VARIABLES
	private Calendar time = Calendar.getInstance();
	private SeatLayout layout;
	private Movie movie=new Movie();
	private Cinema cinema= new Cinema();
	private Cineplex cineplex= new Cineplex();
	private boolean is3D;                        //check whether this slot shows 3D mode
	private boolean isPH;
	private final SimpleDateFormat dataform = new SimpleDateFormat("EEE, d MMM yyyy 'at' HH:mm");

	
	//-----------------------------------------
	//#####################################################
	// PART 2: CONSTRUCTOR OF THE OBJECT

	//////////// SETTERS
	public Showtime(int year, int Month, int Date, int Hour, int Minute, boolean is3d, boolean isPh, SeatLayout Layout, Cineplex cinplx, Cinema cinema, Movie movie) {
		this.time.set(Calendar.YEAR, year);
		this.time.set(Calendar.MONTH, Month);
		this.time.set(Calendar.DATE, Date);
		this.time.set(Calendar.HOUR, Hour);
		this.time.set(Calendar.MINUTE, Minute);
		this.is3D=is3d;
		this.layout=Layout;
		this.cinema=cinema;
		this.movie=movie;
		this.cineplex=cinplx;
		this.isPH=isPh;
	}

	public void setUpdateTime(int year, int Month, int Date, int Hour, int Minute){
		this.time.set(Calendar.YEAR,year);
		this.time.set(Calendar.MONTH,Month);
		this.time.set(Calendar.DATE, Date);
		this.time.set(Calendar.HOUR,Hour);
		this.time.set(Calendar.MINUTE,Minute);

	}

	public void Setis3d(boolean is3d) {
		this.is3D = is3d;
	}

	public void setLayout(SeatLayout layout) {
		this.layout = layout;
	}

	//////////////////////////////////////
	// GETTERS
	public int getYear(){
		return this.time.get(Calendar.YEAR);
	}
	public int getmonth() {
		return this.time.get(Calendar.MONTH);
		//function returns time
	}                                            //

	public int getDate() {                        //
		return this.time.get(Calendar.DATE);          //
	}                                            //

	public int getHour() {                        //
		return this.time.get(Calendar.HOUR);
	}                                            //

	public int getMinute() {                    //
		return this.time.get(Calendar.MINUTE);        //
	}
	public boolean getisPH(){
		return this.isPH;
	}

	public boolean get3D() {                        //this function returns whether this slot is 3D
		return this.is3D;                        //
	}                                            //
	public String getType(){
		if(this.get3D())
			return "3D";
		else
			return "STANDARD";
	}
	public int getDayofWeek(){
		// return day of week 1-7 mon-sun
		return this.time.get(Calendar.DAY_OF_WEEK);
	}

	public String getTime() {                    //
		return dataform.format(time.getTime());    //
	}                                            //

	public SeatLayout getSeatlayout() {
		return layout;
	}
	public String getCineplexname(){
		return this.cineplex.getCineplexName();
	}
	public String getMoviename()
	{
		return this.movie.getTitle();
	}
	public String getCinemaname(){
		return this.cinema.getname();
	}
	public String getCinemaCode(){
		return this.cinema.getCode();
	}
	public CinemaType getCinemaType(){
		return this.cinema.getCinematype();
	}
	public boolean getMovieisBlock(){
		return this.movie.isBlock;
	}

	public MovieStatus getMoviestatus(){
		return this.movie.getstatus();
	}
	public MovieRestriction getMovieRestrict(){
		return this.movie.getMovieRest();
	}
}

	

