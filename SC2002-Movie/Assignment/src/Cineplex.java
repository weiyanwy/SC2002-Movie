import java.util.Scanner;
public class Cineplex {
	private String name;
	private Movie[] movielist;
	Scanner sc = new Scanner(System.in);
	public void setmovielist(Movie[] list) {
		this.movielist=list;
	}
	public void setname(String name) {
		this.name=name;
	}
	public String getname() {
		return this.name;
	}
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
	public void printmovietitles(int size) {
		
		for(int x =0; x<size; x++) {
			System.out.println("Movie #" + (x+1) +" "+ movielist[x].getTitle());
		}
		
	}
	public void viewseatings(int choice) {
		boolean check=true;
		int sel;
		do {
			try {
			movielist[choice].printShowtime();
			System.out.println("Select Show Time to view Seat's Status");
			System.out.println("Enter 0 to Exit");
			sel=Integer.parseInt(sc.nextLine());
			if(sel==0) {
				System.out.println("Exiting...");
				break;
			}
			if(sel>0 && sel<=movielist[choice].getShowlistSize()) {
				movielist[choice].printSeatStatus(sel-1);
			}
			else
				throw new Exception();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
		}while(check);
	}
	
	public void checkifbooking(int choice) {
		int sel=1;
		do {
			try {
				System.out.println("Do you want to book?");
				System.out.println("1: Book Tickets");
				System.out.println("2: Exit");
				sel=Integer.parseInt(sc.nextLine());
				switch(sel) {
				case(1):
					booking();
					break;
				case(2):
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Invalid input");
				}
				}
				catch(Exception e) {
					System.out.println("Invalid Input");
				}
			}while(sel!=2);
		}
		
	public void booking() {
		int sel;
		boolean check=true;
		do {
			try {
				System.out.println("Enter seat Index");
				
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
		}while(check);
	}
}
