package dto;

public class DesignationDTO implements DTO {

	
	private int designationId;
	private String designationName;
	private String designationDesc;
	
	public DesignationDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public DesignationDTO(int designationId, String designationName, String designationDesc) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.designationDesc = designationDesc;
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDesignationDesc() {
		return designationDesc;
	}

	public void setDesignationDesc(String designationDesc) {
		this.designationDesc = designationDesc;
	}

	@Override
	public String toString() {
		return "designation [designationId=" + designationId + ", designationName=" + designationName
				+ ", designationDesc=" + designationDesc + "]";
	}
	
	

}
