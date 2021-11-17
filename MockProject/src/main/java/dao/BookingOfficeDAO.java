package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import entities.BookingOffice;

public interface BookingOfficeDAO {
	List<BookingOffice> getListBooking(int index) throws SQLException;
	boolean addBooking(BookingOffice booking) throws SQLException;
	boolean deleteBooking(BookingOffice booking) throws SQLException;
	boolean updateBooking(BookingOffice booking) throws SQLException;
	int countBooking() throws SQLException;
}
