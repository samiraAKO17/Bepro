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

import com.utilisateur.model.RepresentantEntreprise;
import com.utilisateur.model.Role;
import com.utilisateur.service.RepresentantService;
import com.utilisateur.service.RoleService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("utilisateur/entreprises")
public class RepresentantController {

	@Autowired
	private RepresentantService s;
	

	@Autowired
	private RoleService sr;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping("/")
	public List<RepresentantEntreprise> getAllUsers(){
		
		return s.societes();
	}			
	
	@PostMapping("/")
	public RepresentantEntreprise createUser(@RequestBody RepresentantEntreprise user) {
		user.setPass(encoder.encode(user.getPass()));
		
		Set<Role> roles = new HashSet<Role>();
		roles.add(sr.getRoleById(4L));
		user.setRoles(roles);
		 s.addRepresentant(user);
		 return user;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<RepresentantEntreprise> getUserById(@PathVariable Long id) {
		RepresentantEntreprise user = s.getRepresentantById(id);
		return ResponseEntity.ok(user);
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<RepresentantEntreprise> updateUser(@PathVariable Long id, @RequestBody RepresentantEntreprise userDetails){
		RepresentantEntreprise user = s.getRepresentantById(id);
		
		user.setNom(userDetails.getNom());
		user.setPrenom(userDetails.getPrenom());
		user.setEmail(userDetails.getEmail());

		user.setTelephone(userDetails.getTelephone());
		user.setAdresse(userDetails.getAdresse());
		user.setSite(userDetails.getSite());
		user.setDescription(userDetails.getDescription());
		user.setIdentUnique(userDetails.getIdentUnique());
		user.setPhoto(userDetails.getPhoto());

		user.setSecteur(userDetails.getSecteur());
		user.setRoles(userDetails.getRoles());
		
		s.updateRepresentant(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRepresentant(@PathVariable Long id){
		RepresentantEntreprise user = s.getRepresentantById(id);
		user.setPass(encoder.encode(user.getPass()));

		s.deleteRepresentant(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
