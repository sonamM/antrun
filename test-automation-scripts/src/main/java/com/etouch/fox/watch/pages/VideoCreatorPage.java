package com.etouch.fox.watch.pages;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.rest.ResultType;

import com.etouch.fox.common.pages.CommonPage;
import com.etouch.fox.watch.pages.elements.VideoCreatorPageElement;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Button;
import com.etouch.taf.webui.selenium.webelement.CheckBox;
import com.etouch.taf.webui.selenium.webelement.Image;
import com.etouch.taf.webui.selenium.webelement.TextBox;

public class VideoCreatorPage extends CommonPage {

	WebElement webElement = null;
	TextBox primaryText = null;
	Image generalArrow = null;
	boolean flag = false;
	private static Log log = LogUtil.getLog(VideoCreatorPage.class);

	public VideoCreatorPage(String sbPageUrl, WebPage webPage) {
		super(sbPageUrl, webPage);
		loadPage();
	}

//	public boolean enterCredentials(String username, String password) {
//		String pageElement = null;
//		try {
//			TextBox tbUserName = webPage.findPageObjectByXPath(
//					VideoCreatorPageElement.TXT_USERNAME, -1, null,
//					IPageObjectType.TextBox);
//			TextBox tbPassword = webPage.findPageObjectByXPath(
//					VideoCreatorPageElement.TXT_PASSWORD, -1, null,
//					IPageObjectType.TextBox);
//			Button buttonLogin = webPage.findPageObjectByXPath(
//					VideoCreatorPageElement.BOTTON_LOGIN, -1, null,
//					IPageObjectType.Button);
//			tbUserName.enterText(username);
//			tbPassword.enterText(password);
//			buttonLogin.clickButton();
//			flag = true;
//			
//		} catch (PageException e) {
//			log.error(e.getMessage());
//			flag = false;
//			setErrMessage(ResultType.ERROR, pageElement,
//					webPage.getCurrentUrl(), username + "," + password,
//					String.valueOf(flag), e.getMessage());
//		}
//		return flag;
//	}
//
//	public String navigateVideoCreator(String url) {
//		String navigatre_url = null;
//		String pageElement = null;
//
//		try {
//			webPage.navigateToUrl(url);
//			webPage.sleep(5000);
//			navigatre_url = webPage.getCurrentUrl();
//
//		} catch (Exception e) {
//			log.error(e.getMessage());
//			flag = false;
//			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), url, navigatre_url, e.getMessage());
//		}
//		return navigatre_url;
//	}
//
//	/**
//	 * to select the primary category
//	 * 
//	 * @throws InterruptedException
//	 * @throws PageException
//	 * */
//
//	public boolean selectPrimaryCategory() throws InterruptedException {
//		String expectedResult = null;
//		String pageElement = null;
//		try {
//			webPage.getDriver()
//					.switchTo()
//					.frame(webPage.getDriver().findElement(
//							By.xpath(VideoCreatorPageElement.FRAME_XPATH)));
//			webPage.sleep(5000);
//
//			Image dropDownImage = webPage.findPageObjectByXPath(
//					VideoCreatorPageElement.PRIMARY_DROPDOWN_IMAGE, 20, null,
//					IPageObjectType.Image);
//			dropDownImage.click();
//
//			if (BrowserInfoUtil.INSTANCE.isIE8()
//					|| BrowserInfoUtil.INSTANCE.isIE9()
//					|| BrowserInfoUtil.INSTANCE.isIE10()) {
//
//				primaryText = webPage.findPageObjectByXPath(
//						VideoCreatorPageElement.PRIMARY_TEXTBOX_OPTION_IE, 10,
//						null, IPageObjectType.TextBox);
//
//			} else {
//
//				primaryText = webPage.findPageObjectByXPath(
//						VideoCreatorPageElement.PRIMARY_TEXTBOX_OPTION, 10,
//						null, IPageObjectType.TextBox);
//
//			}
//			primaryText.hover(webPage.getDriver());
//			primaryText.click();
//			webPage.sleep(5000);
//			flag = true;
//		} catch (PageException e) {
//			log.error(e.getMessage());
//			flag = false;
//			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), expectedResult,String.valueOf(flag), e.getMessage());
//
//		}
//		return flag;
//	}
//
//	/**
//	 * to click the Hide Comments Check Box
//	 * 
//	 * @throws InterruptedException
//	 * @throws PageException
//	 * */
//
//	public boolean clickHideCommentsCheckBox() throws InterruptedException {
//		String expectedResult = null;
//		String pageElement = null;
//		try {
//			webPage.sleep(10000);
//			webPage.getDriver()
//					.switchTo()
//					.frame(webPage.getDriver().findElement(
//							By.xpath(VideoCreatorPageElement.FRAME_XPATH)));
//			webPage.sleep(10000);
//
//			if (BrowserInfoUtil.INSTANCE.isIE8()
//					|| BrowserInfoUtil.INSTANCE.isIE9()
//					|| BrowserInfoUtil.INSTANCE.isIE10()) {
//				generalArrow = webPage.findPageObjectByXPath(
//						VideoCreatorPageElement.GENERAL_ARROW_IMAGE_IE,
//						IPageObjectType.Image);
//
//			} else {
//
//				generalArrow = webPage.findPageObjectByXPath(
//						VideoCreatorPageElement.GENERAL_ARROW_IMAGE,
//						IPageObjectType.Image);
//
//			}
//			generalArrow.click();
//			CheckBox hideComments = webPage.findPageObjectByXPath(
//					VideoCreatorPageElement.CHECK_HIDE_COMMENTS,
//					IPageObjectType.CheckBox);
//			hideComments.checkBox_click();
//			webPage.getDriver().switchTo().defaultContent();
//			flag = true;
//		} catch (PageException e) {
//			log.error(e.getMessage());
//			flag = false;
//			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), expectedResult,String.valueOf(flag), e.getMessage());
//
//		} catch (NoSuchElementException e) {
//			log.error(e.getMessage());
//			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(),null, null, e.getMessage());
//			flag = false;
//		}
//		return flag;
//	}

}
