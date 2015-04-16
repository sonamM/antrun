/*
 * 
 */
package com.etouch.taf.core.config;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class TestngConfig.
 */
public class TestngConfig extends TafConfig {
	
	/** The listener. */
	private String listener;
	
	/** The class name. */
	private String[] className;
	
	/** The reporter. */
	private String reporter;
	

	/**
	 * Gets the listener.
	 *
	 * @return the listener
	 */
	public String getListener() {
		return listener;
	}
	
	/**
	 * Sets the listener.
	 *
	 * @param listener the new listener
	 */
	public void setListener(String listener) {
		this.listener = listener;
	}
	
	
	/**
	 * Sets the class name.
	 *
	 * @param className the new class name
	 */
	public void setClassName(String[] className) {
		this.className = className;
	}
	
	/**
	 * Gets the class name.
	 *
	 * @return the class name
	 */
	public String[] getClassName() {
		return className;
	}

	/**
	 * Gets the reporter.
	 *
	 * @return the reporter
	 */
	public String getReporter() {
		return reporter;
	}

	/**
	 * Sets the reporter.
	 *
	 * @param reporter the new reporter
	 */
	public void setReporter(String reporter) {
		this.reporter = reporter;
	}
	
	
	
}
