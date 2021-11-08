package entities;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int employeeId;
	private String account;
	private String departmentId;
	private String employeeAddress;
	private String employeeBirthdate;
	private String employeeEmail;
	private String employeeName;
	private String employeePhone;
	private String password;
	private String sex;
	private Boolean role;

	public Employee() {
		super();
	}

	public Employee(int employeeId, String account, String departmentId, String employeeAddress,
			String employeeBirthdate, String employeeEmail, String employeeName, String employeePhone, String password,
			String sex, Boolean role) {
		super();
		this.employeeId = employeeId;
		this.account = account;
		this.departmentId = departmentId;
		this.employeeAddress = employeeAddress;
		this.employeeBirthdate = employeeBirthdate;
		this.employeeEmail = employeeEmail;
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.password = password;
		this.sex = sex;
		this.role = role;
	}

	public Employee(String account, String departmentId, String employeeAddress, String employeeBirthdate,
			String employeeEmail, String employeeName, String employeePhone, String password, String sex, Boolean role) {
		super();
		this.account = account;
		this.departmentId = departmentId;
		this.employeeAddress = employeeAddress;
		this.employeeBirthdate = employeeBirthdate;
		this.employeeEmail = employeeEmail;
		this.employeeName = employeeName;
		this.employeePhone = employeePhone;
		this.password = password;
		this.sex = sex;
		this.role = role;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getEmployeeBirthdate() {
		return employeeBirthdate;
	}

	public void setEmployeeBirthdate(String employeeBirthdate) {
		this.employeeBirthdate = employeeBirthdate;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeePhone() {
		return employeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", account=" + account + ", departmentId=" + departmentId
				+ ", employeeAddress=" + employeeAddress + ", employeeBirthdate=" + employeeBirthdate
				+ ", employeeEmail=" + employeeEmail + ", employeeName=" + employeeName + ", employeePhone="
				+ employeePhone + ", password=" + password + ", sex=" + sex + ", role=" + role + "]";
	}

}
