package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.TripDAOImpl;
import entities.Trip;

/**
 * Servlet implementation class TripSearchController
 */
@WebServlet("/TripSearchController")
public class TripSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TripDAOImpl tripDAOImpl = new TripDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TripSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String day = request.getParameter("day");
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			String inputSearch = request.getParameter("input-search");
			
			String date = year+"-"+month+"-"+day;
			
			
			List<Trip> trips = tripDAOImpl.getAllTripsByDateAndDes(Date.valueOf(date), inputSearch);
			request.setAttribute("trips", trips);
			request.setAttribute("inputSearch", inputSearch);
			request.getRequestDispatcher("views/main/trip-list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
