package ie.cit.gerry.dao.impl;

import java.util.ArrayList;
import java.util.List;

import ie.cit.gerry.Customer;
import ie.cit.gerry.dao.CustomerDao;

public class StubCustomerDao implements CustomerDao {

	ArrayList<Customer> customers = new ArrayList<Customer>();
	
	public StubCustomerDao() {
		customers.add(new Customer("Johnny", "Mack", "99 The Street", "Ballytown", "Limerick", 20000.0));
		customers.add(new Customer("Jill", "O'Mahoney", "33 The Lane", "Kilthere", "Meath", 53257.43));
	}
	
	@Override
	public List<Customer> findAll() {
		return customers;
	}

	@Override
	public List<Customer> getByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Customer customer) {
		customers.add(customer);
	}

	@Override
	public List<Customer> findInTown(String town) {
		// TODO Auto-generated method stub
		return null;
	}

}
