/*
 * 
 */
package com.etouch.taf.core.resources;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * List the valid Browsers supported by the test framework.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public enum TestBedType {
	
	/** The Firefox. */
	Firefox("fireFox"), 
	
	/** The Internet explorer. */
	InternetExplorer("InternetExplorer"), 
	
	/** The Chrome. */
	Chrome("Chrome"), 
	
	/** The Safari. */
	Safari("Safari"),
	
	// iOS Simulators
	/** The i phone native sim. */
	iPhoneNativeSim("iPhoneNativeSim"),
	
	/** The i pad native sim. */
	iPadNativeSim("iPadNativeSim"),
	
	/** The i phone web sim. */
	iPhoneWebSim("iPhoneWebSim"),
	
	/** The i pad web sim. */
	iPadWebSim("iPadWebSim"),
	
	//iOS real device
	/** The i phone native. */
	iPhoneNative("iPhoneNative"),
	
	/** The i pad native. */
	iPadNative("iPadNative"),
	
	/** The i phone web. */
	iPhoneWeb("iPhoneWeb"),
	
	/** The i pad web. */
	iPadWeb("iPadWeb"),
	
	/** The i os. */
	iOS("iOS"),
    
    /** The Android native. */
    AndroidNative("AndroidNative"),
	
	/** The Android web em. */
	AndroidWebEm("AndroidWebEm"),
	
	/** The Android. */
	Android("Android"),
	
	/**  The Android Native Browser. */
	AndroidBrowser("Android")
	;
    
	/** The log. */
	static Log log = LogUtil.getLog(TestBedType.class);
	
	/** The test bed name. */
	private String testBedName;

	/**
	 * Instantiates a new test bed type.
	 *
	 * @param testBedName the test bed name
	 */
	private TestBedType(String testBedName) {
		this.testBedName = testBedName;
	}

	/**
	 * Gets the test bed name.
	 *
	 * @return the test bed name
	 */
	public String getTestBedName() {
		return testBedName;
	}
	
	
	/**
	 * Checks if is supported.
	 *
	 * @param testBedType the platform name
	 * @return true, if is supported
	 */
	public static boolean isSupported(String testBedType){
		TestBedType[] testBedTypeList = TestBedType.values();
		for(TestBedType tbType : testBedTypeList){
			if(tbType.getTestBedName().equalsIgnoreCase(testBedType)){
				return true;
			}
		}
		return false;
	}
	
	

}
