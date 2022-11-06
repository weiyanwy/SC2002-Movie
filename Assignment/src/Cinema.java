/*
 * Title: Cinema
 * Use: Object Cinema consists of movie
 * ---------------------------------------
 */

import java.util.Scanner;

public class Cinema {
		//#################################################################
		//
		//PART 1: INITIALIZE RELEVANT VARIABLES
		//
		//1.1: Initialize objects init
		public String name;									//name of cinema
		public Showtime[] ShowTimeList = new Showtime[100];
		Scanner sc = new Scanner(System.in);

		//#################################################################
		//
		//PART 2: CONSTRUCTORS OF THE CLASS
		//
		
		///////SETTERS
		// set type seat
		public void setTypeSeat() {
			int Inp;
			System.out.println("Indicate the TypeSeat of new cinema: ");
			System.out.println("[1] Standard");
			System.out.println("[2] Luxury");
			Inp = sc.nextInt();
			if(Inp ==1) this.TypeSeat = typeSeat.Standard;
			if(Inp ==2) this.TypeSeat = typeSeat.Luxury;
		}
		// set name cinema
		public void setNameCinema() {
			String Inp;
			System.out.println("Indicate the name of new cinema: ");
			Inp = sc.nextLine();
			this.name = Inp;
		}
		////////GETTERS
		public String getNameCinema() {
			return this.name;
		}
		public typeSeat getTypeSeat() {
			return this.TypeSeat;
		}
		
		//##################################################################
		//
		//PART 3: IMPORTANT FUNCTIONS
		/*
			public void runCineplexshowtime(int size) {
				int choice=1;
				do {
					try {
						printmovietitles(size);
						System.out.println("Enter Movie Index to view showtime:");
						System.out.println("Enter 0 to exit:");
						choice=Integer.parseInt(sc.nextLine());
						if(choice ==0)
							break;
						while(choice<1 && choice>size) {
							System.out.println("Invalid Input");
							System.out.println("Enter Movie Index to view showtime:");
							choice=Integer.parseInt(sc.nextLine());
						}
						viewseatings(choice-1);
						
					}
					catch(Exception e) {
						System.out.println("Invalid Input");
					}
				}while(choice!=0);
			}
	*/
			/*
			public void setMovieList(Movie[] list) {
				this.movielist=list;
			}
			*/
			//print only "NOW SHOWING" MOVIE
			/*
			public void printmovietitles(int size) {
				
				for(int x =0; x<size; x++) {
					System.out.println("Movie #" + (x+1) +" "+ movielist[x].getTitle());
				}
				
			}
			*/
			/*
			public void viewseatings(int moviechoice) {
				boolean check=true;
				int sel;
				do {
					try {
					movielist[moviechoice].printShowtime();
					System.out.println("Select Show Time to view Seat's Status");
					System.out.println("Enter 0 to Exit");
					sel=Integer.parseInt(sc.nextLine());
					if(sel==0) {
						System.out.println("Exiting...");
						break;
					}
					if(sel>0 && sel<=movielist[moviechoice].getShowlistSize()) {
						movielist[moviechoice].printSeatStatus(sel-1);
						//checkifbooking(moviechoice,sel-1);
					}
					else
						throw new Exception();
					}
					catch(Exception e) {
						System.out.println("Invalid Input");
					}
				}while(check);
			}
			*/
}
