package com.booking;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.arul.booking.model.SeatAvailability;
import com.arul.booking.model.UserModel;
import com.arul.booking.repository.SeatAvalibilityRepo;
import com.arul.booking.repository.UserModelRepository;
import com.arul.booking.services.AvailabilityService;
import com.arul.booking.services.UserServices;

@SpringBootTest(classes = FlightBookApplicationTests.class)
class FlightBookApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@InjectMocks
	AvailabilityService availabilityService;
	
	@InjectMocks
	UserServices userServices;
	
	@Mock
	SeatAvalibilityRepo seatAvalibilityRepo;
	
	@Mock
	UserModelRepository userRepository;
	
	@Test
	public void getUserDetailsByNameTest() {
		UserModel user1=new UserModel("X101","RAJ","KUMAR",3);
		UserModel user2=new UserModel("X102","JOHN","JOHN",3);
		UserModel user3=new UserModel("X103","RAHUL","SHARMA",3);
		
		when(userRepository.findById("X101")).thenReturn(Optional.of(user1));
		assertEquals("X101",userServices.getUserDetailsByName("X101").getFlightId());	
		
		when(userRepository.findById("X102")).thenReturn(Optional.of(user2));
		assertEquals("X102",userServices.getUserDetailsByName("X102").getFlightId());	
		
		when(userRepository.findById("X103")).thenReturn(Optional.of(user3));
		assertEquals("X103",userServices.getUserDetailsByName("X103").getFlightId());	
	}
	
	@Test
	public void saveUserDetailTest() {
		UserModel user1=new UserModel("101","X101","RAJ","KUMAR",3);
		UserModel user2=new UserModel("102","X102","JOHN","JOHN",3);
		UserModel user3=new UserModel("103","X103","RAHUL","SHARMA",3);
		
		System.out.println(user1.getNoOfPassengers());
		SeatAvailability flightseat=seatAvalibilityRepo.findById(user1.getFlightId()).get();
		System.out.println(flightseat);
		System.out.println(flightseat.getAvailable());
		if(user1.getNoOfPassengers()<=flightseat.getAvailable()) {
			userRepository.save(user1);
			int updatedseats=flightseat.getAvailable()-user1.getNoOfPassengers();
			flightseat.available=updatedseats;
			
			seatAvalibilityRepo.save(flightseat);
		}
		
//		when(userRepository.save(user1)).thenReturn(user1);
//		when(seatAvalibilityRepo.save(flightseat)).thenReturn(flightseat);
		assertEquals("FlightId : X101 Booking Id : 101 Seats Booked : 3",userServices.saveUserDetail(user1));	
	}
	
	
	
	

}
