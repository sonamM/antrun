package com.etouch.fox.watch.pages.elements;

/**
 * Interface defining CrowdGoesWild page elements - id, xpath etc.,
 * 
 * @author eTouch Systems Corporation
 * 
 */
public interface CrowdGoesWildPageElements {
	/**
	 * Include XPATH for Crows Goes Wild Page Elements
	 */
	String	  BUZZER_HEADER	            = "/html/body/div[3]/div/div[2]/div/div[2]/section[2]/div/div/div/div[2]/div/div/div[2]/article/div/a/h3";
	String	  BUZZER_PUBDATE	        = "buzzer-pubdate";
	String	  VIDEO_CHECK	            = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div[2]/article[1]/div[2]/a";
	String	  Col1_XPATH	            = "//article[1]/div[1]/a/h3";
	String	  Col2_XPATH	            = "//div[contains(@class, 'upcoming-guests')]/descendant::span[@class='guest-name']";
	String	  Col3_XPATH	            = "//div[contains(@class, 'layout_layer midground')]/descendant::section[@class='right-rail']//descendant::div[@class='headerComponentContainer']";
	final int	COLS_FOR_DESKTOP_LAYOUT	= 3;
	final int	COLS_FOR_TABLET_LAYOUT	= 2;
	final int	COLS_FOR_IPHONE_LAYOUT	= 1;
	String	  BUZZER_HEADER_IMAG	    = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[1]/div/div/img";
	String	  BUZZER_COMPONENT	        = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[1]/div";
	String	  SECTION_HEADER_XPATH	    = "//section[@id='section-header']";
	// TC16
	String	  regExpression	            = "[A-Z]{3}\\s\\d{2},\\s\\d:\\d{2}(a|p)\\s[A-Z]{2}";
	String	  headerTag	                = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[1]/a/h3";
	String	  dateText	                = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[1]/div/span[1]";
	String	  byLine	                = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[1]/div/span[2]";
	String	  sorce	                    = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[1]/div/span[3]";
	String	  descriptionText	        = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[2]/div/p";
	String	  moreIcon	                = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[3]/div[1]/span";
	String	  viewMoreLink	            = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[2]/div/a";
	String	  tagLink	                = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[1]/div[3]/div[1]/a/span";
	String	  ShowMore_Xpath	        = "//div[@class='buzzer-load-more']//span[2]";
	// "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/div[2]/div/span[2]";
	String	  VideoLink	                = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[2]/div[1]/a/h3";
	String	  storyLink	                = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[3]/div[1]/a/h3";
	String	  HeadLine_Xpath	        = "//h3";
	// TC17
	String	  FOURTHLINK	            = "//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div/div[2]/article[4]/div[1]/a/h3";
	// TC23
	String	  SECONDARY_NAV_VIDEO	    = "//*[@id='SecondaryNavContainer3']/a/span/span";
	String	  SECONDARY_NAV_VIDEO_TITLE	= "//*[@id='SecondaryNavContainer3']/a";
	String	  CAST_LI	                = "//*[@id='SecondaryNavContainerBD2']/div[1]/ul/li/a/span";
	String	  SECONDARY_NAV_CAST	    = "//*[@id='SecondaryNavTrigger2']/span/span[1]";
	String	  SECONDARY_NAV_CAST_ANCHOR	= "//*[@id='SecondaryNavContainerBD2']/div[1]/ul/li/a";
	// Tc 30
	String	  CAST_CLOSE	            = "//*[@id='SecondaryNavCloseLink2']/span";
	// TC-36 toTC-43
	String MSN_HEADER="html/body/div[4]/div/header/div[1]";
	String MSN_LOGO="//*[@id='msn-menu-items']/li[1]/a";
	String	  SEARCH_TEXTBOX	        = "//*[@id='q']";
	String	  BOTTON_WEB	            = "//*[@id='wslink']";
	
	//TC44
	String SCROLL_CHECK = "//*[@id='buzzer-container']/div/div[2]/div[2]/div/span[2]";
	
	// TC 35 - 37
	String	  HEADER_IMG	            = "//*[@id='section-header']/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[1]/a/img";
	String	  HEADER_IMG_TWO_COL	    = "//*[@id='section-header']/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/a/img";
	String	  HEADER_IMG_ONE_COL	    = "//*[@id='section-header']/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[3]/a/img";
	// TC 45 -47
	String	  TUNE_IN_HEADER	        = "//*[@id='section-header']/div/div/div/div/div[1]/div[2]/div/div[1]/div/div/h2";
	
	//TC 31 ,32
		String BUZZER_LINK="//*[@id='SecondaryNavTriggerColA']/span/span";
		String BUZZER_IMAGE="//*[@id='buzzer-container']/div/div[1]/div/div/img";
		String INFO_LINK="//*[@id='SecondaryNavTriggerColB']/span/span";
		String INFO_IMAGE="//*[@id='news-container']/div[3]/div/div[1]/img";
	
}
