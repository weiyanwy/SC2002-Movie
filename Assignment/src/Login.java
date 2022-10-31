////This file will run the overall login mode for
////both customers and staffs

////
import java.util.Scanner;

public class Login{
    public void main(String[] args){
        #-------------------------------------------------
        
        #initialization of scanner and relating variables
        Scanner sc = new Scanner(System.in);
        
        #-------------------------------------------------
        
        #first interfacing of the app
       
        System.out.println("############################\n");
        System.out.println("Welcome to MOBLIMA\n");
        System.out.println("Please choose mode of login");
        System.out.println("[1] Login as STAFF");
        System.out.println("[2] Login as CUSTOMER");
        System.out.println("############################\n");
        
        #-------------------------------------------------
        
        #user input to access either staff mode or customer mode
        int choice = 0;
        choice = sc.nextInt();
        switch(choice){
            case 1:
                System.out.println("Signing in as STAFF");
                /*
                insert your code here to import StaffLogin
                */
                break;
            case 2:
                System.out.println("Signing in as CUSTOMER");
                /*
                insert you code here to import Customer Interface
                */
                break;
        }
        
        #---------------------------------------------------
    }
}
