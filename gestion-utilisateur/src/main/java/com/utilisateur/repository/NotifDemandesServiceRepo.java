package com.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utilisateur.model.NotifDemandes;

@Repository
public interface NotifDemandesServiceRepo extends JpaRepository<NotifDemandes, Long>{

}
