/*
 * 
 */
package com.etouch.taf.core.resources;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * TestEnvironmentType stores information on test execution environment.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public enum TestEnvironmentType {
	
	/** The local. */
	LOCAL("local"),
	
	/** The remote. */
	REMOTE("remote"),
	
	/** The browserstack. */
	BROWSERSTACK("browserstack");
 
	/** The log. */
	static Log log = LogUtil.getLog(TestEnvironmentType.class);
	
 	/** The test env. */
	 private String testEnv;

	/**
	 * Instantiates a new test environment type.
	 *
	 * @param testEnv the test env
	 */
	private TestEnvironmentType(String testEnv) {
		this.testEnv = testEnv;
	}

	/**
	 * Returns test environment.
	 *
	 * @return the test env
	 */
	public String getTestEnv() {
		return testEnv;
	}
}
