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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Movie implements Serializable {
	//#-----------------------------
	//Generating movies' variables

	////////////IMPORTANT VARIABLES////////////////

	public String title;						//title of movie
	public MovieStatus ShowStatus;					//status of movie (defined in enum above) (should be reviewed in the future)
	public int ShowSize =0;					//how many slots of movies have been created
	public boolean isBlock = false;						//check whether this movie is a blockbuster
	//public is3D = False;						//check whether this movie is a 3D
	////////////NOT IMPORTANT VARIABLES////////////
	public String Synopsis;
	public String Director;
	public String MainCast;
	public String Genre;
	public float rating;
	public MovieRestriction movieRestriction;


	public String runtime;
	public ArrayList<String> reviews;
	///
	private int Reviewcount=0;

	SimpleDateFormat Runtimeformat= new SimpleDateFormat("H hr mm");
	Scanner sc = new Scanner(System.in);
	//#-----------------------------

	//###########################################################################################
	//FUNCTIONS START HERE

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
		if(choice == 1) this.ShowStatus = MovieStatus.Coming_Soon;
		if(choice == 2) this.ShowStatus = MovieStatus.Preview;
		if(choice == 3) this.ShowStatus = MovieStatus.Now_Showing;
		if(choice == 4) this.ShowStatus = MovieStatus.End_Of_Showing;
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
		this.MainCast=Inp;
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
		System.out.println("[1] NC16");
		System.out.println("[1] M18");
		System.out.println("[1] R21");
		Inp = sc.nextInt();
		if(Inp == 1) this.movieRestriction = MovieRestriction.PG13;
		if(Inp == 2) this.movieRestriction = MovieRestriction.NC16;
		if(Inp == 3) this.movieRestriction = MovieRestriction.M18;
		if(Inp == 4) this.movieRestriction = MovieRestriction.R21;
	}
	public void viewReviews() {
		if(reviews.size()>0){
		for (int x = 0; x<this.Reviewcount; x++) {
			System.out.println("Review #"+ (x+1) +" "+ this.reviews.get(x));
		}}
		else{
			System.out.println("No Reviews");
		}
	}

	public String getTitle() {
		return this.title;
	}
	public MovieStatus getstatus(){
		return this.ShowStatus;
	}

	public String getSynopsis() {
		return this.Synopsis;
	}
	public String getDirector() {
		return this.Director;
	}

	public float getRating() {
		return this.rating;
	}
	public MovieRestriction getMovieRest() {
		return this.movieRestriction;
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
		System.out.println("Movie Restriction "+ this.movieRestriction);
		// Set condition if only review > 1 then show
		System.out.println("Movie Reviews: ");
		viewReviews();
		// get reviews

	}

	}
