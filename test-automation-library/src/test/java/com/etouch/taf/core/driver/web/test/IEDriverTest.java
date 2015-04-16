package com.etouch.taf.core.driver.web.test;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.config.BrowserConfig;
import com.etouch.taf.core.driver.web.IEDriver;
import com.etouch.taf.core.test.util.TafTestUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;

public class IEDriverTest {
	
	static Log log=LogUtil.getLog(IEDriverTest.class);
	TestBed testbed = null;

	@Before
	public void setUp()
	{
		TafTestUtil.initialize();
		
		testbed = new TestBed();
		BrowserConfig bcfg = new BrowserConfig();
		bcfg.setName("InternetExplorer");
		bcfg.setVersion("11");
		bcfg.setDriverLocation("..\\test-automation-library\\resources\\IEDriverServer.exe");
		testbed.setBrowser(bcfg);	 
	}
	
	@Test
	public void test() {
		try{
			IEDriver driverObj = new IEDriver(testbed);	
			driverObj.buildDriver();
			SoftAssertor.assertNotNull(driverObj.getDriver());		
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
	}

}
