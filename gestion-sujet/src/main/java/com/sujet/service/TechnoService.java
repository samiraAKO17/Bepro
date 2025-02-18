package com.sujet.service;

import java.util.List;

import com.sujet.model.Categorie;
import com.sujet.model.Technologie;


public interface TechnoService {
	
	List<Technologie> all();
	Technologie addTech (Technologie tech);
	void updateTech (Technologie tech);
	void deleteTech (Technologie tech);
	Technologie getTechById(Long id);
}
