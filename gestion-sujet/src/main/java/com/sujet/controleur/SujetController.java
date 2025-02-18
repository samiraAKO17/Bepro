package com.sujet.controleur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import com.sujet.Feign.Contacts;
import com.sujet.model.Categorie;
import com.sujet.model.NotifSujet;
import com.sujet.model.Sujet;
import com.sujet.model.Technologie;
import com.sujet.service.NotifSujetService;
import com.sujet.service.SujetService;
import com.sujet.service.TechnoService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("gestSujet/sujets")
public class SujetController {

	@Autowired
	private SujetService s;
	
	@Autowired
	private TechnoService ts;
	
	@Autowired
	private NotifSujetService ns;
	
	@Autowired
	private Contacts c;
	@GetMapping("/")
	public List<Sujet> getAllUsers(){
		List<Sujet> sujets = s.all();
		List<Sujet> sujetss =new ArrayList<Sujet>();
		for(int i =0;i<sujets.size();i++) {
			Sujet sujet=sujets.get(i);
			sujet.setCree(c.getUser(sujet.getAjouterPar()));
			sujetss.add(sujet);
		}
		return sujetss;
	}			
	
	
	@PostMapping("/")
	public Sujet createSujet(@RequestBody Sujet sujet) {
		System.out.print(sujet.toString());
		Sujet sujet1 =s.addSujet(sujet);
		String cree = c.getUser(sujet1.getAjouterPar()).getPrenom()+" "+c.getUser(sujet1.getAjouterPar()).getNom();
		NotifSujet notification  = new NotifSujet("le sujet "+ sujet1.toString()); 
		 ns.addNotifDemandes(notification);
		return sujet1;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Sujet> getSujetById(@PathVariable Long id) {
		Sujet user = s.getSujetById(id);
		return ResponseEntity.ok(user);
	}
	
	@GetMapping("/{id1}/{id}")
	public ResponseEntity<Sujet> addTech(@PathVariable Long id,@PathVariable Long id1) {
		Sujet sujet = s.getSujetById(id);
		Technologie tech = ts.getTechById(id1);
		Set<Technologie> technos = new HashSet<Technologie>();
		technos=sujet.getTechnologies();
		technos.add(tech);
		sujet.setTechnologies(technos);
		s.updateSujet(sujet);
		Sujet cat1 = s.getSujetById(id);

		return ResponseEntity.ok(cat1);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Sujet> updateSujet(@PathVariable Long id, @RequestBody Sujet sujetDetails){
		Sujet sujet = s.getSujetById(id);
		
		sujet.setTechnologies(sujetDetails.getTechnologies());
		sujet.setDescription(sujetDetails.getDescription());
		sujet.setDifficulte(sujetDetails.getDifficulte());

		sujet.setDuree(sujetDetails.getDuree());
		sujet.setPhoto(sujetDetails.getPhoto());
		sujet.setPrix(sujetDetails.getPrix());
		sujet.setTitre(sujetDetails.getTitre());
		
		s.updateSujet(sujet);
		return ResponseEntity.ok(sujet);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteSujetr(@PathVariable Long id){
		Sujet sujet = s.getSujetById(id);
		
		s.deleteSujet(sujet);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
