package com.sample.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Table("products")
public class Product {
	@Id
	private int id;
	
	private String name;
	
	private double price;
	
	private String category;
	
	@Column("instock")
	private int stock;
}

