package com.sujet.service;

import java.util.List;

import com.sujet.model.Categorie;


public interface CategorieService {
	
	List<Categorie> all();
	void addCat (Categorie cat);
	void updateCat (Categorie cat);
	void deleteCat (Categorie cat);
	Categorie getCatById(Long id);
}
