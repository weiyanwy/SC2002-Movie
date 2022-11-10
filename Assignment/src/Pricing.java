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
			totalPrice += priceCalc(Inp, showtime);
		}	
				
	}
	public int calcDayinYear(int day, int month, int year){
		//denoting the day of edit: 11/10/2022 (THU) and consider it as milestone of calculation
		//assuming all data input needs to be more than 11/10/2022
		//leap year = year%4 ==0
		//denoting return code
		//SAT = 0, SUN =1, MON = 2, TUE =3
		//WED = 4, THU = 5, FRI = 6
		int code, totalGap=0, i;
		
		int dayInMonth[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		if(year>2022){
		for(i = 2022;i<(year-1);i++{
			if((year%4)==0) totalGap += 366;
			else totalGap += 365;
		}
		for(i=0;i<(month-1);i++){
			totalGap+= dayInMonth[i];
			if(i==3 && (year%4)==0) totalGap+=1; //if the date surpass Feb on leap year 
		}
		totalGap += day;
		}
		if(year ==2022){
			if(month==11) totalGap += (day-11);
			if(month==12) totalGap = totalGap + (30-11) + day;
		}
		
		code = totalGap%7;
		return code;
	}
	//##############################################	
	public double priceCalc(int ageGoer, Showtime showtime){
		//things to take into account
		
		int day,month, year, code;
		DayOfWeek day;
		day = showtime.day;
		month = showtime.month;
		year = showtime.year;
		code = calcDayinYear(day,month,year);
		
		if(code==0) day = DayOfWeek.SAT;
		if(code==1) day = DayOfWeek.SUN;
		if(code==2) day = DayOfWeek.MON;
		if(code==3) day = DayOfWeek.TUE;
		if(code==4) day = DayOfWeek.WED;
		if(code==5) day = DayOfWeek.THU;
		if(code==6) day = DayOfWeek.FRI;
		
		double totalPrice = 0.0;
		if(is3D){								//3D films has seperate rates of price
			totalPrice = 9.00;
			if(day == DayOfWeek.MON || day == DayOfWeek.TUE || day == DayOfWeek.WED || day == DayOfWeek.THU)
				totalPrice = 11.00;
			if(day == DayOfWeek.FRI || day == DayOfWeek.SAT || day == DayOfWeek.SUN) totalPrice = 15.00;
		} else{
			totalPrice = generalPrice;
			if(ageGoer>=55) totalPrice += changeSenior;			//change for Senior
			if(ageGoer<=18) totalPrice += changeStudent;			//change for Student
			if(day == DayOfWeek.THU) totalPrice += changeNearWeekend;			//change for weekend days
			if(day == DayOfWeek.FRI && hour <18) totalPrice += changeNearWeekend;	//
			if(day == DayOfWeek.FRI && hour >=18) totalPrice += changeWeekend;	//
			if(day == DayOfWeek.SAT || day == DayOfWeek.SUN) totalPrice += changeWeekend;	// 
		}
		
		if(isBlock) totalPrice += this.changeBlockbuster;		//increase 1$ if being blockbuster
		
		totalPrice *= rateGST;					//GST constant rate

	}
		return totalPrice;
		
	//################################################
}}




