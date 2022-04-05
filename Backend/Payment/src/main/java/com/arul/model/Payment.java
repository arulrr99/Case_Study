package com.arul.model;

import org.springframework.data.annotation.Id;

public class Payment {

	@Id
	private String paymentId;
	private String bookinId;
	private String flightId;
	private int noOfPassengers;
	private int priceOfEachTicket;
	private int totalPrice;
	private boolean paymentstatus;
	private boolean checkinstatus;

	public Payment() {
		super();
	}

	public Payment(String paymentId, String bookinId, String flightId, int noOfPassengers, int priceOfEachTicket,
			int totalPrice, boolean paymentstatus, boolean checkinstatus) {
		super();
		this.paymentId = paymentId;
		this.bookinId = bookinId;
		this.flightId = flightId;
		this.noOfPassengers = noOfPassengers;
		this.priceOfEachTicket = priceOfEachTicket;
		this.totalPrice = totalPrice;
		this.paymentstatus = paymentstatus;
		this.checkinstatus = checkinstatus;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getBookinId() {
		return bookinId;
	}

	public void setBookinId(String bookinId) {
		this.bookinId = bookinId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public int getPriceOfEachTicket() {
		return priceOfEachTicket;
	}

	public void setPriceOfEachTicket(int priceOfEachTicket) {
		this.priceOfEachTicket = priceOfEachTicket;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public boolean isPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(boolean paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public boolean isCheckinstatus() {
		return checkinstatus;
	}

	public void setCheckinstatus(boolean checkinstatus) {
		this.checkinstatus = checkinstatus;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", bookinId=" + bookinId + ", flightId=" + flightId
				+ ", noOfPassengers=" + noOfPassengers + ", priceOfEachTicket=" + priceOfEachTicket + ", totalPrice="
				+ totalPrice + ", paymentstatus=" + paymentstatus + ", checkinstatus=" + checkinstatus + "]";
	}

}
