package com.sujet.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Technologie {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	@Transient
	@ManyToOne
	private Categorie categorie;
	public Technologie(String nom) {
		super();
		this.nom = nom;
	}
	
	public Technologie() {
		
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
}
