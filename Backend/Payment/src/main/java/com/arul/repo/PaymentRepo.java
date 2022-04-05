package com.arul.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.arul.model.Payment;

public interface PaymentRepo extends MongoRepository<Payment, String> {

}
