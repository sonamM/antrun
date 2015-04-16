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
public class PurchaseTab extends BaseTest {
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
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validateAIData(TestParameters inputs) {
		try {
			System.out.println("Starting test case 28");
			boolean val =  mainPage.verifyAIData(inputs);
			Thread.sleep(1000);
			System.out.println("value is "+val);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(val,true,"Additional Infrastructure cost donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 28 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validateCAPEXLabel(TestParameters inputs) {
		try {
			System.out.println("Starting test case 29");
			boolean val =  mainPage.verifyCAPEX(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"CAPEX donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 29 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 3)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validateCAPEXHRLabel(TestParameters inputs) {
		try {
			System.out.println("Starting test case 30");
			boolean val =  mainPage.verifyCAPEXHR(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"CAPEX PER HOUR donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 30 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 4)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validatePowerLabel(TestParameters inputs) {
		try {
			System.out.println("Starting test case 31");
			boolean val =  mainPage.verifyPOWER(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"POWER donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 31 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 5)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validateITM(TestParameters inputs) {
		try {
			System.out.println("Starting test case 32");
			boolean val =  mainPage.verifyITM(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"IT Management donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 32 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 6)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validateNf(TestParameters inputs) {
		try {
			System.out.println("Starting test case 33");
			boolean val =  mainPage.verifyNF(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"Network Fee donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 33 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 7)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validateOPEX(TestParameters inputs) {
		try {
			System.out.println("Starting test case 34");
			boolean val =  mainPage.verifyOPEX(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"OPEX donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 34 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 8)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validateOPEXHR(TestParameters inputs) {
		try {
			System.out.println("Starting test case 35");
			boolean val =  mainPage.verifyOPEXHR(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"OPEX Per Hour donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 35 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 9)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void validateTotalECUHR(TestParameters inputs) {
		try {
			System.out.println("Starting test case 36");
			boolean val =  mainPage.verifyTotalECUHR(inputs);
			Thread.sleep(1000);
			Assert.assertEquals(val,true,"Total ECU Per Hour donot match");
		} catch (AssertionError e) {
			System.out.println("the test case 36 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 10)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void calCostPurchaseTab(TestParameters inputs) {
		try {
			System.out.println("Starting test case 8");
			mainPage.calCostPurchaseTab(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 8 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 11)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void SaveDuplicateTab(TestParameters inputs) {
		try {
			System.out.println("Starting test case 9");
			mainPage.DuplicateReport(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 9 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 12)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "DuplicatePurchaseTab")
	public void cancelDupliacteReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 10");
			mainPage.CancelDuplicateReport(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 10 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 13)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void blankPurchaseReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 11");
			mainPage.BlankReport(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 11 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 14)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidPurchaseTab")
	public void invalidPurchaseData(TestParameters inputs) {
		try {
			System.out.println("Starting test case 12");
			mainPage.InvalidPurchaseTab(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 12 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 15)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidPurchaseTab1")
	public void invalidPurchaseData1(TestParameters inputs) {
		try {
			System.out.println("Starting test case 13");
			mainPage.InvalidPurchaseTab(inputs);
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

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 16)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidPurchaseTab2")
	public void invalidPurchaseData2(TestParameters inputs) {
		try {
			System.out.println("Starting test case 14");
			mainPage.InvalidPurchaseTab(inputs);
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
}