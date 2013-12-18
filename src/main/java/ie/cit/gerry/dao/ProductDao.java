package ie.cit.gerry.dao;

import ie.cit.gerry.Product;

import java.util.List;

public interface ProductDao {
	
	List<Product> findAll();
	Product getBySku(int sku);
	void add(Product product);
	
	void save(Product product);

}
