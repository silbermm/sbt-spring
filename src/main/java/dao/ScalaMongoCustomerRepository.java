package dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import sModels.MongoScalaCustomer;

public interface ScalaMongoCustomerRepository extends MongoRepository<MongoScalaCustomer, String>{
	
}
