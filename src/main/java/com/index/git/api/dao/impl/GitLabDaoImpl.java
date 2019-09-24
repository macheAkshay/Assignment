package com.index.git.api.dao.impl;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.index.git.api.dao.GitLabDao;
import com.index.git.api.urls.AppConstants;
import com.index.gitlab.api.bean.GitLabProject;

@Repository
public class GitLabDaoImpl implements GitLabDao{

	static {
		
	}
	
	public ResponseEntity<List<GitLabProject>> consumeAllProjects() {

		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<List<GitLabProject>> response = 
				restTemplate.exchange(AppConstants.GITLAB_ALL_REPOS, 
						HttpMethod.GET, 
						null,
						new ParameterizedTypeReference<List<GitLabProject>>() {}
				);

		return response;
	}

	public ResponseEntity<List<GitLabProject>> consumeProjectsByUser(String id) {
		
		final String URL = AppConstants.GITLAB_REPOS_BY_USER.replace("user_id", id);

		ResponseEntity<List<GitLabProject>> response = null;
		try{
			RestTemplate restTemplate = new RestTemplate();
			response = 
					restTemplate.exchange(URL, 
							HttpMethod.GET, 
							null, 
							new ParameterizedTypeReference<List<GitLabProject>>() {}
					);
			
			return response;
		}
		catch (Exception e) 
		{
			return new ResponseEntity<List<GitLabProject>>(null, null, HttpStatus.NOT_FOUND);
		}
	}
}