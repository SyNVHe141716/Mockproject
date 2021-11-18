package entities;

import java.io.Serializable;
import java.sql.Date;

public class BookingOffice implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stt;
	private int officeId;
	private String officeName;
	private String officePhone;
	private String officePlace;
	private int officePrice;
	private Date startContractDeadline;
	private Date endContractDeadline;
	private String destination;
	private int tripid;
	
	
	

	public int getStt() {
		return stt;
	}

	public void setStt(int stt) {
		this.stt = stt;
	}

	public BookingOffice(int officeId) {
		super();
		this.officeId = officeId;
	}
	

	

	public BookingOffice(int stt, int officeId, String officeName, String officePhone, String officePlace,
			int officePrice, Date startContractDeadline, Date endContractDeadline, String destination, int tripid) {
		super();
		this.stt = stt;
		this.officeId = officeId;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.endContractDeadline = endContractDeadline;
		this.destination = destination;
		this.tripid = tripid;
	}

	public BookingOffice(int officeId, String officeName, String officePhone, String officePlace, int officePrice,
			Date startContractDeadline, Date endContractDeadline, int tripid) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.endContractDeadline = endContractDeadline;
		this.tripid = tripid;
	}

	public int getTripid() {
		return tripid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}

	public BookingOffice() {
		super();
	}

	public BookingOffice(String officeName, String officePhone, String officePlace, int officePrice,
			Date startContractDeadline, Date endContractDeadline) {
		super();
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.endContractDeadline = endContractDeadline;
	}

	public BookingOffice(int officeId, String officeName, String officePhone, String officePlace, int officePrice,
			Date startContractDeadline, Date endContractDeadline) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.endContractDeadline = endContractDeadline;
	}
	

	public BookingOffice(int officeId, String officeName, String destination) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
		this.destination = destination;
	}


	public BookingOffice(String officeName, String officePhone, String officePlace, int officePrice,
			Date startContractDeadline, Date endContractDeadline, int tripid) {
		super();
		this.officeName = officeName;
		this.officePhone = officePhone;
		this.officePlace = officePlace;
		this.officePrice = officePrice;
		this.startContractDeadline = startContractDeadline;
		this.endContractDeadline = endContractDeadline;
		this.tripid = tripid;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getOfficePlace() {
		return officePlace;
	}

	public void setOfficePlace(String officePlace) {
		this.officePlace = officePlace;
	}

	public int getOfficePrice() {
		return officePrice;
	}

	public void setOfficePrice(int officePrice) {
		this.officePrice = officePrice;
	}

	public Date getStartContractDeadline() {
		return startContractDeadline;
	}

	public void setStartContractDeadline(Date startContractDeadline) {
		this.startContractDeadline = startContractDeadline;
	}

	public Date getEndContractDeadline() {
		return endContractDeadline;
	}

	public void setEndContractDeadline(Date endContractDeadline) {
		this.endContractDeadline = endContractDeadline;
	}

	@Override
	public String toString() {
		return "BookingOffice [officeId=" + officeId + ", officeName=" + officeName + ", officePhone=" + officePhone
				+ ", officePlace=" + officePlace + ", officePrice=" + officePrice + ", startContractDeadline="
				+ startContractDeadline + ", endContractDeadline=" + endContractDeadline + ", destination="
				+ destination + "]";
	}

	
	
	
}
