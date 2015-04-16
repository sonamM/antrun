/*
 * 
 */
package com.etouch.taf.core.driver.mobile;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.driver.DriverBuilder;
import com.etouch.taf.core.exception.DriverException;

// TODO: Auto-generated Javadoc
/**
 * The Class MobileDriver.
 */
public  class MobileDriver extends DriverBuilder {
	
	
	

	/**
	 * Instantiates a new mobile driver.
	 *
	 * @param testBed the test bed
	 * @throws DriverException the driver exception
	 */
	public MobileDriver(TestBed testBed) throws DriverException {
		super(testBed);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.etouch.taf.core.driver.DriverBuilder#buildDriver()
	 */
	@Override
	public void buildDriver() throws DriverException {
		// TODO Auto-generated method stub
		
	}

	
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.driver.DriverBuilder#getDriver()
	 */
	public Object getDriver() throws DriverException {
		// TODO Auto-generated method stub
		return driver;
	}
	

}
