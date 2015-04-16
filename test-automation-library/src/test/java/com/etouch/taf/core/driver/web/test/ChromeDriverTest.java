package com.etouch.taf.core.driver.web.test;


import junit.framework.TestCase;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.config.BrowserConfig;
import com.etouch.taf.core.driver.web.ChromeDriver;
import com.etouch.taf.core.test.util.TafTestUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;

public class ChromeDriverTest {
	
	static Log log=LogUtil.getLog(ChromeDriverTest.class);
	TestBed testbed = null;
	
	@Before
	public void setUp()
	{
		TafTestUtil.initialize();
		
		testbed = new TestBed();
		BrowserConfig bcfg = new BrowserConfig();
		bcfg.setName("Chrome");
		bcfg.setVersion("35");
		//bcfg.setDriverLocation("..\\test-automation-library\\resources\\chromedriver.exe");
		bcfg.setDriverLocation("/Users/sonamdeo/eTouch-local-git-latest-april2015/test-automation-version1/test-automation-library/resources/chromedriver");
		testbed.setBrowser(bcfg);	 
	}
	
	@Test
	public void test() {		
	try{
			ChromeDriver driverObj = new ChromeDriver(testbed);	
			driverObj.buildDriver();
			SoftAssertor.assertNotNull(driverObj.getDriver());		
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
	}
}

	
	