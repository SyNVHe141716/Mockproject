package utils;

public class SQLCommand {

	/*
	 * SQL Command Employee
	 *  Author: ThienNT11 
	 *  Create Date: 09/11/2021
	 */
	public final static String GET_EMPLOYEE = "SELECT [employeeId], [account], [password] FROM [dbo].[employee] WHERE account = ? AND password = ?";
	
	public final  static String GET_ALL_EMPLOYEES = "SELECT * FROM [dbo].[employee]";

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
	
	
	
	/*
	 * SQL Command Parking Lot
	 * Author: KienNV13
	 * Create Date: 09/11/2021
	 * */
	public static final String GET_ALL_PARKING_LOT = "SELECT * FROM packinglot";
	public static final String ADD_PARKING_LOT = "INSERT INTO packinglot( [packName], [packPlaceId], [packArea] , [packPrice], [packStatus]) VALUES(?, ?, ?, ?, ?)";
	public static final String DELETE_PARKING_LOT = "DELETE FROM packinglot WHERE packId = ?";
	public static final String UPDATE_PARKING_LOT = "UPDATE packinglot SET packName = ?, packPlaceId = ?, packArea = ?, packPrice = ?, packStatus = ? WHERE packId = ?";
	public static final String GET_PARKINGLOT_BY_ID = "SELECT * FROM packinglot WHERE packId = ?";
	public static final String QUERY_SEARCH_PARKINGLOT_BY_NAME = "SELECT * FROM packinglot WHERE packName LIKE ?";
	public static final String QUERY_SEARCH_PARKINGLOT_BY_PLACE_ID = "SELECT * FROM packinglot WHERE packPlaceId = ?";
	public static final String QUERY_SEARCH_PARKINGLOT_BY_STATUS = "SELECT * FROM packinglot WHERE packStatus = ?";
	public static final String QUERY_SEARCH_PARKINGLOT_BY_AREA = "SELECT * FROM packinglot WHERE packArea BETWEEN ? AND ?";
	public static final String QUERY_SEARCH_PARKINGLOT_BY_PRICE = "SELECT * FROM packinglot WHERE packPrice BETWEEN ? AND ?";
	public static final String GET_PARKINGLOT_BY_PAGE = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY [packId] ASC) AS rn, * FROM [packinglot]) AS x WHERE rn BETWEEN (?-1)*?+1 and ?*?";
	public static final String GET_PARKINGLOT_BY_NAME = "SELECT * FROM packinglot WHERE packName = ?";
	
	/**
	 * SQL Command Parking Place
	 * Author: KienNV13
	 * Create Date: 10/11/2021
	 */
	public static final String GET_ALL_PARKING_PLACE = "SELECT * FROM packPlace";
	public static final String GET_PARKING_PLACE_BY_ID =  "SELECT * FROM packPlace WHERE packPlaceId = ?";
	
	//=============================================================
	public static final String QUERY_GET_Booking_List = "SELECT officeId,officeName,t.destination\r\n"
			+ "FROM bookingoffice b join trip t on b.tripId=t.tripId\r\n"
			+ "ORDER BY officeId\r\n"
			+ "OFFSET ?  ROWS FETCH NEXT 3 ROWS ONLY";
	public static final String QUERY_ADD_Booking_List ="\r\n"
			+ "INSERT INTO bookingoffice(officeName,tripId,officePhone,officePlace,officePrice,startContractDeadline,endContractDeadline)\r\n"
			+ "VALUES(?,?,?,?,?,?,?)";
	public static final String QUERY_DELETE_Booking="\r\n"
			+ "DELETE bookingoffice\r\n"
			+ "WHERE officeId=?";
	public static final String QUERY_UPDATE_Booking="UPDATE bookingoffice \r\n"
			+ "SET officeName=? , tripId=1,officePhone=?,officePlace=?,officePrice=?,startContractDeadline=?,endContractDeadline=?\r\n"
			+ "WHERE officeId=?" ;



	
}
