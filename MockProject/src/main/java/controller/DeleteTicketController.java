package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TicketDAO;
import dao.impl.TicketDAOImpl;

/**
 * Servlet implementation class DeleteTicketController
 */
@WebServlet("/DeleteTicketController")
public class DeleteTicketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTicketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TicketDAO ticketDAO = new TicketDAOImpl();
			int ticketId = Integer.parseInt(request.getParameter("id"));
			if(ticketDAO.updateBookedNumberDown(ticketId)) {
				ticketDAO.deleteTicket(ticketId);
			}
			response.sendRedirect("TicketListController");
		} catch (Exception e) {
			request.getRequestDispatcher("views/main/ErrorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
