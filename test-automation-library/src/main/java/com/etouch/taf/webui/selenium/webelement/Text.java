/*
 * 
 */
package com.etouch.taf.webui.selenium.webelement;

import org.apache.commons.logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.Color;

import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

// TODO: Auto-generated Javadoc
/**
 * Renders Text PageObject. .
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class Text extends Element {

	/** The log. */
	static Log log = LogUtil.getLog(Text.class);

	/**
	 * Instantiates a new text.
	 *
	 * @param webElement the web element
	 */
	public Text(WebElement webElement) {
		super(webElement);
	}

	/** The action. */
	Actions action = new Actions(driver);


	/**
	 * Text hover.
	 */
	public void textHover(){
		Mouse mouse=((HasInputDevices)driver).getMouse();
		mouse.mouseMove(((Locatable) this.webElement).getCoordinates());
	}
	
	/**
	 * Text color.
	 *
	 * @return the string
	 */
	public String textColor() {
		if(BrowserInfoUtil.INSTANCE.isSafari()){
			action.moveToElement(webElement);
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(mouseOverScript, webElement);
			System.out.println("In hover");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			CommonUtil.sop("OUT hover");
		}else{
			textHover();
		}
		String hex = Color.fromString(webElement.getCssValue("color")).asHex();
		return hex;
	}

	/**
	 * Text style.
	 *
	 * @return the string
	 */
	public String textStyle(){
		// TODO
		return null;
	}
	
	/**
	 * Text font.
	 *
	 * @return the string
	 */
	public String textFont(){
		//TODO 
		return null;
	}
	
	/**
	 * Text title.
	 *
	 * @return the string
	 */
	public String textTitle() {
		textHover();
		String titleText = webElement.getAttribute("title");
		return titleText;
	}

	/**
	 * Border color.
	 *
	 * @return the string
	 */
	public String borderColor() {
		textHover();
		String hex = Color.fromString(webElement.getCssValue("color")).asHex();
		return hex;
	}

}
