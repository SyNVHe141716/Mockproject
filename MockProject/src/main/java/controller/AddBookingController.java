package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.BookingDaoImpl;
import entities.BookingOffice;
import entities.Trip;

/**
 * Servlet implementation class AddBookingController
 */
@WebServlet("/add")
public class AddBookingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookingController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookingDaoImpl bk = new BookingDaoImpl();
		List<Trip> lsTrip;
		List<BookingOffice> lsBk;
		try {
			lsTrip = bk.getTrip();
			lsBk= bk.getPlace();
			request.setAttribute("lstrip", lsTrip);
			request.setAttribute("lsBk", lsBk);
			
			request.getRequestDispatcher("views/main/add-booking-office.jsp").forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingDaoImpl bk= new BookingDaoImpl();
		
		String name= request.getParameter("bookingOfficeName");
		String tripId= request.getParameter("trip");
		int id= Integer.parseInt(tripId);
		String phone =request.getParameter("phonenumber");
		String Place=request.getParameter("place");
		String price= request.getParameter("price");
		int pr= Integer.parseInt(price);
		String fromdate=request.getParameter("fromDate");
		String todate=request.getParameter("toDate");
		
	    Date from = Date.valueOf(fromdate);
	    Date to = Date.valueOf(todate);
		BookingOffice boo = new BookingOffice(name, phone, Place, pr, from, to, id);
		
		try {
			List<Trip> lsTrip = bk.getTrip();
			List<BookingOffice> lsBk= bk.getPlace();
			boolean kq= bk.addBooking(boo);
			if(kq==true) {
				
				request.setAttribute("lstrip", lsTrip);
				request.setAttribute("lsBk", lsBk);
				request.setAttribute("place", Place);
				request.setAttribute("tripid", tripId);
				request.setAttribute("bk", boo);
				request.setAttribute("mess", "Add Success");
				request.getRequestDispatcher("/views/main/add-booking-office.jsp").forward(request, response);
			}else {
				request.setAttribute("mess", "Add false");
				request.getRequestDispatcher("/views/main/add-booking-office.jsp").forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("mess", "Add false");
			request.getRequestDispatcher("/views/main/add-booking-office.jsp").forward(request, response);
		}
		
		
		
		
	}

}
