import java.util.Scanner;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;

public class MovieSettings {
		private int MovieSize; // Size of content in movielist
		private Movie[] MovieList; //Create tempList to store and return
		Scanner sc = new Scanner(System.in);
		Display UI = new Display(); //display UI messages
		MovieStatus status; //{ComingSoon, Preview, NowShowing, EndofShowing};


		private MovieDBcontrol MovieDB;

		int choice;
		//UI.staffdisplay();
	public Movie[] runmoviesetting(String MovieAddress, int size) {
			this.MovieDB=new MovieDBcontrol(MovieAddress);
			this.MovieList=MovieDB.GetMovieFromDB();
			this.MovieSize=size;
		do {
			try {
			UI.moviesettingdisplay();
//				System.out.println("******MOVIE SETTINGS*****");
//				System.out.println("1: Create Movie");
//				System.out.println("2: Update Movie");
//				System.out.println("3: Remove Movie");
//				System.out.println("4: Adjust Ranking");
//				System.out.println("0: Exit");
//				System.out.println("Enter Choice:");
			choice = Integer.parseInt(sc.nextLine());

			switch(choice) {
				case(1):
					System.out.println("*****Create Movie******");
					CreateMovie(); //run create movie method


					break;
				case(2):
					UpdateMovie();
					break;
				case(3):
					System.out.println("Remove Movie");
					RemoveMovie();
					break;
				case(4):
					System.out.println("Change movie Ranking");
					MovieRanking();
					break;
				case(0):
					System.out.println("Exit Movie Settings");
					MovieDB.UpdateMovietoDB(this.MovieList);
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
		return this.MovieSize;
	}

	public Movie CreateMovie() {
		Movie temp;
		MovieStatus NewStatus;
		MovieRestriction MovieRestrict;
		String Input;
		int a;
		float b;
		boolean check=true;
		System.out.println("Enter Title:");
		String title=sc.nextLine();
		System.out.println("Enter Movie Description: ");
		String Description=sc.nextLine();
		System.out.println("Enter Movie Show Status (1:Now Showing, 2:Coming Soon, 3:Preview, 4:End Of Showing)");
		do{
			int sel;
			try{
				sel=Integer.parseInt(sc.nextLine());
			switch (sel) {
				case 1:
					NewStatus = MovieStatus.Now_Showing;
					check = false;
					break;
				case 2:
					NewStatus = MovieStatus.Coming_Soon;
					check = false;
					break;
				case 3:
					NewStatus = MovieStatus.Preview;
					check = false;
					break;
				case 4:
					NewStatus = MovieStatus.End_Of_Showing;
					check = false;
					break;
				default:
					System.out.println("Invalid Input");
			}
				}
			catch(Exception e){
				System.out.println("Invalid Input");
			}
		}while(check);

		System.out.println("Enter Movie Director: ");
		String Director =sc.nextLine();
		System.out.println("Enter Movie Main Cast: ");
		String MainCast = sc.nextLine();
		System.out.println("Enter Movie Restriction (1: PG13,2: NC16,3: M18,4: R21):"); //-edit to enum
		check=true;
		do{
			int sel;
			try{
				sel=Integer.parseInt(sc.nextLine());
				switch (sel) {
					case 1:
						MovieRestrict= MovieRestriction.PG13;
						check = false;
						break;
					case 2:
						MovieRestrict= MovieRestriction.NC16
						check = false;
						break;
					case 3:
						MovieRestrict= MovieRestriction.M18;
						check = false;
						break;
					case 4:
						MovieRestrict= MovieRestriction.R21;
						check = false;
						break;
					default:
						System.out.println("Invalid Input");
				}
			}
			catch(Exception e){
				System.out.println("Invalid Input");
			}
		}while(check);
		System.out.println("Enter Movie Genre:");
		String Genre = sc.nextLine();
		System.out.println("Enter Movie Run time in minutes");
		int Runtime = Integer.parseInt(sc.nextLine());


		return temp=new Movie(title, Description, Director, MainCast, Genre, Runtime, NewStatus, MovieRestrict);
	}
	//Sort movie by status NowShowing, End of Show,Preview, Coming Soon)
	public void sortMovie(){
		Movie temp;
		for(int i=1; i<MovieSize; i++)
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
		if(movie.getstatus().equals(MovieStatus.Now_Showing))
			return 4;
		else if(movie.getstatus().equals(MovieStatus.Preview))
			return 3;
		else if(movie.getstatus().equals(MovieStatus.Coming_Soon))
			return 2;
		else
			return 1;
	}
	public void UpdateMovie(){
		int choice, sel, updateInt;
		float updatefloat;
		String updates;
		
		printmovietitle();
		
		System.out.println("Select Movie to update: ");
		sel=Integer.parseInt(sc.nextLine());
		
		while(sel>this.MovieSize) {
			System.out.println("Invalid Input");
			System.out.println("Select Movie to update: ");
			sel=Integer.parseInt(sc.nextLine());
		}
		sel=sel-1;
		do {
			System.out.println("Movie " + MovieList[sel].getTitle()+ " selected");
			UI.updatedisplay();
			//System.out.println("Enter Choice: ");
			choice = Integer.parseInt(sc.nextLine());
			if(0<choice && choice<11)
				System.out.println("Enter new updates: ");
			//updates=sc.nextLine();// check input

			switch(choice) {

				case (1):
					MovieList[sel].assignTitle(updates=sc.nextLine());
					break;
				case (2):

					MovieList[sel].assignSyn(updates=sc.nextLine());
					break;
				case (3):

					MovieList[sel].assignDirect(updates=sc.nextLine());
					break;
				case (4):

					MovieList[sel].assignCast(updates=sc.nextLine());
					break;
				case (5):

					MovieList[sel].assignGenre(updates=sc.nextLine());
					break;
				case (6):

					MovieList[sel].assignRestrict(updates=sc.nextLine());
					break;
				case (7):

					MovieList[sel].assignRuntime(updates=sc.nextLine());
					break;
				case (8):

					MovieList[sel].assignRate(updatefloat=Float.parseFloat(sc.nextLine()));
					break;
				case (9):
					MovieList[sel].assignVotes(updateInt=Integer.parseInt(sc.nextLine()));
					break;
				case (10):
					MovieList[sel].updateReview(updates=sc.nextLine());
					break;
				case (11):
					choice =0;
					break;
				default:
					choice = 1;
					break;
			}
		}while(choice!=0);

		

	}
	public void printmovietitle() {
		for(int x=0;x<this.MovieSize;x++) {
			System.out.println("Movie #"+(x+1)+" "+MovieList[x].getTitle());
		}
	}

	public int searchMovie(String title) {
		int count=0;
		while(count<this.MovieSize){
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
			for(int loop=remove; loop<this.MovieSize; loop++){
				//shift all elements forward
				this.MovieList[loop] = this.MovieList[loop+1];
			}
			System.out.println("Removal was Successful");
			this.Size--;
		}
	}
	public void MovieRanking() {
		Movie temp1;
		
		//copy the content of the original Seat to tempSeat
		//Sort TOP 5 rating
	
		System.out.println("Before");
		for(int a=0; a<MovieSize; a++) {
			System.out.println(MovieList[a].getTitle() + " rating" + MovieList[a].getRating() );
		}
		
		for(int i=1; i<MovieSize; i++)
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
		for(int a=0; a<MovieSize; a++) {
			System.out.println(MovieList[a].getTitle() + " rating" + MovieList[a].getRating() );
		}
		
		
	}
}
