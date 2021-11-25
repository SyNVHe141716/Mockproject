package controller.car;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.CarDAO;
import dao.impl.CarDAOImpl;
import entities.Car;
import entities.Company;
import entities.ParkingLot;

/**
 * Servlet implementation class ListCarController
 */
@WebServlet("/ListCarController")
public class ListCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListCarController() {
		super();
		// TODO Auto-generated constructor stub
	}
	CarDAO dao = new CarDAOImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Car> cars = dao.getAllCart();
			List<ParkingLot> parkingLots = dao.getAllParkingLot();
			List<Company> companies = dao.getAllCompany();
			request.setAttribute("parkingLots", parkingLots);
			request.setAttribute("companies", companies);
			request.setAttribute("cars", cars);
		} catch (Exception e) {
			e.printStackTrace();
			String err = "Connect SQL Server fail";
			request.setAttribute("errorSQL", err);
		}
		request.getRequestDispatcher("views/main/car-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
