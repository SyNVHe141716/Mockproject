package entities;

import java.io.Serializable;

public class Car implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String licensePlate;
	private String carColor;
	private String carType;
	private String company;
	private int packId;

	public Car() {
		super();
	}

	public Car(String licensePlate, String carColor, String carType, String company, int packId) {
		super();
		this.licensePlate = licensePlate;
		this.carColor = carColor;
		this.carType = carType;
		this.company = company;
		this.packId = packId;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public String getCarType() {
		return carType;
	}

	public void setCarType(String carType) {
		this.carType = carType;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	@Override
	public String toString() {
		return "Car [licensePlate=" + licensePlate + ", carColor=" + carColor + ", carType=" + carType + ", company="
				+ company + ", packId=" + packId + "]";
	}

}
