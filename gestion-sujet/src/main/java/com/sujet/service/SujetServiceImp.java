package com.sujet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujet.Repository.SujetRepo;
import com.sujet.model.Sujet;

@Service
public class SujetServiceImp implements SujetService{

	@Autowired
	SujetRepo repo;
	
	@Override
	public List<Sujet> all() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Sujet addSujet(Sujet sujet) {
		// TODO Auto-generated method stub
		return repo.save(sujet);
	}

	@Override
	public void updateSujet(Sujet sujet) {
		// TODO Auto-generated method stub
		repo.save(sujet);
		
	}

	@Override
	public void deleteSujet(Sujet sujet) {
		// TODO Auto-generated method stub
		repo.delete(sujet);
		
	}

	@Override
	public Sujet getSujetById(Long id) {
		// TODO Auto-generated method stub
		Optional<Sujet> sujet = null;
		sujet = repo.findById(id);
		return sujet.get();
	}

}
