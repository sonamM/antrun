/*
 * 
 */
package com.etouch.taf.core;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;

import com.etouch.taf.core.config.AppConfig;
import com.etouch.taf.core.config.BrowserConfig;
import com.etouch.taf.core.config.DeviceConfig;
import com.etouch.taf.core.config.PlatformConfig;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * This class is primarily responsible for creating {@link WebDriver} 
 * This class holds information of testBed.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 */
public class TestBed {
		
		/** The log. */
		static Log log = LogUtil.getLog(TestBed.class);
		
		/** The Constant MaxWaitSeconds. */
		public static final int MaxWaitSeconds=60;
	
		/** The driver. */
		private Object driver = null;
		
		/** The testbed class name. */
		private String[] testbedClassName;
		
		/**  The test bed name such as IE, Chrome, iPad, Android. */
		private String testBedName;
		
		/**  All the device related information will be configured here. */
		private DeviceConfig device;
		
		/**  All the browser related information will be configured here. */
		private BrowserConfig browser;
		
		/**  All the Platform/OS related information will be configured here. */
		private PlatformConfig platform; 
		
		/**  All the App related information(Only for mobile Config) will be configured here. */
		private AppConfig app;
		
		
		
		/**
		 * Gets the test bed name.
		 *
		 * @return the test bed name
		 */
		public String getTestBedName() {
			return testBedName;
		}
		
		/**
		 * Sets the test bed name.
		 *
		 * @param testBedName the new test bed name
		 */
		public void setTestBedName(String testBedName) {
			this.testBedName = testBedName;
		}
		
		/**
		 * Gets the driver.
		 *
		 * @return the driver
		 */
		public Object getDriver() {
			return driver;
		}
		
		/**
		 * Sets the driver.
		 *
		 * @param driver the new driver
		 */
		public void setDriver(Object driver) {
			this.driver = driver;
		}
		
		/**
		 * Gets the testbed class name.
		 *
		 * @return the testbed class name
		 */
		public String[] getTestbedClassName() {
			return testbedClassName;
		}
		
		/**
		 * Sets the testbed class name.
		 *
		 * @param testbedClassName the new testbed class name
		 */
		public void setTestbedClassName(String[] testbedClassName) {
			this.testbedClassName = testbedClassName;
		}
		
		/**
		 * Gets the device.
		 *
		 * @return the device
		 */
		public DeviceConfig getDevice() {
			return device;
		}
		
		/**
		 * Sets the device.
		 *
		 * @param device the new device
		 */
		public void setDevice(DeviceConfig device) {
			this.device = device;
		}
		
		/**
		 * Gets the browser.
		 *
		 * @return the browser
		 */
		public BrowserConfig getBrowser() {
			return browser;
		}
		
		/**
		 * Sets the browser.
		 *
		 * @param browser the new browser
		 */
		public void setBrowser(BrowserConfig browser) {
			this.browser = browser;
		}
		
		/**
		 * Gets the platform.
		 *
		 * @return the platform
		 */
		public PlatformConfig getPlatform() {
			return platform;
		}
		
		/**
		 * Sets the platform.
		 *
		 * @param platform the new platform
		 */
		public void setPlatform(PlatformConfig platform) {
			this.platform = platform;
		}
		
		/**
		 * Gets the app.
		 *
		 * @return the app
		 */
		public AppConfig getApp() {
			return app;
		}
		
		/**
		 * Sets the app.
		 *
		 * @param app the new app
		 */
		public void setApp(AppConfig app) {
			this.app = app;
		}
		
		
		
	
}