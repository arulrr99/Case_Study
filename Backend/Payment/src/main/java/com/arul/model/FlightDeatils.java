package com.arul.model;

import org.springframework.data.annotation.Id;

public class FlightDeatils {

	@Id
	private String flightId;
	private String departure;
	private String destination;
	private int price;
	private String date;

	public FlightDeatils() {
		super();
	}

	public FlightDeatils(String flightId, String departure, String destination, int price, String date) {
		super();
		this.flightId = flightId;
		this.departure = departure;
		this.destination = destination;
		this.price = price;
		this.date = date;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FlightDeatils [flightId=" + flightId + ", departure=" + departure + ", destination=" + destination
				+ ", price=" + price + ", date=" + date + "]";
	}

}
