package com.utilisateur.service;

import java.util.List;

import com.utilisateur.model.Utilisateur;

public interface UserService {
	List<Utilisateur> utilisateurs();
	void addUtilisateur (Utilisateur user);
	void updateUtilisateur (Utilisateur user);
	void deleteUtilisateur (Utilisateur user);
	Utilisateur getUserById(Long id);
	Utilisateur getUserByLoginAndPass(String login,String pass);
	Utilisateur getUserByEmail(String email);
}
