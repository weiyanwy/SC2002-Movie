
import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
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
	private SeatsLayOut arrangement= new SeatsLayOut();
	private SeatsLayOut layout=new SeatsLayOut();
	public boolean is3D = false;						//check whether this slot shows 3D mode
	
	boolean check=true;
	public	int sel = 0;
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat dataform = new SimpleDateFormat("MM/dd HH:mm");
	//-----------------------------------------
	//#####################################################
	// PART 2: CONSTRUCTOR OF THE OBJECT
	
	//////////// SETTERS
	
	// set time of timeslot
	public void updatetime() {
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
				time.set(Calendar.getInstance().get(Calendar.YEAR), month, date, hour, minute);
				break;
			}
			catch(Exception a) {
				System.out.println("Invalid input");
			}
		}while(check!=false);
	}
	
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
	switch(sel) {
	case(1):
	this.is3D = true;
	check=false;
	break;
	case(2):
	this.is3D = false;
	check=false;
	break;
	default:
	System.out.println("Invalid Input");
	}
	}
	catch(Exception e) {
	System.out.println("Invalid Input");
	}
	}while(check);
	}
	
	
	//////////////////////////////////////
	// GETTERS
	
	public int getmonth() {
	return time.get(Calendar.MONTH);		//function returns time
	}											//
	public int getDate() {						//
	return time.get(Calendar.DATE);			//
	}											//
	public int getHour() {						//
	return time.get(Calendar.HOUR);			//
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
	public void printSeatStatus() {				//
	layout.printSeatStatus();				//
	}											//
	public void printlayout() {					//
	//print seat layout						//
	layout.printlayout();					//
	}
	
	//#################################################
	//
	// PART 3: FUNCTIONS
	public void setShow() {
	boolean check=true;
	do {
	try {
		updatetime();										//setup time of slot
		set3D();											//setup whether it is 3D	
		this.layout.run();
		//updaterun();
		break;
	}
		catch(Exception a) {
			System.out.println("Invalid input");
	}
	}while(check);
	}
}

