/*
 * 
 */
package com.etouch.amazon.pages;

 import java.io.File;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
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
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.remote.DesiredCapabilities;
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
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;
import com.etouch.amazon.common.BaseTest;
import com.etouch.amazon.common.CommonPage;
import com.etouch.taf.webui.selenium.webelement.*;
import com.etouch.taf.webui.selenium.WebPage;

// TODO: Auto-generated Javadoc
/**
 * The Class AmazonMainPage.
 */
public class AmazonMainPage extends CommonPage {
	
	//private WebDriver webDriver;
	
	
	/**
	 * Instantiates a new amazon main page.
	 *
	 * @param sbPageUrl the sb page url
	 * @param webPage the web page
	 */
	public AmazonMainPage(String sbPageUrl, WebPage webPage) {
		super(sbPageUrl, webPage);
  
		
		//webDriver = webPage.getDriver();
		CommonUtil.sop("webDriver in AmazonMainPage "+ webPage.getDriver());
				
			//startRecording();
	//	if(TestBedManager.INSTANCE.getCurrentTestBed().getDevice().getName() != null){
			
			loadPage();		
			
		//}
	}

	/**
	 * Gets the page url.
	 *
	 * @return the page url
	 */
	public String getPageUrl() {
		return webPage.getCurrentUrl();
	}

	
	/**
	 * Pre sign in.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void PreSignIn() throws InterruptedException, PageException{
		final int MAX_WAIT = 20;
		//try {
			/*((Button) webPage.findObject(ObjectType.Button,
				MainPageElements.Nav_SignIn_Title_XPATH, ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.CLICKABLE)).click();*/ 
		
			//"nav-link-yourAccount"
				
			CommonUtil.sop("this is presignIn");
			//webPage.findObjectById("nav-link-yourAccount").click();
			((Button) webPage.findObject(ObjectType.Button, "nav-link-yourAccount",
					ObjectValType.ID, MAX_WAIT, WaitCondition.CLICKABLE)).hover();
			
			((Button) webPage.findObject(ObjectType.Button, "nav-link-yourAccount",
					ObjectValType.ID, MAX_WAIT, WaitCondition.CLICKABLE)).click();
			
			
			/*((Button) webPage.findObject(ObjectType.Button, "nav-link-yourAccount",
					ObjectValType.ID, MAX_WAIT, WaitCondition.CLICKABLE)).hover();*/
			
			/*((Button) webPage.findObject(ObjectType.Button, ".//*[@id='nav-link-yourAccount']/span[1]",
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.CLICKABLE)).hover();
			
			
			((Button) webPage.findObject(ObjectType.Button, ".//*[@id='nav-flyout-ya-signin']/a/span",
					ObjectValType.XPATH, MAX_WAIT, WaitCondition.CLICKABLE)).click();*/
			Thread.sleep(2000);

			
		}	
		/*catch (Exception e) {
			SoftAssertor.addVerificationFailure(e.getMessage());
			CommonUtil.sop("Exception is here");
			CommonUtil.sop(e.getMessage());			
		}*/
	//}
	
	
	/**
	 * Sign in.
	 *
	 * @throws InterruptedException the interrupted exception
	 */
	public void SignIn() throws InterruptedException, PageException
	{
		final int MAX_WAIT = 20;
		//try{
			((TextBox) webPage.findObject(ObjectType.TextBox,
				"ap_email", ObjectValType.ID, MAX_WAIT, WaitCondition.VISIBLE))
					.enterText("");

			((TextBox) webPage.findObject(ObjectType.TextBox,
					"ap_password", ObjectValType.ID, MAX_WAIT,
					WaitCondition.VISIBLE)).enterText("");
			
		
			((Button) webPage.findObject(ObjectType.Button,
				"signInSubmit-input", ObjectValType.ID, MAX_WAIT,
					WaitCondition.CLICKABLE)).click();
			
				
			/* }catch (Exception e) {
			SoftAssertor.addVerificationFailure(e.getMessage());
			CommonUtil.sop("exception 2");	
			CommonUtil.sop(e.getMessage());
		}*/
	}
}




