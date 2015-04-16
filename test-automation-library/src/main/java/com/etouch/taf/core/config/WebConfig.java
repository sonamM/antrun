/*
 * 
 */
package com.etouch.taf.core.config;

// TODO: Auto-generated Javadoc
/**
 * The Class WebConfig.
 */
public class WebConfig extends TafConfig {
	
	/** The url. */
	private String URL;
	
	/** The proxy. */
	private String proxy;
	
	/** The no proxy. */
	private String noProxy;
	
	/** The user name. */
	private String userName;	
	
	/** The password. */
	private String password;
	
	

	/**
	 * Gets the url.
	 *
	 * @return the url
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * Sets the url.
	 *
	 * @param uRL the new url
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}

	/**
	 * Gets the proxy.
	 *
	 * @return the proxy
	 */
	public String getProxy() {
		return proxy;
	}

	/**
	 * Sets the proxy.
	 *
	 * @param proxy the new proxy
	 */
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	/**
	 * Gets the no proxy.
	 *
	 * @return the no proxy
	 */
	public String getNoProxy() {
		return noProxy;
	}

	/**
	 * Sets the no proxy.
	 *
	 * @param noProxy the new no proxy
	 */
	public void setNoProxy(String noProxy) {
		this.noProxy = noProxy;
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
	
	

}
