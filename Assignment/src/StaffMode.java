

import java.util.Scanner;
public class StaffMode {
	private int MovieListSize; // Size of content in movielist
	private Movie[] MovieList= new Movie[30]; //Create tempList to store and return

	//######## Create CINEPLEX SETTING CLASS
	CineplexSetting CineplexSet=new CineplexSetting();
	private Cineplex[] CineplexList;
	private int Cineplexlistsize;
	MovieSettings movieset = new MovieSettings();


	Scanner sc = new Scanner(System.in);
	Display UI = new Display(); //display UI messages

	String MovieDBaddress = " ";
	String CineplexDBaddress= " ";
	String CinemaDBaddress=" ";
	String ShowtimeDBaddress=" ";



	public void Adminmode(Movie[] movielist, int size){

		this.MovieList=movielist;
		this.MovieListSize= size;
		String MovieDBAddress = " "; // add address
		String CinemaDBAddress = " ";

		int choice;
		//UI.staffdisplay();
		do {
			UI.staffdisplay();
			//System.out.print("What is your choice:  ");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
				case(1):
					this.MovieList=movieset.runmoviesetting(MovieDBAddress, MovieListSize);
					this.MovieListSize=movieset.returnlistsize();
					break;
				case(2):
					CineplexSet.runCineplexSetting(MovieList,MovieListSize);
					this.CineplexList = CineplexSet.returncineplexlist();
					this.Cineplexlistsize= CineplexSet.returnCineplexListSize();

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
	public Cineplex[] getCineplexList() {
		return this.CineplexList;
	}
	public int getCineplexSize() {
		return this.Cineplexlistsize=CineplexSet.returnCineplexListSize();
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
	}


}

