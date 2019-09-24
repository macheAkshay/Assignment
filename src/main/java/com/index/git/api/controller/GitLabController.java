package com.index.git.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.index.git.api.exception.InvalidUser;
import com.index.git.api.exception.NoProjectsAvailable;
import com.index.git.api.service.impl.GitLabServiceImpl;
import com.index.gitlab.api.bean.GitLabProject;

@RestController
@RequestMapping(value = "/api/gitlab")
public class GitLabController {

	@Autowired
	GitLabServiceImpl service;
	
	static {
		
	}
	
	@GetMapping
	public List<GitLabProject> getAllUsersAndProjects()
	{
		ResponseEntity<List<GitLabProject>> response = service.getUsersAndProjects();
		
		return response.getBody();
	}
	
	@GetMapping("/{user_id}")
	public List<GitLabProject> getProjectById(@PathVariable("user_id") String id)
	{
		ResponseEntity<List<GitLabProject>> response = service.getProjectsByUser(id);
		
		if(response.getStatusCode().equals(HttpStatus.NOT_FOUND))
			throw new InvalidUser("Invalid user :"+id);
		
		if(response != null && response.getBody().isEmpty())
			throw new NoProjectsAvailable("No Projects Available for user :"+id);
	
		return response.getBody();
	}
}