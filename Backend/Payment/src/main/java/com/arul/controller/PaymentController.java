package com.arul.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arul.model.Payment;
import com.arul.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	// check payment status
	@GetMapping("/checkstatus/{id}")
	public List<Payment> getPayment(@PathVariable String id) {
		paymentService.getpaymentdetails(id);
		return paymentService.returnpaymentdetails(id);
	}

	// payment
	@GetMapping("/price/{bookingid}/{total}")
	public String getPayment1(@PathVariable String bookingid, @PathVariable int total) {
		return paymentService.payment(bookingid, total);
	}

	// check-in
	@GetMapping("/checkin/{paymentid}")
	public String checkin(@PathVariable String paymentid) {
		return paymentService.checkIn(paymentid);

	}

}
