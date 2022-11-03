
public class Display {
	
	public void logindisplay(){
		System.out.println("*****WELCOME TO MOBLIMA*****\n");
		System.out.println("\n");
		System.out.println("Please login choosing either of this mode:\n");
		System.out.println("[1] CUSTOMER MODE");
		System.out.println("[2] STAFF MODE");
		System.out.println("[3] EXIT THE APP");
	}
	
	public void maindisplay() {
		System.out.println("*****Welcome*****\n"+
				"*******TO********\n"+
				"*****MOBILMA*****");
		System.out.println("1: View Movie Listing");
		System.out.println("2: View Show Time and Cinema");
		System.out.println("3: View Order History");
		System.out.println("4: Staff Login");
		System.out.println("5: Exit Application");
	}
	public void staffdisplay() {
		System.out.println("*****ADMIN MODE*****");
		System.out.println("1: Create Movie Listing");
		System.out.println("2: Update Movie Listing");
		System.out.println("3: Remove Movie Listing");
		System.out.println("4: Change Movie Ranking");
		System.out.println("5: Exit Admin Mode");
	}
	public void updatedisplay() {
		System.out.println("*****UPDATE MOVIE*****");
		System.out.println("1: Title");
		System.out.println("2: Synopsis");
		System.out.println("3: Director");
		System.out.println("4: Cast");
		System.out.println("5: Genre");
		System.out.println("6: Movie Restriciton");
		System.out.println("7: Movie Run time");
		System.out.println("8: Movie Rating");
		System.out.println("9: Movie Votes");
		System.out.println("10: Exit");
	}
}
