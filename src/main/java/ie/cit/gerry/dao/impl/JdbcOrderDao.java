package ie.cit.gerry.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.gerry.Order;
import ie.cit.gerry.dao.OrderDao;
import ie.cit.gerry.dao.mapper.OrderMapper;

@Repository
public class JdbcOrderDao implements OrderDao{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcOrderDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Order> findAll() {
		String sql = "SELECT * FROM myOrder";
		return jdbcTemplate.query(sql, new OrderMapper());
	}


	@Override
	public Order getByOrderID(int orderID) {
		String sql = "SELECT * FROM myOrder WHERE orderID = ?";
		return jdbcTemplate.queryForObject(sql, new OrderMapper(), orderID);
	}
	

	
	@Override
	public List<Order> findByCustomerID(int customerID) {
		String sql = "SELECT * FROM myOrder WHERE customerID = ?";
		return jdbcTemplate.query(sql, new OrderMapper(), customerID);
	}

	
	@Override
	public void save(Order order) {
		if (order.getOrderID() < 0) {
			add(order);
		} else {
			update(order);
		}
	}

	public void add(Order order) {
		jdbcTemplate.update("INSERT INTO myOrder (customerID, sku, quantity, total)"
				+ " VALUES (?, ?, ?, ?)",order.getCustomerID(), order.getSku(),order.getQuantity(),
				order.getTotal());
	}
	

	public void update(Order order) {
		jdbcTemplate.update("UPDATE myOrder SET customerID = ?, sku = ?,  quantity = ?, total= ?" +
				" WHERE orderID = ?", order.getCustomerID(), order.getSku(),order.getQuantity() ,
				order.getTotal(), order.getOrderID());
	}

}