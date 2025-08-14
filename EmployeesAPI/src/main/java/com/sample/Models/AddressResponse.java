package com.sample.Models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressResponse {
//	private int id;	
	private int empid;
	private String address1;	
	private String address2;
	private String address3;
	private String city;
	private String state;
	private String country;
}
