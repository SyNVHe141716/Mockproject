package controller;

import java.io.IOException;
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
 * Servlet implementation class BookingSearchController
 */
@WebServlet("/search")
public class BookingSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingSearchController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		if(category=="") {
			request.getRequestDispatcher("/booking").forward(request, response);
		}
		request.setAttribute("cate", category);
		
		if(category.equalsIgnoreCase("Bookingoffice")) {
			
			BookingDaoImpl bk= new BookingDaoImpl();

			String txt=request.getParameter("txtSearch");
			try {
			
			if(txt=="") {
				request.getRequestDispatcher("/booking").forward(request, response);
			}
			List<Trip> lsTrip = bk.getTrip();
			request.setAttribute("lsTrip", lsTrip);
			request.setAttribute("txt", txt);
			request.setAttribute("category", category);
			List<BookingOffice> list = bk.getSearchBookingName(txt);
				if(list.isEmpty()) {
					request.setAttribute("mess", "Can not find :" +txt);
					request.getRequestDispatcher("/views/main/booking-office-list.jsp").forward(request, response);
				}
				else {
					request.setAttribute("list", list);
					request.getRequestDispatcher("/views/main/booking-office-list.jsp").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(category.equalsIgnoreCase("Trip")) {
			BookingDaoImpl bk= new BookingDaoImpl();
			String selectTrip=request.getParameter("selectTrip");
			int id=Integer.parseInt(selectTrip);
			
		try {
			if(selectTrip=="") {
				request.getRequestDispatcher("/booking").forward(request, response);
			}
			List<Trip> lsTrip = bk.getTrip();
			request.setAttribute("lsTrip", lsTrip);
			request.setAttribute("id", id);
			request.setAttribute("category", category);
			List<BookingOffice> listT = bk.getSearchTrip(id);
			if(listT.isEmpty()) {
				request.setAttribute("mess", "Can not find");
				request.getRequestDispatcher("/views/main/booking-office-list.jsp").forward(request, response);
			}else {
				request.setAttribute("list", listT);
				request.getRequestDispatcher("/views/main/booking-office-list.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
				// TODO: handle exception
			e.printStackTrace();
			}
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
