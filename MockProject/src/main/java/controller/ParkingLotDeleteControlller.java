package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ParkingLotDAO;
import dao.impl.ParkingLotDAOImpl;
import entities.ParkingLot;

/**
 * Servlet implementation class ParkingLotDeleteControlller
 */
@WebServlet("/parking-lot-delete")
public class ParkingLotDeleteControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ParkingLotDeleteControlller() {
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
			int id = Integer.parseInt(request.getParameter("id"));
			ParkingLotDAO parkingLotDAO = new ParkingLotDAOImpl();
			if (parkingLotDAO.delete(id)) {
				mess = "Delete successfully!";
			} else {
				mess = "Not exist id = " + id + "!";
			}
			String pageIndex = request.getParameter("index");
			if (pageIndex == null) {
				pageIndex = "1";
			}
			int index = Integer.parseInt(pageIndex);
			int total = parkingLotDAO.getAll().size();
			int pageSize = 5;
			int maxPage = (total % pageSize == 0) ? (total / pageSize) : (total / pageSize) + 1;
			List<ParkingLot> parkingLots = parkingLotDAO.getByPage(index, pageSize);
			request.setAttribute("parkingLots", parkingLots);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("index", index);
		} catch (Exception e) {
			mess = "Delete fail in SQL!";
			e.printStackTrace();
		}
		request.setAttribute("mess", mess);
		request.getRequestDispatcher("views/main/parking-lot-list.jsp").forward(request, response);
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
