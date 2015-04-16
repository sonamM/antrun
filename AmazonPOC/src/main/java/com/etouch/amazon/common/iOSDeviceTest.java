/*
 * 
 */
package com.etouch.amazon.common;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.core.resources.ObjectValType;
import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.SoftAssertor;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Button;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.webui.selenium.webelement.Text;

// TODO: Auto-generated Javadoc
/**
 * The Class iOSDeviceTest.
 */
public class iOSDeviceTest extends BaseTest {
	
	
	/**
	 * Test google.
	 *
	 * @throws Exception the exception
	 */
	@Test
	 public static void testGoogle() throws Exception {
		final int MAX_WAIT = 20;
	   RemoteWebDriver driver=(RemoteWebDriver)TestBedManager.INSTANCE.getCurrentTestBed().getDriver();
	   WebPage webPage=new WebPage();
/*	 DesiredCapabilities cap = new DesiredCapabilities();
//	 cap.setCapability("deviceName", "iPhone Retina (4-inch)");
//     cap.setCapability(CapabilityType.VERSION, "7.1");
//     cap.setCapability("platformName", "iOS");
//     cap.setCapability("app", "com.apple.samplecode.MapSearch");
//     cap.setCapability("UDID","b260151b7058491bd4dcd99396da691f045c1bbc");
	 
	 //driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);*/
	 Thread.sleep(3000);
	
	 
	 
	 WebElement element = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIASearchBar[1]"));
	 element.sendKeys("Coffee!");
	 Thread.sleep(2000);
	 
	 
	 //This code is with eTaap- which needs to be updated
	Button button= ((Button) webPage.findObject(ObjectType.Button,
				"//UIApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]", ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.CLICKABLE));
	button.click();

	 
	 //WebElement searchElement=driver.findElement(By.xpath("//UIApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[4]"));
	 //searchElement.click();
	 
	 Thread.sleep(2000);
	 
	 ((Text) webPage.findObject(ObjectType.Text,
				"//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[1]", ObjectValType.XPATH, MAX_WAIT,
					WaitCondition.CLICKABLE)).click();
	// WebElement resultElement=driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[6]/UIAStaticText[1]"));
	// resultElement.click();
	 
	 Thread.sleep(2000);
	 WebElement mapElement=driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAMapView[1]/UIAPopover[1]/UIAStaticText[1]"));
	 mapElement.click();
	 CommonUtil.sop("map Result " + mapElement.getText());
	 //AssertJUnit.assertEquals("Starbucks" ,mapElement.getText());
	 SoftAssertor.assertEquals("Starbucks" ,mapElement.getText());
	


	 
	}
	} 