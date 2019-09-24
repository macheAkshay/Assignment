package com.index.git.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.index.git.api.dao.impl.GitLabDaoImpl;
import com.index.git.api.service.GitLabService;
import com.index.gitlab.api.bean.GitLabProject;

@Service
public class GitLabServiceImpl implements GitLabService{

	@Autowired
	GitLabDaoImpl dao;
	
	static {
		
	}
	
	public ResponseEntity<List<GitLabProject>> getUsersAndProjects() {
		return dao.consumeAllProjects();
	}

	public ResponseEntity<List<GitLabProject>> getProjectsByUser(String id) {
		return dao.consumeProjectsByUser(id);
	}
}