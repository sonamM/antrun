package com.etouch.taf.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.etouch.taf.core.driver.DriverBuilder;



public class JavaScriptUtil {
	
		public static <T extends Object> T executeJavaScript(WebDriver driver, String javaScript) 
		{
			T result = null;
			
			try {
					JavascriptExecutor js = (JavascriptExecutor) driver;	
					result= (T)js.executeScript(javaScript);
					
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				return result;
		}
	
	
}



