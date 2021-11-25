package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDAO;
import entities.Car;
import entities.Ticket;
import entities.Trip;
import utils.DBConnection;
import utils.SQLCommand;

public class TicketDAOImpl implements TicketDAO {

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
			while (rs.next()) {
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
			while (rs.next()) {
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
	public boolean addTicket(String customerName, LocalTime bookingTime, int idTrip, String licensePlate)
			throws Exception {
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.INSERT_TICKET);
			pre.setString(++param, bookingTime.toString());
			pre.setString(++param, customerName);
			pre.setString(++param, licensePlate);
			pre.setInt(++param, idTrip);
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
	public List<Ticket> getTicket(String category, String customerName, String from, String to, String tripId,
			String licensePlate, String bookingDate) throws Exception {
		List<Ticket> listTicket = new ArrayList<>();
		try {
			String sql = SQLCommand.SEARCH_TICKET;
			String where;
			if ("customerName".equals(category) && customerName != null && !"".equals(customerName)) {
				where = "where ticket.customerName like '%" + customerName + "%' and ticket.bookingDate = '"
						+ bookingDate + "'";
			} else if ("bookingTime".equals(category) && from != null && !"".equals(from) && to != null
					&& !"".equals(to)) {
				where = "where CAST(ticket.bookingTime as time) between '" + from + "' and '" + to
						+ "' and ticket.bookingDate = '" + bookingDate + "'";
			} else if ("tripId".equals(category) && tripId != null && !"".equals(tripId)) {
				where = "where ticket.tripId = " + tripId + " and ticket.bookingDate = '" + bookingDate + "'";
			} else if ("licensePlate".equals(category) && licensePlate != null && !"".equals(licensePlate)) {
				where = "where ticket.licensePlate = '" + licensePlate + "' and ticket.bookingDate = '" + bookingDate
						+ "'";
			} else if (bookingDate != null && !"".equals(bookingDate)) {
				where = "where ticket.bookingDate = '" + bookingDate + "'";
			} else {
				where = "order by ticket.bookingDate asc";
			}
			sql += where;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Ticket t = new Ticket();
				t.setTicketId(rs.getInt("ticketid"));
				t.setBookingTime(rs.getTime("bookingTime"));
				t.setBookingDate(rs.getDate("bookingDate"));
				t.setCustomerName(rs.getString("customerName"));
				t.setLicensePlate(rs.getString("licensePlate"));
				t.setTripName(rs.getString("destination"));
				listTicket.add(t);
			}
			return listTicket;
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
	public boolean deleteTicket(int idTicket) throws Exception {
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.DELETE_TICKET);
			pre.setInt(1, idTicket);
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
	public boolean editTicket(int ticketId, String customerName, String bookingTime, int tripId, String licensePlate)
			throws Exception {
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.UPDATE_TICKET);
			pre.setString(1, bookingTime);
			pre.setString(2, customerName);
			pre.setString(3, licensePlate);
			pre.setInt(4, tripId);
			pre.setInt(5, ticketId);
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
	public List<Trip> getAllTrip() throws Exception {
		List<Trip> listTrip = new ArrayList<>();
		try {
			String sql = "select * from trip";
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Trip t = new Trip();
				t.setTripId(rs.getInt("tripId"));
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
	public List<Car> getAllCar() throws Exception {
		List<Car> listCar = new ArrayList<>();
		try {
			String sql = "select * from car";
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
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
	public int getMaxYear() throws Exception {
		try {
			String sql = "select year(max(bookingDate)) as maxYear from ticket";
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			if (rs.next()) {
				return rs.getInt("maxYear");
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
		return 0;
	}

	@Override
	public Ticket getTicketById(int ticketId) throws Exception {
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_TICKET_BY_ID);
			pre.setInt(1, ticketId);
			rs = pre.executeQuery();
			if (rs.next()) {
				Ticket t = new Ticket();
				t.setTicketId(rs.getInt("ticketId"));
				t.setBookingTime(rs.getTime("bookingTime"));
				t.setCustomerName(rs.getString("customerName"));
				t.setLicensePlate(rs.getString("licensePlate"));
				t.setTripId(rs.getInt("tripId"));
				return t;
			}
			return null;
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
	public List<Trip> getTripForUpdate(int ticketId) throws Exception {
		List<Trip> listTrip = new ArrayList<>();
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_TRIP_FOR_UPDATE_TICKET);
			pre.setInt(1, ticketId);
			rs = pre.executeQuery();
			while (rs.next()) {
				Trip t = new Trip();
				t.setTripId(rs.getInt("tripId"));
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
	public List<Car> getCarForUpdate(int ticketId) throws Exception {
		List<Car> listCar = new ArrayList<>();
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_CAR_FOR_UPDATE_TICKET);
			pre.setInt(1, ticketId);
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

}
