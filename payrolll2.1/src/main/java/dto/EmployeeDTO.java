package dto;

import java.sql.Date;

public class EmployeeDTO implements DTO {
	
	
	private int empId;
	private String empName;
	private String empAddress;
	private String empState;
	private String empEmail;
	private String empMobileno;
	private String empGender;
	private String emppan;
	private Date empDOJ;
	private String empdepartment;
	private String empdesignation;
	private String empbankaccno;
	private String empbankname;
	
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmpState() {
		return empState;
	}

	public void setEmpState(String empState) {
		this.empState = empState;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpMobileno() {
		return empMobileno;
	}

	public void setEmpMobileno(String empMobileno) {
		this.empMobileno = empMobileno;
	}

	public String getEmpGender() {
		return empGender;
	}

	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}

	public String getEmppan() {
		return emppan;
	}

	public void setEmppan(String emppan) {
		this.emppan = emppan;
	}

	public Date getEmpDOJ() {
		return empDOJ;
	}

	public void setEmpDOJ(Date empDOJ) {
		this.empDOJ = empDOJ;
	}

	public String getEmpdepartment() {
		return empdepartment;
	}

	public void setEmpdepartment(String empdepartment) {
		this.empdepartment = empdepartment;
	}

	public String getEmpdesignation() {
		return empdesignation;
	}

	public void setEmpdesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}

	public String getEmpbankaccno() {
		return empbankaccno;
	}

	public void setEmpbankaccno(String empbankaccno) {
		this.empbankaccno = empbankaccno;
	}

	public String getEmpbankname() {
		return empbankname;
	}

	public void setEmpbankname(String empbankname) {
		this.empbankname = empbankname;
	}

	public EmployeeDTO() {
		// TODO Auto-generated constructor stub
	}

	public EmployeeDTO(int empId, String empName, String empAddress, String empState, String empEmail,
			String empMobileno, String empGender, String emppan, Date empDOJ, String empdepartment,
			String empdesignation, String empbankaccno, String empbankname) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empState = empState;
		this.empEmail = empEmail;
		this.empMobileno = empMobileno;
		this.empGender = empGender;
		this.emppan = emppan;
		this.empDOJ = empDOJ;
		this.empdepartment = empdepartment;
		this.empdesignation = empdesignation;
		this.empbankaccno = empbankaccno;
		this.empbankname = empbankname;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empState="
				+ empState + ", empEmail=" + empEmail + ", empMobileno=" + empMobileno + ", empGender=" + empGender
				+ ", emppan=" + emppan + ", empDOJ=" + empDOJ + ", empdepartment=" + empdepartment + ", empdesignation="
				+ empdesignation + ", empbankaccno=" + empbankaccno + ", empbankname=" + empbankname + "]";
	}
	
	

}
