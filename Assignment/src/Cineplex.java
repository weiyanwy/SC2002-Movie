package MovieApp;

/*
 * Title: Cineplex
 * Use: Object Cineplex which is the biggest structure of all
 * ---------------------------------------
 */
import java.util.Scanner;

public class Cineplex {
	//#################################################################
	//
	//PART 1: INITIALIZE RELEVANT VARIABLES
	//
	//1.1: Initialize objects init
	Scanner sc = new Scanner(System.in);
	public String name;							//name of cineplex
	public Cinema[] cinemaList;					//list of cinemas within the cineplex
	
	//#################################################################
	//
	//PART 2: CONSTRUCTORS OF THE CLASS
	
	public String getName() {
		return this.name;
	}
	public void setName() {
		String Inp;
		System.out.println("Set name for this Cineplex: ");
		Inp = sc.nextLine();
		this.name = Inp;
	}
	//##################################################################
	//
	//PART 3: FUNCTIONS
	
	
	
}
