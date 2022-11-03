import java.util.Scanner;

public class SeatsLayOut {
	
	private Seat[][] layout;
	private int row, column;
	private int totalseats;
	Scanner sc = new Scanner(System.in);
	
	public void run(){
		
	System.out.println("Set Layout");
	System.out.println("Enter no. row");
	int b = Integer.parseInt(sc.nextLine());
	System.out.println("Enter no. col");
	int c = Integer.parseInt(sc.nextLine());
	SeatsLayout(b,c);
	//printlayout();
	//selectseat();
	
	}
	
	
	public void SeatsLayout(int row, int column) {
		this.row=row;
		this.column=column;
		//this.totalseats
		layout = new Seat[row][column];
		
		for(int x=0; x< this.row;x++) {
			for(int y=0;y<this.column;y++) {
				layout[x][y]=new Seat();
				layout[x][y].setID(((x+1)*10)+y);				
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
		printSeatIndex();
		printSeatStatus();
	}
	
	public void selectseat() {
		int[] storeselect;
		int count;
		System.out.println("Select Index of Seat");
		boolean check=true;
		do {
			try {
				int choice = Integer.parseInt(sc.nextLine());
				this.layout[(choice/10)-1][choice%10].SelectSeat();
				printlayout();
			}
			catch(Exception e) {
				System.out.println("Invalid Input");
			}
		}while(check);
	}
	
	public void bookseat(int[] selectedseats, int no_seatselect) {
		
	}
}
