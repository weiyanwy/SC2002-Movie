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

public class Pricing{
	
	#----------------------
	//Generate relevant variables
	public float generalPrice = 8.50;		//fixed price of movie
	public float changeSenior = -4.50;		//change if senior
	public float changeStudent = -1.50;		//change if student
	public float changeBlockbuster = 1.00;		//change if Blockbuster
	public float rateGST = 1.07;			//fixed rate of GST of 7%
	public float changeNearWeekend = 1.00;		//fixed change rate of near weekend;
	public float changeWeekend = 2.50;		//fixed change rate of weekend
	
	enum DAY {MON, TUE, WED, THU, FRI, SAT, SUN}	//days in a week
	
	public float rateLuxury = 1.2;			//fixed rate of luxurious class cinema
	public float rateHoliday = 1.5;			//fixed rate of Public Holiday
		
	#----------------------
	//FUNCTION STARTS HERE
	
	################################################
	//function to calculate the price of a ticket
		
	public float priceCalc(int ageGoer, DAY day, int hour, boolean isBlock, boolean is3D, boolean isLuxury){
		float totalPrice = 0.0;
		if(is3D){								//3D films has seperate rates of price
			totalPrice = 9.00;
			if(day == MON || day == TUE || day == WED || day == THU) totalPrice = 11.00;
			if(day == FRI || day == SAT || day ==SUN) totalPrice = 15.00;
		} else{
			totalPrice = generalPrice;
			if(ageGoer>=55) totalPrice += changeSenior;			//change for Senior
			if(ageGoer<=18) totalPrice += changeStudent;			//change for Student
			if(day == THU) totalPrice += changeNearWeekend;			//change for weekend days
			if(day == FRI && hour <18) totalPrice += changeNearWeekend;	//
			if(day == FRI && hour >=18) totalPrice += changeWeekend;	//
			if(day == SAT || day == SUN) totalPrice += changeWeekend;	//
		}
		
		if(isLuxury) totalPrice *= rateLuxury;			//if chosen Luxury seats
		
		if(isBlock) totalPrice += changBlockbuster;		//increase 1$ if being blockbuster
		
		price *= rateGST;					//GST constant rate
		return totalPrice;
	}
		
	################################################
}




