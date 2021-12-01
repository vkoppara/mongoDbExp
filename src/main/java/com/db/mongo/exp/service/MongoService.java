package com.db.mongo.exp.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db.mongo.exp.exception.CompanyNotFoundException;
import com.db.mongo.exp.model.Company;
import com.db.mongo.exp.model.Person;
import com.db.mongo.exp.repository.CompanyRepository;
import com.db.mongo.exp.repository.PersonRepository;

@Component
public class MongoService {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public Optional<Person> getPerson(UUID personId) {
		return personRepository.findById(personId);
	}

	public void save(Person person) throws CompanyNotFoundException {
		if(!this.getCompany(person.getCompanyId()).isPresent()) {
			throw new CompanyNotFoundException("Company Not Found");
		}
		person.setPersonId(UUID.randomUUID());		
		personRepository.save(person);
		
	}
	public List<Person> getPersonsByZipCode(String zipCode){
		return personRepository.findByZipCode(zipCode);
	}
	
	public List<Person> getPersonsByIdentity(String issuer){
		return personRepository.findByIdentityIssuer(issuer);
	}

	public List<Person> getAllPersons() {
		return personRepository.findAll();
	}

	public void save(Company company) {
		company.setCompanyId(UUID.randomUUID());
		companyRepository.save(company);
		
	}

	public Optional<Company> getCompany(UUID companyId) {
		return companyRepository.findById(companyId);
	}

	public List<Company> getAllCompanies() {
		return companyRepository.findAll();
	}


	
}
