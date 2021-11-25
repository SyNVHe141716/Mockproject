package controller.car;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * Servlet implementation class SearchCartController
 */
@WebServlet("/SearchCartController")
public class SearchCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchCartController() {
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
		String txt = request.getParameter("input-search");
		String category = request.getParameter("category");
		String company = request.getParameter("selectCompany");
		String ParkingLot = request.getParameter("selectParkingLot");
		List<Car> cars = new ArrayList<Car>();

		try {
			List<Company> companies = dao.getAllCompany();
			List<ParkingLot> parkingLots = dao.getAllParkingLot();
			request.setAttribute("parkingLots", parkingLots);
			request.setAttribute("companies", companies);
		} catch (Exception e1) {
			e1.printStackTrace();
			String err = "Connect SQL Server fail";
			request.setAttribute("errorSQL", err);
		}
		if (category == "") {
			try {
				cars = dao.getAllCart();
			} catch (SQLException e) {
				e.printStackTrace();
				String err = "Connect SQL Server fail";
				request.setAttribute("errorSQL", err);
			}
		} else {
			if (category.equals("licensePlate")) {
				try {
					if (txt == "") {
						cars = dao.getAllCart();
					} else {
						cars = dao.getAlllicensePlate(txt);
					}
				} catch (Exception e) {
					e.printStackTrace();
					String err = "Connect SQL Server fail";
					request.setAttribute("errorSQL", err);
				}
			} else if (category.equals("carType")) {
				try {
					if (txt == "") {

						cars = dao.getAllCart();
					} else {
						cars = dao.getAllcarType(txt);
					}
				} catch (Exception e) {
					e.printStackTrace();
					String err = "Connect SQL Server fail";
					request.setAttribute("errorSQL", err);
				}
			} else if (category.equals("carColor")) {
				try {
					if (txt == "") {
						cars = dao.getAllCart();
					} else {
						cars = dao.getAllcarColor(txt);
					}
				} catch (Exception e) {
					e.printStackTrace();
					String err = "Connect SQL Server fail";
					request.setAttribute("errorSQL", err);
				}
			} else if (category.equals("company")) {
				try {
					cars = dao.getAllcompanyName(company);
				} catch (Exception e) {
					e.printStackTrace();
					String err = "Connect SQL Server fail";
					request.setAttribute("errorSQL", err);
				}
			} else {
				try {
					cars = dao.getAllpackName(ParkingLot);
				} catch (Exception e) {
					e.printStackTrace();
					String err = "Connect SQL Server fail";
					request.setAttribute("errorSQL", err);
				}
			}
		}
		request.setAttribute("com", company);
		request.setAttribute("pa", ParkingLot);
		request.setAttribute("category", category);
		request.setAttribute("cars", cars);
		request.getRequestDispatcher("views/main/car-list.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
