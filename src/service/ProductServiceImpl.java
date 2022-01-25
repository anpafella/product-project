package service;

import java.util.List;

import model.Product;
import test.ProductTest;

public class ProductServiceImpl implements ProductService{

	ProductTest productTest = new ProductTest();

	@Override
	public Product create(Product product) {
		ProductTest.productBD.add(product);
		return product;
	}

	@Override
	public Product update(Product product, Integer id) {
		
		Product productAretornar= null;
		
		for (int i = 0; i < ProductTest.productBD.size(); i++) {
			Product productFound = ProductTest.productBD.get(i);
			if ( productFound.getId().equals(id)) {
				productFound.setPrecio(product.getPrecio());
				productFound.setNombreProducto(product.getNombreProducto());
				productFound.setDescripcion(product.getDescripcion());
				
				productAretornar = productFound ;
				
			}
		}
		
		return productAretornar;
	}

	
	
	@Override
	public Product getById(Integer id) {

		Product productAretornar = null;
		for(int i= 0; i < ProductTest.productBD.size(); i++) {
			Product productFound = ProductTest.productBD.get(i);
			
			if(productFound.getId().equals(id)) {
				productAretornar = productFound;
			}
				
		}	
		
		return productAretornar;
	}

	@Override
	public List<Product> getAll() {
		
		return ProductTest.productBD;
	}

	@Override
	public void delete(Integer id) {
		
		
		for(int i= 0; i < ProductTest.productBD.size(); i++) {
			Product productFound = ProductTest.productBD.get(i);
			
			if(productFound.getId().equals(id)) {
				ProductTest.productBD.remove(i);
			}
		}		
	}	
	
	
	
	
}
