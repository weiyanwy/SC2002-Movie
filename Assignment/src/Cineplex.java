

/*
 * Title: Cineplex
 * Use: Object Cineplex which is the biggest structure of all
 * ---------------------------------------
 */


import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable {
	//#################################################################
	//
	//PART 1: INITIALIZE RELEVANT VARIABLES
	//
	//1.1: Initialize objects init
	private ArrayList<Cinema> Cinemalist=new ArrayList<>();

	public String name;							//name of cineplex
											//list of cinemas within the cineplex

	//#################################################################
	//
	//PART 2: CONSTRUCTORS OF THE CLASS
	public void setCineplexname(String name){
		this.name=name;
	}
	public String getCineplexName() {
		return this.name;
	}

	public void assignCinemalist(ArrayList<Cinema> Cinemalist){
		this.Cinemalist=Cinemalist;
	}
	public ArrayList<Cinema> getCinemalist(){
		return this.Cinemalist;
	}


	//##################################################################
	//
	//PART 3: FUNCTIONS
	
	
	
}
