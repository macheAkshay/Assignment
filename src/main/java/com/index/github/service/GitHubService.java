package com.index.github.service;

import java.util.List;

import com.index.github.bean.GitHubProject;

public interface GitHubService {

	public abstract List<GitHubProject> getUsersAndProjects();
	public List<GitHubProject> getProjectsByUser(String userName);
}
