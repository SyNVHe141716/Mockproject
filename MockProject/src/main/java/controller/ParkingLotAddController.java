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
 * Servlet implementation class ParkingLotAddController
 */
@WebServlet("/add-parking-lot")
public class ParkingLotAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkingLotAddController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ParkingPlaceDAO parkingPlaceDAO = new ParkingPlaceDAOImpl();
		String mess = "";
		try {
			List<ParkingPlace> parkingPlaces = parkingPlaceDAO.getAll();
			request.setAttribute("parkingPlaces", parkingPlaces);
		} catch (SQLException e) {
			e.printStackTrace();
			mess = "Fail on SQL when get parking places";
			request.setAttribute("mess", mess);
		}
		boolean activeParkingLotAdd = true;
		request.setAttribute("activeParkingLotAdd", activeParkingLotAdd);
		request.getRequestDispatcher("views/main/add-parking-lot.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		int placeId = Integer.parseInt(request.getParameter("placeId"));
		int area = Integer.parseInt(request.getParameter("area"));
		int price = Integer.parseInt(request.getParameter("price"));
		ParkingLot parkingLot = new ParkingLot(name, placeId, area, price, false);
		ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
		ParkingPlaceDAO parkingPlaceDAO = new ParkingPlaceDAOImpl();
		String mess = "";

		try {
			List<ParkingPlace> parkingPlaces = parkingPlaceDAO.getAll();
			request.setAttribute("parkingPlaces", parkingPlaces);

			if (parkingLotDAO.getByName(name.toLowerCase()) == null) {
				if (parkingLotDAO.add(parkingLot)) {
					mess = "Add Parking Lot Successfully!";

				} else {
					mess = "Add Parking Lot Fail!";
				}
			} else {
				mess = "Parking Slot name \"" + name + "\" was existed!";
			}
			boolean activeParkingLotAdd = true;
			request.setAttribute("activeParkingLotAdd", activeParkingLotAdd);
		} catch (Exception e) {
			mess = "Add Parking Lot Fail in SQL!";
			e.printStackTrace();
		}
		request.setAttribute("mess", mess);
		request.getRequestDispatcher("views/main/add-parking-lot.jsp").forward(request, response);
	}

}
