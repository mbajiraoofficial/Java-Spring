package com.sample.Repos;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.sample.Models.Product;

@Repository
public interface ProductsRepo extends ReactiveCrudRepository<Product, Integer> {

}
