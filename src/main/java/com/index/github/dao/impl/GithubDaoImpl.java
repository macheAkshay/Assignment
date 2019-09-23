package com.index.github.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.index.github.bean.GitHubProject;
import com.index.github.dao.GitDao;
import com.index.gitlab.bean.GitLabProject;
import com.index.rest.urls.AppConstants;

@Repository
public class GithubDaoImpl implements GitDao{

	private static final Logger LOGGER = Logger.getLogger(GithubDaoImpl.class);
	
	static {
		
		LOGGER.info("GithubDaoImpl Loaded...!");
	}

	public List<GitLabProject> consumeAllGitLabProjects() {

		LOGGER.info("consumeAllProjects() execution starts...!");
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<GitLabProject>> response = 
				restTemplate.exchange(AppConstants.GITLAB_ALL_REPOS, 
						HttpMethod.GET, 
						null, 
						new ParameterizedTypeReference<List<GitLabProject>>() {}
				);

		LOGGER.info("consumeAllProjects() execution end...!");
		return response.getBody();
	}
	
	public List<GitHubProject> consumeAllProjects() {

		LOGGER.info("consumeAllProjects() execution starts...!");
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<GitHubProject>> response = 
				restTemplate.exchange(AppConstants.GITHUB_ALL_REPOS, 
						HttpMethod.GET, 
						null, 
						new ParameterizedTypeReference<List<GitHubProject>>() {}
				);

		LOGGER.info("consumeAllProjects() execution end...!");
		return response.getBody();
	}

	public List<GitHubProject> consumeProjectsByUser(String userName) {

		LOGGER.info("consumeProjectsByUser() execution starts...!");

		final String URL = AppConstants.GITHUB_REPOS_BY_USER.replace("user_name", userName);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<GitHubProject>> response = 
				restTemplate.exchange(URL, 
						HttpMethod.GET, 
						null, 
						new ParameterizedTypeReference<List<GitHubProject>>() {}
				);

		LOGGER.info("consumeProjectsByUser() execution end...!");
		
		return response.getBody();
	}
}