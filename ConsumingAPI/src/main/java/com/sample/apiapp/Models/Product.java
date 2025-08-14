package com.sample.apiapp.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	private int id;
	private String name;
	private double price;
	private String category;
	private int stock;
}
