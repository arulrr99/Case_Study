package com.arul.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.arul.model.FlightDeatils;
import com.arul.model.Payment;
import com.arul.model.UserDetails;
import com.arul.repo.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PaymentRepo paymentRepo;

	// fetch data from booking microservice

	public void getpaymentdetails(String id) {
		UserDetails userDetails = restTemplate.getForObject("http://flight-book/user/usergetdata/" + id,
				UserDetails.class);
		System.out.println("Hello" + userDetails);
		int totaltravellers = userDetails.getNoOfPassengers();
		String flightIdForPrice = userDetails.getFlightId();
		int price = getprice(flightIdForPrice);
		System.out.println("Travellers " + totaltravellers);
		System.out.println("Price " + price);
		int totalprice = price * totaltravellers;
		int insert = 1;
		List<Payment> eachdetail = new ArrayList<>();
		paymentRepo.findAll().forEach(pay -> eachdetail.add(pay));
		for (Payment p1 : eachdetail) {
			if (p1.getBookinId().equals(id)) {
				insert = 0;
			}
		}
		if (insert == 1) {
			Payment payment1 = new Payment(null, id, flightIdForPrice, totaltravellers, price, totalprice, false,
					false);
			paymentRepo.save(payment1);

		}

	}

	// return payment details
	public List<Payment> returnpaymentdetails(String id) {
		List<Payment> eachdetail = new ArrayList<>();
		List<Payment> correctdetail = new ArrayList<>();
		paymentRepo.findAll().forEach(pay -> eachdetail.add(pay));
		for (Payment p1 : eachdetail) {
			if (p1.getBookinId().equals(id)) {
				correctdetail.add(p1);
			}
		}
		return correctdetail;
	}

	// fetch data from searching microservice
	public int getprice(String id) {
		FlightDeatils f = restTemplate.getForObject("http://flight-search/flight/" + id, FlightDeatils.class);
		System.out.println("Hello " + f);
		return f.getPrice();
	}

	// paying amount
	public String payment(String bookingid, int total) {
		Payment payment1 = paymentRepo.findById(bookingid).get();
		int totalpayment = payment1.getTotalPrice();
		if (totalpayment == total && payment1.isPaymentstatus() == false) {
			payment1.setPaymentstatus(true);
			paymentRepo.save(payment1);
			return ("Full Amount Paid with Id: " + payment1.getPaymentId());

		} else if (total < totalpayment && payment1.isPaymentstatus() == (false)) {
			return ("Pay full amount " + payment1.getTotalPrice());
		}

		else if (total > totalpayment && payment1.isPaymentstatus() == (false)) {
			payment1.setPaymentstatus(true);
			paymentRepo.save(payment1);
			int t = total - totalpayment;
			return ("Full Amount Paid with Id :" + payment1.getPaymentId() + " Balance amount : " + t + " returned");
		}
		return null;

	}

	public String checkIn(String paymentid) {
		Payment checkin = paymentRepo.findById(paymentid).get();
		if (checkin.isPaymentstatus() == false) {
			System.out.println("/////");
			return "Payment is not done yet";
		} else {
			checkin.setCheckinstatus(true);
			paymentRepo.save(checkin);
			return "CheckedIn Successfullly";
		}

	}

}
