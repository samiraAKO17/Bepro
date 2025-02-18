package com.utilisateur.service;

import java.util.List;

import com.utilisateur.model.RepresentantEntreprise;

public interface RepresentantService {
	
	List<RepresentantEntreprise> societes();
	void addRepresentant (RepresentantEntreprise user);
	void updateRepresentant (RepresentantEntreprise user);
	void deleteRepresentant (RepresentantEntreprise user);
	RepresentantEntreprise getRepresentantById(Long id);
}
