package controller;

import java.io.IOException;
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
 * Servlet implementation class EditTicketController
 */
@WebServlet("/EditTicketController")
public class EditTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String ticketId = request.getParameter("id");
			String edit = request.getParameter("edit");
			TicketDAO ticketDAO = new TicketDAOImpl();
			Ticket t = ticketDAO.getTicketById(Integer.parseInt(ticketId));
			List<Trip> listTrip = ticketDAO.getTripForUpdate(Integer.parseInt(ticketId));
			List<Car> listCar = ticketDAO.getCarForUpdate(Integer.parseInt(ticketId));
			request.setAttribute("ticket", t);
			request.setAttribute("trip", listTrip);
			request.setAttribute("car", listCar);
			request.setAttribute("edit", edit);
			request.getRequestDispatcher("views/main/edit-ticket.jsp").forward(request, response);
		} catch (Exception e) {
			request.getRequestDispatcher("views/main/ErrorPage.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TicketDAO ticketDAO = new TicketDAOImpl();
			int ticketId = Integer.parseInt(request.getParameter("ticketId"));
			String customerName = request.getParameter("customerName");
			String bookingTime = request.getParameter("bookingTime");
			int trip = Integer.parseInt(request.getParameter("tripId"));
			String licensePlate = request.getParameter("licensePlate");
			
			if(ticketDAO.updateBookedNumberDown(ticketId)) {
				if(ticketDAO.editTicket(ticketId, customerName, bookingTime, trip, licensePlate)) {
					ticketDAO.updateBookedNumberUp(ticketId);
				}
			}
			
			response.sendRedirect("EditTicketController?id=" + ticketId + "&edit=true");
		} catch (Exception e) {
			request.getRequestDispatcher("views/main/ErrorPage.jsp").forward(request, response);
		}
	}

}
