/*
 * 
 */
package com.etouch.taf.webui.selenium;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;

import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.webelement.Button;
import com.etouch.taf.webui.selenium.webelement.CheckBox;
import com.etouch.taf.webui.selenium.webelement.Element;
import com.etouch.taf.webui.selenium.webelement.Image;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.webui.selenium.webelement.RadioButton;
import com.etouch.taf.webui.selenium.webelement.SelectBox;
import com.etouch.taf.webui.selenium.webelement.Text;
import com.etouch.taf.webui.selenium.webelement.TextBox;
import com.etouch.taf.webui.selenium.webelement.Video;

// TODO: Auto-generated Javadoc
/**
 * Create page object from the page object factory. 
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class PageObjectFactory {
	
	/** The log. */
	static Log log = LogUtil.getLog(PageObjectFactory.class);
	
	/**
	 * Returns page object based on page object type.
	 * @param webElement initialnoteizes page object.
	 * @param type page object type.
	 * @return page element instance based on page object type.
	 * @throws PageException on error in creating page object.
	 */
	
	public static Element createPageObject (WebElement webElement,String type) throws PageException{
		
		if(CommonUtil.isNull(webElement) || CommonUtil.isNull(type)){
			log.error("Falied to create object, target element or page object type is missing (" + webElement + "," + type +")");			
			throw new PageException("Falied to create object, target element or page object type is missing");
		}		

		//TODO Multiple if-else block needs to be revisited for performance.
		if (ObjectType.Text.equalsIgnoreCase(type)){
			return new Text(webElement);
		}else if (ObjectType.TextBox.equalsIgnoreCase(type)){
				return new TextBox(webElement);
		}else if (ObjectType.SelectBox.equalsIgnoreCase(type)){
			return new SelectBox(webElement);
		}else if (ObjectType.Link.equalsIgnoreCase(type)){
			return new Link(webElement);
		}else if (ObjectType.Button.equalsIgnoreCase(type)){
			return new Button(webElement);	
		}else if (ObjectType.Video.equalsIgnoreCase(type)){
                return new Video(webElement);
		}else if (ObjectType.Image.equalsIgnoreCase(type)){
            return new Image(webElement);
		}else if (ObjectType.RadioButton.equalsIgnoreCase(type)){
            return new RadioButton(webElement);
		}else if (ObjectType.CheckBox.equalsIgnoreCase(type)){
            return new CheckBox(webElement);
		}else{
			throw new PageException("No such object exist");
		}
	}
}	
