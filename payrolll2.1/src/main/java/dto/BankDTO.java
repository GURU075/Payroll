package dto;

public class BankDTO implements DTO {

	private int BankId;
	private String BankName;
	private String BankBranch;
	private String BankDesc;
	
	
	public BankDTO() {
		super();
		}
	
	public BankDTO(int BankId, String BankName,String BankBranch, String BankDesc) {
		super();
		this.BankId = BankId;
		this.BankName = BankName;
		this.BankBranch = BankBranch;
		this.BankDesc = BankDesc;
	}

	public int getBankId() {
		return BankId;
	}

	public void setBankId(int bankId) {
		BankId = bankId;
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

	public String getBankDesc() {
		return BankDesc;
	}

	public void setBankDesc(String bankDesc) {
		BankDesc = bankDesc;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "BankDTO [BankId=" + BankId + ", BankName=" + BankName + ", BankBranch="+BankBranch+", BankDesc="
		+ BankDesc + "]";
	}
	
	

}
