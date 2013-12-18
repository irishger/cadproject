package ie.cit.gerry.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;



import ie.cit.gerry.Product;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product>{
	
	@Override
	public Product mapRow(ResultSet rs, int i) throws SQLException {
		Product p = new Product();
		p.setSku(rs.getInt("sku"));
		p.setName(rs.getString("name"));
		p.setDescription(rs.getString("description"));
		p.setPricePerUnit(rs.getDouble("pricePerUnit"));
		p.setStockLevel(rs.getInt("stockLevel"));
		p.setUnitDescription(rs.getString("unitDescription"));
	
		return p;
	}

}
