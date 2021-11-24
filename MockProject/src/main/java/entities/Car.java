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
	private int companyId;
	private Company company;
	private int packId;
	private ParkingLot parkingLot;

	public Car() {
		super();
	}

	public Car(String licensePlate, String carColor, String carType, int companyId, int packId) {
		super();
		this.licensePlate = licensePlate;
		this.carColor = carColor;
		this.carType = carType;
		this.companyId = companyId;
		this.packId = packId;
	}

	public Car(String licensePlate, String carColor, String carType, int companyId, Company company, int packId,
			ParkingLot parkingLot) {
		super();
		this.licensePlate = licensePlate;
		this.carColor = carColor;
		this.carType = carType;
		this.companyId = companyId;
		this.company = company;
		this.packId = packId;
		this.parkingLot = parkingLot;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public ParkingLot getParkingLot() {
		return parkingLot;
	}

	public void setParkingLot(ParkingLot parkingLot) {
		this.parkingLot = parkingLot;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
