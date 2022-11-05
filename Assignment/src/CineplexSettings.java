package MovieApp;
/*
 * Title: CineplexSettings
 * Use: Provide 3 functions to be used, which are
 * Create Cineplex
 * Remove Cineplex
 * Update Cineplex (in other words fix the cinemas)
 */
import java.util.Scanner;

public class CineplexSettings {
	//#################################################################
	//
	//PART 1: INITIALIZE RELEVANT VARIABLES
	//
	//1.1: Initialize objects init
	Display UI = new Display();
	Scanner sc = new Scanner(System.in);
	
	public Cineplex[] CineplexList = new Cineplex[5];
	public int plexSize = 0;
	
	//#################################################################
	//
	//PART 2: CONSTRUCTORS OF THE CLASS
	
	//##################################################################
	//
	//PART 3: FUNCTIONS
	//-----------------------------------------
	////CREATE CINEPLEX
	public Cineplex createCineplex() {
		Cineplex temp = new Cineplex();
		//insert functions in here
		CineplexList[plexSize] = temp;
		plexSize++;
		return temp;
	}
	
	//-----------------------------------------
	//REMOVE CINEPLEX
	//SEARCH FIRST
	public int searchCineplex(String plexName) {
		int count=0;
		while(count<this.plexSize){
			if(this.CineplexList[count].getName().equalsIgnoreCase(plexName)){
				return count;
			}
			count++;
		}
		System.out.println("Movie Not Found");
		return -1;
	}

	
	//THEN DELETE
	public void RemoveCineplex() {
		String name;
		int remove;
		System.out.println("Enter Movie name to be removed:");
		remove=searchCineplex(name=sc.nextLine());
		if(remove<0)
			System.out.println("Removal was Unsuccessful");
		else{
			for(int loop=remove; loop<this.plexSize; loop++){
				//shift all elements forward
				this.CineplexList[loop] = this.CineplexList[loop+1];
			}
			System.out.println("Removal was Successful");
			this.plexSize--;
		}
	}
	
	
	//-----------------------------------------
	//UPDATE CINEPLEX
	
}
