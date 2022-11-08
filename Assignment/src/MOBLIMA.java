import java.util.Scanner;
import java.util.InputMismatchException;
public class MOBLIMA {
	//////////////////////////////////////////
		// PART 1: INITIALIZE VARIABLES
		// initialization of relevant objects
		Display UI = new Display();
		Scanner sc = new Scanner(System.in);				//scanner
		Operation Ops = new Operation();					//maybe delete
		Movie[] movies = new Movie[30];						//list of movie
		int movieSize = 0;
		Cineplex[] cineplex = new Cineplex[3];				//list of cineplex
		int cineplexSize = 0;
		Pricing ticketCalculator = new Pricing();			//ticket calculator
		
		StaffLogin Login = new StaffLogin();
		StaffMode Staff = new StaffMode();
		
		CustMode cust = new CustMode();
		int choice;											//user input
		//SystemConfig config= new SystemConfig();
		//create array of Movie to store
		//+----------------------------------
			
		////////////////////////////////////////
		// PART 2: FUNCTIONS IN LOGIN
		//
		//WHILE IN SYSTEM:
		//Step 1: Login Display
		//Step 2: Choose login as CUSTOMER/ STAFF
		while(true){
			
		///////STEP 1////////////////
		UI.loginDisplay();
		
		//////STEP 2/////////////////
		choice = Integer.parseInt(sc.nextLine());
		
		switch(choice){
		case 1:										//login as customer
		System.out.println("*****Login as CUSTOMER*****");
		//##############################################################
		cust.CustomerMode(movies, movieSize);
		break;
		//##################################################################
		case 2:									//login as staff
		System.out.println("*****Login as STAFF*****");
		if(Login.run(movies, movieSize)) {
			Staff.Adminmode(movies, movieSize);
		}
		else System.out.println("***Login failed***");
		break;

		}
	}
	}
	
	//#################################

}





		









