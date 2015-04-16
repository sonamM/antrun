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
public class editReport extends BaseTest {
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
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditDataECU")
	public void editDataCalECU(TestParameters inputs) {
		try {
			System.out.println("Starting test case 43");
			mainPage.EditDataCalECU(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 44 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditPurchaseTab")
	public void editPurchaseTab(TestParameters inputs) {
		try {
			System.out.println("Starting test case 44");
			mainPage.EditPurchasetab(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 44 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 3)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditLeaseTab")
	public void editLeaseTab(TestParameters inputs) {
		try {
			System.out.println("Starting test case 45");
			mainPage.EditLeaseTab(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 45 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 4)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditLeaseTab")
	public void editLeaseTabReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 46");
			mainPage.EditReportLease(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 46 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 5)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditPurchaseTab")
	public void editPurchaseTabReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 47");
			mainPage.EditReportPurchase(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 47 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 6)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditLeaseTab")
	public void editLeaseTabReportDuplicate(TestParameters inputs) {
		try {
			System.out.println("Starting test case 48");
			mainPage.EditReportLeaseDuplicate(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 48 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 7)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditPurchaseTab")
	public void editPurchaseTabReportDuplicate(TestParameters inputs) {
		try {
			System.out.println("Starting test case 49");
			mainPage.EditReportPurchaseDuplicate(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 49 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 8)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditLeaseTab")
	public void editLeaseTabReportBlank(TestParameters inputs) {
		try {
			System.out.println("Starting test case 50");
			mainPage.EditReportLeaseBlank(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 50 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 9)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditPurchaseTab")
	public void editPurchaseTabReportBlank(TestParameters inputs) {
		try {
			System.out.println("Starting test case 51");
			mainPage.EditReportPurchaseBlank(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 51 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
	
	