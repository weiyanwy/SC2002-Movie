

/*
 * Title: Cineplex
 * Use: Object Cineplex which is the biggest structure of all
 * ---------------------------------------
 */


public class Cineplex {
	//#################################################################
	//
	//PART 1: INITIALIZE RELEVANT VARIABLES
	//
	//1.1: Initialize objects init
	private Cinema[] Cinemalist= new Cinema[3];
	private int Cinemalistsize=0;
	public String name;							//name of cineplex
											//list of cinemas within the cineplex

	//#################################################################
	//
	//PART 2: CONSTRUCTORS OF THE CLASS
	public Cineplex(String name){
		this.name=name;
	}
	public String getCineplexName() {
		return this.name;
	}

	public void assignCinemalist(Cinema[] Cinemalist){
		this.Cinemalist=Cinemalist;
	}
	public void assigneCinematlistsize(int Size){
		this.Cinemalistsize=Size;
	}
	public Cinema[] getCinemalist(){

		return this.Cinemalist;
	}
	public int getCinemalistsize(){
		return this.Cinemalistsize;
	}

	//##################################################################
	//
	//PART 3: FUNCTIONS
	
	
	
}
