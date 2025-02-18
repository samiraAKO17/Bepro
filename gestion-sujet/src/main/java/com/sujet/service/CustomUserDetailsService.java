package com.sujet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sujet.Feign.Contacts;
import com.sujet.Feign.Security;
import com.utilisateur.model.Utilisateur;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private Security users;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur user = users.getUserByLogin(email);
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