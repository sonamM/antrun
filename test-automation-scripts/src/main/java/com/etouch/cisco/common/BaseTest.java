package com.etouch.cisco.common;

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
import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.core.exception.MonitorException;
import com.etouch.taf.core.exception.ProfileBuilderException;
import com.etouch.taf.core.monitor.gridmonitor.SeleniumMonitor;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;


/**
 * Base test that all the test classes should extend.
 * This class initializes {@link TestBedManager} based on configuration file input
 *
 * @author eTouch Systems Corporation
 *
 */

public class BaseTest {

	static Log log = LogUtil.getLog(BaseTest.class);

	protected TestBedManager testBedManager = TestBedManager.INSTANCE;
	private static String TEST_CONFIG_FILE_PARAM = "configFileName";
	private static String TEST_SUITE_FILE_PARAM ="testSuiteFileName";
	private static String TEST_MONITOR_FILE_PARAM = "monitorFileName";
	private static String DEFECT_FILE = "defectFileName";
	protected static String defect_properties_file = null;

	public String BASE_URL = null;
	public String BASE_URL2 = null;
	public long startTime = 0;
    public int methodNum = 0;

    /**
     * @param method
     */
	@BeforeMethod()
	public void printTimeStart(Method method) {
		methodNum = methodNum + 1;
		log.info("<.<.<.<.<.<.<.<.<.<.< Starting method " + methodNum + "::" + method.getName() + "<.<.<.<.<.<.<.<.<.<.<");
		startTime = System.currentTimeMillis();
	}

	/**
	 * @param method
	 */
	@AfterMethod()
	public void printTimeTaken(Method method) {
		log.info(">.>.>.>.>.>.>.>.>.>.>.>.> Ending method " + methodNum + "::" + method.getName() + ">.>.>.>.>.>.>.>.>.>.>.>.>Time Taken ::" + (System.currentTimeMillis() - startTime) / 1000
		        + " Seconds");
	}

	public static void main(String args[]){
		
		//String configFileName="/Users/schmitzb/Documents/workspace/test-automation-scripts/src/main/java/devConfig.yml";
		String configFileName = "/Users/eTouch/git/test-automation/test-automation-scripts/src/main/java/devConfig.yml";
		//String configFileName = "C:\\Documents and Settings\\eTouch\\workspace\\test-automation-scripts-cisco\\src\\main\\java\\devConfig.yml";
		InputStream in=null;
		try {
			in = convertFileToInputStream(configFileName);
		} catch (ProfileBuilderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			TestBedManager.INSTANCE.setConfig(in);
		} catch (ProfileBuilderException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DefectException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			exceuteTestNGFile();
		} catch (ProfileBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DefectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Test Suites are completed");
		
	}
	
	@BeforeSuite()
	
	private static void setupConfig(ITestContext configParameters,@Optional("FF")String browserName)
			throws ProfileBuilderException, DefectException {
			
			
		
	}
	
	
	
	private static void readConfigurationFile(ITestContext configParameters) throws ProfileBuilderException, DefectException{
		// Hard coded file Name, Change it and read it from ConfigParameter later
		//String configFileName="/Users/schmitzb/Documents/workspace/test-automation-scripts/src/main/java/devConfig.yml";
		String configFileName="/Users/eTouch/git/test-automation/test-automation-scripts/src/main/java/devConfig.yml";
		InputStream in=convertFileToInputStream(configFileName);
		TestBedManager.INSTANCE.setConfig(in);
	}
	
	private static void exceuteTestNGFile() throws ProfileBuilderException, DefectException{
		// Hard coded file Name, Change it and read it from ConfigParameter later
		//String testNGFileName="C:\\Documents and Settings\\eTouch\\workspace\\test-automation-scripts-cisco\\src\\test\\resources\\testng.xml";
		//String testNGFileName="/Users/schmitzb/Documents/workspace/test-automation-scripts/src/test/resources/testng.xml";
		String testNGFileName="/Users/eTouch/git/test-automation/test-automation-scripts/src/test/resources/testng.xml";
		InputStream ipStream=convertFileToInputStream(testNGFileName);
		
		TestBedManager.INSTANCE.executeTestNG(ipStream);
	}
	
	
	private static InputStream convertFileToInputStream(String fileName) throws ProfileBuilderException
	{
		InputStream ipStream=null;
		if(fileName != null){
			
			try {
				ipStream = new FileInputStream(new File(fileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			log.error(" File name is null - " + fileName);
			throw new ProfileBuilderException(
					"failed to read profile configuration/TestNG, file name is missing");
		}
		return ipStream;
	}
	
	
	
	@BeforeClass(alwaysRun = true)
	public void loadConfig() throws ProfileBuilderException, DefectException {
		

		//TODO: commented by Sophia Ghins
		//TestBedManagerConfiguration profile = new TestBedManagerConfiguration(configFile);
		//BASE_URL = profile.getBaseURL();
		//BASE_URL2 = profile.getBaseUrl2();

		//BASE_URL = testBedManager.getProfile().getBaseURL();
		//BASE_URL2 = testBedManager.getProfile().getBaseUrl2();
		
	}
	
	
		@AfterClass(alwaysRun=true)
	public void tearDown(){
			
	WebDriver driver=(WebDriver)TestBedManager.INSTANCE.getCurrentTestBed().getDriver();		
	try {
		driver.wait(150000);
	} catch (Exception e) {
	}
	driver.close();
	driver.quit();
			

	}

	public String constructURL(String inputURL)
	{
		if(inputURL.contains("<baseurl>"))
			inputURL = inputURL.replace("<baseurl>", BASE_URL);
		else if(inputURL.contains("<baseurl2>"))
			inputURL = inputURL.replace("<baseurl2>", BASE_URL2);

		return inputURL;
	}

	
	
	
	// @BeforeSuite(alwaysRun = true)
		// public void testHubAndNodeAvailability(ITestContext configParameters){
		// SeleniumMonitor sm = new SeleniumMonitor();
		// Properties configProp = new Properties();
		// Properties prop = null;
		// long timeout = 60000;
		// String configFileName =
		// configParameters.getCurrentXmlTest().getParameter(TEST_CONFIG_FILE_PARAM);
		// //String configFileName = System.getProperty("fileName");
		// if(null == configFileName){
		// // Check on input from system property
		// configFileName = System.getProperty(TEST_CONFIG_FILE_PARAM);
		// }
		//
		// String monitorFile =
		// configParameters.getCurrentXmlTest().getParameter(TEST_MONITOR_FILE_PARAM);
		//
		// File configFile = new File(configFileName);
		// System.out.println(configFile.getAbsolutePath()
		// + " CONFIG FILE NAME:  " + configFileName);
		// FileReader configReader = null;
		// try {
		// configReader = new FileReader(configFile.getAbsolutePath());
		// if(configReader!=null){
		// configProp.load(configReader);
		// }
		//
		// prop = FileUtils.readPropertyFile(monitorFile);
		// //configProp = FileUtils.readPropertyFile(configFile);
		// } catch (FileNotFoundException e) {
		// Assert.fail("Property file not found. Message: " + e.getMessage());
		// } catch (IOException e) {
		// Assert.fail("Unable to read from property file. Message: " +
		// e.getMessage());
		// }
		//
		// HashMap<String,String> nodeRegMap= new HashMap<String,String>();
		// String remoteNodeHost = null;
		//
		// if(!configProp.getProperty("TEST_ENV").equals("browserstack")){
		// String hubURL = "http://" + configProp.getProperty("HUB") + ":" +
		// configProp.getProperty("PORT");
		// String hubCmdFile = prop.getProperty("HUB_CMD");
		//
		// if(configProp.getProperty("BROWSER").equals("FF")){
		// nodeRegMap.put(prop.getProperty("NODE1_URL"),
		// MessageFormat.format(prop.getProperty("Node_FF_CMD"), hubURL));
		// remoteNodeHost = prop.getProperty("NODE1_HOST");
		// }else if(configProp.getProperty("BROWSER").equals("Chrome")){
		// nodeRegMap.put(prop.getProperty("NODE2_URL"),
		// MessageFormat.format(prop.getProperty("NODE_CR_CMD"), hubURL));
		// remoteNodeHost = prop.getProperty("NODE2_HOST");
		// }else if(configProp.getProperty("BROWSER").equals("IE10")){
		// nodeRegMap.put(prop.getProperty("NODE3_URL"),
		// MessageFormat.format(prop.getProperty("NODE_IE10_CMD"), hubURL));
		// remoteNodeHost = prop.getProperty("NODE3_HOST");
		// }else if(configProp.getProperty("BROWSER").equals("IE9")){
		// nodeRegMap.put(prop.getProperty("NODE3_URL"),
		// MessageFormat.format(prop.getProperty("NODE_IE9_CMD"), hubURL));
		// remoteNodeHost = prop.getProperty("NODE3_HOST");
		// }else if(configProp.getProperty("BROWSER").equals("IE8")){
		// nodeRegMap.put(prop.getProperty("NODE3_URL"),
		// MessageFormat.format(prop.getProperty("NODE_IE8_CMD"), hubURL));
		// remoteNodeHost = prop.getProperty("NODE3_HOST");
		// }else{
		// Assert.fail("Invalid browser name specified in config file.");
		// }
		//
		// try {
		// if(!sm.isHubAvailable(hubURL)){
		// String remoteHost = configProp.getProperty("HUB_HOST");
		// sm.runSelOnRemoteMachine(remoteHost, hubCmdFile, hubURL);
		// }
		//
		// if(!sm.waitUntilHubAvailable(hubURL, timeout)){
		// Assert.fail("Unable to start the Hub.");
		// }
		//
		// for(String nurl: nodeRegMap.keySet()){
		// if(!sm.isNodeAvailable(hubURL, nurl)){
		// sm.runSelOnRemoteMachine(remoteNodeHost, nodeRegMap.get(nurl), nurl);
		// }
		// }
		//
		// if(!sm.waitUntilNodesAvailable(hubURL, nodeRegMap.keySet().toArray(new
		// String[nodeRegMap.size()]), timeout)){
		// Assert.fail("Unable to start node.");
		// }
		// } catch (IOException ex) {
		// Assert.fail(ex.getMessage());
		// }catch (MonitorException ex) {
		// Assert.fail(ex.getMessage());
		// }
		// }
		//
		// }

		// @BeforeSuite
		// public void setUpConfig(ITestContext configParameters) throws
		// ProfileBuilderException, DefectException{
		// log.info("Start - loadConfig");
		// String configFileName =
		// configParameters.getCurrentXmlTest().getParameter(TEST_CONFIG_FILE_PARAM);
		// log.info("Reading config file : " + configFileName);
		//
		//
		// if(null == configFileName){
		// configFileName = System.getProperty(TEST_CONFIG_FILE_PARAM);
		// }
		// configFileName="C:\\Users\\Rajeswari Thangavelu\\workspace\\test-automation-scripts\\src\\main\\java\\devConfig.yml";
		// log.info("Configuration file - " + configFileName);
		// defect_properties_file =
		// configParameters.getCurrentXmlTest().getParameter(DEFECT_FILE);
		//
		// testBedManager = TestBedManager.INSTANCE;
		// InputStream in=null;
		// try {
		// in = new FileInputStream(new File(configFileName));
		// } catch (FileNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// testBedManager.setConfig(in);
		// List<XmlSuite>
		// existingSuite=handleForExistingSuites(TEST_SUITE_FILE_PARAM);
		//
		//
		//
		// log.info("End - loadConfig");
		//
		// }
}
