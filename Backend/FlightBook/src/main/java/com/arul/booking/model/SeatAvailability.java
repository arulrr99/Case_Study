package com.arul.booking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "seatavailability")
public class SeatAvailability {

	@Id
	public String flightId;
	public int available;

	public SeatAvailability(String flightId, int available) {
		this.flightId = flightId;
		this.available = available;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "SeatAvailability [flightId=" + flightId + ", available=" + available + "]";
	}

}
