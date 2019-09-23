package com.index.github.controller;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.index.github.bean.GitHubProject;
import com.index.github.service.impl.GitHubServiceImpl;

@RestController
@RequestMapping(value = "/github")
public class GitHubController {

	private static final Logger LOGGER = Logger.getLogger(GitHubController.class);
	
	@Autowired
	GitHubServiceImpl service;
	
	static {
		
		LOGGER.info("GitHubController Loaded...!");
	}
	
	@GetMapping
	public List<GitHubProject> getAllUsersAndProjects()
	{
		LOGGER.info("getAllUsersAndProjects() invoked...!"); 
		return service.getUsersAndProjects();
	}
	
	@GetMapping("/{user}")
	public List<GitHubProject> getProjectsByUser(@PathVariable("user") String userName)
	{
		LOGGER.info("getProjectsByUser() invoked...!");
		
		return service.getProjectsByUser(userName);
	}
}