import java.util.Scanner;
public class Operation {
	
	private Movie[] MovieLists = new Movie[30];
	public int Size=0;
	Scanner sc = new Scanner(System.in);
	//public Operation() {
	//	this.MovieLists = new Movie[30];
	//	for(int y=0; y<30; y++) {
	//		this.MovieLists[y] = new Movie(); 
	

	//}
	
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
				choice=sc.nextInt();
				if(choice==0)
					break;
				if(choice<Size)
					Moviedetails(MovieLists[choice-1]);
			}
			else {
				System.out.println("List is Empty");
				break;
			}
			
		}while(choice!=0);
	
		
	}
	public void runAdminLogin() {
		StaffLogin Staff = new StaffLogin();
		Staff.run(MovieLists,this.Size);
		this.MovieLists = Staff.returnlist();
		this.Size=Staff.returnSize();
		
	}
	public void SearchMovie() {
		
	}
	public void ViewOrderHistory(){
	}
	
	public void Moviedetails(Movie data) {
		System.out.println("Title: "+ data.getTitle());
		System.out.println("Synopsis "+data.getSynopsis());
		System.out.println("Director "+data.getDirector());
		System.out.println("Main Cast "+data.getCast());
		System.out.println("Movie rating "+data.getRating());
		System.out.println("Movie Restriction "+data.getMovieRest());
		// get reviews
		
	}
	
}


