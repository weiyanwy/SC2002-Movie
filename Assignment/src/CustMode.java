
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
	
	
	////////////////////////////////////
	// PART  2: MAIN FUNCTIONS
	public void CustomerMode(Movie[] movielist, int size) {
		this.movie = movielist;
		this.sizeMovie = size;
		/////////////////
		// As customers, you have these functions
		// [1] View movie listing
		// [2] Search for movie
		// [3] Book a ticket
		// [4] View Order History
		// [5] Exit
		UI.Customerdisplay();
		do {
			try {
			//////UI of Customer////////////
			UI.Customerdisplay();
			System.out.print("What is your choice:  ");
			choice= Integer.parseInt(sc.nextLine());
			////////////////////////////////
			
			switch(choice){
			// Function 1: viewMovie
			case 1:
				viewMovie(movie, sizeMovie);
				break;
				
			// Function 2: Search Movie
			case 2:
				int index;
				index = searchMovie(movie,sizeMovie);
				if(index!=-1) {
					System.out.println("***");
					System.out.println("Movie found");
					System.out.println("["+(index+1)+"] "+ movie[index].getTitle());
				}
				else System.out.println("Requested movie not found");
				break;
				
			// Function 3: Book a ticket		
			case 3:
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
	/////////////////////////////////////////////////////////////////////////
	//
	//Function [1]: viewMovie
	public void viewMovie(Movie[] movie, int sizeList) {
		int i=0;
		System.out.println("***The list of current movies***");
		for(i=0;i<sizeList;i++) {
			System.out.println("**************************************");
			System.out.println("Movie ["+ (i+1)+ "]: "+ movie[i].getTitle());
			System.out.println("---------");
			System.out.println("Director: "+ movie[i].getDirector());
			System.out.println("Main Cast: ");
			for(int k =0 ;k<movie[i].MainCast.size();k++) {
				System.out.println(movie[i].MainCast.get(k));
			}
			System.out.println("---------");
			System.out.println("Description: "+ movie[i].getSynopsis());
			System.out.println("Age Restriction: "+ movie[i].getMovieRest());
			System.out.println("Status: "+ movie[i].getStatus());
		}
	}
	/////////////////////////////////////////////////////////////////////////
	//
	//Function [2]; searchMovie
	public int searchMovie(Movie[] movie, int sizeList) {
		int i = 0;
		String search;
		System.out.println("***Search Movie***");
		System.out.println("Please indicate the name you are searching for:");
		search = sc.nextLine();
		for(i=0;i<sizeList;i++) {
			if(movie[i].getTitle().equalsIgnoreCase(search)) return i;
		}
		return -1;
	}
	
	/////////////////////////////////////////////////////////////////////////
	//
	//Function [3]:Booking
	//Super complex, good luck with this one
	// Procedure of booking
	
	public void booking(Movie[] movie, int movieList, Cineplex[] cineplex) {
		//////STEP 1///////
	}
	
	
}
