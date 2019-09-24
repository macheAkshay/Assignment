package com.index.git.api.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.index.gitlab.api.bean.GitLabProject;

public interface GitLabDao {

	public ResponseEntity<List<GitLabProject>> consumeAllProjects();
	public ResponseEntity<List<GitLabProject>> consumeProjectsByUser(String userName);
}
