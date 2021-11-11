package entities;

import java.io.Serializable;

public class ParkingPlace implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	public ParkingPlace() {
		super();
	}
	public ParkingPlace(String name) {
		super();
		this.name = name;
	}
	public ParkingPlace(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	@Override
	public String toString() {
		return "ParkingPlace [id=" + id + ", name=" + name + "]";
	}
	
}
