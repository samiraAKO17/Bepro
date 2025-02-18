package com.utilisateur.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utilisateur.model.Utilisateur;
import com.utilisateur.repository.UtilisateurRepo;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UtilisateurRepo repo;
	
	@Override
	public List<Utilisateur> utilisateurs() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		repo.save(user);
	}

	@Override
	public void updateUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		repo.save(user);

	}

	@Override
	public void deleteUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		repo.delete(user);

	}

	@Override
	public Utilisateur getUserById(Long id) {
		// TODO Auto-generated method stub
		Optional<Utilisateur> u = null;
		u = repo.findById(id);
		return 	u.get();

	}

	@Override
	public Utilisateur getUserByLoginAndPass(String login, String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return repo.getByEmail(email);
	}

	
}
