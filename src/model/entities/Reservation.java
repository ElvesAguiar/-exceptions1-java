package model.entities;

import java.util.Date;

public class Reservation {
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer duration() {
		return null;
	}

	public void updateDates(Date checkin, Date checkout) {

	}

}
