package com.db.mongo.exp.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Company")
public class Company {
	
	@Id
	private UUID companyId;
	private String companyName;
	private String companyShortName;

}
