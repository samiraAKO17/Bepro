package com.utilisateur.controleur;

import java.util.ArrayList;
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

import com.utilisateur.model.Apprenant;
import com.utilisateur.model.Role;
import com.utilisateur.service.ApprenantService;
import com.utilisateur.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("utilisateur/apprenants")
public class ApprenantController {

	@Autowired
	private ApprenantService s;
	
	@Autowired
	private RoleService sr;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@GetMapping("/")
	public List<Apprenant> getAllUsers(){
		
		return s.apprenants();
	}			
	
	@PostMapping("/")
	public Apprenant createUser(@RequestBody Apprenant user) {
		
		user.setPass(encoder.encode(user.getPass()));
		Set<Role> roles = new HashSet<Role>();
		roles.add(sr.getRoleById(2L));
		user.setRoles(roles);
		 s.addApprenant(user);
		 return user;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Apprenant> getUserById(@PathVariable Long id) {
		Apprenant user = s.getApprenantById(id);
		return ResponseEntity.ok(user);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Apprenant> updateUser(@PathVariable Long id, @RequestBody Apprenant userDetails){
		Apprenant user = s.getApprenantById(id);
		user.setPass(encoder.encode(userDetails.getPass()));

		user.setNom(userDetails.getNom());
		user.setPrenom(userDetails.getPrenom());
		user.setEmail(userDetails.getEmail());

		user.setTelephone(userDetails.getTelephone());
		user.setPhoto(userDetails.getPhoto());
		//user.setRoles(userDetails.getRoles());
		
		s.updateApprenant(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteApprenant(@PathVariable Long id){
		Apprenant user = s.getApprenantById(id);
		
		s.deleteApprenant(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
