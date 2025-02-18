package com.sujet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujet.Repository.CategorieRepo;
import com.sujet.model.Categorie;

@Service
public class CategorieServiceImp implements CategorieService{

	@Autowired
	CategorieRepo repo;
	
	@Override
	public List<Categorie> all() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addCat(Categorie cat) {
		// TODO Auto-generated method stub
		repo.save(cat);
	}

	@Override
	public void updateCat(Categorie cat) {
		// TODO Auto-generated method stub
		repo.save(cat);
	}

	@Override
	public void deleteCat(Categorie cat) {
		// TODO Auto-generated method stub
		repo.delete(cat);
	}

	@Override
	public Categorie getCatById(Long id) {
		// TODO Auto-generated method stub
		Optional<Categorie> cat =  null;
		cat = repo.findById(id);
		return cat.get();
	}

}
