package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TripDAO;
import dao.impl.TripDAOImpl;
import entities.Trip;

/**
 * Servlet implementation class TripListController
 */
@WebServlet("/TripListController")
public class TripListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TripDAO tripDAOImpl = new TripDAOImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TripListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Trip> trips = tripDAOImpl.getAllTrips();
			
			if (trips.size() > 0) {
				request.setAttribute("day", trips.get(0).getDeparttureDate().getDate());
				request.setAttribute("month", trips.get(0).getDeparttureDate().getMonth() + 1);
				request.setAttribute("year", trips.get(0).getDeparttureDate().getYear() + 1900);
				request.setAttribute("maxYear", trips.get(0).getDeparttureDate().getYear() + 1900);
			}
			else {
				request.setAttribute("day", 0);
				request.setAttribute("maxYear", 2021);
			}

			request.setAttribute("trips", trips);
			request.getRequestDispatcher("views/main/trip-list.jsp" + "").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String day = request.getParameter("day");
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			String inputSearch = request.getParameter("input-search");
			
			String date = year+"-"+month+"-"+day;
			int maxYear = tripDAOImpl.getMaxYear();
			
			List<Trip> trips = tripDAOImpl.getAllTripsByDateAndDes(Date.valueOf(date), inputSearch);
			request.setAttribute("trips", trips);
			request.setAttribute("inputSearch", inputSearch);
			request.setAttribute("day", day);
			request.setAttribute("month", month);
			request.setAttribute("year", year);
			request.setAttribute("maxYear", maxYear);
			request.getRequestDispatcher("views/main/trip-list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
