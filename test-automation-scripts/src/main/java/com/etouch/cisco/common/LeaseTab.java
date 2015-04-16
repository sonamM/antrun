package com.etouch.cisco.common;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.TestParameters;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.core.resources.ObjectValType;
import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.util.LogUtil;
import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.common.pages.CommonPage;
import com.etouch.taf.webui.selenium.webelement.*;
import com.etouch.taf.webui.selenium.WebPage;

@IExcelDataFiles(excelDataFiles = { "file1=src/test/resources/testdata/cisco.xls" })
public class LeaseTab extends BaseTest {
	private static Log log = LogUtil.getLog(ECUCal.class);
	private String url = "https://tools-stage-was7.cisco.com/wsrp/pwc019/mobile/view";
	private CiscoMainPage mainPage;

	@BeforeClass
	public void prepareBeforeClass() throws Exception {
		try {
			WebPage webPage = new WebPage();
			mainPage = new CiscoMainPage(url, webPage);
		} catch (Exception e) {
			System.out.println("error is " + e);
		}
	}
	
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 1)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
	public void validateHWCostHR(TestParameters inputs) {
		try {
			System.out.println("Starting test case 37");
			boolean val =  mainPage.verifyHWCost(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"Hardware Cost Per Hour donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 37 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
	public void validatePowerLease(TestParameters inputs) {
		try {
			System.out.println("Starting test case 38");
			boolean val =  mainPage.verifyPower(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"Power cost donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 38 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 3)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
	public void validateITMLease(TestParameters inputs) {
		try {
			System.out.println("Starting test case 39");
			boolean val =  mainPage.verifyITMLease(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"Total IT Management Hours donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 39 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 4)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
	public void validateNFLease(TestParameters inputs) {
		try {
			System.out.println("Starting test case 40");
			boolean val =  mainPage.verifyNFLease(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"Network Fee Per Hour donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 40 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 5)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
	public void validateOPEXHRLease(TestParameters inputs) {
		try {
			System.out.println("Starting test case 41");
			boolean val =  mainPage.verifyOPEXHRLease(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"Total OPEX Per Hour donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 41 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 6)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
	public void validateECULease(TestParameters inputs) {
		try {
			System.out.println("Starting test case 42");
			boolean val =  mainPage.verifyECUHRLease(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"Total ECU Per Hour donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 42 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 7)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
	public void blankLeasereport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 13");
			mainPage.blankLeaseReport(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 13 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 8)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidLease")
	public void invalidLease(TestParameters inputs) {
		try {
			System.out.println("Starting test case 14");
			mainPage.invalidLease(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 14 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 9)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidLease1")
	public void invalidLease1(TestParameters inputs) {
		try {
			System.out.println("Starting test case 15");
			mainPage.invalidLease(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 15 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 10)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidLease2")
	public void invalidLease2(TestParameters inputs) {
		try {
			System.out.println("Starting test case 16");
			mainPage.invalidLease(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 16 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 11)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "DuplicateLease")
	public void SaveDuplicateLeaseReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 17");
			mainPage.DuplicateLeaseReport(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 17 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 12)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "DuplicateLease")
	public void cancelDuplicateLeaseReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 18");
			mainPage.cancelDuplicateLeaseReport(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 18 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}