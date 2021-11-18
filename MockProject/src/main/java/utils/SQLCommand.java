package utils;

public class SQLCommand {

	/*
	 * SQL Command Employee Author: ThienNT11 Create Date: 09/11/2021
	 */
	public final static String GET_EMPLOYEE = "SELECT [employeeId], [account], [password] FROM [dbo].[employee] WHERE account = ? AND password = ?";

	public final static String GET_ALL_EMPLOYEES = "SELECT * FROM [dbo].[employee]";
	
	public final static String GET_ALL_EMPLOYEES_BY_ROLE = "SELECT * FROM [dbo].[employee] WHERE role = ?";

	public final static String GET_ALL_EMPLOYEES_BY_ACCOUNT = "SELECT * FROM [dbo].[employee] WHERE account = ? ";

	public final static String GET_ALL_EMPLOYEES_BY_ID = "SELECT * FROM [dbo].[employee] WHERE employeeId = ? ";

	public final static String INSERT_EMPLOYEE_INTO_DB = "INSERT INTO [dbo].[employee] ([account],[departmentId],[employeeAddress],[employeeBirthdate],[employeeEmail],[employeeName],[employeePhone],[password],[sex])\n"
			+ "VALUES (?,?,?,?,?,?,?,?,?)";

	public final static String UPDATE_EMPLOYEE_INTO_DB = "UPDATE [dbo].[employee] SET [account] = ?,[departmentId] = ? ,[employeeAddress] = ?,[employeeBirthdate] = ?,[employeeEmail] = ?,[employeeName] = ?\n"
			+ "      ,[employeePhone] = ?,[password] = ?,[sex] = ? WHERE employeeId = ?";

	public final static String DELETE_EMPLOYEE_BY_ID = "DELETE FROM [dbo].[employee] WHERE employeeId = ?";

	/*
	 * SQL Command Department Author: ThienNT11 Create Date: 09/11/2021
	 */

	public final static String GET_ALL_DEPARTMENT = "SELECT [departmentId],[departmentName] FROM [dbo].[department]";

	/*
	 * SQL Command Parking Lot Author: KienNV13 Create Date: 09/11/2021
	 */
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
	 * SQL Command Parking Place Author: KienNV13 Create Date: 10/11/2021
	 */
	public static final String GET_ALL_PARKING_PLACE = "SELECT * FROM packPlace";
	public static final String GET_PARKING_PLACE_BY_ID = "SELECT * FROM packPlace WHERE packPlaceId = ?";

	// =============================================================
	public static final String QUERY_GET_Booking_List = "SELECT ROW_NUMBER() over(order by officeid asc)as r,officeId,officeName,t.destination,b.tripId,officePhone,officePlace,officePrice,startContractDeadline,endContractDeadline\r\n"
			+ "			FROM bookingoffice b join trip t on b.tripId=t.tripId\r\n" + "			order by r asc\r\n"
			+ "			OFFSET ?  ROWS FETCH NEXT 3 ROWS ONLY\r\n";
	public static final String QUERY_BOOKING = "SELECT officeId,officeName,t.destination,b.tripId,officePhone,officePlace,officePrice,startContractDeadline,endContractDeadline,t.destination\r\n"
			+ "FROM bookingoffice b join trip t on b.tripId=t.tripId\r\n" + "WHERE officeId = ?";
	public static final String QUERY_ADD_Booking_List = "\r\n"
			+ "INSERT INTO bookingoffice(officeName,tripId,officePhone,officePlace,officePrice,startContractDeadline,endContractDeadline)\r\n"
			+ "VALUES(?,?,?,?,?,?,?)";
	public static final String QUERY_DELETE_Booking = "\r\n" + "DELETE bookingoffice\r\n" + "WHERE officeId=?";
	public static final String QUERY_UPDATE_Booking = "UPDATE bookingoffice \r\n"
			+ "SET officeName=? , tripId=?,officePhone=?,officePlace=?,officePrice=?,startContractDeadline=?,endContractDeadline=?\r\n"
			+ "WHERE officeId=?";
	public static final String QUERY_COUNT_Booking = "SELECT COUNT(*)\r\n" + "FROM bookingoffice";
	public static final String QUERY_LIST_CBX = "SELECT tripId,destination\r\n" + "FROM trip";
	public static final String QUERY_LIST_CBXBk = "SELECT DISTINCT officePlace\r\n" + "FROM bookingoffice";
	public static final String QUERY_COUNT_BookingName = "SELECT COUNT(*)\r\n" + "FROM bookingoffice\r\n"
			+ "WHERE officeName=?";
	public static final String SEARCH_BOOKINGNAME = "\r\n"
			+ "SELECT * from(SELECT ROW_NUMBER() over(order by officeid asc)as r,officeId,officeName,t.destination,b.tripId,officePhone,officePlace,officePrice,startContractDeadline,endContractDeadline\r\n"
			+ "FROM bookingoffice b join trip t on b.tripId=t.tripId\r\n" + "WHERE officeName like ?) as x\r\n"
			+ "where r between ? and ?";
	public static final String SEARCH_TRIPID = "	SELECT * from(SELECT ROW_NUMBER() over(order by officeid asc)as r,officeId,officeName,t.destination,b.tripId,officePhone,officePlace,officePrice,startContractDeadline,endContractDeadline\r\n"
			+ "			FROM bookingoffice b join trip t on b.tripId=t.tripId\r\n"
			+ "			WHERE b.tripId =?) as r\r\n" + "			where r between ? and ?";

	public static final String Count_TripID = "SELECT COUNT(*)\r\n"
			+ "FROM bookingoffice b join trip t on b.tripId=t.tripId\r\n" + "where b.tripId =?";

	public static final String INSERT_TICKET = "INSERT INTO [dbo].[ticket] ([bookingTime],[bookingDate],[customerName],[licensePlate],[tripId]) VALUES (?,GETDATE(),?,?,?)";
	
	public static final String SEARCH_TICKET = "select ticket.*, trip.destination from ticket join trip on ticket.tripId = trip.tripId ";
	
	public static final String GET_TRIP_FOR_TICKET = "select tripid, destination from trip where bookedTicketNumber < maximumOnlineTicketNumber";
	
	public static final String GET_CAR_FOR_TICKET = "select * from car where licensePlate not in (select licensePlate from ticket)";
	
	public static final String UPDATE_BOOKED_NUMBER = "update trip set bookedTicketNumber = bookedTicketNumber + 1 where tripId = ?";
}
