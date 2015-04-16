package com.etouch.fox.watch.pages.elements;
/**
 * Interface defining BuzzerPage elements - id, xpath etc.,
 * 
 * @author eTouch Systems Corporation
 *
 */
public interface BuzzerPageElements {
	/**
	 * Include XPATH for BuzzerPage Elements
	 */
	String Text_CHECK="//h3";
	
	String TextVideo_CHECK="//h3"; 
	String  SHOWMORE= "//section[@id='section-body']/div/div/div/div[2]/div/div/div[2]/div[2]/div/span[2]";
	String Text_HEADER="//article[";
	String Text_DATE="//article[";
	String Text_BODY="//article[";
	String BUZZER_PUBDATE ="buzzer-pubdate";
	
	String BUZZER_IMAGE="//*[@id='section-body']/div[1]/div/div/div[2]/div[1]/div/div[1]/div/div/img";
	String SECTION_HEADER_XPATH = "//section[@id='section-header']";
	String XPATH_IMAGEELEMENT_NASCAR="html/body/div[2]/div/header/div[2]/div[2]/div/a[2]/h2";
	String CROWD_GOES_LOGO="//div[@class='main-page-header']/div/a";
	String PROPERPAGE_LINK="(//div[@class='buzzer-header']/a)[1]";

	String POPUP_XPATH = "//div[contains(@class, 'screenLayers')]/descendant::section[@class='vanillaPopup']//descendant::div[@class='swingLeft left']";
}
