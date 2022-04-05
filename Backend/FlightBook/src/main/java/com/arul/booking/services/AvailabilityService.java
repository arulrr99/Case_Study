package com.arul.booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arul.booking.model.SeatAvailability;
import com.arul.booking.model.UserModel;
import com.arul.booking.repository.SeatAvalibilityRepo;
import com.arul.booking.repository.UserModelRepository;

@Service
public class AvailabilityService {

	@Autowired
	SeatAvalibilityRepo seatAvalibilityRepo;

	@Autowired
	UserModelRepository userModelRepository;

	// add vacancy list
	public String save(SeatAvailability seat) {
		seatAvalibilityRepo.save(seat);
		return ("Seats saved for Id :" + seat.getFlightId());
	}

	// particular flights passenger list
	public List<UserModel> getFlightUser(String id) {
		List<UserModel> user = new ArrayList<UserModel>();
		List<UserModel> Match = new ArrayList<UserModel>();
		userModelRepository.findAll().forEach(e1 -> user.add(e1));
		System.out.println(user);

		for (UserModel f : user) {
			System.out.println(f.getFlightId() + " " + id);
			if (f.getFlightId().equals(id)) {
				Match.add(f);
			}
		}
		System.out.println(Match);
		return Match;
	}

}
