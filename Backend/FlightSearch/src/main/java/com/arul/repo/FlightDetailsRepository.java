package com.arul.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arul.model.FlightDetails;

public interface FlightDetailsRepository extends MongoRepository<FlightDetails, String> {

}