/*
 * 
 */
package com.etouch.taf.webui.selenium.webelement;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * Renders RadioButton PageObject. 
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class RadioButton extends Element{

	/** The log. */
	static Log log = LogUtil.getLog(SelectBox.class);
	
	/**
	 * Initialize radio button page object.
	 *
	 * @param webElement the web element
	 */
	public RadioButton(WebElement webElement) {
		super(webElement);
	}
	
	/**
	 * Select radio button page object only if it is not checked.
	 */
	public void check(){
		if(radioButton_isSelected()==false)
		webElement.click();	
	}
	
	/**
	 * UnSelect radio button page object only if it is checked.
	 */
	public void uncheck(){
		if(radioButton_isSelected()==true)
		webElement.click();	
	}
	
	/**
	 * Radio button_is selected.
	 *
	 * @return true, if successful
	 */
	public boolean radioButton_isSelected() {
		// TODO Auto-generated method stub
		return	webElement.isSelected();
	
	}

}
