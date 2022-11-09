

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class StaffMode {

	//######## Create CINEPLEX SETTING CLASS
	CineplexSetting CineplexSet= new CineplexSetting();
	MovieSettings movieset = new MovieSettings();
	Scanner sc = new Scanner(System.in);
	Display UI = new Display(); //display UI messages


	public void Adminmode() throws IOException, ClassNotFoundException {

		String MovieDBAddress = " "; // add address
		String CinemaDBAddress = " ";

		int choice;
		//UI.staffdisplay();
		do {
			UI.staffdisplay();
			//System.out.print("What is your choice:  ");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice) {
				case(1):
					movieset.runMovieSetting();
					break;
				case(2):
					CineplexSet.runCineplexSetting();

					break;
				case(0):
					System.out.println("Exit Admin Mode");
					choice =0;
					break;
				default:
					System.out.println("Invalid Choice");
					choice=1;

			}

		}while(choice != 0);

	}

}

