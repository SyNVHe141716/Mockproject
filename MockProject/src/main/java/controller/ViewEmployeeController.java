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
import services.EmployeeService;

/**
 * Servlet implementation class ViewEmployeeController
 */
@WebServlet("/ViewEmployeeController")
public class ViewEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
	DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl();
	EmployeeService employeeService = new EmployeeService();
	int id = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewEmployeeController() {
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
			Employee employee = (Employee) request.getSession().getAttribute("employee");
			id = employee.getEmployeeId();
			if (request.getParameter("id") != null) {
				id = Integer.parseInt(request.getParameter("id"));
				List<Employee> employees = employeeDAOImpl.getAllEmployeesById(id);
				List<Department> departments = departmentDAOImpl.getAllDepartment();

				request.setAttribute("departments", departments);
				request.setAttribute("employees", employees);
				request.getRequestDispatcher("views/main/view-employee.jsp").forward(request, response);
			} else {

				List<Employee> employees = employeeDAOImpl.getAllEmployeesById(id);
				List<Department> departments = departmentDAOImpl.getAllDepartment();

				request.setAttribute("departments", departments);
				request.setAttribute("employees", employees);
				request.getRequestDispatcher("views/main/view-employee.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int employeeId = Integer.parseInt(request.getParameter("id"));
			String employeeName = request.getParameter("fullname");
			String employeePhone = request.getParameter("phonenumber");
			String employeeBirthdate = request.getParameter("dateofbirth");
			boolean gender = Boolean.parseBoolean(request.getParameter("sex"));
			String employeeAddress = request.getParameter("address");
			String employeeEmail = request.getParameter("email");
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			int departmentId = Integer.parseInt(request.getParameter("department"));

			Employee emp = new Employee();
			emp.setEmployeeId(employeeId);
			emp.setEmployeeName(employeeName);
			emp.setEmployeePhone(employeePhone);
			emp.setEmployeeBirthdate(employeeBirthdate);
			emp.setSex(gender);
			emp.setEmployeeAddress(employeeAddress);
			emp.setEmployeeEmail(employeeEmail);
			emp.setAccount(account);
			emp.setPassword(password);
			emp.setDepartmentId(departmentId);

			if (employeeService.checkEmail(employeeEmail) == false) {
				boolean checkEmail = false;
				List<Employee> employees = employeeDAOImpl.getAllEmployeesById(id);
				List<Department> departments = departmentDAOImpl.getAllDepartment();

				request.setAttribute("departments", departments);
				request.setAttribute("employees", employees);
				request.setAttribute("checkEmail", checkEmail);
				request.getRequestDispatcher("views/main/view-employee.jsp").forward(request, response);
			} else if (employeeService.checkAccount(account) == false) {
				boolean checkAcc = false;
				List<Employee> employees = employeeDAOImpl.getAllEmployeesById(id);
				List<Department> departments = departmentDAOImpl.getAllDepartment();

				request.setAttribute("departments", departments);
				request.setAttribute("employees", employees);
				request.setAttribute("checkAccount", checkAcc);
				request.getRequestDispatcher("views/main/view-employee.jsp").forward(request, response);
			} else if (employeeDAOImpl.updateEmployee(emp) == false) {
				List<Employee> employees = employeeDAOImpl.getAllEmployeesById(id);
				List<Department> departments = departmentDAOImpl.getAllDepartment();

				request.setAttribute("departments", departments);
				request.setAttribute("employees", employees);
				boolean check = true;
				request.setAttribute("check", check);
				request.getRequestDispatcher("views/main/view-employee.jsp").forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
