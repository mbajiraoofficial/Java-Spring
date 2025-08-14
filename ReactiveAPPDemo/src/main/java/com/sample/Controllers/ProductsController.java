package com.sample.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.Models.Product;
import com.sample.Repos.ProductsRepo;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	ProductsRepo repo;
	
	@GetMapping
	public ResponseEntity<Flux<Product>> getAll()
	{
		return ResponseEntity.ok(repo.findAll());
	}
}
