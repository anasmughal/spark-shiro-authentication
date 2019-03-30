package com.example.webapp.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.webapp.security.exception.AuthenticationException;
import com.example.webapp.security.exception.ExcessiveAttemptsException;
import com.example.webapp.security.exception.IncorrectCredentialsException;
import com.example.webapp.security.exception.LockedAccountException;
import com.example.webapp.security.exception.UnknownAccountException;



public class SecurityManagerTest {


	final static Logger logger = LoggerFactory.getLogger(SecurityManagerTest.class);



	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}



	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}



	@Before
	public void setUp() throws Exception {
	}



	@After
	public void tearDown() throws Exception {
	}



	@Test
	public void testLogin_ValidCredentials() {
		logger.info("==== testDoGetAuthenticationInfo ====");

		String username = "johndoe";
		String password = "pass123";

		try {
			SecurityService.login(username, password);
		} catch (UnknownAccountException uae) {
			uae.printStackTrace();
		} catch (IncorrectCredentialsException ice) {
			ice.printStackTrace();
		} catch (LockedAccountException lae) {
			lae.printStackTrace();
		} catch (ExcessiveAttemptsException eae) {
			eae.printStackTrace();
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
		}

		logger.info("is authenticated: " + username);

		assertEquals(true, SecurityService.isAuthenticated());

		SecurityService.logout();

	}



	@Test
	public void testDoGetAuthenticationInfo_NotValidCredentials() {
		logger.info("==== testDoGetAuthenticationInfo ====");


		String username = "anasmughal@yahoo.com";
		String password = "guest7543";

		try {
			SecurityService.login(username, password);
		} catch (UnknownAccountException uae) {
			uae.printStackTrace();
		} catch (IncorrectCredentialsException ice) {
			ice.printStackTrace();
		} catch (LockedAccountException lae) {
			lae.printStackTrace();
		} catch (ExcessiveAttemptsException eae) {
			eae.printStackTrace();
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
		}

		logger.info("NOT authenticated: " + username);

		assertNotEquals(true, SecurityService.isAuthenticated());

		SecurityService.logout();
	}



}
