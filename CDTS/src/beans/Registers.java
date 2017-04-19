package beans;

public class Registers {

	public String UserId;
	public String Password;
	public String FullName;
	public String State;
	public int Mobile;
	public String City;
	public String Address;
	public String Gender;
	public int Age;
	/**
	 * @param userId
	 * @param password
	 * @param fullName
	 * @param state
	 * @param mobile
	 * @param city
	 * @param address
	 * @param gender
	 * @param age
	 */
	public Registers(String userId, String password, String fullName,
			String state, int mobile, String city, String address,
			String gender, int age) {
		super();
		UserId = userId;
		Password = password;
		FullName = fullName;
		State = state;
		Mobile = mobile;
		City = city;
		Address = address;
		Gender = gender;
		Age = age;
	}
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getFullName() {
		return FullName;
	}
	public void setFullName(String fullName) {
		FullName = fullName;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public int getMobile() {
		return Mobile;
	}
	public void setMobile(int mobile) {
		Mobile = mobile;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	
	
	

}
