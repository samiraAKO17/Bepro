package com.sujet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sujet.model.Categorie;
import com.sujet.model.Technologie;

@Repository
public interface TechnoRepo extends JpaRepository<Technologie, Long>{

}
