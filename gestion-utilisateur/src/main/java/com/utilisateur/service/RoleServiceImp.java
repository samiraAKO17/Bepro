package com.utilisateur.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utilisateur.model.Role;
import com.utilisateur.repository.RoleRepository;

@Service
public class RoleServiceImp implements RoleService{
	
	@Autowired
	private RoleRepository repo;
	@Override
	public List<Role> roles() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public void addRole(Role role) {
		// TODO Auto-generated method stub
		repo.save(role);
	}

	@Override
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		repo.save(role);
	}

	@Override
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		repo.delete(role);
	}

	@Override
	public Role getRoleById(Long id) {
		// TODO Auto-generated method stub
		return repo.getOne(id);
	}
}
