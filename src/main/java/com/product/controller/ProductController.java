package com.product.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.dto.ProductDTO;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	// EndPoint para crear
	// Product es un objeto, entidad, bean
	@PostMapping("/crear")
	public ProductDTO crear(@RequestBody @Valid ProductDTO product) {
		ProductDTO productoRecibido = productService.create(product);

		return productoRecibido;
	}

	// endPoint para eliminar
	@DeleteMapping("/{idParam}/delete")
	public void delete(@PathVariable(value = "idParam") Integer id) {
		productService.deleteById(id);

	}

	// end point para actualziar
	@PutMapping("/{id}/update")
	public ProductDTO update(@RequestBody @Valid ProductDTO client, @PathVariable(value = "id") Integer id) {
		ProductDTO clienteActualizado = productService.update(client, id);
		return clienteActualizado;

	}

	// end point para obtener cliente por id
	@GetMapping("/{id}/get")
	public ProductDTO getByid(@PathVariable(value = "id") Integer id) {
		ProductDTO clienteObtenido = productService.getById(id);
		return clienteObtenido;
	}

	// endpoint para obtener all

	@GetMapping("/get")
	public List<ProductDTO> getAll() {

		return productService.getAll();
	}

}
