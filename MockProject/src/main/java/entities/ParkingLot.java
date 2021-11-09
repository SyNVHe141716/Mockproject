package entities;

import java.io.Serializable;

public class ParkingLot implements Serializable {
	/**
	 * @author KienNV13
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String place;
	private int area;
	private int price;
	private boolean status;

	public ParkingLot() {
		super();
	}

	public ParkingLot(String name, String place, int area, int price, boolean status) {
		super();
		this.name = name;
		this.place = place;
		this.area = area;
		this.price = price;
		this.status = status;
	}

	public ParkingLot(int id, String name, String place, int area, int price, boolean status) {
		super();
		this.id = id;
		this.name = name;
		this.place = place;
		this.area = area;
		this.price = price;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ParkingLot [id=" + id + ", name=" + name + ", place=" + place + ", area=" + area + ", price=" + price
				+ ", status=" + status + "]";
	}
	
}
