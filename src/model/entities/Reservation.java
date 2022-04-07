package model.entities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public static final Calendar cal = new Calendar() {

		/**
		 * 
		 */
		private static final long serialVersionUID = 2L;

		@Override
		public void roll(int field, boolean up) {
			// TODO Auto-generated method stub

		}

		@Override
		public int getMinimum(int field) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getMaximum(int field) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getLeastMaximum(int field) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int getGreatestMinimum(int field) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		protected void computeTime() {
			// TODO Auto-generated method stub

		}

		@Override
		protected void computeFields() {
			// TODO Auto-generated method stub

		}

		@Override
		public void add(int field, int amount) {
			// TODO Auto-generated method stub

		}
	};

	public Reservation() {

	}

	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkIn;
	}

	public Date getCheckout() {
		return checkOut;
	}

	public long duration() {
		long diff = checkIn.getTime() - checkOut.getTime();

		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {
		Date now = Calendar.getInstance().getTime();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + roomNumber + ", check-in: " + sdf.format(checkIn) + ", check-out: " + sdf.format(checkOut)
				+ ", " + duration() + " nigths";
	}

}
