import java.io.IOException;
import java.util.Scanner;
import java.util.InputMismatchException;
public class MOBLIMA {
	//////////////////////////////////////////
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// PART 1: INITIALIZE VARIABLES
		// initialization of relevant objects

		Display UI = new Display();
		Scanner sc = new Scanner(System.in);				//scanner
		int cineplexSize = 0;
		Pricing ticketCalculator = new Pricing();			//ticket calculator
		StaffLogin Login = new StaffLogin();
		StaffMode Staff = new StaffMode();
		CustMode cust = new CustMode();
		int choice;									
		//SystemConfig config= new SystemConfig();
		//+----------------------------------
			
		////////////////////////////////////////
		// PART 2: FUNCTIONS IN LOGIN
		//
		//WHILE IN SYSTEM:
		//Step 1: Login Display
		//Step 2: Choose login as CUSTOMER/ STAFF
			
		///////STEP 1////////////////
		UI.loginDisplay();
		
		//////STEP 2/////////////////
		choice = Integer.parseInt(sc.nextLine());
		while(true){
		switch(choice){
		case 1:										//login as customer
		System.out.println("*****Login as CUSTOMER*****");
		cust.CustomerMode();
		break;
		case 2:									//login as staff
		System.out.println("*****Login as STAFF*****");
		if(Login.run()) {
			Staff.Adminmode();
		}
		else System.out.println("***Login failed***");
		break;

		}
	}
	}
}





		









