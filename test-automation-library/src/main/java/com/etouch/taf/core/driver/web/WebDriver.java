/*
 * 
 */
package com.etouch.taf.core.driver.web;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.driver.DriverBuilder;
import com.etouch.taf.core.exception.DriverException;

// TODO: Auto-generated Javadoc
/**
 * An Abstract class for webrelated browser drivers.
 */
public abstract class WebDriver  extends DriverBuilder{

	/**
	 * Instantiates a new web driver.
	 *
	 * @param testBed the test bed
	 * @throws DriverException the driver exception
	 */
	public WebDriver(TestBed testBed) throws DriverException {
		super(testBed);
		// TODO Auto-generated constructor stub
	}

	
}
