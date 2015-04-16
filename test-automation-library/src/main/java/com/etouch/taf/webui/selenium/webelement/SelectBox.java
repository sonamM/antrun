/*
 * 
 */
package com.etouch.taf.webui.selenium.webelement;

import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * Renders SelectBox PageObject. 
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class SelectBox extends Element{

	/** The log. */
	static Log log = LogUtil.getLog(SelectBox.class);
	
	/**
	 * Initialize select box page object.
	 *
	 * @param webElement the web element
	 */
	public SelectBox(WebElement webElement) {
		super(webElement);
	}
	
	/**
	 * Selects value from the list .
	 *
	 * @param selection the text for the element to be selected from the selection list
	 * @return true if the selection is found
	 * @throws PageException the page exception
	 */
	public boolean selectDropDownList(String selection) throws PageException{
		if(CommonUtil.isNull(selection)){
			log.error("select text is missing - "+ selection);			
			throw new PageException("select text is missing");
		}
		List<WebElement> componentList = webElement.findElements(By.tagName("option"));
		for (WebElement component : componentList) {
			if (component.getText().contains(selection)) {
				component.click();
				return true;
			}
		}
		return false;
	}

}
