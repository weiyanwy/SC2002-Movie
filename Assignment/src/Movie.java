
import java.util.Scanner;

public class Movie {
	private String title;
	private String Synopsis;
	private String Director;
	private String ShowStatus;
	private String MainCast;
	private int numvotes;
	private float rating;
	private String MovieRestriction;
	private String Genre;
	private String runtime;
	private int totalsales;
	private String[] reviews = new String[10];
	///
	private Showtime[] time= new Showtime[100];
	private int ShowSize =0;
	public int i = 0; 		//iterator variable
	////

	private int count=0;
	
	Scanner sc = new Scanner(System.in);
	
	public void assignTitle(String Movietitle) {
		this.title = Movietitle;
		System.out.println("hello");
	}
	public void assignStatus(String Status) {
		this.ShowStatus = Status;
	}
	public void assignSyn(String Syns) {
		this.Synopsis = Syns;
	}
	public void assignDirect(String Director) {
		this.Director = Director;
	}
	// change to array easier to update
	public void assignCast(String Cast) {
		this.MainCast=Cast;
	}
	public void assignRate(float rating) {
		this.rating=rating;
	}
	public void assignVotes(int numvotes) {
		this.numvotes=numvotes;
	}
	public void assignSales(int sales) {
		this.totalsales= sales;
	}
	public void updateReview(String Review) {
		reviews[this.count]= Review;
		this.count+=1;
	}
	public void assignGenre(String Genre) {
		this.Genre=Genre;
	}
	public void assignRuntime(String Runtime) {
		this.runtime=Runtime;
	}
	public void assignRestrict(String Restrict) {
		this.MovieRestriction = Restrict;
	}
	public void viewReviews() {
		for (int x = 0; x<this.count; x++) {
			System.out.println("Review #"+ (x+1) +" "+ this.reviews[x]);
		}
	}

	public String getTitle() {
		return this.title;
	}
	public String getStatus() {
		return this.ShowStatus;
	}
	public String getSynopsis() {
		return this.Synopsis;
	}
	public String getDirector() {
		return this.Director;
	}
	public String getCast() {
		return this.MainCast;
	}
	public int getVotes() {
		return this.numvotes;
	}
	public float getRating() {
		return this.rating;
	}
	public String getMovieRest() {
		return this.MovieRestriction;
	}
	public String getGenre() {
		return this.Genre;
	}
	public String runtime() {
		return this.runtime;
	}

	public void rundetails() {
		System.out.println("Title: "+ this.title);
		System.out.println("Show Status: "+ this.ShowStatus);
		System.out.println("Synopsis "+ this.Synopsis);
		System.out.println("Director "+ this.Director);
		System.out.println("Main Cast "+ this.MainCast);
		System.out.println("Movie rating "+this.rating);
		System.out.println("Movie Restriction "+ this.MovieRestriction);
		System.out.println("Movie Reviews: ");
		viewReviews();
		// get reviews

	}
	#################################################################################################
	//this function is to display showtime when
	//booking ticket, because they need to see the available time slots
		
	//variables relating to this function
	//time[i] = variable containing ShowTime array
	//time[i] includes (year, month, date/time.minute)
	public void runShowtime(){
		for(i = 0; i<this.ShowSize;i++){
			System.out.print("Slot "+(i+1)+":");
			System.out.print("Day :"+time[i].year+ time[i].month + time[i].date);
			System.out.print("Time :"+ time[i].hour+ time[i].minute);
		}
	}
		
	#################################################################################################
	public int getShowlistSize() {
		return this.ShowSize;
	}
	
	public void assignShowtime(){
		Showtime temp = new Showtime();
		temp.setshow();
		this.time[ShowSize]=temp;
		this.ShowSize++;
	}
	public void updateshowtime() {
		int select;
		boolean check=true;
		if(ShowSize==0) {
			System.out.println("List is Empty");
		}
		else {
			for(int x=0; x<this.ShowSize;x++) {
				System.out.println(time[x].gettime());
			}
			do {
				try {
					System.out.println("Enter index to update:");
					select=Integer.parseInt(sc.nextLine());
					if((select>0) && (select<=this.ShowSize)) {
						time[select-1].updatetime();
						check=false;
					}
					else {
						System.out.println("Invalid Input");
					}
				}
				catch(Exception e)
				{
					System.out.println("Invalid Input");
				}
			}while(check);
			}
	}
	public void printShowtime() {
		System.out.println("Movie title: "+this.title);
		for(int x=0;x<ShowSize;x++) {
			System.out.println("#" + (x+1) +": " + this.time[x].gettime() + "  Type: "+time[x].gettype());
		}
	}
	public void printSeatStatus(int x) {
		time[x].printSeatStatus();
	}
	public void printlayout(int x) {
		time[x].printlayout();
	}
}
