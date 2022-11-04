import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class Showtime {
	
	#----------------------------------------
	//Generate relevant variables
	private Calendar time = Calendar.getInstance();
	private int year;						//year of showing
	private int month;						//month of slot
	private int date;						//day of slot
	private int hour;						//hour of slot
	private int minute;						//minute of slot
	private SeatsLayOut arrangement= new SeatsLayOut();
	private String VenueHall;
	private SeatsLayOut layout=new SeatsLayOut();
	public is3D = False;						//check whether this slot shows 3D mode
	
	boolean check=true;
	public	int sel = 0;
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat dataform = new SimpleDateFormat("MM/dd HH:mm");
	#-----------------------------------------
	
	///////////////////////////////////////////////////////////////////////
	//FUNCTION STARTS HERE
	public void setshow() {
		boolean check=true;
		do {
			try {
				updatetime();				//setup time of slot
				set3D();				//setup whether it is 3D
				//updatetype();		
				setvenue();				//setup which cinema to put in
				this.layout.run();
				break;
			}
			catch(Exception a) {
				System.out.println("Invalid input");
			}
		}while(check);
	}
	//////////////////////////////////////////////////////////////////////////////
	//This function chooses the venue of the slot
	public void setvenue() {
		String venue;
		System.out.println("Enter venue hall:");
		venue=sc.nextLine();
		this.VenueHall=venue;
	}
	///////////////////////////////////////////////////////////////////////////////
	//This function declares time of the slot
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
	////////////////////////////////////////////////////////////////////////////////
	
	//////////////////this block can be used for future reference/////////////////
	/* 
	public void updatetype() {
		System.out.println("Enter Show Type (1:Standard, 2:IMAX, 3:Preview):");
		do {
			try {
			System.out.println("Enter Choice:");
			sel=Integer.parseInt(sc.nextLine());
			switch(sel) {
			case(1):
				this.Type=showtype.STANDARD;
				check=false;
				break;
			case(2):
				this.Type=showtype.IMAX;
				check=false;
				break;
			case(3):
				this.Type=showtype.PREVIEW;
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
	*/
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
				this.is3D = True;
				check=false;
				break;
			case(2):
				this.is3D = False;
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
	/////////////////////////////////////////////////////////////////
	//FUNCTIONS THAT SIMPLY RETURN VALUE
	public String getvenue() {
		return this.VenueHall;
	}
	public showtype gettype() {
		return this.Type;
	}
	public int getmonth() {
		return time.get(Calendar.MONTH);
	}
	public int getDate() {
		return time.get(Calendar.DATE);
	}
	public int getHour() {
		return time.get(Calendar.HOUR);
	}
	public int getMinute() {
		return time.get(Calendar.MINUTE);
	}
	public boolean get3D(){						//this function returns whether this slot is 3D
		return this.is3D;
	}
	public String gettime() {
		return dataform.format(time.getTime());
	}
	public void printSeatStatus() {
		layout.printSeatStatus();
	}
	public void printlayout() {
		//print seat layout
		layout.printlayout();
	}
}
