/*
 * 
 */
package com.etouch.taf.core.resources;

import org.apache.commons.logging.Log;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * List the valid Expected condition for wait driver supported by the test framework.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public enum ObjectValType {
	
	/* Use for the single element search */
	/** The id. */
	ID("id"), 
	
	/** The name. */
	NAME("name"),
	
	/** The xpath. */
	XPATH("xpath"),
	
	/** The css. */
	CSS("cssSelector"),
	
	/** The link. */
	LINK("linkText"),
	
	/** The Partial link. */
	PartialLink("PartialLinkText"),
	
	/** The class. */
	CLASS("className"),
	
	/** The tag. */
	TAG("tagName")
	;
    
	/** The log. */
	static Log log = LogUtil.getLog(ObjectValType.class);
	
	/** The type. */
	private String type;

	/**
	 * Instantiates a new object val type.
	 *
	 * @param type the type
	 */
	private ObjectValType(String type) {
		this.type = type;
	}

	/**
	 * Gets the object val type.
	 *
	 * @return the object val type
	 */
	public String getObjectValType() {
		return type;
	}

}
