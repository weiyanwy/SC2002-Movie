
public class Display {
	
	public void loginDisplay(){
		System.out.println("####WELCOME TO MOBLIMA####\n");
		System.out.println("\n");
		System.out.println("Please choose number as mode of login\n");
		System.out.println("[1] Login as STAFF\n");
		System.out.println("[2] Login as CUSTOMER\n");
		System.out.println("\n");
	}

	public void Customerdisplay() {
		System.out.println("Current mode: CUSTOMER");
		System.out.println("\n");
		System.out.println("*****Welcome*****\n"+
				"*******TO********\n"+
				"*****MOBILMA*****");
		System.out.println("1: View Movie Listing");
		System.out.println("2: Search Movie");
		System.out.println("3: View Show Time and Cinema");
		System.out.println("4: View Order History");
		System.out.println("5: Exit Application");
		System.out.println("Enter Choice:");
	}
	public void staffdisplay() {
		System.out.println("*******ADMIN MODE*******");
		System.out.println("1: Movie Settings");
		System.out.println("2: Cinema Settings");
		System.out.println("0: Exit Admin Mode");
		System.out.println("Enter Choice:");
	}
	public void moviesettingdisplay() {
		System.out.println("******MOVIE SETTINGS*****");
		System.out.println("1: Create Movie");
		System.out.println("2: Update Movie");
		System.out.println("3: Remove Movie");
		System.out.println("4: Adjust Ranking");
		System.out.println("0: Exit");
		System.out.println("Enter Choice:");
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
		System.out.println("10: Reviews");
		System.out.println("11: Exit");
		System.out.println("Enter Choice:");
	}
	
	public void CinemaSettingdisplay() {
		System.out.println("*****SYSTEM CONFIGURATION*****");
		System.out.println("1: Create Cinema");
		System.out.println("2: Update Cinema");
		System.out.println("3: Remove Cinema");
		System.out.println("0: Exit");
		System.out.println("Enter Choice:");
	}
	
	public void cinemaupdatedisplay() {
		System.out.println("*****CINEMA UPDATE*****");
		System.out.println("1: Add Show Time and layout");
		System.out.println("2: Update Show time");
		System.out.println("3: Update Layout");
		System.out.println("4: Delete Showtime");
		System.out.println("0: Exit");
		System.out.println("Enter Choice:");
	}
}
