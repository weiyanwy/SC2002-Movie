import java.util.Scanner;
import java.util.*;
public class Operation {
	
	//#-----------------------------
	//initialisation of relevant things
	private Movie[] MovieLists = new Movie[30];	//List of Movies, imported in arrays
	public int Size=0;

	Pricing price = new Pricing();		//Pricing object
	private Cineplex[] Cineplexlist;			//Cinema list
	private int CineplexSize;				//
	StaffLogin Staff = new StaffLogin();		//Initiate Staff here
	 //Operation Op = new Operation();			//Constructor of Operator
	Scanner sc = new Scanner(System.in);		//Scanner

	String MovieDBaddress = " ";
	String CineplexDBaddress= " ";
	String CinemaDBaddress=" ";
	String ShowtimeDBaddress=" ";
	//#-----------------------------
	int choice = 1;					//dummy variable to insert input

	public void runAdminLogin() {
		Staff.run(MovieLists,this.Size);
	}


	

}
