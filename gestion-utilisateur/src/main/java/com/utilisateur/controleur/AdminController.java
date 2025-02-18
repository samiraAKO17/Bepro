package com.utilisateur.controleur;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utilisateur.model.Admin;
import com.utilisateur.model.Role;
import com.utilisateur.service.AdminService;
import com.utilisateur.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("utilisateur/admins")
public class AdminController {

	@Autowired
	private AdminService s;
	
	@Autowired
	private RoleService sr;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping("/")
	public List<Admin> getAllUsers(){
		
		return s.admins();
	}			
	
	@PostMapping("/")
	public Admin createUser(@RequestBody Admin user) {
		user.setPass(encoder.encode(user.getPass()));
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(sr.getRoleById(1L));
		user.setRoles(roles);
		
		 s.addAdmin(user);
		 return user;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Admin> getUserById(@PathVariable Long id) {
		Admin user = s.getAdminById(id);
		return ResponseEntity.ok(user);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Admin> updateUser(@PathVariable Long id, @RequestBody Admin userDetails){
		Admin user = s.getAdminById(id);
		//user.setPass(encoder.encode(user.getPass()));

		user.setNom(userDetails.getNom());
		user.setPrenom(userDetails.getPrenom());
		user.setEmail(userDetails.getEmail());

		user.setTelephone(userDetails.getTelephone());
		user.setPhoto(userDetails.getPhoto());
		//user.setRoles(userDetails.getRoles());
		
		s.updateAdmin(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteAdmin(@PathVariable Long id){
		Admin user = s.getAdminById(id);
		
		s.deleteAdmin(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
