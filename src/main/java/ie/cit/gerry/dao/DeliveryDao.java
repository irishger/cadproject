package ie.cit.gerry.dao;

import java.sql.Date;
import java.util.List;

import ie.cit.gerry.Delivery;

public interface DeliveryDao {
	
	List<Delivery> findAll();
	
	List<Delivery> findByDate(Date deliveryDate);
	
	List<Delivery> findByCustomerID (int customerID);
	
	Delivery getByOrderID(int orderID);
	
	void save(Delivery delivery);
	
}
