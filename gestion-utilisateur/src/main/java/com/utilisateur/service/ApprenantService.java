package com.utilisateur.service;

import java.util.List;

import com.utilisateur.model.Apprenant;

public interface ApprenantService {

	List<Apprenant> apprenants();
	void addApprenant (Apprenant user);
	void updateApprenant (Apprenant user);
	void deleteApprenant (Apprenant user);
	Apprenant getApprenantById(Long id);
}
