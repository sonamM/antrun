/*
 * 
 */
package com.etouch.taf.core.exception;

import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * Custom exception thrown if exception is raised during driver build.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 */
public class DriverException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4467116203951497332L;
	
	/** The message. */
	private String message;
	
	/**
	 * Instantiates a new driver exception.
	 *
	 * @param message the message
	 */
	public DriverException(String message) {
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
