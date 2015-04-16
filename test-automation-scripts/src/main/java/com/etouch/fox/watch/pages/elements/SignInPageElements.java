package com.etouch.fox.watch.pages.elements;

/**
 * @author
 *
 */
public interface SignInPageElements {

	String	LINK_PRIVACY_POLICY	         = ".//*[@id='agreeToTermsAndConditions_form_item']/label/a[1]";
	String	POST_COMMENT	             = "//*[@id=':9b']/div/div";
	String	CHECKBOX_ERRORMSG	         = "//*[@id='agreeToTermsAndConditions_form_item']/div";
	String	CHECKBOX_SECOND	             = "//*[@id='agreeToTermsAndConditions_input']";
	String	password_reset	             = "//*[@id='capture']/div[1]/h1";
	String	DONE	                     = "//*[@id='CaptureDoneElem']";
	String	EMAIL_MSG	                 = "//*[@id='email_form_item']/div[3]";
	String	TXT_EMAIL_ADDRESS	         = "//*[@id='email_input']";
	String	TXT_LAST_NAME_ERRORMSG	     = "//*[@id='familyName_form_item']/div[3]";
	String	TXT_LAST_NAME	             = "//*[@id='familyName_input']";
	String	TXT_SCREEN_NAME_ERRORMSG	 = "//*[@id='FSCOM_SCREENNAME_form_item']/div[3]";
	String	TXT_SCREEN_NAME	             = "//*[@id='FSCOM_SCREENNAME_input']";
	String	COMMENT	                     = "//*[@id='fyre-editor-300']/p";
	String	TXT_FIRST_NAME	             = "//*[@id='givenName_input']";
	String	SIGNUP_NEED_HELP	         = "//*[@id='HelpLink']/span";
	String	SIGNUP	                     = "//*[@id='legacy_register']/a";
	String	SIGNIN	                     = "//*[@id='livefyre']/div/div/div[3]/div[1]/a";
	String	loggedin_ScreenName	         = "//*[@id='livefyre']/div/div/div[3]/div[1]/div/a/span";
	String	VERIFYEMAIL_SECTION_HEADER	 = "//*[@id='Logincontent']/section/header";
	String	backModal	                 = "//*[@id='Logincontent']/section/header/div/div/div/div";
	String	CHECKBOX_FIRST	             = "//*[@id='optIns_FOXSports_optInStatus']";
	String	TXT_RETYPE_PASSWORD_ERRORMSG	= "//*[@id='password_confirm_form_item']/div[3]";
	String	TXT_CONFIRMPWD	             = "//*[@id='password_confirm_input']";
	String	TXT_PASSWORD_ERRORMSG	     = "//*[@id='password_form_item']/div[3]";
	String	PASSWORD	                 = "//*[@id='password_input']";
	String	SIGNUP_PRIVACYPOLICY	     = "//*[@id='PrivacyPolicyLink']/span";
	String	back	                     = "//*[@id='recover_password_back']";
	String	recoveryStatus	             = "//*[@id='recover_password_status']";
	String	forgot_password	             = "//*[@id='recover_password_url']";
	String	BUTTON_SIGN_UP_XPATH	     = "//*[@id='register']";
	String	send	                     = "//*[@id='send']";
	String	SIGNUP_WHATS_SHARED	         = "//*[@id='SharedLink']/span";
	String	SHOW_COMMENTS_PATH	         = "//*[@id='showComments']";
	String	signin_btn	                 = "//input[@id='signin']";
	String	signin_errors	             = "//*[@id='signin_errors']";
	String	SIGNUP_TERMS_OF_USE	         = "//*[@id='TermsOfUseLink']/span";
	String	Back_xpath	                 = "//a[@id='recover_password_back']";
	String	Forget_Xpath	             = "//a[@id='recover_password_url']";
	String	Sign_IN_Xpath	             = "//*[@id='livefyre']/div/div/div[3]/div[1]/a";
	                                       //*[@id='livefyre']/div/div/div[3]/div[1]/a
	String	Terms_Of_Use	             = "//*[@id='agreeToTermsAndConditions_form_item']/label/a[2]";
	String	LINK_Microsoft	             = "//*[@id='agreeToTermsAndConditions_form_item']/label/a[3]";
	String	Password_Reset	             = "//div[@id='capture']/div[1]/h1";
	String	Frame_Xpath	                 = "//div[@id='ContentIFrameParent']/iframe";
	String	First_Name_ErrMsg	         = "//div[@id='givenName_form_item']/div[3]";
	String	showcomments	             = "//div[@id='showComments']";
	String	Mail_Textbox_Xpath	         = "//input[@id='email_input']";
	String	Last_Name	                 = "//input[@id='familyName_input']";
	String	First_Name	                 = "//input[@id='givenName_input']";
	String	Sign_Up_Xpath	             = "//p[@id='legacy_register']/a";
	
	String	Junk_Char	                 = "@";
	String	First_Name_Text	             = "FOXSPORTS";
	String	Welcome_Frame_xpath	         = "html/body/div[11]/div/div[2]/section/header/div/div/div/div";
	String	SIGNIN_FULL	                 = "html/body/div[2]/div/div[2]/div[1]/div[2]/section[3]/div[1]/div/div/div[1]/div/div[4]/div[3]/div/div/div/div[3]/div[1]/a";
	String	signIn_Frame_Xpath	         = "html/body/div[2]/div[2]/div[1]/p/a";
	String	JanrainIFrame	             = "JanrainIFrame";
	String	SHOWCOMMENTS_ID	             = "showComments";
	String	SHOWCOMMENTS_TEXT	         = "SHOWCOMMENTS";
	String	ACCEPT_BUTTON	             = "//*[@id='yes']";
	String	Send_Xpath	                 = "//input[@id='send']";
	String	Mail_Confirm_Xpath	         = "//p[@id='recover_password_status]";
	String	Login_closeLink	             = "//*[@id='Logincontent']/section/header/div/div";
	String  backLink                     = "//*[@id='back_hyperlink']/p/a";
			//"html/body/div[11]/div/div[2]/section/header/div/div/a";
	
	////*[@id='LogincloseLink']/span/img
	                 //                    = html/body/div[12]/div/div[2]/section/header/div/div/a/span/img
	
}