package com.encadrement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encadrement.model.Semaine;
import com.encadrement.model.Stage;
import com.encadrement.repository.SemaineRepo;

@Service
public class SemaineServiceImpl implements SemaineService{

	@Autowired
	SemaineRepo repo;
	@Override
	public List<Semaine> all() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void updateSemaine(Semaine semaine) {
		// TODO Auto-generated method stub
		repo.save(semaine);
	}

	@Override
	public void deleteSemaine(Semaine semaine) {
		// TODO Auto-generated method stub
		repo.delete(semaine);
		
	}

	@Override
	public Semaine getSemaineById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Semaine> SemainesByStage(Stage stage) {
		// TODO Auto-generated method stub
		return repo.findByStage(stage);
	}

	@Override
	public Semaine addSemaine(Semaine semaine) {
		// TODO Auto-generated method stub
		return 		repo.save(semaine);
	}

}
