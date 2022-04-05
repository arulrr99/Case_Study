package com.flightuser.model;


public class AuthenticationResponse {
	
	private String response;
	private String role;
	

	public AuthenticationResponse() {
		
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public AuthenticationResponse(String response) {
		this.response = response;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public AuthenticationResponse(String response, String role) {
		super();
		this.response = response;
		this.role = role;
	}

}
