package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Trip;

public interface TripDAO {
	public List<Trip> getAllTrips() throws SQLException;
	
	public Trip getTripById(int id) throws SQLException;
	
	public boolean updateTripById(Trip trip) throws SQLException;
	
	public boolean addTripById(Trip trip) throws SQLException;
}
