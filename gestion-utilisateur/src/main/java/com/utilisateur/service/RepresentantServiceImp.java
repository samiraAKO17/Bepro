package com.utilisateur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.utilisateur.model.RepresentantEntreprise;
import com.utilisateur.repository.RepresentantRepo;

@Service
public class RepresentantServiceImp implements RepresentantService{

	@Qualifier("RepresentantRepo")
	@Autowired
	RepresentantRepo repo;
	
	@Override
	public List<RepresentantEntreprise> societes() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addRepresentant(RepresentantEntreprise user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public void updateRepresentant(RepresentantEntreprise user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public void deleteRepresentant(RepresentantEntreprise user) {
		// TODO Auto-generated method stub
		repo.delete(user);
	}

	@Override
	public RepresentantEntreprise getRepresentantById(Long id) {
		// TODO Auto-generated method stub
		Optional <RepresentantEntreprise> r = null;
		r= repo.findById(id);
		return r.get();
	}

}
