package com.encadrement.controleur;

import java.util.ArrayList;
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

import com.encadrement.Feign.EncadrementContacts;
import com.encadrement.Feign.Sujets;
import com.encadrement.model.NotifStage;
import com.encadrement.model.Stage;
import com.encadrement.service.NotifStageService;
import com.encadrement.service.StageService;
import com.sujet.model.Sujet;
import com.utilisateur.model.Utilisateur;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("gestStages/stage")
public class StageController {
	@Autowired
	private StageService s;
	
	@Autowired
	Sujets feignSujet;
	
	@Autowired
	EncadrementContacts feignUtilisateur;
	
	@Autowired
	private NotifStageService ns;
	
	@GetMapping("/demandes/")
	public List<Stage> getDemandesStages(){
		ArrayList<Stage> stg = new ArrayList<Stage>();
		stg = (ArrayList<Stage>) s.all();
		ArrayList<Stage> stages = new ArrayList<Stage>();
		
		for(int i=0; i< stg.size();i++) {
			Stage stage =stg.get(i);
			if(stage.getEncadrant_id()==null) {
			Sujet sujet = feignSujet.getSujet(stage.getSujet_id());
			Utilisateur app = feignUtilisateur.getUser(stage.getApprenant_id());
			stage.setApprenant(app.getNom()+" "+app.getPrenom());
			stage.setSujet(sujet.getTitre());
			stages.add(stage);
			}
		} 
		return stages;
	}			
	
	@GetMapping("/")
	public List<Stage> getAllStages(){
		ArrayList<Stage> stg = new ArrayList<Stage>();
		stg = (ArrayList<Stage>) s.all();
		ArrayList<Stage> stages = new ArrayList<Stage>();
		
		for(int i=0; i< stg.size();i++) {
			Stage stage =stg.get(i);
			if(stage.getEncadrant_id()!=null) {
			Sujet sujet = feignSujet.getSujet(stage.getSujet_id());
			Utilisateur app = feignUtilisateur.getUser(stage.getApprenant_id());
			Utilisateur prof = feignUtilisateur.getUser(stage.getEncadrant_id());
			stage.setApprenant(app.getNom()+" "+app.getPrenom());
			stage.setEncadrant(prof.getNom()+" "+prof.getPrenom());
			stage.setSujet(sujet.getTitre());
			stages.add(stage);
			}
		} 
		return stages;
	}			
	
	@PostMapping("/")
	public Stage createStage(@RequestBody Stage stage) {
		System.out.print(stage.toString());
		stage.setEtat("En attente");
		 s.addStage(stage);
			NotifStage notification  = new NotifStage("nouveau stage "+ stage.toString()); 
			 ns.addNotifDemandes(notification);
			
		 return stage;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Stage> getStageById(@PathVariable Long id) {
		Stage stage = s.getStageById(id);
		Utilisateur app = feignUtilisateur.getUser(stage.getApprenant_id());
		stage.setApprenant(app.getNom()+" "+app.getPrenom());
		Sujet sujet = feignSujet.getSujet(stage.getSujet_id());
		stage.setSujet(sujet.getTitre());

		return ResponseEntity.ok(stage);
	}
	@GetMapping("/encadrements/{id}")
	public ResponseEntity<List<Stage>> getEncadrements(@PathVariable Long id) {
		ArrayList<Stage> stg = new ArrayList<Stage>();
		stg = (ArrayList<Stage>) s.encadrements(id);
		ArrayList<Stage> stages = new ArrayList<Stage>();
		
		for(int i=0; i< stg.size();i++) {
			Stage stage =stg.get(i);
			if(stage.getEncadrant_id()!=null) {
			Sujet sujet = feignSujet.getSujet(stage.getSujet_id());
			Utilisateur app = feignUtilisateur.getUser(stage.getApprenant_id());
			Utilisateur prof = feignUtilisateur.getUser(stage.getEncadrant_id());
			stage.setApprenant(app.getNom()+" "+app.getPrenom());
			stage.setEncadrant(prof.getNom()+" "+prof.getPrenom());
			stage.setSujet(sujet.getTitre());
			stages.add(stage);
			}
		} 
		return ResponseEntity.ok(stages);
	}@GetMapping("/stagiaire/{id}")
	public ResponseEntity<List<Stage>> getStagiaire(@PathVariable Long id) {
		ArrayList<Stage> stg = new ArrayList<Stage>();
		stg = (ArrayList<Stage>) s.stagesApprenant(id);
		ArrayList<Stage> stages = new ArrayList<Stage>();
		
		for(int i=0; i< stg.size();i++) {
			Stage stage =stg.get(i);
			if(stage.getEncadrant_id()!=null) {
			Sujet sujet = feignSujet.getSujet(stage.getSujet_id());
			Utilisateur app = feignUtilisateur.getUser(stage.getApprenant_id());
			Utilisateur prof = feignUtilisateur.getUser(stage.getEncadrant_id());
			stage.setApprenant(app.getNom()+" "+app.getPrenom());
			stage.setEncadrant(prof.getNom()+" "+prof.getPrenom());
			stage.setSujet(sujet.getTitre());
			stages.add(stage);
			}
		} 
		return ResponseEntity.ok(stages);
	}@GetMapping("/sujets/{id}")
	public ResponseEntity<List<Stage>> getStages(@PathVariable Long id) {
		List<Stage> stages = s.sujets(id);
		return ResponseEntity.ok(stages);
	}
	/*@GetMapping("/{id1}/{id}")
	public ResponseEntity<Stage> addTech(@PathVariable Long id,@PathVariable Long id1) {
		Stage Stage = s.getStageById(id);
		Technologie tech = ts.getTechById(id1);
		Set<Technologie> technos = new HashSet<Technologie>();
		technos=Stage.getTechnologies();
		technos.add(tech);
		Stage.setTechnologies(Stage.getTechnologies());
		s.updateStage(Stage);
		Stage Stage1 = s.getStageById(id);

		return ResponseEntity.ok(Stage1);
	}*/
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Stage> updateStage(@PathVariable Long id, @RequestBody Stage stageDetails){
		Stage stage = s.getStageById(id);
		
		stage.setEncadrant_id(stageDetails.getEncadrant_id());
		stage.setRapport(stageDetails.getRapport());
		stage.setPresentation(stageDetails.getPresentation());
		s.updateStage(stage);
		return ResponseEntity.ok(stage);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteStage(@PathVariable Long id){
		Stage Stage = s.getStageById(id);
		
		s.deleteStage(Stage);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@RequestMapping(value = "/logged")
	public Map<String,Object> getUserLogged(HttpServletRequest servlet){
		HttpSession session = servlet.getSession();
		SecurityContext context =(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String userName = context.getAuthentication().getName();
		List<String> roles = new ArrayList<>(); 
		for(GrantedAuthority g : context.getAuthentication().getAuthorities())
		{
			roles.add(g.getAuthority());
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userName", userName);
		params.put("roles", roles);
		return params;
	}

}
