import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class MovieSettings {

	private ArrayList<Movie> MovieList = new ArrayList<>(); //Create tempList to store and return
	Scanner sc = new Scanner(System.in);
	Display UI = new Display(); //display UI messages

	MovieDBcontrol movieDB = new MovieDBcontrol();
	int choice;
	//UI.staffdisplay();
	
//////////////////////////////////////////////////////////
//
// PART 3: FUNCTION STARTS HERE
// 3.1 BIGGEST RUNNING FUNCTION IN THE FILE
public void runMovieSetting() throws IOException, ClassNotFoundException {
	if(movieDB.GetMovieFromDB() !=null)
		this.MovieList=movieDB.GetMovieFromDB();
	do {
		try {
		UI.moviesettingdisplay();
		choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case(1):
				System.out.println("*****Create Movie******");

				CreateMovie(); 			//run create movie method
										//increment movielist size
				sortMovie(); 									//Show movie by status
				break;
			case(2):
				UpdateMovie();
				break;
			case(3):
				System.out.println("*****Remove Movie******");
				RemoveMovie();
				break;
			case(4):
				System.out.println("*****Change Movie Ranking*****");
				MovieRanking();
				break;
			case(0):
				System.out.println("Exit Movie Settings");
				choice =0;
				break;
		default:
				System.out.println("Invalid Choice");
			
		}
		}
		catch(Exception e) {
			System.out.println("Invalid Input");
			choice=1;
		}

	}while(choice!=0);
	movieDB.insertMovieToDB(MovieList);
}



///////////////////////////////////////////////////////////////
//
// 3.2 Other functions

//////////////////////////////
// Function [1]: Create Movie
public void CreateMovie(){
	System.out.println("hello");
	Movie temp=new Movie();
	temp.setTitle();								//function dedicated for setTitle (in Movie)
	temp.setStatus();								//function setStatus
	temp.setBlock();								//function decide blockbuster or not
	temp.setDirector();								//name of director
	temp.setRate();									//set rating
	temp.setRestriction();							//set restriction
	temp.setRuntime();								//set runtime
	temp.setSyn();									//set abstract
	temp.setCast();									//set cast
	this.MovieList.add(temp);
}
//
//Re-Sort movie by status
//Each time a new movie is added, the list is sorted again
public void sortMovie(){
	Movie temp;
	// check if i =0 or 1
	for(int i=0; i<MovieList.size(); i++)
	{
		for(int j=i; j>0; j--)
		{
			if(checkprority(MovieList.get(j))> checkprority(MovieList.get(i)))
			{
				//check element right is smaller than left
				temp = MovieList.get(j);
				MovieList.set(j, MovieList.get(j-1));
				MovieList.set((j-1), temp);
			}
			else
				break;
		}
	}
}
//assign priority to Now showing, preview, coming soon, end of show
public int checkprority(Movie movie){
	if(movie.getstatus().equals(MovieStatus.Now_Showing))
		return 4;
	else if(movie.getstatus().equals(MovieStatus.Preview))
		return 3;
	else if(movie.getstatus().equals(MovieStatus.Coming_Soon))
		return 2;
	else
		return 1;
}
///////////////////////////////////////////////////////////////////////
//
//Function [2]: Update Movie

public void UpdateMovie(){
	int choice, sel;
	System.out.println("***List of movie you can choose to update***");
	if(MovieList.size()>0) {
		printmovietitle(this.MovieList);

		System.out.println("Select Movie to update: ");
		sel = Integer.parseInt(sc.nextLine());

		while (sel > this.MovieList.size() || sel < 0) {
			System.out.println("Invalid Input");
			System.out.println("Select Movie to update: ");
			sel = Integer.parseInt(sc.nextLine());
		}
		sel = sel - 1;
		do {
			System.out.println("***Movie " + MovieList.get(sel).getTitle() + " selected***");
			UI.updatedisplay();
			System.out.println("Enter the field you want to edit: ");
			choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
				case (1):
					MovieList.get(sel).setTitle();
					break;
				case (2):
					MovieList.get(sel).setSyn();
					break;
				case (3):
					MovieList.get(sel).setDirector();
					break;
				case (4):
					MovieList.get(sel).setCast();
					break;
				case (5):
					MovieList.get(sel).setRestriction();
					break;
				case (6):
					MovieList.get(sel).setRuntime();
					break;
				case (7):
					MovieList.get(sel).setRate();
					break;
				case (8):
					MovieList.get(sel).updateReview();
					break;
				case (9):
					MovieList.get(sel).setBlock();
					break;
				default:
					choice = 1;
					break;
			}
		} while (choice != 0);
	}
	else
		System.out.println("Movie List is empty");
}
//generate the list of movie that is currently in spot
public void printmovietitle(ArrayList<Movie> movielist) {
	for(int x=0;x<movielist.size();x++) {
		System.out.println("["+(x+1)+"] "+movielist.get(x).getTitle());
	}
}
////////////////////////////////////////////////
//
//Function [3]: Remove movie
public int searchMovie(String title) {
	int count=0;
	while(count<this.MovieList.size()){
		if(this.MovieList.get(count).getTitle().equalsIgnoreCase(title)){
			return count;
		}
		count++;
	}
	System.out.println("Movie Not Found");
	return -1;
}
public void RemoveMovie() {
	String name;
	int remove;
	if(MovieList.size()>0) {
		System.out.println("Enter Movie name to be removed:");
		remove = searchMovie(name = sc.nextLine());
		if (remove < 0)
			System.out.println("Removal was Unsuccessful");
		else {
			MovieList.remove(remove);
			System.out.println("Removal was Successful");

		}
	}
	else
		System.out.println("List is empty");
}


///////////////////////////////////////////////////
//
//Function [4]: Movie Ranking (have not understood yet)
public void MovieRanking() {
	Movie temp;
	
	//copy the content of the original Seat to tempSeat
	//Sort TOP 5 rating
	if(MovieList.size()>0) {
		System.out.println("Before");
		for (int a = 0; a < MovieList.size(); a++) {
			System.out.println(MovieList.get(a).getTitle() + " rating" + MovieList.get(a).getRating());
		}

		for (int i = 1; i < MovieList.size(); i++) {
			for (int j = i; j > 0; j--) {
				if (MovieList.get(j).getRating() > MovieList.get(i).getRating()) {
					//check element right is smaller than left
					temp = MovieList.get(j);
					MovieList.set(j, MovieList.get(j - 1));
					MovieList.set((j - 1), temp);
				} else
					break;
			}
		}
		System.out.println("After");
		for (int a = 0; a < MovieList.size(); a++) {
			System.out.println(MovieList.get(a).getTitle() + " rating" + MovieList.get(a).getRating());
		}
	}
	else
		System.out.println("Movie List is empty");
	
	
}		
}
