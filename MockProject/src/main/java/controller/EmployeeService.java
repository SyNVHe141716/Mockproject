package controller;

import java.util.ArrayList;
import java.util.List;

import dao.impl.EmployeeDAOImpl;
import entities.Employee;

public class EmployeeService {
	EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();

	public boolean checkAccount(String account) {
		try {
			List<Employee> employees = employeeDAOImpl.getAllEmployees();
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			//Create new list not have current account
			for (Employee empl : employees) {
				if (!empl.getAccount().equals(account)) {
					listOfEmployees.add(empl);
				}
			}
			//Check account dulicate
			for (Employee emp : listOfEmployees) {
				if (emp.getAccount().equals(account)) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean checkEmail(String email) {
		try {
			List<Employee> employees = employeeDAOImpl.getAllEmployees();
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			//Create new list not have current email
			for (Employee empl : employees) {
				if (!empl.getEmployeeEmail().equals(email)) {
					listOfEmployees.add(empl);
				}
			}
			//Check email dulicate
			for (Employee emp : listOfEmployees) {
				if (emp.getEmployeeEmail().equals(email)) {
					return false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}
