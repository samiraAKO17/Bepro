package com.utilisateur.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utilisateur.model.Utilisateur;

@Repository
@Primary
public interface UtilisateurRepo<T extends Utilisateur> extends JpaRepository<T , Long>{
	
	Utilisateur getByEmail(String email);
}
