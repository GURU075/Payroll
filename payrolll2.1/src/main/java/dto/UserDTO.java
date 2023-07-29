package dto;

public class UserDTO implements DTO {

	
	private int userid;
	private String User;
	private String UserName;
	private String UserPassword;
	private String UserPosition;
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}


	public UserDTO(int userid, String user, String userName, String userPassword, String userPosition) {
		super();
		this.userid = userid;
		User = user;
		UserName = userName;
		UserPassword = userPassword;
		UserPosition = userPosition;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public String getUser() {
		return User;
	}


	public void setUser(String user) {
		User = user;
	}


	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getUserPassword() {
		return UserPassword;
	}


	public void setUserPassword(String userPassword) {
		UserPassword = userPassword;
	}


	public String getUserPosition() {
		return UserPosition;
	}


	public void setUserPosition(String userPosition) {
		UserPosition = userPosition;
	}


	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", User=" + User + ", UserName=" + UserName + ", UserPassword="
				+ UserPassword + ", UserPosition=" + UserPosition + "]";
	}
	
	

}
