package com.project.application.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.application.model.Product;
import com.project.application.repository.Products;

@RestController
@RequestMapping("/products")
public class ProductsResource {
	
	@Autowired
	private Products products;
	
	@PostMapping
	public Product adicionar(@Valid @RequestBody Product product) {
		return products.save(product);
	}
	
	@GetMapping
	public List<Product> listar() {
		return products.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> buscar(@PathVariable Long id) {
		Product product = products.findOne(id);
		
		if (product == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Product product) {
		Product existente = products.findOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(product, existente, "id");
		
		existente = products.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Product product = products.findOne(id);
		
		if (product == null) {
			return ResponseEntity.notFound().build();
		}
		
		products.delete(product);
		
		return ResponseEntity.noContent().build();
	}
}











