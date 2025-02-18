package com.encadrement.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Semaine {
	@Id
	@GeneratedValue
	private Long id;
	private int num;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="semaine_tache",joinColumns = @JoinColumn(name="id"),inverseJoinColumns = @JoinColumn(name="tache_id"))
	private Set<Tache> Taches;
	private String travail;
	@ManyToOne
	private Stage stage;
	@OneToOne
	private Reunion reunion;
	public Semaine(int num, Set<Tache> taches, Stage stage) {
		super();
		this.num = num;
		Taches = taches;
		this.stage = stage;
	}
	public Semaine() {
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Set<Tache> getTaches() {
		return Taches;
	}
	public void setTaches(Set<Tache> taches) {
		Taches = taches;
	}
	public String getTravail() {
		return travail;
	}
	public void setTravail(String travail) {
		this.travail = travail;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	public Reunion getReunion() {
		return reunion;
	}
	public void setReunion(Reunion reunion) {
		this.reunion = reunion;
	}
	
	
	
	
}
