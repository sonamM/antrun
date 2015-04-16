package com.etouch.taf.core.driver.web.test;


import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.config.BrowserConfig;
import com.etouch.taf.core.driver.web.FirefoxDriver;
import com.etouch.taf.core.driver.web.SafariDriver;
import com.etouch.taf.core.test.util.TafTestUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;

public class SafariDriverTest{
	
	static Log log=LogUtil.getLog(SafariDriverTest.class);
	TestBed testbed = null;
	
	@Before
	public void setUp()
	{
		TafTestUtil.initialize();
		
		testbed = new TestBed();
		BrowserConfig bcfg = new BrowserConfig();
		bcfg.setName("Safari");
		bcfg.setVersion("2.28.0");
		testbed.setBrowser(bcfg);	 
	}
	
	@Test
	public void test() {		
	try{
			SafariDriver driverObj = new SafariDriver(testbed);	
			driverObj.buildDriver();
			SoftAssertor.assertNotNull(driverObj.getDriver());		
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
	}
}

	
	