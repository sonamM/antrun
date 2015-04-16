/*
 * 
 */
package com.etouch.taf.core.driver.web;

import java.io.File;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.driver.DriverBuilder;
import com.etouch.taf.core.driver.DriverConstantUtil;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.core.resources.TestEnvironmentType;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.ConfigUtil;
import com.etouch.taf.webui.selenium.SeleniumDriver;

// TODO: Auto-generated Javadoc
/**
 * The Class ChromeDriver.
 */
public class ChromeDriver extends DriverBuilder{

	/**
	 * Instantiates a new chrome driver.
	 *
	 * @param testBed the test bed
	 * @throws DriverException the driver exception
	 */
	public ChromeDriver(TestBed testBed)
			throws DriverException {
		super(testBed);
		//buildDriver();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Creates driver for Chrome.
	 *
	 * @throws DriverException the driver exception
	 */
	@Override
	public void buildDriver() throws DriverException
	{
		if(ConfigUtil.isLocalEnv())
		{
			// if it is a Selenium tool, then create selenium ChromeDriver
			if(ConfigUtil.isSelenium()){
				
				File chromeDriverFile=getChromeDriverFile();
				System.out.println(" Found Driver file");
				driver =SeleniumDriver.buildChromeDriver(chromeDriverFile);
				 //new org.openqa.selenium.chrome.ChromeDriver();
				
			}
			
		}
		else if(ConfigUtil.isRemoteEnv())
		{
			if(ConfigUtil.isSelenium()){
				capabilities = DesiredCapabilities.chrome();	
				driver = SeleniumDriver.buildRemoteDriver(capabilities);
			}
			
			
		}
		else if(ConfigUtil.isBrowserStackEnv())
		{
			capabilities = DesiredCapabilities.chrome();
			buildBrowserstackCapabilities();

		}

	}
	
	
	/**
	 * This method returns Driver file for Chrome Driver
	 * If is in mentioned in config.yml then set that as system property
	 * otherwise, use the defaults Chromedriver from library based on the given platform
	 *
	 * @return the chrome driver file
	 */
	public File getChromeDriverFile(){
		
		File file=null;
		if(testBed.getBrowser().getDriverLocation()!=null){
			
			file =new File(testBed.getBrowser().getDriverLocation());
		
		}else{
			if(ConfigUtil.isWindows(testBed))
			{
				//TODO have to remove the hard coded values
				//file = new File("..\\test-automation-library\\resources\\chromedriver.exe");
				file = new File(DriverConstantUtil.CHROME_WINDOWS_DRIVER_FILE);
			}
			else
			{
				file = new File(DriverConstantUtil.CHROME_MAC_DRIVER_FILE);
				//file = new File("/Users/sonamdeo/git/test-automation/test-automation-library/resources/chromedriver");
			}
		}
		
		return file;
	}

	/* (non-Javadoc)
	 * @see com.etouch.taf.core.driver.DriverBuilder#getDriver()
	 */
	@Override
	public Object getDriver() throws DriverException {
		return driver;
	}

}
