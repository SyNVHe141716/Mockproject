package controller;

import java.io.IOException;
import java.time.Year;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDAO;
import dao.impl.TicketDAOImpl;
import entities.Car;
import entities.Ticket;
import entities.Trip;

/**
 * Servlet implementation class TicketListController
 */
@WebServlet("/TicketListController")
public class TicketListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TicketListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			TicketDAO ticketDAO = new TicketDAOImpl();
			List<Trip> listTrip = ticketDAO.getAllTrip();
			List<Car> listCar = ticketDAO.getAllCar();
			List<Ticket> listTicket = ticketDAO.getTicket(null, null, null, null, null, null, null);
			request.setAttribute("ticket", listTicket);
			request.setAttribute("trip", listTrip);
			request.setAttribute("car", listCar);
			if (listTicket.size() > 0) {
				request.setAttribute("day", listTicket.get(0).getBookingDate().getDate());
				request.setAttribute("month", listTicket.get(0).getBookingDate().getMonth() + 1);
				request.setAttribute("year", listTicket.get(0).getBookingDate().getYear() + 1900);
				request.setAttribute("maxYear", listTicket.get(0).getBookingDate().getYear() + 1900);
			}
			else {
				request.setAttribute("day", 0);
				request.setAttribute("maxYear", 2021);
			}
			request.getRequestDispatcher("views/main/ticket-list.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("views/main/ErrorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String category = request.getParameter("category");
			String customerName = request.getParameter("name-search");
			String tripId = request.getParameter("trip-search");
			String licensePlate = request.getParameter("license-plate-search");
			String from = request.getParameter("from");
			String to = request.getParameter("to");
			String day = request.getParameter("day");
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			String bookingDate = year + "-" + month + "-" + day;

			TicketDAO ticketDAO = new TicketDAOImpl();
			List<Trip> listTrip = ticketDAO.getAllTrip();
			List<Car> listCar = ticketDAO.getAllCar();
			List<Ticket> listTicket = ticketDAO.getTicket(category, customerName, from, to, tripId, licensePlate,
					bookingDate);
			int maxYear = ticketDAO.getMaxYear();
			request.setAttribute("ticket", listTicket);
			request.setAttribute("trip", listTrip);
			request.setAttribute("car", listCar);
			request.setAttribute("day", day);
			request.setAttribute("month", month);
			request.setAttribute("year", year);
			request.setAttribute("maxYear", maxYear);
			request.setAttribute("category", category);
			request.setAttribute("customerName", customerName);
			request.setAttribute("tripId", tripId);
			request.setAttribute("licensePlate", licensePlate);
			request.setAttribute("from", from);
			request.setAttribute("to", to);

			request.getRequestDispatcher("views/main/ticket-list.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("views/main/ErrorPage.jsp").forward(request, response);
		}

	}

}
