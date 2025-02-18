package com.encadrement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.encadrement.model.Semaine;
import com.encadrement.model.Stage;

@Repository
public interface SemaineRepo extends JpaRepository<Semaine, Long>{
	@Query("SELECT u FROM Semaine u WHERE u.stage= ?1")
	List<Semaine> findByStage(Stage stage);
}
