/*
 * 
 */
package com.etouch.taf.util;

import org.apache.commons.logging.Log;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.core.resources.DefectToolType;
import com.etouch.taf.core.resources.PlatformType;
import com.etouch.taf.core.resources.TestEnvironmentType;
import com.etouch.taf.core.resources.TestToolType;
import com.etouch.taf.core.resources.TestTypes;
import com.etouch.taf.tools.defect.DefectManagerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class ConfigUtil.
 */
public class ConfigUtil {

	/** The log. */
	static Log log = LogUtil.getLog(ConfigUtil.class);

	/** The tb mgr config. */
	private static TestBedManagerConfiguration tbMgrConfig = TestBedManagerConfiguration
			.getInstance();
	
	/** The test environment. */
	private static String testEnvironment = tbMgrConfig.getWebConfig()
			.getTestEnv();

	/**
	 * If it is windows platform then return true.
	 *
	 * @param testBed the test bed
	 * @return true, if is windows
	 */
	public static boolean isWindows(TestBed testBed) {

		boolean result = false;

		if (testBed.getPlatform().getName()
				.equalsIgnoreCase(PlatformType.Windows.toString())) {
			result = true;
		}
		return result;
	}

	/**
	 * If it is Mac platform then return true.
	 *
	 * @param testBed the test bed
	 * @return true, if is mac
	 */
	public static boolean isMac(TestBed testBed) {

		boolean result = false;

		if (testBed.getPlatform().getName()
				.equalsIgnoreCase(PlatformType.Mac.toString())) {
			result = true;
		}
		return result;
	}

	/**
	 * If it is Linux platform then return true.
	 *
	 * @param testBed the test bed
	 * @return true, if is linux
	 */
	public static boolean isLinux(TestBed testBed) {

		boolean result = false;

		if (testBed.getPlatform().getName()
				.equalsIgnoreCase(PlatformType.Linux.toString())) {
			result = true;
		}
		return result;
	}

	
	/**
	 * If it is Android platform then return true.
	 *
	 * @param testBed the test bed
	 * @return true, if is android
	 */
	public static boolean isAndroid(TestBed testBed) {

		boolean result = false;

		if (testBed.getPlatform().getName()
				.equalsIgnoreCase(PlatformType.Android.toString())) {
			result = true;
		}
		return result;
	}

	/**
	 * If it is iOS platform then return true.
	 *
	 * @param testBed the test bed
	 * @return true, if is i os
	 */
	public static boolean isiOS(TestBed testBed) {

		boolean result = false;

		if (testBed.getPlatform().getName()
				.equalsIgnoreCase(PlatformType.iOS.toString())) {
			result = true;
		}
		return result;
	}

	/**
	 * If it is FirefoxOS platform then return true.
	 *
	 * @param testBed the test bed
	 * @return true, if is firefox os
	 */
	public static boolean isFirefoxOS(TestBed testBed) {

		boolean result = false;

		if (testBed.getPlatform().getName()
				.equalsIgnoreCase(PlatformType.FirefoxOS.toString())) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks whether testScripts are going to run again Local Environment or
	 * not.
	 *
	 * @return true, if is local env
	 */
	public static boolean isLocalEnv() {

		boolean result = false;

		if (TestEnvironmentType.LOCAL.getTestEnv().equals(testEnvironment)) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks whether testScripts are going to run again Remote Environment or
	 * not.
	 *
	 * @return true, if is remote env
	 */
	public static boolean isRemoteEnv() {

		boolean result = false;

		if (TestEnvironmentType.REMOTE.getTestEnv().equals(testEnvironment)) {
			result = true;
		}
		return result;
	}

	/**
	 * Checks whether testScripts are going to run again Remote Environment or
	 * not.
	 *
	 * @return true, if is browser stack env
	 */
	public static boolean isBrowserStackEnv() {

		boolean result = false;

		if (TestEnvironmentType.BROWSERSTACK.getTestEnv().equals(
				testEnvironment)) {
			result = true;
		}
		return result;
	}

	/**
	 * Check whether selenium is given for webTesting.
	 *
	 * @return true, if is selenium
	 */
	public static boolean isSelenium() {
		boolean result = false;
		if (tbMgrConfig.getWebConfig().getTool()
				.equalsIgnoreCase(TestToolType.Selenium.getTestToolType())) {
			result = true;
		}
		return result;
	}

	/**
	 * Check whether Appium is given for webTesting.
	 *
	 * @return true, if is appium
	 */
	public static boolean isAppium() {
		boolean result = false;
		if (tbMgrConfig.getMobileConfig().getTool()
				.equalsIgnoreCase(TestToolType.Appium.getTestToolType())) {
			result = true;
		}
		return result;
	}

	
	/**
	 * To check whether the WebTestType is included or not.
	 *
	 * @return true, if is web test type enabled
	 */
	public static boolean isWebTestTypeEnabled() {
		TestBedManagerConfiguration tbMgrConfig = TestBedManagerConfiguration
				.getInstance();
		boolean isWebEnabled = false;

		for (String testType : tbMgrConfig.getTestTypes()) {
			if (testType.equalsIgnoreCase(TestTypes.WEB.getTestType())) {
				isWebEnabled = true;
				break;
			}
		}

		return isWebEnabled;
	}

	
	/**
	 * To check whether the Mobile Test Types is included or not.
	 *
	 * @return true, if is mobile test type enabled
	 */
	public static boolean isMobileTestTypeEnabled() {
		TestBedManagerConfiguration tbMgrConfig = TestBedManagerConfiguration
				.getInstance();
		boolean isMobileEnabled = false;

		for (String testType : tbMgrConfig.getTestTypes()) {
			if (testType.equalsIgnoreCase(TestTypes.MOBILE.getTestType())) {
				isMobileEnabled = true;
				break;
			}
		}

		return isMobileEnabled;
	}

	
	/**
	 * Verifies weather the given defect tool is Supported by eTaap or not.
	 *
	 * @return boolean
	 * @throws DefectException the defect exception
	 */
	public static boolean isDefectToolSupported() throws DefectException {

		boolean result = false;
		String defectTool = TestBedManagerConfiguration.getInstance()
				.getDefectConfig().getDefectTool();

		// instantiate the appropriate defect tracking tool to be used
		if (defectTool != null) {
			if (!DefectToolType.isSupported(defectTool)) {
				log.error("The defect '" + defectTool + "' is not supported.");
				throw new DefectException("The defect '" + defectTool
						+ "' is not supported.");
			} else {
				result = true;
			}
		}
		return result;
	}
	
	/**
	 * Checks if is experi test.
	 *
	 * @return true, if is experi test
	 */
	public static boolean isExperiTest() {
		boolean result = false;
		if (tbMgrConfig.getMobileConfig().getTool()
				.equalsIgnoreCase(TestToolType.ExperiTest.getTestToolType())) {
			result = true;
		}
		return result;		
	}
	
}
