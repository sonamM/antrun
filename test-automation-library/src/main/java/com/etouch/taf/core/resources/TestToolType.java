/*
 * 
 */
package com.etouch.taf.core.resources;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * The Enum TestToolType.
 */
public enum TestToolType {
	
	/** The Appium. */
	Appium("Appium"), 
	
	/** The Selenium. */
	Selenium("Selenium"), 
	
	/** The Experi test. */
	ExperiTest("ExperiTest");
	
	/** The log. */
	static Log log = LogUtil.getLog(TestToolType.class);
	
	/** The test tool type. */
	private String testToolType;

	/**
	 * Instantiates a new test tool type.
	 *
	 * @param testToolType the test tool type
	 */
	private TestToolType(String testToolType) {
		this.testToolType = testToolType;
	}

	/**
	 * Gets the test tool type.
	 *
	 * @return the test tool type
	 */
	public String getTestToolType() {
		return testToolType;
	}

	

}
