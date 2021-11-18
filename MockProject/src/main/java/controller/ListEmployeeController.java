package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.DepartmentDAOImpl;
import dao.impl.EmployeeDAOImpl;
import entities.Department;
import entities.Employee;

/**
 * Servlet implementation class ListEmployeeController
 */
@WebServlet("/ListEmployeeController")
public class ListEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
	DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Employee> employees = employeeDAOImpl.getAllEmployees();
			List<Department> departments = departmentDAOImpl.getAllDepartment();

			request.setAttribute("departments", departments);
			request.setAttribute("employees", employees);
			request.getRequestDispatcher("views/main/employee-list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
