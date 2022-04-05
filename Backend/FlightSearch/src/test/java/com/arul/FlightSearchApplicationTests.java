package com.arul;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.arul.model.FlightDetails;
import com.arul.repo.FlightDetailsRepository;
import com.arul.services.FromToDetailsService;

@SpringBootTest(classes = {FlightSearchApplicationTests.class})
class FlightSearchApplicationTests {

	@Test
	void contextLoads() {
	}
	
	 @InjectMocks
	 FromToDetailsService Service;
	 
	 @Mock
     FlightDetailsRepository flightRepository;
	 
	 public List<FlightDetails> myflights;
	 
	 //getting all flights
	 @Test
	 public void getflightDetailsTest() {
		 List<FlightDetails> myflights=new ArrayList<FlightDetails>();
		 myflights.add(new FlightDetails("X101", "ABC", "XYZ", 0, "DD-MM-YYY"));
		 myflights.add(new FlightDetails("X102", "ABD", "XYA", 1, "DD-MM-YYY"));
		 myflights.add(new FlightDetails("X103", "ABE", "XYB", 2, "DD-MM-YYY"));
		 
		 when(flightRepository.findAll()).thenReturn(myflights);
		 assertEquals(myflights,Service.getflightDetails());
		 
	 }
	 
	 //getting flight with particular id
	 @Test
	 public void getflightDetailsByNameTest() {
		 FlightDetails myflights1=new FlightDetails("X101", "ABC", "XYZ", 0, "DD-MM-YYY");
		 FlightDetails myflights2=new FlightDetails("X102", "ABD", "XYA", 1, "DD-MM-YYY");
		 FlightDetails myflights3=new FlightDetails("X103", "ABE", "XYB", 2, "DD-MM-YYY");
		 
		 when(flightRepository.findById("X101")).thenReturn(Optional.of(myflights1));
		 assertEquals("X101",Service.getflightDetailsByName("X101").getFlightId());
		 
		 when(flightRepository.findById("X102")).thenReturn(Optional.of(myflights2));
		 assertEquals("X102",Service.getflightDetailsByName("X102").getFlightId());
		 
		 when(flightRepository.findById("X103")).thenReturn(Optional.of(myflights3));
		 assertEquals("X103",Service.getflightDetailsByName("X103").getFlightId());
		 
	 }
	 
	 //deleting flight
	 @Test
	 public void deleteflightDetailsTest() {
		 FlightDetails myflights1=new FlightDetails("X101", "ABC", "XYZ", 0, "DD-MM-YYY");
		 FlightDetails myflights2=new FlightDetails("X102", "ABD", "XYA", 1, "DD-MM-YYY");
		 FlightDetails myflights3=new FlightDetails("X103", "ABE", "XYB", 2, "DD-MM-YYY");
		 
		 flightRepository.deleteById("X101");
		 assertEquals("Deleted flight id X101",Service.deleteflightDetails("X101"));
		 
		 flightRepository.deleteById("X102");
		 assertEquals("Deleted flight id X102",Service.deleteflightDetails("X102"));
		 
		 flightRepository.deleteById("X103");
		 assertEquals("Deleted flight id X103",Service.deleteflightDetails("X103"));
		 
		 
		 
//		 when(flightRepository.findById("X102")).thenReturn(Optional.of(myflights2));
//		 assertEquals("X102",Service.getflightDetailsByName("X102").getFlightId());
		 		 
	 }
	 
	 @Test
	 public void getAllflightDetailsTest() {
		 List<FlightDetails> myflights=new ArrayList<FlightDetails>();
		 List<FlightDetails> Match=new ArrayList<FlightDetails>();
		 myflights.add(new FlightDetails("X101", "ABC", "XYZ", 0, "01-02-2022"));
		 myflights.add(new FlightDetails("X102", "ABD", "XYA", 1, "DD-MM-YYYY"));
		 myflights.add(new FlightDetails("X103", "ABE", "XYB", 2, "DD-MM-YYYY"));

		 for(FlightDetails f: myflights) {
			  if(f.getDeparture().equals("ABC") && f.getDestination().equals("XYZ") && f.getDate().equals("01-02-2022"))
			  { 
				  Match.add(f);
			  
			  }
			  }
		 when(flightRepository.findAll()).thenReturn(myflights);
		 assertEquals(Match,Service.getAllflightDetails("ABC","XYZ","01-02-2022"));
	 }
	 
	 
	 
	 @Test
	 public void saveTest() {
		 FlightDetails myflights1=new FlightDetails("X101", "ABC", "XYZ", 0, "DD-MM-YYY");
		 when(flightRepository.save(myflights1)).thenReturn(myflights1);
		 assertEquals("Flight Added with ID: X101",Service.save(myflights1));
	 }
	 
	 @Test
	 public void saveOrUpdateTest() {
		 FlightDetails myflights1=new FlightDetails("X101", "ABC", "XYZ", 0, "DD-MM-YYY");
		 when(flightRepository.save(myflights1)).thenReturn(myflights1);
		 assertEquals("Flight updated with ID: X101",Service.saveOrUpdate(myflights1));
	 }
	 
	 
	 
	
}
