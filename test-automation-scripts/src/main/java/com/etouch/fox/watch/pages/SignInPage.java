package com.etouch.fox.watch.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;

import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.rest.ResultType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.etouch.fox.email.EmailTestHelper;
import com.etouch.fox.common.pages.CommonPage;
import com.etouch.fox.common.pages.FoxSportsFooterPage;
import com.etouch.fox.watch.pages.elements.SignInPageElements;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.exception.ValidationException;
import com.etouch.taf.infra.mail.EmailValidator;
import com.etouch.taf.infra.mail.IEmailValidator;
import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Button;
import com.etouch.taf.webui.selenium.webelement.CheckBox;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.webui.selenium.webelement.Text;
import com.etouch.taf.webui.selenium.webelement.TextBox;

/**
 * Page Class for SignUpModalPage page. It calls the Framework APIs.
 *
 * Test Class resembles the test specification. Page Class resembles the test
 * implementation
 *
 * @author eTouch Systems Corporation
 *
 */
public class SignInPage extends CommonPage {
	private FoxSportsFooterPage	foxSportsFooterPage;
	// private static int linkTextIndex = 1;
	private static Log	        log	             = LogUtil.getLog(SignInPage.class);
	String	                    pageElementXpath	= null;

	/**
	 *
	 * @param sbPageUrl
	 * @param webPage
	 */
	public SignInPage(String sbPageUrl, WebPage webPage) {
		super(sbPageUrl, webPage);
		this.foxSportsFooterPage = new FoxSportsFooterPage(this.webPage);
		loadPage();
	}
//
//	/**
//	 *
//	 * @return
//	 */
//	public FoxSportsFooterPage getFoxSportsFooterPage() {
//		return foxSportsFooterPage;
//	}
//
//	/**
//	 *
//	 * @return
//	 */
//	public String getPageUrl() {
//		String crowd_url = webPage.getCurrentUrl();
//		return crowd_url;
//	}
//
//	/**
//	 *
//	 */
//	public void scrollWindow() {
//		webPage.sleep(100000);
//		webPage.getDriver().manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
//		JavascriptExecutor js = (JavascriptExecutor) webPage.getDriver();
//		js.executeScript("window.scrollBy(0,1200)", "");
//	}
//
//	/**
//	 *
//	 * @return
//	 */
//	public Point getScrollPosition() {
//		JavascriptExecutor js = (JavascriptExecutor) webPage.getDriver();
//
//		Long ycoordinate = (Long) js.executeScript("return window.pageYOffset", "");
//		Long xcoordinate = (Long) js.executeScript("return window.pageXOffset", "");
//		return new Point(xcoordinate.intValue(), ycoordinate.intValue());
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @return
//	 */
//	public String clickSignIn(String expectedValue) {
//		String welcomeText = null;
//		try {
//			webPage.sleep(100000);
//			pageElementXpath = SignInPageElements.Sign_IN_Xpath;
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Link)).click();
//			webPage.sleep(10000);
//			pageElementXpath = SignInPageElements.Welcome_Frame_xpath;
//			welcomeText = ((Text) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, welcomeText, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return welcomeText;
//	}
//
//	/**
//	 * @param expectedValue
//	 * @return
//	 */
//	public String clicksignUpFrame(String expectedValue) {
//		//webPage.sleep(10000);
//		String signUpText = null;
//		webPage.getDriver().switchTo().frame("JanrainIFrame");
////		                                      JanrainIFrame
//		log.info("entered into frames");
//		try {
//			pageElementXpath = SignInPageElements.Sign_Up_Xpath;
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Link)).click();
//			pageElementXpath = SignInPageElements.Password_Reset;
//			signUpText = ((Text) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, signUpText, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return signUpText;
//	}
//
//	/**
//	 *
//	 * @param inputvalue
//	 * @param expectedValue
//	 * @return
//	 */
//	public String validateFirstNameForEmpty(String inputvalue, String expectedValue) {
//		String errorText = null;
//		try {
//			pageElementXpath = SignInPageElements.First_Name;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputvalue);
//			pageElementXpath = SignInPageElements.Last_Name;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			webPage.sleep(5000);
//			pageElementXpath = SignInPageElements.First_Name_ErrMsg;
//			errorText = ((Text) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, errorText, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return errorText;
//	}
//
//	/**
//	 *
//	 * @param inputText
//	 * @param expectedValue
//	 * @return
//	 */
//	public String validateFirsNameSpecialChar(String inputText, String expectedValue) {
//		String errorText = null;
//		try {
//			pageElementXpath = SignInPageElements.First_Name;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputText);
//			pageElementXpath = SignInPageElements.Last_Name;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			pageElementXpath = SignInPageElements.First_Name_ErrMsg;
//			errorText = ((Text) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, errorText, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return errorText;
//	}
//
//	/**
//	 *
//	 * @param text
//	 * @param expectedValue
//	 * @return
//	 */
//	public boolean validateFirstName(String text, boolean expectedValue) {
//		boolean flag = false;
//		try {
//			pageElementXpath = SignInPageElements.First_Name;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(text);
//			pageElementXpath = SignInPageElements.Last_Name;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			pageElementXpath = SignInPageElements.First_Name_ErrMsg;
//			String message = ((Text) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text)).getText();
//			if (message.isEmpty())
//				flag = true;
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(expectedValue), String.valueOf(flag), e.getMessage());
//			log.error(getErrMessage());
//		}
//		return flag;
//	}
//
//	/**
//	 * @param expectedValue
//	 * @return
//	 */
//	public String forgetpassword(String expectedValue) {
//		String forgettext = null;
//		webPage.sleep(100000);
//		try {
//			pageElementXpath = SignInPageElements.Sign_IN_Xpath;
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Link)).click();
//			webPage.getDriver().switchTo().frame("JanrainIFrame");
//			((Link) webPage.findPageObjectByXPath(SignInPageElements.Forget_Xpath, IPageObjectType.Link)).click();
//			webPage.sleep(10000);
//			forgettext = ((Text) webPage.findPageObjectByXPath(SignInPageElements.Password_Reset, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, forgettext, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return forgettext;
//	}
//
//	/**
//	 *
//	 */
//	public void clickBacklink() {
//		try {
//			((Link) webPage.findPageObjectByXPath(SignInPageElements.Back_xpath, -1, null, IPageObjectType.Link)).click();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), null, null, e.getMessage());
//			log.error(getErrMessage());
//		}
//	}
//
//	/**
//	 * @param expectedValue
//	 * @return
//	 */
//	public String validateWelcome(String expectedValue) {
//		String welcometext = null;
//		webPage.getDriver().switchTo().defaultContent();
//		try {
//			welcometext = ((Text) webPage.findPageObjectByXPath(SignInPageElements.Welcome_Frame_xpath, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, welcometext, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return welcometext;
//	}
//
//	/**
//	 * @param maild
//	 */
//	public void entermail(String maild) {
//		webPage.getDriver().switchTo().frame("JanrainIFrame");
//		try {
//			((TextBox) webPage.findPageObjectByXPath(SignInPageElements.Mail_Textbox_Xpath, -1, null, IPageObjectType.TextBox)).enterText(maild);
//			((Button) webPage.findPageObjectByXPath(SignInPageElements.Send_Xpath, -1, null, IPageObjectType.Button)).click();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), null, null, e.getMessage());
//			log.error(getErrMessage());
//		}
//	}
//
//	/**
//	 * @param expectedValue
//	 * @return
//	 */
//	public String passwordReset(String expectedValue) {
//		String forgettext = null;
//		try {
//			forgettext = ((Text) webPage.findPageObjectByXPath(SignInPageElements.Password_Reset, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, forgettext, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return forgettext;
//	}
//
//	/**
//	 * @param expectedValue
//	 * @return
//	 */
//	public String confirmationMSG(String expectedValue) {
//		String confirmText = null;
//		try {
//			confirmText = ((Text) webPage.findPageObjectByXPath(SignInPageElements.Mail_Confirm_Xpath, IPageObjectType.Text)).getText();
//			webPage.getDriver().switchTo().defaultContent();
//			webPage.sleep(5000);
//			pageElementXpath = SignInPageElements.Login_closeLink;
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link)).click();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, confirmText, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return confirmText;
//	}
//
//	/**
//	 * @param maild
//	 */
//	public void enterproperID(String maild) {
//		try {
//			((TextBox) webPage.findPageObjectByXPath(SignInPageElements.Mail_Textbox_Xpath, -1, null, IPageObjectType.TextBox)).enterText(maild);
//			((Button) webPage.findPageObjectByXPath(SignInPageElements.Send_Xpath, -1, null, IPageObjectType.Button)).click();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), null, null, e.getMessage());
//			log.error(getErrMessage());
//		}
//	}
//
//	/**
//	 *
//	 * @param text
//	 * @param expectedValue
//	 */
//	public void entermail(String text, String expectedValue) {
//		webPage.getDriver().switchTo().frame("JanrainIFrame");
//		log.info("entered into frames");
//		try {
//			pageElementXpath = SignInPageElements.Mail_Textbox_Xpath;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(text);
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, null, e.getMessage());
//			log.error(getErrMessage());
//		}
//	}
//
//	/**
//	 * @param lastName
//	 * @param expectedValue
//	 * @return true if error message matches with the string passed from excel
//	 *         sheet
//	 */
//	public String validateLastNameForSignUp(String lastName, String expectedValue) {
//		String actualMsg = null;
//		try {
//			pageElementXpath = SignInPageElements.TXT_LAST_NAME;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(lastName);
//			pageElementXpath = SignInPageElements.TXT_SCREEN_NAME;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			pageElementXpath = SignInPageElements.TXT_LAST_NAME_ERRORMSG;
//			actualMsg = webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, actualMsg, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return actualMsg;
//	}
//
//	/**
//	 * @param screenName
//	 * @param expectedValue
//	 * @param Screen
//	 *            Name
//	 * @return true if error message matches with the string passed from excel
//	 *         sheet
//	 */
//	public String validateScreenNameForSignUp(String screenName, String expectedValue) {
//		String actualMsg = null;
//		try {
//			pageElementXpath = SignInPageElements.TXT_SCREEN_NAME;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(screenName);
//			pageElementXpath = SignInPageElements.TXT_EMAIL_ADDRESS;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			webPage.sleep(5000);
//			pageElementXpath = SignInPageElements.TXT_SCREEN_NAME_ERRORMSG;
//			actualMsg = webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, actualMsg, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return actualMsg;
//	}
//
//	/**
//	 *
//	 * @param inputValue
//	 * @param expectedValue
//	 * @return
//	 */
//	public String checkEmail(String inputValue, String expectedValue) {
//		String emailValidationMsg = null;
//		try {
//			pageElementXpath = SignInPageElements.TXT_EMAIL_ADDRESS;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputValue);
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			pageElementXpath = SignInPageElements.EMAIL_MSG;
//			emailValidationMsg = ((Text) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, emailValidationMsg, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return emailValidationMsg;
//	}
//
//	/**
//	 *
//	 * @param password
//	 * @param expectedValue
//	 * @param message
//	 * @return true if error message matches with the string passed from excel
//	 *         sheet
//	 */
//	public String validatePasswordForSignUp(String password, String expectedValue) {
//		String actualMsg = null;
//		try {
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(password);
//			pageElementXpath = SignInPageElements.TXT_CONFIRMPWD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			pageElementXpath = SignInPageElements.TXT_PASSWORD_ERRORMSG;
//			actualMsg = webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text).getText();
//			log.info("Password entered :- " + password);
//			pageElementXpath = SignInPageElements.TXT_PASSWORD_ERRORMSG;
//			log.info("Actual Message :- " + webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text).getText());
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, actualMsg, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return actualMsg;
//	}
//
//	/**
//	 *
//	 * @param reTypePassword
//	 * @param expectedValue
//	 * @param password
//	 * @param message
//	 * @return true if error message matches with the string passed from excel
//	 *         sheet
//	 */
//	public String validateReTypePasswordForSignUp(String reTypePassword, String expectedValue) {
//		String actualMsg = null;
//		try {
//			log.info(" RetypeValues In Beginging:- " + reTypePassword);
//			pageElementXpath = SignInPageElements.TXT_CONFIRMPWD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(reTypePassword);
//			// get sign up button
//			pageElementXpath = SignInPageElements.BUTTON_SIGN_UP_XPATH;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).clickButton();
//			// click on signup button
//			pageElementXpath = SignInPageElements.TXT_RETYPE_PASSWORD_ERRORMSG;
//			actualMsg = webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, actualMsg, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return actualMsg;
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @param checkbox
//	 * @param message
//	 * @return true if error message matches with the string passed from
//	 */
//	public boolean clickFirstCheckBox(boolean expectedValue) {
//		boolean flag = false;
//		try {
//			pageElementXpath = SignInPageElements.CHECKBOX_FIRST;
//			((CheckBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.CheckBox)).checkBox_click();
//			webPage.sleep(10000);
//			flag = true;
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(expectedValue), String.valueOf(flag), e.getMessage());
//			log.error(getErrMessage());
//		}
//		return flag;
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @return
//	 */
//	public String validateCheckBox(String expectedValue) {
//		String actualErrorMessage = null;
//		try {
//			pageElementXpath = SignInPageElements.BUTTON_SIGN_UP_XPATH;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).clickButton();
//			webPage.sleep(10000);
//			pageElementXpath = SignInPageElements.CHECKBOX_ERRORMSG;
//			actualErrorMessage = ((Text) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, actualErrorMessage, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return actualErrorMessage;
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @return
//	 */
//	public boolean clickSecondCheckBox(boolean expectedValue) {
//		boolean flag = false;
//		try {
//			pageElementXpath = SignInPageElements.CHECKBOX_SECOND;
//			((CheckBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.CheckBox)).checkBox_click();
//			webPage.sleep(10000);
//			flag = true;
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(expectedValue), String.valueOf(flag), e.getMessage());
//			log.error(getErrMessage());
//		}
//		return flag;
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @return
//	 */
//	public String clickLinkPrivacyPolicy(String expectedValue) {
//		String actualUrl = null;
//		try {
//			pageElementXpath = SignInPageElements.LINK_PRIVACY_POLICY;
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link)).click();
//			webPage.openNewTab();
//			actualUrl = webPage.getCurrentUrl();
//			webPage.sleep(3000);
//			webPage.close_toggleWindow();
//			webPage.sleep(30000);
//			log.info("webPage.getCurrentUrl() ::::::::::::::::::::::" + webPage.getCurrentUrl());
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, actualUrl, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return actualUrl;
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @return
//	 */
//	public String clickLinkTermsOfUse(String expectedValue) {
//		String actualUrl = null;
//		webPage.sleep(30000);
//		log.info("\n\n clickLinkTermsOfUse : start : ");
//		try {
//			webPage.getDriver().switchTo().frame(SignInPageElements.JanrainIFrame);
//			log.info("swwwwwwwwwwwwwitched to janrain frame");
//			pageElementXpath = SignInPageElements.Terms_Of_Use;
//			Link linkTermsOfUse = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link);
//			linkTermsOfUse.click();
//			webPage.sleep(5000);
//			webPage.toggleWindow();
//			webPage.sleep(5000);
//			actualUrl = webPage.getCurrentUrl();
//			webPage.close_toggleWindow();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, actualUrl, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return actualUrl;
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @return
//	 */
//	public String clickLinkMicrosoft(String expectedValue) {
//		String actualUrl = null;
//		log.info("\n\n clickLinkMicrosoft : start : ");
//		try {
//			webPage.getDriver().switchTo().frame(SignInPageElements.JanrainIFrame);
//			log.info("swwwwwwwwwwwwwitched to janrain frame");
//			pageElementXpath = SignInPageElements.LINK_Microsoft;
//			Link linkMicrosoft = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link);
//			linkMicrosoft.click();
//			webPage.sleep(5000);
//			webPage.toggleWindow();
//			webPage.sleep(5000);
//			actualUrl = webPage.getCurrentUrl();
//			webPage.close_toggleWindow();
//			// will have to remove this once TC 9, 10 and 11 are completed.
//			webPage.sleep(5000);
//			System.out.println("I am in clickMicrosoft");
//			pageElementXpath = SignInPageElements.backLink;
//
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link)).click();
//			System.out.println("I have clicked");
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, actualUrl, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return actualUrl;
//	}
//
//	Random	rd	= new Random();
//
//	/**
//	 *
//	 */
//	public void clicksignUpButton() {
//		log.info("\n\n entering unique values to create an account ");
//		try {
//			webPage.sleep(20000);
//			// webPage.getDriver().switchTo().frame(SignInPageElements.JanrainIFrame);
//			// log.info("swwwwwwwwwwwwwitched to janrain frame");
//			int randomNum = rd.nextInt();
//			pageElementXpath = SignInPageElements.First_Name;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText("firstName" + randomNum);
//			pageElementXpath = SignInPageElements.TXT_LAST_NAME;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText("lastName" + randomNum);
//			pageElementXpath = SignInPageElements.TXT_SCREEN_NAME;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText("screenName" + randomNum);
//			pageElementXpath = SignInPageElements.TXT_EMAIL_ADDRESS;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText("email" + randomNum + "@email.com");
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText("password" + randomNum);
//			pageElementXpath = SignInPageElements.TXT_CONFIRMPWD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText("password" + randomNum);
//			pageElementXpath = SignInPageElements.CHECKBOX_SECOND;
//			((CheckBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.CheckBox)).checkBox_click();
//			pageElementXpath = SignInPageElements.BUTTON_SIGN_UP_XPATH;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, IPageObjectType.Button)).clickButton();
//			webPage.sleep(6000);
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), null, null, e.getMessage());
//			log.error(getErrMessage());
//		}
//	}
//
//	
//	public String clickSubLink(String xpath,WebDriver webDriver,String expectedURL) throws InterruptedException{
//        String url = null;
//        try 
//        {
//             Link link = webPage.findPageObjectByXPath(xpath, IPageObjectType.Link );
//             webPage.sleep(1000);   
//             log.info("Sub link text clicked----------------------------" + link.getText());
//                if (BrowserInfoUtil.INSTANCE.isSafari())
//                {
//                    link.clickEvent(webDriver);
//                }
//                else 
//                {
//                    link.click();
//                }
//                webPage.toggleWindow();
//                url=webDriver.getCurrentUrl();
//                webPage.sleep(1000);
//                webPage.close_toggleWindow();
//        } 
//        catch (PageException e) 
//        {
//            log.error(e.getMessage());
//            setErrMessage(
//                        ResultType.ERROR,
//                        null,
//                        webPage.getCurrentUrl(),
//                        expectedURL,
//                        url,
//                        e.getMessage());
//        }
//        
//    
//        return url;
//    }   
//	
//	/**
//	 *
//	 */
//	public void clickAcceptButton() {
//		log.info("\n\n clickAcceptButton" + " : start : ");
//		try {
//			Button accept = webPage.findPageObjectByXPath(SignInPageElements.ACCEPT_BUTTON, IPageObjectType.Button);
//			webPage.sleep(20000);
//			accept.click();
//			webPage.sleep(6000);
//		} catch (PageException e) {
//			log.info("\n\n clickAcceptButton : catch : ");
//			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(), null, null, e.getMessage());
//		}
//	}
//
//	/**
//	 *
//	 * @param inputComment
//	 * @param expectedValue
//	 * @return
//	 */
//	public String check_VerifyEmail(String inputComment, String expectedValue) {
//		String verifyEmail_SectionHeader = null;
//		try {
//			// webPage.getDriver().switchTo().defaultContent();
//			// webPage.sleep(20000);
//			// pageElementXpath = SignInPageElements.Login_closeLink;
//			// ((Link) webPage.findPageObjectByXPath(pageElementXpath, -1, null,
//			// IPageObjectType.Link)).click();
//			webPage.sleep(20000);
//			((TextBox) webPage.findPageObjectByXPath("//*[@id='livefyre']/div/div/div[4]/div/div[1]", -1, null, IPageObjectType.TextBox)).click();
//			webPage.getDriver().switchTo().frame("fyre-editor-300");
//			webPage.sleep(30000);
//			pageElementXpath = SignInPageElements.COMMENT;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputComment);
//			webPage.getDriver().switchTo().defaultContent();
//			pageElementXpath = SignInPageElements.POST_COMMENT;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).click();
//			pageElementXpath = SignInPageElements.VERIFYEMAIL_SECTION_HEADER;
//			verifyEmail_SectionHeader = ((Text) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, verifyEmail_SectionHeader, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return verifyEmail_SectionHeader;
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @return
//	 */
//	public boolean closeVerifyEmail_popUp(boolean expectedValue) {
//		Boolean isPopupOpen = null;
//		try {
//			pageElementXpath = SignInPageElements.DONE;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).click();
//			pageElementXpath = SignInPageElements.VERIFYEMAIL_SECTION_HEADER;
//			isPopupOpen = ((Text) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text)).isDisplayed();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(expectedValue), String.valueOf(isPopupOpen), e.getMessage());
//			log.error(getErrMessage());
//		}
//		return isPopupOpen;
//	}
//
//	/**
//	 *
//	 * @param driver
//	 */
//	public void waitForPageLoaded(WebDriver driver) {
//		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//			public Boolean apply(WebDriver driver) {
//				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//			}
//		};
//		Wait<WebDriver> wait = new WebDriverWait(driver, 30);
//		try {
//			wait.until(expectation);
//		} catch (Throwable error) {
//			log.info("in Throwable error of waitForPageLoaded()");
//			// assertFalse("Timeout waiting for Page Load Request to complete.",true);
//		}
//	}
//
//	/**
//	 *
//	 * @param expectedValue
//	 * @return
//	 */
//	public String verify_forgot_password(String expectedValue) {
//		String password_reset = null;
//		try {
//			webPage.sleep(20000);
//			// JRLFBundle.js
//			// waitForPageLoaded(webPage.getDriver());
//			pageElementXpath = SignInPageElements.SHOW_COMMENTS_PATH;
//			validateLink(pageElementXpath);
//			// Selenium.waitForPageToLoad("timeout");
//			webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link).click();
//			webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link).click(BrowserInfoUtil.INSTANCE);
//			webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link).clickEvent(webPage.getDriver());
//			webPage.sleep(5000);
//			((JavascriptExecutor) webPage.getDriver()).executeScript("window.scrollBy(0,200)", "");
//			// webPage.sleep(20000);
//			pageElementXpath = SignInPageElements.SIGNIN;
//			validateLink(pageElementXpath);
//			// focus to new/changed modal panel
//			webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link).click();
//			log.info("sign in clicked waiting for popup open ...............");
//			webPage.sleep(5000);
//			((Link) webPage.findPageObjectByXPath("LoginscreenLayer", -1, null, IPageObjectType.Link)).click();
//			// webPage.getDriver().switchTo();
//			webPage.sleep(5000);
//			pageElementXpath = SignInPageElements.forgot_password;
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, -1, SignInPageElements.JanrainIFrame, IPageObjectType.Link)).click();
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, -1, SignInPageElements.JanrainIFrame, IPageObjectType.Link)).click(BrowserInfoUtil.INSTANCE);
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, -1, SignInPageElements.JanrainIFrame, IPageObjectType.Link)).clickEvent(webPage.getDriver());
//			webPage.sleep(5000);
//			pageElementXpath = SignInPageElements.password_reset;
//			password_reset = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, password_reset, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return password_reset;
//	}
//
//	/**
//	 *
//	 * @param link
//	 * @return
//	 */
//	public Boolean validateLink(String link) {
//		WebDriver driver = webPage.getDriver();
//		final int MAXIMUM_WAIT_TIME = 10;
//		WebDriverWait wait = new WebDriverWait(driver, MAXIMUM_WAIT_TIME);
//		try {
//			wait.until(elementToBeClickable(By.xpath(link)));
//			return true;
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	/**
//	 *
//	 * @param inputValue
//	 * @param expectedValue
//	 * @return
//	 */
//	public String verify_signIn(String inputValue, String expectedValue) {
//		String signin_errors = null;
//		try {
//			webPage.sleep(30000);
//			pageElementXpath = SignInPageElements.SIGNIN;
//			((Link) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Link)).click();
//			webPage.sleep(30000);
//			pageElementXpath = SignInPageElements.backModal;
//			String welcome = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text).getText();
//			webPage.sleep(30000);
//			webPage.getDriver().switchTo().frame(SignInPageElements.JanrainIFrame);
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputValue);
//			pageElementXpath = SignInPageElements.signin_btn;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).clickButton();
//			webPage.sleep(10000);
//			pageElementXpath = SignInPageElements.signin_errors;
//			signin_errors = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, signin_errors, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return signin_errors;
//	}
//
//	/**
//	 *
//	 * @param inputValue
//	 * @param expectedValue
//	 * @return
//	 */
//	public String signIn_checkEmail(String inputValue, String expectedValue) {
//		String emailValidationMsg = null;
//		try {
//			pageElementXpath = SignInPageElements.TXT_EMAIL_ADDRESS;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputValue);
//			webPage.sleep(15000);
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			webPage.sleep(10000);
//			pageElementXpath = SignInPageElements.EMAIL_MSG;
//			emailValidationMsg = ((Text) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text)).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, emailValidationMsg, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return emailValidationMsg;
//	}
//
//	/**
//	 *
//	 * @param inputValue
//	 * @param expectedValue
//	 * @return
//	 */
//	public String signIn_emptyPassword(String inputValue, String expectedValue) {
//		String signin_errors = null;
//		try {
//			webPage.sleep(10000);
//			pageElementXpath = SignInPageElements.TXT_EMAIL_ADDRESS;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputValue);
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			pageElementXpath = SignInPageElements.signin_btn;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).clickButton();
//			webPage.sleep(10000);
//			pageElementXpath = SignInPageElements.signin_errors;
//			signin_errors = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, signin_errors, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return signin_errors;
//	}
//
//	/**
//	 *
//	 * @param inputValue
//	 * @param expectedValue
//	 * @return
//	 */
//	public String signIn_invalidPassword(String inputValue, String expectedValue) {
//		String signin_errors = null;
//		try {
//			webPage.sleep(10000);
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputValue);
//			pageElementXpath = SignInPageElements.signin_btn;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).clickButton();
//			pageElementXpath = SignInPageElements.signin_errors;
//			signin_errors = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, signin_errors, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return signin_errors;
//	}
//
//	/**
//	 *
//	 * @param inputUserNameValue
//	 * @param inputPasswordValue
//	 * @param expectedValue
//	 * @return
//	 */
//	public String signIn_invalidUser(String inputUserNameValue, String inputPasswordValue, String expectedValue) {
//		String signin_errors = null;
//		try {
//			pageElementXpath = SignInPageElements.TXT_EMAIL_ADDRESS;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputUserNameValue);
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputPasswordValue);
//			pageElementXpath = SignInPageElements.signin_btn;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).clickButton();
//			pageElementXpath = SignInPageElements.signin_errors;
//			signin_errors = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, signin_errors, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return signin_errors;
//	}
//
//	/**
//	 *
//	 * @param inputValue
//	 * @param expectedValue
//	 * @return
//	 */
//	public String signIn_clearPassword(String inputValue, String expectedValue) {
//		String signin_errors = null;
//		try {
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputValue);
//			webPage.sleep(5000);
//			pageElementXpath = SignInPageElements.TXT_EMAIL_ADDRESS;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).click();
//			webPage.sleep(15000);
//			pageElementXpath = SignInPageElements.TXT_PASSWORD_ERRORMSG;
//			signin_errors = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, signin_errors, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return signin_errors;
//	}
//
//	/**
//	 *
//	 * @param inputValue1
//	 * @param inputValue2
//	 * @param expectedValue
//	 * @return
//	 */
//	public String signIn_success(String inputValue1, String inputValue2, String expectedValue) {
//		String ScreenName = null;
//		try {
//			pageElementXpath = SignInPageElements.TXT_EMAIL_ADDRESS;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputValue1);
//			pageElementXpath = SignInPageElements.PASSWORD;
//			((TextBox) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.TextBox)).enterText(inputValue2);
//			pageElementXpath = SignInPageElements.signin_btn;
//			((Button) webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Button)).clickButton();
//			webPage.sleep(30000);
//			if (BrowserInfoUtil.INSTANCE.isChrome() || BrowserInfoUtil.INSTANCE.isIE9() || BrowserInfoUtil.INSTANCE.isIE10() || BrowserInfoUtil.INSTANCE.isIE8() || BrowserInfoUtil.INSTANCE.isSafari()
//			        || BrowserInfoUtil.INSTANCE.isFF()) {
//				((JavascriptExecutor) webPage.getDriver()).executeScript("window.scrollBy(0,1200)", "");
//			}
//			webPage.sleep(20000);
//			pageElementXpath = SignInPageElements.loggedin_ScreenName;
//			ScreenName = webPage.findPageObjectByXPath(pageElementXpath, -1, null, IPageObjectType.Text).getText();
//		} catch (PageException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, ScreenName, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return ScreenName;
//	}
//
//	/**
//	 *
//	 * @param props
//	 * @param checkUrlPattern
//	 * @param emailSubjectText
//	 * @return
//	 */
//	public boolean signIn_EmailRegisLinkPresent(Properties props, String checkUrlPattern, String emailSubjectText) {
//		IEmailValidator emailValidator = new EmailValidator();
//		boolean isValidEmail = false;
//		//Added the lookup Text from the excel data sheet into to Properties
//		//TODO: do not hard code the strings
//		props.put("mailLookupString", checkUrlPattern);
//		props.put("matchSubJectLike", emailSubjectText);
//
//		try {
//			isValidEmail = emailValidator.validateEmail(props);
//		} catch (ValidationException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), checkUrlPattern, emailSubjectText, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return isValidEmail;
//
//	}
//
//	/**
//	 *
//	 * @param props
//	 * @param checkUrlPattern
//	 * @param emailSubjectText
//	 * @return
//	 */
//	public boolean signIn_VerifyEmailRegistrationPage(Properties props, String checkUrlPattern, String emailSubjectText, String textData) {
//		IEmailValidator emailValidator = new EmailValidator();
//		//TODO: move the implicit wait functions from BuzzerPage to WebPage (in library)
//		BuzzerPage buzzerPage;
//		int index;
//		//Added the lookup Text from the excel data sheet into to Properties
//		//TODO: do not hard code the strings
//		props.put("mailLookupString", checkUrlPattern);
//		props.put("matchSubJectLike", emailSubjectText);
//
//		try {
//			List<String> emailBodyContents = emailValidator.retriveEmailBodyContentFromMessages(props);
//
//			List<String> checkUrls = new EmailTestHelper().retriveUrlsFromEmailBody(emailBodyContents, props);
//
//			for(String url : checkUrls)
//			{
//				index = 0;
//				buzzerPage = new BuzzerPage(url, webPage);
//				buzzerPage.waitForPageload();
//
//				List<String> text_data = buzzerPage.getBuzzerPopupText();
//				if(text_data.size() > 0)
//				{
//					String[] array = text_data.toArray(new String[text_data.size()]);
//					if(!array[index++].equals(textData)){
//						return false;
//					}
//				}
//			}
//		} catch (ValidationException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), checkUrlPattern, emailSubjectText, e.getMessage());
//			log.error(getErrMessage());
//		}catch (ArrayStoreException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), checkUrlPattern, emailSubjectText, e.getMessage());
//			log.error(getErrMessage());
//		}catch (NullPointerException e) {
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), checkUrlPattern, emailSubjectText, e.getMessage());
//			log.error(getErrMessage());
//		}
//		return true;
//	}

}
