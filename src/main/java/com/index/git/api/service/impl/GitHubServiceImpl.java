package com.index.git.api.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.index.git.api.dao.impl.GitHubDaoImpl;
import com.index.git.api.service.GitHubService;
import com.index.github.api.bean.GitHubProject;

@Service
public class GitHubServiceImpl implements GitHubService{

	@Autowired
	GitHubDaoImpl dao;
	
	private static final Logger LOGGER = Logger.getLogger(GitHubServiceImpl.class);
	
	static {
		
		LOGGER.info("GitHubServiceImpl Loaded...!");
	}
	
	public ResponseEntity<List<GitHubProject>> getUsersAndProjects() {
		
		LOGGER.info("GitHub - getUsersAndProjects() invoked...!");
		return dao.consumeAllProjects();
	}


	public ResponseEntity<List<GitHubProject>> getProjectsByUser(String userName) {
		
		LOGGER.info("GitHub - getProjectsByUser() invoked...!");
		return dao.consumeProjectsByUser(userName);
	}
}