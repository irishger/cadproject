package ie.cit.gerry.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.gerry.Product;
import ie.cit.gerry.dao.ProductDao;
import ie.cit.gerry.dao.mapper.ProductMapper;

@Repository
public class JdbcProductDao implements ProductDao{
	
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcProductDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Product> findAll() {
		String sql = "SELECT * FROM product";
		return jdbcTemplate.query(sql, new ProductMapper());
	}


	@Override
	public Product getBySku(int sku) {
		String sql = "SELECT * FROM product WHERE sku = ?";
		return jdbcTemplate.queryForObject(sql, new ProductMapper(), sku);
	}
	

	
	@Override
	public void save(Product product) {
		if (product.getSku() < 0) {
			add(product);
		} else {
			update(product);
		}
	}

	public void add(Product product) {
		jdbcTemplate.update("INSERT INTO product (name, description, pricePerUnit, unitDescription, stockLevel)"
				+ " VALUES (?, ?, ?, ?, ?)", product.getName(), product.getDescription(), product.getPricePerUnit(),
				product.getUnitDescription(), product.getStockLevel());
	}

	public void update(Product product) {
		jdbcTemplate.update("UPDATE product SET name = ?, description = ?, pricePerUnit = ?, unitDescription = ?, stockLevel = ?" +
				" WHERE sku = ?", product.getName(), product.getDescription(), product.getPricePerUnit(),
				product.getUnitDescription(), product.getStockLevel(), product.getSku());
	}

	
	

}
