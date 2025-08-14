package com.sample.mvcapp.Models;

import jakarta.persistence.*;
import lombok.*;
import jakarta.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Name is Required")
	@Size(min = 5,max = 50,message = "Invalid Name Size")
	private String name;
	
	@NotNull(message = "Price is Required")
	private double price;
	
	@NotBlank(message = "Category is Required")
	@Size(min = 5,max = 50,message = "Invalid Category Size")
	private String category;
	
	@Column(name="instock")
	@NotNull(message = "Stock is Required")
	@Min(value = 1,message = "minimum 1 is Required")
	@Max(value=50, message="maximum 50 allowed")
	private int stock;
}
