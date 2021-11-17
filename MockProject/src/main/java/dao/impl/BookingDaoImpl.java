package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.BookingOfficeDAO;
import entities.BookingOffice;
import entities.Trip;
import utils.DBConnection;
import utils.SQLCommand;

public class BookingDaoImpl implements BookingOfficeDAO {
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	@Override
	public List<BookingOffice> getListBooking(int index) throws SQLException {
		List<BookingOffice> list = new ArrayList<>();
		BookingOffice bk = null;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.QUERY_GET_Booking_List);
			ps.setInt(1, (index - 1) * 3);
			rs = ps.executeQuery();
			while (rs.next()) {
				bk = new BookingOffice();
				bk.setStt(rs.getInt("r"));
				bk.setOfficeId(rs.getInt("officeId"));
				bk.setOfficeName(rs.getString("officeName"));
				bk.setDestination(rs.getString("destination"));
				bk.setTripid(rs.getInt("tripId"));
				bk.setOfficePhone(rs.getString("officePhone"));
				bk.setOfficePlace(rs.getString("officePlace"));
				bk.setOfficePrice(rs.getInt("officePrice"));
				bk.setStartContractDeadline(rs.getDate("startContractDeadline"));
				bk.setEndContractDeadline(rs.getDate("endContractDeadline"));
				list.add(bk);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean addBooking(BookingOffice booking) throws SQLException {
		int row = 0;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(SQLCommand.QUERY_ADD_Booking_List);
			ps.setString(1, booking.getOfficeName());
			ps.setInt(2, booking.getTripid());
			ps.setString(3, booking.getOfficePhone());
			ps.setInt(4, booking.getOfficePrice());
			ps.setString(5, booking.getOfficePlace());
			ps.setDate(6, booking.getStartContractDeadline());
			ps.setDate(7, booking.getEndContractDeadline());
			row = ps.executeUpdate();
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return row > 0;
	}

	@Override
	public boolean deleteBooking(BookingOffice booking) throws SQLException {
		int row = 0;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(SQLCommand.QUERY_DELETE_Booking);
			ps.setInt(1, booking.getOfficeId());
			row = ps.executeUpdate();
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return row > 0;
	}

	@Override
	public boolean updateBooking(BookingOffice booking) throws SQLException {
		int row = 0;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(SQLCommand.QUERY_UPDATE_Booking);
			ps.setString(1, booking.getOfficeName());
			ps.setInt(2, booking.getTripid());
			ps.setString(3, booking.getOfficePhone());
			ps.setString(4, booking.getOfficePlace());
			ps.setInt(5, booking.getOfficePrice());
			
			ps.setDate(6, booking.getStartContractDeadline());
			ps.setDate(7, booking.getEndContractDeadline());
			ps.setInt(8, booking.getOfficeId());
			row = ps.executeUpdate();
		} finally {
			if (rs != null) {
				rs.close();
			}

			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		}

		return row > 0;
	}

	public int countBooking() throws SQLException {
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.QUERY_COUNT_Booking);

			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<Trip> getTrip() throws SQLException {
		List<Trip> list = new ArrayList<>();
		Trip trip = null;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.QUERY_LIST_CBX);
			rs = ps.executeQuery();
			while (rs.next()) {
				trip = new Trip();
				trip.setTripId(rs.getInt("tripId"));
				trip.setDestination(rs.getString("destination"));

				list.add(trip);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<BookingOffice> getPlace() throws SQLException {
		List<BookingOffice> list = new ArrayList<>();
		BookingOffice bk;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.QUERY_LIST_CBXBk);
			rs = ps.executeQuery();
			while (rs.next()) {
				bk = new BookingOffice();
				bk.setOfficePlace(rs.getString(1));
				list.add(bk);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int countBookingName(String txt) throws SQLException {
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.QUERY_COUNT_BookingName);
			ps.setString(1, txt);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	public List<BookingOffice> getSearchBookingName(String txt, int index) throws SQLException {
		List<BookingOffice> list = new ArrayList<>();
		BookingOffice bk = null;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.SEARCH_BOOKINGNAME);
			ps.setString(1, "%" + txt + "%");
			ps.setInt(2, (index * 3) - 2);
			ps.setInt(3, (index * 3));
			rs = ps.executeQuery();
			while (rs.next()) {
				bk = new BookingOffice();
				bk.setStt(rs.getInt("r"));
				bk.setOfficeId(rs.getInt("officeId"));
				bk.setOfficeName(rs.getString("officeName"));
				bk.setDestination(rs.getString("destination"));
				bk.setTripid(rs.getInt("tripId"));
				bk.setOfficePhone(rs.getString("officePhone"));
				bk.setOfficePlace(rs.getString("officePlace"));
				bk.setOfficePrice(rs.getInt("officePrice"));
				bk.setStartContractDeadline(rs.getDate("startContractDeadline"));
				bk.setEndContractDeadline(rs.getDate("endContractDeadline"));
				list.add(bk);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public BookingOffice getBooking(int id) throws SQLException {
		List<BookingOffice> list = new ArrayList<>();
		BookingOffice bk = null;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.QUERY_BOOKING);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				bk = new BookingOffice();

				bk.setOfficeId(rs.getInt("officeId"));
				bk.setOfficeName(rs.getString("officeName"));
				bk.setDestination(rs.getString("destination"));
				bk.setTripid(rs.getInt("tripId"));
				bk.setOfficePhone(rs.getString("officePhone"));
				bk.setOfficePlace(rs.getString("officePlace"));
				bk.setOfficePrice(rs.getInt("officePrice"));
				bk.setStartContractDeadline(rs.getDate("startContractDeadline"));
				bk.setEndContractDeadline(rs.getDate("endContractDeadline"));
				return bk;
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<BookingOffice> getSearchTrip(int id, int index) throws SQLException {
		List<BookingOffice> list = new ArrayList<>();
		BookingOffice bk = null;
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.SEARCH_TRIPID);
			ps.setInt(1, id);
			ps.setInt(2, (index * 3) - 2);
			ps.setInt(3, (index * 3));
			rs = ps.executeQuery();
			while (rs.next()) {
				bk = new BookingOffice();
				bk.setStt(rs.getInt("r"));
				bk.setOfficeId(rs.getInt("officeId"));
				bk.setOfficeName(rs.getString("officeName"));
				bk.setDestination(rs.getString("destination"));
				bk.setTripid(rs.getInt("tripId"));
				bk.setOfficePhone(rs.getString("officePhone"));
				bk.setOfficePlace(rs.getString("officePlace"));
				bk.setOfficePrice(rs.getInt("officePrice"));
				bk.setStartContractDeadline(rs.getDate("startContractDeadline"));
				bk.setEndContractDeadline(rs.getDate("endContractDeadline"));
				list.add(bk);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public int countTrip(int tripid) throws SQLException {
		try {
			conn = DBConnection.getInstance().getConnection();
			ps = conn.prepareStatement(utils.SQLCommand.Count_TripID);
			ps.setInt(1, tripid);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (ps != null) {
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	public static void main(String[] args) throws SQLException {
		BookingDaoImpl bk = new BookingDaoImpl();
//		 String str = "2017-1-1";
//	        // converting string into sql date
//	        Date date = Date.valueOf(str);
//	       
//		try {
//			
//			BookingOffice boo= new BookingOffice(4, "sy", "1", "123", 1, date, date, 1);
	//	boolean kq = bk.updateBooking(boo);
//			if(kq==true) {
//				System.out.println("success");
//			}else {
//				System.out.println("faile");
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		List<BookingOffice> ls = bk.getSearchTrip(1,15);
		if(ls.isEmpty()) {
			System.out.println("123");
		}else {
		for (BookingOffice bookingOffice : ls) {
			System.out.println(bookingOffice.toString());
		}
		}

	}

}
