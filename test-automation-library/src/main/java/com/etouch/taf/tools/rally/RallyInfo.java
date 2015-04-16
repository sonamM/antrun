/*
 * 
 */
package com.etouch.taf.tools.rally;

// TODO: Auto-generated Javadoc
/**
 * This class stores information used to connect rally instance.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class RallyInfo {
	
	/** The url. */
	String url;
	
	/** The user name. */
	String userName;
	
	/** The password. */
	String password;
	
	/** The app name. */
	String appName;
	
	/** The wsapi version. */
	String wsapiVersion;
	
	/**
	 * Instantiates a new rally info.
	 *
	 * @param url the url
	 * @param userName the user name
	 * @param password the password
	 * @param appName the app name
	 */
	public RallyInfo(String url, String userName, String password, String appName) {
		super();
		this.url = url;
		this.userName = userName;
		this.password = password;
		this.appName = appName;
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
	
	/**
	 * Gets the app name.
	 *
	 * @return the app name
	 */
	public String getAppName() {
		return appName;
	}
	
	/**
	 * Sets the app name.
	 *
	 * @param appName the new app name
	 */
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	/**
	 * Gets the wsapi version.
	 *
	 * @return the wsapi version
	 */
	public String getWsapiVersion() {
		return wsapiVersion;
	}
	
	/**
	 * Sets the wsapi version.
	 *
	 * @param wsapiVersion the new wsapi version
	 */
	public void setWsapiVersion(String wsapiVersion) {
		this.wsapiVersion = wsapiVersion;
	}

}
