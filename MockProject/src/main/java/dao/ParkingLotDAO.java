package dao;

import java.sql.SQLException;
import java.util.List;

import entities.ParkingLot;

/**
 *
 * @author KienNV13
 *
 */
public interface ParkingLotDAO {
	public List<ParkingLot> getAll() throws SQLException;
	public boolean add(ParkingLot parkingLot) throws SQLException;
	public boolean delete(int id) throws SQLException;
	public boolean update(ParkingLot parkingLot) throws SQLException;
	public ParkingLot getById(int id) throws SQLException;
	public List<ParkingLot> searchByName(String txtSearch) throws SQLException;
	public List<ParkingLot> searchByPlace(int placeId) throws SQLException;
	public List<ParkingLot> searchByStatus(int status) throws SQLException;
	public List<ParkingLot> searchByArea(int minArea, int maxArea) throws SQLException;
	public List<ParkingLot> searchByPrice(int minPrice, int maxPrice) throws SQLException;
	public List<ParkingLot> getByPage(int pageIndex, int pageSize) throws SQLException;
	public ParkingLot getByName(String name) throws SQLException;
}
