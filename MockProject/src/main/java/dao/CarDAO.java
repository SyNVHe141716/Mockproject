package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Car;
import entities.Company;
import entities.ParkingLot;

public interface CarDAO {
	public int addCar(Car car) throws SQLException;

	public List<Company> getAllCompany() throws SQLException;

	public List<ParkingLot> getAllParkingLot() throws SQLException;

	public List<Car> getAllCart() throws SQLException;

	public int update(Car car) throws SQLException;

	public int delete(String licensePlate) throws SQLException;

	public Car searchByLicensePlate(String lincensePlate) throws SQLException;

	List<Car> getAlllicensePlate(String licensePlate) throws SQLException;

	public List<Car> getAllcarColor(String carColor) throws SQLException;

	public List<Car> getAllcompanyName(String companyName) throws SQLException;

	public List<Car> getAllpackName(String packName) throws SQLException;

	public List<Car> getAllcarType(String carType) throws SQLException;
}
