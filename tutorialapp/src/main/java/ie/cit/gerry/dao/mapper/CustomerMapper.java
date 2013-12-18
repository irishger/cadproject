package ie.cit.gerry.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.gerry.Customer;

import org.springframework.jdbc.core.RowMapper;

public class CustomerMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int i) throws SQLException {
		Customer c = new Customer();
		c.setId(rs.getInt("id"));
		c.setFirstName(rs.getString("firstName"));
		c.setSecondName(rs.getString("secondName"));
		c.setAddress1(rs.getString("address1"));
		c.setAddress2(rs.getString("address2"));
		c.setAddress3(rs.getString("address3"));
		c.setCreditLimit(rs.getDouble("creditLimit"));
		return c;
	}

}
