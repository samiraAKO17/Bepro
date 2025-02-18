package com.utilisateur.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.utilisateur.model.Apprenant;
import com.utilisateur.model.Professionnel;
import com.utilisateur.repository.ApprenantRepo;

@Service
public class ApprenantServiceImp implements ApprenantService{

	
	@Qualifier("ApprenantRepo")
	@Autowired
	ApprenantRepo repo;
	@Override
	public List<Apprenant> apprenants() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addApprenant(Apprenant user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public void updateApprenant(Apprenant user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public void deleteApprenant(Apprenant user) {
		// TODO Auto-generated method stub
		repo.delete(user);
	}

	@Override
	public Apprenant getApprenantById(Long id) {
		// TODO Auto-generated method stub
		Optional <Apprenant> r = null;
		r= repo.findById(id);
		return r.get();	
	}

}
