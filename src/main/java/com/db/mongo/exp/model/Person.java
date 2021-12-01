package com.db.mongo.exp.model;

import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("Person")
public class Person {
	
	@Id
	private UUID personId;
	private String firstName;
	private String lastName;
	@Indexed(unique=true)
	private String emailId;
	private String category;
	private UUID companyId;
	private Address address;
	private List<Identity> identities;

}
