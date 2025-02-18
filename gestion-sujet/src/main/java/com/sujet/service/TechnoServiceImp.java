package com.sujet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujet.Repository.TechnoRepo;
import com.sujet.model.Technologie;

@Service
public class TechnoServiceImp implements TechnoService{

	@Autowired
	TechnoRepo repo;
	
	@Override
	public List<Technologie> all() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Technologie addTech(Technologie tech) {
		// TODO Auto-generated method stub
		return repo.save(tech);
	}

	@Override
	public void updateTech(Technologie tech) {
		// TODO Auto-generated method stub
		repo.save(tech);
	}

	@Override
	public void deleteTech(Technologie tech) {
		// TODO Auto-generated method stub
		repo.delete(tech);
	}

	@Override
	public Technologie getTechById(Long id) {
		// TODO Auto-generated method stub
		 Optional<Technologie> cat = null;
		cat = repo.findById(id);
		return cat.get();
	}

}
