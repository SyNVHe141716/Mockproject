package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO;
import entities.Employee;
import utils.DBConnection;
import utils.SQLCommand;

public class EmployeeDAOImpl implements EmployeeDAO{
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;
	

	@Override
	public Employee getEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_EMPLOYEE);
			pre.setString(1, employee.getAccount());
			pre.setString(2, employee.getPassword());
			rs = pre.executeQuery();
			while (rs.next()) {
				emp.setEmployeeId(rs.getInt("employeeId"));
				emp.setAccount(rs.getString("account"));
				emp.setPassword(rs.getString("password"));
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return emp;
	}


	@Override
	public boolean registAccountToEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		boolean status = true;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.INSERT_EMPLOYEE_INTO_DB);
			pre.setString(1, employee.getAccount());
			pre.setString(2, employee.getDepartmentId());
			pre.setString(3, employee.getEmployeeAddress());
			pre.setString(4, employee.getEmployeeBirthdate());
			pre.setString(5, employee.getEmployeeEmail());
			pre.setString(6, employee.getEmployeeName());
			pre.setString(7, employee.getEmployeePhone());
			pre.setString(8, employee.getPassword());
			pre.setBoolean(9, employee.isSex());
			status = pre.execute();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return status;
	}


	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_EMPLOYEES);
			rs = pre.executeQuery();
			while(rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setAccount(rs.getString("account"));
				employee.setDepartmentId(rs.getString("departmentId"));
				employee.setEmployeeAddress(rs.getString("employeeAddress"));
				employee.setEmployeeBirthdate(rs.getString("employeeBirthdate"));
				employee.setEmployeeEmail(rs.getString("employeeEmail"));
				employee.setEmployeeName(rs.getString("employeeName"));
				employee.setEmployeePhone(rs.getString("employeePhone"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getBoolean("role"));
				employee.setSex(rs.getBoolean("sex"));
				employees.add(employee);
			}
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pre != null) {
				pre.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return employees;
	}
	
	

}
