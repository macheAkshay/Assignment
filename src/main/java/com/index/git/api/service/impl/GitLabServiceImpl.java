package com.index.git.api.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.index.git.api.dao.impl.GitLabDaoImpl;
import com.index.git.api.service.GitLabService;
import com.index.gitlab.api.bean.GitLabProject;

@Service
public class GitLabServiceImpl implements GitLabService{

	private static final Logger LOGGER = Logger.getLogger(GitLabServiceImpl.class);
	
	@Autowired
	GitLabDaoImpl dao;
	
	static {
		
		LOGGER.info("GitLabService Loaded...!");
	}
	
	
	public ResponseEntity<List<GitLabProject>> getUsersAndProjects() {
		return dao.consumeAllProjects();
	}

	public ResponseEntity<List<GitLabProject>> getProjectsByUser(String id) {
		return dao.consumeProjectsByUser(id);
	}
}