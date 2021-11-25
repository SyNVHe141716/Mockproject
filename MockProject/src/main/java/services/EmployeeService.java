package services;

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
	
	public List<Employee> searchEmployeeByName(String name){
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		try {
			Employee employee = new Employee();
			employee.setRole(false);
			
			List<Employee> employees = employeeDAOImpl.getAllEmployeeDepartmentByRole(employee);
			for (Employee emp : employees) {
				if(emp.getEmployeeName().toLowerCase().contains(name.toLowerCase())) {
					listOfEmployees.add(emp);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listOfEmployees;
	}
	
	public List<Employee> searchEmployeeByDateOfBirth(String dateOfBirth){
		try {
			Employee employee = new Employee();
			employee.setRole(false);
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			List<Employee> employees = employeeDAOImpl.getAllEmployeeDepartmentByRole(employee);
			for (Employee emp : employees) {
				if(emp.getEmployeeBirthdate().contains(dateOfBirth)) {
					listOfEmployees.add(emp);
				}
			}
			return listOfEmployees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> searchEmployeeByAddress(String address){
		try {
			Employee employee = new Employee();
			employee.setRole(false);
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			List<Employee> employees = employeeDAOImpl.getAllEmployeeDepartmentByRole(employee);
			for (Employee emp : employees) {
				if(emp.getEmployeeAddress().toLowerCase().contains(address.toLowerCase())) {
					listOfEmployees.add(emp);
				}
			}
			return listOfEmployees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> searchEmployeeByPhoneNumber(String phonenumber){
		try {
			Employee employee = new Employee();
			employee.setRole(false);
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			List<Employee> employees = employeeDAOImpl.getAllEmployeeDepartmentByRole(employee);
			for (Employee emp : employees) {
				if(emp.getEmployeePhone().contains(phonenumber)) {
					listOfEmployees.add(emp);
				}
			}
			return listOfEmployees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> searchEmployeeByDepartment(int departmentId){
		try {
			Employee employee = new Employee();
			employee.setRole(false);
			List<Employee> listOfEmployees = new ArrayList<Employee>();
			List<Employee> employees = employeeDAOImpl.getAllEmployeeDepartmentByRole(employee);
			
			for (Employee emp : employees) {
				if(emp.getDepartmentId() == departmentId) {
					listOfEmployees.add(emp);
				}
			}
			return listOfEmployees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
