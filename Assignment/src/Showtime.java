
import java.util.*;
import java.text.SimpleDateFormat;

public class Showtime {
	//####################################################
	//
	// PART 1: INITIATE VARIABLES
	public Calendar time = Calendar.getInstance();
	public int year;						//year of showing
	public int month;						//month of slot
	public int date;						//day of slot
	public int hour;						//hour of slot
	public int minute;						//minute of slot
	private SeatsLayOut arrangement;
	private SeatsLayOut layout=new SeatsLayOut();
	private String CinemaName;
	private String MovieName;
	public boolean is3D;						//check whether this slot shows 3D mode
	
	boolean check=true;
	public	int sel = 0;
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat dataform = new SimpleDateFormat("MM/dd HH:mm");
	//-----------------------------------------
	//#####################################################
	// PART 2: CONSTRUCTOR OF THE OBJECT
	
	//////////// SETTERS
	
	public Showtime(int month, int date, int hour, int minute, boolean is3D, SeatsLayOut layout ){
		this.month = month;
		this.date= date;
		this.hour=hour;
		this.minute=minute;
		this.is3D=is3D;
		this.layout=layout;
	}
	public void Setis3d(boolean is3d){
		this.is3D=is3d;
	}
	public void setLayout(SeatsLayOut layout){
	this.layout=layout;
	}

	//////////////////////////////////////
	// GETTERS
	
	public int getmonth() {
	return time.get(Calendar.MONTH);
	//function returns time
	}											//
	public int getDate() {						//
	return time.get(Calendar.DATE);			//
	}											//
	public int getHour() {						//
	return time.get(Calendar.HOUR);
	}											//
	public int getMinute() {					//
	return time.get(Calendar.MINUTE);		//
	}											//
	public boolean get3D(){						//this function returns whether this slot is 3D
	return this.is3D;						//
	}											//
	public String getTime() {					//
	return dataform.format(time.getTime());	//
	}											//
	public SeatsLayOut getSeatlayout()
	{return layout;}}

//	public void printSeatStatus() {				//
//	layout.printSeatStatus();				//
//	}											//
//	public void printlayout() {					//
//	//print seat layout						//
//	layout.printlayout();					//
//	}
	

