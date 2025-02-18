package com.utilisateur.service;

import java.util.List;

import com.utilisateur.model.Admin;

public interface AdminService {

	
	List<Admin> admins();
	void addAdmin (Admin user);
	void updateAdmin (Admin user);
	void deleteAdmin (Admin user);
	Admin getAdminById(Long id);
}
