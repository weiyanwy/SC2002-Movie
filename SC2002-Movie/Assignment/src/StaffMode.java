

import java.util.Scanner;
public class StaffMode {
	private int Size; // Size of content in movielist
	private Movie[] MovieList= new Movie[30]; //Create tempList to store and return
	Scanner sc = new Scanner(System.in);
	Display UI = new Display(); //display UI messages
	Cineplex[] CinemaList;
	private int Cinemalistsize;
	CinemaSettings cinema = new CinemaSettings();
	MovieSettings movieset = new MovieSettings();
	public void Adminmode(Movie[] movielist, int size){

		this.MovieList=movielist;
		this.Size= size;
		int choice;
		//UI.staffdisplay();
		do {
			UI.staffdisplay();
			//System.out.print("What is your choice:  ");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
				case(1):
					this.MovieList=movieset.runmoviesetting(movielist,Size);
					this.Size=movieset.returnlistsize();
					break;
				case(2):
					cinema.runCinemaSetting(this.MovieList, this.Size);
					CinemaList= cinema.returncinemalist();
					break;
				case(0):
					System.out.println("Exit Admin Mode");
					choice =0;
					break;
				default:
					System.out.println("Invalid Choice");
					choice=1;

			}

		}while(choice != 0);

	}
	public Cineplex[] getCinemaList() {
		return this.CinemaList;
	}
	public int getCinemaSize() {
		return this.Cinemalistsize=cinema.returnCinemaListSize();
	}

	public Movie[] ReturnList() {

		return this.MovieList;
	}
	public int ReturnSize() {
		return this.Size;
	}
	public void printMovies(Movie[] data, int size) {
		int loop=0;
		while(loop<size) {
			System.out.println("Movie#"+(loop+1)+" "+ data[loop].getTitle());
			loop++;
		}
	}}

