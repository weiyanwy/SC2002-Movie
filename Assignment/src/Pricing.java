/* 
Title: Pricing
Uses: to calculate the price of ticket of a movie

The price of tickets is affected by:
Weekend
Public Holiday
Type of Cinema (Normal -> Luxury)
Type of Movie (2D or 3D, Blockbuster)
Age (Adult, Senior >=55, Kids)
7% GST
-----------------------
Relevant files: Operation
*/

import java.util.Scanner;

public class Pricing{
	
	//#----------------------
	//Generate relevant variables
	public double generalPrice = 8.50;		//fixed price of movie
	public double changeSenior = -4.50;		//change if senior
	public double changeStudent = -1.50;		//change if student
	public double changeBlockbuster = 1.00;		//change if Blockbuster
	public double rateGST = 1.07;			//fixed rate of GST of 7%
	public double changeNearWeekend = 1.00;		//fixed change rate of near weekend;
	public double changeWeekend = 2.50;		//fixed change rate of weekend
	
	public double rateGold = 1.1;
	public double ratePlatinum = 1.2;			//fixed rate of luxurious class cinema
	public double rateHoliday = 1.5;			//fixed rate of Public Holiday
		
	//#----------------------
	//Object related
	Scanner sc = new Scanner(System.in);
	public Showtime showtime = new Showtime();
	public ArrayList<Integer> SelectedSeats;
	//FUNCTION STARTS HERE
	
	public Pricing(Showtime showtime, ArrayList<Integer> SelectedSeats){
		this.showtime = showtime;
		this.SelectedSeats = SelectedSeats;
	}
	
	//################################################
	//function to calculate the price of a ticket
	
	public double PricingUI(){
		int count=0, Inp;
		double totalPrice = 0.0;
		while(i<this.SelectedSeats.size()){
			System.out.println("Indicate the age of the #"+ (i+1) + " ticket holder:");
			Inp = sc.nextInt();
			if(Inp<0){
			System.out.println("Invalid Input, please correct it);
			}
			totalPrice += priceCalc(Inp);
		}	
				
	}
	//##############################################	
	public double priceCalc(int ageGoer){
		//things to take into account
		
		double totalPrice = 0.0;
		if(is3D){								//3D films has seperate rates of price
			totalPrice = 9.00;
			if(day == DAY.MON || day == DAY.TUE || day == DAY.WED || day == DAY.THU)
				totalPrice = 11.00;
			if(day == DAY.FRI || day == DAY.SAT || day ==DAY.SUN) totalPrice = 15.00;
		} else{
			totalPrice = generalPrice;
			if(ageGoer>=55) totalPrice += changeSenior;			//change for Senior
			if(ageGoer<=18) totalPrice += changeStudent;			//change for Student
			if(day == DAY.THU) totalPrice += changeNearWeekend;			//change for weekend days
			if(day == DAY.FRI && hour <18) totalPrice += changeNearWeekend;	//
			if(day == DAY.FRI && hour >=18) totalPrice += changeWeekend;	//
			if(day == DAY.SAT || day == DAY.SUN
			) totalPrice += changeWeekend;	// }
		
		if(isBlock) totalPrice += this.changeBlockbuster;		//increase 1$ if being blockbuster
		
		totalPrice *= rateGST;					//GST constant rate

	}
		return totalPrice;
		
	//################################################
}}




