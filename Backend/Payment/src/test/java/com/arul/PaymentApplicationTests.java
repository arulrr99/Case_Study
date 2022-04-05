package com.arul;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.arul.model.Payment;
import com.arul.repo.PaymentRepo;
import com.arul.service.PaymentService;

@SpringBootTest(classes = {PaymentApplicationTests.class})
class PaymentApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Mock
	PaymentRepo paymentRepo;
	
	@InjectMocks
	PaymentService paymentService;	
	
	
	
//	@Test
//	public void returnpaymentdetailsTest() {
//		List<Payment> payment=new ArrayList<Payment>();
//		List<Payment> correctdetail=new ArrayList<Payment>();
//		
//		payment.add(new Payment("111","AAA","X101",3,2500,7500,false,false));
//		payment.add(new Payment("222","BBB","X102",3,2500,7500,false,false));
//		payment.add(new Payment("333","CCC","X103",3,2500,7500,false,false));
//		
//		for(Payment p1:payment) {
//			if(p1.getBookinId().equals("AAA")) {
//				correctdetail.add(p1);
//			}
//		}
//		when(paymentRepo.findAll()).thenReturn(payment);
//		assertEquals(correctdetail, paymentService.returnpaymentdetails("AAA"));
//	}

}
