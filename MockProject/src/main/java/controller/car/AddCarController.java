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
 * Servlet implementation class AddCarController
 */
@WebServlet("/AddCarController")
public class AddCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCarController() {
        super();
        // TODO Auto-generated constructor stub
    }
	CarDAO dao = new CarDAOImpl();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ParkingLot> listp;
		List<Company> listcom;
		try {
			listp = dao.getAllParkingLot();
			listcom = dao.getAllCompany();
			request.setAttribute("listp", listp);
			request.setAttribute("listcom", listcom);
		} catch (Exception e) {
			e.printStackTrace();
			String err = "Connect SQL Server fail";
			request.setAttribute("errorSQL", err);
		}
		request.getRequestDispatcher("views/main/add-car.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String licensePlate = request.getParameter("licensePlate");
		String carType = request.getParameter("carType");
		String carColor = request.getParameter("carColor");
		int parkingLot = Integer.parseInt(request.getParameter("parkingLot"));
		int company = Integer.parseInt(request.getParameter("company"));
		Car car = new Car(licensePlate, carColor, carType, company, parkingLot);
		String err = "";

		try {
			if (dao.searchByLicensePlate(licensePlate) == null) {
				if (dao.addCar(car) == 1) {
					err = "Add successfully!";
//					response.getWriter().write("<script type=\"text/javascript\">");
//					response.getWriter().write("alert('Add Car Sucessfully');");
//					response.getWriter().write("location='ListCarController';");
//					response.getWriter().write("</script>");
				} else {
					err = "Add  fail!";
				}
			} else {
				err = licensePlate + " is existed!";
			}

		} catch (Exception e) {
			err = "Connect SQL Server fail";
			e.printStackTrace();
		}
		request.setAttribute("errorSQL", err);
		request.getRequestDispatcher("ListCarController").forward(request, response);
	}
}
