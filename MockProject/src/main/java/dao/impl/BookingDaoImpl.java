package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookingOfficeDAO;
import entities.BookingOffice;

import utils.DBConnection;
import utils.SQLCommand;

public class BookingDaoImpl implements BookingOfficeDAO{
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
			ps.setInt(1, (index-1)*3);
			rs = ps.executeQuery();
			while (rs.next()) {
				bk= new BookingOffice();
				bk.setOfficeId(rs.getInt("officeId"));
				bk.setOfficeName(rs.getString("officeName"));
				bk.setDestination(rs.getString("destination"));
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

	public static void main(String[] args) throws SQLException {
		BookingOfficeDAO bk = new BookingDaoImpl();
		List<BookingOffice> ls = bk.getListBooking(1);
		for (BookingOffice bookingOffice : ls) {
			System.out.println(bookingOffice.toString());
		}
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
			ps.setInt(1,booking.getOfficeId());
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
	


}
