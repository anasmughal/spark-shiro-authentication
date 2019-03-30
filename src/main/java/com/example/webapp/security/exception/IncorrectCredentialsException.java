package com.example.webapp.security.exception;


/**
 * 
 * IncorrectCredentialsException
 *
 */
public class IncorrectCredentialsException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * Creates a new IncorrectCredentialsException.
	 */
	public IncorrectCredentialsException() {
		super();
	}



	/**
	 * Constructs a new IncorrectCredentialsException.
	 *
	 * @param message the reason for the exception
	 */
	public IncorrectCredentialsException(String message) {
		super(message);
	}



	/**
	 * Constructs a new IncorrectCredentialsException.
	 *
	 * @param cause the underlying Throwable that caused this exception to be
	 *              thrown.
	 */
	public IncorrectCredentialsException(Throwable cause) {
		super(cause);
	}



	/**
	 * Constructs a new IncorrectCredentialsException.
	 *
	 * @param message the reason for the exception
	 * @param cause   the underlying Throwable that caused this exception to be
	 *                thrown.
	 */
	public IncorrectCredentialsException(String message, Throwable cause) {
		super(message, cause);
	}


}
