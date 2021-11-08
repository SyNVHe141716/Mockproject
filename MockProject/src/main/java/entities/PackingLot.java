package entities;

import java.io.Serializable;

public class PackingLot implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int packId;
	private int packArea;
	private String packName;
	private String packPlace;
	private int packPrice;
	private String packStatus;

	public PackingLot() {
		super();
	}

	public PackingLot(int packArea, String packName, String packPlace, int packPrice, String packStatus) {
		super();
		this.packArea = packArea;
		this.packName = packName;
		this.packPlace = packPlace;
		this.packPrice = packPrice;
		this.packStatus = packStatus;
	}

	public PackingLot(int packId, int packArea, String packName, String packPlace, int packPrice, String packStatus) {
		super();
		this.packId = packId;
		this.packArea = packArea;
		this.packName = packName;
		this.packPlace = packPlace;
		this.packPrice = packPrice;
		this.packStatus = packStatus;
	}

	public int getPackId() {
		return packId;
	}

	public void setPackId(int packId) {
		this.packId = packId;
	}

	public int getPackArea() {
		return packArea;
	}

	public void setPackArea(int packArea) {
		this.packArea = packArea;
	}

	public String getPackName() {
		return packName;
	}

	public void setPackName(String packName) {
		this.packName = packName;
	}

	public String getPackPlace() {
		return packPlace;
	}

	public void setPackPlace(String packPlace) {
		this.packPlace = packPlace;
	}

	public int getPackPrice() {
		return packPrice;
	}

	public void setPackPrice(int packPrice) {
		this.packPrice = packPrice;
	}

	public String getPackStatus() {
		return packStatus;
	}

	public void setPackStatus(String packStatus) {
		this.packStatus = packStatus;
	}


	@Override
	public String toString() {
		return "PackingLot [packId=" + packId + ", packArea=" + packArea + ", packName=" + packName + ", packPlace="
				+ packPlace + ", packPrice=" + packPrice + ", packStatus=" + packStatus + "]";
	}
	
}
