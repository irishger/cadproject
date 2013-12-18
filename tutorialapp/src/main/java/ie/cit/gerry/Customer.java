package ie.cit.gerry;

public class Customer {

	private int id;
	private String firstName;
	private String secondName;
	private String address1;
	private String address2;
	private String address3;
	private double creditLimit;
	
	public Customer() {
		
	}
	
	public Customer(String firstName, String secondName, String address1,
			String address2, String address3, double creditLimit) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.address1 = address1;
		this.address2 = address2;
		this.address3 = address3;
		this.creditLimit = creditLimit;
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAddress3() {
		return address3;
	}
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	public double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(double creditLimit) {
		this.creditLimit = creditLimit;
	}

	
}
