import java.util.Scanner;

public class MOBLIMA {
	Display UI = new Display();
	
	public static void main(String[] args) {
		
		#---------------------------------
		#initialisation of needed components
			
		Scanner sc = new Scanner(System.in);
		Display UI = new Display();
		Operation Ops = new Operation();
		Movie movies = new Movie();
		
		int choice = 0; 		//this variable is used to received input from the staff/user
		
		#---------------------------------
			
			
		#---------------------------------
			
		#initialise login mode
		do{
			UI.logindisplay();
			switch(choice){
				case 1:
					break;
				case 2: 
					break;
				case 3:
					break;
				default:
					break;
		do {
			UI.maindisplay();
			System.out.print("What is your choice:  ");
			choice= sc.nextInt();
			switch(choice) {
			case 1:
				Ops.viewMovie();
				break;
			case 2:
				System.out.println("View Show Time and Cinema");
			case 3:
				System.out.println("Order History");
				break;
			case 4:
				Ops.runAdminLogin();
				break;
			case 5:
				System.out.println("Thanks for using MOBLIMA");
				choice =0;
				break;
			default:
				System.out.println("Wrong input");
				break;
			}
		}while(choice!=0);
	}
	
	
}

		









