package com.index.gitlab.api.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_EMPTY)
public class Namespace {

	private int id;
	private String name;
	private String path;
	private String kind;
	private String web_url;

	
	public Namespace() {
		super();
	}
	
	public Namespace(int id, String name, String path, String kind, String web_url) {
		super();
		this.id = id;
		this.name = name;
		this.path = path;
		this.kind = kind;
		this.web_url = web_url;
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
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getKind() {
		return kind;
	}
	
	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public String getWeb_url() {
		return web_url;
	}
	
	public void setWeb_url(String web_url) {
		this.web_url = web_url;
	}

	
	@Override
	public String toString() {
		return "Namespace [id=" + id + ", name=" + name + ", path=" + path + ", kind=" + kind + ", web_url=" + web_url
				+ "]";
	}
}