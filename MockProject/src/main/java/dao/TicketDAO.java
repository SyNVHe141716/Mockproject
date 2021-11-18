package dao;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import entities.Car;
import entities.Ticket;
import entities.Trip;

public interface TicketDAO {

	List<Trip> getTrip() throws Exception;
	
	List<Car> getCar() throws Exception;
	
	boolean addTicket(String customerName, LocalTime bookingTime, int idTrip, String licensePlate) throws Exception;

	List<Ticket> getTicket(String category, String input, String bookingDate) throws Exception;

	boolean deleteTicket(int idTicket) throws Exception;

	boolean editTicket(int idTicket, String customerName, Time bookingTime, int idTrip, String licensePlate)
			throws Exception;
	
	boolean updateBookedNumber(int tripId)  throws Exception;
}
