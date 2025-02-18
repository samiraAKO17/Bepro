package com.encadrement.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class StringResult {

	private Long id;
	private String name;
	
	public StringResult() {
		
	}
	
	public StringResult(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
