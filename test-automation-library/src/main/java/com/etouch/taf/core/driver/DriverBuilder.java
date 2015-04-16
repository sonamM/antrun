/*
 * 
 */
package com.etouch.taf.core.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.core.resources.TestBedType;
import com.etouch.taf.core.resources.TestEnvironmentType;
import com.etouch.taf.util.LogUtil;

import org.apache.commons.logging.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.Platform;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class DriverBuilder.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 */
public abstract class DriverBuilder {

	/** The tb mgr config. */
	protected TestBedManagerConfiguration tbMgrConfig=TestBedManagerConfiguration.getInstance();
	
	/** The test bed. */
	protected TestBed testBed = TestBedManager.INSTANCE.getCurrentTestBed();
	
	/** The hub location. */
	protected String hubLocation=null;
	
	/** The capabilities. */
	protected DesiredCapabilities capabilities=null;
	
	/** The driver. */
	protected Object driver=null;
	
	/** The browser stack url. */
	protected String browserStackURL = null;
	
	/** The test environment. */
	protected String testEnvironment= tbMgrConfig.getWebConfig().getTestEnv();
	
	/** The log. */
	static Log log = LogUtil.getLog(DriverBuilder.class);

	/**
	 * Instantiates a new driver builder.
	 *
	 * @param testBed the test bed
	 * @throws DriverException the driver exception
	 */
	public DriverBuilder(TestBed testBed) throws DriverException {
		this.testBed = testBed;
	}

	 /**
 	 * Builds the driver.
 	 *
 	 * @throws DriverException the driver exception
 	 */
	public abstract void buildDriver() throws DriverException;
	 
	 /**
 	 * Gets the driver.
 	 *
 	 * @return Object of an Driver
 	 * @throws DriverException the driver exception
 	 */
	public abstract Object getDriver() throws DriverException;


	


	/**
	 * This method set the details for BrowserStackDriver.
	 *
	 * @throws DriverException the driver exception
	 */
	public void buildBrowserstackCapabilities() throws DriverException
	{
		capabilities.setCapability("osVersion", testBed.getPlatform().getVersion());
		capabilities.setCapability("os", testBed.getPlatform().getName());
		capabilities.setCapability("version", testBed.getBrowser().getVersion());
		capabilities.setCapability("browserName", testBed.getBrowser().getName());
		capabilities.setCapability("browserstack.debug", "true");
		try {
			driver = new RemoteWebDriver(new URL(buildBrowserStackUrl()), capabilities);
		} catch (MalformedURLException e) {
			log.error("failed to create driver : " + e.getMessage());
			throw new DriverException("failed to create driver : " + e.getMessage());
		}

	}
	
	
	/**
	 * Builds the url.
	 *
	 * @return the string
	 */
	protected  String buildURL() {
		TestBedManagerConfiguration tbMgrConfig=TestBedManagerConfiguration.getInstance();
		String hub = tbMgrConfig.getWebConfig().getHub();
		String port = tbMgrConfig.getWebConfig().getPort();
		
		TestBed testBed=TestBedManager.INSTANCE.getCurrentTestBed();

		// defalut hub to localhost
		if (hub == null || hub.isEmpty()) {
			hub = "localhost";
		}

		// default port to 4444
		if (port == null || port.isEmpty()) {
			port = "4444";
		}
		
		 hubLocation = "http://" + hub + ":" + port + "/wd/hub";

		// add proxy setting to the webdriver
		String proxyString = tbMgrConfig.getWebConfig().getProxy();
		String noProxyString = tbMgrConfig.getWebConfig().getNoProxy();
		if (proxyString != null && !proxyString.isEmpty()) {
			Proxy proxysetting = new Proxy();
			proxysetting.setHttpProxy(proxyString)
					.setFtpProxy(proxyString).setSslProxy(proxyString);
			if (noProxyString != null && !proxyString.isEmpty()) {
				proxysetting.setNoProxy(noProxyString);
			}

			capabilities.setCapability(CapabilityType.PROXY,
					proxysetting);
		}
		
		return hubLocation;
	}
	

	
	/**
	 * Get the BrowserStackURL from configuration file.
	 *
	 * @return browserStackURL
	 */
	public String buildBrowserStackUrl(){
		return browserStackURL;
	}
	
	
}
