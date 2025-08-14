package com.sample.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Addresslist")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "aid")
	private int id;	
	
	
	private int empid;
	
	private String address1;	
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String country;
	
	
}
