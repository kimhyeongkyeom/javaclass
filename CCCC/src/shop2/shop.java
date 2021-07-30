package shop2;

public class shop {

	private String memberno ;
	private String password ;
	private String name ;
	private String birth;
	private String gender;	
	private String phone;
	private String addr; 
	private String account;
	private String balance;
	
	
	//getter setter
	public String getMemberno() {
		return memberno;
	}
	public void setMemberno(String memberno) {
		this.memberno = memberno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	
	
	
	// tostring
	@Override
	public String toString() {
		return "shop [memberno=" + memberno + ", password=" + password + ", name=" + name + ", birth=" + birth
				+ ", gender=" + gender + ", phone=" + phone + ", addr=" + addr + ", account=" + account + ", balance="
				+ balance + "]";
	}
	// 생성자
	public shop() {
	}
	
	
	public shop(String memberno, String password, String name, String birth, String gender, String phone, String addr,
			String account, String balance) {
		this.memberno = memberno;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.gender = gender;
		this.phone = phone;
		this.addr = addr;
		this.account = account;
		this.balance = balance;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
