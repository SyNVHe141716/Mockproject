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
	public boolean delete(ParkingLot parkingLot) throws SQLException;
	public boolean update(ParkingLot parkingLot) throws SQLException;
	public List<ParkingLot> searchByName(String txtSearch) throws SQLException;
	public List<ParkingLot> searchByPlace(String txtSearch) throws SQLException;
	
}
