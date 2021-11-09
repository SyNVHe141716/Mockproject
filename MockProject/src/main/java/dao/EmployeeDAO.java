package dao;

import java.sql.SQLException;

import entities.Employee;

public interface EmployeeDAO {

	public Employee getEmployee(Employee employee) throws SQLException;
	
	public boolean registAccountToEmployee(Employee employee) throws SQLException;
}
