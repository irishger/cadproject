package ie.cit.gerry.dao.mapper;

import ie.cit.gerry.Order;

import java.sql.ResultSet;
import java.sql.SQLException;


import org.springframework.jdbc.core.RowMapper;

public class OrderMapper implements RowMapper<Order>{
	
	
	@Override
	public Order mapRow(ResultSet rs, int i) throws SQLException {
		Order o = new Order();
		o.setOrderID(rs.getInt("orderID"));
		o.setCustomerID(rs.getInt("customerID"));
		o.setSku(rs.getInt("sku"));
		o.setQuantity(rs.getInt("quantity"));
		o.setTotal(rs.getDouble("total"));
		return o;
	}

}
