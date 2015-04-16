/*
 * 
 */
package com.etouch.taf.core.driver.web;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.core.resources.TestEnvironmentType;
import com.etouch.taf.core.resources.TestToolType;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.ConfigUtil;
import com.etouch.taf.webui.selenium.SeleniumDriver;

// TODO: Auto-generated Javadoc
/**
 * Helps to build Firefox Driver firefox profile is not included yet.
 * 
 * @author eTouch
 */
public class FirefoxDriver extends WebDriver {

	/**
	 * Instantiates a new firefox driver.
	 * 
	 * @param testBed
	 *            the test bed
	 * @throws DriverException
	 *             the driver exception
	 */
	public FirefoxDriver(TestBed testBed) throws DriverException {
		super(testBed);
	}

	/**
	 * Builds Firefox Driver according to the given configuration values in
	 * config.yml
	 * 
	 * @throws DriverException
	 *             the driver exception
	 */
	@Override
	public void buildDriver() throws DriverException {

		if (ConfigUtil.isLocalEnv()) {
			// if tool is given devConfig.yml as Selenium, then create a
			// selenium FireFox driver
			if (ConfigUtil.isSelenium()) {
				driver = SeleniumDriver.buildFireFoxDriver();
			}
		} else if (ConfigUtil.isRemoteEnv()) {

			if (ConfigUtil.isSelenium()) {

				FirefoxProfile ffProfile = new FirefoxProfile();
				ffProfile.setEnableNativeEvents(false);
				capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability(
						org.openqa.selenium.firefox.FirefoxDriver.PROFILE,
						testBed);

			//	capabilities = DesiredCapabilities.();
				driver=SeleniumDriver.buildRemoteDriver(capabilities);
			}

		} else if (ConfigUtil.isBrowserStackEnv()) {
			capabilities = DesiredCapabilities.firefox();
			buildBrowserstackCapabilities();

		}
	}

	// TODO - include firefox profile
	/**
	 * This method will give an instance of FirefoxProfile Uncomment the code
	 * according to which firefox profile you want to create.
	 * 
	 * @return the firefox profile
	 */
	private FirefoxProfile getFirefoxProfile() {
		// File file = new File("firebug-1.8.1.xpi");
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		// firefoxProfile.addExtension(file);
		// firefoxProfile.setPreference("extensions.firebug.currentVersion",
		// "1.8.1"); // Avoid startup screen

		// FirefoxProfile fp = new FirefoxProfile();
		// fp.setPreference("webdriver.load.strategy", "unstable"); // As of
		// 2.19. from 2.9 - 2.18 use 'fast'

		return firefoxProfile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.etouch.taf.core.driver.DriverBuilder#getDriver()
	 */
	@Override
	public Object getDriver() throws DriverException {
		// TODO Auto-generated method stub
		return driver;
	}

	// More features has to be added
	// https://code.google.com/p/selenium/wiki/TipsAndTricks
}
