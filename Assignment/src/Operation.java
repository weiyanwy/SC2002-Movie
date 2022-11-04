import java.util.Scanner;
import java.util.*;
public class Operation {
	
	//#-----------------------------
	//initialisation of relevant things
	private Movie[] MovieLists = new Movie[30];	//List of Movies, imported in arrays
	public int Size=0;

	Pricing price = new Pricing();		//Pricing object
	private Cineplex[] cinemalist;			//Cinema list
	private int CinemaSize;				//
	StaffLogin Staff = new StaffLogin();		//Initiate Staff here
	 //Operation Op = new Operation();			//Constructor of Operator
	Scanner sc = new Scanner(System.in);		//Scanner
	//#-----------------------------
	int choice = 1;					//dummy variable to insert input

	//functions to write
	public void viewMovie() {
		do {
			try {
				// size if list is empty
				if(Size>0) {
					int y=0;
					// Print movie listing
					while(y<Size) {
						System.out.println("Movie Title: "+ (y+1) + " " + this.MovieLists[y].getTitle());
						y++;
					}
					System.out.println("Choose which Movie detail you want to see: ");
					System.out.println("Enter 0 to Exit");
					System.out.println("Enter choice: ");
					choice=Integer.parseInt(sc.nextLine());
					// Exit


					if(choice==0)
						break;
					// Check for invalid input
					while(choice<0 && choice>this.Size) {
						System.out.println("Invalid Input");
						System.out.println("Enter choice: ");
						choice=Integer.parseInt(sc.nextLine());
					}

					// print movie details
					MovieLists[(choice-1)].rundetails();
				}
				// print list empty
				else {
					System.out.println("List is Empty");
					break;
				}}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}

		}while(choice!=0);
	}

	public void viewCinema() {
		int choice=1;

		do {
			try {
				// size if list is empty
				if(this.CinemaSize>0) {
					int y=0;
					// Print movie listing
					while(y<CinemaSize) {
						System.out.println("Cinema: "+ (y+1) + " " + this.cinemalist[y].getname());
						y++;
					}
					System.out.println("Choose which Cinema to view: ");
					System.out.println("Enter 0 to Exit:");
					System.out.println("Enter choice: ");
					choice=Integer.parseInt(sc.nextLine());
					// Exit


					if(choice==0)
						break;
					// Check for invalid input
					while(choice<0 && choice>this.Size) {
						System.out.println("Invalid Input");
						System.out.println("Enter choice: ");
						choice=Integer.parseInt(sc.nextLine());
					}
					cinemalist[choice-1].runCineplexshowtime(this.Size);
				}
				// print list empty
				else {
					System.out.println("List is Empty");
					break;
				}}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}

		}while(choice!=0);
	}

	public void runAdminLogin() {
		Staff.run(MovieLists,this.Size);
		this.MovieLists = Staff.returnlist();
		this.Size=Staff.returnSize();
		this.cinemalist= Staff.returnCinemaList();
		this.CinemaSize=Staff.returnCinema_Size();
	}


	public Movie[] returnlist() {
		return this.MovieLists;
	}
	// search position of movie
	public int SearchMovie() {

		String title;
		int count=0;
		System.out.println("Enter movie title to search: ");

		title=sc.nextLine();
		while(count<this.Size) {
			if(this.MovieLists[count].getTitle().toLowerCase().equals(title.toLowerCase())) {
				System.out.println("Movie Found");
				this.MovieLists[count].rundetails();
				return count;
			}
			count++;
		}
		System.out.println("Movie Not Found");
		return -1;
	}
	public void runCinema() {
		int sel;
		for(int x=1; x<=this.CinemaSize; x++) {
			System.out.println("Cinema #"+x + " "+ cinemalist[x-1].getname());
		}
		System.out.println("Enter Cinema Index to view");
		System.out.println("Enter 0 to exit");
		System.out.println("Enter Choice:");
		sel=Integer.parseInt(sc.nextLine());
		if(sel==0) {
			System.out.println("Exiting...");

		}
		else if(sel>0 && sel<=this.CinemaSize) {
			cinemalist[sel-1].runCineplexshowtime(this.Size);
		}


	}
	//##############################################################################################################################

	public void booking(){
	//#----------------------
		//Steps to implement this part
		//Step 1: booking is composed of showtime
		//Step 2: search film
		//Step 3: if succcessful, extract list of showtime
		//Step 4: choose showtime
		//step 5: choose position (step 5.5: print out availability of seats)
		//step 6: if successful, indicate name, email, phone number
		//step 7: print out price to pay (assume payment done)
		//step 8: generate transaction id (format XXX-YYYYMMDD-hhmm)
	//#----------------------

		///////////////STEP 1 & 2 & 3////////////////////////
		//List of variable used:
		//SearchMovie(); (finding the target movie)
		//target = containing the value of SearchMovie return
		//Movie[i].runShowtime(); (to help Customer choose timeslot)

		int target = 0;
		target = SearchMovie();						//
		if( target == -1 ){							//the movie is not found
			System.out.println("The movie you search for is not found\n");	//
			System.out.println("Returning to CUSTOMER menu\n");		//
			return;								//returning to CUSTOMER menu
		} else{									//
			MovieLists[target].runShowtime();					//display timeslots for customers to pick

		}
		/////////STEP 1&2&3 DONE///////////////////////////
	//#----------------------
				////////////////STEP 4&5///////////////////////////
				//List of variables used:
				//choice: user input to choose timeslot
				//Movie[target].ShowSize

		System.out.println("Please indicate your desired timeslot: ");
		choice = Integer.parseInt(sc.nextLine());
		if(choice<1 || choice> (MovieLists[target].getShowlistSize() +1) ){			//ill format input
			System.out.println("Invalid timeslot\n");			//
			System.out.println("Returning to CUSTOMER menu\n");		//
			return;								//returning to CUSTOMER menu
		} else{
		/* insert code to choose position here
		remember to take care of how the positions are marked
		*/
		}

		////////////STEP 4&5 DONE//////////////////////////
	//#----------------------
				////////////STEP 6/////////////////////////////////

				////////////STEP 6 DONE////////////////////////////
				//+----------------------
		////////////STEP 7/////////////////////////////////
		//List of variables used:
		//price object with function priceCalc
		//template priceCalc(age, day, hour, isBlock, is3D, isLuxury)

		double totalPrice = 0.0;
		//totalPrice = price.priceCalc(age, day, hour, isBlock, is3D, isLuxury);

		System.out.println("You have booked the seat successfully");
		System.out.printf("The amount of money to pay is %4.2f", totalPrice);
		System.out.println("Thank you for booking");

		////////////STEP 7 DONE////////////////////////////
		//+----------------------
				////////////STEP 8/////////////////////////////////
				//List of variables used:
				//string transID = null;
				//string transID = null;

		//transID = nameOfCinema+ real transaction time;
		System.out.println("Your transaction ID is: " );//+ transID);
		System.out.println("Please save the transaction ID for future reference");

		////////////STEP 8 DONE////////////////////////////


	//#############################################################################################################################

	}
	public void ViewOrderHistory(){
	}



}