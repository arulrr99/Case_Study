package com.arul.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PassengerDetails")
public class UserDetails {

	@Id
	private String bookingid;

	private String flightId;
	private String firstname;
	private String lastname;
	private int noOfPassengers;

	public UserDetails(String flightId, String firstname, String lastname, int noOfPassengers) {
		super();
		this.flightId = flightId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.noOfPassengers = noOfPassengers;
	}

	public UserDetails() {
		super();
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	@Override
	public String toString() {
		return "UserDetails [flightId=" + flightId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", noOfPassengers=" + noOfPassengers + "]";
	}

}
