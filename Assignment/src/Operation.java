import java.util.Scanner;
import java.util.*;
public class Operation {
	
	#-----------------------------
	//initialisation of relevant things
	private Movie[] MovieLists = new Movie[30];	//List of Movies, imported in arrays
	public int Size=0;
	
	private Cineplex[] cinemalist;			//Cinema list
	private int CinemaSize;				//
	StaffLogin Staff = new StaffLogin();		//Initiate Staff here
	Operation Op = new Operation();			//Constructor of Operator
	Scanner sc = new Scanner(System.in);		//Scanner
	#-----------------------------
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
				return i;
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
	##############################################################################################################################
		
	public void booking(){
	#----------------------
	//Steps to implement this part
	//Step 1: booking is composed of showtime
	//Step 2: search film
	//Step 3: if succcessful, extract list of showtime
	//Step 4: choose showtime
	//step 5: choose position
	//step 6: if successful, indicate name, email, phone number
	#----------------------
		
	///////////////STEP 1 & 2 & 3////////////////////////
	//List of variable used: 
	//SearchMovie(); (finding the target movie)
	//target = containing the value of SearchMovie return
	//Movie[i].runShowtime(); (to help Customer choose timeslot)
		
	public int target = 0;
	target = Op.SearchMovie()						//
	if( target == -1 ){							//the movie is not found 
		System.out.println("The movie you search for is not found");	//
		System.out.println("Returning to CUSTOMER menu");		//
		return;								//returning to CUSTOMER menu
	} else{
		Movie[target].runShowtime();
	}	
	/////////STEP 1&2&3 DONE///////////////////////////
		
	////////////////STEP 4/////////////////////////////
	
	
	////////////STEP 4 DONE////////////////////////////
		
	#############################################################################################################################
	
	}
	public void ViewOrderHistory(){
	}



}
