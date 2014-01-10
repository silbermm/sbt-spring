package dao;

import java.util.List;

import models.MongoCustomer;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface MongoCustomerRepository extends MongoRepository<MongoCustomer, String> {

    public MongoCustomer findByFirstName(String firstName);
    public List<MongoCustomer> findByLastName(String lastName);

}