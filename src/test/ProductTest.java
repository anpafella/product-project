package test;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

public class ProductTest {

	public static List<Product> productBD = new ArrayList<Product>();

	public static ProductService productService = new ProductServiceImpl();

	public static void main(String[] args) {

		productBD.add(new Product(1, 4, "kolgate", "pasta dental"));
		productBD.add(new Product(2, 2, "lays", "papas fritas"));

		Product productToSave = new Product(3, 20, "scoth", "papel higiénico");
		Product productSaved = productService.create(productToSave);

		System.out.println("producto nuevo : " + productSaved);
		System.out.println("***************************************************");

		Product productToUpdate = new Product(null, 5, "panadol", "pastilla");

		Product productUpdated = productService.update(productToUpdate, 3);

		System.out.println("updated user :" + productUpdated);

		System.out.println(productBD);
		System.out.println("***************************************************");

		Integer id = 3;

		Product productGottenById = productService.getById(id);
		System.out.println(productGottenById);

		productService.delete(2);

		System.out.println(productBD);
		System.out.println("***************************************************");

		List<Product> productList = productService.getAll();
		{

			for (Product productToPrint : productList) {
				System.out.println("getAll:" + productToPrint);
			}

			System.out.println("*********************************************************");

		}

	}

}
