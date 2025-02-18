package com.sujet.service;

import java.util.List;

import com.sujet.model.Sujet;

public interface SujetService {
	
	List<Sujet> all();
	Sujet addSujet (Sujet sujet);
	void updateSujet (Sujet sujet);
	void deleteSujet (Sujet sujet);
	Sujet getSujetById(Long id);
}
