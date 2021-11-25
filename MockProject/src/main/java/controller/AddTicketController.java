package controller;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDAO;
import dao.impl.TicketDAOImpl;
import entities.Car;
import entities.Trip;

/**
 * Servlet implementation class AddTicketController
 */
@WebServlet("/AddTicketController")
public class AddTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String add = request.getParameter("add");
			TicketDAO ticketDAO = new TicketDAOImpl();
			List<Trip> listTrip = ticketDAO.getTrip();
			List<Car> listCar = ticketDAO.getCar();
			
			request.setAttribute("trip", listTrip);
			request.setAttribute("car", listCar);
			request.setAttribute("add", add);
			
			request.getRequestDispatcher("views/main/add-ticket.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("views/main/ErrorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String customerName = request.getParameter("customer-name");
			LocalTime bookingTime = LocalTime.parse(request.getParameter("booking-time"));
			int tripId = Integer.parseInt(request.getParameter("trip"));
			String licensePlate = request.getParameter("license-plate");
			TicketDAO ticketDAO = new TicketDAOImpl();
			if(ticketDAO.addTicket(customerName, bookingTime, tripId, licensePlate)) {
				response.sendRedirect("AddTicketController?add=true");
			}
		} catch (Exception e) {
			request.getRequestDispatcher("views/main/ErrorPage.jsp").forward(request, response);
		}
	}

}
