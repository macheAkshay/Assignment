package com.index.git.api.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.index.git.api.exception.InvalidUser;
import com.index.git.api.exception.NoProjectsAvailable;
import com.index.git.api.exception.ResourceNotFound;
import com.index.git.api.service.impl.GitHubServiceImpl;
import com.index.github.api.bean.GitHubProject;

@RestController
//@RequestMapping(value = "")
public class GitHubController {

	private static final Logger LOGGER = Logger.getLogger(GitHubController.class);
	
	@Autowired
	GitHubServiceImpl service;
	
	static {
		
		LOGGER.info("GitHubController Loaded...!");
	}
	
	@RequestMapping("api/")
	public void m1()
	{
		LOGGER.error("No mapping found for this Url");
		throw new ResourceNotFound("No Maaping for this url");
	}
	
	
	@GetMapping("/api/github")
	public List<GitHubProject> getAllUsersAndProjects()
	{
		LOGGER.info("GitHub - getAllUsersAndProjects() invoked...!");
		
		ResponseEntity<List<GitHubProject>> response = service.getUsersAndProjects();
		
		return response.getBody();
	}
	
	@GetMapping("/api/github/{user}")
	public List<GitHubProject> getProjectsByUser(@PathVariable("user") String userName)
	{
		LOGGER.info("GitHub - getProjectsByUser() invoked...!");
		
		ResponseEntity<List<GitHubProject>> response = service.getProjectsByUser(userName); 
		
		System.out.println(response.getBody().isEmpty());
		
		if(response.getStatusCode().equals(HttpStatus.NOT_FOUND))
			throw new InvalidUser("Invalid user :"+userName);
		
		if(response != null && response.getBody().isEmpty())
		{
			throw new NoProjectsAvailable("No Projects Available for user :"+userName);
		}
		
		return response.getBody(); 
	}
}