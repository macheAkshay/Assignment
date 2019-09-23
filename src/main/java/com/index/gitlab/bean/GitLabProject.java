package com.index.gitlab.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitLabProject {

	private int id;
	private String name;
	
	private Namespace namespace;
	
	private Owner owner;
	
	private String description;
	private String visibility;

	
	public GitLabProject() {
		super();
	}
	
	public GitLabProject(int id, String name, Namespace namespace, Owner owner, String description, String visibility) {
		super();
		this.id = id;
		this.name = name;
		this.namespace = namespace;
		this.owner = owner;
		this.description = description;
		this.visibility = visibility;
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
	
	public Namespace getNamespace() {
		return namespace;
	}
	
	public void setNamespace(Namespace namespace) {
		this.namespace = namespace;
	}
	
	public Owner getOwner() {
		return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getVisibility() {
		return visibility;
	}
	
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	
	@Override
	public String toString() {
		return "GitLabProject [id=" + id + ", name=" + name + ", namespace=" + namespace + ", owner=" + owner
				+ ", description=" + description + ", visibility=" + visibility + "]";
	}
}