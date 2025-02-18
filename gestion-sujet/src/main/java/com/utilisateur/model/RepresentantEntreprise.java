package com.utilisateur.model;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class RepresentantEntreprise extends Utilisateur{
	
    private String nomEntreprise;
    private String identUnique;
    private String adresse;
    private String site;
    private String secteur;
    private String description;
    
	public RepresentantEntreprise(String nom, String prenom, String email, String pass, int telephone, String photo,
			String nomEntreprise) {
		super(nom, prenom, email, pass, telephone, photo);
		this.nomEntreprise = nomEntreprise;
	}

	public RepresentantEntreprise(String nom, String prenom, String email, String pass, int telephone, String photo) {
		super(nom, prenom, email, pass, telephone, photo);
		// TODO Auto-generated constructor stub
	}

	public RepresentantEntreprise(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}
	public RepresentantEntreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNomEntreprise() {
		return nomEntreprise;
	}

	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}

	@Override
	public Long getUser_id() {
		// TODO Auto-generated method stub
		return super.getUser_id();
	}

	@Override
	public void setUser_id(Long user_id) {
		// TODO Auto-generated method stub
		super.setUser_id(user_id);
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return super.getNom();
	}

	@Override
	public void setNom(String nom) {
		// TODO Auto-generated method stub
		super.setNom(nom);
	}

	@Override
	public String getPrenom() {
		// TODO Auto-generated method stub
		return super.getPrenom();
	}

	@Override
	public void setPrenom(String prenom) {
		// TODO Auto-generated method stub
		super.setPrenom(prenom);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getPass() {
		// TODO Auto-generated method stub
		return super.getPass();
	}

	@Override
	public void setPass(String pass) {
		// TODO Auto-generated method stub
		super.setPass(pass);
	}

	@Override
	public int getTelephone() {
		// TODO Auto-generated method stub
		return super.getTelephone();
	}

	@Override
	public void setTelephone(int telephone) {
		// TODO Auto-generated method stub
		super.setTelephone(telephone);
	}

	@Override
	public String getPhoto() {
		// TODO Auto-generated method stub
		return super.getPhoto();
	}

	@Override
	public void setPhoto(String photo) {
		// TODO Auto-generated method stub
		super.setPhoto(photo);
	}

	@Override
	public Set<Role> getRoles() {
		// TODO Auto-generated method stub
		return super.getRoles();
	}

	@Override
	public void setRoles(Set<Role> roles) {
		// TODO Auto-generated method stub
		super.setRoles(roles);
	}

	public String getIdentUnique() {
		return identUnique;
	}

	public void setIdentUnique(String identUnique) {
		this.identUnique = identUnique;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
