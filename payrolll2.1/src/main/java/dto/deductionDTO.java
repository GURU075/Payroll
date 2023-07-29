package dto;

public class deductionDTO implements DTO {

	private int deductionId;
	private String deductionName;
	private String deductionDesc;

	public deductionDTO() {
		super();
	}
	
	public deductionDTO(int deductionId, String deductionName, String deductionDesc) {
		super();
		this.deductionId = deductionId;
		this.deductionName = deductionName;
		this.deductionDesc = deductionDesc;
	}
		
	public int getdeductionId() {
		return deductionId;
	}
	public void setdeductionId(int deductionId) {
		this.deductionId = deductionId;
	}
	public String getdeductionName() {
		return deductionName;
	}
	public void setdeductionName(String deductionName) {
		this.deductionName = deductionName;
	}
	public String getdeductionDesc() {
		return deductionDesc;
	}
	public void setdeductionDesc(String deductionDesc) {
		this.deductionDesc = deductionDesc;
	}

	@Override
	public String toString() {
		return "deductionDTO [deductionId=" + deductionId + ", deductionName=" + deductionName + ", deductionDesc="
				+ deductionDesc + "]";
	}

}