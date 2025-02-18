package com.encadrement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encadrement.model.Tache;

@Repository
public interface TacheRepo extends JpaRepository<Tache, Long>{

}
