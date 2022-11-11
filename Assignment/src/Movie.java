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
	public double rating;
	public MovieRestriction movieRestriction;


	public String runtime;
	public ArrayList<String> reviews;
	///



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
	/*public Movie(String Title, String Synopsis, String Cast, String Director, MovieStatus status, boolean isBlock, String Genre, MovieRestriction restrict, double rating ){
		this.title=Title;
		this.Synopsis=Synopsis;
		this.MainCast=Cast;
		this.Director=Director;
		this.ShowStatus=status;
		this.isBlock=isBlock;
		this.Genre=Genre;
		this.movieRestriction=restrict;
		this.rating=rating;
	}*/
	public void setTitle(String title) {
		this.title=title;
	}
	// Status of movie
	public void setStatus(MovieStatus status) {
		this.ShowStatus=status;
	}
	public void setGenre(String genre){
		this.Genre=genre;
	}
	// Is the movie a blockbuster?
	public void setBlock(boolean block) {
		this.isBlock=block;
	}
	public void setSyn(String Synopsis) {
		this.Synopsis=Synopsis;
	}
	public void setDirector(String Director) {
		this.Director=Director;
	}
	public void setCast(String cast) {
		this.MainCast=cast;
	}
	public void setRate(double rating) {
		this.rating=rating;
	}
	public void updateReview(String review) {
		this.reviews.add(review);
	}
	public void setRuntime(int runtime) {
		int hour=runtime/60;
		int minute=runtime%60;

		this.runtime= hour + " hr "+minute+ " min";
	}
	public void setRestriction(MovieRestriction restrict) {
		this.movieRestriction=restrict;
	}



	public void viewReviews() {
		if(reviews.size()>0){
			for (int x = 0; x<this.reviews.size(); x++) {
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

	public double getRating() {
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