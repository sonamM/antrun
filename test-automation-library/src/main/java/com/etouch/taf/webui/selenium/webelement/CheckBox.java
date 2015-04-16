/*
 * 
 */
package com.etouch.taf.webui.selenium.webelement;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * Renders CheckBox PageObject. . 
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class CheckBox extends Element{
	
	/** The log. */
	static Log log = LogUtil.getLog(TextBox.class);
	
	/**
	 * Initialize check box page object.
	 *
	 * @param webElement the web element
	 */
	public CheckBox(WebElement webElement){
		super(webElement);
	}
	
	/**
	 * Select check box page object only if it is not checked.
	 */
	public void check(){
	if(checkBox_isSelected()==false)
		webElement.click();    
		
	}
	
	/**
	 * Select check box page object only if it is checked.
	 */
	public void uncheck(){
		if(checkBox_isSelected()==true)
			webElement.click();
	}
	
	/**
	 * Returns true if check box selected.
	 * @return true if check box selected.
	 */
	public boolean checkBox_isSelected() {
		return	webElement.isSelected();
	}
	
}
