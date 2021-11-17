package controller;

import java.io.IOException;
import java.sql.SQLException;
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

		try {
			ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
			ParkingPlaceDAO parkingPlaceDAO = new ParkingPlaceDAOImpl();
			List<ParkingPlace> parkingPlaces = parkingPlaceDAO.getAll();
			List<ParkingLot> parkingLots = parkingLotDAO.getAll();
			request.setAttribute("parkingPlaces", parkingPlaces);
			request.setAttribute("parkingLots", parkingLots);
			request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
	}

}
