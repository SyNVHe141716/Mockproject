package entities;

import java.io.Serializable;
import java.sql.Time;

public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ticketId;
	private Time bookingTime;
	private String customerName;
	private String licensePlate;
	private String tripId;
	
	public Ticket() {
		super();
	}

	public Ticket(Time bookingTime, String customerName, String licensePlate, String tripId) {
		super();
		this.bookingTime = bookingTime;
		this.customerName = customerName;
		this.licensePlate = licensePlate;
		this.tripId = tripId;
	}

	public Ticket(int ticketId, Time bookingTime, String customerName, String licensePlate, String tripId) {
		super();
		this.ticketId = ticketId;
		this.bookingTime = bookingTime;
		this.customerName = customerName;
		this.licensePlate = licensePlate;
		this.tripId = tripId;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public Time getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(Time bookingTime) {
		this.bookingTime = bookingTime;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getTripId() {
		return tripId;
	}

	public void setTripId(String tripId) {
		this.tripId = tripId;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", bookingTime=" + bookingTime + ", customerName=" + customerName
				+ ", licensePlate=" + licensePlate + ", tripId=" + tripId + "]";
	}
	
	
}
