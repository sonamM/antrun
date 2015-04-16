/*
 * 
 */
package com.etouch.taf.util;

import org.apache.commons.logging.Log;


// TODO: Auto-generated Javadoc
/**
 * This class OS utility methods.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class OSUtil {
	
	/** The log. */
	private static Log log = LogUtil.getLog(OSUtil.class);

	/** The Constant OS_32_BIT. */
	private static final String OS_32_BIT = "32";
	
	/** The Constant OS_64_BIT. */
	private static final String OS_64_BIT = "64";
	
	/** The Constant OS_ARCH. */
	private static final String OS_ARCH = "os.arch";

	/**
	 * This method determines, if the operating system is 64 bit.
	 *
	 * @return true, if is 64 bit os
	 */
	public static boolean is64BitOS() {
		boolean is64BitOS = false;
		// Get the OS information
		String osArchitureInfo = System.getProperty(OS_ARCH);
		if(osArchitureInfo != null) {
			is64BitOS = osArchitureInfo.contains(OS_64_BIT);
		}
		return is64BitOS;
	}
	
	/**
	 * This method determines, if the operating system is 32 bit.
	 *
	 * @return true, if is 32 bit os
	 */
	public static boolean is32BitOS() {
		boolean is32BitOS = false;
		// Get the OS information
		String osArchitureInfo = System.getProperty(OS_ARCH);
		if(osArchitureInfo != null) {
			is32BitOS = osArchitureInfo.contains(OS_32_BIT);
		}
		return is32BitOS;
	}
}
