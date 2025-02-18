package com.utilisateur.service;

import java.util.List;

import com.utilisateur.model.Professionnel;

public interface ProfessionnelService {
	List<Professionnel> professionnels();
	void addProfessionnel (Professionnel user);
	void updateProfessionnel (Professionnel user);
	void deleteProfessionnel (Professionnel user);
	Professionnel getProfessionnelById(Long id);
}
