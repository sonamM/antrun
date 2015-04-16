/*
 * 
 */
package com.etouch.taf.tools.jira;

// TODO: Auto-generated Javadoc
/**
 * This class stores information used to connect rally instance.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class JiraInfo {
	
	/** The url. */
	String url;
	
	/** The user name. */
	String userName;
	
	/** The password. */
	String password;
	
	/** The issue url. */
	String issueUrl;
	//String auth;
	
	/**
	 * Instantiates a new jira info.
	 *
	 * @param url the url
	 * @param userName the user name
	 * @param password the password
	 */
	public JiraInfo(String url, String userName, String password) {
		super();
		this.url = url;
		this.issueUrl = issueUrl;
		this.userName = userName;
		this.password = password;
		//this.auth = auth;
	}
	
	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 *
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the issue url.
	 *
	 * @return the issue url
	 */
	public String getissueUrl() {
		return issueUrl;
	}
	
	/**
	 * Sets the issue url.
	 *
	 * @param issueUrl the new issue url
	 */
	public void setissueUrl(String issueUrl) {
		this.issueUrl = issueUrl;
	}
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
/*	public String getauth() {
		return auth;
	}*/
	
}

