package com.utilisateur.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.utilisateur.model.RepresentantEntreprise;

@Repository
@Qualifier("RepresentantRepo")
public interface RepresentantRepo extends UtilisateurRepo<RepresentantEntreprise>{

}
