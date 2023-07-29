package dto;

public class EmpallowanceDTO implements DTO {
	private int empid;
	private int allowanceid;
	private String allowancename;
	private int allowanceamt;
	
	
	public EmpallowanceDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EmpallowanceDTO(int empid, int allowanceid, String allowancename, int allowanceamt) {
		super();
		this.empid = empid;
		this.allowanceid = allowanceid;
		this.allowancename = allowancename;
		this.allowanceamt = allowanceamt;
	}


	public int getEmpid() {
		return empid;
	}


	public void setEmpid(int empid) {
		this.empid = empid;
	}


	public int getAllowanceid() {
		return allowanceid;
	}


	public void setAllowanceid(int allowanceid) {
		this.allowanceid = allowanceid;
	}


	public String getAllowancename() {
		return allowancename;
	}


	public void setAllowancename(String allowancename) {
		this.allowancename = allowancename;
	}


	public int getAllowanceamt() {
		return allowanceamt;
	}


	public void setAllowanceamt(int allowanceamt) {
		this.allowanceamt = allowanceamt;
	}


	@Override
	public String toString() {
		return "EmpallowanceDTO [empid=" + empid + ", allowanceid=" + allowanceid + ", allowancename=" + allowancename
				+ ", allowanceamt=" + allowanceamt + "]";
	}
	
	
	
	
}
