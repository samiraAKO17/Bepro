package com.utilisateur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utilisateur.model.NotifDemandes;
import com.utilisateur.repository.NotifDemandesServiceRepo;

@Service
public class NotifDemandesServiceImpl implements NotifDemandesService {
	
	@Autowired
	NotifDemandesServiceRepo repo;
	@Override
	public List<NotifDemandes> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addNotifDemandes(NotifDemandes n) {
		// TODO Auto-generated method stub
		repo.save(n);
	}

	@Override
	public void updateNotifDemandes(NotifDemandes n) {
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
