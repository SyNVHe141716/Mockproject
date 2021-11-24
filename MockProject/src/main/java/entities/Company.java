package entities;
import java.io.Serializable;

public class Company implements Serializable{
	private int companyId;
	private String companyName;
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public Company(int companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}


