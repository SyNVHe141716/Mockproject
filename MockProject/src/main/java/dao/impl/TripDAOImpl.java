package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TripDAO;
import entities.Trip;
import utils.DBConnection;
import utils.SQLCommand;

public class TripDAOImpl implements TripDAO{
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public List<Trip> getAllTrips() throws SQLException{
		List<Trip> trips = new ArrayList<Trip>();
		Trip trip = null;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_TRIPS);
			rs = pre.executeQuery();
			while(rs.next()) {
				trip = new Trip();
				trip.setTripId(rs.getInt("tripId"));
				trip.setBookedTicketNumber(rs.getInt("bookedTicketNumber"));
				trip.setCarType(rs.getString("carType"));
				trip.setDeparttureDate(rs.getDate("departtureDate"));
				trip.setDepartureTime(rs.getTime("departureTime"));
				trip.setDestination(rs.getString("destination"));
				trip.setDriver(rs.getString("driver"));
				trip.setMaximumOnlineTicketNumber(rs.getInt("maximumOnlineTicketNumber"));
				trips.add(trip);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return trips;
	}

	@Override
	public boolean updateTripById(Trip trip) throws SQLException {
		boolean status = true;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.UPDATE_TRIP_BY_ID);
			pre.setInt(1, trip.getBookedTicketNumber());
			pre.setString(2, trip.getCarType());
			pre.setDate(3, trip.getDeparttureDate());
			pre.setTime(4, trip.getDepartureTime());
			pre.setString(5, trip.getDestination());
			pre.setString(6, trip.getDriver());
			pre.setInt(7, trip.getMaximumOnlineTicketNumber());
			pre.setInt(8, trip.getTripId());
			status = pre.execute();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}

	@Override
	public Trip getTripById(int id) throws SQLException {
		Trip trip = null;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_TRIP_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				trip = new Trip();
				trip.setTripId(rs.getInt("tripId"));
				trip.setBookedTicketNumber(rs.getInt("bookedTicketNumber"));
				trip.setCarType(rs.getString("carType"));
				trip.setDeparttureDate(rs.getDate("departtureDate"));
				trip.setDepartureTime(rs.getTime("departureTime"));
				trip.setDestination(rs.getString("destination"));
				trip.setDriver(rs.getString("driver"));
				trip.setMaximumOnlineTicketNumber(rs.getInt("maximumOnlineTicketNumber"));			
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return trip;
	}

	@Override
	public boolean addTripById(Trip trip) throws SQLException {
		boolean status = true;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.INSERT_TRIP);
			pre.setInt(1, trip.getBookedTicketNumber());
			pre.setString(2, trip.getCarType());
			pre.setDate(3, trip.getDeparttureDate());
			pre.setTime(4, trip.getDepartureTime());
			pre.setString(5, trip.getDestination());
			pre.setString(6, trip.getDriver());
			pre.setInt(7, trip.getMaximumOnlineTicketNumber());
			status = pre.execute();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}

}
