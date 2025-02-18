package com.encadrement.service;

import java.util.List;

import com.encadrement.model.Stage;


public interface StageService {
	List<Stage> all();
	Stage addStage (Stage stage);
	void updateStage (Stage stage);
	void deleteStage (Stage stage);
	Stage getStageById(Long id);
	List<Stage> stagesApprenant(Long apprenant_id);
	List<Stage> encadrements(Long encadrant_id);
	List<Stage> sujets(Long sujet_id);

}
