package com.arul.booking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.arul.booking.model.SeatAvailability;

public interface SeatAvalibilityRepo extends MongoRepository<SeatAvailability, String> {

}
