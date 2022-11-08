

public class SeatLayout {

	private int row;
	private int col;
	private Seat[][] seats;

	public SeatLayout(int row, int col, Seat[][] seats){
		this.row= row;
		this.col=col;
		this.seats=seats;
	}
	public void updateSeatsStatus(Seat[][] seats){
		this.seats=seats;
	}
	public Seat[][] getSeats(){
		return this.seats;
	}
	public int getRow(){
		return this.row;
	}
	public int getCol(){
		return this.col;
	}
}
