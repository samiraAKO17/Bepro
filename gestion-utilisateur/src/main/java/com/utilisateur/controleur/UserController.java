package com.utilisateur.controleur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
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

import com.utilisateur.model.Role;
import com.utilisateur.model.Utilisateur;
import com.utilisateur.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("utilisateur/users")
public class UserController {
	
	@Autowired
	private UserService s;
	
	@Autowired
	BCryptPasswordEncoder encoder;

	@GetMapping("/")
	public List<Utilisateur> getAllUsers(){
		
		return s.utilisateurs();
	}			
	
	
	@PostMapping("/")
	public Utilisateur createUser(@RequestBody Utilisateur user) {
		System.out.print(user.toString());
		user.setPass(encoder.encode(user.getPass()));
		 s.addUtilisateur(user);
		 return user;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Utilisateur> getUserById(@PathVariable Long id) {
		Utilisateur user = s.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Utilisateur> updateUser(@PathVariable Long id, @RequestBody Utilisateur userDetails){
		Utilisateur user = s.getUserById(id);
		
		user.setNom(userDetails.getNom());
		user.setPrenom(userDetails.getPrenom());
		user.setEmail(userDetails.getEmail());

		user.setTelephone(userDetails.getTelephone());
		user.setPhoto(userDetails.getPhoto());
		user.setRoles(userDetails.getRoles());
		
		s.updateUtilisateur(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable Long id){
		Utilisateur user = s.getUserById(id);
		
		s.deleteUtilisateur(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/login/{email}")
	public ResponseEntity<Utilisateur> getUserByLogin(@PathVariable String email) {
		Utilisateur user = s.getUserByEmail(email);
		return ResponseEntity.ok(user);
	}
}
