package com.sample.Models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
	private int id;
	private String name;
	private int quantity;
}
