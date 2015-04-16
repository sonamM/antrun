package com.etouch.fox.watch.pages.elements;

public interface VideoCreatorPageElement {
	String TXT_USERNAME="//*[@id='username']";
	String TXT_PASSWORD="//*[@id='password']";
	
	String BOTTON_LOGIN="//*[@id='login']/button";
	String FRAME_XPATH="//iframe[@id='cq-cf-frame']";
	
	String PRIMARY_DROPDOWN_IMAGE ="//input[@id='ext-comp-1016']";
	
	String PRIMARY_TEXTBOX_OPTION = "//div[@id='cq-gen271']/div[2]";
	String PRIMARY_TEXTBOX_OPTION_IE = "//div[@id='cq-gen321']/div[2]";
	
	String GENERAL_ARROW_IMAGE = "//div[@id='cq-gen234']";
	String GENERAL_ARROW_IMAGE_IE = "//div[@id='cq-gen273']";
	
	String CHECK_HIDE_COMMENTS = "//input[@id='hideComments']";
		
}
