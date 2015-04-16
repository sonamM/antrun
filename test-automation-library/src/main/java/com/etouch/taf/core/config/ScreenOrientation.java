/*
 * 
 */
package com.etouch.taf.core.config;

// TODO: Auto-generated Javadoc
/**
 * The Enum ScreenOrientation.
 */
public enum ScreenOrientation {

	/** The landscape. */
	LANDSCAPE("Landscape"),/** The portrait. */
PORTRAIT("Portrait");
	
	/** The orientation. */
	private String orientation;

	/**
	 * Gets the orientation.
	 *
	 * @return the orientation
	 */
	public String getOrientation() {
		return orientation;
	}

	/**
	 * Instantiates a new screen orientation.
	 *
	 * @param orientation the orientation
	 */
	private ScreenOrientation(String orientation) {
		this.orientation = orientation;
	}
	
	
	
	
}
