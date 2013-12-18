package ie.cit.gerry.dao;

import java.util.List;

import ie.cit.gerry.Order;


public interface OrderDao {
	
	List<Order> findAll();
	List<Order> findByCustomerID(int customerID);
	Order getByOrderID(int orderID);
	
	void add(Order order);
	void save(Order order);

}
