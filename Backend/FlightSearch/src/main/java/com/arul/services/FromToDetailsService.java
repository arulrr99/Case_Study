package com.arul.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arul.model.FlightDetails;
import com.arul.repo.FlightDetailsRepository;

@Service
public class FromToDetailsService {

	@Autowired
	FlightDetailsRepository flightRepository;

	/* FromToDetails fromToDetails; */

	// Mapping values from flight collection in database

	/**
	 * 
	 * to get flights based on
	 */
	public List<FlightDetails> getAllflightDetails(String dep1, String des1, String date) {

		List<FlightDetails> flights = new ArrayList<FlightDetails>();
		List<FlightDetails> Match = new ArrayList<FlightDetails>();

		flightRepository.findAll().forEach(e1 -> flights.add(e1));

		for (FlightDetails f : flights) {
			if (f.getDeparture().equals(dep1) && f.getDestination().equals(des1) && f.getDate().equals(date)) {
				Match.add(f);

			}
		}

		System.out.println(Match);
		return Match;

	}

	// Add flight data
	public String save(FlightDetails f1) {
		flightRepository.save(f1);
		return ("Flight Added with ID: " + f1.getFlightId());
	}

	// get all flights details

	public List<FlightDetails> getflightDetails() {
		List<FlightDetails> f2 = new ArrayList<FlightDetails>();
		flightRepository.findAll().forEach(e1 -> f2.add(e1));
		return f2;

	}

	// find flight details by id
	public FlightDetails getflightDetailsByName(String id) {
		return flightRepository.findById(id).get();
	}

	// delete flight
	public String deleteflightDetails(String id) {
		flightRepository.deleteById(id);
		return ("Deleted flight id " + id);

	}

	// update flight
	public String saveOrUpdate(FlightDetails data) {
		flightRepository.save(data);
		return ("Flight updated with ID: " + data.getFlightId());
	}

}
