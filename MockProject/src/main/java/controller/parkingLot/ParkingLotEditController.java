package controller.parkingLot;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingLotDAO;
import dao.ParkingPlaceDAO;
import dao.impl.ParkingLotDAOImpl;
import dao.impl.ParkingPlaceDAOImpl;
import entities.Employee;
import entities.ParkingLot;
import entities.ParkingPlace;

/**
 * Servlet implementation class ParkingLotEditController
 */
@WebServlet("/parking-lot-edit")
public class ParkingLotEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkingLotEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mess = "";
		try {
			ParkingPlaceDAO parkingPlaceDAO = new ParkingPlaceDAOImpl();
			List<ParkingPlace> parkingPlaces = parkingPlaceDAO.getAll();
			request.setAttribute("parkingPlaces", parkingPlaces);
			int id = Integer.parseInt(request.getParameter("id"));
			ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
			ParkingLot parkingLot = parkingLotDAO.getById(id);
			request.setAttribute("parkingLot", parkingLot);
		} catch (Exception e) {
			e.printStackTrace();
			mess = "Fail in SQL on get Parking lot";
			request.setAttribute("mess", mess);
		}
		Employee employee = (Employee) request.getSession().getAttribute("employee") ;
		request.setAttribute("acc", employee);
		request.getRequestDispatcher("views/main/edit-parking-lot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		int area = Integer.parseInt(request.getParameter("area"));
		int price = Integer.parseInt(request.getParameter("price"));
		boolean status = false;
		ParkingLot parkingLotUpdate = new ParkingLot(id, name, placeId, area, price, status);
		ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
		String mess = "";
		try {
			if (parkingLotDAO.getByName(name) == null || parkingLotDAO.getByName(name).getId() == id) {
			if (parkingLotDAO.update(parkingLotUpdate)) {
				mess = "Update Sucessfully!";

			} else {
				mess = "Update Fail!";
			}
			}
			else {
				mess = "Parking Slot name \"" + name + "\" was existed!";
			}
			ParkingPlaceDAO parkingPlaceDAO = new ParkingPlaceDAOImpl();
			List<ParkingPlace> parkingPlaces = parkingPlaceDAO.getAll();
			request.setAttribute("parkingPlaces", parkingPlaces);
			ParkingLot parkingLot = parkingLotDAO.getById(id);
			request.setAttribute("parkingLot", parkingLot);
		} catch (Exception e) {
			mess = "Fail in SQL";
			e.printStackTrace();
		}
		request.setAttribute("mess", mess);
		request.getRequestDispatcher("views/main/edit-parking-lot.jsp").forward(request, response);
	}

}
