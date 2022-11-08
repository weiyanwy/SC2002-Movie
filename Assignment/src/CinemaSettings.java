import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class CinemaSettings{
	private Movie[] movielist;
	private int MovieListSize;
	private CinemaType cinematype;
	private Cinema[] Cinemalist = new Cinema[30];
	private int No_Cinema=0;

	private MovieDBcontrol moviedata;
	private MovieSettings moviesetting;
	private ShowTimeSetting showset;

	Display UI = new Display();
	Scanner sc = new Scanner(System.in);


	public DBaddress address;
	private String MovieDBaddress= address.getMovieDBAddress();
	private String CinplexDBaddress= address.getCineplexDBAddress();

	public Cinema[] runCinemaSetting(int Movielistsize) {

		//extract movielist from database
		this.moviedata=new MovieDBcontrol(MovieDBaddress);
		this.movielist=moviedata.GetMovieFromDB();

		this.MovieListSize=Movielistsize;
		int sel=1;
		do {
			
			try {
			UI.CinemaSettingdisplay();
			sel=Integer.parseInt(sc.nextLine());
			switch(sel) {
				case(0):
					//Exit
					System.out.println("Exit");
					sel=0;
					break;
				case(1):
					//Call Create Cinema");
					createCinema();
					this.No_Cinema++;
					break;
				case(2):
					//Call update cinema function
					updateCinema();
					break;
				case(3):
					//Call remove cinema
					System.out.println("Remove Cinema");
					removeCinema();
					break;
	
				default:
					System.out.println("Invalid Choice");
				} 		
			}
			
			catch(Exception e) {
				System.out.println("Invalid Choice");
			}
		}while(sel!=0);

		return Cinemalist;
	}
	
	public Cinema createCinema() {
		boolean exit=true;
		int sel;
		String name;
		Cinema temp = new Cinema();

		System.out.println("Enter Cinema Name:");
		name=sc.nextLine();
		do{
			System.out.println("Enter Cinema Type:");
			System.out.println("1: STANDARD");
			System.out.println("2: GOLD");
			System.out.println("3: PLATINUM");
			sel=Integer.parseInt(sc.nextLine());
			switch(sel){
				case 1:
					cinematype=CinemaType.STANDARD;
					exit = false;
					break;
				case 2:
					cinematype=CinemaType.GOLD;
					exit=false;
					break;
				case 3:
					cinematype=CinemaType.PLATINUM;
					break;
				default:
					System.out.println("Invalid Input");
			}
		}while(exit);
		temp.setname(name);
		temp.setCinematype(cinematype);
		return temp;
	}
	
	public int selectCinema() {
		int sel = 1;
		if (No_Cinema != 0) {
			do {
				try {
					System.out.println("Select Cinema");
					for (int x = 0; x < this.No_Cinema; x++) {
						System.out.println("#" + (x + 1) + " " + Cinemalist[x].getname());
					}
					System.out.println("Enter 0 to exit:");
					sel = Integer.parseInt(sc.nextLine());
					if (sel == 0)
						System.out.println("Exiting...");
					else if ((sel > 0) && (sel <= this.No_Cinema)) {
						return sel - 1;
					} else {
						System.out.println("Invalid Input");
					}
				} catch (Exception e) {
					System.out.println("Invalid Input");
				}

			} while (sel != 0);
			return 0;
		} else
			System.out.println("Cinema List is Empty");
		return -1;
	}
	
	public void updateCinema() throws IOException, ClassNotFoundException {
		int sel = selectCinema();
		int selectmovie = 0;
		int choice = 1;
		boolean exit = true;
		if (sel != -1) {
			moviesetting.printmovietitle(this.movielist, this.MovieListSize);
			while (exit) {
				System.out.println("Select Movie to update");
				selectmovie = Integer.parseInt(sc.nextLine());
				if (selectmovie > 0 && selectmovie < MovieListSize)
					exit = false;
				else
					System.out.println("Invalid Input");
			}
			showset.runShowtimesetup(Cinemalist[sel],movielist[selectmovie-1], MovieListSize);

		} else
			System.out.println("List is empty");
	}


	public void removeCinema(){
		int choice;
		choice=selectCinema();
		if(choice!=-1){
			for(int x=choice; x<No_Cinema; x++){
				// Shift data to the left
				Cinemalist[x]=Cinemalist[x+1];
			}
			No_Cinema--;
			System.out.println("Removal Successful");
		}
		else
			System.out.println("List is empty and removal unsuccessful");

	}

	public void printCinemalist(){
		for (int x = 0; x<No_Cinema;x++){
			System.out.println("Cinema #"+(x+1)+ " " + Cinemalist[x].getname());
		}
	}

	public int returnCinemaSize() {
		return this.No_Cinema;
	}
}
