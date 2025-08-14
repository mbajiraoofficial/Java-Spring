package com.sample.apiapp.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.apiapp.Models.Product;

@Service
public class apiService {

	@Value("${api.base.url}")
	private String baseUrl;
	
	private final RestTemplate rest=new RestTemplate();
	
	public List<Product> getAll()
	{
		ResponseEntity<List<Product>> response= rest.exchange(
				baseUrl+"/api/products",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Product>>() {}
				);
		return response.getBody();
	}
	
	public Product getById(int id)
	{
		return rest.getForObject(baseUrl+"/api/products/"+id, Product.class);
	}
	
	public void add(Product prod)
	{
		rest.postForEntity(baseUrl+"/api/products", prod, Product.class);
	}
	
	public void update(int id,Product prod)
	{
		rest.put(baseUrl+"/api/products/"+id, prod);
	}
	public void delete(int id)
	{
		rest.delete(baseUrl+"/api/products/"+id);
	}
}
