package Entity;

import java.io.Serializable;
import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import Controller.*;
import Settings.*;
public class MovieSettings implements Serializable {

	ArrayList<Movie> MovieList = new ArrayList<>(); //Create tempList to store and return
	Scanner sc = new Scanner(System.in);
	Display UI = new Display(); //display UI messages

	MovieDBcontrol movieDB = new MovieDBcontrol();

	//UI.staffdisplay();

	//////////////////////////////////////////////////////////
//
// PART 3: FUNCTION STARTS HERE
// 3.1 BIGGEST RUNNING FUNCTION IN THE FILE
	public void runMovieSetting() throws IOException {
		int choice;
		this.MovieList=movieDB.GetMovieFromDB();

		do {

			UI.moviesettingdisplay();
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
				case(1):
					System.out.println("*****Create Movie******");
					movieDB.addMovie(CreateMovie());
					this.MovieList= movieDB.GetMovieFromDB();
					//MovieList.add(Temp);//run create movie method
					//sortMovie(); 									//Show movie by status
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
				case(5):
					System.out.println("****Movie List*****");
					printmovietitle(this.MovieList);
					break;
				case(0):
					System.out.println("Exit Movie Settings");
					choice =0;
					break;
				default:
					System.out.println("Invalid Choice");

			}


		}while(choice!=0);
		movieDB.overwriteMovieList(this.MovieList);
		//printmovietitle(MovieList);
	}



///////////////////////////////////////////////////////////////
//
// 3.2 Other functions

	//////////////////////////////
// Function [1]: Create Movie
	public Movie CreateMovie() {
		boolean exit = true;
		
		int choice;
		MovieStatus status = null;
		MovieRestriction restrict=null;

		Movie temp = new Movie();

		System.out.println("Enter Movie Title:");
		String title = sc.nextLine();
		temp.setTitle(title);
		System.out.println("Enter Genre:");
		String Genre=sc.nextLine();
		temp.setGenre(Genre);

		temp.setTitle(title);
		do {
			try {
				System.out.println("Enter Show Status:");
				System.out.println("1: Now Showing");
				System.out.println("2: Preview");
				System.out.println("3: Coming Soon");
				System.out.println("4: End of Showing");
				System.out.println("Enter choice:");
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
					case 1:
						status = MovieStatus.Now_Showing;
						exit = false;
						break;
					case 2:
						status = MovieStatus.Preview;
						exit = false;
						break;
					case 3:
						status = MovieStatus.Coming_Soon;
						exit = false;
						break;
					case 4:
						status = MovieStatus.End_Of_Showing;
						exit = false;
						break;
					default:
						System.out.println("Invalid Input");
				}
			}
			catch(Exception e){
					System.out.println("Invalid Input");
				}
			//set cast
		}while(exit);
		temp.setStatus(status);

		boolean isBlockuster = false;
		do{
			exit=true;
			System.out.println("Enter is Movie Blockbuster?");
			System.out.println("1: Yes");
			System.out.println("2: False");
			System.out.println("Enter choice:");
			choice =Integer.parseInt(sc.nextLine());
			try {
				switch (choice) {
					case 1:
						isBlockuster = true;
						exit = false;
						break;

					case 2:
						isBlockuster = false;
						exit = false;
						break;
					default:
						System.out.println("Invalid Input:");
				}
			}
			catch(Exception e){
				System.out.println("Invalid Input");
			}
		}while(exit);

		temp.setBlock(isBlockuster);

		System.out.println("Enter Movie Synopsis:");

		String Syn = sc.nextLine();

		temp.setSyn(Syn);

		System.out.println("Enter Director Name:");
		String Director = sc.nextLine();
		temp.setDirector(Director);

		System.out.println("Enter Cast Names:");
		String Cast=sc.nextLine();
		temp.setCast(Cast);

		System.out.println("Enter Movie Run Time In Minutes: ");
		int runtime =Integer.parseInt(sc.nextLine());
		temp.setRuntime(runtime);

		System.out.println("Enter Movie Rating:");
		double rate = Double.parseDouble(sc.nextLine());
		temp.setRate(rate);

		do{
			exit = true;
			System.out.println("Enter Movie Restriction Rating:");
			System.out.println("1: PG13");
			System.out.println("2: NC16");
			System.out.println("3: M18");
			System.out.println("4: R21");
			System.out.println("Enter choice:");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice){
				case 1:
					restrict=MovieRestriction.PG13;
					exit=false;
					break;
				case 2:
					restrict=MovieRestriction.NC16;
					exit= false;
					break;
				case 3:
					restrict=MovieRestriction.M18;
					exit=false;
					break;
				case 4:
					restrict=MovieRestriction.R21;
					exit=false;
					break;
				default:
					System.out.println("Invalid Input");

			}
		}while(exit);

		temp.setRestriction(restrict);

		return temp;
	}
	//

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
					case (0):
						System.out.println("Exiting Movie Updates....");
						break;
					case (1):
						System.out.println("Enter Movie Title:");
						String title = sc.nextLine();
						MovieList.get(sel).setTitle(title);
						break;
					case (2):
						System.out.println("Enter Movie Synopsis:");
						String Syn = sc.nextLine();
						MovieList.get(sel).setSyn(Syn);
						break;
					case (3):
						System.out.println("Enter Director Name:");
						String Director = sc.nextLine();
						MovieList.get(sel).setDirector(Director);
						break;
					case (4):
						System.out.println("Enter Cast Names:");
						String Cast=sc.nextLine();
						MovieList.get(sel).setCast(Cast);
						break;
					case (5):
						System.out.println("Enter Genre");
						String Genre=sc.nextLine();
						MovieList.get(sel).setGenre(Genre);
					case (6):
						MovieRestriction restrict=null;
						boolean exit = true;
						do{

							System.out.println("Enter Movie Restriction Rating:");
							System.out.println("1: PG13");
							System.out.println("2: NC16");
							System.out.println("3: M18");
							System.out.println("4: R21");
							System.out.println("Enter choice:");
							choice = Integer.parseInt(sc.nextLine());
							switch(choice){
								case 1:
									restrict=MovieRestriction.PG13;
									exit=false;
									break;
								case 2:
									restrict=MovieRestriction.NC16;
									exit= false;
									break;
								case 3:
									restrict=MovieRestriction.M18;
									exit=false;
									break;
								case 4:
									restrict=MovieRestriction.R21;
									exit=false;
									break;
								default:
									System.out.println("Invalid Input");

							}
						}while(exit);
						MovieList.get(sel).setRestriction(restrict);
						break;
					case (7):
						System.out.println("Enter Movie Run Time In Minutes: ");
						int runtime =Integer.parseInt(sc.nextLine());
						MovieList.get(sel).setRuntime(runtime);
						break;
					case (8):
						System.out.println("Enter Movie Rating:");
						double rate = Double.parseDouble(sc.nextLine());
						MovieList.get(sel).setRate(rate);
						break;
					case (9):
						System.out.println("Enter Review:");
						String newReview=sc.nextLine();
						MovieList.get(sel).updateReview(newReview);
						break;
					case (10):
						boolean isBlockuster=false;
						do{
							exit=true;
							System.out.println("Enter is Movie Blockbuster?");
							System.out.println("1: Yes");
							System.out.println("2: False");
							System.out.println("Enter choice:");
							choice =Integer.parseInt(sc.nextLine());
							switch(choice){
								case 1:
									isBlockuster=true;
									exit=false;
									break;

								case 2:
									isBlockuster=false;
									exit=false;
									break;
								default:
									System.out.println("Invalid Input:");
							}}while(exit);
						MovieList.get(sel).setBlock(isBlockuster);
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
			System.out.println("#"+(x+1)+" Movie: "+movielist.get(x).getTitle() + ", Show Status: "+ movielist.get(x).getstatus()
					+ ", "+ movielist.get(x).getMovieRest() +", "+movielist.get(x).getRating() );
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
		Movie temp=new Movie();

		//copy the content of the original Seat to tempSeat
		//Sort TOP 5 rating
		if(MovieList.size()>0) {
			System.out.println("Before");
			for (int a = 0; a < MovieList.size(); a++) {
				System.out.println("#" + (a+1)+ " Movie: " +MovieList.get(a).getTitle() + " rating: " + MovieList.get(a).getRating());
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
				System.out.println("#" + (a+1)+ " Movie: " +MovieList.get(a).getTitle() + " rating: " + MovieList.get(a).getRating());
			}
		}
		else
			System.out.println("Movie List is empty");


	}
}

