package dao;
/**
 * @author thienNT11
 *
 */

import java.sql.SQLException;
import java.util.List;

import entities.Employee;

public interface EmployeeDAO {

	public Employee getEmployee(Employee employee) throws SQLException;
	
	public boolean registAccountToEmployee(Employee employee) throws SQLException;
	
	public List<Employee> getAllEmployees() throws SQLException;
}
