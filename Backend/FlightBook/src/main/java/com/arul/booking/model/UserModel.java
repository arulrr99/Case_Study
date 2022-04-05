package com.arul.booking.model;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "PassengerDetails")
public class UserModel {

	@Id
	private String bookingid;
	private String flightId;
	private String firstname;
	private String lastname;
	private int noOfPassengers;

	public UserModel() {
		super();
	}

	public UserModel(String flightId, String firstname, String lastname, int noOfPassengers) {
		super();
		this.flightId = flightId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.noOfPassengers = noOfPassengers;
	}

	public UserModel(String bookingid, String flightId, String firstname, String lastname, int noOfPassengers) {
		super();
		this.bookingid = bookingid;
		this.flightId = flightId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.noOfPassengers = noOfPassengers;
	}

	public String getBookingid() {
		return bookingid;
	}

	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
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
		return "UserModel [flightId=" + flightId + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", noOfPassengers=" + noOfPassengers + "]";
	}

}

//public String getName() {
//return name;
//}

//@Override
//public String toString() {
//	return "UserDetils [flightId=" + flightId + ", name=" + name + " ,username ="+username+ ", password=" + password
//			+ ", noOfPassengers=" + noOfPassengers + "]";
//}

//public String getPassword() {
//return password;
//}

//public UserModel(String flightId, String name,String username, String password, int noOfPassengers) {
//super();
//this.flightId = flightId;
//this.name = name;
//this.username=username;
//this.password = password;
//this.noOfPassengers = noOfPassengers;
//
//}
