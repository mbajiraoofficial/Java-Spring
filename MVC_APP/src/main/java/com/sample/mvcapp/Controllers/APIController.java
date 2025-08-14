package com.sample.mvcapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sample.mvcapp.Models.Product;
import com.sample.mvcapp.Services.ProductsService;

@RestController()
@RequestMapping("/api/products")
public class APIController {
	
	@Autowired
	ProductsService serv;
	
	@GetMapping
	public ResponseEntity<List<Product>> GetAll()
	{
		List<Product> prods=serv.GetAllProducts();
			return ResponseEntity.ok(prods);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> GetById(@PathVariable int id)
	{
		Product prod=serv.GetByProductId(id).orElse(new Product());
		if(prod.getId()>0)
		{
			return ResponseEntity.ok(prod);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Product> AddProduct(@RequestBody Product prod)
	{
		Product product=serv.Save(prod);
		return ResponseEntity.ok(product);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Product> UpdateProduct(@PathVariable int id,
			@RequestBody Product prod)
	{
		if(id==0)
		{
			return ResponseEntity.badRequest().build();
		}
		else {
			Product product=serv.Save(prod);
			return ResponseEntity.ok(product);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> DeleteProduct(@PathVariable int id)
	{
		if(id==0)
		{
			return ResponseEntity.badRequest().build();
		}
		else {
			serv.DeleteByProductId(id);
			return ResponseEntity.ok().build();
		}
	}
	
	
}
