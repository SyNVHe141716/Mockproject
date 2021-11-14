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
 * Servlet implementation class ParkingLotSearchController
 */
@WebServlet("/parking-lot-search")
public class ParkingLotSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkingLotSearchController() {
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
		List<ParkingPlace> parkingPlaces;
		try {
			parkingPlaces = parkingPlaceDAO.getAll();
			request.setAttribute("parkingPlaces", parkingPlaces);
		} catch (SQLException e) {
			e.printStackTrace();
			String mess = "Fail in SQL";
			request.setAttribute("mess", mess);
		}
		request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String category = request.getParameter("category");
		ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
		List<ParkingLot> parkingLotSearch = null;
		String mess = "";
		try {
			if (category.equalsIgnoreCase("name")) {
				String txtSearch = request.getParameter("name-search");
				if (txtSearch.isEmpty())
					mess = "Please fill name to search";
				else {
					parkingLotSearch = parkingLotDAO.searchByName(txtSearch);
					request.setAttribute("txtSearch", txtSearch);
				}
			} else if (category.equalsIgnoreCase("area")) {
				if (!(request.getParameter("from") == "") && !(request.getParameter("to") == "")) {
					int minArea = Integer.parseInt(request.getParameter("from"));
					int maxArea = Integer.parseInt(request.getParameter("to"));
					parkingLotSearch = parkingLotDAO.searchByArea(minArea, maxArea);
				} else
					mess = "Please fill all field search";
			} else if (category.equalsIgnoreCase("price")) {
				if (!(request.getParameter("from") == "") && !(request.getParameter("to") == "")) {
					int minPrice = Integer.parseInt(request.getParameter("from"));
					int maxPrice = Integer.parseInt(request.getParameter("to"));
					parkingLotSearch = parkingLotDAO.searchByPrice(minPrice, maxPrice);
				} else
					mess = "Please fill all field to search";
			} else if (category.equalsIgnoreCase("place")) {
				int placeId = Integer.parseInt(request.getParameter("select-place"));
				parkingLotSearch = parkingLotDAO.searchByPlace(placeId);
				request.setAttribute("placeId", placeId);
			}
			request.setAttribute("category", category);
			request.setAttribute("mess", mess);
			request.setAttribute("parkingLots", parkingLotSearch);
			ParkingPlaceDAO parkingPlaceDAO = new ParkingPlaceDAOImpl();
			List<ParkingPlace> parkingPlaces = parkingPlaceDAO.getAll();
			request.setAttribute("parkingPlaces", parkingPlaces);
		} catch (Exception e) {
			e.printStackTrace();
			mess = "Fail in SQL";
			request.setAttribute("mess", mess);
		}
		request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
	}

}
