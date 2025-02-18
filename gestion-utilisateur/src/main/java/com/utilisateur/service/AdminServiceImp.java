package com.utilisateur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.utilisateur.model.Admin;
import com.utilisateur.repository.AdminRepo;

@Service
public class AdminServiceImp implements AdminService {

	@Qualifier("UtilisateurRepo")
	@Autowired
	AdminRepo repo;
	@Override
	public List<Admin> admins() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addAdmin(Admin user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public void updateAdmin(Admin user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public void deleteAdmin(Admin user) {
		// TODO Auto-generated method stub
		repo.delete(user);
	}

	@Override
	public Admin getAdminById(Long id) {
		// TODO Auto-generated method stub
		Optional<Admin> a = null;
		a=repo.findById(id);
		return a.get();
	}

}
