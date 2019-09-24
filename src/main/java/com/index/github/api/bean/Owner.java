package com.index.github.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Owner {
	
	private String login;
	private int id;
	private String repos_url;
	private String type;

	
	public Owner() {
		super();
	}
	
	public Owner(String login, int id, String name, String username, String repos_url, String type) {
		super();
		this.login = login;
		this.id = id;
		this.repos_url = repos_url;
		this.type = type;
	}
	
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRepos_url() {
		return repos_url;
	}
	
	public void setRepos_url(String repos_url) {
		this.repos_url = repos_url;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	
	@Override
	public String toString() {
		return "Owner [login=" + login + ", id=" + id + ", repos_url=" + repos_url + ", type=" + type + "]";
	}
}