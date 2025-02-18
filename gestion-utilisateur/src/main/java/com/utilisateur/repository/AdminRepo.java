package com.utilisateur.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.utilisateur.model.Admin;

@Repository
@Qualifier("UtilisateurRepo")
public interface AdminRepo extends UtilisateurRepo<Admin>{

}
