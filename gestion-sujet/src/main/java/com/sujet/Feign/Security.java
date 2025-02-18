package com.sujet.Feign;

	import org.springframework.cloud.openfeign.FeignClient;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;

	import com.utilisateur.model.Utilisateur;

	@FeignClient(value = "gestion-utilisateur-sec", url = "http://localhost:8081/utilisateur/users/login")
	public interface Security {
		
		@GetMapping("/{email}")
		Utilisateur getUserByLogin(@PathVariable("email") String email);

	}
