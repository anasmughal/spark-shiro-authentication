/*
 * 
 */
package com.example.webapp;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.redirect;
import static spark.Spark.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.webapp.controller.SecurityController;
import com.example.webapp.util.Path;

import spark.Spark;
import spark.servlet.SparkApplication;



/**
 * The Class Main.
 */
public class Main implements SparkApplication {


	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(Main.class);
	
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String[] args ) {
		new Main().init();
	}
	



	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public void init() {

		logger.info("======== init method invoked in JavaSpark =======");
    	
		int maxThreads = 4;
		int minThreads = 2;
		int timeOutMillis = 30000;
		threadPool(maxThreads, minThreads, timeOutMillis);



		/////////////////////////
		// Spark Configuration
		/////////////////////////

		Spark.staticFiles.location("public");
    	


		/////////////////////////
		// Routes
		/////////////////////////

		get(Path.LOGIN, SecurityController.loginGET);
		post(Path.LOGIN, SecurityController.loginPOST);

		get(Path.LOGIN_SUCCESS, SecurityController.loginSuccessGET);

		get(Path.LOGOUT, SecurityController.logout);


		redirect.get("/", Path.LOGIN);


    }
    
   
    
}