package com.arul.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.arul.booking.model.SeatAvailability;
import com.arul.booking.model.UserModel;
import com.arul.booking.services.AvailabilityService;

@RestController
@CrossOrigin(origins = "*")
public class AddVacancyController {
	@Autowired
	AvailabilityService availabilityService;
	
	// add vacancy list
	@PostMapping("/addvacancy")
	public void seats(@RequestBody SeatAvailability seat) {
		availabilityService.save(seat);
	}
	
	//get particular flights passengers
	@GetMapping("/flightusers/{id}")
	public List<UserModel> getUserDetails(@PathVariable String id){
		return availabilityService.getFlightUser(id);
		
	}
	
	
}
	