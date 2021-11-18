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
 * Servlet implementation class AddEmployeeController
 */
@WebServlet("/AddEmployeeController")
public class AddEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
	DepartmentDAOImpl departmentDAOImpl = new DepartmentDAOImpl();
	EmployeeService employeeService = new EmployeeService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployeeController() {
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
			request.getRequestDispatcher("views/main/add-employee.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
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
			emp.setEmployeeName(employeeName);
			emp.setEmployeePhone(employeePhone);
			emp.setEmployeeBirthdate(employeeBirthdate);
			emp.setSex(gender);
			emp.setEmployeeAddress(employeeAddress);
			emp.setEmployeeEmail(employeeEmail);
			emp.setAccount(account);
			emp.setPassword(password);
			emp.setDepartmentId(departmentId);
			
			if (employeeService.checkAccount(account) == false) {
				boolean checkAcc = false;
				List<Department> departments = departmentDAOImpl.getAllDepartment();

				request.setAttribute("departments", departments);
				request.setAttribute("checkAccount", checkAcc);
				request.getRequestDispatcher("views/main/add-employee.jsp").forward(request, response);
			} else if (employeeService.checkEmail(employeeEmail) == false) {
				boolean checkEmail = false;
				
				List<Department> departments = departmentDAOImpl.getAllDepartment();

				request.setAttribute("departments", departments);
				request.setAttribute("checkEmail", checkEmail);
				request.getRequestDispatcher("views/main/add-employee.jsp").forward(request, response);
			} else if (employeeDAOImpl.addEmployee(emp) == false) {
				List<Department> departments = departmentDAOImpl.getAllDepartment();

				boolean check = true;
				request.setAttribute("check", check);
				request.setAttribute("departments", departments);
				request.getRequestDispatcher("views/main/add-employee.jsp").forward(request, response);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
