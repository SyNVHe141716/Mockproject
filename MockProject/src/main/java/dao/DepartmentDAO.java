/**
 * 
 */
package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Department;

/**
 * @author thienNT11
 *
 */
public interface DepartmentDAO {
	public List<Department> getAllDepartment() throws SQLException;
}
