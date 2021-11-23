package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.TripDAOImpl;
import entities.Trip;

/**
 * Servlet implementation class TripUpdateController
 */
@WebServlet("/TripUpdateController")
public class TripUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TripDAOImpl tripDAOImpl = new TripDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int tripId = Integer.parseInt(request.getParameter("id"));
			Trip trip = tripDAOImpl.getTripById(tripId);
			
			request.setAttribute("trip", trip);
			request.getRequestDispatcher("views/main/edit-delete-trip.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int tripId = Integer.parseInt(request.getParameter("id").trim());
			String destination = request.getParameter("destination");
			Time departureTime = Time.valueOf(request.getParameter("departureTime"));
			String driver = request.getParameter("driver");
			String carType = request.getParameter("carType");
			int bookedTicketNumber = Integer.parseInt(request.getParameter("bookedTicketNumber").trim());
			int maximumOTN= Integer.parseInt(request.getParameter("maximum").trim());
			Date departureDate = Date.valueOf(request.getParameter("departureDate"));
			
			Trip trip = new Trip();
			trip.setDestination(destination);
			trip.setDepartureTime(departureTime);
			trip.setDriver(driver);
			trip.setCarType(carType);
			trip.setBookedTicketNumber(bookedTicketNumber);
			trip.setMaximumOnlineTicketNumber(maximumOTN);
			trip.setDeparttureDate(departureDate);
			trip.setTripId(tripId);
			boolean check = true;
			
			if(tripDAOImpl.updateTripById(trip) == false) {
				Trip tripp = tripDAOImpl.getTripById(tripId);
				request.setAttribute("trip", tripp);
				request.setAttribute("success", check);
				request.getRequestDispatcher("views/main/edit-delete-trip.jsp").forward(request, response);
			}else {
				Trip tripp = tripDAOImpl.getTripById(tripId);
				check = false;
				request.setAttribute("falsed", check);
				request.setAttribute("trip", tripp);
				request.getRequestDispatcher("views/main/edit-delete-trip.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
