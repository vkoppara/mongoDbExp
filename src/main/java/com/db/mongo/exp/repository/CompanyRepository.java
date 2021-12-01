package com.db.mongo.exp.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.db.mongo.exp.model.Company;


public interface CompanyRepository  extends MongoRepository<Company, UUID> {

}
