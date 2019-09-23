package com.index.github.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.index.github.bean.GitHubProject;
import com.index.github.dao.impl.GithubDaoImpl;
import com.index.github.service.GitHubService;
import com.index.gitlab.bean.GitLabProject;

@Service
public class GitHubServiceImpl implements GitHubService{

	@Autowired
	GithubDaoImpl dao;
	
	private static final Logger LOGGER = Logger.getLogger(GitHubServiceImpl.class);
	
	static {
		
		LOGGER.info("GitHubServiceImpl Loaded...!");
	}

	public List<GitLabProject> getGitLabUsersAndProjects() {
		
		LOGGER.info("getUsersAndProjects() invoked...!");
		return dao.consumeAllGitLabProjects();
	}

	
	public List<GitHubProject> getUsersAndProjects() {
		
		LOGGER.info("getUsersAndProjects() invoked...!");
		return dao.consumeAllProjects();
	}


	public List<GitHubProject> getProjectsByUser(String userName) {
		
		LOGGER.info("getProjectsByUser() invoked...!");
		
		return dao.consumeProjectsByUser(userName);
	}
}
