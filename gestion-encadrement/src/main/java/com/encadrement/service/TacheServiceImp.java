package com.encadrement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encadrement.model.Tache;
import com.encadrement.repository.TacheRepo;

@Service
public class TacheServiceImp implements TacheService{
	@Autowired
	TacheRepo repo;
	@Override
	public List<Tache> all() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Tache addTache(Tache tache) {
		// TODO Auto-generated method stub
		return repo.save(tache);
	}

	@Override
	public void updateTache(Tache tache) {
		// TODO Auto-generated method stub
		repo.save(tache);
	}

	@Override
	public void deleteTache(Tache tache) {
		// TODO Auto-generated method stub
		repo.delete(tache);
	}

	@Override
	public Tache getTacheById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

}
