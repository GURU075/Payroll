package dto;

public class EmployeeBankDTO implements DTO {

	public EmployeeBankDTO() {
		// TODO Auto-generated constructor stub
	}
	
	int empid;
	int bankid;
	String BankName;
	String BankBranch;
	long BankAcc;
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getBankid() {
		return bankid;
	}
	public void setBankid(int bankid) {
		this.bankid = bankid;
	}
	public String getBankName() {
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
	}
	public String getBankBranch() {
		return BankBranch;
	}
	public void setBankBranch(String bankBranch) {
		BankBranch = bankBranch;
	}
	public long getBankAcc() {
		return BankAcc;
	}
	public void setBankAcc(long bankAcc) {
		BankAcc = bankAcc;
	}
	public EmployeeBankDTO(int empid, int bankid, String bankName, String bankBranch, long bankAcc) {
		super();
		this.empid = empid;
		this.bankid = bankid;
		BankName = bankName;
		BankBranch = bankBranch;
		BankAcc = bankAcc;
	}
	@Override
	public String toString() {
		return "EmployeeBank [empid=" + empid + ", bankid=" + bankid + ", BankName=" + BankName + ", BankBranch="
				+ BankBranch + ", BankAcc=" + BankAcc + "]";
	}
	
	

}
