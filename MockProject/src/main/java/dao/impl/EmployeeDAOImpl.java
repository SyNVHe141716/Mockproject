package dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.EmployeeDAO;
import entities.Department;
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
				emp.setRole(rs.getBoolean("role"));
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
	public boolean updateEmployee(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		boolean status = true;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.UPDATE_EMPLOYEE_INTO_DB);
			pre.setString(1, employee.getAccount());
			pre.setInt(2, employee.getDepartmentId());
			pre.setString(3, employee.getEmployeeAddress());
			pre.setDate(4, Date.valueOf(employee.getEmployeeBirthdate()));
			pre.setString(5, employee.getEmployeeEmail());
			pre.setString(6, employee.getEmployeeName());
			pre.setString(7, employee.getEmployeePhone());
			pre.setString(8, employee.getPassword());
			pre.setBoolean(9, employee.isSex());
			pre.setInt(10, employee.getEmployeeId());
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
				employee.setDepartmentId(rs.getInt("departmentId"));
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


	@Override
	public List<Employee> getEmployeesByAccount(Employee employee) throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp = null;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_EMPLOYEES_BY_ACCOUNT);
			pre.setString(1, employee.getAccount());
			rs = pre.executeQuery();
			while(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employeeId"));
				emp.setAccount(rs.getString("account"));
				emp.setDepartmentId(rs.getInt("departmentId"));
				emp.setEmployeeAddress(rs.getString("employeeAddress"));
				emp.setEmployeeBirthdate(rs.getString("employeeBirthdate"));
				emp.setEmployeeEmail(rs.getString("employeeEmail"));
				emp.setEmployeeName(rs.getString("employeeName"));
				emp.setEmployeePhone(rs.getString("employeePhone"));
				emp.setPassword(rs.getString("password"));
				emp.setRole(rs.getBoolean("role"));
				emp.setSex(rs.getBoolean("sex"));
				employees.add(emp);
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


	@Override
	public List<Employee> getAllEmployeesById(int id) throws SQLException {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<Employee>();
		Employee emp = null;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_EMPLOYEES_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while(rs.next()) {
				emp = new Employee();
				emp.setEmployeeId(rs.getInt("employeeId"));
				emp.setAccount(rs.getString("account"));
				emp.setDepartmentId(rs.getInt("departmentId"));
				emp.setEmployeeAddress(rs.getString("employeeAddress"));
				emp.setEmployeeBirthdate(rs.getString("employeeBirthdate"));
				emp.setEmployeeEmail(rs.getString("employeeEmail"));
				emp.setEmployeeName(rs.getString("employeeName"));
				emp.setEmployeePhone(rs.getString("employeePhone"));
				emp.setPassword(rs.getString("password"));
				emp.setRole(rs.getBoolean("role"));
				emp.setSex(rs.getBoolean("sex"));
				employees.add(emp);
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


	@Override
	public boolean addEmployee(Employee employee) throws SQLException {
		boolean status = true;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.INSERT_EMPLOYEE_INTO_DB);
			pre.setString(1, employee.getAccount());
			pre.setInt(2, employee.getDepartmentId());
			pre.setString(3, employee.getEmployeeAddress());
			pre.setDate(4, Date.valueOf(employee.getEmployeeBirthdate()));
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
	public boolean deleteEmployee(int id) throws SQLException {
		boolean status = true;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.DELETE_EMPLOYEE_BY_ID);
			pre.setInt(1, id);
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
	public List<Employee> getAllEmployeesByRole(Employee empl) throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_EMPLOYEES_BY_ROLE);
			pre.setBoolean(1, empl.getRole());
			rs = pre.executeQuery();
			while(rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setAccount(rs.getString("account"));
				employee.setDepartmentId(rs.getInt("departmentId"));
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


	@Override
	public List<Employee> getAllEmployeeDepartmentByRole(Employee emp) throws SQLException {
		List<Employee> employees = new ArrayList<Employee>();
		Employee employee = null;
		Department department = null;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_EMPLOYEES_DEPARTMENT_BY_ROLE);
			pre.setBoolean(1, emp.getRole());
			rs = pre.executeQuery();
			while(rs.next()) {
				employee = new Employee();
				department = new Department();
				employee.setEmployeeId(rs.getInt("employeeId"));
				employee.setAccount(rs.getString("account"));
				employee.setDepartmentId(rs.getInt("departmentId"));
				employee.setEmployeeAddress(rs.getString("employeeAddress"));
				employee.setEmployeeBirthdate(rs.getString("employeeBirthdate"));
				employee.setEmployeeEmail(rs.getString("employeeEmail"));
				employee.setEmployeeName(rs.getString("employeeName"));
				employee.setEmployeePhone(rs.getString("employeePhone"));
				employee.setPassword(rs.getString("password"));
				employee.setRole(rs.getBoolean("role"));
				employee.setSex(rs.getBoolean("sex"));
				department.setDepartmentName(rs.getString("deptName"));
				employee.setDepartment(department);
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
