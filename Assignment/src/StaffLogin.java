import java.util.Scanner;

public class StaffLogin {
	private  final String Username= "1";
	private  final String Password="1";
	private String TempUser;
	private String TempPass;
	StaffMode staff= new StaffMode();

	public boolean run() {
		Scanner sc = new Scanner(System.in);
		StaffLogin Login = new StaffLogin();
		System.out.println("*****STAFF LOGIN*****");
		String input;
		System.out.println("Enter Username: ");
		Login.InputUser(input= sc.nextLine());
		System.out.println("Enter Password: ");
		Login.InputPass(input=sc.nextLine());
		if(Login.CheckLogin()) {
			return true;
		}
		else {
			return false;
		}
	}
	public void InputUser(String User) {
		this.TempUser=User;
	}
	public void InputPass(String Pass) {
		this.TempPass=Pass;
	}
	public boolean CheckLogin() {
		if(TempUser.equals(Username) && TempPass.equals(Password))
			return true;
		else
			return false;
	}
}