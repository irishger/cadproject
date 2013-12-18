package ie.cit.gerry.service.impl;

import static org.junit.Assert.*;
import ie.cit.gerry.service.CustomerService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-config.xml")
public class CustomerServiceImplTest {

	@Autowired
	private CustomerService customerService;
	
	@Test
	public void testGetCorkCustomers() {
		assertEquals(2, customerService.getCorkCustomers().size());
	}
	
	@Test
	public void testGetCorkCustomersWrongSize() {
		assertFalse(customerService.getCorkCustomers().size() == 1);
	}

}
