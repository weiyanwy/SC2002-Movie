package Entity;

import java.io.Serializable;
import Controller.*;
import Settings.*;

public class Seat implements Serializable {
	
	private int seatID;
	private boolean IsOccupied;
	
	public void setID(int seatID) {
		this.seatID= seatID;
		this.IsOccupied=false;
	}
	public boolean isOccupied(){
		return this.IsOccupied;
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
