import java.util.Date;
import java.util.Calendar;
import java.util.Scanner;
import java.text.SimpleDateFormat;
public class Showtime {
	private Calendar time = Calendar.getInstance();
	private int year;
	private int month;
	private int date;
	private int hour;
	private int minute;
	private showtype Type;
	private SeatsLayOut arrangement= new SeatsLayOut();
	private String VenueHall;
	private SeatsLayOut layout=new SeatsLayOut();
	enum showtype {
		    STANDARD,
		    IMAX,
		    PREVIEW
		  }
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat dataform = new SimpleDateFormat("MM/dd HH:mm");
	public void setshow() {
		boolean check=true;
		do {
			try {
				updatetime();
				updatetype();
				setvenue();
				this.layout.run();
				break;
			}
			catch(Exception a) {
				System.out.println("Invalid input");
			}
		}while(check);
	}
	public void setvenue() {
		String venue;
		System.out.println("Enter venue hall:");
		venue=sc.nextLine();
		this.VenueHall=venue;
	}
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
	public void updatetype() {
		System.out.println("Enter Show Type (1:Standard, 2:IMAX, 3:Preview):");
		boolean check=true;
		int sel;
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
