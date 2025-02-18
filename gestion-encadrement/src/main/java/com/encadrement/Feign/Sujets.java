package com.encadrement.Feign;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sujet.model.Sujet;

@Qualifier("sujets")
@FeignClient(value = "gestion-sujet", url = "http://localhost:8082/gestSujet/sujets")
public interface Sujets {

	
	@GetMapping("/{id}")
	Sujet getSujet(@PathVariable("id") Long id);

	

}
