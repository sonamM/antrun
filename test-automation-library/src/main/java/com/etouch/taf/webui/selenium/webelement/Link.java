/*
 * 
 */
package com.etouch.taf.webui.selenium.webelement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebElement;

import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * Renders Link Page Object.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 */
public class Link extends Element{
	
	/** The log. */
	static Log log = LogUtil.getLog(Link.class);
	
	/**
	 * Initialize link page object.
	 *
	 * @param webElement the web element
	 */
	public Link(WebElement webElement){
		super(webElement);
	}
	
	/**
	 * check link is valid or not.
	 *
	 * @param linkUrl link URL
	 * @return true for valid link
	 * @throws PageException the page exception
	 */
	public boolean isLink(String linkUrl) throws PageException{
		if(CommonUtil.isNull(linkUrl)){
			log.error("Link URL is missing - "+ linkUrl);			
			throw new PageException("Link URL is missing");
		}
		return ((linkUrl.contains("http://") || linkUrl.contains("https://")) && !linkUrl.contains("mailto"));
	}			
	
	/**
	 * checks broken link is valid or not.
	 *
	 * @param linkUrl link URL
	 * @return true for broken link found.
	 * @throws PageException the page exception
	 */
	public boolean isLinkBroken(String linkUrl)  throws PageException{
		boolean result = false; 
		result = CommonUtil.isLinkBroken(linkUrl);
		return result;
	}

}
