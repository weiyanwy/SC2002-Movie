/*
Title: Move
Use: create object movies with many variables to be taken into account

Important variables: 
title (used for searching and booking)
showStatus (affect whether it can be booked or not)
ShowTime (extremely crucial, as it contains other variables within)
ShowSize (following variable to ShowTime)
isBlock (this affects the price)
is3D (this also affects the price, both isBlock and this variable can be referred from the guide)

-----------------------
Relevant files:
Very crucial files to care about!!!
*/

import java.util.Scanner;

public class Movie {
	//#-----------------------------
	//Generating movies' variables
	
	////////////IMPORTANT VARIABLES////////////////
	public String[] movieStatus={"Coming Soon", "Preview", "Now Showing", "End of Showing"};
	enum status {ComingSoon, Preview, NowShowing, EndofShowing}
	private String title;						//title of movie
	private status ShowStatus;					//status of movie (defined in enum above) (should be reviewed in the future)
	private Showtime[] time= new Showtime[100];			//slots of movies
	private int ShowSize =0;					//how many slots of movies have been created
	public boolean isBlock = false;						//check whether this movie is a blockbuster
	//public is3D = False;						//check whether this movie is a 3D
	////////////NOT IMPORTANT VARIABLES////////////
	private String Synopsis;
	private String Director;
	private String MainCast;
	private int numvotes;
	private float rating;
	private String MovieRestriction;
	private String Genre;
	private String runtime;
	private int totalsales;
	private String[] reviews = new String[10];
	///
	private int Reviewcount=0;
	
	Scanner sc = new Scanner(System.in);
	//#-----------------------------
	
	//###########################################################################################
	//FUNCTIONS START HERE
	public void assignTitle(String Movietitle) {
		this.title = Movietitle;
		System.out.println("hello");
	}
	public void assignStatus() {//this function needs review
		int x;
		System.out.println("Select Movie Status 1: Coming Soon, 2:Preview, 3:Now Showing, 4: End of Showing");
		x = Integer.parseInt(sc.nextLine());
		switch(x){
			case 1:
				this.ShowStatus=status.ComingSoon;
				break;
			case 2:
				this.ShowStatus=status.Preview;
				break;
			case 3:
				this.ShowStatus=status.NowShowing;
				break;
			case 4:
				this.ShowStatus=status.EndofShowing;
				break;
			}
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
		reviews[this.Reviewcount]= Review;
		this.Reviewcount+=1;
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
		for (int x = 0; x<this.Reviewcount; x++) {
			System.out.println("Review #"+ (x+1) +" "+ this.reviews[x]);
		}
	}

	public String getTitle() {
		return this.title;
	}
	public status getstatus(){
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
	//#################################################################################################
	//this function is to display showtime when
	//booking ticket, because they need to see the available time slots
		
	//variables relating to this function
	//time[i] = variable containing ShowTime array
	//time[i] includes (year, month, date/time.minute)
	public void runShowtime(){
		for(int i = 0; i<this.ShowSize;i++){
			//gettime print show time HH/MM/ time
			System.out.print("Slot "+(i+1)+":" +time[i].gettime());
		}
	}
		
	//#################################################################################################
	public int getShowlistSize() {
		return this.ShowSize;
	}
	
	public void assignShowtime(){
		Showtime temp = new Showtime();
		temp.setshow();
		this.time[ShowSize]=temp;
		this.ShowSize++;
	}
	public void removeshowtime(){

		int remove;
		runShowtime();
		System.out.println("Enter Index of Show time to be removed:");
		remove=Integer.parseInt(sc.nextLine());
		if(remove<0 && remove>ShowSize)
			System.out.println("Removal was Unsuccessful");
		else{
			for(int loop=remove-1; loop<this.ShowSize; loop++){
				//shift all elements forward
				this.time[loop] = this.time[loop+1];
			}
			System.out.println("Removal was Successful");
			this.ShowSize--;
		}
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
			System.out.println("#" + (x+1) +": " + this.time[x].gettime());// + "  Type: "+time[x].gettype());
		}
	}
	public void printSeatStatus(int x) {
		time[x].printSeatStatus();
	}
	public void printlayout(int x) {
		time[x].printlayout();
	}
}
