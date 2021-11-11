package dao;

import java.sql.SQLException;
import java.util.List;

import entities.ParkingPlace;

public interface ParkingPlaceDAO {
	public List<ParkingPlace> getAll() throws SQLException;
	public ParkingPlace getById(int id) throws SQLException;
}
