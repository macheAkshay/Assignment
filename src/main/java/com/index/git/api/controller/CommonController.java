package com.index.git.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.index.git.api.exception.ResourceNotFound;
import com.index.git.api.service.GitHubService;
import com.index.git.api.service.GitLabService;
import com.index.github.api.bean.GitHubProject;
import com.index.gitlab.api.bean.GitLabProject;

@RestController
//@RequestMapping(value = "/api")
public class CommonController {

	private static Logger LOGGER = Logger.getLogger(CommonController.class);
	
	@Autowired
	GitHubService gitHubService;
	
	@Autowired
	GitLabService gitLabService;
	
	
	static {
		
		LOGGER.info("Common Controller Loaded...!");
	}
	
	@RequestMapping()
	public void m1()
	{
		LOGGER.error("No mapping found for this Url");
		throw new ResourceNotFound("No Maaping for this url");
	}
	
	
	@GetMapping("/api")
	public List<Object> getAllProjects()
	{
		ResponseEntity<List<GitHubProject>> gitHubResponse = gitHubService.getUsersAndProjects();
		ResponseEntity<List<GitLabProject>> gitLabResponse = gitLabService.getUsersAndProjects();
		
		List<Object> list = new ArrayList<Object>(gitHubResponse.getBody());
					 list.addAll(gitLabResponse.getBody());
					 
		return list;
	}
}