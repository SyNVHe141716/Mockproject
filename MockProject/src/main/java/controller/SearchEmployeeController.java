package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.impl.DepartmentDAOImpl;
import entities.Department;
import entities.Employee;
import services.EmployeeService;

/**
 * Servlet implementation class SearchEmployeeController
 */
@WebServlet("/SearchEmployeeController")
public class SearchEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			List<Department> departments = departmentDAOImpl.getAllDepartment();
			
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("views/main/employee-list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String category = request.getParameter("category");
			String inputSearch = request.getParameter("input-search");
			String selectdepartment = request.getParameter("selectdepartment");
			
			EmployeeService employeeService = new EmployeeService();
			List<Employee> employees = new ArrayList<Employee>();
			List<Department> departments = departmentDAOImpl.getAllDepartment();
			
			if(category.equals("name")) {
				employees = employeeService.searchEmployeeByName(inputSearch);
			}
			if(category.equals("dateofbirth")) {
				employees = employeeService.searchEmployeeByDateOfBirth(inputSearch);
			}
			if(category.equals("address")) {
				employees = employeeService.searchEmployeeByAddress(inputSearch);
			}
			if(category.equals("phonenumber")) {
				employees = employeeService.searchEmployeeByPhoneNumber(inputSearch);
			}
			if(category.equals("department")) {
				employees = employeeService.searchEmployeeByDepartment(Integer.parseInt(selectdepartment));
			}
			
			request.setAttribute("selectdepartment", Integer.parseInt(selectdepartment));
			request.setAttribute("inputSearch", inputSearch);
			request.setAttribute("category", category);
			request.setAttribute("employees", employees);
			request.setAttribute("departments", departments);
			request.getRequestDispatcher("views/main/employee-list.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
