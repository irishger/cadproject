package ie.cit.gerry.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.gerry.Customer;
import ie.cit.gerry.dao.CustomerDao;
import ie.cit.gerry.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	CustomerDao customerDao;
	
	@Autowired
	public CustomerServiceImpl(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	@Override
	public void saveCustomer(Customer customer) {
		customerDao.save(customer);
	}

	@Override
	public List<Customer> getCorkCustomers() {
		return customerDao.getByCity("Cork");
	}

	@Override
	public Customer getCustomer(int id) {
		return customerDao.getById(id);
	}

}
