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


import java.text.DecimalFormat;


public class Pricing {

	//#----------------------
	//Generate relevant variables
	public double generalPrice = 8.5;        //fixed price of movie
	public double changeSenior = -4.5;        //change if senior
	public double changeStudent = -1.5;        //change if student
	public double changeBlockbuster = 1.0;        //change if Blockbuster
	public double rateGST = 1.07;            //fixed rate of GST of 7%
	public double changeNearWeekend = 1.0;        //fixed change rate of near weekend;
	public double changeWeekend = 2.5;        //fixed change rate of weekend
	public double priceWeekend3D;
	public double priceWeekday3D;
	public double rateGold = 1.1;
	public double ratePlatinum = 1.2;            //fixed rate of luxurious class cinema
	public double rateHoliday = 1.5;            //fixed rate of Public Holiday


	//#----------------------
	//Object related

	public void setPricing(double generalprice, double SeniorDis, double StudentDis, double Block, double Gst, double nearweekend, double weekend, double weekend3d,
				   double weekday3d, double rategold, double rateplat, double ratePH){
		this.generalPrice=generalprice;
		this.changeSenior=SeniorDis;
		this.changeStudent=StudentDis;
		this.changeBlockbuster=Block;
		this.rateGST=Gst;
		this.changeNearWeekend=nearweekend;
		this.changeWeekend=weekend;
		this.priceWeekend3D=weekend3d;
		this.priceWeekday3D=weekday3d;
		this.rateGold=rategold;
		this.ratePlatinum=rateplat;
		this.rateHoliday=ratePH;

	}
	/*public void printrate(){
		System.out.println("General"+this.generalPrice);
		System.out.println("Senior Dis"+this.changeSenior);
		System.out.println("Stu Dis"+this.changeStudent);
		System.out.println("blk Dis"+this.changeBlockbuster);
		System.out.println("gstr Dis"+this.rateGST);
		System.out.println("nearweeked Dis"+this.changeNearWeekend);
		System.out.println("weekenm"+this.changeWeekend);
		System.out.println("3de "+this.priceWeekend3D);
		System.out.println("3dd "+this.priceWeekday3D);
		System.out.println("Senior gold "+this.rateGold);
		System.out.println("rate plat "+ this.ratePlatinum);
		System.out.println("Ph rateL " + this.rateHoliday);

	}*/
	//FUNCTION STARTS HERE

	//################################################
	//function to calculate the price of a ticket

	public double priceCalc(int ageGoer, Showtime showtime) {
		//things to take into account

		double totalPrice = 0.0;
		if (showtime.get3D()) {//3D films has seperate rates of price
			// check if movie on the Fri-sun
			if (showtime.getDayofWeek() > 4)
				totalPrice = priceWeekend3D;
			else {
				totalPrice = priceWeekday3D;
				// check if moviegoer is a student;
				if (ageGoer <= 18)
					totalPrice += changeStudent;
			}
		} else {
			totalPrice = generalPrice;
			if (ageGoer >= 55) totalPrice += changeSenior;            //change for Senior
			if (ageGoer <= 18) totalPrice += changeStudent;            //change for Student
			// check if dayofweek = thurs = 4
			if (showtime.getDayofWeek() == 4) totalPrice += changeNearWeekend;            //change for weekend days
			// check if dayofweek = fri n before 1800
			if (showtime.getDayofWeek() == 5 && showtime.getHour() < 18) totalPrice += changeNearWeekend;    //
			// check if dayofweek = fri n after 1800
			if (showtime.getDayofWeek() == 5 && showtime.getHour() >= 18) totalPrice += changeWeekend;    //
			//heck if dayof week = sat/sun
			if (showtime.getDayofWeek() == 6 || showtime.getDayofWeek() == 7) totalPrice += changeWeekend;    //
		}

		if (showtime.getMovieisBlock()) totalPrice += changeBlockbuster;        //increase 1$ if being blockbuster
		// check what cinema class it is
		if (showtime.getCinemaType() == CinemaType.GOLD) totalPrice *= rateGold;
		if (showtime.getCinemaType() == CinemaType.PLATINUM) totalPrice *= ratePlatinum;
		// check if its on a public holiday
		if(showtime.getisPH()) totalPrice *= rateHoliday;

		totalPrice *= rateGST;
		totalPrice = Math.round(totalPrice*100)/100.0;

		return totalPrice;//GST constant rate
	}

}
		
	//################################################






