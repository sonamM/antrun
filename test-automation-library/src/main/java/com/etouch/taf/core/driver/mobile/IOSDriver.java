/*
 * 
 */
package com.etouch.taf.core.driver.mobile;

import java.net.MalformedURLException;

import org.apache.commons.logging.Log;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.driver.DriverBuilder;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.core.resources.TestEnvironmentType;
import com.etouch.taf.core.resources.TestToolType;
import com.etouch.taf.mobile.appium.AppiumDriver;
import com.etouch.taf.mobile.experitest.cloud.ExperitestCloudDriver;
import com.etouch.taf.util.ConfigUtil;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class iOSDriver.
 */
public class IOSDriver extends DriverBuilder {

	/** The log. */
	private static Log log = LogUtil.getLog(IOSDriver.class);

	/**
	 * Instantiates a new i os driver.
	 *
	 * @param testBed the test bed
	 * @throws DriverException the driver exception
	 */
	public IOSDriver(TestBed testBed) throws DriverException {
		super(testBed);
		buildDriver();
		// TODO Auto-generated constructor stub
	}

	{

	}

	/* (non-Javadoc)
	 * @see com.etouch.taf.core.driver.DriverBuilder#buildDriver()
	 */
	@Override
	public void buildDriver() throws DriverException {
		try {
			if (ConfigUtil.isLocalEnv()) {

				if (ConfigUtil.isAppium()) {
					driver = AppiumDriver.buildIOSDriver(testBed);
				}
				else if(ConfigUtil.isExperiTest())
				{
					driver = ExperitestCloudDriver.buildDriver(testBed);
				}

			} else if (ConfigUtil.isRemoteEnv()) {

				DesiredCapabilities browser = new DesiredCapabilities(testBed
						.getDevice().getType().toString(), "", Platform.MAC);
				driver = new RemoteWebDriver(new URL(hubLocation), browser);

			} else if (ConfigUtil.isBrowserStackEnv()) {

				capabilities = DesiredCapabilities.android();
				capabilities.setCapability("device", testBed.getDevice()
						.getName());
				buildBrowserstackCapabilities();

			}

		} catch (MalformedURLException e) {
			log.error("failed to create driver for android : " + e.getMessage());
			throw new DriverException("Could not create driver :: "
					+ e.getMessage());
		}

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
