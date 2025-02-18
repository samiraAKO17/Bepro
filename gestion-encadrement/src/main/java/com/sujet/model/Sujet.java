package com.sujet.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.context.annotation.Profile;

import com.utilisateur.model.Utilisateur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
public class Sujet {
	@Id
	@GeneratedValue
	private Long id;
	private String titre;
	private String difficulte;
	private String description;
	private int duree;
	private double prix;
	private String photo;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	private Set<Technologie> technologies ;
	
	private Long ajouterPar;
	@Transient
	private Utilisateur cree;
	
	public Sujet(String titre, String difficulte, String description, int duree, double prix, String photo,
			Set<Technologie> technologies) {
		super();
		this.titre = titre;
		this.difficulte = difficulte;
		this.description = description;
		this.duree = duree;
		this.prix = prix;
		this.photo = photo;
		this.technologies = technologies;
	}
	public Sujet() {
		
	}
	public Long getId() {
		return id;
	}
	public String getTitre() {
		return titre;
	}
	public String getDifficulte() {
		return difficulte;
	}
	public String getDescription() {
		return description;
	}
	public int getDuree() {
		return duree;
	}
	public double getPrix() {
		return prix;
	}
	public String getPhoto() {
		return photo;
	}
	public Set<Technologie> getTechnologies() {
		return technologies;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setDifficulte(String difficulté) {
		this.difficulte = difficulté;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public void setTechnologies(Set<Technologie> technologies) {
		this.technologies = technologies;
	}
	public Long getAjouterPar() {
		return ajouterPar;
	}
	public void setAjouterPar(Long ajouterPar) {
		this.ajouterPar = ajouterPar;
	}
	public Utilisateur getCree() {
		return cree;
	}
	public void setCree(Utilisateur cree) {
		this.cree = cree;
	}
	
	
}
