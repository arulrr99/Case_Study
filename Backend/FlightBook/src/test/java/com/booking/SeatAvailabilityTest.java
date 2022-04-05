package com.booking;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;

import com.arul.booking.model.SeatAvailability;
import com.arul.booking.model.UserModel;
import com.arul.booking.repository.SeatAvalibilityRepo;
import com.arul.booking.repository.UserModelRepository;
import com.arul.booking.services.AvailabilityService;

@SpringBootTest(classes = SeatAvailabilityTest.class)

public class SeatAvailabilityTest {
	
	@Test
	void contextLoads() {
	}
	
	@InjectMocks
	AvailabilityService availabilityService;
	
	@Mock
	UserModelRepository userRepository;
	
	@Mock
	SeatAvalibilityRepo seatAvalibilityRepo;
	
	@Test
	public void saveTest() {
		SeatAvailability seats=new SeatAvailability("X101",100);
		when(seatAvalibilityRepo.save(seats)).thenReturn(seats);
		assertEquals("Seats saved for Id :X101", availabilityService.save(seats));
	}
	
	@Test
	public void getFlightUserTest() {
		 List<UserModel> myflights=new ArrayList<UserModel>();
		 List<UserModel> match=new ArrayList<UserModel>();
		 myflights.add(new UserModel("X101","RAJ","KUMAR",3));
		 myflights.add(new UserModel("X102","JOHN","JOHN",3));
		 myflights.add(new UserModel("X103","RAHUL","SHARMA",3));
		 
		 for(UserModel f:myflights) {
			 if(f.getFlightId().equals("X101")) {
				 match.add(f);
			 }
		 }
		 when(userRepository.findAll()).thenReturn(myflights);
		 assertEquals(match, availabilityService.getFlightUser("X101"));
		 
	}

}
