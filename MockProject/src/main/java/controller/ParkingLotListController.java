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
			String pageIndex = request.getParameter("index");
			if (pageIndex == null) {
				pageIndex = "1";
			}
			int index = Integer.parseInt(pageIndex);
			int total = parkingLotDAO.getAll().size();
			int pageSize = 5;
			int maxPage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize) + 1;
			List<ParkingLot> parkingLots = parkingLotDAO.getByPage(index, pageSize);
			request.setAttribute("parkingPlaces", parkingPlaces);
			request.setAttribute("parkingLots", parkingLots);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("index", index);
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
		String category = request.getParameter("category");
		ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
		List<ParkingLot> parkingLotSearch = null;
		try {
			if (category.equalsIgnoreCase("name")) {
				String txtSearch = request.getParameter("name-search");
				if (!txtSearch.equalsIgnoreCase("")) {
					parkingLotSearch = parkingLotDAO.searchByName(txtSearch);
				}
				String pageIndex = request.getParameter("index");
				if (pageIndex == null) {
					pageIndex = "1";
				}
				int index = Integer.parseInt(pageIndex);
				int total = parkingLotSearch.size();
				int pageSize = 5;
				int maxPage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize) + 1;
				List<ParkingLot> parkingLots = parkingLotDAO.getByPage(index, pageSize);
				request.setAttribute("parkingLots", parkingLots);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("index", index);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String mess = "Fail in SQL";
			request.setAttribute("mess", mess);
		}

		request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
	}

//		int from = Integer.parseInt(request.getParameter("from"));
//		int to = Integer.parseInt(request.getParameter("to"));

}
