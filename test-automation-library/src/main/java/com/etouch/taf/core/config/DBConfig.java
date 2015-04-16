/*
 * 
 */
package com.etouch.taf.core.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: Auto-generated Javadoc
/**
 * This class has all the configuration required for Database connection.
 */
public class DBConfig {

	/** The db url. */
	String dbUrl; 
	
	/** The user name. */
	String userName;
	
	/** The password. */
	String password;
	
	/** The db class. */
	String dbClass;
	
	/**
	 * Gets the db url.
	 *
	 * @return the db url
	 */
	public String getDbUrl() {
		return dbUrl;
	}
	
	/**
	 * Sets the db url.
	 *
	 * @param dbUrl the new db url
	 */
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
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
	 * Gets the db class.
	 *
	 * @return the db class
	 */
	public String getDbClass() {
		return dbClass;
	}
	
	/**
	 * Sets the db class.
	 *
	 * @param dbClass the new db class
	 */
	public void setDbClass(String dbClass) {
		this.dbClass = dbClass;
	}
	
	
}
