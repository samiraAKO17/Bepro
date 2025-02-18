package com.encadrement.controleur;

import java.util.HashMap;
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

import com.encadrement.model.Tache;
import com.encadrement.service.TacheService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("gestStages/semaine/tache")
public class TacheController {

	@Autowired
	TacheService s;
		
		
	
	@PostMapping("/")
	public Tache createTache(@RequestBody Tache tache) {
		System.out.print(tache.toString());
		 s.addTache(tache);
		 
		 return tache;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Tache> getStageById(@PathVariable Long id) {
		
		return ResponseEntity.ok(s.getTacheById(id));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Tache> updateTache(@PathVariable Long id, @RequestBody Tache tacheDetails){
		Tache  tache = s.getTacheById(id);
		
		tache.setNomTache(tacheDetails.getNomTache());
		
		s.updateTache(tache);
		return ResponseEntity.ok(tache);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteTache(@PathVariable Long id){
		Tache tache = s.getTacheById(id);
		
		s.deleteTache(tache);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
