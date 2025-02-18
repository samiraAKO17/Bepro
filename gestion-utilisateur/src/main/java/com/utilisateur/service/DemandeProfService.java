package com.utilisateur.service;

import java.util.List;

import com.utilisateur.model.DemandeProf;

public interface DemandeProfService {
	List<DemandeProf> DemandeProf();
	DemandeProf addDemandeProf (DemandeProf demandeProf);
	void updateDemandeProf (DemandeProf demandeProf);
	void deleteDemandeProf (DemandeProf demandeProf);
	DemandeProf getDemandeProfById(Long id);
}
