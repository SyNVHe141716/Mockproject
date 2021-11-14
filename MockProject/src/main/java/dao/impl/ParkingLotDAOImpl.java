package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ParkingLotDAO;
import entities.ParkingLot;
import utils.DBConnection;
import utils.SQLCommand;

/**
 *
 * @author KienNV13
 *
 */
public class ParkingLotDAOImpl implements ParkingLotDAO {

	private Connection con;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public List<ParkingLot> getAll() throws SQLException {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_ALL_PARKING_LOT);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				parkingLots.add(parkingLot);
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

	@Override
	public boolean add(ParkingLot parkingLot) throws SQLException {
		int row = 0;
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.ADD_PARKING_LOT);
			pre.setString(++param, parkingLot.getName());
			pre.setInt(++param, parkingLot.getPlaceId());
			pre.setInt(++param, parkingLot.getArea());
			pre.setInt(++param, parkingLot.getPrice());
			pre.setBoolean(++param, parkingLot.isStatus());
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
		return row > 0;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		int row = 0;
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.DELETE_PARKING_LOT);
			pre.setInt(++param, id);
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
		return row > 0;
	}

	@Override
	public boolean update(ParkingLot parkingLot) throws SQLException {
		int row = 0;
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.UPDATE_PARKING_LOT);
			pre.setString(++param, parkingLot.getName());
			pre.setInt(++param, parkingLot.getPlaceId());
			pre.setInt(++param, parkingLot.getArea());
			pre.setInt(++param, parkingLot.getPrice());
			pre.setBoolean(++param, parkingLot.isStatus());
			pre.setInt(++param, parkingLot.getId());
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
		return row > 0;
	}

	@Override
	public List<ParkingLot> searchByName(String txtSearch) throws SQLException {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.QUERY_SEARCH_PARKINGLOT_BY_NAME);
			pre.setString(++param, '%' + txtSearch + '%');
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				parkingLots.add(parkingLot);
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

	@Override
	public List<ParkingLot> searchByPlace(int placeId) throws SQLException {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.QUERY_SEARCH_PARKINGLOT_BY_PLACE_ID);
			pre.setInt(++param, placeId);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				parkingLots.add(parkingLot);
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

	@Override
	public List<ParkingLot> searchByStatus(int status) throws SQLException {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.QUERY_SEARCH_PARKINGLOT_BY_STATUS);
			pre.setInt(++param, status);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				parkingLots.add(parkingLot);
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

	@Override
	public List<ParkingLot> searchByArea(int minArea, int maxArea) throws SQLException {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.QUERY_SEARCH_PARKINGLOT_BY_AREA);
			pre.setInt(++param, minArea);
			pre.setInt(++param, maxArea);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				parkingLots.add(parkingLot);
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

	@Override
	public List<ParkingLot> searchByPrice(int minPrice, int maxPrice) throws SQLException {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.QUERY_SEARCH_PARKINGLOT_BY_PRICE);
			pre.setInt(++param, minPrice);
			pre.setInt(++param, maxPrice);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				parkingLots.add(parkingLot);
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

	@Override
	public ParkingLot getById(int id) throws SQLException {
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_PARKINGLOT_BY_ID);
			pre.setInt(++param, id);
			rs = pre.executeQuery();

			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				return parkingLot;
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
	public List<ParkingLot> getByPage(int pageIndex, int pageSize) throws SQLException {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		try {
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_PARKINGLOT_BY_PAGE);
			pre.setInt(1, pageIndex);
			pre.setInt(2, pageSize);
			pre.setInt(3, pageIndex);
			pre.setInt(4, pageSize);
			rs = pre.executeQuery();
			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				parkingLots.add(parkingLot);
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


	@Override
	public ParkingLot getByName(String name) throws SQLException {
		try {
			int param = 0;
			con = DBConnection.getInstance().getConnection();
			pre = con.prepareStatement(SQLCommand.GET_PARKINGLOT_BY_NAME);
			pre.setString(++param, name);
			rs = pre.executeQuery();

			while (rs.next()) {
				ParkingLot parkingLot = new ParkingLot();
				parkingLot.setId(rs.getInt("packId"));
				parkingLot.setArea(rs.getInt("packArea"));
				parkingLot.setName(rs.getString("packName"));
				parkingLot.setPlaceId(rs.getInt("packPlaceId"));
				parkingLot.setPrice(rs.getInt("packPrice"));
				parkingLot.setStatus(rs.getBoolean("packStatus"));
				return parkingLot;
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

//	public static void main(String[] args) throws SQLException {
//		ParkingLotDAO p = new ParkingLotDAOImpl();
//		p.searchByPlace(1).forEach(System.out::println);
//	}
}
