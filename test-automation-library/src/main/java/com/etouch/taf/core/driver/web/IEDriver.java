/*
 * 
 */
package com.etouch.taf.core.driver.web;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.driver.DriverBuilder;
import com.etouch.taf.core.driver.DriverConstantUtil;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.core.resources.TestBedType;
import com.etouch.taf.core.resources.TestEnvironmentType;
import com.etouch.taf.util.ConfigUtil;
import com.etouch.taf.webui.selenium.SeleniumDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class IEDriver.
 */
public class IEDriver extends DriverBuilder {

	/**
	 * Instantiates a new IE driver.
	 *
	 * @param testBed the test bed
	 * @throws DriverException the driver exception
	 */
	public IEDriver(TestBed testBed) throws DriverException {
		super(testBed);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Creates Driver for IE8,IE9,IE10.
	 *
	 * @throws DriverException the driver exception
	 */
	@Override
	public void buildDriver() throws DriverException {

		if (ConfigUtil.isLocalEnv()) {
			// If the tool is given as Selenium in DevConfig, then create a selenium IEDriver
			if (ConfigUtil.isSelenium()) {
				File ieDriverFile = getIEDriverFile();
				driver = SeleniumDriver.buildIEDriver(ieDriverFile);
			}

		} else if (ConfigUtil.isRemoteEnv()) {
			
		
			if (ConfigUtil.isSelenium()) {
				
			capabilities = DesiredCapabilities.internetExplorer();

			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			capabilities.setVersion(testBed.getBrowser().getVersion());

			 driver= SeleniumDriver.buildRemoteDriver(capabilities);
			}

		} else if (ConfigUtil.isBrowserStackEnv()) {
			capabilities = DesiredCapabilities.internetExplorer();
			buildBrowserstackCapabilities();
		}

	}

	/**
	 * This method returns Driver file for InternetExplorer Driver If is in
	 * mentioned in config.yml then set that as system property otherwise, use
	 * the defaults InternetExplorer driver from library based on the given
	 * platform
	 *
	 * @return the IE driver file
	 * @throws DriverException the driver exception
	 */
	public File getIEDriverFile() throws DriverException {

		File file = null;

		if (testBed.getBrowser().getDriverLocation() != null) {

			file = new File(testBed.getBrowser().getDriverLocation());

		} else {
			if (ConfigUtil.isWindows(testBed)) {
				// TODO have to remove the hard coded values
				//file = new File("..\\test-automation-library\\resources\\IEDriverServer.exe");
				file = new File(DriverConstantUtil.IE_DRIVER_FILE);
			} else {
				throw new DriverException(
						" Not found a InternetExplorer- not in Windows OS");
			}
		}

		return file;
	}
	
	/* (non-Javadoc)
	 * @see com.etouch.taf.core.driver.DriverBuilder#getDriver()
	 */
	@Override
	public Object getDriver() throws DriverException {
		// TODO Auto-generated method stub
		return driver;
	}

}
