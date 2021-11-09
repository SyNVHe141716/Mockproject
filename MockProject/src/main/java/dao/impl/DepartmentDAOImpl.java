package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DepartmentDAO;
import entities.Department;
import utils.DBConnection;
import utils.SQLCommand;

public class DepartmentDAOImpl implements DepartmentDAO{
	
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public List<Department> getAllDepartment() throws SQLException {
		// TODO Auto-generated method stub
		List<Department> departments = new ArrayList<Department>();
		Department department = null;
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_DEPARTMENT);
			rs = pre.executeQuery();
			while (rs.next()) {
				department = new Department();
				department.setDepartmentId(rs.getInt("departmentId"));
				department.setDepartmentName(rs.getString("departmentName"));
				departments.add(department);
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
		return departments;
	}

}
