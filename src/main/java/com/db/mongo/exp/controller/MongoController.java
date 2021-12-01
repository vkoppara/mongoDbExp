package com.db.mongo.exp.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.db.mongo.exp.exception.CompanyNotFoundException;
import com.db.mongo.exp.model.Company;
import com.db.mongo.exp.model.Person;
import com.db.mongo.exp.repository.PersonRepository;
import com.db.mongo.exp.service.MongoService;

@RestController
public class MongoController {
	
	@Autowired
	private MongoService mongoService;
	
	@PostMapping("/savePerson")
	public Optional<Person> savePerson(@RequestBody Person person) throws CompanyNotFoundException{
		mongoService.save(person);
		return mongoService.getPerson(person.getPersonId());
	}
	
	@GetMapping("/getPersons")
	public List<Person> getPersons() {
		return mongoService.getAllPersons();
	}
	@GetMapping("/getPersons/zipCode/{zipCode}")
	public List<Person> getPersonByZipCode(@PathVariable("zipCode") String zipCode) {
		return mongoService.getPersonsByZipCode(zipCode);
	}
	
	@GetMapping("/getPersons/issuer/{issuer}")
	public List<Person> getPersonByIssuer(@PathVariable("issuer") String issuer) {
		return mongoService.getPersonsByIdentity(issuer);
	}
	
	@PostMapping("/saveCompany")
	public Optional<Company> saveCompany(@RequestBody Company company){
		mongoService.save(company);
		return mongoService.getCompany(company.getCompanyId());
	}
	
	@GetMapping("/getCompanies")
	public List<Company> getCompanies() {
		return mongoService.getAllCompanies();
	}

}
