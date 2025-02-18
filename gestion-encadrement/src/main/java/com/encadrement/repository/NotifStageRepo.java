package com.encadrement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encadrement.model.NotifStage;

@Repository
public interface NotifStageRepo extends JpaRepository<NotifStage, Long>{

}
