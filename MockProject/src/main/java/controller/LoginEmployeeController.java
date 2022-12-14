package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.EmployeeDAOImpl;
import entities.Employee;
import utils.AppUtils;

/**
 * Servlet implementation class LoginEmployeeController
 */
@WebServlet("/LoginController")
public class LoginEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginEmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("views/main/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String account = request.getParameter("username");
			String password = request.getParameter("password");

			Employee employee = new Employee();
			employee.setAccount(account);
			employee.setPassword(password);

			EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
			Employee emp = employeeDAOImpl.getEmployee(employee);

			if (emp.getAccount() != null && emp.getPassword() != null) {
				AppUtils.storeLoginedUser(request.getSession(), emp);
				//
				int redirectId = -1;
				try {
					redirectId = Integer.parseInt(request.getParameter("redirectId"));
				} catch (Exception e) {
				}
				String requestUri = AppUtils.getRedirectAfterLoginUrl(request.getSession(), redirectId);
				if (requestUri != null) {
					response.sendRedirect(requestUri);
				} else {
					// Mặc định sau khi đăng nhập thành công
					if (emp.getRole() == true) {
						response.sendRedirect("ListEmployeeController");
					} else {
						response.sendRedirect("parking-lot-list");
					}
				}

			} else {
				request.setAttribute("acc", account);
				request.getRequestDispatcher("views/main/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
