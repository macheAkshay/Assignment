package com.index.git.api.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.index.github.api.bean.GitHubProject;

public interface GitHubDao {

	public ResponseEntity<List<GitHubProject>> consumeAllProjects();
	public ResponseEntity<List<GitHubProject>> consumeProjectsByUser(String userName);
}
