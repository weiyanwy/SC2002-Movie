import java.util.ArrayList;  
import java.util.Arrays; 
import java.util.Scanner;
public class StaffMode {
	private int Size;
	private Movie[] MovieList;
	Scanner sc = new Scanner(System.in);
	
	public void Adminmode(Movie[] movielist, int size){
		Display UI = new Display();
		
		int choice = 1;
		//UI.staffdisplay();
		do {
			UI.staffdisplay();
			System.out.print("What is your choice:  ");
			choice = sc.nextInt();
			switch(choice) {
			case(1):
				System.out.println("Create Movie");
				movielist[size]= CreateMovie();
				this.MovieList=movielist;
				size= size+1;
				this.Size=size;
				break;
			case(2):
				System.out.println("Update Movie");
				break;
			case(3):
				System.out.println("Remove Movie");
				break;
			case(4):
				System.out.println("Change movie Ranking");
				break;
			case(5):
				System.out.println("Exit Admin Mode");
				choice =0;
				break;
			default:
				System.out.println("Invalid Choice");
				choice=1;
			
			}
				
		}while(choice != 0);
		
	}
	
	public Movie CreateMovie() {
		Movie temp= new Movie();
		String Input;
		int a;
		float b;
		Input=sc.nextLine(); //clear the previous sc.nextInt.
		System.out.println("Enter Title:");
		temp.assignTitle(Input=sc.nextLine());
		System.out.println("Enter Movie Description: ");
		temp.assignSyn(Input=sc.nextLine());
		System.out.println("Enter Movie Director: ");
		temp.assignDirect(Input=sc.nextLine());
		System.out.println("Enter Movie Main Cast: ");
		temp.assignCast(Input=sc.nextLine());
		System.out.println("Enter Movie Restriction (PG13,NC16,M18,TBC)");
		temp.assignRestrict(Input=sc.nextLine());
		System.out.println("Enter Movie Genre: ");
		temp.assignGenre(Input=sc.nextLine());
		System.out.println("Enter Movie Run time");
		temp.assignRuntime(Input=sc.nextLine());
		System.out.println("Enter Movie total votes");
		temp.assignVotes(a=sc.nextInt());
		System.out.println("Enter Movie Rating");
		temp.assignRate(b=sc.nextFloat());
		System.out.println("Enter Movie Sales");
		temp.assignSales(a=sc.nextInt());
		return temp;
	}
	public void UpdateMovie(){
	}
	public void RemoveMovie() {
		
	}
	public void MovieRanking() {
		
	}
	public Movie[] ReturnList() {
		
		return this.MovieList;
	}
	public int ReturnSize() {
		return this.Size;
	}
}
