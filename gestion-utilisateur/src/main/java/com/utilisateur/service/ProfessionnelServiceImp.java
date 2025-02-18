package com.utilisateur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.utilisateur.model.Professionnel;
import com.utilisateur.model.RepresentantEntreprise;
import com.utilisateur.repository.ProfessionnelRepo;

@Service
public class ProfessionnelServiceImp implements ProfessionnelService{

	@Qualifier("ProfessionnelRepo")
	@Autowired
	ProfessionnelRepo repo;
	@Override
	public List<Professionnel> professionnels() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addProfessionnel(Professionnel user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public void updateProfessionnel(Professionnel user) {
		// TODO Auto-generated method stub
		repo.save(user);

	}

	@Override
	public void deleteProfessionnel(Professionnel user) {
		// TODO Auto-generated method stub
		repo.delete(user);

	}

	@Override
	public Professionnel getProfessionnelById(Long id) {
		// TODO Auto-generated method stub
		Optional <Professionnel> r = null;
		r= repo.findById(id);
		return r.get();	
		
	}

}
