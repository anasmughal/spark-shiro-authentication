package com.example.webapp.security;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.webapp.security.shiro.database.ShiroDatabaseRealm;



public class RealmDBTest {


	final static Logger logger = LoggerFactory.getLogger(RealmDBTest.class);



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
	public void testDoGetAuthenticationInfo_ValidCredentials() {
		logger.info("==== testDoGetAuthenticationInfo ====");


		ShiroDatabaseRealm realm = new ShiroDatabaseRealm();
		WebSecurityManager securityManager = new DefaultWebSecurityManager(realm);

		// Make SecurityManager available to entire application via static memory
		SecurityUtils.setSecurityManager(securityManager);


		org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();


		// Example using most common scenario:
		// String username and password. Acquire in
		// system-specific manner (HTTP request, GUI, etc)
		String username = "johndoe";
		String password = "pass123";
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);


		try {
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			uae.printStackTrace();
		} catch (IncorrectCredentialsException ice) {
			ice.printStackTrace();
		} catch (LockedAccountException lae) {
			lae.printStackTrace();
		} catch (ExcessiveAttemptsException eae) {
			eae.printStackTrace();
		} catch (org.apache.shiro.authc.AuthenticationException ae) {
			ae.printStackTrace();
		}

		logger.info("is authenticated: " + currentUser.isAuthenticated());

		assertEquals(true, currentUser.isAuthenticated());

		currentUser.logout();

	}



	@Test
	public void testDoGetAuthenticationInfo_NotValidCredentials() {
		logger.info("==== testDoGetAuthenticationInfo ====");


		ShiroDatabaseRealm realm = new ShiroDatabaseRealm();

		WebSecurityManager securityManager = new DefaultWebSecurityManager(realm);

		// Make the SecurityManager instance available to the entire application via
		// static memory:
		SecurityUtils.setSecurityManager(securityManager);


		org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();


		// Example using most common scenario:
		// String username and password. Acquire in
		// system-specific manner (HTTP request, GUI, etc)
		String username = "johndoe";
		String password = "pass777";
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);


		try {
			currentUser.login(token);
		} catch (UnknownAccountException uae) {
			// uae.printStackTrace();
		} catch (IncorrectCredentialsException ice) {
			// ice.printStackTrace();
		} catch (LockedAccountException lae) {
			// lae.printStackTrace();
		} catch (ExcessiveAttemptsException eae) {
			// eae.printStackTrace();
		} catch (org.apache.shiro.authc.AuthenticationException ae) {
			// ae.printStackTrace();
		}

		logger.info("is authenticated: " + currentUser.isAuthenticated());

		assertNotEquals(true, currentUser.isAuthenticated());

		currentUser.logout();
	}



}
