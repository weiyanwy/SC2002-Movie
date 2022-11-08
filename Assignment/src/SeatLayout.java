public class SeatLayout {

import java.util.Scanner;
	
	private Seat[][] layout;
	private int size = 8;
	private int row, column;
	private int totalseats;
	Scanner sc = new Scanner(System.in);
	
	public void SeatsLayout(int row, int column) {
		this.row=size;
		this.column=size;
		//this.totalseats
		layout = new Seat[row][column];
		
		for(int x=0; x< this.row;x++) {
			for(int y=0;y<this.column;y++) {
				layout[x][y]=new Seat();
				layout[x][y].setID(x*10+y+1);				
			}
			
		}
	}
	public void printSeatStatus() {
		String title="[SCREEN]";
		String Status="[SEAT's STATUS]";
		for(int x=0; x< this.row;x++) {
			String S ="";
			for(int y=0;y<this.column;y++) {
				Status = "--" + Status + "--";
				title = "----" + title + "----";
				if(y==0)
					S+="| ";
				if( x==0 && (y==(column/2)))
					System.out.println(Status);
				if(y== (column/2))
					S+="   ";
				S += "[ "+layout[x][y].GetSeatStatus()+" ]";
				
			}
			S+=" |";
			System.out.println(S);
		}
		System.out.println("Legends A: Avaliable, O: Occupied");
	}
	public void printSeatIndex() {
		String title="[SCREEN]";
		for(int x=0; x< this.row;x++) {
			String S ="";
			for(int y=0;y<this.column;y++) {
				title = "----" + title + "----";
				if(y==0)
					S+="| ";
				if( x==0 && (y==(column/2)))
					System.out.println(title);
				if(y== (column/2))
					S+="   ";
				S += "[ "+layout[x][y].getID()+" ]";
		
			}
			S+=" |";
			System.out.println(S);
		}
	}
	public void printlayout() {
		System.out.println("***List seats with index***");
		printSeatIndex();
		System.out.println("***List seats with status***");
		printSeatStatus();
		System.out.println("****************************");
	}
	
	public Seat[][] selectseat(Seat[][] layout, int size) {
		this.layout = layout;
		System.out.println("Select Index of Seat: ");
		boolean check=true;
		do {
			try {
				int choice = Integer.parseInt(sc.nextLine());
				choice--;
				this.layout[(choice/size)][choice%size].SelectSeat();
				printlayout();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
		}while(check);
		return this.layout;
	}
	
	public Seat[][] bookseat(Seat[][] layout, int size) {
		this.layout = layout;
		printlayout();
		this.layout = selectseat(this.layout, size);
		return this.layout ;
	}


}
