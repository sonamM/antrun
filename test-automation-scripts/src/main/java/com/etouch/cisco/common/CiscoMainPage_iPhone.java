package com.etouch.cisco.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
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
import com.etouch.cisco.pages.elements.MainPageElements_iphone;
import com.etouch.cisco.pages.elements.MainPageElements_iphoneEm;
import com.etouch.fox.common.pages.CommonPage;
import com.etouch.taf.webui.selenium.webelement.*;
import com.etouch.taf.webui.selenium.WebPage;

public class CiscoMainPage_iPhone {
	// private static final String MainPageElements_iphone = null;
	private static Log log = LogUtil.getLog(CiscoMainPage_iPhone.class);
	String compName = null;
	private WebDriver webDriver;
	//private JavascriptExecutor jsx;
	private float totalECU;
	DecimalFormat df = new DecimalFormat("###.##");
	private WebPage webPage = new WebPage();
	private WebDriver driver;

	public CiscoMainPage_iPhone() throws MalformedURLException {
		// TODO Auto-generated constructor stub

		driver = (RemoteWebDriver) TestBedManager.INSTANCE.getCurrentTestBed()
				.getDriver();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getPageUrl() {
		return webPage.getCurrentUrl();
	}

	public void SignIn(TestParameters input) throws InterruptedException {
		final int MAX_WAIT = 20;
		try {
			//Tread.sleep(1000);
			
			
			if(TestBedManager.INSTANCE.getCurrentTestBed().getTestBedName().equalsIgnoreCase("iPhoneNativeSim")){
				singInSim();
					
			}else{
				
				WebElement element = driver.findElement(By
						.xpath(MainPageElements_iphone.UName_XPATH_ipad));
				element.click();
				element.sendKeys(input.getParamMap().get("uname"));
				
				WebElement pwdelement = driver.findElement(By
						.xpath(MainPageElements_iphone.PWD_XPATH_ipad));
				
				pwdelement.click();
				pwdelement.sendKeys(input.getParamMap().get("pwd"));
			}
			
			WebElement butElement = driver.findElement(By
					.xpath(MainPageElements_iphone.Login_BTN_XPATH_ipad));
			butElement.click();

			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getLocalizedMessage());
		}

		try {
			Thread.sleep(5000);
			driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]"))
					.click();
			//Thread.sleep(10000);
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_iphone.ServerCount_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText("4");
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_iphone.CPUCount_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText("2");
			Thread.sleep(500);
		
			
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIAStaticText[10]")).click();
			Link element=(Link)webPage.findObject(ObjectType.Link, MainPageElements_iphone.Input_Cost, 
					ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
			element.click();
			
			//WebElement elem=driver.findElement(By.name("Input Cost"));
			//elem.click();
			// jsx.executeScript("document.getElementById('calculate').click()");
		} catch (Exception e) {
			log.error(e.getMessage());
			System.err.println(e.getMessage());
		}
	
		try{
			String name = "Purchase_Report_"
					+ new Random().nextInt(10000);
			Thread.sleep(4000);
			driver.findElement(
					By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]"))
					.click(); // purchase
			TextBox element = ((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_iphone.CostSolution_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE));
			element.clear();
			element.enterText("3456");
			
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]")).click();
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_iphone.ReportName_XPATH,
					ObjectValType.XPATH)).enterText(name);
			Link saveElement=(Link)webPage.findObject(ObjectType.Link,"//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]", 
					ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
			
			saveElement.click();
			driver.findElement(By.id("Save")).click();
			
			// webPage.findObject(ObjectType.Link, "Save",
			// ObjectValType.LINK).click();
		} catch (Exception e) {
			log.error(e.getMessage());
			System.err.println(e.getMessage());
		}
	

	
		/*try {
			Link shareElement=(Link)webPage.findObject(ObjectType.Link,"//window[1]/UIAKey[1]/scrollview[1]/webview[1]/link[3]", 
					ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
			shareElement.click();
			TextBox from=((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_iphone.To_XPATH, ObjectValType.XPATH));
					from.click();
					from.enterText("rpandey@eTouch.net");
			TextBox subject=((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_iphone.Subject_XPATH, ObjectValType.XPATH));
					subject.click();
					subject.enterText("Sharing purchase report");
			TextBox mailBody=((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_iphone.Msg_XPATH, ObjectValType.XPATH));
					mailBody.click();
					mailBody.enterText("Hi, Please find your cloud server purchase report attached");
			webPage.findObject(ObjectType.Link,
					MainPageElements_iphone.SendReport_XPATH,
					ObjectValType.XPATH).click();
			Link okButton=(Link)webPage.findObject(ObjectType.Link,"//window[1]/UIAKey[1]/scrollview[1]/webview[1]/link[1]", 
					ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
			okButton.click();
			//driver.findElement(By.id("Ok")).click();
			
			
		} catch (Exception e) {
			log.error(e.getMessage());
			System.err.println(e.getMessage());
		}
	
		try{
			// //SignIn(input);
			webPage.findObject(ObjectType.Image,
					MainPageElements_iphone.Dashboard_XPATH,
					ObjectValType.XPATH).click();
			//webPage.findObject(ObjectType.Link, "Logout", ObjectValType.LINK)
			//		.click();
			driver.findElement(By.id("Logout")).click();
			driver.findElement(By.id("Yes")).click();*/
			driver.quit();
			//webPage.findObject(ObjectType.Link, "Yes", ObjectValType.LINK)
			//		.click();

		/*}
		catch(PageException e){
			log.error(e.getMessage());
			System.err.println(e.getMessage());
			}*/
		}

// For simulator
public void singInSim(){
	final int MAX_WAIT = 20;
	try {
		Thread.sleep(1000);
	TextBox element = ((TextBox) webPage.findObject(ObjectType.TextBox,
			"User Name",ObjectValType.ID, MAX_WAIT, WaitCondition.VISIBLE));
	element.click();
	element.enterText("nbathula");
	
	TextBox pwdelement=((TextBox) webPage.findObject(ObjectType.TextBox,
			"Password",ObjectValType.ID, MAX_WAIT, WaitCondition.VISIBLE));
	pwdelement.click();
	pwdelement.enterText("November2013$");
	
	WebElement butElement = driver.findElement(By
			.xpath(MainPageElements_iphone.Login_BTN_XPATH_ipad));
	butElement.click();

	Thread.sleep(1000);
	}catch(Exception e)
	{
		log.error(e.getMessage());
		System.err.println(e.getMessage());
	}
	//validECU
	try {
		Thread.sleep(5000);
		driver.findElement(
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]"))
				.click();
		Thread.sleep(1000);
		TextBox serverCount=((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements_iphone.ServerCount_XPATH,
				ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE));
		serverCount.enterText("4");
		Thread.sleep(100);
		TextBox cpuCount=((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements_iphone.CPUCount_XPATH,
				ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE));
		cpuCount.click();
				cpuCount.enterText("2");
//		Link element=(Link)webPage.findObject(ObjectType.Link, MainPageElements_iphone.Input_Cost, 
//				ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
//		element.click();
		//driver.findElement(By.id("Input Cost")).click();
				driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]/UIAStaticText[1]")).click();
	} catch (Exception e) {
		log.error(e.getMessage());
		System.err.println(e.getMessage());
	}
	//Purchase Report
	try{
		String name = "Purchase_Report_"
				+ new Random().nextInt(10000);
		Thread.sleep(4000);
		driver.findElement(
				By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]"))
				.click(); // purchase
		TextBox element = ((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements_iphone.CostSolution_XPATH,
				ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE));
		element.clear();
		element.enterText("3456");
		
		Link ele=(Link)webPage.findObject(ObjectType.Link,"//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]", 
				ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
		ele.click();
		
		((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements_iphone.ReportName_XPATH,
				ObjectValType.XPATH)).enterText(name);
		
		Link saveElement=(Link)webPage.findObject(ObjectType.Link,"//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[4]", 
				ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
		saveElement.click();
		driver.findElement(By.id("Save")).click();
		
		// webPage.findObject(ObjectType.Link, "Save",
		// ObjectValType.LINK).click();
	} catch (Exception e) {
		log.error(e.getMessage());
		System.err.println(e.getMessage());
	}
	
	// Share Report
	/*try {
		Thread.sleep(500);
		Link shareElement=(Link)webPage.findObject(ObjectType.Link,"Share", 
				ObjectValType.ID,MAX_WAIT,WaitCondition.VISIBLE);
		shareElement.click();
		TextBox from=((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements_iphone.To_XPATH, ObjectValType.XPATH));
				from.click();
				from.enterText("rpandey@eTouch.net");
		TextBox subject=((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements_iphone.Subject_XPATH, ObjectValType.XPATH));
				subject.click();
				subject.enterText("Sharing purchase report");
		TextBox mailBody=((TextBox) webPage.findObject(ObjectType.TextBox,
				MainPageElements_iphone.Msg_XPATH, ObjectValType.XPATH));
				mailBody.click();
				mailBody.enterText("Hi, Please find your cloud server purchase report attached");
		webPage.findObject(ObjectType.Link,
				MainPageElements_iphone.SendReport_XPATH,
				ObjectValType.XPATH).click();
		Link okButton=(Link)webPage.findObject(ObjectType.Link,"//window[1]/UIAKey[1]/scrollview[1]/webview[1]/link[1]", 
				ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
		okButton.click();
		//driver.findElement(By.id("Ok")).click();
		
		
	} catch (Exception e) {
		log.error(e.getMessage());
		System.err.println(e.getMessage());
	}

	//Logout
	try{
		webPage.findObject(ObjectType.Image,
				MainPageElements_iphone.Dashboard_XPATH,
				ObjectValType.XPATH).click();
		driver.findElement(By.id("Logout")).click();
		driver.findElement(By.id("Yes")).click();*/
		driver.quit();

	/*}
	catch(PageException e){
		log.error(e.getMessage());
		System.err.println(e.getMessage());
		}*/
	}
}
	

	

	

