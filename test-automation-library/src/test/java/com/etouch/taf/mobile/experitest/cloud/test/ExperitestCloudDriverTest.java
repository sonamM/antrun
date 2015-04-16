package com.etouch.taf.mobile.experitest.cloud.test;


import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.config.DeviceConfig;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.core.test.util.TafTestUtil;
import com.etouch.taf.mobile.experitest.cloud.ExperitestCloudDriver;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;
import com.experitest.selenium.MobileWebDriver;


public class ExperitestCloudDriverTest {

	private static Log log = LogUtil.getLog(ExperitestCloudDriver.class);
	MobileWebDriver mwbDriver = null;
	TestBed testbed =null;
	
	@Before
	public void setUp()
	{

		TafTestUtil.initialize();		
		testbed = new TestBed();		
	}	
	
	@Test
	public void testIOS() {
		CommonUtil.sop("Inside ExperiTestCloudDriverTest test method 1");	
		DeviceConfig deviceConfig = new DeviceConfig();
		deviceConfig.setName("ios: iphone");
		testbed.setDevice(deviceConfig);
		try{
			mwbDriver =  ExperitestCloudDriver.buildDriver(testbed);
			SoftAssertor.assertNotNull(mwbDriver);
		}catch(DriverException ex)
		{
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	@Test
	public void testAndroid()
	{
		CommonUtil.sop("Inside ExperiTestCloudDriverTest test method 2");	
		DeviceConfig deviceConfig = new DeviceConfig();
		deviceConfig.setName("Nexus_4.4.2_19");
		testbed.setDevice(deviceConfig);
		
		try{
			mwbDriver =  ExperitestCloudDriver.buildDriver(testbed);
			SoftAssertor.assertNotNull(mwbDriver);
		}catch(DriverException ex)
		{
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
		
	}
	

}
