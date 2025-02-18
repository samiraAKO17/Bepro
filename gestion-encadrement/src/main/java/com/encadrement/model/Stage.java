package com.encadrement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Stage {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long sujet_id;
	private Long apprenant_id;
	private Long encadrant_id;
	private String presentation;
	private String rapport;
	private String etat;
	@Transient
	private String apprenant;
	@Transient
	private String encadrant;
	@Transient
	private String sujet;
	public Stage() {
		
	}
	
	public Stage(Long sujet_id, Long apprenant_id) {
		super();
		this.sujet_id = sujet_id;
		this.apprenant_id = apprenant_id;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSujet_id() {
		return sujet_id;
	}
	public void setSujet_id(Long sujet_id) {
		this.sujet_id = sujet_id;
	}
	public Long getApprenant_id() {
		return apprenant_id;
	}
	public void setApprenant_id(Long apprenant_id) {
		this.apprenant_id = apprenant_id;
	}
	public Long getEncadrant_id() {
		return encadrant_id;
	}
	public void setEncadrant_id(Long encadrant_id) {
		this.encadrant_id = encadrant_id;
	}
	public String getPresentation() {
		return presentation;
	}
	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getRapport() {
		return rapport;
	}
	public void setRapport(String rapport) {
		this.rapport = rapport;
	}

	public String getApprenant() {
		return apprenant;
	}

	public void setApprenant(String apprenant) {
		this.apprenant = apprenant;
	}

	public String getEncadrant() {
		return encadrant;
	}

	public void setEncadrant(String encadrant) {
		this.encadrant = encadrant;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	
	
	
}
