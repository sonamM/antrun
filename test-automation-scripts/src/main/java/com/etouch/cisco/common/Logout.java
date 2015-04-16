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
public class Logout extends BaseTest {
	private static Log log = LogUtil.getLog(Logout.class);
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
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LogOut")
	public void logout(TestParameters inputs) {
		try {
			System.out.println("Starting test case 29");
			mainPage.Logout(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 29 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LogOutCancel")
	public void logoutCancel(TestParameters inputs) {
		try {
			System.out.println("Starting test case 30");
			mainPage.LogoutCancel(inputs);
			Thread.sleep(1000);
			String actualURL = mainPage.getPageUrl();
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 30 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}