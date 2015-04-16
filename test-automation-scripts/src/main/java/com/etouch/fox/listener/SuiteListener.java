package com.etouch.fox.listener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.TestBedConfig;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.exception.ProfileBuilderException;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;

/**
 * 
 * @author eTouch Systems Corporation
 *
 */

public class SuiteListener implements ISuiteListener {
	
	static Log log = LogUtil.getLog(SuiteListener.class);
	
	static public Properties pageURLs = null;
	static public Properties rallyPropertyFile = null;
	
    public void onStart(ISuite arg0) {
    	String testBedName=arg0.getParameter("testBedName");
    	TestBed testBed=loadTestBedDetails(testBedName);
    	try {
			TestBedManager.INSTANCE.setCurrentTestBed(testBed);
			System.out.println("testBedName "  + testBedName);
			testBed.createDriver(testBedName);
			
		} catch (ProfileBuilderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	//	Returns null if it runs locally
    }
    
    public void onFinish(ISuite arg0) {
    	log.info("Suite Name :"+ arg0.getName() + " - End");
    	log.info("********Results*******");
   
    }

    /** 
     * Loads Web Testbed details from devConfig.xml
     * @param testBedName
     * @return
     */
    private static TestBed loadTestBedDetails(String testBedName){
		
		TestBed currentTestBed=null;
		TestBedManagerConfiguration testBedMgrConfig=TestBedManagerConfiguration.getInstance();
		if(TestBedManager.INSTANCE.isWebTestTypeEnabled()){
			for(TestBedConfig tbConfig:testBedMgrConfig.getWebConfig().getTestBeds()){
				if(tbConfig.getTestBedName().equalsIgnoreCase(testBedName)){
					currentTestBed=copyTestBedDetails(tbConfig);
					break;
				}
			}
		}
		if(TestBedManager.INSTANCE.isMobileTestTypeEnabled()){
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
     * Loads Mobile Test Bed details from devConfig.xml
     * @param browserName
     * @return
     */
    private static TestBed loadMobileTestBedDetails(String browserName){
		
  		TestBed currentTestBed=null;
  		TestBedManagerConfiguration testBedMgrConfig=TestBedManagerConfiguration.getInstance();
  		for(TestBedConfig tbConfig:testBedMgrConfig.getMobileConfig().getTestBeds()){
  			if(tbConfig.getBrowserName().equalsIgnoreCase(browserName)){
  				currentTestBed=copyTestBedDetails(tbConfig);
  			}
  		}
  		
  		
  		return currentTestBed;
  	}
    
    
	private static TestBed copyTestBedDetails(TestBedConfig testBedConfig){
		TestBed currentTestBed = new TestBed();
		if(testBedConfig!=null){
			currentTestBed.setTestBedName(testBedConfig.getTestBedName());
			
			currentTestBed.setOS(testBedConfig.getOS());
			currentTestBed.setOSVer(testBedConfig.getOSVer());
			
			currentTestBed.setDriverName(testBedConfig.getDriver());
			
			currentTestBed.setApp(testBedConfig.getApp());
			currentTestBed.setBrowserName(testBedConfig.getBrowserName());
			currentTestBed.setBrowserVer(testBedConfig.getBrowserVer());
			currentTestBed.setNewCommandTimeOut(testBedConfig.getNewCommandTimeOut());
			currentTestBed.setLaunch(testBedConfig.getLaunch());
			
			
			//iOS related
			currentTestBed.setCalendarFormat(testBedConfig.getCalendarFormat()); 
			if(testBedConfig.getDeviceName()!= null ){
				currentTestBed.setDeviceName(testBedConfig.getDeviceName()); 	
			}else{
				currentTestBed.setDeviceName("");
			}
			currentTestBed.setLanguage(testBedConfig.getLanguage());	
			currentTestBed.setLaunchTimeout(testBedConfig.getLaunchTimeout ());	
			currentTestBed.setLocale(testBedConfig.getLocale());
			currentTestBed.setUDID(testBedConfig.getUDID());
			currentTestBed.setBundleID(testBedConfig.getBundleID());
			
			
			//Android related
			currentTestBed.setAppActivity(testBedConfig.getAppActivity());
			currentTestBed.setAppPackage(testBedConfig.getAppPackage());
			currentTestBed.setAppWaitActivity(testBedConfig.getAppWaitActivity());
			currentTestBed.setDeviceReadyTimeout(testBedConfig.getDeviceReadyTimeout());
			currentTestBed.setCompressXml(testBedConfig.getCompressXml());
			
		}
		
		return currentTestBed;
	}

    
}
