package com.utilisateur.service;

import java.util.List;

import com.utilisateur.model.Role;

public interface RoleService {

	List<Role> roles();
	void addRole (Role role);
	void updateRole(Role role);
	void deleteRole(Role role);
	Role getRoleById(Long id);
}
