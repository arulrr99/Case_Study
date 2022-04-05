package com.arul.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FlightDetails")
public class FlightDetails {

	@Id
	private String flightId;

	private String departure;
	private String destination;
	private int price;
	private String date;

	public FlightDetails(String flightId, String departure, String destination, int price, String date) {
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

	public String getDeparture() {
		return departure;
	}

	public String getDestination() {
		return destination;
	}

	public int getPrice() {
		return price;
	}

	public String getDate() {
		return date;
	}

	@Override
	public String toString() {
		return "flightDetails [flightId=" + flightId + ", departure=" + departure + ", destination=" + destination
				+ ", price=" + price + ", date=" + date + "]";
	}

}
