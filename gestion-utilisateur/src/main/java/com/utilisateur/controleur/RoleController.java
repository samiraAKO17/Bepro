package com.utilisateur.controleur;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utilisateur.model.Role;
import com.utilisateur.service.RoleService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class RoleController {

	@Autowired
	private RoleService s;
	
	@GetMapping("roles")
	public List<Role> getAll(){
		return s.roles();
	}		
	
	
	@PostMapping("roles")
	public void createRole(@RequestBody Role role) {
		 s.addRole(role);
	}
	
	
	@GetMapping("roles/{id}")
	public ResponseEntity<Role> getSubjectById(@PathVariable Long id) {
		Role role = s.getRoleById(id)
;		return ResponseEntity.ok(role);
	}
	
	
	@PutMapping("roles/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role RoleDetails){
		Role role = s.getRoleById(id);
		role.setNomRole(RoleDetails.getNomRole());
		
		 s.updateRole(role);
		return ResponseEntity.ok(role);
	}
	
	@DeleteMapping("roles/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
		Role role = s.getRoleById(id);		
		s.deleteRole(role);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
