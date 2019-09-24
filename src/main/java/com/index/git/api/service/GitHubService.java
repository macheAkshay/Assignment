package com.index.git.api.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.index.github.api.bean.GitHubProject;

public interface GitHubService {

	public abstract ResponseEntity<List<GitHubProject>> getUsersAndProjects();
	public ResponseEntity<List<GitHubProject>> getProjectsByUser(String userName);
}
