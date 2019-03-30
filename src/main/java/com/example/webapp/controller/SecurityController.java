package com.example.webapp.controller;

//import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.webapp.security.SecurityService;
import com.example.webapp.security.exception.AuthenticationException;
import com.example.webapp.util.Path;

//import junit.framework.Assert;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerEngine;



/**
 * The Class SecurityController.
 */
public class SecurityController extends BaseController {

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(SecurityController.class);
    
    


	/**
	 * 
	 */
	public static Route loginGET = ( Request request, Response response ) -> {

		logger.info("SecurityController::loginGET");

		// Build the data-model
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("title", "Login");
		templateData.put("HeadTitle", "Login");

		// for testing only
		templateData.put("username", "johndoe");
		templateData.put("password", "pass123");
		templateData.put("DEV", true);

		String loggedInUser = SecurityService.getUsername();
		if (loggedInUser != null) {
			templateData.put("loggedInUser", loggedInUser);
		}

		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
		return freeMarkerEngine.render(new ModelAndView(templateData, "login.ftl"));

	};



	/**
	 * 
	 */
	public static Route loginPOST = ( Request request, Response response ) -> {

		logger.info("SecurityController::loginPOST");


		boolean loginSuccess = true;
		
		
		Map<String, String> postParams = getPostParams(request);

		String username = postParams.get("username");
		String password = postParams.get("password");

		if (username == null || username.isEmpty()) {
			halt(401, "Login FAILED!");
			logger.warn("Login FAILED due to empty or null username!!");
		}
		if (password == null || password.isEmpty()) {
			halt(401, "Login FAILED!");
			logger.warn("Login FAILED due to empty or null password!");
		}

		try {
			SecurityService.login(username, password);
		} catch (UnknownAccountException uae) {
			uae.printStackTrace();
			loginSuccess = false;
		} catch (IncorrectCredentialsException ice) {
			ice.printStackTrace();
			loginSuccess = false;
		} catch (LockedAccountException lae) {
			lae.printStackTrace();
			loginSuccess = false;
		} catch (ExcessiveAttemptsException eae) {
			eae.printStackTrace();
			loginSuccess = false;
		} catch (AuthenticationException ae) {
			ae.printStackTrace();
			loginSuccess = false;
		}

		logger.info(">>> Authentication successful: " + loginSuccess);

		
		// Build the data-model
		Map<String, Object> templateData = new HashMap<String, Object>();
		templateData.put("title", "Login");
		templateData.put("HeadTitle", "Login");



		if (loginSuccess) {

			response.redirect(Path.LOGIN_SUCCESS);

		} else {

			// for development only
			templateData.put("DEV", true);

		}

		String templateName = "login.ftl";
		templateData.put("loginSuccess", loginSuccess);
		templateData.put("username", username);
		templateData.put("password", password);
		templateData.put("templateName", templateName);

		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
		return freeMarkerEngine.render(new ModelAndView(templateData, templateName));

	};


	/**
	 * 
	 */
	public static Route loginSuccessGET = ( Request request, Response response ) -> {

		logger.info("SecurityController::loginSuccessGET");

		// Build the data-model
		Map<String, Object> templateData = new HashMap<String, Object>();
		// data.put("title", "Login");

		String loggedInUser = SecurityService.getUsername();
		if (loggedInUser != null) {
			templateData.put("loggedInUser", loggedInUser);
		}

		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
		return freeMarkerEngine.render(new ModelAndView(templateData, "login-success.ftl"));

	};





	/**
	 * 
	 */
	public static Route logout = ( Request request, Response response ) -> {

		logger.info("SecurityController::logout");

		SecurityService.logout();

		// Build the data-model
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("title", "logout");

		FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
		return freeMarkerEngine.render(new ModelAndView(data, "login.ftl"));

	};





}
