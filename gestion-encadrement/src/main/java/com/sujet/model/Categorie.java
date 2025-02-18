package com.sujet.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categorie {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private Set<Technologie> Technologies;
	
	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	
	public Categorie() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<Technologie> getTechnologies() {
		return Technologies;
	}

	public void setTechnologies(Set<Technologie> technologies) {
		Technologies = technologies;
	}
	
}
