package beans;

public class Customer {

	public String FirstName;
	public String LastName;
	public String Address;
	public String Email;
	public int Mobile;
	public String Source;
	public String Destination;
	public String ProductDetail;
	public String Type;
	public float Weight;
	public float Price;
	public int Quantity;
	public String CourierId;
	
	/**
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param email
	 * @param mobile
	 * @param source
	 * @param destination
	 * @param productDetail
	 * @param type
	 * @param weight
	 * @param price
	 * @param quantity
	 */
	public Customer(String firstName, String lastName, String address,
			String email, int mobile, String source, String destination,
			String productDetail, String type, float weight, float price,
			int quantity,String courierId) {
		super();
		FirstName = firstName;
		LastName = lastName;
		Address = address;
		Email = email;
		Mobile = mobile;
		Source = source;
		Destination = destination;
		ProductDetail = productDetail;
		Type = type;
		Weight = weight;
		Price = price;
		Quantity = quantity;
		CourierId=courierId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public int getMobile() {
		return Mobile;
	}

	public void setMobile(int mobile) {
		Mobile = mobile;
	}

	public String getSource() {
		return Source;
	}

	public void setSource(String source) {
		Source = source;
	}

	public String getDestination() {
		return Destination;
	}

	public void setDestination(String destination) {
		Destination = destination;
	}

	public String getProductDetail() {
		return ProductDetail;
	}

	public void setProductDetail(String productDetail) {
		ProductDetail = productDetail;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public float getWeight() {
		return Weight;
	}

	public void setWeight(float weight) {
		Weight = weight;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	public String getCourierId() {
		return CourierId;
	}

	public void setCourierId(String courierId) {
		CourierId = courierId;
	}
}
