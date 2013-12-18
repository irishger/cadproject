package ie.cit.gerry.dao.impl;

import ie.cit.gerry.Delivery;
import ie.cit.gerry.Order;
import ie.cit.gerry.dao.DeliveryDao;
import ie.cit.gerry.dao.OrderDao;
import ie.cit.gerry.dao.mapper.DeliveryMapper;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDeliveryDao implements DeliveryDao{
	
	JdbcTemplate jdbcTemplate;


	@Autowired
	public JdbcDeliveryDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Autowired
	OrderDao orderDao;


	@Override
	public List<Delivery> findAll() {
		String sql = "SELECT * FROM delivery";
		return jdbcTemplate.query(sql, new DeliveryMapper());
	}


	@Override
	public List<Delivery> findByDate(Date deliveryDate) {
		String sql = "SELECT * FROM delivery WHERE deliveryDate = ?";
		return jdbcTemplate.query(sql, new DeliveryMapper(), deliveryDate);
	}


	@Override
	public Delivery getByOrderID(int orderID) {
		String sql = "SELECT * FROM delivery WHERE orderID = ?";
		return jdbcTemplate.queryForObject(sql, new DeliveryMapper(), orderID);
	}


	@Override
	public List<Delivery> findByCustomerID(int customerID) {
		
		List<Order> orderList = orderDao.findByCustomerID(customerID);
		ArrayList<Delivery> deliveryList = new ArrayList<Delivery>();
		
		for (int i = 0; i<orderList.size(); i++){
			
			deliveryList.add(getByOrderID(orderList.get(i).getOrderID()));
		}
		
		return deliveryList;
	}


	@Override
	public void save(Delivery delivery) {
		if (delivery.getDeliveryID() < 0) {
			add(delivery);
		} else {
			update(delivery);
		}
	}

	
	private void update(Delivery delivery) {
		jdbcTemplate.update("UPDATE delivery SET orderID = ?, firstName = ?, secondName = ?, address1 = ?, address2 = ?, address3 = ?, deliveryDate = ?" +
				" WHERE deliveryID = ?",delivery.getOrderID(), delivery.getFirstName(), delivery.getSecondName(),
				delivery.getAddress1(),delivery.getAddress2(),delivery.getAddress2(),
				delivery.getDeliveryDate(), delivery.getDeliveryID()); 
		
	}
	
	private void add(Delivery delivery) {
		jdbcTemplate.update("INSERT INTO delivery (orderID, firstName, secondName, address1, address2, address3, deliveryDate)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)", delivery.getOrderID(), delivery.getFirstName(), delivery.getSecondName(), delivery.getAddress1(),
				delivery.getAddress2(), delivery.getAddress3(), delivery.getDeliveryDate());
			
	}


}
