package dao;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

import entities.Car;
import entities.Ticket;
import entities.Trip;

public interface TicketDAO {

	List<Trip> getTrip() throws Exception;
	
	List<Car> getCar() throws Exception;
	
	boolean addTicket(String customerName, LocalTime bookingTime, int idTrip, String licensePlate) throws Exception;
	
	List<Trip> getAllTrip() throws Exception;
	
	List<Car> getAllCar() throws Exception;

	int getMaxYear() throws Exception;
	
	List<Ticket> getTicket(String category, String customerName, String from, String to, String tripId, String licensePlate, String bookingDate) throws Exception;

	boolean deleteTicket(int idTicket) throws Exception;
	
	Ticket getTicketById(int ticketId) throws Exception;

	boolean editTicket(int ticketId, String customerName, String bookingTime, int tripId, String licensePlate)
			throws Exception;
	
	List<Trip> getTripForUpdate(int ticketId) throws Exception;
	
	List<Car> getCarForUpdate(int ticketId) throws Exception;
	
	boolean updateBookedNumber(int tripId)  throws Exception;
	
	boolean updateBookedNumberDown(int ticketId)  throws Exception;
	
	boolean updateBookedNumberUp(int ticketId)  throws Exception;
}
