/*
 * 
 */
package com.etouch.taf.core.exception;

import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * Custom exception thrown if error in generating report.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class ReportException extends Exception {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4930971510611884750L;
	
	/** The message. */
	private String message;
		
	/**
	 * Instantiates a new report exception.
	 *
	 * @param message the message
	 */
	public ReportException(String message) {
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
