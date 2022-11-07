import java.util.HashMap;
import java.util.Scanner;


public class CinemaSettings{
	private Movie[] movielist;
	private int ListSize;
	private Cinema[] Cinemalist = new Cinema[30];
	private int No_Cinema=0;
	Display UI = new Display();
	Scanner sc = new Scanner(System.in);
	private HashMap<String, Cinema> CineplexCinema = new HashMap<String, Cinema>();
	public Cinema[] runCinemaSetting(String CineplexName, int size) {
		this.movielist=movielist;
		ListSize=size;
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
					createCinema(movielist);
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
	
	public Cinema createCinema(Movie[] movie) {
		String name;
		Cinema temp = new Cinema();
		temp.setmovielist(movie);
		System.out.println("Enter Cinema Name:");
		name=sc.nextLine();
		temp.setname(name);
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
		
		int selectmovie;
		int choice =1;
		Cinemalist[sel].printmovietitles(ListSize);
		System.out.println("Select Movie to update");
		selectmovie= Integer.parseInt(sc.nextLine());
		do {
			try {
				UI.cinemaupdatedisplay();
				//System.out.println("Enter Choice:");
				choice=Integer.parseInt(sc.nextLine());
				switch(choice) {
					case(1):
						//call Add time function
						this.movielist[selectmovie-1].assignShowtime();
						this.movielist[selectmovie-1].printShowtime();
						break;
					case(2):
						this.movielist[selectmovie-1].updateshowtime();
						break;
						//call Update time function
					case(3):
						this.movielist[selectmovie-1].removeshowtime();
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
	public Cinema[] returncinemalist() {
		return this.Cinemalist;
	}
	public int returnCinemaSize() {
		return this.No_Cinema;
	}
}
