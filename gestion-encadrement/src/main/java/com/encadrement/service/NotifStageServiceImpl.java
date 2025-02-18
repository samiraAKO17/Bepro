package com.encadrement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encadrement.model.NotifStage;
import com.encadrement.repository.NotifStageRepo;



@Service
public class NotifStageServiceImpl implements NotifStageService{
	
	@Autowired
	NotifStageRepo repo;
	
	@Override
	public List<NotifStage> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addNotifDemandes(NotifStage n) {
		// TODO Auto-generated method stub
		repo.save(n);
	}

	@Override
	public void updateNotifDemandes(NotifStage n) {
		// TODO Auto-generated method stub
		repo.save(n);

	}

	@Override
	public void deleteNotifDemandes(Long id) {
		// TODO Auto-generated method stub
		repo.delete(repo.findById(id).get());
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		repo.deleteAll(); 
	}
}
