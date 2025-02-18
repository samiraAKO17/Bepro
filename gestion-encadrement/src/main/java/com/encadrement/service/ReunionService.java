package com.encadrement.service;

import java.util.List;

import com.encadrement.model.Reunion;

public interface ReunionService {
	List<Reunion> all();
	Reunion addReunion (Reunion reunion);
	void updateReunion (Reunion reunion);
	void deleteReunion (Reunion reunion);
	Reunion getSemaineById(Long id);
}
