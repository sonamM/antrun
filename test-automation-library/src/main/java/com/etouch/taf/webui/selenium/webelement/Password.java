/*
 * 
 */
package com.etouch.taf.webui.selenium.webelement;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * Renders Password PageObject. . 
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class Password extends Element{
	
	/** The log. */
	static Log log = LogUtil.getLog(TextBox.class);
	
	/**
	 * Instantiates a new password.
	 *
	 * @param webElement the web element
	 */
	public Password(WebElement webElement){
		super(webElement);
	}
	
	/**
	 * Enters text in the password.
	 * @param text text to be entered.
	 */
	public void enterText(String text){
		webElement.clear();
		webElement.sendKeys(text);    
		return;
	}
	
}