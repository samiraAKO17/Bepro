package com.encadrement.service;

import java.util.List;

import com.encadrement.model.Semaine;
import com.encadrement.model.Stage;

public interface SemaineService {
	List<Semaine> all();
	Semaine addSemaine (Semaine semaine);
	void updateSemaine (Semaine semaine);
	void deleteSemaine (Semaine semaine);
	Semaine getSemaineById(Long id);
	List<Semaine> SemainesByStage(Stage stage);
}
