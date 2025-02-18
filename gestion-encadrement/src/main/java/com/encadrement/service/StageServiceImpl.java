package com.encadrement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encadrement.model.Stage;
import com.encadrement.repository.StageRepository;
@Service
public class StageServiceImpl implements StageService {
	
	@Autowired
	StageRepository repo;
	@Override
	public List<Stage> all() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Stage addStage(Stage stage) {
		// TODO Auto-generated method stub
		return repo.save(stage);
	}

	@Override
	public void updateStage(Stage stage) {
		// TODO Auto-generated method stub
		repo.save(stage);
	}

	@Override
	public void deleteStage(Stage stage) {
		// TODO Auto-generated method stub
		repo.delete(stage);
	}

	@Override
	public Stage getStageById(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public List<Stage> stagesApprenant(Long apprenant_id) {
		// TODO Auto-generated method stub
		return repo.findByApprenant_id(apprenant_id);
	}

	@Override
	public List<Stage> encadrements(Long encadrant_id) {
		// TODO Auto-generated method stub
		return repo.findByEncadrant_id(encadrant_id);
	}

	@Override
	public List<Stage> sujets(Long sujet_id) {
		// TODO Auto-generated method stub
		return repo.findBySujet_id(sujet_id);
	}

}
