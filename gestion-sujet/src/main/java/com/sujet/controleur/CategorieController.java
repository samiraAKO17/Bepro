package com.sujet.controleur;

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

import com.sujet.Feign.Contacts;
import com.sujet.model.Categorie;
import com.sujet.model.Technologie;
import com.sujet.service.CategorieService;
import com.sujet.service.TechnoService;
import com.utilisateur.model.Utilisateur;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("gestSujet/categories")
public class CategorieController {
	@Autowired
	private CategorieService s;
	@Autowired
	Contacts cc;
	@Autowired
	private TechnoService ts;
	@GetMapping("/")
	public List<Categorie> getAllcats(){
		
		return s.all();
	}			
	
	
	@PostMapping("/")
	public Categorie createcat(@RequestBody Categorie cat) {
		System.out.print(cat.toString());
		 s.addCat(cat);
		 return cat;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorie> getcatById(@PathVariable Long id) {
		Categorie cat = s.getCatById(id);
		return ResponseEntity.ok(cat);
	}
	@GetMapping("/{id1}/{id}")
	public ResponseEntity<Categorie> addTech(@PathVariable Long id,@PathVariable Long id1) {
		Categorie cat = s.getCatById(id);
		Technologie tech = ts.getTechById(id1);
		Set<Technologie> technos = new HashSet<Technologie>();
		technos=cat.getTechnologies();
		technos.add(tech);
		cat.setTechnologies(cat.getTechnologies());
		s.updateCat(cat);
		Categorie cat1 = s.getCatById(id);

		return ResponseEntity.ok(cat1);
	}
	@DeleteMapping("/{id1}/{id}")
	public ResponseEntity<Categorie> supprimerTech(@PathVariable Long id,@PathVariable Long id1) {
		Categorie cat = s.getCatById(id);
		Technologie tech = ts.getTechById(id1);
		Set<Technologie> technos = new HashSet<Technologie>();
		technos=cat.getTechnologies();
		technos.remove(tech);
		cat.setTechnologies(cat.getTechnologies());
		s.updateCat(cat);
		Categorie cat1 = s.getCatById(id);

		return ResponseEntity.ok(cat1);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categorie> updatecat(@PathVariable Long id, @RequestBody Categorie catDetails){
		Categorie cat = s.getCatById(id);
		
		cat.setNom(catDetails.getNom());
		
		
		s.updateCat(cat);
		return ResponseEntity.ok(cat);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteCat(@PathVariable Long id){
		Categorie cat = s.getCatById(id);
		
		s.deleteCat(cat);
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
