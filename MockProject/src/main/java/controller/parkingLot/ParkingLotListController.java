package controller.parkingLot;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingLotDAO;
import dao.ParkingPlaceDAO;
import dao.impl.CarDAOImpl;
import dao.impl.ParkingLotDAOImpl;
import dao.impl.ParkingPlaceDAOImpl;
import entities.Car;
import entities.ParkingLot;
import entities.ParkingPlace;

/**
 * Servlet implementation class ParkingLotListController
 */
@WebServlet("/parking-lot-list")
public class ParkingLotListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkingLotListController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("packId");
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		CarDAOImpl a = new CarDAOImpl();
		ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
		ParkingPlaceDAO parkingPlaceDAO = new ParkingPlaceDAOImpl();
		if (pid == null) {
			try {
				parkingLots = parkingLotDAO.getAll();
				List<ParkingPlace> parkingPlaces = parkingPlaceDAO.getAll();
				request.setAttribute("parkingPlaces", parkingPlaces);
			} catch (SQLException e) {
				e.printStackTrace();
				request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
			}
		} else {
			try {
				int id = Integer.parseInt(pid);
				ParkingLot p = parkingLotDAO.getById(id);
				parkingLots.add(p);
				List<ParkingPlace> parkingPlaces = parkingPlaceDAO.getAll();
				request.setAttribute("parkingPlaces", parkingPlaces);
			} catch (SQLException e) {
				e.printStackTrace();
				request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
			}
		}
		request.setAttribute("parkingLots", parkingLots);

		boolean activeParkingLotList = true;
		request.setAttribute("activeParkingLotList", activeParkingLotList);
		request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		boolean activeParkingLotList = true;
//		request.setAttribute("activeParkingLotList", activeParkingLotList);
		request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
	}

}
