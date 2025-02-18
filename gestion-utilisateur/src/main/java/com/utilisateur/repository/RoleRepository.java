package com.utilisateur.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.utilisateur.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

}
