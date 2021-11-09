package utils;

public class SQLCommand {

	/*
	 * SQL Command Employee
	 *  Author: ThienNT11 
	 *  Create Date: 09/11/2021
	 */
	public final static String GET_EMPLOYEE = "SELECT [employeeId], [account], [password] FROM [dbo].[employee] WHERE account = ? AND password = ?";

	public final static String INSERT_EMPLOYEE_INTO_DB = "INSERT INTO [dbo].[employee] ([account],[departmentId],[employeeAddress],[employeeBirthdate],[employeeEmail],[employeeName],[employeePhone],[password],[sex]\n"
			+ "     VALUES (?,?,?,?,?,?,?,?,?)";

	public final static String UPDATE_EMPLOYEE_INTO_DB = "UPDATE [dbo].[employee] SET [account] = ?,[departmentId] = ? ,[employeeAddress] = ?,[employeeBirthdate] = ?,[employeeEmail] = ?,[employeeName] = ?\n"
			+ "      ,[employeePhone] = ?,[password] = ?,[sex] = ?,[role] = ? WHERE employeeId = ?";
	
	public final static String DELETE_EMPLOYEE_BY_ID = "DELETE FROM [dbo].[employee] WHERE employeeId = ?";
	
	/*
	 * SQL Command Department
	 * Author: ThienNT11 
	 * Create Date: 09/11/2021
	 * */
	
	public final static String GET_ALL_DEPARTMENT= "SELECT [departmentId],[departmentName] FROM [dbo].[department]";
}
