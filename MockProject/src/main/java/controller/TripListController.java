package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.TripDAOImpl;
import entities.Trip;

/**
 * Servlet implementation class TripListController
 */
@WebServlet("/TripListController")
public class TripListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TripDAOImpl tripDAOImpl = new TripDAOImpl();

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
		// TODO Auto-generated method stub

	}

}
