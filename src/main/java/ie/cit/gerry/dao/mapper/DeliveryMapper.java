package ie.cit.gerry.dao.mapper;

import ie.cit.gerry.Delivery;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DeliveryMapper implements RowMapper<Delivery>{
	
	@Override
	public Delivery mapRow(ResultSet rs, int i) throws SQLException {
		
		Delivery delivery = new Delivery();
		delivery.setDeliveryID(rs.getInt("deliveryID"));
		delivery.setOrderID(rs.getInt("orderID"));
		delivery.setFirstName(rs.getString("firstName"));
		delivery.setSecondName(rs.getString("secondName"));
		delivery.setAddress1(rs.getString("address1"));
		delivery.setAddress2(rs.getString("address2"));
		delivery.setAddress3(rs.getString("address3"));
		delivery.setDeliveryDate(rs.getDate("deliveryDate"));
		
		return delivery;
	}	

}
