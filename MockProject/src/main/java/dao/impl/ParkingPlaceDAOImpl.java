package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ParkingPlaceDAO;
import entities.ParkingPlace;
import utils.DBConnection;
import utils.SQLCommand;

public class ParkingPlaceDAOImpl implements ParkingPlaceDAO {

	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public List<ParkingPlace> getAll() throws SQLException {
		List<ParkingPlace> parkingPlaces = new ArrayList<ParkingPlace>();
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_PARKING_PLACE);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingPlace parkingPlace = new ParkingPlace();
				parkingPlace.setId(rs.getInt("packPlaceId"));
				parkingPlace.setName(rs.getString("packPlaceName"));
				parkingPlaces.add(parkingPlace);
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
		return parkingPlaces;
	}

	@Override
	public ParkingPlace getById(int id) throws SQLException {
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_PARKING_PLACE_BY_ID);
			pre.setInt(1, id);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingPlace parkingPlace = new ParkingPlace();
				parkingPlace.setId(rs.getInt("packPlaceId"));
				parkingPlace.setName(rs.getString("packPlaceName"));
				return parkingPlace;
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

}
