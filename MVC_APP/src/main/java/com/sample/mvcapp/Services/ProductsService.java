package com.sample.mvcapp.Services;

import java.util.List;
import java.util.Optional;

import com.sample.mvcapp.Models.Product;

public interface ProductsService {
	List<Product> GetAllProducts();
	Optional<Product> GetByProductId(int id);
	Product Save(Product prod);
	void DeleteByProductId(int id);
}
