package com.utilisateur;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.utilisateur.model.Apprenant;
import com.utilisateur.model.Utilisateur;
import com.utilisateur.service.ApprenantService;
import com.utilisateur.service.UserService;
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
public class GestionUtilisateurApplication  implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private ApprenantService s;
	
	@Autowired
	private UserService users;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionUtilisateurApplication.class, args);
		
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//mod();
		list();
		
	}
	
	private void list() {
		// TODO Auto-generated method stub
		ArrayList<Utilisateur> utils = new ArrayList<Utilisateur>();
		utils = (ArrayList<Utilisateur>) users.utilisateurs();
		
		for(int i=0; i< utils.size();i++) {
			System.out.print(utils.get(i).toString());
		}
	}

	public void mod() {
		Apprenant a = new Apprenant();
		a.setEmail("sign-up");
		a.setPass("sign-up");;
		a.setPass(passwordEncoder.encode(a.getPass()));
		System.out.println(a.getPass());
		s.updateApprenant(a);
	}

}
