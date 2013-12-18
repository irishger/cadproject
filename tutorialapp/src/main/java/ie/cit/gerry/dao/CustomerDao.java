package ie.cit.gerry.dao;

import java.util.List;

import ie.cit.gerry.Customer;

public interface CustomerDao {

	List<Customer> findAll();
	
	List<Customer> findInTown(String town);
	
	Customer getById(int id);
	
	void save(Customer customer);

	List<Customer> getByCity(String city);
	
}
