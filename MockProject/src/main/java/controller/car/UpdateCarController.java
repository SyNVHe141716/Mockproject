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
 * Servlet implementation class UpdateCarController
 */
@WebServlet("/UpdateCarController")
public class UpdateCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCarController() {
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
		String c = request.getParameter("uid");
		List<ParkingLot> listp;
		List<Company> listcom;
		try {
			listp = dao.getAllParkingLot();
			listcom = dao.getAllCompany();
			Car car = dao.searchByLicensePlate(c);
			request.setAttribute("listp", listp);
			request.setAttribute("listcom", listcom);
			request.setAttribute("listlp", car);
		} catch (Exception e) {
			e.printStackTrace();
			String err = "Connect SQL Server fail";
			request.setAttribute("errorSQL", err);
		}
		request.getRequestDispatcher("views/main/edit-delete-car.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String licensePlate = request.getParameter("licensePlate");
		String carType = request.getParameter("carType");
		String carColor = request.getParameter("carColor");
		int parkingLot = Integer.parseInt(request.getParameter("parkingLot"));
		int company = Integer.parseInt(request.getParameter("company"));
		// System.out.println(licensePlate);
		Car car = new Car(licensePlate, carColor, carType, company, parkingLot);
		String err = "";
		try {
			if (dao.update(car) == 1) {
				err = "Upadate successfully!";

			} else {
				err = "Upadate  fail!";
			}
		} catch (Exception e) {
			err = "Connect SQL Server fail";
			e.printStackTrace();
		}
		request.setAttribute("errorSQL", err);
		request.getRequestDispatcher("ListCarController").forward(request, response);
	}

}
