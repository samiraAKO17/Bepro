package com.encadrement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.encadrement.Feign.EncadrementSecurity;
import com.utilisateur.model.Utilisateur;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private EncadrementSecurity user0;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur user = user0.getUserByLogin(email);
		CustomUserDetails userDetails = null;
		if (user != null) {
			userDetails = new CustomUserDetails();
			userDetails.setUser(user);
		} else {
			throw new UsernameNotFoundException("User not exist with name : " + email);
		}
		return userDetails;

	}

}