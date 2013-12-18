package ie.cit.gerry.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.gerry.Customer;
import ie.cit.gerry.dao.CustomerDao;
import ie.cit.gerry.dao.mapper.CustomerMapper;

@Repository
public class JdbcCustomerDao implements CustomerDao {

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcCustomerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Customer> findAll() {
		String sql = "SELECT * FROM customer";
		return jdbcTemplate.query(sql, new CustomerMapper());
	}

	@Override
	public List<Customer> findInTown(String town) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer getById(int id) {
		String sql = "SELECT * FROM customer WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new CustomerMapper(), id);
	}
	
	

	
	@Override
	public List<Customer> getByCity(String city) {
		String sql = "SELECT * FROM customer WHERE address3 = ?";
		return jdbcTemplate.query(sql, new CustomerMapper(), city);
	}
	
	@Override
	public void save(Customer customer) {
		if (customer.getId() < 0) {
			add(customer);
		} else {
			update(customer);
		}
	}

	private void add(Customer customer) {
		jdbcTemplate.update("INSERT INTO customer (firstName, secondName, address1, address2, address3, creditLimit)"
				+ " VALUES (?, ?, ?, ?, ?, ?)", customer.getFirstName(), customer.getSecondName(), customer.getAddress1(),
				customer.getAddress2(), customer.getAddress3(), customer.getCreditLimit());
	}

	private void update(Customer customer) {
		jdbcTemplate.update("UPDATE customer SET firstName = ?, secondName = ?, address1 = ?, address2 = ?, address3 = ?, creditLimit = ?" +
				" WHERE id = ?", customer.getFirstName(), customer.getSecondName(), customer.getAddress1(),
				customer.getAddress2(), customer.getAddress3(), customer.getCreditLimit(), customer.getId());
	}
	

	

}
