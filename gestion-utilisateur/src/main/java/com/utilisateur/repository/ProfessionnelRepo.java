package com.utilisateur.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.utilisateur.model.Professionnel;

@Repository
@Qualifier("ProfessionnelRepo")
public interface ProfessionnelRepo extends UtilisateurRepo<Professionnel>{

}
