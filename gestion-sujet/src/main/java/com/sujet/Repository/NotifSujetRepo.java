package com.sujet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sujet.model.NotifSujet;

@Repository
public interface NotifSujetRepo extends JpaRepository<NotifSujet, Long>{

}
