package com.utilisateur.model;

import java.util.Set;

import javax.persistence.Entity;

@Entity
public class Professionnel extends Utilisateur{
	
	private String societe;
	private String poste;
	private String cv;
	private String portfolio;
	
	
	public Professionnel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Professionnel(String nom, String prenom, String email, String pass, int telephone, String photo) {
		super(nom, prenom, email, pass, telephone, photo);
		// TODO Auto-generated constructor stub
	}

	public Professionnel(String nom) {
		super(nom);
		// TODO Auto-generated constructor stub
	}

	
	
	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
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
    
    
}
