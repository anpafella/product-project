package service;

import java.util.List;

import model.Product;

public interface ProductService {

	Product create(Product product);
	
	Product update(Product product, Integer id);
	
	Product getById(Integer id);
	
	List<Product>getAll();
	
	void delete(Integer id);
	
	
	
}
