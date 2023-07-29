package dto;

import java.sql.Date;

public class LeaveDTO implements DTO {

	
	
	private int LeaveId;
	private int empid;
	private Date LeaveFrom;
	private Date LeaveTo;
	private String LeaveType;
	private String LeaveDesc;
	public int getLeaveId() {
		return LeaveId;
	}
	public void setLeaveId(int leaveId) {
		LeaveId = leaveId;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public Date getLeaveFrom() {
		return LeaveFrom;
	}
	public void setLeaveFrom(Date leaveFrom) {
		LeaveFrom = leaveFrom;
	}
	public Date getLeaveTo() {
		return LeaveTo;
	}
	public void setLeaveTo(Date leaveTo) {
		LeaveTo = leaveTo;
	}
	public String getLeaveType() {
		return LeaveType;
	}
	public void setLeaveType(String leaveType) {
		LeaveType = leaveType;
	}
	public String getLeaveDesc() {
		return LeaveDesc;
	}
	public void setLeaveDesc(String leaveDesc) {
		LeaveDesc = leaveDesc;
	}
	@Override
	public String toString() {
		return "LeaveDTO [LeaveId=" + LeaveId + ", empid=" + empid + ", LeaveFrom=" + LeaveFrom + ", LeaveTo=" + LeaveTo
				+ ", LeaveType=" + LeaveType + ", LeaveDesc=" + LeaveDesc + "]";
	}
	public LeaveDTO(int leaveId, int empid, Date leaveFrom, Date leaveTo, String leaveType, String leaveDesc) {
		super();
		LeaveId = leaveId;
		this.empid = empid;
		LeaveFrom = leaveFrom;
		LeaveTo = leaveTo;
		LeaveType = leaveType;
		LeaveDesc = leaveDesc;
	}
	public LeaveDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
