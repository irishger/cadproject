package ie.cit.gerry.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import ie.cit.gerry.Customer;
import ie.cit.gerry.dao.CustomerDao;
import ie.cit.gerry.service.CustomerService;
import ie.cit.gerry.service.impl.CustomerServiceImpl;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-config.xml")
public class CustomerServiceImplMockTest {

	private CustomerService customerService;
	private CustomerDao customerDaoMock;
	
	@Before
	public void setup() {
		customerDaoMock = mock(CustomerDao.class);

		Customer c = new Customer();
		c.setId(1);
		c.setAddress1("The Street");
		c.setAddress2("The Neighbourhood");
		c.setAddress3("Cork");
		c.setFirstName("Tom");
		c.setSecondName("Hardy");
		c.setCreditLimit(5000);
		
		when(customerDaoMock.getById(1)).thenReturn(c);
		
		List<Customer> clist = new ArrayList<Customer>();
		clist.add(c);
		when(customerDaoMock.getByCity("Cork")).thenReturn(clist);
		
		customerService = new CustomerServiceImpl(customerDaoMock);
	}
	
	@Test
	public void testGetCorkCustomers() {
		assertEquals(1, customerService.getCorkCustomers().size());
	}

	@Test
	public void testGetById() {
		String firstName = customerService.getCustomer(1).getFirstName();
		String secondName = customerService.getCustomer(1).getSecondName();
		assertTrue(firstName.equals("Tom") && secondName.equals("Hardy"));
	}

}
