/*
 * 
 */
package com.etouch.taf.core.resources;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * The Enum PlatformType.
 */
public enum PlatformType {
	
	/** The Windows. */
	Windows("Windows"),
	
	/** The Mac. */
	Mac("Mac"),
	
	/** The Linux. */
	Linux("Linux"),
	
	/** The Unix. */
	Unix("Unix"),
	
	/** The Android. */
	Android("Android"),
	
	/** The Firefox os. */
	FirefoxOS("FirefoxOS"),
	
	/** The i os. */
	iOS("iOS");
    
	/** The log. */
	static Log log = LogUtil.getLog(PlatformType.class);
	
	/** The name. */
	private String name;

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Instantiates a new platform type.
	 *
	 * @param name the name
	 */
	private PlatformType(String name) {
		this.name = name;
	}
	
	/**
	 * Checks if is supported.
	 *
	 * @param platformName the platform name
	 * @return true, if is supported
	 */
	public static boolean isSupported(String platformName){
		PlatformType[] platformList = PlatformType.values();
		for(PlatformType platform : platformList){
			if(platform.getName().equalsIgnoreCase(platformName)){
				return true;
			}
		}
		return false;
	}

	
}
