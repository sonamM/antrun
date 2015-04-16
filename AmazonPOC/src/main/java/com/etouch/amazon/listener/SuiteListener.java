/*
 * 
 */
package com.etouch.amazon.listener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.openqa.selenium.remote.server.DriverFactory;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.etouch.taf.core.driver.DriverManager;
import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.AppConfig;
import com.etouch.taf.core.config.BrowserConfig;
import com.etouch.taf.core.config.DeviceConfig;
import com.etouch.taf.core.config.PlatformConfig;
import com.etouch.taf.core.config.TestBedConfig;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.ConfigUtil;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving suite events.
 * The class that is interested in processing a suite
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addSuiteListener<code> method. When
 * the suite event occurs, that object's appropriate
 * method is invoked.
 *
 * @author eTouch Systems Corporation
 */

public class SuiteListener implements ISuiteListener {
	
	/** The log. */
	static Log log = LogUtil.getLog(SuiteListener.class);
	
	/** The page ur ls. */
	static public Properties pageURLs = null;
	
	/** The rally property file. */
	static public Properties rallyPropertyFile = null;
	
	/** The is initialize. */
	static boolean isInitialize=false;
	
    /* (non-Javadoc)
     * @see org.testng.ISuiteListener#onStart(org.testng.ISuite)
     */
    public void onStart(ISuite arg0) {

    	String testBedName=arg0.getParameter("testBedName");
    	TestBed testBed=loadTestBedDetails(testBedName);
    	try {
    		TestBedManager.INSTANCE.createDefectManager();
			TestBedManager.INSTANCE.setCurrentTestBed(testBed);
			CommonUtil.sop("testBedName "  + testBedName);
			testBed.setDriver(DriverManager.buildDriver(testBedName).getDriver());
			
		} catch (DriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	catch(DefectException e)
    	{
    		e.printStackTrace();
    	}
    	
    }
    
    
  
    
    /* (non-Javadoc)
     * @see org.testng.ISuiteListener#onFinish(org.testng.ISuite)
     */
    public void onFinish(ISuite arg0) {
    	log.info("Suite Name :"+ arg0.getName() + " - End");
    	log.info("********Results*******");
   
    }

    /**
     *  
     * Loads Web Testbed details from devConfig.xml
     *
     * @param testBedName the test bed name
     * @return the test bed
     */
    private static TestBed loadTestBedDetails(String testBedName){
		
		TestBed currentTestBed=null;
		TestBedManagerConfiguration testBedMgrConfig=TestBedManagerConfiguration.getInstance();
		if(ConfigUtil.isWebTestTypeEnabled()){
			for(TestBedConfig tbConfig:testBedMgrConfig.getWebConfig().getTestBeds()){
				
				CommonUtil.sop(" Current TestBedName " + testBedName + "tbConfig TestBedName " +tbConfig.getTestBedName() );
				if(tbConfig.getTestBedName().equalsIgnoreCase(testBedName)){
					currentTestBed=copyTestBedDetails(tbConfig);
					break;
				}
			}
		}
		if(ConfigUtil.isMobileTestTypeEnabled()){
		if(currentTestBed == null){
				for(TestBedConfig tbConfig:testBedMgrConfig.getMobileConfig().getTestBeds()){
					if(tbConfig.getTestBedName().equalsIgnoreCase(testBedName)){
						currentTestBed=copyTestBedDetails(tbConfig);
						break;
				}
			}
		}
		}
		return currentTestBed;
	}
	
  
    
    
	/**
	 * Copy test bed details.
	 *
	 * @param testBedConfig the test bed config
	 * @return the test bed
	 */
	private static TestBed copyTestBedDetails(TestBedConfig testBedConfig){
		TestBed currentTestBed = new TestBed();
		if(testBedConfig!=null){
			
			currentTestBed.setTestBedName(testBedConfig.getTestBedName());
			
			currentTestBed.setPlatform(testBedConfig.getPlatform());
			currentTestBed.setBrowser(testBedConfig.getBrowser());
			currentTestBed.setApp(testBedConfig.getApp());
			currentTestBed.setDevice(testBedConfig.getDevice());
			currentTestBed.setTestBedName(testBedConfig.getTestBedName());
			currentTestBed.setTestbedClassName(testBedConfig.getTestbedClassName());

			
		}
		
		return currentTestBed;
	}

    
}
