import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class MovieSettings {
private int Size; // Size of content in movielist
	private Movie[] MovieList= new Movie[30]; //Create tempList to store and return
	Scanner sc = new Scanner(System.in);
	Display UI = new Display(); //display UI messages
	enum status {ComingSoon, Preview, NowShowing, EndofShowing};
	int choice;
	//UI.staffdisplay();
	
//////////////////////////////////////////////////////////
//
// PART 3: FUNCTION STARTS HERE
// 3.1 BIGGEST RUNNING FUNCTION IN THE FILE
public Movie[] runMovieSetting(Movie[] movielist, int size) {
		this.MovieList=movielist;
		this.Size=size;
	do {
		try {
		UI.moviesettingdisplay();
	
		choice = Integer.parseInt(sc.nextLine());
		switch(choice) {
			case(1):
				System.out.println("*****Create Movie******");
				this.MovieList[Size]= CreateMovie(); 			//run create movie method
				Size= Size+1; 									//increment movielist size
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
	
	return this.MovieList;
}

public int returnlistsize() {
	return this.Size;
}

///////////////////////////////////////////////////////////////
//
// 3.2 Other functions

//////////////////////////////
// Function [1]: Create Movie
public Movie CreateMovie() {
	Movie temp= new Movie();
	temp.setTitle();								//function dedicated for setTitle (in Movie)
	temp.setStatus();								//function setStatus
	temp.setBlock();								//function decide blockbuster or not
	temp.setDirector();								//name of director
	temp.setRate();									//set rating
	temp.setRestriction();							//set restriction
	temp.setRuntime();								//set runtime
	temp.setSyn();									//set abstract
	temp.setCast();									//set cast
	return temp;
}
//
//Re-Sort movie by status
//Each time a new movie is added, the list is sorted again
public void sortMovie(){
	Movie temp;
	for(int i=1; i<Size; i++)
	{
		for(int j=i; j>0; j--)
		{
			if(checkprority(MovieList[j])> checkprority(MovieList[j-1]))
			{
				//check element right is smaller than left
				temp = MovieList[j];
				MovieList[j] = MovieList[j-1];
				MovieList[j-1] = temp;
			}
			else
				break;
		}
	}
}
//assign priority to Now showing, preview, coming soon, end of show
public int checkprority(Movie movie){
	if(movie.getStatus().equals(status.NowShowing))
		return 4;
	else if(movie.getStatus().equals(status.Preview))
		return 3;
	else if(movie.getStatus().equals(status.ComingSoon))
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
	printmovietitle();
	
	System.out.println("Select Movie to update: ");
	sel=Integer.parseInt(sc.nextLine());
	
	while(sel>this.Size || sel<0) {
		System.out.println("Invalid Input");
		System.out.println("Select Movie to update: ");
		sel=Integer.parseInt(sc.nextLine());
	}
	sel=sel-1;
	do {
	System.out.println("***Movie " + MovieList[sel].getTitle()+ " selected***");
	UI.updatedisplay();
	System.out.println("Enter the field you want to edit: ");
	choice = Integer.parseInt(sc.nextLine());
	switch(choice) {
	case (1):
		MovieList[sel].setTitle();
		break;
	case (2):
		MovieList[sel].setSyn();
		break;
	case (3):
		MovieList[sel].setDirector();
		break;
	case (4):
		MovieList[sel].setCast();
		break;
	case (5):
		MovieList[sel].setRestriction();
		break;
	case (6):
		MovieList[sel].setRuntime();
		break;
	case (7):
		MovieList[sel].setRate();
		break;
	case (8):
		MovieList[sel].updateReview();
		break;
	case (9):
		MovieList[sel].setBlock();
		break;
	default:
		choice = 1;
		break;
		}
	}while(choice!=0);
}
//generate the list of movie that is currently in spot
public void printmovietitle() {
	for(int x=0;x<this.Size;x++) {
		System.out.println("["+(x+1)+"] "+MovieList[x].getTitle());
	}
}
////////////////////////////////////////////////
//
//Function [3]: Remove movie
public int searchMovie(String title) {
	int count=0;
	while(count<this.Size){
		if(this.MovieList[count].getTitle().equalsIgnoreCase(title)){
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
	System.out.println("Enter Movie name to be removed:");
	remove=searchMovie(name=sc.nextLine());
	if(remove<0)
		System.out.println("Removal was Unsuccessful");
	else{
		for(int loop=remove; loop<this.Size; loop++){
			//shift all elements forward
			this.MovieList[loop] = this.MovieList[loop+1];
		}
		System.out.println("Removal was Successful");
		this.Size--;
	}
}

///////////////////////////////////////////////////
//
//Function [4]: Movie Ranking (have not understood yet)
public void MovieRanking() {
	Movie temp1;
	
	//copy the content of the original Seat to tempSeat
	//Sort TOP 5 rating

	System.out.println("Before");
	for(int a=0; a<Size; a++) {
		System.out.println(MovieList[a].getTitle() + " rating" + MovieList[a].getRating() );
	}
	
	for(int i=1; i<Size; i++)
	{
		for(int j=i; j>0; j--)
		{
			if(MovieList[j].getRating() > MovieList[j-1].getRating())
			{
				//check element right is smaller than left
				temp1 = MovieList[j];
				MovieList[j] = MovieList[j-1];
				MovieList[j-1] = temp1;
			}
			else
				break;
		}
	}
	System.out.println("After");
	for(int a=0; a<Size; a++) {
		System.out.println(MovieList[a].getTitle() + " rating" + MovieList[a].getRating() );
	}
	
	
}		
}
