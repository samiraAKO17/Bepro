package com.utilisateur.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.context.annotation.Profile;

import com.sujet.model.Sujet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance
//@Profile("utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long user_id;
	private String nom;
	private String prenom;
	private String email;
	private String pass;
	private int telephone;
	private String photo;
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles ;
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},fetch = FetchType.LAZY)
	@JoinTable(name="user_sujets",joinColumns = @JoinColumn(name="user_id"),inverseJoinColumns = @JoinColumn(name=" id"))
	private Set<Sujet> sujets;
	public Utilisateur(String nom, String prenom, String email, String pass, int telephone, String photo) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.pass = pass;
		this.telephone = telephone;
		this.photo = photo;
	}
	
	public Utilisateur(String nom) {
		this.nom = nom;
	}
	
	public Utilisateur() {
		
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Sujet> getSujets() {
		return sujets;
	}

	public void setSujets(Set<Sujet> sujets) {
		this.sujets = sujets;
	}
	
	
}
