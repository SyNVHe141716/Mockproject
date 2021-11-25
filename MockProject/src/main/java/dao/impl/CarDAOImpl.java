package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CarDAO;
import entities.Car;
import entities.Company;
import entities.ParkingLot;
import utils.DBConnection;

public class CarDAOImpl implements CarDAO {
	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public int addCar(Car car) throws SQLException {
		int row = 0;
		try {
			String sql = "INSERT INTO [dbo].[car]\r\n" + "           ([licensePlate]\r\n" + "           ,[carColor]\r\n"
					+ "           ,[carType]\r\n" + "           ,[companyId]\r\n" + "           ,[packId])\r\n"
					+ "     VALUES\r\n" + "           (?,?,?,?,?)";
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, car.getLicensePlate());
			pre.setString(2, car.getCarColor());
			pre.setString(3, car.getCarType());
			pre.setInt(4, car.getCompanyId());
			pre.setInt(5, car.getPackId());
			row = pre.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
		}
		return row;
	}

	@Override
	public List<Company> getAllCompany() throws SQLException {
		List<Company> companies = new ArrayList<Company>();
		try {
			String sql = "select * from company";
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Company c = new Company();
				c.setCompanyId(rs.getInt("companyId"));
				c.setCompanyName(rs.getString("companyName"));
				companies.add(c);
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
		return companies;
	}

	@Override
	public List<Car> getAllCart() throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		try {
			String sql = "select c.licensePlate,c.carColor,c.carType , n.companyName, p.packName, p.packId  from car c\r\n"
					+ "					inner join packinglot p on p.packId = c.packId\r\n"
					+ "					inner join company n on n.companyId = c.companyId";
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				Car c = new Car();
				ParkingLot p = new ParkingLot();
				Company y = new Company();
				c.setLicensePlate(rs.getString("licensePlate"));
				c.setCarColor(rs.getString("carColor"));
				c.setCarType(rs.getString("carType"));
				y.setCompanyName(rs.getString("companyName"));
				p.setName(rs.getString("packName"));
				p.setId(rs.getInt("packId"));
				c.setParkingLot(p);
				c.setCompany(y);
				cars.add(c);
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
		return cars;
	}

	@Override
	public int update(Car car) throws SQLException {
		int row = 0;
		try {
			String sql = "UPDATE [dbo].[car]\r\n" + "   SET [carColor] = ?\r\n" + "      ,[carType] = ?\r\n"
					+ "      ,[companyId] = ?\r\n" + "      ,[packId] = ?\r\n" + " WHERE licensePlate = ?";

			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, car.getCarColor());
			pre.setString(2, car.getCarType());
			pre.setInt(3, car.getCompanyId());
			pre.setInt(4, car.getPackId());
			pre.setString(5, car.getLicensePlate());
			row = pre.executeUpdate();
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
		return row;
	}

	@Override
	public int delete(String licensePlate) throws SQLException {
		int row = 0;
		try {
			String sql = "delete car WHERE licensePlate = ?";

			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, licensePlate);
			row = pre.executeUpdate();
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
		return row;
	}

	@Override
	public Car searchByLicensePlate(String lincensePlate) throws SQLException {
		try {
			String sql = "select * from car where licensePlate = ?";
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, lincensePlate);
			rs = pre.executeQuery();
			while (rs.next()) {
				Car c = new Car();
				c.setLicensePlate(rs.getString(1));
				c.setCarColor(rs.getString(2));
				c.setCarType(rs.getString(3));
				c.setCompanyId(rs.getInt(4));
				c.setPackId(rs.getInt(5));
				return c;
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
		return null;
	}

	@Override
	public List<Car> getAlllicensePlate(String licensePlate) throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		String sql = "select c.licensePlate,c.carColor,c.carType , n.companyName, p.packName, p.packId  from car c\r\n"
				+ "									inner join packinglot p on p.packId = c.packId\r\n"
				+ "									inner join company n on n.companyId = c.companyId where c.licensePlate like ?";
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + licensePlate + "%");
			rs = pre.executeQuery();
			while (rs.next()) {
				Car c = new Car();
				ParkingLot p = new ParkingLot();
				Company y = new Company();
				c.setLicensePlate(rs.getString("licensePlate"));
				c.setCarColor(rs.getString("carColor"));
				c.setCarType(rs.getString("carType"));
				y.setCompanyName(rs.getString("companyName"));
				p.setName(rs.getString("packName"));
				p.setId(rs.getInt("packId"));
				c.setParkingLot(p);
				c.setCompany(y);
				cars.add(c);
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
		return cars;
	}

	@Override
	public List<Car> getAllcarColor(String carColor) throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		String sql = "select c.licensePlate,c.carColor,c.carType , n.companyName, p.packName, p.packId  from car c\r\n"
				+ "									inner join packinglot p on p.packId = c.packId\r\n"
				+ "									inner join company n on n.companyId = c.companyId where c.carColor like ?";
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + carColor + "%");
			rs = pre.executeQuery();
			while (rs.next()) {
				Car c = new Car();
				ParkingLot p = new ParkingLot();
				Company y = new Company();
				c.setLicensePlate(rs.getString("licensePlate"));
				c.setCarColor(rs.getString("carColor"));
				c.setCarType(rs.getString("carType"));
				y.setCompanyName(rs.getString("companyName"));
				p.setName(rs.getString("packName"));
				p.setId(rs.getInt("packId"));
				c.setParkingLot(p);
				c.setCompany(y);
				cars.add(c);
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
		return cars;
	}

	@Override
	public List<Car> getAllcarType(String carType) throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		String sql = "select c.licensePlate,c.carColor,c.carType , n.companyName, p.packName, p.packId  from car c\r\n"
				+ "									inner join packinglot p on p.packId = c.packId\r\n"
				+ "									inner join company n on n.companyId = c.companyId where c.carType like ?";
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, "%" + carType + "%");
			rs = pre.executeQuery();
			while (rs.next()) {
				Car c = new Car();
				ParkingLot p = new ParkingLot();
				Company y = new Company();
				c.setLicensePlate(rs.getString("licensePlate"));
				c.setCarColor(rs.getString("carColor"));
				c.setCarType(rs.getString("carType"));
				y.setCompanyName(rs.getString("companyName"));
				p.setName(rs.getString("packName"));
				p.setId(rs.getInt("packId"));
				c.setParkingLot(p);
				c.setCompany(y);
				cars.add(c);
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
		return cars;
	}

	@Override
	public List<Car> getAllcompanyName(String companyName) throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		String sql = "select c.licensePlate,c.carColor,c.carType , n.companyName, p.packName, p.packId  from car c\r\n"
				+ "									inner join packinglot p on p.packId = c.packId\r\n"
				+ "									inner join company n on n.companyId = c.companyId where n.companyName = ?";
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, companyName);
			rs = pre.executeQuery();
			while (rs.next()) {
				Car c = new Car();
				ParkingLot p = new ParkingLot();
				Company y = new Company();
				c.setLicensePlate(rs.getString("licensePlate"));
				c.setCarColor(rs.getString("carColor"));
				c.setCarType(rs.getString("carType"));
				y.setCompanyName(rs.getString("companyName"));
				p.setName(rs.getString("packName"));
				p.setId(rs.getInt("packId"));
				c.setParkingLot(p);
				c.setCompany(y);
				cars.add(c);
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
		return cars;
	}

	@Override
	public List<Car> getAllpackName(String packName) throws SQLException {
		List<Car> cars = new ArrayList<Car>();
		String sql = "select c.licensePlate,c.carColor,c.carType , n.companyName, p.packName, p.packId  from car c\r\n"
				+ "									inner join packinglot p on p.packId = c.packId\r\n"
				+ "									inner join company n on n.companyId = c.companyId where p.packName = ?";
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			pre.setString(1, packName);
			rs = pre.executeQuery();
			while (rs.next()) {
				Car c = new Car();
				ParkingLot p = new ParkingLot();
				Company y = new Company();
				c.setLicensePlate(rs.getString("licensePlate"));
				c.setCarColor(rs.getString("carColor"));
				c.setCarType(rs.getString("carType"));
				y.setCompanyName(rs.getString("companyName"));
				p.setName(rs.getString("packName"));
				p.setId(rs.getInt("packId"));
				c.setParkingLot(p);
				c.setCompany(y);
				cars.add(c);
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
		return cars;
	}

	@Override
	public List<ParkingLot> getAllParkingLot() throws SQLException {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		try {
			String sql = "select packId, packName from packinglot";
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(sql);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingLot p = new ParkingLot();
				p.setId(rs.getInt("packId"));
				p.setName(rs.getString("packName"));
				parkingLots.add(p);
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
		return parkingLots;
	}
}
