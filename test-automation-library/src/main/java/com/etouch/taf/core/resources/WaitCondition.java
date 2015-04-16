/*
 * 
 */
package com.etouch.taf.core.resources;

import org.apache.commons.logging.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * List the valid Expected condition for wait driver supported by the test framework.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 */
public enum WaitCondition {
	
	/* Use for the single element search */
	/** The exist. */
	EXIST("presenceOfElementLocated"), 
	
	/** The clickable. */
	CLICKABLE("elementToBeClickable"),
	
	/** The visible. */
	VISIBLE("visibilityOfElementLocated"),
	
	/* Use for the below for multi elements search */
	/** The allexist. */
	ALLEXIST("presenceOfAllElementsLocatedBy"),
	
	/** The allvisible. */
	ALLVISIBLE("visibilityOfAllElementsLocatedBy")
	;
    
	/** The log. */
	static Log log = LogUtil.getLog(WaitCondition.class);
	
	/** The condition. */
	private String condition;

	/**
	 * Gets the condition.
	 *
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * Instantiates a new wait condition.
	 *
	 * @param condition the condition
	 */
	private WaitCondition(String condition) {
		this.condition = condition;
	}


}
