
import java.util.Scanner;

public class CustMode {
	////////////////////////////////////
	//
	// PART 1: INITIALISE VARIABLES
	public int sizeMovie;
	public Movie[] movie = new Movie[30];
	Display UI = new Display();
	MovieSettings movieset = new MovieSettings();
	Scanner sc = new Scanner(System.in);
	int choice;
	MovieMode movieUI=new MovieMode();
	
	////////////////////////////////////
	// PART  2: MAIN FUNCTIONS
	public void CustomerMode() {
		/////////////////
		// As customers, you have these functions
		// [1] View movie listing
		// [2] Search for movie
		// [3] Review Movie
		// [4] Book a ticket
		// [5] View Order History
		// [6] Exit
		UI.Customerdisplay();
		do {
			try {
			//////UI of Customer////////////
			UI.Customerdisplay();
				/*System.out.println("1: View Movie Listing");
				System.out.println("2: Search Movie");
				System.out.println("3: Review Movie");
				System.out.println("4: View Show Time and Cinema");
				System.out.println("5: View Order History");
				System.out.println("6: Exit Application");
			System.out.print("What is your choice:  ");*/
			choice= Integer.parseInt(sc.nextLine());
			////////////////////////////////
			
			switch(choice){
			// Function 1: viewMovie
			case 1:
				movieUI.viewMovie();
				break;
			// Function 2: Search Movie
			case 2:
				System.out.println("Enter Movie Title: ");
				String Name = sc.nextLine();
				movieUI.SearchMovie(Name);
				break;
			// Function 3: Book a ticket		
			case 3:
				movieUI.updateMovieReview();
				break;
			// Function 4: Book a ticket
			case 4:


				break;
			default:
				choice = 1;
				break;
			}
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
			}while(choice!=5);
	
	}

	
}
