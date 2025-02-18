package com.encadrement.Feign;
import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.utilisateur.model.Utilisateur;

@FeignClient(value = "gestion-utilisateur1", url = "http://localhost:8081/utilisateur/users")
public interface EncadrementContacts {
	@GetMapping("/")
	Collection<Utilisateur> list();

	@GetMapping("/{id}")
	Utilisateur getUser(@PathVariable("id") Long id);

	

}
