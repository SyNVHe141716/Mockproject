package entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class Ticket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ticketId;
	private Time bookingTime;
	private Date bookingDate;
	private String customerName;
	private String licensePlate;
	private int tripId;
	private String tripName;
	
	public Ticket() {
		super();
	}

	public Ticket(int ticketId, Time bookingTime, String customerName, String licensePlate, int tripId,
			String tripName) {
		super();
		this.ticketId = ticketId;
		this.bookingTime = bookingTime;
		this.customerName = customerName;
		this.licensePlate = licensePlate;
		this.tripId = tripId;
		this.tripName = tripName;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
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

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public String getTripName() {
		return tripName;
	}

	public void setTripName(String tripName) {
		this.tripName = tripName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", bookingTime=" + bookingTime + ", customerName=" + customerName
				+ ", licensePlate=" + licensePlate + ", tripId=" + tripId + ", tripName=" + tripName + "]";
	}
	
	
}
