package com.index.git.api.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.springframework.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.index.git.api.dao.impl.GitLabDaoImpl;

public class GitLabTest{

	GitLabDaoImpl gitLabDao;
	
	@BeforeTest
	public void createDaoObject()
	{
		gitLabDao = new GitLabDaoImpl();
	}
	
	@Test
	public void isNull()
	{
		assertNotNull(gitLabDao);
	}
	
	@Test
	public void isValidUserId() {

		final String userId = "1";
		
		assertEquals(gitLabDao.consumeProjectsByUser(userId).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void invalidUserId() {

		final String userId = "mac78";
		
		assertEquals(gitLabDao.consumeProjectsByUser(userId).getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void hasProjects() {

		final String userId = "nk";
		
		assertEquals(gitLabDao.consumeProjectsByUser(userId).getBody().isEmpty(), true);
	}
	
	@Test
	public void hasRepositories() {

		assertEquals(gitLabDao.consumeAllProjects().getBody().isEmpty(), false);
	}
}