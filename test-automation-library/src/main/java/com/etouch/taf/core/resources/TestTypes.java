/*
 * 
 */
package com.etouch.taf.core.resources;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * The Enum TestTypes.
 */
public enum TestTypes {

	
	/** The web. */
	WEB("Web"), 
	
	/** The mobile. */
	MOBILE("Mobile");
	
	/** The log. */
	static Log log = LogUtil.getLog(TestTypes.class);
	
	/** The test type. */
	private String testType;

	/**
	 * Instantiates a new test types.
	 *
	 * @param testType the test type
	 */
	private TestTypes(String testType) {
		this.testType = testType;
	}

	/**
	 * Gets the test type.
	 *
	 * @return the test type
	 */
	public String getTestType() {
		return testType;
	}

}
