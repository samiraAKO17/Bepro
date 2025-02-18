package com.encadrement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.encadrement.model.Reunion;

@Repository
public interface ReunionRepo extends JpaRepository<Reunion, Long> {

}
