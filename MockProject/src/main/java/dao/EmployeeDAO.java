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

	public boolean updateEmployee(Employee employee) throws SQLException;

	public boolean addEmployee(Employee employee) throws SQLException;

	public List<Employee> getAllEmployees() throws SQLException;

	public List<Employee> getAllEmployeesById(int id) throws SQLException;

	public List<Employee> getEmployeesByAccount(Employee employee) throws SQLException;

	public boolean deleteEmployee(int id) throws SQLException;
}
