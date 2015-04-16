package com.etouch.cisco.common;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.xml.bind.ParseConversionEvent;

import org.apache.commons.logging.Log;
import org.apache.poi.ss.usermodel.Textbox;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

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
import com.etouch.cisco.pages.elements.MainPageElements;
import com.etouch.fox.common.pages.CommonPage;
import com.etouch.taf.webui.selenium.webelement.*;
import com.etouch.taf.webui.selenium.WebPage;

public class CiscoMainPage extends CommonPage {
	private static Log log = LogUtil.getLog(CiscoMainPage.class);
	String compName = null;
	private WebDriver webDriver;
	private JavascriptExecutor jsx;
	private float totalECU;
	DecimalFormat df = new DecimalFormat("###.##"); 
	

	public CiscoMainPage(String sbPageUrl, WebPage webPage) {
		super(sbPageUrl, webPage);
		webDriver = webPage.getDriver();
		jsx = (JavascriptExecutor) webDriver;
		if((TestBedManager.INSTANCE.getCurrentTestBed().getDeviceName()==null)
				||(TestBedManager.INSTANCE.getCurrentTestBed().getDeviceName().isEmpty())){
			loadPage();
		}
	}

	public String getPageUrl() {
		return webPage.getCurrentUrl();
	}

	public void setCompName(String n) {
		compName = n;

	}

	public String getCompName() {
		return compName;
	}

	public void SignIn(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 20;
		try {
			if((TestBedManager.INSTANCE.getCurrentTestBed().getDeviceName()==null)||
					TestBedManager.INSTANCE.getCurrentTestBed().getDeviceName().isEmpty()){
		
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.UName_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("uname"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.PWD_ID, ObjectValType.ID, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwd"));
			((Button) webPage.findObject(ObjectType.Button,
					MainPageElements.Login_BTN_ID, ObjectValType.ID, MAX_WAIT,
					WaitCondition.CLICKABLE)).click();
			}
			else if(TestBedManager.INSTANCE.getCurrentTestBed().getDeviceName().equalsIgnoreCase("Android"))
			{
				WebDriver driver=(WebDriver)TestBedManager.INSTANCE.getCurrentTestBed().getDriver();
				driver.findElement(By.id(MainPageElements.UName_ID)).sendKeys(input.getParamMap().get("uname"));
				driver.findElement(By.id(MainPageElements.PWD_ID)).sendKeys(input.getParamMap().get(
						"pwd"));
				driver.findElement(By.id(MainPageElements.Login_BTN_ID)).click();
			}
			
			////////webPage.sleep(100);
		} catch (Exception e) {
			log.error(getErrMessage());
			System.out.println("Error: " + getErrMessage());
		}
	}

	public void InvalidSignIn(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 20;
		try {
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.UName_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("uname"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.PWD_ID, ObjectValType.ID, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwd"));
			((Button) webPage.findObject(ObjectType.Button,
					MainPageElements.Login_BTN_ID, ObjectValType.ID, MAX_WAIT,
					WaitCondition.CLICKABLE)).click();
			////////webPage.sleep(100);

		} catch (Exception e) {
			log.error(getErrMessage());
			System.out.println("Error: " + getErrMessage());
		}
	}

	public void validECUvalidation(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			webPage.findObject(ObjectType.Image,
					MainPageElements.Back_XPATH, ObjectValType.XPATH)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ServerCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("servercount"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CPUCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cpucount"));
			((SelectBox) webPage.findObject(ObjectType.SelectBox, "selectCpu",
					ObjectValType.ID, MAX_WAIT, WaitCondition.VISIBLE)).click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}
	
	public void ValidECU(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		String tempecu = "";
		try {
			//SignIn(input);
			jsx.executeScript("window.document.getElementById('newCalculation').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ServerCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("servercount"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CPUCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cpucount"));

			// testing kanika - start
			WebElement table = webDriver.findElement(By
					.id(MainPageElements.TotalECU_ID));
			List<WebElement> allRows = table.findElements(By.tagName("tr"));
			for (WebElement row : allRows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
				for (WebElement colElement : cells) {
					tempecu = colElement.getText();
				}
			}
			totalECU = Float.parseFloat(tempecu);
			// testing kanika - end
			((SelectBox) webPage.findObject(ObjectType.SelectBox, "selectCpu",
					ObjectValType.ID, MAX_WAIT, WaitCondition.VISIBLE)).selectDropDownList("E5-2650 v2");
			// jsx.executeScript("document.getElementById('calculate').click()");
			//////webPage.sleep(100);
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void multipleECU(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			jsx.executeScript("window.document.getElementById('newCalculation').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ServerCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("servercount"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CPUCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cpucount"));
			((SelectBox) webPage.findObject(ObjectType.SelectBox, "selectCpu",
					ObjectValType.ID, MAX_WAIT, WaitCondition.VISIBLE)).click();
			jsx.executeScript("document.getElementById('addServer').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CPUCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cpucount1"));
			((SelectBox) webPage.findObject(ObjectType.SelectBox, "selectCpu",
					ObjectValType.ID, MAX_WAIT, WaitCondition.VISIBLE)).click();
			// jsx.executeScript("document.getElementById('calculate').click()");
			//////webPage.sleep(100);
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void invalidECU(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			////SignIn(input);
			jsx.executeScript("window.document.getElementById('newCalculation').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ServerCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("servercount"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CPUCount_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cpucount"));
			((SelectBox) webPage.findObject(ObjectType.SelectBox, "selectCpu",
					ObjectValType.ID, MAX_WAIT, WaitCondition.VISIBLE)).click();
			
			//jsx.executeScript("document.getElementById('calculate').click()");
			//////webPage.sleep(100);
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void calCostPurchaseTab(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			String name = input.getParamMap().get("reportname")+"_"+new Random().nextInt(10000);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("itmgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NetworkFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("ntwkfee"));
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ReportName_XPATH, ObjectValType.XPATH))
					.enterText(name);
			webPage.findObject(ObjectType.Link, "Save", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void DuplicateReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostPurchaseTab(input);
			webPage.findObject(ObjectType.Link, "Yes", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void CancelDuplicateReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//String name = input.getParamMap().get("reportname")+"_"+new Random().nextInt(10000);
			calCostPurchaseTab(input);
			webPage.findObject(ObjectType.Link, "Cancel", ObjectValType.LINK)
					.click();
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ReportName_XPATH, ObjectValType.XPATH))
					.enterText(input.getParamMap().get("newreport"));
			webPage.findObject(ObjectType.Link, "Save", ObjectValType.LINK)
					.click();

		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void BlankReport(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("itmgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NetworkFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("ntwkfee"));
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ReportName_XPATH, ObjectValType.XPATH))
					.enterText(input.getParamMap().get("rprtname"));
			webPage.findObject(ObjectType.Link, "Save", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void InvalidPurchaseTab(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("itmgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NetworkFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("ntwkfee"));
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void calCostLeaseTab(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			String name = input.getParamMap().get("report")+"_"+new Random().nextInt(10000);
			
			SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("fee"));
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ReportName_XPATH, ObjectValType.XPATH))
					.enterText(name);
			webPage.findObject(ObjectType.Link, "Save", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void blankLeaseReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("fee"));
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ReportName_XPATH, ObjectValType.XPATH))
					.enterText(input.getParamMap().get("rprt"));
			webPage.findObject(ObjectType.Link, "Save", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void invalidLease(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			////SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("fee"));
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void DuplicateLeaseReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			////SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("fee"));
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ReportName_XPATH, ObjectValType.XPATH))
					.enterText(input.getParamMap().get("reportname"));
			webPage.findObject(ObjectType.Link, "Save", ObjectValType.LINK)
					.click();
			webPage.findObject(ObjectType.Link, "Yes", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void cancelDuplicateLeaseReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			////SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("fee"));
			webPage.findObject(ObjectType.Link, "Create Report",
					ObjectValType.LINK).click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ReportName_XPATH, ObjectValType.XPATH))
					.enterText(input.getParamMap().get("rpt"));
			webPage.findObject(ObjectType.Link, "Save", ObjectValType.LINK)
					.click();
			webPage.findObject(ObjectType.Link, "Yes", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void sharePurchaseReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostPurchaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();

			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			webPage.findObject(ObjectType.Link, "Send Report",
					ObjectValType.LINK).click();
			webPage.findObject(ObjectType.Link, "Ok", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void shareCancelPurchaseReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostPurchaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();

			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			webPage.findObject(ObjectType.Link, "Cancel", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void shareLeaseReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostLeaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();

			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			webPage.findObject(ObjectType.Link, "Send Report",
					ObjectValType.LINK).click();
			webPage.findObject(ObjectType.Link, "Ok", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void shareCancelLeaseReport(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostLeaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();

			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			webPage.findObject(ObjectType.Link, "Cancel", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void shareBlankToLease(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostLeaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			webPage.findObject(ObjectType.Link, "Send Report",
					ObjectValType.LINK).click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void shareBlankToPurchase(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostPurchaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			webPage.findObject(ObjectType.Link, "Send Report",
					ObjectValType.LINK).click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void shareBlankLease(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostLeaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			webPage.findObject(ObjectType.Link, "Send Report",
					ObjectValType.LINK).click();
			webPage.findObject(ObjectType.Link, "Ok", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void shareBlankPurchase(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			calCostPurchaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			webPage.findObject(ObjectType.Link, "Ok", ObjectValType.LINK)
					.click();
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void Logout(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			////SignIn(input);
			webPage.findObject(ObjectType.Image,
					MainPageElements.Dashboard_XPATH, ObjectValType.XPATH)
					.click();
			webPage.findObject(ObjectType.Link, "Logout", ObjectValType.LINK)
					.click();
			webPage.findObject(ObjectType.Link, "Yes", ObjectValType.LINK)
					.click();

		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void LogoutCancel(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			webPage.findObject(ObjectType.Image,
					MainPageElements.Dashboard_XPATH, ObjectValType.XPATH)
					.click();
			webPage.findObject(ObjectType.Link, "Logout", ObjectValType.LINK)
					.click();
			webPage.findObject(ObjectType.Link, "Cancel", ObjectValType.LINK)
					.click();

		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void FeedbackRatings(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		//SignIn(input);
		try {
			webPage.findObject(ObjectType.Link,
					input.getParamMap().get("link"), ObjectValType.LINK)
					.click();
			webPage.findObject(ObjectType.Link, MainPageElements.Rating_XPATH,
					ObjectValType.LINK).click();
			webPage.findObject(ObjectType.Link,
					input.getParamMap().get("link1"), ObjectValType.LINK)
					.click();

		} catch (PageException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void FeedbackSubmission(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			webPage.findObject(ObjectType.Link,
					input.getParamMap().get("link"), ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.FeedbackMsg_XPATH, ObjectValType.XPATH))
					.enterText(input.getParamMap().get("msg"));
			webPage.findObject(ObjectType.Link,
					input.getParamMap().get("link1"), ObjectValType.LINK)
					.click();

		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}

	public void validatePurchaseTabValues(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,MAX_WAIT, WaitCondition.VISIBLE)).enterText(input.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,MainPageElements.AdditionalInfra_XPATH,ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE)).enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,	WaitCondition.VISIBLE)).enterText(input.getParamMap().get("cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,MAX_WAIT, WaitCondition.VISIBLE)).enterText(input.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,MAX_WAIT, WaitCondition.VISIBLE)).enterText(input.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,MainPageElements.Power_XPATH, ObjectValType.XPATH,MAX_WAIT, WaitCondition.VISIBLE)).enterText(input.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,MAX_WAIT, WaitCondition.VISIBLE)).enterText(input.getParamMap().get("itmgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,MainPageElements.NetworkFee_XPATH, ObjectValType.XPATH,MAX_WAIT, WaitCondition.VISIBLE)).enterText(input.getParamMap().get("ntwkfee"));

			float cos = Float.parseFloat(input.getParamMap().get("cos"));
			float aiper = Float.parseFloat(input.getParamMap().get("ai"));
			float software = Float.parseFloat(input.getParamMap().get("cas"));
			float license = Float.parseFloat(input.getParamMap().get("osl"));
			float pwrper = Float.parseFloat(input.getParamMap().get("power"));
			float itmper = Float.parseFloat(input.getParamMap().get("itmgmt"));
			float nfper = Float.parseFloat(input.getParamMap().get("ntwkfee"));
			int depri = 365 * 24 * Integer.parseInt(input.getParamMap().get("depri"));
			
			float ai = Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.AI_XPATH)).getAttribute("value"));
			float capexhr = Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.CAPEXHR_XPATH)).getAttribute("value"));
			float aival = Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.AI_XPATH)).getAttribute("value"));
			
		
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
	}
	
	public boolean verifyAIData(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			
			float ai = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.AI_XPATH)).getAttribute("value"));
			float aiper = Float.parseFloat(input.getParamMap().get("ai"));
			float cos = Float.parseFloat(input.getParamMap().get("cos"));
			if (ai == ((aiper * cos) / 100)) {
				return true;
			}

		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean verifyCAPEX(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));

			float ai = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.AI_XPATH)).getAttribute("value"));
			float aiper = Float.parseFloat(input.getParamMap().get("ai"));
			float cos = Float.parseFloat(input.getParamMap().get("cos"));
			float servers = Float.parseFloat(input.getParamMap().get(
					"servercount"));
			float software = Float.parseFloat(input.getParamMap().get("cas"));
			float license = Float.parseFloat(input.getParamMap().get("osl"));
			float CAPEX = (cos + ai + (servers * software) + (servers * license));
			float capex = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.CAPEX_XPATH)).getAttribute(
					"value"));
			 
			if (df.format(capex) == df.format(CAPEX))
				return true;
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean verifyCAPEXHR(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));

			float ai = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.AI_XPATH)).getAttribute("value"));
			float aiper = Float.parseFloat(input.getParamMap().get("ai"));
			float cos = Float.parseFloat(input.getParamMap().get("cos"));
			float servers = Float.parseFloat(input.getParamMap().get(
					"servercount"));
			float software = Float.parseFloat(input.getParamMap().get("cas"));
			float license = Float.parseFloat(input.getParamMap().get("osl"));
			float CAPEX = (cos + ai + (servers * software) + (servers * license));
			float capexhr = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.CAPEXHR_XPATH)).getAttribute(
					"value"));
			int depri = 365 * 24 * Integer.parseInt(input.getParamMap().get(
					"depri"));
			if (df.format(capexhr) == df.format(CAPEX / depri))
				return true;
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean verifyPOWER(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			float ai = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.AI_XPATH)).getAttribute("value"));
			float cos = Float.parseFloat(input.getParamMap().get("cos"));
			float p = Float.parseFloat(input.getParamMap().get("power"));
			float pwr = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.POWER_XPATH)).getAttribute(
					"value"));
			int depri = 365 * 24 * Integer.parseInt(input.getParamMap().get(
					"depri"));
			if (df.format(pwr) == df.format((((cos + ai) * p) / depri)))
				return true;
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean verifyITM(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("itmgmt"));
			float ai = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.AI_XPATH)).getAttribute("value"));
			float cos = Float.parseFloat(input.getParamMap().get("cos"));
			float itm = Float.parseFloat(input.getParamMap().get("itmgmt"));
			float itmgt = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.POWER_XPATH)).getAttribute(
					"value"));
			int depri = 365 * 24 * Integer.parseInt(input.getParamMap().get(
					"depri"));
			if (df.format(itmgt) == (df.format(((cos + ai) * itm) / depri)))
				return true;
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean verifyNF(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("itmgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NetworkFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("ntwkfee"));
			float ai = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.AI_XPATH)).getAttribute("value"));
			float cos = Float.parseFloat(input.getParamMap().get("cos"));
			int fee = Integer.parseInt(input.getParamMap().get("ntwkfee"));
			float nf = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.NF_XPATH)).getAttribute("value"));
			int depri = 365 * 24 * Integer.parseInt(input.getParamMap().get(
					"depri"));
			if (df.format(nf) == df.format(((cos + ai) * fee) / depri))
				return true;
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean verifyOPEX(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("itmgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NetworkFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("ntwkfee"));
			float fee = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.NF_XPATH)).getAttribute("value"));
			float itm = Float
					.parseFloat(webDriver.findElement(
							By.xpath(MainPageElements.ITM_XPATH)).getAttribute(
							"value"));
			float pwr = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.POWER_XPATH)).getAttribute(
					"value"));
			float OPEX = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.OPEX_XPATH))
					.getAttribute("value"));
			if (df.format(OPEX).equalsIgnoreCase(df.format(itm + pwr + fee)))
				return true;
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean verifyOPEXHR(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("itmgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NetworkFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("ntwkfee"));
			float OPEX = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.OPEX_XPATH))
					.getAttribute("value"));
			float OPEXHR = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.OPEXHR_XPATH)).getAttribute(
					"value"));
			if (df.format(OPEXHR).equalsIgnoreCase(df.format(OPEX / (365 * 24))))
				return true;
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean verifyTotalECUHR(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CAS_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"cas"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.OSLicensing_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("osl"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Depriciation_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("depri"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Power_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("power"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.ITMgmt_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("itmgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NetworkFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("ntwkfee"));
			float CAPEX = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.CAPEXHR_XPATH)).getAttribute(
					"value"));
			float OPEX = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.OPEXHR_XPATH)).getAttribute(
					"value"));
			float capexecuhr = CAPEX / totalECU;
			float opexecuhr = OPEX / totalECU;
			float totalecuhr = capexecuhr + opexecuhr;

			System.out.println(Math.floor(totalecuhr * 10000 + .5) / 10000);
			float totalECUHR = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.TOTALECUHR_XPATH)).getText());
			System.out.println(totalECUHR);
			if (df.format(totalecuhr).equalsIgnoreCase(df.format(totalECUHR))){
				return true;
			}
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(e.getCause() + "              "
					+ e.getStackTrace());
		}
		return false;
	}

	public boolean verifyHWCost(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			float mcos = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.MonthlyCost_XPATH)).getAttribute(
					"value"));
			float hwcost = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.HWCOST_XPATH)).getAttribute(
					"value"));
			float ecu = totalECU * 30 * 24;
			if (df.format(hwcost).equalsIgnoreCase(df.format(mcos/ecu))){
				return true;
			}

		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
		return false;
	}

	public boolean verifyPower(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			System.out.println("here");
			float hwcost = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.HWCOST_XPATH)).getAttribute(
					"value"));
			float pwr = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.Pwer_XPATH))
					.getAttribute("value"));
			float power = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.PowerLease_XPATH)).getAttribute(
					"value"));
			pwr = (hwcost * pwr) / 100;
			System.out.println("pwr"+pwr);
			System.out.println("power is "+power);
			if (df.format(pwr).equalsIgnoreCase(df.format(power))) {
				return true;
			}
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
		return false;
	}

	public boolean verifyITMLease(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			float hwcost = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.HWCOST_XPATH)).getAttribute(
					"value"));
			float itmper = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.Mgmt_XPATH))
					.getAttribute("value"));
			float itm = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.ITMLease_XPATH)).getAttribute(
					"value"));
			itmper = (hwcost * itmper) / 100;
			System.out.println("itmper" +df.format(itmper));
			System.out.println("itm "+df.format(itm));
			if (df.format(itmper).equalsIgnoreCase(df.format(itm))) {
				System.out.println("kanika");
				return true;
			}
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
		return false;
	}

	public boolean verifyNFLease(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("fee"));
			float hwcost = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.HWCOST_XPATH)).getAttribute(
					"value"));
			float nfper = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.NWFee_XPATH)).getAttribute(
					"value"));
			float nf = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.NFLease_XPATH)).getAttribute(
					"value"));
			nfper = (hwcost * nfper) / 100;
			System.out.println("nfper" +nfper);
			System.out.println("nf "+nf);
			if (nfper == nf) {
				return true;
			}
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
		return false;
	}

	public boolean verifyOPEXHRLease(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("fee"));

			float pwr = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.PowerLease_XPATH)).getAttribute(
					"value"));
			float itm = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.ITMLease_XPATH)).getAttribute(
					"value"));
			float nf = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.NFLease_XPATH)).getAttribute(
					"value"));
			float opexhr = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.OPEXECULease_XPATH))
					.getAttribute("value"));
			float opex = pwr + itm + nf;
			System.out.println("opexhr"+opexhr);
			System.out.println("opex"+opex);
			if (opexhr == opex) {
				return true;
			}
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
		return false;
	}

	public boolean verifyECUHRLease(TestParameters input)
			throws InterruptedException {
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"pwr"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
					"mgmt"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("fee"));

			float mcos = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.MonthlyCost_XPATH)).getAttribute(
					"value"));
			float opexhr = Float.parseFloat(webDriver.findElement(
					By.xpath(MainPageElements.OPEXECULease_XPATH))
					.getAttribute("value"));
			float ecu = mcos + opexhr;
			float totalecuhr = Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.TOTALECUHR_XPATH)).getText());
			//System.out.println(webDriver.findElement(By.xpath(MainPageElements.TOTALECUHR_XPATH)));
			if (ecu == totalecuhr) {
				return true;
			}
		} catch (Exception e) {
			log.error(getErrMessage());
			System.err.println(getErrMessage());
		}
		return false;
	}

	public void EditDataCalECU(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			ValidECU(input);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void EditPurchasetab(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('purchaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.CostSolution_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("cos"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.AdditionalInfra_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText(input.getParamMap().get("ai"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void EditLeaseTab(TestParameters input) throws InterruptedException {
		// TODO Auto-generated method stub
		final int MAX_WAIT = 50;
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			ValidECU(input);
			jsx.executeScript("document.getElementById('calculate').click()");
			jsx.executeScript("document.getElementById('leaseTab').click()");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
					MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
					.getParamMap().get("mcst"));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void EditReportLease(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			calCostLeaseTab(input);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void EditReportPurchase(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			calCostPurchaseTab(input);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void EditReportLeaseDuplicate(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			DuplicateLeaseReport(input);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void EditReportPurchaseDuplicate(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			DuplicateReport(input);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void EditReportLeaseBlank(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			blankLeaseReport(input);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public void EditReportPurchaseBlank(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			//SignIn(input);
			webDriver.findElement(
					By.xpath(MainPageElements.SavedReportName_XPATH)).click();
			webDriver.findElement(By.xpath(MainPageElements.Edit_XPATH))
					.click();
			BlankReport(input);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	public boolean ShareReportSub(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			calCostPurchaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			int msize = webDriver
					.findElement(By.xpath(MainPageElements.Msg_ID))
					.getAttribute("value").length();
			if (msize <= 140)
				return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean ShareReportLeaseSub(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			calCostLeaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			int msize = webDriver
					.findElement(By.xpath(MainPageElements.Msg_ID))
					.getAttribute("value").length();
			if (msize <= 140)
				return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean ShareReportMsg(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			calCostPurchaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			int msize = webDriver
					.findElement(By.xpath(MainPageElements.Msg_ID))
					.getAttribute("value").length();
			if (msize <= 500)
				return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	public boolean ShareReportLeaseMsg(TestParameters input)
			throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			calCostLeaseTab(input);
			webPage.findObject(ObjectType.Link, "Share", ObjectValType.LINK)
					.click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.To_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("to"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Subject_ID, ObjectValType.ID))
					.enterText(input.getParamMap().get("sub"));
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements.Msg_ID, ObjectValType.ID)).enterText(input
					.getParamMap().get("msgs"));
			int msize = webDriver
					.findElement(By.xpath(MainPageElements.Msg_ID))
					.getAttribute("value").length();
			if (msize <= 500)
				return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	public String validateLeaseTabValues(TestParameters input) throws InterruptedException{
		final int MAX_WAIT = 50;
		String res = "";
		try{
		ValidECU(input);
		jsx.executeScript("document.getElementById('calculate').click()");
		jsx.executeScript("document.getElementById('leaseTab').click()");
		((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements.MonthlyCost_XPATH, ObjectValType.XPATH,
				MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
				.getParamMap().get("mcst"));
		((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements.Pwer_XPATH, ObjectValType.XPATH, MAX_WAIT,
				WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
				"pwr"));
		((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements.Mgmt_XPATH, ObjectValType.XPATH, MAX_WAIT,
				WaitCondition.VISIBLE)).enterText(input.getParamMap().get(
				"mgmt"));
		((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements.NWFee_XPATH, ObjectValType.XPATH,
				MAX_WAIT, WaitCondition.VISIBLE)).enterText(input
				.getParamMap().get("fee"));
		float mcos = (float) (Math.round(Float.parseFloat(input.getParamMap().get("mcst"))*100.0)/100.0);
		float powerper = (float) (Math.round(Float.parseFloat(input.getParamMap().get("pwr"))*100.0)/100.0);
		float itmper = (float) (Math.round(Float.parseFloat(input.getParamMap().get("mgmt"))*100.0)/100.0);
		float nfper = (float) (Math.round(Float.parseFloat(input.getParamMap().get("fee"))*100.0)/100.0);
		float hwcost =(float) (Math.round( Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.HWCOST_XPATH)).getAttribute("value"))*100.0)/100.0);
		float power =(float) (Math.round( Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.PowerLease_XPATH)).getAttribute("value"))*100.0)/100.0);
		float itmgmt=(float) (Math.round( Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.ITMLease_XPATH)).getAttribute("value"))*100.0)/100.0);
		float nf=(float) (Math.round( Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.NFLease_XPATH)).getAttribute("value"))*100.0)/100.0);
		float opex=(float) (Math.round( Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.OPEXECULease_XPATH)).getAttribute("value"))*100.0)/100.0);
		float totalECUHr=(float) (Math.round( Float.parseFloat(webDriver.findElement(By.xpath(MainPageElements.TOTALECUHR_XPATH)).getText())*100.0)/100.0);
		
		//calculations
		float hcost = (float) (Math.round(mcos/(totalECU*30.0*24.0)*100.0)/100.0);
		float pwr = (float) ((float)(Math.round(hcost*powerper)*100.0)/100.0);
		float itm = (float) ((float)(Math.round(hcost*itmper)*100.0)/100.0);
		float nfee = (float) ((float)(Math.round(hcost*nfper)*100.0)/100.0);
		float opexhr = pwr+itm+nf;
		float tECUHr = hwcost +opexhr;
		
		System.out.println("calculated value: "+hcost+",,,,,,"+pwr+",,,,,"+itm+",,,,"+nfee+",,,,,"+opexhr+",,,,"+tECUHr);
		System.out.println("Obtained value: "+hwcost+",,,,,,"+power+",,,,,"+itmgmt+",,,,"+nf+",,,,,"+opex+",,,,"+totalECUHr);
		
		if(hcost == hwcost){
			res = "hwcost";
		}	
		if(pwr == power){
			res = res +","+"power";
		}
		if(itm == itmgmt){
			res = res +","+"itm";
		}
		if(nf == nfee){
			res = res +","+"nfee";
		}
		if(opexhr == opex){
			res = res +","+"opex";
		}
		if(totalECUHr == tECUHr){
			res = res +","+"totalecuhr";
		}
	}
		catch(Exception e){
			System.err.println(e.getMessage());
		}
		//return false;
		return res;
	}
}
