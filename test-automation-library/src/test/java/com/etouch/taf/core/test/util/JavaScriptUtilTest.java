package com.etouch.taf.core.test.util;

import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.BrowserConfig;
import com.etouch.taf.core.exception.DriverException;
//import com.etouch.taf.core.driver.web.ChromeDriver;
//import com.etouch.taf.core.driver.web.test.ChromeDriverTest;
import com.etouch.taf.util.*;
import com.etouch.taf.webui.selenium.SeleniumDriver;

public class JavaScriptUtilTest {
	static Log log=LogUtil.getLog(JavaScriptUtilTest.class);
	TestBed testbed = null;
	private WebDriver driverObj = null;
	
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
		TestBedManager.INSTANCE.setCurrentTestBed(testbed);
	}

	@Test
	public void test() {
		try{
				File file = new File(testbed.getBrowser().getDriverLocation());
				driverObj = SeleniumDriver.buildChromeDriver(file);	
				String javascript = "console.log(\"Hello JavaSCript\")";
				WebElement  webElement  = JavaScriptUtil.executeJavaScript(driverObj, javascript);
				Assert.assertNotNull(webElement);
			
			}catch(Exception ex)
			{
				ex.printStackTrace();
				log.error(ex.getMessage());
			}
	}
	
	@After
	public void tearDown()
	{
		try {
			driverObj.wait(150000);
		} catch (Exception e) {
			//SoftAssertor.addVerificationFailure(e.getMessage());
		}
		driverObj.close();
		driverObj.quit();
	}

}
