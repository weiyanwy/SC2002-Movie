import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class CinemaSettings{
	private ArrayList<Movie> movielist;

	private CinemaType cinematype;
	private ArrayList<Cinema> Cinemalist=new ArrayList<>();
	private int No_Cinema=0;

	private MovieDBcontrol moviedata;
	private MovieSettings moviesetting;
	private ShowTimeSetting showset;

	Display UI = new Display();
	Scanner sc = new Scanner(System.in);


	public DBaddress address;


	public ArrayList<Cinema> runCinemaSetting(ArrayList<Cinema> Cinemalists) {

		//extract movielist from database
		this.moviedata=new MovieDBcontrol();
		this.movielist=moviedata.GetMovieFromDB();
		boolean exit=true;
		if(Cinemalists!=null)
			this.Cinemalist=Cinemalists;

		System.out.println("****Cinema setting******");
		int sel;
		do {
			UI.CinemaSettingdisplay();
			sel=Integer.parseInt(sc.nextLine());
			try {

			switch(sel) {
				case(0):
					//Exit
					System.out.println("Exit");
					exit=false;
					break;
				case(1):
					//Call Create Cinema");
					System.out.println("*****Create Cinema*****");
					this.Cinemalist.add(createCinema());
					printCinema();
					break;
				case(2):
					//Call update cinema function
					System.out.println("*****Update Cinema*****");
					updateCinema();
					break;
				case(3):
					//Call remove cinema
					System.out.println("*****Remove Cinema*****");
					removeCinema();
					break;
				default:
					System.out.println("Invalid Choice");

				} 		
			}
			catch(Exception e) {
				System.out.println("Invalid Choice");
			}
		}while(exit);

		return this.Cinemalist;
	}
	public void printCinema(){
		for(int x=0; x<this.Cinemalist.size(); x++){
			System.out.println("Cinema " + (x+1) + " "+ this.Cinemalist.get(x).getname())+ "Type: "+ this.Cinemalist.get(x).getCinematype());
		}
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
			System.out.println("Enter choice");
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
					exit=false;
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
		if (Cinemalist.size()> 0) {
			do {
				try {
					System.out.println("Select Cinema");
						for(int x = 0; x < this.Cinemalist.size(); x++) {
						System.out.println("#" + (x + 1) + " " + Cinemalist.get(x).getname());
					}
					System.out.println("Enter 0 to exit:");
					sel = Integer.parseInt(sc.nextLine());
					if (sel == 0)
						System.out.println("Exiting...");
					else if ((sel > 0) && (sel <= Cinemalist.size())) {
						return sel - 1;
					}
					else {
						System.out.println("Invalid Input");
					}
				} catch (Exception e) {
					System.out.println("Invalid Input");
				}

			} while (sel != 0);
			//return 0 if exit
			return 0;
		} else
			System.out.println("Cinema List is Empty");
		//return 1 if empty
		return -1;
	}
	
	public void updateCinema() throws IOException, ClassNotFoundException {
		int sel = selectCinema();
		int selectmovie = 0;
		boolean exit = true;
		if (sel > -1) {
			moviesetting.printmovietitle(this.movielist);
			while (exit) {
				System.out.println("Select Movie to update");
				selectmovie = Integer.parseInt(sc.nextLine());
				if (selectmovie > 0 && selectmovie < movielist.size())
					exit = false;
				else
					System.out.println("Invalid Input");
			}
			if(movielist.get(selectmovie-1).getstatus().equals(MovieStatus.Now_Showing)||movielist.get(selectmovie-1).getstatus().equals(MovieStatus.Preview)){
			Cinemalist.get(sel).assignShowtime(showset.runShowtimesetup(Cinemalist.get(sel),movielist.get(selectmovie-1),
					Cinemalist.get(sel).getShowtimelist()));
			} else{
				System.out.println("This movie is not allowed to assign timeslot");
			}

		} else
			System.out.println("List is empty");
	}


	public void removeCinema(){
		int choice;
		choice=selectCinema();
		if(choice!=-1){
			Cinemalist.remove(choice);
			System.out.println("Removal Successful");
		}
		else
			System.out.println("Removal unsuccessful");
	}


}
