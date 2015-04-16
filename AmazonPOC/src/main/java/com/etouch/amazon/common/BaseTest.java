/*
 * 
 */
package com.etouch.amazon.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.xml.Parser;
import org.testng.xml.XmlSuite;
import org.xml.sax.SAXException;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.TestSuiteManager;
import com.etouch.taf.core.config.TestBedConfig;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.driver.DriverBuilder;
import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.core.exception.MonitorException;
import com.etouch.taf.core.exception.DriverException;
//import com.etouch.taf.core.monitor.gridmonitor.SeleniumMonitor;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;


// TODO: Auto-generated Javadoc
/**
 * Base test that all the test classes should extend.
 * This class initializes {@link TestBedManager} based on configuration file input
 *
 * @author eTouch Systems Corporation
 *
 */

public class BaseTest {

	/** The log. */
	static Log log = LogUtil.getLog(BaseTest.class);

	/** The test bed manager. */
	protected TestBedManager testBedManager = TestBedManager.INSTANCE;
	
	/** The test config file param. */
	private static String TEST_CONFIG_FILE_PARAM = "configFileName";
	
	/** The test suite file param. */
	private static String TEST_SUITE_FILE_PARAM ="testSuiteFileName";
	
	/** The test monitor file param. */
	private static String TEST_MONITOR_FILE_PARAM = "monitorFileName";
	
	/** The defect file. */
	private static String DEFECT_FILE = "defectFileName";
	
	/** The defect_properties_file. */
	protected static String defect_properties_file = null;

	/** The base url. */
	public String BASE_URL = null;
	
	/** The BAS e_ ur l2. */
	public String BASE_URL2 = null;
	
	/** The start time. */
	public long startTime = 0;
    
    /** The method num. */
    public int methodNum = 0;

    /**
     * Prints the time start.
     *
     * @param method the method
     */
	@BeforeMethod()
	public void printTimeStart(Method method) {
		methodNum = methodNum + 1;
		log.info("<.<.<.<.<.<.<.<.<.<.< Starting method " + methodNum + "::" + method.getName() + "<.<.<.<.<.<.<.<.<.<.<");
		startTime = System.currentTimeMillis();
	}

	/**
	 * Prints the time taken.
	 *
	 * @param method the method
	 */
	@AfterMethod()
	public void printTimeTaken(Method method) {
		log.info(">.>.>.>.>.>.>.>.>.>.>.>.> Ending method " + methodNum + "::" + method.getName() + ">.>.>.>.>.>.>.>.>.>.>.>.>Time Taken ::" + (System.currentTimeMillis() - startTime) / 1000
		        + " Seconds");
	}

//	public static void main(String args[]){
//		
//		String configFileName = "/Users/eTouch/Documents/workspace-eTaap/AmazonPOC/src/main/java/devConfig.yml";
//		InputStream in=null;
//		try {
//			in = convertFileToInputStream(configFileName);
//		} catch (DriverException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			TestBedManager.INSTANCE.setConfig(in);
//		} catch (DriverException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (DefectException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		try {
//			exceuteTestNGFile();
//		} catch (DriverException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DefectException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		System.out.println("Test Suites are completed");
//		
//	}
	
	/**
 * Setup config.
 *
 * @param configParameters the config parameters
 * @param browserName the browser name
 * @throws DriverException the driver exception
 * @throws DefectException the defect exception
 */
@BeforeSuite()
	
	private static void setupConfig(ITestContext configParameters,@Optional("FF")String browserName)
			throws DriverException, DefectException {
		
	}

	/**
	 * Convert file to input stream.
	 *
	 * @param fileName the file name
	 * @return the input stream
	 * @throws DriverException the driver exception
	 */
	private static InputStream convertFileToInputStream(String fileName) throws DriverException
	{
		InputStream ipStream=null;
		if(fileName != null){
			
			try {
				ipStream = new FileInputStream(new File(fileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}else{
			log.error(" File name is null - " + fileName);
			throw new DriverException(
					"failed to read profile configuration/TestNG, file name is missing");
		}
		return ipStream;
	}
	
	
	
	/**
	 * Load config.
	 *
	 * @throws DriverException the driver exception
	 * @throws DefectException the defect exception
	 */
	@BeforeClass(alwaysRun = true)
	public void loadConfig() throws DriverException, DefectException {
		

		//TODO: commented by Sophia Ghins
		//TestBedManagerConfiguration profile = new TestBedManagerConfiguration(configFile);
		//BASE_URL = profile.getBaseURL();
		//BASE_URL2 = profile.getBaseUrl2();

		//BASE_URL = testBedManager.getProfile().getBaseURL();
		//BASE_URL2 = testBedManager.getProfile().getBaseUrl2();
		
	}
	
	
		/**
		 * Tear down.
		 */
		@AfterClass(alwaysRun=true)
	public void tearDown(){
			
	DriverBuilder driver=(DriverBuilder)TestBedManager.INSTANCE.getCurrentTestBed().getDriver();		
	try {
		driver.wait(150000);
	} catch (Exception e) {
		log.error(e.getMessage());
	}
	//driver.close();
	//driver.quit();
			

	}

	/**
	 * Construct url.
	 *
	 * @param inputURL the input url
	 * @return the string
	 */
	public String constructURL(String inputURL)
	{
		if(inputURL.contains("<baseurl>"))
			inputURL = inputURL.replace("<baseurl>", BASE_URL);
		else if(inputURL.contains("<baseurl2>"))
			inputURL = inputURL.replace("<baseurl2>", BASE_URL2);

		return inputURL;
	}

	
	
	
	
}
