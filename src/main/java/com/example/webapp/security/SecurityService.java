package com.example.webapp.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * The Class SecurityService.
 */
public class SecurityService {

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(SecurityService.class);



	/**
	 * LOGIN.
	 *
	 * @param username the username
	 * @param password the password
	 * @throws UnknownAccountException       the unknown account exception
	 * @throws IncorrectCredentialsException the incorrect credentials exception
	 * @throws LockedAccountException        the locked account exception
	 * @throws ExcessiveAttemptsException    the excessive attempts exception
	 * @throws AuthenticationException       the authentication exception
	 */
	public static void login( String username, String password )
			throws com.example.webapp.security.exception.UnknownAccountException,
			com.example.webapp.security.exception.IncorrectCredentialsException,
			com.example.webapp.security.exception.LockedAccountException,
			com.example.webapp.security.exception.ExcessiveAttemptsException,
			com.example.webapp.security.exception.AuthenticationException {


		org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		token.setRememberMe(true);

		try {


			// invoke Shiro login

			currentUser.login(token);


		} catch (UnknownAccountException uae) {
			uae.printStackTrace();
			throw new com.example.webapp.security.exception.UnknownAccountException(uae.getMessage(),
					uae.getCause());
		} catch (IncorrectCredentialsException ice) {
			ice.printStackTrace();
			throw new com.example.webapp.security.exception.IncorrectCredentialsException(ice.getMessage(),
					ice.getCause());
		} catch (LockedAccountException lae) {
			lae.printStackTrace();
			throw new com.example.webapp.security.exception.LockedAccountException(lae.getMessage(),
					lae.getCause());
		} catch (ExcessiveAttemptsException eae) {
			eae.printStackTrace();
			throw new com.example.webapp.security.exception.ExcessiveAttemptsException(eae.getMessage(),
					eae.getCause());
		} catch (org.apache.shiro.authc.AuthenticationException ae) {
			ae.printStackTrace();
			throw new com.example.webapp.security.exception.AuthenticationException(ae.getMessage(),
					ae.getCause());
		}

		logger.info("Login successful: =" + username + "=  User is authenticated: " + currentUser.isAuthenticated());

	}



	/**
	 * Checks if is authenticated.
	 *
	 * @return true, if is authenticated
	 */
	public static boolean isAuthenticated() {
		org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();
		return currentUser.isAuthenticated();
	}




	/**
	 * Checks if is authenticated.
	 *
	 * @return true, if is authenticated
	 */
	public static String getUsername() {

		org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
		if (subject != null) {

			if (!(subject.isAuthenticated())) {
				logger.warn("subject NOT authenticated");
			} else {
				logger.info("subject authenticated");
			}

			if (subject.getPrincipal() != null) {
				return subject.getPrincipal().toString();
			}
		}
		return null;
	}




	/**
	 * LOGOUT
	 */
	public static void logout() {

		org.apache.shiro.subject.Subject currentUser = SecurityUtils.getSubject();

		currentUser.logout();

		logger.info("Logged OUT successfully: " + currentUser.getPrincipal());

	}

}
