package com.arul.booking.services;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.arul.booking.model.SeatAvailability;
import com.arul.booking.model.UserModel;
import com.arul.booking.repository.SeatAvalibilityRepo;
import com.arul.booking.repository.UserModelRepository;

@Service
public class UserServices {

	@Autowired
	UserModelRepository userRepository;

	@Autowired
	SeatAvalibilityRepo seatAvalibilityRepo;

	// Adding data to user collection
	public String saveUserDetail(UserModel u) {
		System.out.println(u.getNoOfPassengers());
		SeatAvailability flightseat = seatAvalibilityRepo.findById(u.getFlightId()).get();
		System.out.println(flightseat);
		System.out.println(flightseat.getAvailable());

		if (u.getNoOfPassengers() <= flightseat.getAvailable()) {
			userRepository.save(u);
			int updatedseats = flightseat.getAvailable() - u.getNoOfPassengers();
			flightseat.available = updatedseats;

			seatAvalibilityRepo.save(flightseat);
			return ("FlightId : " + u.getFlightId() + " Booking Id : " + u.getBookingid() + " Seats Booked : "
					+ u.getNoOfPassengers());
		
		} else {
			return "Seats Not Avaliable";
		}

	}

	// User details of particular user by id
	public UserModel getUserDetailsByName(String id) {
		return userRepository.findById(id).get();
	}

}
