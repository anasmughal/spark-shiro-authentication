package com.example.webapp.security.exception;


/**
 * UnknownAccountException
 *
 */
public class UnknownAccountException extends AuthenticationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * Creates a new UnknownAccountException.
	 */
	public UnknownAccountException() {
		super();
	}



	/**
	 * Constructs a new UnknownAccountException.
	 *
	 * @param message the reason for the exception
	 */
	public UnknownAccountException(String message) {
		super(message);
	}



	/**
	 * Constructs a new UnknownAccountException.
	 *
	 * @param cause the underlying Throwable that caused this exception to be
	 *              thrown.
	 */
	public UnknownAccountException(Throwable cause) {
		super(cause);
	}



	/**
	 * Constructs a new UnknownAccountException.
	 *
	 * @param message the reason for the exception
	 * @param cause   the underlying Throwable that caused this exception to be
	 *                thrown.
	 */
	public UnknownAccountException(String message, Throwable cause) {
		super(message, cause);
	}
}
