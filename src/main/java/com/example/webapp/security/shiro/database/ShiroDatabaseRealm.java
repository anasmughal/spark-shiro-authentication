package com.example.webapp.security.shiro.database;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 
 * 
 *
 */
public class ShiroDatabaseRealm extends AuthorizingRealm {

	/** The Constant logger. */
	final static Logger logger = LoggerFactory.getLogger(ShiroDatabaseRealm.class);



	/**
	 * WHEN USER LOGS IN !!!
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo( final AuthenticationToken token )
			throws AuthenticationException {


		UsernamePasswordToken upToken = (UsernamePasswordToken) token;


		// Get user from database
		// (We are faking it here to simplify the logic
		String usernameFromDB = "johndoe";
		String passwordFromDB = "pass123";


		// Now pass the username for the principal and pass the password from database
		AuthenticationInfo info = new SimpleAuthenticationInfo(upToken.getUsername(), passwordFromDB, getName());


		return info;
	}



	/**
	 * this function loads user authorization data from "userManager" data source
	 * (database) User, Role are custom POJOs (beans) and are loaded from database.
	 * WildcardPermission implements shiros Permission interface, so my permissions
	 * in database gets accepted by shiro security
	 **/
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo( final PrincipalCollection principals ) {

		/*
		 * Set<String> roles = new HashSet<String>(); Set<Permission> permissions = new
		 * HashSet<Permission>(); Collection<User> principalsList =
		 * principals.byType(User.class);
		 * 
		 * if (principalsList.isEmpty()) { throw new
		 * AuthorizationException("Empty principals list!"); } //LOADING STUFF FOR
		 * PRINCIPAL for (User userPrincipal : principalsList) { try {
		 * this.userManager.beginTransaction();
		 * 
		 * User user = this.userManager.loadById(userPrincipal.getId());
		 * 
		 * Set<Role> userRoles = user.getRoles(); for (Role r : userRoles) {
		 * roles.add(r.getName()); Set<WildcardPermission> userPermissions =
		 * r.getPermissions(); for (WildcardPermission permission : userPermissions) {
		 * if (!permissions.contains(permission)) { permissions.add(permission); } } }
		 * this.userManager.commitTransaction(); } catch (InvalidDataException idEx) {
		 * //userManger exceptions throw new AuthorizationException(idEx); } catch
		 * (ResourceException rEx) { throw new AuthorizationException(rEx); } } //THIS
		 * IS THE MAIN CODE YOU NEED TO DO !!!! SimpleAuthorizationInfo info = new
		 * SimpleAuthorizationInfo(roles); info.setRoles(roles); //fill in roles
		 * info.setObjectPermissions(permissions); //add permisions (MUST IMPLEMENT
		 * SHIRO PERMISSION INTERFACE)
		 * 
		 * return info;
		 * 
		 */
		return null;

	}




}
