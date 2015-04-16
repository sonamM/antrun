package com.etouch.fox.watch.pages;

import com.etouch.fox.common.pages.CommonPage;
import com.etouch.fox.common.pages.FoxSportsFooterPage;
import com.etouch.taf.webui.selenium.WebPage;

/**
 * Page Class for FantasyFootball page.
 * It calls the Framework APIs.
 * 
 * Test Class resembles the test specification.
 * Page Class resembles the test implementation
 * 
 * @author eTouch Systems Corporation
 *
 */
public class FantasyFootballPage extends CommonPage {

	private FoxSportsFooterPage foxSportsFooterPage;
	
	public FantasyFootballPage(String sbPageUrl, WebPage webPage) {
		super(sbPageUrl,webPage);
		this.foxSportsFooterPage = new FoxSportsFooterPage(this.webPage);
		loadPage();
	}

}
