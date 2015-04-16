/*
 * 
 */
package com.etouch.taf.core.exception;

import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * Custom exception thrown by {@link EmailNotification}.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class EmailException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7976195163013123628L;
	
	/** The message. */
	private String message;
	
	/**
	 * Instantiates a new email exception.
	 *
	 * @param message the message
	 */
	public EmailException(String message) {
		super();
		this.message = message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/* (non-Javadoc)
	 * @see java.lang.Throwable#printStackTrace(java.io.PrintWriter)
	 */
	@Override
	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);
	}

}
