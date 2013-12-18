package ie.cit.gerry;

import java.sql.Date;

public class Delivery {
	
	private int deliveryID;
	private int orderID;
	private String firstName;
	private String secondName;
	private String address1;
	private String address2;
	private String address3;
	private Date deliveryDate;
	
	
	public Delivery(){
		
	}
	
	public Delivery(int orderID, String firstName, String secondName, String address1, String address2, String address3, Date date){
		
		this.setOrderID(orderID);
		this.setFirstName(firstName);
		this.setSecondName(secondName);
		this.setAddress1(address1);
		this.setAddress2(address2);
		this.setAddress3(address3);
		this.setDeliveryDate(date);

		
	}

	public int getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(int id) {
		this.deliveryID = id;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
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

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date date) {
		this.deliveryDate = date;
	}

}
