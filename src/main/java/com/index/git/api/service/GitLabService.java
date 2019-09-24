package com.index.git.api.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import com.index.gitlab.api.bean.GitLabProject;

public interface GitLabService {

	public abstract ResponseEntity<List<GitLabProject>> getUsersAndProjects();
	public ResponseEntity<List<GitLabProject>> getProjectsByUser(String userName);
}
