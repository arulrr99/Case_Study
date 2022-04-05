package com.flightuser.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flightuser.model.AuthenticationRequest;
import com.flightuser.model.AuthenticationResponse;
import com.flightuser.model.UserModel;
import com.flightuser.repository.UserRepository;
import com.flightuser.services.UserServices;
import com.flightuser.utils.JwtUtils;

@RestController
@CrossOrigin(origins = "*")
public class AuthController {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserServices userServices;

	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping("/dashboard")
	private String testingToken() {
		return "Welcome to DASHBOARD " + SecurityContextHolder.getContext().getAuthentication().getName();
	}

	@PostMapping("/subs")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest) {
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		UserModel userModel = new UserModel();
		userModel.setUsername(username);
		userModel.setPassword(new BCryptPasswordEncoder().encode(password));
		try {
			userRepository.save(userModel);
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error during subscription for client " + username));
		}
		return ResponseEntity.ok(new AuthenticationResponse("Successful subscription for client " + username));

	}

	@PostMapping("/auth")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest) {
		String username = authenticationRequest.getUsername();
		String password = authenticationRequest.getPassword();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (Exception E) {
			return ResponseEntity.ok(new AuthenticationResponse("Unsuccessful authentication for client " + username));

		}
		UserDetails loadeduser = userServices.loadUserByUsername(username);
		String generatedToken = jwtUtils.generateToken(loadeduser);

		if (username.equals("admin")) {
			String role = "admin";
			return ResponseEntity.ok(new AuthenticationResponse(generatedToken, role));
		} else {
			String role = "user";
			return ResponseEntity.ok(new AuthenticationResponse(generatedToken, role));
		}

	}

}
