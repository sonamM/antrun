/*
 * 
 */
package com.etouch.taf.webui.selenium;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.ObjectValType;
import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.webelement.Element;

// TODO: Auto-generated Javadoc
/**
 * This class finds and renders page objects , drivers.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class WebPage {
	
	/** The log. */
	private static Log log = LogUtil.getLog(WebPage.class);
	
	//private static TestBedManager testBedManager = null; 
	/** The driver. */
	protected WebDriver driver = null;
	
	//value for the wait loop
	/** The wait to check. */
	private int WAIT_TO_CHECK = 500;
	
	/**
	 * Initializes web driver and test bed manager.
	 */
	public WebPage() {		
		//if (this.driver == null) {
			this.driver=(WebDriver)TestBedManager.INSTANCE.getCurrentTestBed().getDriver();
		//}
		//testBedManager = manager;
	}

	/**
	 * 
	 * Returns driver.
	 * @return instance of web driver
	 * 
	 */
	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * Loads web page URL.
	 * @param pageUrl web page URL
	 */
	public void loadPage(String pageUrl) {
		this.driver.get(pageUrl);
		if(BrowserInfoUtil.INSTANCE.isFF()||BrowserInfoUtil.INSTANCE.isIE() || BrowserInfoUtil.INSTANCE.isChrome() )
		{
			this.driver.manage().window().maximize();
		}
		
	}

	/**
	 * find the specified object using an id .
	 *
	 * @param <T> the generic type
	 * @param object target object to look for e.g button, link
	 * @param id target value to use to find the object e.g. <div>...
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingId(String object, String id) throws PageException{
		WebElement webElement = null;
		try{
			webElement = driver.findElement(By.id(id));
		}catch (Exception e){
			log.error("Failed to find object using given id" + " = "+ id + ", message : " + e.toString());
        	throw new PageException("Failed to find object using given id , message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * find the specified object using a name .
	 *
	 * @param <T> the generic type
	 * @param object target object to look for e.g button, link
	 * @param name target value to use to find the object e.g. <div>...
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingName(String object, String name) throws PageException{
		WebElement webElement = null;
		try{
			  webElement = driver.findElement(By.id(name));
		}catch (Exception e){
			log.error("Failed to find object using given name" + " = " + name + ", message : " + e.toString());
        	throw new PageException("Failed to find object using given name, message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * find the specified object using an xpath .
	 *
	 * @param <T> the generic type
	 * @param object target object to look for e.g button, link
	 * @param xpath target value to use to find the object e.g. <div>...
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingxPath(String object, String xpath) throws PageException{
		WebElement webElement = null;
		try{
			webElement = driver.findElement(By.xpath(xpath));
		}catch (Exception e){
			log.error("Failed to find object using given xpath"+ " = " + " , message : " + e.toString());
        	throw new PageException("Failed to find object using given xpath, message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}	
	
	/**
	 * find the specified object using an css selector.
	 *
	 * @param <T> the generic type
	 * @param object target object to look for e.g button, link
	 * @param css target value to use to find the object e.g. <div>...
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingCss(String object, String css) throws PageException{
		WebElement webElement = null;
		try{
			webElement = driver.findElement(By.cssSelector(css));
		}catch (Exception e){
			log.error("Failed to find object using given css" + " = " + css + ", message : " + e.toString());
        	throw new PageException("Failed to find object using given css, message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * find the specified object using a link .
	 *
	 * @param <T> the generic type
	 * @param object target object to look for e.g button, link
	 * @param link target value to use to find the object e.g. <div>...
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingLink(String object, String link) throws PageException{
		WebElement webElement = null;
		try{
			webElement = driver.findElement(By.linkText(link)); 
		}catch (Exception e){
			log.error("Failed to find object using given link" + " = " + link + ", message : " + e.toString());
        	throw new PageException("Failed to find object using given link , message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * find the specified object using a partial link .
	 *
	 * @param <T> the generic type
	 * @param object target object to look for e.g button, link
	 * @param link target value to use to find the object e.g. <div>...
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingPartialLink(String object, String link) throws PageException{
		WebElement webElement = null;
		try{
			webElement = driver.findElement(By.partialLinkText(link)); 
		}catch (Exception e){
			log.error("Failed to find object using given partial link" + " = " + link + ", message : " + e.toString());
        	throw new PageException("Failed to find object using given partial link, message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * find the specified object using an class name .
	 *
	 * @param <T> the generic type
	 * @param object target object to look for e.g button, link
	 * @param name target value to use to find the object e.g. <div>...
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingClass(String object, String name) throws PageException{
		WebElement webElement = null;
		try{
			webElement = driver.findElement(By.className(name)); 
		}catch (Exception e){
			log.error("Failed to find object using given class name" + " = " + name + ", message : " + e.toString());
        	throw new PageException("Failed to find object using given class name, message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param val the val
	 * @param valType the val type
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObject(String object, String val, ObjectValType valType) throws PageException{
		WebElement webElement = null;
		try{
			Method m = By.class.getMethod(valType.getObjectValType(), String.class);
			webElement = ((WebDriver)driver).findElement((By)m.invoke(By.class, val));
		}catch (Exception e){
			log.error("Failed to find object using given "+ valType + " = " + val +", message : " + e.toString());
        	throw new PageException("Failed to find object using given "+ valType + ", message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Waits for specified time to find an object using an id. 
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param id target value of the object e.g <div>...
	 * @param wait target maximum wait in seconds
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingId(String object, String id, int wait) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.id(id), (wait==-1)?TestBed.MaxWaitSeconds:wait, null);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Waits for specified time to find an object using a name. 
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param name target value of the object e.g <div>...
	 * @param wait target maximum wait in seconds
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */ 
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingName(String object, String name, int wait) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.name(name), (wait==-1)?TestBed.MaxWaitSeconds:wait, null);
		return (T) PageObjectFactory.createPageObject(webElement,object);	
	}

	/**
	 * Waits for specified time to find an object using an xpath. 
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param xpath target value of the object e.g <div>...
	 * @param wait target maximum wait in seconds
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */ 
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingXpath(String object, String xpath, int wait) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.xpath(xpath), (wait==-1)?TestBed.MaxWaitSeconds:wait, null);
		return (T) PageObjectFactory.createPageObject(webElement,object);		
	}
	
	/**
	 * Waits for specified time to find an object using an css. 
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param css target value of the object e.g <div>...
	 * @param wait target maximum wait in seconds
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingCss(String object, String css, int wait) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.cssSelector(css), (wait==-1)?TestBed.MaxWaitSeconds:wait, null);
		return (T) PageObjectFactory.createPageObject(webElement,object);		
	}
	
	/**
	 * Waits for specified time to find an object using an link text. 
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param link target value of the object e.g <div>...
	 * @param wait target maximum wait in seconds
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingLink(String object, String link, int wait) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.linkText(link), (wait==-1)?TestBed.MaxWaitSeconds:wait, null);
		return (T) PageObjectFactory.createPageObject(webElement,object);		
	}
	
	/**
	 * Waits for specified time to find an object using a partial link text. 
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param link target value of the object e.g <div>...
	 * @param wait target maximum wait in seconds
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingPartialLink(String object, String link, int wait) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.partialLinkText(link), (wait==-1)?TestBed.MaxWaitSeconds:wait, null);
		return (T) PageObjectFactory.createPageObject(webElement,object);
		
	}
	
	/**
	 * Waits for specified time to find an object using a class name. 
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param name target value of the object e.g <div>...
	 * @param wait target maximum wait in seconds
	 * @return instance of page object based on the object
	 * @exception PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingClass(String object, String name, int wait) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.className(name), (wait==-1)?TestBed.MaxWaitSeconds:wait, null);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param val the val
	 * @param valType the val type
	 * @param wait the wait
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObject(String object, String val, ObjectValType valType, int wait) throws PageException{
		WebElement webElement=null;
		Method m;
		try {
			m = By.class.getMethod(valType.getObjectValType(), String.class);
			webElement = waitOnElement(((By)m.invoke(By.class, val)), (wait==-1)?TestBed.MaxWaitSeconds:wait, null);
		} catch (Exception e) {
			log.error("Failed to find object using given "+ valType + " = " + val +", message : " + e.toString());
        	throw new PageException("Failed to find object using given "+ valType + ", message : " + e.toString());
		}
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Waits for specified time to find an object using a wait condition.
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param id the id
	 * @param wait target maximum wait in seconds
	 * @param condition target wait based on a Condition
	 * @return instance of page object based on the object
	 * @throws PageException throws this exception if object not found
	 */

	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingId(String object, String id, int wait, WaitCondition condition) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.id(id), (wait==-1)?TestBed.MaxWaitSeconds:wait, null,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using name.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param name the name
	 * @param wait the wait
	 * @param condition the condition
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingName(String object, String name, int wait, WaitCondition condition) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.name(name), (wait==-1)?TestBed.MaxWaitSeconds:wait, null,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using xpath.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param xpath the xpath
	 * @param wait the wait
	 * @param condition the condition
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingXpath(String object, String xpath, int wait, WaitCondition condition) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.xpath(xpath), (wait==-1)?TestBed.MaxWaitSeconds:wait, null,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using css.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param css the css
	 * @param wait the wait
	 * @param condition the condition
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingCss(String object, String css, int wait, WaitCondition condition) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.cssSelector(css), (wait==-1)?TestBed.MaxWaitSeconds:wait, null,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @param wait the wait
	 * @param condition the condition
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingLink(String object, String link, int wait, WaitCondition condition) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.linkText(link), (wait==-1)?TestBed.MaxWaitSeconds:wait, null,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using partial link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @param wait the wait
	 * @param condition the condition
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingPartialLink(String object, String link, int wait, WaitCondition condition) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.partialLinkText(link), (wait==-1)?TestBed.MaxWaitSeconds:wait, null,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using class.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param name the name
	 * @param wait the wait
	 * @param condition the condition
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingClass(String object, String name, int wait, WaitCondition condition) throws PageException{
		WebElement webElement=null;
		webElement = waitOnElement(By.className(name), (wait==-1)?TestBed.MaxWaitSeconds:wait, null,condition);		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param val the val
	 * @param valType the val type
	 * @param wait the wait
	 * @param condition the condition
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObject(String object, String val, ObjectValType valType, int wait, WaitCondition condition) throws PageException{
		WebElement webElement=null;
		Method m;
		try {
			m = By.class.getMethod(valType.getObjectValType(), String.class);
			webElement = waitOnElement(((By)m.invoke(By.class, val)), (wait==-1)?TestBed.MaxWaitSeconds:wait, null,condition);
		} catch (Exception e) {
			
				log.error("Failed to find object using given "+ valType + "  =  " + val +", message : " + e.getMessage());
			
			;
        	throw new PageException("Failed to find object using given "+ valType + ", message : " + e.toString());
		}		
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Waits for specified time to find the object using a specific frame handle. 
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param id the id
	 * @param wait target maximum wait in seconds
	 * @param frame target name of the frame
	 * @return instance of page object based on the object
	 * @throws PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingId(String object, String id, int wait, String frame) throws PageException{
		WebElement webElement = null;
		webElement = (waitOnElement(By.id(id), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame));
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using name.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param name the name
	 * @param wait the wait
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingName(String object, String name, int wait, String frame) throws PageException{
		WebElement webElement = null;
		webElement = (waitOnElement(By.name(name), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame));
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}

	/**
	 * Find object using xpath.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param xpath the xpath
	 * @param wait the wait
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingXpath(String object, String xpath, int wait, String frame) throws PageException{
		WebElement webElement = null;
		webElement = (waitOnElement(By.xpath(xpath), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame));
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using css.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param css the css
	 * @param wait the wait
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingCss(String object, String css, int wait, String frame) throws PageException{
		WebElement webElement = null;
		webElement = (waitOnElement(By.cssSelector(css), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame));
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @param wait the wait
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingLink(String object, String link, int wait, String frame) throws PageException{
		WebElement webElement = null;
		webElement = (waitOnElement(By.linkText(link), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame));
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using partial link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @param wait the wait
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingPartialLink(String object, String link, int wait, String frame) throws PageException{
		WebElement webElement = null;
		webElement = (waitOnElement(By.partialLinkText(link), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame));
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using class.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param name the name
	 * @param wait the wait
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingClass(String object, String name, int wait, String frame) throws PageException{
		WebElement webElement = null;
		webElement = (waitOnElement(By.className(name), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame));
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param val the val
	 * @param valType the val type
	 * @param wait the wait
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObject(String object, String val, ObjectValType valType, int wait, String frame) throws PageException{
		WebElement webElement = null;
		Method m;
		try {
			m = By.class.getMethod(valType.getObjectValType(), String.class);
			webElement = (waitOnElement(((By)m.invoke(By.class, val)), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame));
		} catch (Exception e) {
			log.error("Failed to find object using given "+ valType + " = " + val + ", message : " + e.toString());
        	throw new PageException("Failed to find object using given "+ valType + ", message : " + e.toString());
		}
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Waits for specified time to find an object by using a condition and a specific frame.
	 *
	 * @param <T> the generic type
	 * @param object target actual object e.g. button, link
	 * @param id the id
	 * @param wait target maximum wait in seconds
	 * @param condition target wait based on the Expected Condition
	 * @param frame target name of the frame
	 * @return instance of page object based on the object
	 * @throws PageException throws this exception if object not found
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingId(String object, String id, int wait, WaitCondition condition, String frame) throws PageException{
		WebElement webElement = null;
		webElement=waitOnElement(By.id(id), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using name.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param name the name
	 * @param wait the wait
	 * @param condition the condition
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingName(String object, String name, int wait, WaitCondition condition, String frame) throws PageException{
		WebElement webElement = null;
		webElement=waitOnElement(By.name(name), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}

	/**
	 * Find object using xpath.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param xpath the xpath
	 * @param wait the wait
	 * @param condition the condition
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingXpath(String object, String xpath, int wait, WaitCondition condition, String frame) throws PageException{
		WebElement webElement = null;
		webElement=waitOnElement(By.xpath(xpath), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using css.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param css the css
	 * @param wait the wait
	 * @param condition the condition
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingCss(String object, String css, int wait, WaitCondition condition, String frame) throws PageException{
		WebElement webElement = null;
		webElement=waitOnElement(By.cssSelector(css), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @param wait the wait
	 * @param condition the condition
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingLink(String object, String link, int wait, WaitCondition condition, String frame) throws PageException{
		WebElement webElement = null;
		webElement=waitOnElement(By.linkText(link), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using partial link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @param wait the wait
	 * @param condition the condition
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingPartialLink(String object, String link, int wait, WaitCondition condition, String frame) throws PageException{
		WebElement webElement = null;
		webElement=waitOnElement(By.partialLinkText(link), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object using class.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param name the name
	 * @param wait the wait
	 * @param condition the condition
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObjectUsingClass(String object, String name, int wait, WaitCondition condition, String frame) throws PageException{
		WebElement webElement = null;
		webElement=waitOnElement(By.className(name), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame,condition);
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * Find object.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param val the val
	 * @param valType the val type
	 * @param wait the wait
	 * @param condition the condition
	 * @param frame the frame
	 * @return the t
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> T findObject(String object, String val, ObjectValType valType, int wait, WaitCondition condition, String frame) throws PageException{
		WebElement webElement = null;
		Method m;
		try {
			m = By.class.getMethod(valType.getObjectValType(), String.class);
			webElement = (waitOnElement(((By)m.invoke(By.class, val)), (wait==-1)?TestBed.MaxWaitSeconds:wait, (frame==null||"".equals(frame))?null:frame,condition));
		} catch (Exception e) {
			log.error("Failed to find object using given "+ valType + " = " + val +", message : " + e.toString());
        	throw new PageException("Failed to find object using given "+ valType + ", message : " + e.toString());
		}
		return (T) PageObjectFactory.createPageObject(webElement,object);
	}
	
	/**
	 * find multiple objects by using the valType. 
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param tag the tag
	 * @return list of page objects if WebDriver is able to find the objects
	 * @throws PageException the page exception
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingTag(String object, String tag) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst=null;
		lst = driver.findElements(By.tagName(tag));
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects using xpath.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param xpath the xpath
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingXpath(String object, String xpath) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst=null;
		lst = driver.findElements(By.xpath(xpath));
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects using link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingLink(String object, String link) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst=null;
		lst = driver.findElements(By.linkText(link));
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects using partial link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingPartialLink(String object, String link) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst=null;
		lst = driver.findElements(By.partialLinkText(link));
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects using class.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param name the name
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingClass(String object, String name) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst=null;
		lst = driver.findElements(By.className(name));
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param val the val
	 * @param valType the val type
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjects(String object, String val, ObjectValType valType) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst=null;
		Method m;
		try {
			m = By.class.getMethod(valType.getObjectValType(), String.class);
			lst= driver.findElements((By)m.invoke(By.class, val));
		} catch (Exception e) {
			log.error("Can not find objects for: "+ valType + " = " + val +", message : " + e.toString());
        	throw new PageException("Can not find objects for:  "+ valType + ", message : " + e.toString());
		}
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * find multiple objects by using the valType .
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param tag the tag
	 * @param wait the wait
	 * @param condition the condition
	 * @return list of page objects if WebDriver is able to find the objects
	 * @throws PageException the page exception
	 */
	
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingTag(String object, String tag, int wait, WaitCondition condition) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst =  null;
		lst= waitOnElements(By.tagName(tag),wait,condition);
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}

	/**
	 * Find objects using xpath.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param xpath the xpath
	 * @param wait the wait
	 * @param condition the condition
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingXpath(String object, String xpath, int wait, WaitCondition condition) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst =  null;
		lst= waitOnElements(By.xpath(xpath),wait,condition);
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects using link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @param wait the wait
	 * @param condition the condition
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingLink(String object, String link, int wait, WaitCondition condition) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst =  null;
		lst= waitOnElements(By.linkText(link),wait,condition);
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects using partial link.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param link the link
	 * @param wait the wait
	 * @param condition the condition
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingPartialLink(String object, String link, int wait, WaitCondition condition) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst =  null;
		lst= waitOnElements(By.partialLinkText(link),wait,condition);
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects using class.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param name the name
	 * @param wait the wait
	 * @param condition the condition
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjectsUsingClass(String object, String name, int wait, WaitCondition condition) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst =  null;
		lst= waitOnElements(By.className(name),wait,condition);
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Find objects.
	 *
	 * @param <T> the generic type
	 * @param object the object
	 * @param val the val
	 * @param valType the val type
	 * @param wait the wait
	 * @param condition the condition
	 * @return the list
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	public <T extends Element> List<T> findObjects(String object, String val, ObjectValType valType, int wait, WaitCondition condition) throws PageException{
		List<T> l1 = new ArrayList<T>();
		List<WebElement> lst =  null;
		Method m;
		try {
			m = By.class.getMethod(valType.getObjectValType(), String.class);
			lst= waitOnElements(((By)m.invoke(By.class, val)),wait,condition);
		} catch (Exception e) {
			log.error("Can not find objects for: "+ valType + " = " + val +", message : " + e.toString());
        	throw new PageException("Can not find objects for:  "+ valType + ", message : " + e.toString());
		}
		for(WebElement we : lst){
			l1.add((T) PageObjectFactory.createPageObject(we,object));
		}
		return l1;
	}
	
	/**
	 * Wait on element.
	 *
	 * @param element the element
	 * @param wait the wait
	 * @param frame the frame
	 * @return the web element
	 * @throws PageException the page exception
	 */
	private WebElement waitOnElement(By element, int wait, String frame) throws PageException{
		WebElement identifier = null;
		for (int i = 0; i < wait; i++) {
			try {
				if (frame == null)
					identifier = driver.findElement(element);
				else {
					driver.switchTo().defaultContent();
					identifier = driver.switchTo().frame(frame).findElement(element);
				}		
				//if element is found return
				if (identifier != null) 
					break;		
				//Thread.sleep(WAIT_TO_CHECK);
			} catch (Exception e) {	
				identifier = null;
				log.error("Failed to find object, message : " + e.toString());
	        	throw new PageException("Failed to find object, message : " + e.toString());
			}		
		}
		return identifier;
	}

	/**
	 * Waits on web element.  
	 *
	 * @param element the element
	 * @param wait the wait
	 * @return the web element
	 * @throws PageException the page exception
	 */
	public WebElement waitOnElement(By element, int wait) throws PageException{
		return waitOnElement(element, wait, null);
	}
	

	/**
	 * Wait on element to get loaded based on the Expected Condition.
	 *
	 * @param element the element
	 * @param wait the wait
	 * @param frame the frame
	 * @param condition the condition
	 * @return the web element
	 * @throws PageException the page exception
	 */
	@SuppressWarnings("unchecked")
	private WebElement waitOnElement(By element, int wait, String frame, WaitCondition condition) throws PageException{
		WebElement identifier = null;
		try{
			Method method = ExpectedConditions.class.getMethod(condition.getCondition(), By.class);
			WebDriverWait w = new WebDriverWait(((WebDriver)driver), wait);
			if(frame != null)
				w.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
			identifier = w.until((ExpectedCondition<WebElement>)method.invoke(ExpectedConditions.class,  element)) ; 	
		} catch (Exception e) {	
			identifier = null;
			log.error("Failed to find object, message : " + e.toString());
			throw new PageException("Failed to find object, message : " + e.toString());
		}
		return identifier;
	}
	
	/**
	 * Wait on element.
	 *
	 * @param element the element
	 * @param wait the wait
	 * @param condition the condition
	 * @return the list
	 * @throws PageException the page exception
	 */
	
	@SuppressWarnings("unchecked")
	private List<WebElement> waitOnElements(By element, int wait, WaitCondition condition) throws PageException{
		List<WebElement> identifiers = null;
		try{

			Method method = ExpectedConditions.class.getMethod(condition.getCondition(), By.class);
			WebDriverWait w = new WebDriverWait((WebDriver)driver, wait);
			identifiers = w.until( (ExpectedCondition<List<WebElement>>)method.invoke(ExpectedConditions.class,  element));  
		} catch (Exception e) {	
			identifiers = null;
			log.error("Failed to find object, message : " + e.toString());
			throw new PageException("Failed to find object, message : " + e.toString());
		}
		return identifiers;
	}
	
	/**
	 * Click on "Continue to this Website(not recommended)" link on Certificate Error Page for IE browser.
	 */
	public void  certificateErrorClick() {
		if(BrowserInfoUtil.INSTANCE.isIE()){
			driver.navigate().to("javascript:document.getElementById('overridelink').click()");
		}
	}

	/**
	 * sleep time.
	 *
	 * @param timeout the timeout
	 */
	public void sleep(long timeout){
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Resize window to given width and height.
	 *
	 * @param width the width
	 * @param height the height
	 */
	public void resize(int width,int height){
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(width,height));
		return;
	}

	/**
	 * Resize window to given height width by adding wait.
	 *
	 * @param width the width
	 * @param height the height
	 * @param wait the wait
	 */
	public void resize(int width,int height,int wait){
		driver.manage().window().setSize(new org.openqa.selenium.Dimension(width,height));	
		sleep(wait);
		return;
	}
	
	/**
	 * Returns current URL.
	 *
	 * @return the current url
	 */
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}

	/**
	 * Gets the transition url.
	 *
	 * @param previousUrl the previous url
	 * @param driverWait the driver wait
	 * @param implicitWait the implicit wait
	 * @return the transition url
	 */
	public String getTransitionUrl(final String previousUrl, int driverWait,int implicitWait){
		WebDriverWait wait = new WebDriverWait(driver, driverWait);
	    driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
	    ExpectedCondition<Boolean> e = new ExpectedCondition<Boolean>() {
	    	public Boolean apply(WebDriver d) {
	    		return (d.getCurrentUrl() != previousUrl);
	    	}
	    };
	    wait.until(e);
		return driver.getCurrentUrl();
	}
	
	/**
	 * Returns true if current URL has parameters appended.
	 * @return true if current URL has parameters appended.
	 */
	public boolean StringParameterAppend(){
		String url=driver.getCurrentUrl();
		boolean flag = url.indexOf("?")!= -1;
		if(flag)
			return false;
		else
			return true;
	}

	/**
	 * Navigates to the given URL.
	 * @param url URL to navigate.
	 */
	public void navigateToUrl(String url){
		driver.navigate().to(url);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			log.error("Exception in thread sleep, message, " + e.toString());
		}
	}
	
	/**
	 * Switch to new tab.
	 */
	public void openNewTab(){
		Set<String> windows = driver.getWindowHandles();
		log.info("After click no. of windows:"+windows.size());
		log.info("Before Switch "+driver.getWindowHandle());
		for(String window: windows){
			driver.switchTo().window(window);
			log.info("After Switch "+driver.getWindowHandle());
			log.info("Page URL:"+driver.getCurrentUrl());
			log.info("Switched Page title is:"+driver.getTitle());
		}
	}
	
	/**
	 * Navigates back.
	 *
	 * @return the back to url
	 */
	public void getBackToUrl(){
		driver.navigate().back();
		return;
	}

	/**
	 * Toggle window.
	 */
    public void toggleWindow() {
           String currentHandle = driver.getWindowHandle();
           log.info("currentHandle:: " + currentHandle);
           Set<String> windows = driver.getWindowHandles();
           log.info("no. of windows::" + windows.size());
           windows.remove(currentHandle);
           log.info("no. of windows after remove current handle ::" + windows.size());
           if (windows.size() == 1) {
                  log.info("switching to window ::" + (String) ((windows.toArray())[0]));
                  driver.switchTo().window((String) ((windows.toArray())[0]));
           }
    }

    /**
     * Close_toggle window.
     */
    public void close_toggleWindow() {
           String currentHandle = driver.getWindowHandle();
           log.info("currentHandle:: " + currentHandle);
           Set<String> windows = driver.getWindowHandles();
           log.info("no. of windows::" + windows.size());
           driver.switchTo().window(currentHandle).close();
           windows.remove(currentHandle);
           log.info("no. of windows after remove current handle ::" + windows.size());
           if (windows.size() == 1) {
                  log.info("switching to window ::" + (String) ((windows.toArray())[0]));
                  driver.switchTo().window((String) ((windows.toArray())[0]));
           }
    }	
	
}
