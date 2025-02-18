package com.encadrement.Feign;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.utilisateur.model.Utilisateur;

@Qualifier("encadrementSecurity")
@FeignClient(value = "gestion-utilisateur-sec1", url = "http://localhost:8081/utilisateur/users/login")
public interface EncadrementSecurity {
	
		@GetMapping("/{email}")
		Utilisateur getUserByLogin(@PathVariable("email") String email);

}
