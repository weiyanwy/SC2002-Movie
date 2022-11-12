package Entity;

import java.io.Serializable;
import Controller.*;
import Settings.*;

public class SeatLayout implements Serializable {

	private int row;
	private int col;
	private Seat[][] seats;

	public void setSeatLayout(int row, int col, Seat[][] seats){
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
