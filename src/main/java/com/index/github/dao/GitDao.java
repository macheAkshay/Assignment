package com.index.github.dao;

import java.util.List;

import com.index.github.bean.GitHubProject;

public interface GitDao {

	public List<GitHubProject> consumeAllProjects();
	public List<GitHubProject> consumeProjectsByUser(String userName);
}
