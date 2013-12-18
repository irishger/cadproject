package ie.cit.gerry.service;

import java.util.List;

import ie.cit.gerry.Customer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface CustomerService {
	
	void saveCustomer(Customer customer);
	
	List<Customer> getCorkCustomers();
	
	Customer getCustomer(int id);
	
	// plus other useful use case methods
}
