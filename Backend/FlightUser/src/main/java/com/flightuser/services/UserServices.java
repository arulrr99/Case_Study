package com.flightuser.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.flightuser.model.UserModel;
import com.flightuser.repository.UserRepository;

@Service
public class UserServices implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel userfound = userRepository.findByUsername(username);
		if (userfound == null) {
			return null;
		}

		String name = userfound.getUsername();
		String pswd = userfound.getPassword();

		return new User(name, pswd, new ArrayList<>());
	}

}
