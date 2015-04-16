/*
 * 
 */
package com.etouch.taf.core.driver;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.exception.DriverException;


// TODO: Auto-generated Javadoc
/**
 * The Interface IDriver.
 */
public interface IDriver {//extends RemoteWebDriver{
	
	/**
 * Builds the driver.
 *
 * @param profile the profile
 * @throws DriverException the driver exception
 */
public void buildDriver(TestBed profile) throws DriverException;
	
	/**
	 * Gets the driver.
	 *
	 * @return the driver
	 */
	public Object getDriver();
}
