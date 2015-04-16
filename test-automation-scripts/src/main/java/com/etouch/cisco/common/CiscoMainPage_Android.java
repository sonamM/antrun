package com.etouch.cisco.common;

import java.net.MalformedURLException;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.etouch.cisco.pages.elements.MainPageElements_Android;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.datamanager.excel.TestParameters;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.core.resources.ObjectValType;
import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.webui.selenium.webelement.TextBox;

public class CiscoMainPage_Android {
	// private static final String MainPageElements_Android = null;
		private static Log log = LogUtil.getLog(CiscoMainPage_Android.class);
		String compName = null;
		private WebDriver webDriver;
		//private JavascriptExecutor jsx;
		private float totalECU;
		DecimalFormat df = new DecimalFormat("###.##");
		private WebPage webPage = new WebPage();
		private WebDriver driver;

		public CiscoMainPage_Android() throws MalformedURLException {
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
				
				
				if(TestBedManager.INSTANCE.getCurrentTestBed().getTestBedName().equalsIgnoreCase("AndroidNativeSim")){
					singInSim();
						
				}else{
					
					WebElement element = driver.findElement(By
							.xpath(MainPageElements_Android.UName_XPATH_android));
					element.click();
					element.sendKeys(input.getParamMap().get("uname"));
					
					WebElement pwdelement = driver.findElement(By
							.xpath(MainPageElements_Android.PWD_XPATH_android));
					
					pwdelement.click();
					pwdelement.sendKeys(input.getParamMap().get("pwd"));
				}
				
				WebElement butElement = driver.findElement(By
						.xpath(MainPageElements_Android.Login_BTN_XPATH_android));
				butElement.click();

				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error: " + e.getLocalizedMessage());
			}

			try {
				Thread.sleep(5000);
				driver.findElement(By.xpath(MainPageElements_Android.PLUS_BTN_XPATH)).click();
						//By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]"))
						//.click();
				Thread.sleep(5000);
				((TextBox) webPage.findObject(ObjectType.TextBox,
						MainPageElements_Android.ServerCount_XPATH,
						ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
						.enterText("4");
				((TextBox) webPage.findObject(ObjectType.TextBox,
						MainPageElements_Android.CPUCount_XPATH,
						ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE))
						.enterText("2");
				Link element=(Link)webPage.findObject(ObjectType.Link, MainPageElements_Android.Input_Cost, 
						ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
				element.click();
				//WebElement elem=driver.findElement(By.name("Input Cost"));
				//elem.click();
			} catch (Exception e) {
				log.error(e.getMessage());
				System.err.println(e.getMessage());
			}
		
			try{
				String name = "Purchase_Report_"
						+ new Random().nextInt(10000);
//				driver.findElement(
//						By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIAButton[1]"))
//						.click(); // purchase
				TextBox element = ((TextBox) webPage.findObject(ObjectType.TextBox,
						MainPageElements_Android.CostSolution_XPATH,
						ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE));
				element.clear();
				element.enterText("3456");
				
				driver.findElement(By.xpath("//android.view.View[2]/android.view.View[1]/android.view.View[4]/android.view.View[4]")).click();
				
				
				Thread.sleep(1000);
				Link relement=(Link)webPage.findObject(ObjectType.Link, MainPageElements_Android.CREATE_REPORT_XPATH, 
						ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
				relement.click();
				
				((TextBox) webPage.findObject(ObjectType.TextBox,
						MainPageElements_Android.ReportName_XPATH,
						ObjectValType.XPATH)).enterText(name);

				//driver.findElement(By.id("Save")).click();
				Link selement=(Link)webPage.findObject(ObjectType.Link, MainPageElements_Android.SAVE_REPORT_LINK_XPATH, 
						ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
				selement.click();
				
		
			} catch (Exception e) {
				log.error(e.getMessage());
				System.err.println(e.getMessage());
			}
		

				driver.quit();
	
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
				.xpath(MainPageElements_Android.Login_BTN_XPATH_android));
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
					MainPageElements_Android.ServerCount_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE));
			serverCount.enterText("4");
			Thread.sleep(100);
			TextBox cpuCount=((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_Android.CPUCount_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE));
			cpuCount.click();
					cpuCount.enterText("2");
//			Link element=(Link)webPage.findObject(ObjectType.Link, MainPageElements_Android.Input_Cost, 
//					ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
//			element.click();
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
					MainPageElements_Android.CostSolution_XPATH,
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.VISIBLE));
			element.clear();
			element.enterText("3456");
			
			Link ele=(Link)webPage.findObject(ObjectType.Link,"//UIAApplication[1]/UIAWindow[1]/UIAKey[1]/UIAScrollView[1]/UIAWebView[1]/UIALink[2]", 
					ObjectValType.XPATH,MAX_WAIT,WaitCondition.VISIBLE);
			ele.click();
			
			((TextBox) webPage.findObject(ObjectType.TextBox,
					MainPageElements_Android.ReportName_XPATH,
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

}
}
