package com.index.github.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.index.github.service.impl.GitHubServiceImpl;
import com.index.gitlab.bean.GitLabProject;

@RestController
@RequestMapping(value = "/gitlab")
public class GitLabController {

	private static final Logger LOGGER = Logger.getLogger(GitLabController.class);
	
	@Autowired
	GitHubServiceImpl service;
	
	static {
		
		LOGGER.info("GitLabController Loaded...!");
	}
	
	@GetMapping
	public List<GitLabProject> getAllUsersAndProjects()
	{
		LOGGER.info("getAllUsersAndProjects() invoked...!"); 
		return service.getGitLabUsersAndProjects();
	}
}