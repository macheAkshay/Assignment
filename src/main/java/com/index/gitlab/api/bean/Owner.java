package com.index.gitlab.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Owner {

	private int id;
	private String name;
	private String username;

	
	public Owner() {
		super();
	}
	
	public Owner(int id, String name, String username) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	
	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", username=" + username + "]";
	}
}