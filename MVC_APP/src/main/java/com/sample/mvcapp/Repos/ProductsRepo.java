package com.sample.mvcapp.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.mvcapp.Models.Product;

@Repository
public interface ProductsRepo extends JpaRepository<Product, Integer> {

}
