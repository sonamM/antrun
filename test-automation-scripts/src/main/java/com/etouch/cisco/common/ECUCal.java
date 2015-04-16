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
public class ECUCal extends BaseTest {
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
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CalECU")
	public void testValidECU(TestParameters inputs) {
		try {
			System.out.println("Starting test case 3");
			mainPage.ValidECU(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 3 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
/*
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CalInvalidECU")
	public void testInvalidECU(TestParameters inputs) {
		try {
			System.out.println("Starting test case 4");
			mainPage.invalidECU(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 4 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 3)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CalInvalidECU1")
	public void testInvalidECU1(TestParameters inputs) {
		try {
			System.out.println("Starting test case 5");
			mainPage.invalidECU(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 5 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 1)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CalBlankECU")
	public void testBlankECU(TestParameters inputs) {
		try {
			System.out.println("Starting test case 6");
			mainPage.invalidECU(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 6 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 4)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "MultipleECU")
	public void testMultipleECU(TestParameters inputs) {
		try {
			System.out.println("Starting test case 7");
			mainPage.multipleECU(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 7 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
}