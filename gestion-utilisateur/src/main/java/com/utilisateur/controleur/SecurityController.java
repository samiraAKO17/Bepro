package com.utilisateur.controleur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utilisateur.model.Role;
import com.utilisateur.model.Utilisateur;
import com.utilisateur.service.UserService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("utilisateur/Security")
public class SecurityController {
	@Autowired
	private UserService s;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@GetMapping("/{email}")
	public Utilisateur login(HttpServletRequest servlet,@PathVariable String email) {
		HttpSession session = servlet.getSession();
		SecurityContext context =(SecurityContext) session.getAttribute("SPRING_SECURITY_CONTEXT");
		String userName = context.getAuthentication().getName();
		//CustomUserDetails details = (CustomUserDetails) context.getAuthentication().getDetails();
		Utilisateur u = new Utilisateur();
		u= s.getUserByEmail(email);
		Set<Role> roles = new HashSet<Role>(); 
		for(GrantedAuthority g : context.getAuthentication().getAuthorities())
		{ 
			Role r = new Role();
			r.setNomRole(g.getAuthority());
			roles.add(r);
		}
		System.out.print(u.toString());
		Utilisateur user =new Utilisateur();
		user.setUser_id(u.getUser_id());
		user.setEmail(userName);
		user.setRoles( u.getRoles());
		user.setNom(u.getNom());
		user.setPrenom(u.getPrenom());
		user.setEmail(u.getEmail());
		return user;
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
