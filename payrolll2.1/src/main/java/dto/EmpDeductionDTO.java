package dto;

public class EmpDeductionDTO implements DTO {

	private int empid;
	private int deductionid;
	private String deductionname;
	private int deductionamt;
	
	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public int getDeductionid() {
		return deductionid;
	}

	public void setDeductionid(int deductionid) {
		this.deductionid = deductionid;
	}

	public String getDeductionname() {
		return deductionname;
	}

	public void setDeductionname(String deductionname) {
		this.deductionname = deductionname;
	}

	public int getDeductionamt() {
		return deductionamt;
	}

	public void setDeductionamt(int deductionamt) {
		this.deductionamt = deductionamt;
	}

	
	
	public EmpDeductionDTO(int empid, int deductionid, String deductionname, int deductionamt) {
		super();
		this.empid = empid;
		this.deductionid = deductionid;
		this.deductionname = deductionname;
		this.deductionamt = deductionamt;
	}

	
	@Override
	public String toString() {
		return "EmpDeductionDTO [empid=" + empid + ", deductionid=" + deductionid + ", deductionname=" + deductionname
				+ ", deductionamt=" + deductionamt + "]";
	}

	public EmpDeductionDTO() {
		// TODO Auto-generated constructor stub
	}

}
