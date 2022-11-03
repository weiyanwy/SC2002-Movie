import java.util.Scanner;
import java.util.*;
public class Operation {

	private Movie[] MovieLists = new Movie[30];
	StaffLogin Staff = new StaffLogin();
	public int Size=0;
	Scanner sc = new Scanner(System.in);

	public void viewMovie() {
		int choice;
		do {
			if(Size>0) {
				int y=0;
				while(y<Size) {
					System.out.println("Movie Title: "+ (y+1) + " " + this.MovieLists[y].getTitle());
					y++;
				}
				System.out.println("Choose which Movie detail you want to see: ");
				System.out.println("Enter 0 to Exit");
				System.out.println("Enter choice: ");
				choice=Integer.parseInt(sc.nextLine());
				if(choice==0)
					break;
				if((choice-1)<Size)
					MovieLists[(choice-1)].rundetails();
			}
			else {
				System.out.println("List is Empty");
				break;
			}

		}while(choice!=0);


	}
	public void runAdminLogin() {
		Staff.run(MovieLists,this.Size);
		this.MovieLists = Staff.returnlist();
		this.Size=Staff.returnSize();

	}
	// search position of movie
	public void SearchMovie() {

		String title;
		int count=0;
		System.out.println("Enter movie title to search: ");

		title=sc.nextLine();
		while(count<this.Size) {
			if(this.MovieLists[count].getTitle().toLowerCase().equals(title.toLowerCase())) {
				System.out.println("Movie Found");
				this.MovieLists[count].rundetails();
				break;
			}
			count++;
		}
		System.out.println("Movie Not Found");
	}
	public void ViewOrderHistory(){
	}



}
