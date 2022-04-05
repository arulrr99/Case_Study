package com.arul.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arul.booking.model.UserModel;
import com.arul.booking.repository.UserModelRepository;
import com.arul.booking.services.UserServices;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserServices userServices;

	@Autowired
	UserModelRepository userModelRepository;

	// Add user details
	@PostMapping("/adduser")
	public String saveUserDetails(@RequestBody UserModel u) {
		return userServices.saveUserDetail(u);
	}

	// get flightid,no of passengers for payment microservice
	@GetMapping("/usergetdata/{id}")
	private UserModel getUserModelPayment(@PathVariable String id) {
		return userServices.getUserDetailsByName(id);
	}

	// user data
	@GetMapping("/userdetails/{id}")
	private UserModel getUserDetails(@PathVariable String id) {
		return userServices.getUserDetailsByName(id);
	}

	@GetMapping("/ad")
	public String admin() {
		return "admin";
	}

}








