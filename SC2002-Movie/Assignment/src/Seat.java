
public class Seat {
	private int seatID;
	private boolean IsOccupied;
	private boolean ReserveSeat;
	
	public void setID(int seatID) {
		this.seatID= seatID;
		this.IsOccupied=false;
		this.ReserveSeat=false;
	}
	public int getID() {
		return this.seatID;
	}
	public void BookSeat() {
		this.IsOccupied=true;
	}
	public void SelectSeat() {
		this.ReserveSeat=true;
	}
	public void UnSelectSeat() {
		this.ReserveSeat=false;
	}
	public String GetSeatStatus() {
		if(this.ReserveSeat)
			return "X";
		else {
		if(this.IsOccupied)
			return "O";
		else
			return "A";
	}
	}
}
