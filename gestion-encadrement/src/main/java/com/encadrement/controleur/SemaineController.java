package com.encadrement.controleur;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encadrement.model.Semaine;
import com.encadrement.model.Stage;
import com.encadrement.model.Tache;
import com.encadrement.service.SemaineService;
import com.encadrement.service.TacheService;
import com.sujet.model.Categorie;
import com.sujet.model.Sujet;
import com.sujet.model.Technologie;
import com.utilisateur.model.Utilisateur;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("gestStages/semaine")
public class SemaineController {
	
	@Autowired
	SemaineService s;
	
	@Autowired
	TacheService ts;
		
	@PostMapping("/list/")
	public List<Semaine> getSemainesByStage(@RequestBody Stage stage) {
		List<Semaine> list =s.SemainesByStage(stage);
     Collections.sort(list, new SortbyNum());

		return list;
	}	
	
	@PostMapping("/")
	public Semaine createSemaine(@RequestBody Semaine semaine) {
		System.out.print(semaine.toString());
		 s.addSemaine(semaine);
		 
		 return semaine;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Semaine> getSemaineById(@PathVariable Long id) {
		
		return ResponseEntity.ok(s.getSemaineById(id));
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Semaine> updateSemaine(@PathVariable Long id, @RequestBody Semaine semaineDetails){
		Semaine semaine = s.getSemaineById(id);
		
		semaine.setReunion(semaineDetails.getReunion());
		
		semaine.setTaches(semaineDetails.getTaches());
		semaine.setTravail(semaineDetails.getTravail());

		s.updateSemaine(semaine);
		return ResponseEntity.ok(semaine);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStage(@PathVariable Long id){
		Semaine semaine = s.getSemaineById(id);
		
		s.deleteSemaine(semaine);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	
	@GetMapping("/{id1}/{id}")
	public ResponseEntity<Semaine> addTache(@PathVariable Long id,@PathVariable Long id1) {
		Semaine ss = s.getSemaineById(id);
		Tache t = ts.getTacheById(id1);
		Set<Tache> taches = new HashSet<Tache>();
		taches=ss.getTaches();
		taches.add(t);
		ss.setTaches(ss.getTaches());
		s.updateSemaine(ss);
		Semaine cat1 = s.getSemaineById(id);

		return ResponseEntity.ok(cat1);
	}
	@DeleteMapping("/{id1}/{id}")
	public ResponseEntity<Semaine> deleteTache(@PathVariable Long id,@PathVariable Long id1) {
		Semaine ss = s.getSemaineById(id);
		Tache t = ts.getTacheById(id1);
		Set<Tache> taches = new HashSet<Tache>();
		taches=ss.getTaches();
		taches.remove(t);
		ss.setTaches(ss.getTaches());
		s.updateSemaine(ss);
		Semaine cat1 = s.getSemaineById(id);

		return ResponseEntity.ok(cat1);
	}
	class SortbyNum implements Comparator<Semaine>
	{
	    

		@Override
		public int compare(Semaine o1, Semaine o2) {
			// TODO Auto-generated method stub
			return o1.getNum() - o2.getNum();
		}
	}
}
