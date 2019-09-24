package com.index.git.api.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.index.git.api.dao.GitHubDao;
import com.index.git.api.urls.AppConstants;
import com.index.github.api.bean.GitHubProject;

@Repository
public class GitHubDaoImpl implements GitHubDao{

	private static final Logger LOGGER = Logger.getLogger(GitHubDaoImpl.class);
	
	static {
		
		LOGGER.info("GithubDaoImpl Loaded...!");
	}

	public ResponseEntity<List<GitHubProject>> consumeAllProjects() {

		LOGGER.info("GitHub - consumeAllProjects() execution starts...!");
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<GitHubProject>> response = 
				restTemplate.exchange(AppConstants.GITHUB_ALL_REPOS, 
						HttpMethod.GET, 
						null, 
						new ParameterizedTypeReference<List<GitHubProject>>() {}
				);
		LOGGER.info("GitHub - consumeAllProjects() execution end...!");
		return response;
	}

	public ResponseEntity<List<GitHubProject>> consumeProjectsByUser(String userName) {

		LOGGER.info("GitHub - consumeProjectsByUser() execution starts...!");

		final String URL = AppConstants.GITHUB_REPOS_BY_USER.replace("user_name", userName);

		ResponseEntity<List<GitHubProject>> response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();
			response =
					restTemplate.exchange(URL, 
							HttpMethod.GET, 
							null, 
							new ParameterizedTypeReference<List<GitHubProject>>() {}
					);
			
			LOGGER.info("GitHub - consumeProjectsByUser() execution end...!");
			return response;
		}
		catch(Exception e)
		{
			LOGGER.error("GitHub - consumeProjectsByUser() "+e.getMessage());
			
			return new ResponseEntity<List<GitHubProject>>(null, null, HttpStatus.NOT_FOUND);
		}
	}
}