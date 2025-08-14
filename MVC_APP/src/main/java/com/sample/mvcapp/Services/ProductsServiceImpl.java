package com.sample.mvcapp.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.mvcapp.Models.Product;
import com.sample.mvcapp.Repos.ProductsRepo;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	ProductsRepo repo;
	
	@Override
	public List<Product> GetAllProducts() {
		return repo.findAll();
	}

	@Override
	public Optional<Product> GetByProductId(int id) {
		return repo.findById(id);
	}

	@Override
	public Product Save(Product prod) {
		return repo.save(prod);
	}

	@Override
	public void DeleteByProductId(int id) {
		repo.deleteById(id);

	}

}
