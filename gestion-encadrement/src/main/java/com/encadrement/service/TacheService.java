package com.encadrement.service;

import java.util.List;

import com.encadrement.model.Tache;

public interface TacheService {

	List<Tache> all();
	Tache addTache (Tache tache);
	void updateTache (Tache tache);
	void deleteTache (Tache tache);
	Tache getTacheById(Long id);
}
