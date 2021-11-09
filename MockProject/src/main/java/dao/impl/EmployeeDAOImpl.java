package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			pre.setString(9, employee.getSex());
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
	
	

}
