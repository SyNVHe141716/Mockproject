package services;

import java.util.List;

import dao.impl.EmployeeDAOImpl;
import entities.Employee;

public class EmployeeService {
	EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

	public boolean checkAccount(Employee employee) {
		try {
			List<Employee> employees = employeeDAOImpl.getAllEmployees();

			for (Employee emp : employees) {
				if (emp.getAccount().equals(employee.getAccount())) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean checkEmail(Employee employee) {
		try {
			List<Employee> employees = employeeDAOImpl.getAllEmployees();

			for (Employee emp : employees) {
				if (emp.getEmployeeEmail().equals(employee.getEmployeeEmail())) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
