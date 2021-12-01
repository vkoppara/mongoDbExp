package com.db.mongo.exp.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.db.mongo.exp.model.Person;

public interface PersonRepository extends MongoRepository<Person, UUID>  {
	

	@Query("{'address.zipCode':?0}") 
	List<Person> findByZipCode(String zipCode);
	@Query("{'identities': { $elemMatch: {'issuer': ?0} }}")
	List<Person> findByIdentityIssuer(String issuer);

}
