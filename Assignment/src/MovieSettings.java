import java.util.Scanner;

public class MovieSettings {
		private int Size; // Size of content in movielist
		private Movie[] MovieList= new Movie[30]; //Create tempList to store and return
		Scanner sc = new Scanner(System.in);
		Display UI = new Display(); //display UI messages
		enum status {ComingSoon, Preview, NowShowing, EndofShowing};
		int choice;
		//UI.staffdisplay();
	public Movie[] runmoviesetting(Movie[] movielist, int size) {
			this.MovieList=movielist;
			this.Size=size;
		do {
			try {
			UI.moviesettingdisplay();
		
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
				case(1):
					System.out.println("*****Create Movie******");
					this.MovieList[Size]= CreateMovie(); //run create movie method
					Size= Size+1; //increment movielist size
					sortMovie(); //Show movie by status
					break;
				case(2):
					UpdateMovie();
					break;
				case(3):
					System.out.println("Remove Movie");
					RemoveMovie();
					break;
				case(4):
					System.out.println("Change movie Ranking");
					MovieRanking();
					break;
				case(0):
					System.out.println("Exit Movie Settings");
					choice =0;
					break;
			default:
					System.out.println("Invalid Choice");
				
			}
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
				choice=1;
			}

		}while(choice!=0);
		
		return this.MovieList;

	}
	public int returnlistsize() {
		return this.Size;
	}

	public Movie CreateMovie() {
		Movie temp= new Movie();
		String Input;
		int a;
		float b;
		System.out.println("Enter Title:");
		temp.assignTitle(Input=sc.nextLine());
		//System.out.println("Enter Movie Show Status (Now Showing, Coming Soon, TBC)");
		//temp.assignStatus(Input=sc.nextLine());
		//System.out.println("Enter Movie Description: ");
		//temp.assignSyn(Input=sc.nextLine());
		//System.out.println("Enter Movie Director: ");
		//temp.assignDirect(Input=sc.nextLine());
		//System.out.println("Enter Movie Main Cast: ");
		//temp.assignCast(Input=sc.nextLine());
		//System.out.println("Enter Movie Restriction (PG13,NC16,M18,TBC):"); -edit to enum
		//temp.assignRestrict(Input=sc.nextLine());
		//System.out.println("Enter Movie Genre:");
		//temp.assignGenre(Input=sc.nextLine());
		//System.out.println("Enter Movie Run time");
		//temp.assignRuntime(Input=sc.nextLine());
		//System.out.println("Enter Movie total votes");
		//temp.assignVotes(a=sc.nextInt());
		//System.out.println("Enter Movie Rating");
		//temp.assignRate(b=sc.nextFloat());
		//System.out.println("Enter Movie Sales");
		//temp.assignSales(a=sc.nextInt());
		return temp;
	}
	//Sort movie by status NowShowing, End of Show,Preview, Coming Soon)
	public void sortMovie(){
		Movie temp;
		for(int i=1; i<Size; i++)
		{
			for(int j=i; j>0; j--)
			{
				if(checkprority(MovieList[j])> checkprority(MovieList[j-1]))
				{
					//check element right is smaller than left
					temp = MovieList[j];
					MovieList[j] = MovieList[j-1];
					MovieList[j-1] = temp;
				}
				else
					break;
			}
		}
	}
	//assign priority to Now showing, preview, coming soon, end of show
	public int checkprority(Movie movie){
		if(movie.getstatus().equals(status.NowShowing))
			return 4;
		else if(movie.getstatus().equals(status.Preview))
			return 3;
		else if(movie.getstatus().equals(status.ComingSoon))
			return 2;
		else
			return 1;
	}
	public void UpdateMovie(){
		int choice, sel, updateInt;
		float updatefloat;
		String updates;
		
		printmovietitle();
		
		System.out.println("Select Movie to update: ");
		sel=Integer.parseInt(sc.nextLine());
		
		while(sel>this.Size) {
			System.out.println("Invalid Input");
			System.out.println("Select Movie to update: ");
			sel=Integer.parseInt(sc.nextLine());
		}
		sel=sel-1;
		do {
			System.out.println("Movie " + MovieList[sel].getTitle()+ " selected");
			UI.updatedisplay();
			//System.out.println("Enter Choice: ");
			choice = Integer.parseInt(sc.nextLine());
			if(0<choice && choice<11)
				System.out.println("Enter new updates: ");
			//updates=sc.nextLine();// check input

			switch(choice) {

				case (1):
					MovieList[sel].assignTitle(updates=sc.nextLine());
					break;
				case (2):

					MovieList[sel].assignSyn(updates=sc.nextLine());
					break;
				case (3):

					MovieList[sel].assignDirect(updates=sc.nextLine());
					break;
				case (4):

					MovieList[sel].assignCast(updates=sc.nextLine());
					break;
				case (5):

					MovieList[sel].assignGenre(updates=sc.nextLine());
					break;
				case (6):

					MovieList[sel].assignRestrict(updates=sc.nextLine());
					break;
				case (7):

					MovieList[sel].assignRuntime(updates=sc.nextLine());
					break;
				case (8):

					MovieList[sel].assignRate(updatefloat=Float.parseFloat(sc.nextLine()));
					break;
				case (9):
					MovieList[sel].assignVotes(updateInt=Integer.parseInt(sc.nextLine()));
					break;
				case (10):
					MovieList[sel].updateReview(updates=sc.nextLine());
					break;
				case (11):
					choice =0;
					break;
				default:
					choice = 1;
					break;
			}
		}while(choice!=0);

		

	}
	public void printmovietitle() {
		for(int x=0;x<this.Size;x++) {
			System.out.println("Movie #"+(x+1)+" "+MovieList[x].getTitle());
		}
	}

	public int searchMovie(String title) {
		int count=0;
		while(count<this.Size){
			if(this.MovieList[count].getTitle().equalsIgnoreCase(title)){
				return count;
			}
			count++;
		}
		System.out.println("Movie Not Found");
		return -1;
	}
	public void RemoveMovie() {
		String name;
		int remove;
		System.out.println("Enter Movie name to be removed:");
		remove=searchMovie(name=sc.nextLine());
		if(remove<0)
			System.out.println("Removal was Unsuccessful");
		else{
			for(int loop=remove; loop<this.Size; loop++){
				//shift all elements forward
				this.MovieList[loop] = this.MovieList[loop+1];
			}
			System.out.println("Removal was Successful");
			this.Size--;
		}
	}
	public void MovieRanking() {
		Movie temp1;
		
		//copy the content of the original Seat to tempSeat
		//Sort TOP 5 rating
	
		System.out.println("Before");
		for(int a=0; a<Size; a++) {
			System.out.println(MovieList[a].getTitle() + " rating" + MovieList[a].getRating() );
		}
		
		for(int i=1; i<Size; i++)
		{
			for(int j=i; j>0; j--)
			{
				if(MovieList[j].getRating() > MovieList[j-1].getRating())
				{
					//check element right is smaller than left
					temp1 = MovieList[j];
					MovieList[j] = MovieList[j-1];
					MovieList[j-1] = temp1;
				}
				else
					break;
			}
		}
		System.out.println("After");
		for(int a=0; a<Size; a++) {
			System.out.println(MovieList[a].getTitle() + " rating" + MovieList[a].getRating() );
		}
		
		
	}
}
