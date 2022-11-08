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

	private HashMap<String, Cinema> CineplexCinema = new HashMap<String, Cinema>();

	String MovieDBaddress
	String CinemaDBaddress;
	String ShowtimeDBaddress;

	public Cinema[] runCinemaSetting(String CineplexName, int Movielistsize, String MovieDbaddress, String CinemaDBaddress, String ShowtimeDbaddress) {
		this.MovieDBaddress= MovieDbaddress;
		this.CinemaDBaddress=CinemaDBaddress;
		this.ShowtimeDBaddress=ShowtimeDbaddress;
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
					selectCinema();
					break;
				case(3):
					//Call remove cinema
					System.out.println("Remove Cinema");
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
	
	public void selectCinema() {
		int sel = 1;
		do {
			try {
				System.out.println("Select Cinema");
				for(int x=0; x<this.No_Cinema;x++) {
					System.out.println("#" +(x+1) + " " +Cinemalist[x].getname());
				}
				System.out.println("Enter 0 to exit:");
				sel=Integer.parseInt(sc.nextLine());
				if(sel==0)
					System.out.println("Exiting...");
				else if((sel>0) && (sel<=this.No_Cinema)) {
					updateCinema(sel-1);
				}
				else {
					System.out.println("Invalid Input");
				}
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
			
		}while(sel!=0);
	}
	
	public void updateCinema(int sel) {
		
		int selectmovie=0;
		int choice =1;
		boolean exit = true;
		moviesetting.printmovietitle(this.movielist, this.MovieListSize);
		while(exit){
			System.out.println("Select Movie to update");
			selectmovie= Integer.parseInt(sc.nextLine());
			if(selectmovie>0 && selectmovie<MovieListSize)
				exit=false;
			else
				System.out.println("Invalid Input");
		}
		do {
			try {
				UI.cinemaupdatedisplay();
				//System.out.println("Enter Choice:");
				choice=Integer.parseInt(sc.nextLine());
				switch(choice) {
					case(1):
						//call Add time function
						this.showset.Createshowtime(Cinemalist[sel].getname(), movielist[selectmovie-1].getTitle());
						break;
					case(2):
						this.showset.Updateshowtime(Cinemalist[sel].getname(), movielist[selectmovie-1].getTitle());
						break;
						//call Update time function
					case(3):
						this.showset.Removeshowtime(Cinemalist[sel].getname(), movielist[selectmovie-1].getTitle());
						break;
					case(4):
						//update layout
						break;
					case(0):
						System.out.println("Exiting....");
						break;
					default:
						System.out.println("Invalid Input");
				}
				
			}
			catch(Exception e) {
				System.out.println("Invalid input");
			}
		}while(choice!=0);
	}


	public void RemoveCinemafromCineplex(String CineplexName){

	}
	public void printCinemalist(){
		for (int x = 0; x<No_Cinema;x++){
			System.out.println("Cinema #"+(x+1)+ " " + Cinemalist[x].getname());
		}
	}
	public Cinema[] returncinemalist() {
		return this.Cinemalist;
	}
	public int returnCinemaSize() {
		return this.No_Cinema;
	}
}
