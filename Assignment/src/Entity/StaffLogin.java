package Entity;
import java.util.Scanner;

public class StaffLogin {
    private String tempuser;
    private String temppass;
    Scanner sc= new Scanner(System.in);
    public boolean runStafflogin() {
        System.out.println("*****STAFF LOGIN*****");
        System.out.println("Enter Username: ");
        InputUser(sc.nextLine());
        System.out.println("Enter Password: ");
        InputPass(sc.nextLine());
        return CheckLogin();
    }
    public void InputUser(String User) {
        this.tempuser=User;
    }
    public void InputPass(String Pass) {
        this.temppass=Pass;
    }
    public boolean CheckLogin() {
        String username = "1";
        String password = "1";
        return this.tempuser.equals(username) && this.temppass.equals(password);
    }
}
