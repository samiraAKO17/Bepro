package com.encadrement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.encadrement.model.Stage;
@Repository
public interface StageRepository extends JpaRepository<Stage, Long>{
	@Query("SELECT u FROM Stage u WHERE u.apprenant_id = ?1")
	List<Stage> findByApprenant_id(Long apprenant_id);
	
	@Query("SELECT u FROM Stage u WHERE u.encadrant_id = ?1")
	List<Stage> findByEncadrant_id(Long encadrant_id);
	
	@Query("SELECT u FROM Stage u WHERE u.sujet_id = ?1")
	List<Stage> findBySujet_id(Long sujet_id);
}
