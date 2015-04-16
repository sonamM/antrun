/*
 * 
 */
package com.etouch.taf.core.config;

import java.util.List;

import com.etouch.taf.core.TestBed;

// TODO: Auto-generated Javadoc
/**
 * The Class TestBedConfig.
 */
public class TestBedConfig {
	
	//Web Related
	/** The test bed name. */
	private String testBedName;
	
	
	//Change Started
	/** The testbed class name. */
	private String[] testbedClassName;
	//Change Ends
	
	/** The device. */
	private DeviceConfig device;
	
	/** The browser. */
	private BrowserConfig browser;
	
	/** The platform. */
	private PlatformConfig platform;
	
	/** The app. */
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
	
	
	
	
	
//	private String  OS;
//	private String  OSVer;
//	private String   driver;
//	private String platform;
//	
//	private String app;
//	private String browserName;
//	private String browserVer;
//	private String newCommandTimeOut;
//	private String launch;
//	
//	
//	//iOS related
//	private String calendarFormat; 
//	private String deviceName; 	
//	private String language;	
//	private String launchTimeout ;	
//	private String locale;
//	
//	private String UDID;
//	private String bundleID;
//	
//	//Android related
//	private String appActivity;
//	private String appPackage;
//	private String appWaitActivity;
//	private String deviceReadyTimeout;
//	private String compressXml;
	
	/*public String getBrowserName() {
		return browserName;
	}
	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getBrowserVer() {
		return browserVer;
	}
	public void setBrowserVer(String browserVer) {
		this.browserVer = browserVer;
	}
	public String getOS() {
		return OS;
	}
	public void setOS(String oS) {
		OS = oS;
	}
	public String getOSVer() {
		return OSVer;
	}
	public void setOSVer(String oSVer) {
		OSVer = oSVer;
	}
	public String getDriver() {
		return driver;
	}
	
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getCalendarFormat() {
		return calendarFormat;
	}
	public void setCalendarFormat(String calendarFormat) {
		this.calendarFormat = calendarFormat;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getLaunchTimeout() {
		return launchTimeout;
	}
	public void setLaunchTimeout(String launchTimeout) {
		this.launchTimeout = launchTimeout;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getAppActivity() {
		return appActivity;
	}
	public void setAppActivity(String appActivity) {
		this.appActivity = appActivity;
	}
	public String getAppPackage() {
		return appPackage;
	}
	public void setAppPackage(String appPackage) {
		this.appPackage = appPackage;
	}
	public String getAppWaitActivity() {
		return appWaitActivity;
	}
	public void setAppWaitActivity(String appWaitActivity) {
		this.appWaitActivity = appWaitActivity;
	}
	public String getDeviceReadyTimeout() {
		return deviceReadyTimeout;
	}
	public void setDeviceReadyTimeout(String deviceReadyTimeout) {
		this.deviceReadyTimeout = deviceReadyTimeout;
	}
	public String getCompressXml() {
		return compressXml;
	}
	public void setCompressXml(String compressXml) {
		this.compressXml = compressXml;
	}
	public String getApp() {
		return app;
	}
	public void setApp(String app) {
		this.app = app;
	}
	public String getNewCommandTimeOut() {
		return newCommandTimeOut;
	}
	public void setNewCommandTimeOut(String newCommandTimeOut) {
		this.newCommandTimeOut = newCommandTimeOut;
	}
	public String getLaunch() {
		return launch;
	}
	public void setLaunch(String launch) {
		this.launch = launch;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getUDID() {
		return UDID;
	}
	public void setUDID(String uDID) {
		UDID = uDID;
	}
	public String getBundleID() {
		return bundleID;
	}
	public void setBundleID(String bundleID) {
		this.bundleID = bundleID;
	}*/
	





	
	
	

}
