package com.utilisateur.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.utilisateur.model.DemandeProf;


@Repository
@Qualifier("DemandeProfRepo")
public interface DemandeProfRepo extends UtilisateurRepo<DemandeProf>{

}
