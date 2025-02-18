package com.sujet.Repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sujet.model.Categorie;

@Qualifier("CategorieRepo")
@Repository
public interface CategorieRepo extends JpaRepository<Categorie, Long>{

}
