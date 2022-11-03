import java.util.Scanner;
import java.util.*;
public class Operation {
	
	#-----------------------------
	//initialisation of relevant things
	private Movie[] MovieLists = new Movie[30];
	public int Size=0;
	private Cineplex[] cinemalist;
	private int CinemaSize;
	StaffLogin Staff = new StaffLogin();;
	Scanner sc = new Scanner(System.in);
	#-----------------------------
	
	//functions to write
	public void viewMovie() {
		int choice=1;

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
	public void SearchMovie() {

		String title;
		int count=0;
		System.out.println("Enter movie title to search: ");

		title=sc.nextLine();
		while(count<this.Size) {
			if(this.MovieLists[count].getTitle().toLowerCase().equals(title.toLowerCase())) {
				System.out.println("Movie Found");
				this.MovieLists[count].rundetails();
				break;
			}
			count++;
		}
		System.out.println("Movie Not Found");
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
	public void booking(){
		
	}
	public void ViewOrderHistory(){
	}



}
