package dto;

public class DepartmentDTO implements DTO {

	private int DepartmentId;
	private String DepartmentName;
	private String DepartmentLocation;
	private String DepartmentDesc;
	
	
	public DepartmentDTO() {
		super();
		}
	
	public DepartmentDTO(int DepartmentId, String DepartmentName,String DepartmentLocation, String DepartmentDesc) {
		super();
		this.DepartmentId = DepartmentId;
		this.DepartmentName = DepartmentName;
		this.DepartmentLocation = DepartmentLocation;
		this.DepartmentDesc = DepartmentDesc;
	}
	
	public int getDepartmentId() {
		return DepartmentId;
	}


	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}


	public String getDepartmentName() {
		return DepartmentName;
	}


	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}


	public String getDepartmentLocation() {
		return DepartmentLocation;
	}


	public void setDepartmentLocation(String departmentLocation) {
		DepartmentLocation = departmentLocation;
	}


	public String getDepartmentDesc() {
		return DepartmentDesc;
	}


	public void setDepartmentDesc(String departmentDesc) {
		DepartmentDesc = departmentDesc;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "DepartmentDTO [DepartmentId=" + DepartmentId + ", DepartmentName=" + DepartmentName + ", DepartmentLocation="+DepartmentLocation+", DepartmentDesc="
		+ DepartmentDesc + "]";
	}
	

}
