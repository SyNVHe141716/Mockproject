package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.BookingDaoImpl;
import entities.BookingOffice;
import entities.Trip;

/**
 * Servlet implementation class BookinglistController
 */
@WebServlet("/booking")
public class BookinglistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookinglistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookingDaoImpl bk= new BookingDaoImpl();
		String pageIn=request.getParameter("index");
		if(pageIn==null) {
			pageIn="1";
		}
		int index=Integer.parseInt(pageIn);
		
		try {
		int count = bk.countBooking();
		int sizepage=3;
		int endPage=count/sizepage;
		if(count%sizepage!=0) {
				endPage++;
		}
		List<Trip> lsTrip = bk.getTrip();
		request.setAttribute("lsTrip", lsTrip);
		request.setAttribute("endPage", endPage);
		request.setAttribute("count", count);
		request.setAttribute("tag", index);
		List<BookingOffice> list = bk.getListBooking(index);
			if(list.isEmpty()) {
				
				request.setAttribute("mess", "no data. Please add content!!!!");
				request.getRequestDispatcher("/views/main/booking-office-list.jsp").forward(request, response);
			}else {
				request.setAttribute("list", list);
				request.getRequestDispatcher("/views/main/booking-office-list.jsp").forward(request, response);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
	}

}
