package com.encadrement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encadrement.model.Reunion;
import com.encadrement.repository.ReunionRepo;

@Service
public class ReunionServiceImpl implements ReunionService {

	@Autowired
	ReunionRepo repo;
	@Override
	public List<Reunion> all() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void updateReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		repo.save(reunion);
	}

	@Override
	public void deleteReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		repo.save(reunion);

	}

	@Override
	public Reunion getSemaineById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Reunion addReunion(Reunion reunion) {
		// TODO Auto-generated method stub
		return 		repo.save(reunion);
	}

}
