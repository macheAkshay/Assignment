package com.index.github.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(value = Include.NON_EMPTY)
public class GitHubProject {

	private int id;
	private String name;
	private String full_name;
	private Owner owner;
	private String description;
	private String projectSource = "Github";
	
	
	public GitHubProject() {
		super();
	}


	public GitHubProject(int id, String name, String full_name, Owner owner, String description,
			String projectSource) {
		super();
		this.id = id;
		this.name = name;
		this.full_name = full_name;
		this.owner = owner;
		this.description = description;
		this.projectSource = projectSource;
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

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
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

	public String getProjectSource() {
		return projectSource;
	}

	public void setProjectSource(String projectSource) {
		this.projectSource = projectSource;
	}

	
	@Override
	public String toString() {
		return "GitHubProject [id=" + id + ", name=" + name + ", full_name=" + full_name + ", owner=" + owner
				+ ", description=" + description + ", projectSource=" + projectSource + "]";
	}
}