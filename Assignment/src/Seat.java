
public class Seat {
	private int seatID;
	private boolean IsOccupied;
	private SeatType type;
	enum SeatType{
		Standard,
		Luxury
	}
	
	public void setID(int seatID) {
		this.seatID= seatID;
		this.IsOccupied=false;
		SetSeatStandard();

	}
	public void SetSeatStandard(){
		this.type=SeatType.Standard;
	}
	public void SetSeatLux(){
		this.type=SeatType.Luxury;
	}
	public int getID() {
		return this.seatID;
	}
	public void SelectSeat() {
		this.IsOccupied=true;
	}
	public void UnSelectSeat() {
		this.IsOccupied=false;
	}
	public String GetSeatStatus() {
		if(this.IsOccupied)
			return "O";
		else
			return "A";
	}
}
