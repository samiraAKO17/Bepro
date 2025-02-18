package com.sujet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sujet.Repository.NotifSujetRepo;
import com.sujet.model.NotifSujet;

@Service
public class NotifSujetServiceImp implements NotifSujetService{

	@Autowired
	NotifSujetRepo repo;
	@Override
	public List<NotifSujet> list() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addNotifDemandes(NotifSujet n) {
		// TODO Auto-generated method stub
		repo.save(n);
	}

	@Override
	public void updateNotifDemandes(NotifSujet n) {
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
