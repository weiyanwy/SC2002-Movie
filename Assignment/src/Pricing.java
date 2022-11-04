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
	
	//#----------------------
	//Generate relevant variables
	public double generalPrice = 8.50;		//fixed price of movie
	public double changeSenior = -4.50;		//change if senior
	public double changeStudent = -1.50;		//change if student
	public double changeBlockbuster = 1.00;		//change if Blockbuster
	public double rateGST = 1.07;			//fixed rate of GST of 7%
	public double changeNearWeekend = 1.00;		//fixed change rate of near weekend;
	public double changeWeekend = 2.50;		//fixed change rate of weekend
	
	enum DAY {MON, TUE, WED, THU, FRI, SAT, SUN}	//days in a week
	
	public double rateLuxury = 1.2;			//fixed rate of luxurious class cinema
	public double rateHoliday = 1.5;			//fixed rate of Public Holiday
		
	//#----------------------
	//FUNCTION STARTS HERE
	
	//################################################
	//function to calculate the price of a ticket
		
	public double priceCalc(int ageGoer, DAY day, int hour, boolean isBlock, boolean is3D, boolean isLuxury){
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
		
		if(isLuxury) totalPrice *= rateLuxury;			//if chosen Luxury seats
		
		if(isBlock) totalPrice += this.changeBlockbuster;		//increase 1$ if being blockbuster
		
		totalPrice *= rateGST;					//GST constant rate

	}
		return totalPrice;
		
	//################################################
}}




