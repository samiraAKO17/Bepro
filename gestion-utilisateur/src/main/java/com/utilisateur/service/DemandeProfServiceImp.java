package com.utilisateur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.utilisateur.repository.DemandeProfRepo;
import com.utilisateur.model.DemandeProf;
@Service
public class DemandeProfServiceImp implements DemandeProfService{

	
	@Qualifier("DemandeProfRepo")
	@Autowired
	DemandeProfRepo repo;
	
	@Override
	public List<DemandeProf> DemandeProf() {
		// TODO Auto-generated method stub
		return repo.findAll();
		}

	@Override
	public DemandeProf addDemandeProf(DemandeProf demandeProf) {
		// TODO Auto-generated method stub
		return repo.save(demandeProf);
	}

	@Override
	public void updateDemandeProf(DemandeProf demandeProf) {
		// TODO Auto-generated method stub
		repo.save(demandeProf);
	}

	@Override
	public void deleteDemandeProf(DemandeProf demandeProf) {
		// TODO Auto-generated method stub
		repo.delete(demandeProf);
	}

	@Override
	public DemandeProf getDemandeProfById(Long id) {
		// TODO Auto-generated method stub
		Optional <DemandeProf> r = null;
		r= repo.findById(id);
		return r.get();	
	}

}
