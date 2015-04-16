package com.etouch.fox.common.pages;

import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Text;

/**
 * 
 * @author eTouch Systems Corporation
 *
 */
public class FoxSportsFooterPage {
	
	private WebPage webPage;
	
	public FoxSportsFooterPage(WebPage webPage){
		this.webPage = webPage;
	}
	
	public String getFooterLinkText(String linkText) throws PageException{
//		Text txt = webPage.findPageObjectByPartialLinkText(linkText, -1, null, IPageObjectType.Text);
		Text txt = (Text) webPage.findObjectsUsingLink(linkText, ObjectType.Text, -1, WaitCondition.CLICKABLE);
		return txt.getText();
	}
	
}
