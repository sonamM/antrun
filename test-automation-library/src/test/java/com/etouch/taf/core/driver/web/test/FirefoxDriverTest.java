package com.etouch.taf.core.driver.web.test;


import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.config.BrowserConfig;
import com.etouch.taf.core.driver.web.FirefoxDriver;
import com.etouch.taf.core.test.util.TafTestUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;

public class FirefoxDriverTest{
	
	static Log log=LogUtil.getLog(FirefoxDriverTest.class);
	TestBed testbed = null;
	
	@Before
	public void setUp()
	{
		TafTestUtil.initialize();
		
		testbed = new TestBed();
		BrowserConfig bcfg = new BrowserConfig();
		bcfg.setName("Firefox");
		bcfg.setVersion("25");	
		testbed.setBrowser(bcfg);	 
	}
	
	@Test
	public void test() {		
	try{
			FirefoxDriver driverObj = new FirefoxDriver(testbed);	
			driverObj.buildDriver();
			SoftAssertor.assertNotNull(driverObj.getDriver());		
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
	}
}

	
	