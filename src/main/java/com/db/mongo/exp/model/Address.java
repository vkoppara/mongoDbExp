package com.db.mongo.exp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	private String addressLine1;
	private String addressLine2;
	private String street;
	private String Country;
	private String City;
	private String zipCode;

}
