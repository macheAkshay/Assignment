package com.index.git.api.service.impl;

import java.util.List;

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
	
	static {
		
	}
	
	public ResponseEntity<List<GitHubProject>> getUsersAndProjects() {
		
		return dao.consumeAllProjects();
	}


	public ResponseEntity<List<GitHubProject>> getProjectsByUser(String userName) {
		
		return dao.consumeProjectsByUser(userName);
	}
}