package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDAO;
import entities.Car;
import entities.Ticket;
import entities.Trip;
import utils.DBConnection;
import utils.SQLCommand;

public class TicketDAOImpl implements TicketDAO{

	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;
	
	@Override
	public List<Trip> getTrip() throws Exception {
		List<Trip> listTrip = new ArrayList<>();
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_TRIP_FOR_TICKET);
			rs = pre.executeQuery();
			while(rs.next()) {
				Trip t = new Trip();
				t.setTripId(rs.getInt("tripid"));
				t.setDestination(rs.getString("destination"));
				listTrip.add(t);
			}
			return listTrip;
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
	}

	@Override
	public List<Car> getCar() throws Exception {
		List<Car> listCar = new ArrayList<>();
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_CAR_FOR_TICKET);
			rs = pre.executeQuery();
			while(rs.next()) {
				Car c = new Car();
				c.setLicensePlate(rs.getString("licensePlate"));
				listCar.add(c);
			}
			return listCar;
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
	}
	
	@Override
	public boolean addTicket(String customerName, LocalTime bookingTime, int idTrip, String licensePlate) throws Exception {
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.INSERT_TICKET);
			pre.setString(++param, bookingTime.toString());
			pre.setString(++param, customerName);
			pre.setString(++param, licensePlate);
			pre.setInt(++param, idTrip);
			return pre.executeUpdate() > 0;
		}
		finally {
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
	}
	
	@Override
	public boolean updateBookedNumber(int tripId) throws Exception {
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.UPDATE_BOOKED_NUMBER);
			pre.setInt(1, tripId);
			return pre.executeUpdate() > 0;
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
	}

	@Override
	public List<Ticket> getTicket(String category, String input, String bookingDate) throws Exception {
		List<Ticket> listTicket = new ArrayList<>();
		try {
			String sql = SQLCommand.SEARCH_TICKET;
			String where = "where ticket.bookingDate = (select max(bookingDate) from ticket)";
			if(category != null || !"".equals(category)) {
				if("customerName".equals(category)) {
					where = "where ticket.customerName like '%" + input + "%' and ticket.bookingDate = '" + bookingDate +"'";
				}
				else {
					where = "where ticket." + category + " = '" + input + "' and ticket.bookingDate = '" + bookingDate +"'";
				}
			}
			sql+=where;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while(rs.next()){
				Ticket t = new Ticket();
				
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
		return listTicket;
	}

	@Override
	public boolean deleteTicket(int idTicket) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editTicket(int idTicket, String customerName, Time bookingTime, int idTrip, String licensePlate)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	

	

}
