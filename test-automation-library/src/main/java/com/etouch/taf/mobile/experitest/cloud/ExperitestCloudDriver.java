/*
 * 
 */
package com.etouch.taf.mobile.experitest.cloud;


import org.apache.commons.logging.Log;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.config.DeviceConfig;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.util.LogUtil;
import com.experitest.selenium.MobileWebDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class ExperitestCloudDriver.
 *
 * @author Lavanya Karanam
 */
public class ExperitestCloudDriver {
	
/** The log. */
private static Log log = LogUtil.getLog(ExperitestCloudDriver.class);
	
	/**
	 * Builds the driver.
	 *
	 * @param testBed the test bed
	 * @return the mobile web driver
	 * @throws DriverException Description: Below method creates the MobileWebDriver, which can be used to access Cloud devices.
	 */
	public static MobileWebDriver buildDriver(TestBed testBed) throws DriverException 
	{
		
		MobileWebDriver mobileWebDriver=null;
		TestBedManagerConfiguration tbMgrConfig=TestBedManagerConfiguration.getInstance();
		
		try{
				String host = tbMgrConfig.getMobileConfig().getHub();
				int port = Integer.parseInt(tbMgrConfig.getMobileConfig().getPort());				
				String projectBaseDirectory =  System.getProperty("user.dir")+"\\workspace\\project";	
				
				System.out.println(host+ " " + port + " "+ projectBaseDirectory);	
				
				mobileWebDriver = new MobileWebDriver(host, port, projectBaseDirectory,"xml", "reports", testBed.getTestBedName());
				
				if(testBed.getDevice()!=null)
					mobileWebDriver.setDevice(testBed.getDevice().getName());
			}catch (Exception ex) {
			log.error("Failed to create Mobile Web Driver : " + ex.getMessage());
			throw new DriverException("Could not create Mobile Webdriver :: " + ex.getMessage());
		}
		return  mobileWebDriver;
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[])
	{
		TestBed testBed = new TestBed();
		DeviceConfig deviceConfig = new DeviceConfig();
		deviceConfig.setName("ios: iphone");
		testBed.setDevice(deviceConfig);
		try{
		buildDriver(testBed);
		}catch(DriverException ex)
		{
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		
		
	}


}
