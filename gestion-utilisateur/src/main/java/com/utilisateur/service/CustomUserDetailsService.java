package com.utilisateur.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.utilisateur.model.Utilisateur;
import com.utilisateur.repository.UtilisateurRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UtilisateurRepo repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utilisateur user = repo.getByEmail(email);
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