package dto;

public class AllowanceDTO implements DTO {

	private int allowanceId;
	private String allowanceName;
	private String allowanceDesc;

	public AllowanceDTO() {
		super();
	}
	
	public AllowanceDTO(int allowanceId, String allowanceName, String allowanceDesc) {
		super();
		this.allowanceId = allowanceId;
		this.allowanceName = allowanceName;
		this.allowanceDesc = allowanceDesc;
	}
		
	public int getAllowanceId() {
		return allowanceId;
	}
	public void setAllowanceId(int allowanceId) {
		this.allowanceId = allowanceId;
	}
	public String getAllowanceName() {
		return allowanceName;
	}
	public void setAllowanceName(String allowanceName) {
		this.allowanceName = allowanceName;
	}
	public String getAllowanceDesc() {
		return allowanceDesc;
	}
	public void setAllowanceDesc(String allowanceDesc) {
		this.allowanceDesc = allowanceDesc;
	}

	@Override
	public String toString() {
		return "AllowanceDTO [allowanceId=" + allowanceId + ", allowanceName=" + allowanceName + ", allowanceDesc="
				+ allowanceDesc + "]";
	}

}