/* 
Title: Pricing
Uses: to calculate the price of ticket of a movie

The price of tickets is affected by:
Weekend (denoting Fri, Sat, Sun)
Public Holiday
Type of Cinema (Economic -> Normal -> Luxury)
Type of Movie (2D or 3D, Blockbuster)
Age (Adult, Senior >=55, Kids)
7% GST
-----------------------
Relevant files: Operation
*/

public class Pricing{
	
	#----------------------
	//Generate relevant variables
	public int generalPrice = 10; 		//fixed price of movie
	public float rateGST = 1.07;		//fixed rate of GST of 7%
	public float rateWeekend = 1.1;		//fixed rate of weekend;
	public float rateEconomic = 0.9;	//fixed rate of economic cinema
	public float rateNormal = 1.0;		//fixed rate of normal cinema
	public float rateLuxury = 1.2;		//fixed rate of luxurious class cinema
	public float rateHoliday = 1.5;		//fixed rate of Public Holiday
		
	#----------------------
	//FUNCTION STARTS HERE
	
	################################################
	//function to calculate the price of a ticket
		
	public float priceCalc(boolean isWeekend, int class, boolean isHoliday){
		float price = generalPrice;
		price *= rateGST;							//multiplied by GST
		if(isWeekend) price *= rateWeekend;					//multiplied if day in weekend
		if(class == 0) price *= rateEconomic;					//multiplied if chosen Economic
		if(class == 1) price *= rateNormal;					//multiplied if chosen Normal
		if(class == 2) price *= rateLuxury;					//multiplied if chosen Luxury
		if(isHoliday) price *= rateHoliday;					//multiplied if day is holiday
		
		return price;
	}
	
	################################################
}




