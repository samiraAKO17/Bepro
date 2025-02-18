package com.encadrement.controleur;

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

import com.encadrement.model.Reunion;
import com.encadrement.model.Semaine;
import com.encadrement.service.ReunionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("gestStages/reunion")
public class ReunionController {

	@Autowired
	ReunionService s;
		
		
	
	@PostMapping("/")
	public Reunion createReunion(@RequestBody Reunion reunion) {
		System.out.print(reunion.toString());
		 s.addReunion(reunion);
		 
		 return reunion;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Reunion> getStageById(@PathVariable Long id) {
		
		return ResponseEntity.ok(s.getSemaineById(id));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Reunion> updateSemaine(@PathVariable Long id, @RequestBody Reunion reunionDetails){
		Reunion  reunion = s.getSemaineById(id);
		
		reunion.setDate(reunionDetails.getDate());
		reunion.setHeure(reunionDetails.getHeure());
		
		s.updateReunion(reunion);
		return ResponseEntity.ok(reunion);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteReunion(@PathVariable Long id){
		Reunion reunion = s.getSemaineById(id);
		
		s.deleteReunion(reunion);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
