package ie.cit.gerry;

public class Order {
	
	private int orderID;
	private int customerID;
	private int sku;
	private int quantity;
	private double total;

	public Order() {
		
	}
	
	
	public Order(int orderID, int customer, int sku, int quantity, double total) {
		
		this.orderID = orderID;
		this.customerID = customer;
		this.sku = sku;
		this.quantity = quantity;
		this.total = total;
	}
	
	public int getOrderID(){
		return orderID;
	}
	
	public void setOrderID(int orderID){
		this.orderID = orderID;
	}
	
	public int getCustomerID(){
		return customerID;	
	}
	
	
	public void setCustomerID(int customer){
		this.customerID = customer;
	}
	
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public int getSku() {
		return sku;
	}


	public void setSku(int sku) {
		this.sku = sku;
	}

}
