package com.sujet.controleur;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.sujet.model.Technologie;
import com.sujet.service.TechnoService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("gestSujet/technologies")
public class TechnologieController {
	@Autowired
	private TechnoService s;
	
	@GetMapping("/")
	public List<Technologie> getAllTechs(){
		
		return s.all();
	}			
	
	
	@PostMapping("/")
	public Technologie createTech(@RequestBody Technologie Tech) {
		System.out.print(Tech.toString());
		 Technologie t =s.addTech(Tech);
		 return t;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Technologie> getTechById(@PathVariable Long id) {
		Technologie Tech = s.getTechById(id);
		return ResponseEntity.ok(Tech);
	}
	
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Technologie> updateTech(@PathVariable Long id, @RequestBody Technologie TechDetails){
		Technologie Tech = s.getTechById(id);
		
		Tech.setNom(TechDetails.getNom());
		
		
		s.updateTech(Tech);
		return ResponseEntity.ok(Tech);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTech(@PathVariable Long id){
		Technologie Tech = s.getTechById(id);
		
		s.deleteTech(Tech);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
