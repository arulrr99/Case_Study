package com.arul.booking.repository;


import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.arul.booking.model.UserModel;
@Repository
public interface UserModelRepository extends MongoRepository<UserModel, String> {
	
	UserModel findByfirstname(String username);

}
