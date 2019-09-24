package com.index.git.api.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.springframework.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.index.git.api.dao.impl.GitHubDaoImpl;

public class GitHubTest{

	GitHubDaoImpl gitHubDao;
	
	@BeforeTest
	public void createDaoObject()
	{
		gitHubDao = new GitHubDaoImpl();
	}
	
	@Test
	public void isNull()
	{
		assertNotNull(gitHubDao);
	}
	
	@Test
	public void isValidUserName() {

		final String userName = "macheAkshay";
		
		assertEquals(gitHubDao.consumeProjectsByUser(userName).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void invalidUserName() {

		final String userName = "mac";
		
		assertEquals(gitHubDao.consumeProjectsByUser(userName).getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void hasProjects() {

		final String userName = "like";
		
		assertEquals(gitHubDao.consumeProjectsByUser(userName).getBody().isEmpty(), true);
	}
	
	@Test
	public void hasRepositories() {

		assertEquals(gitHubDao.consumeAllProjects().getBody().isEmpty(), false);
	}
}