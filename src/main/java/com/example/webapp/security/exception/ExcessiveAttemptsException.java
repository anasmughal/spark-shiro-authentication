/**
 * 
 */
package com.example.webapp.security.exception;


/**
 * ExcessiveAttemptsException
 *
 */
public class ExcessiveAttemptsException extends AuthenticationException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	/**
	 * Creates a new ExcessiveAttemptsException.
	 */
	public ExcessiveAttemptsException() {
		super();
	}



	/**
	 * Constructs a new ExcessiveAttemptsException.
	 *
	 * @param message the reason for the exception
	 */
	public ExcessiveAttemptsException(String message) {
		super(message);
	}



	/**
	 * Constructs a new ExcessiveAttemptsException.
	 *
	 * @param cause the underlying Throwable that caused this exception to be
	 *              thrown.
	 */
	public ExcessiveAttemptsException(Throwable cause) {
		super(cause);
	}



	/**
	 * Constructs a new ExcessiveAttemptsException.
	 *
	 * @param message the reason for the exception
	 * @param cause   the underlying Throwable that caused this exception to be
	 *                thrown.
	 */
	public ExcessiveAttemptsException(String message, Throwable cause) {
		super(message, cause);
	}
}
