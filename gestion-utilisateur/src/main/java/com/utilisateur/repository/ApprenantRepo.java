package com.utilisateur.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.utilisateur.model.Apprenant;

@Repository
@Qualifier("ApprenantRepo")
public interface ApprenantRepo extends UtilisateurRepo<Apprenant> {

}
