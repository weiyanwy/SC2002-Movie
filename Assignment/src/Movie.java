

/*
Title: Movie
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
import java.util.ArrayList;

public class Movie {
	
	//////////////////////////////////////////
	// PART 1: INITIALIZE VARIABLES
	// initialization of relevant objects
	
	////////////IMPORTANT VARIABLES////////////////
	enum status {ComingSoon, Preview, NowShowing, EndofShowing}			//status of a movie
	public String title;												//title of movie
	public status ShowStatus;											//status of movie (defined in enum above)
	public boolean isBlock = false;										//check whether this movie is a blockbuster
	
	////////////NOT IMPORTANT VARIABLES////////////
	enum Restriction {PG, R16, R18, R21}
	private String Synopsis;											//movie abstract
	private String Director;											//name of director
	public ArrayList<String> MainCast;									//List of Main Cast
	public int rating;													//rating from 1-5
	private Restriction MovieRestriction;								//allowance to book ticket
	private String runtime;
	private ArrayList<String> reviews;
	///
	
	Scanner sc = new Scanner(System.in);
	//#-----------------------------
	
	//#################################################################
	//
	//PART 2: CONSTRUCTORS OF THE CLASS
	//
	
	//////////SETTERS
	// Title of movie
	public void setTitle() {
		String title;
		System.out.println("Enter the title of the movie: ");
		title = sc.nextLine();
		this.title = title;
	}
	// Status of movie
	public void setStatus() {			
		int choice;
		System.out.println("Enter Status of Movie: ");
		System.out.println("[1] Coming Soon");
		System.out.println("[2] Preview");
		System.out.println("[3] Now Showing");
		System.out.println("[4] End of Showing");
		choice = sc.nextInt();
		if(choice == 1) this.ShowStatus = status.ComingSoon;
		if(choice == 2) this.ShowStatus = status.Preview;
		if(choice == 3) this.ShowStatus = status.NowShowing;
		if(choice == 4) this.ShowStatus = status.EndofShowing;
	}
	// Is the movie a blockbuster?
	public void setBlock() {
		int choice;
		System.out.println("Blockbuster status of movie: ");
		System.out.println("[1] Yes");
		System.out.println("[2] No");
		choice = sc.nextInt();
		if(choice == 1) this.isBlock = true;
		if(choice == 2) this.isBlock = false;
	}
	
	////////GETTERS
	//Title
	public String getTitle() {
		return this.title;
	}
	//ShowStatus
	public status getStatus() {
		return this.ShowStatus;
	}
	//isBlock
	public boolean getBlock() {
		return this.isBlock;
	}
	
	/////////NOT IMPORTANT SETUPS//////////////////////////////
	
	////setters
	public void setSyn() {
		String Inp;
		System.out.println("Enter the Synopsis of the movie: ");
		Inp = sc.nextLine();
		this.Synopsis = Inp;
	}
	public void setDirector() {
		String Inp;
		System.out.println("Enter the Director of the movie: ");
		Inp = sc.nextLine();
		this.Director = Inp;
	}
	public void setCast() {
		String Inp;
		System.out.println("Enter the Cast of the movie: ");
		Inp = sc.nextLine();
		this.MainCast.add(Inp);
	}
	public void setRate() {
		int Inp;
		System.out.println("Enter the Ratings of the movie: ");
		Inp = sc.nextInt();
		this.rating=Inp;
	}
	public void updateReview() {
		String Inp;
		System.out.println("Add a new review to the movie: ");
		Inp = sc.nextLine();
		this.reviews.add(Inp);
	}
	public void setRuntime() {
		String Inp;
		System.out.println("Enter the Runtime of the movie: ");
		Inp = sc.nextLine();
		this.runtime=Inp;
	}
	public void setRestriction() {
		int Inp;
		System.out.println("Enter the Restriction of the movie: ");
		System.out.println("[1] PG");
		System.out.println("[1] R16");
		System.out.println("[1] R18");
		System.out.println("[1] R21");
		Inp = sc.nextInt();
		if(Inp == 1) this.MovieRestriction = Restriction.PG;
		if(Inp == 2) this.MovieRestriction = Restriction.R16;
		if(Inp == 3) this.MovieRestriction = Restriction.R18;
		if(Inp == 4) this.MovieRestriction = Restriction.R21;
	}
	////getters
	public String getSynopsis() {
		return this.Synopsis;
	}
	public String getDirector() {
		return this.Director;
	}
	public ArrayList<String> getCast() {
		return this.MainCast;
	}
	public float getRating() {
		return this.rating;
	}
	public Restriction getMovieRest() {
		return this.MovieRestriction;
	}
	public String getRuntime() {
		return this.runtime;
	}
	public void viewReviews() {
		for (int x = 0; x<this.reviews.size(); x++) {
			System.out.println("Review #"+ (x+1) +" "+ this.reviews.get(x));
		}
	}
	public void rundetails() {
		/////IMPORTANT VARIABLES
		System.out.println("Title: "+ this.title);
		System.out.println("Show Status: "+ this.ShowStatus);
		if(this.isBlock) System.out.println("Blockbuster: Yes");
		else System.out.println("Blockbuster: No");
		/////NOT IMPORTANT VARIABLES
		System.out.println("Synopsis "+ this.Synopsis);
		System.out.println("Director "+ this.Director);
		//System.out.println("Main Cast "+ this.MainCast);
		System.out.println("Movie rating "+this.rating);
		System.out.println("Movie Restriction "+ this.MovieRestriction);
		System.out.println("Movie Reviews: ");
		viewReviews();
		// get reviews

	}
	//#################################################################
	//PART 3: START HERE
	//#################################################################################################
	//this function is to display showtime when
	//booking ticket, because they need to see the available time slots
		
	//variables relating to this function
	//time[i] = variable containing ShowTime array
	//time[i] includes (year, month, date/time.minute)
	/*
	public void runShowtime(){
		for(i = 0; i<this.ShowSize;i++){
			System.out.print("Slot "+(i+1)+":");
			System.out.print("Day :"+time[i].year+ time[i].month + time[i].date);
			System.out.print("Time :"+ time[i].hour+ time[i].minute);
		}
	}
	*/
		
	//#################################################################################################
	/*
	public void updateShowtime() {
		int select;
		boolean check=true;
		if(ShowSize==0) {
			System.out.println("List is Empty");
		}
		else {
			for(int x=0; x<this.ShowSize;x++) {
				System.out.println(time[x].getTime());
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
			System.out.println("#" + (x+1) +": " + this.time[x].getTime());
		}
	}
	*/
}

