package com.etouch.fox.watch.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.server.rest.ResultType;

import com.etouch.fox.common.pages.CommonPage;
import com.etouch.fox.common.pages.FoxSportsFooterPage;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.elements.BuzzerPageVideoLinkElements;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Image;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.webui.selenium.webelement.Video;

/**
 * Page Class for BuzzerPageVideoLink. It calls the Framework APIs.
 * 
 * Test Class resembles the test specification. Page Class resembles the test
 * implementation
 * 
 * @author eTouch Systems Corporation
 * 
 */
public class BuzzerPageVideoLink extends CommonPage {
	private FoxSportsFooterPage foxSportsFooterPage;
	private static int linkTextIndex = 1;
	private static Log log = LogUtil.getLog(BuzzerPage.class);

	public BuzzerPageVideoLink(String sbPageUrl, WebPage webPage) {
		super(sbPageUrl, webPage);
		this.foxSportsFooterPage = new FoxSportsFooterPage(this.webPage);
		loadPage();
	}

	public FoxSportsFooterPage getFoxSportsFooterPage() {
		return foxSportsFooterPage;
	}

	public String getPageUrl() {
		String crowd_url = webPage.getCurrentUrl();
		return crowd_url;
	}

	public String getViewMoreVideoLink(String expectedUrl) throws PageException {

		String pageElement = null;
		Video lstVideoLnk = null;
		String url2 = null;
		try {
			
			lstVideoLnk = (Video) webPage.findObjectsUsingXpath(
					BuzzerPageVideoLinkElements.view_more_video,
					ObjectType.Video);

			pageElement = lstVideoLnk.getAttribute("src");
			if (lstVideoLnk != null) {
				if (BrowserInfoUtil.INSTANCE.isIE10()
						|| BrowserInfoUtil.INSTANCE.isIE9()
						|| BrowserInfoUtil.INSTANCE.isIE8()) {

					JavascriptExecutor jsx = (JavascriptExecutor) webPage
							.getDriver();
					jsx.executeScript("window.scrollBy(0,450)", "");
				}
				lstVideoLnk.click();
			}

			url2 = webPage.getCurrentUrl();
			return url2;
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), expectedUrl, url2, e.getMessage());

			throw e;
		}

	}

	public void goBackToLink() {
		if (BrowserInfoUtil.INSTANCE.isSafari())
			navigatePage();
		else

			webPage.getBackToUrl();
	}

	public void navigatePage() {
		webPage.navigateToUrl(SuiteListener.pageURLs.getProperty("CROWD_GOES_WILD_PAGE"));
	}

	public String getViewMoreLinkText(String expectedLinkText)
			throws PageException {

		webPage.sleep(5000);
		Link linkText = null;
		String pageElement = null;
		String actualResult = null;

		try {
			linkText = (Link) webPage.findObjectsUsingXpath(
					BuzzerPageVideoLinkElements.VIEWMORE_LINKTEXT + linkTextIndex
							+ "]", ObjectType.Link);
			pageElement = linkText.getAttribute("src");
			actualResult = linkText.getText();

		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement,
					webPage.getCurrentUrl(), expectedLinkText, actualResult,e.getMessage());
			throw e;

		}
		linkTextIndex++;
		return linkText.getText();
	}

	public boolean brokenLink() throws PageException {
		Image linkText;
		String pageElement = null;
		String expectedResult = null;
		boolean flag = false;
		linkText = (Image) webPage.findObjectsUsingXpath(
				BuzzerPageVideoLinkElements.SECTION_HEADER_XPATH,
				ObjectType.Image);
		linkText.click();

		try {
			flag = isLinkBroken(webPage.getCurrentUrl());
		} catch (PageException e) {

			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), expectedResult,String.valueOf(flag), e.getMessage());
			throw e;
		}
		return flag;
	}

	public void waitForPageLoad() {
		String previousUrl = SuiteListener.pageURLs
				.getProperty("CROWD_GOES_WILD_PAGE");
		webPage.getTransitionUrl(previousUrl, 10000, 10000);
	}

	public boolean isLinkBroken(String linkUrl) throws PageException {
		System.out.println("Start - isLinkBroken");
		boolean result = false;

		String expectedResult = null;
		if (CommonUtil.isNull(linkUrl)) {
			System.out.println("Link URL is null - " + linkUrl);
			throw new PageException("Link URL is null");
		}
		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url
					.openConnection();
			httpURLConnect.setConnectTimeout(6000);
			httpURLConnect.connect();
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				result = true;
			}
		} catch (MalformedURLException e) {
			log.info("Malformed URL - " + linkUrl + " Message - "
					+ e.toString());

			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(),expectedResult, String.valueOf(result), e.getMessage());

			throw new PageException("Failed to check broken link for URL - "
					+ linkUrl + " Message - " + e.toString());
		} catch (IOException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(),expectedResult, String.valueOf(result), e.getMessage());

			throw new PageException("Failed to check broken link for URL - "
					+ linkUrl + " Message - " + e.toString());
		} finally {
			log.info("End - isLinkBroken");
		}
		return result;
	}

	public boolean stringAppend() {
		boolean str;
		str = webPage.StringParameterAppend();
		return str;

	}

	public String verifyCrowdLogo(String responsiveURL) {
		Image linkText = null;
		String pageElement = null;
		try {
			linkText = (Image) webPage.findObjectsUsingXpath(
					BuzzerPageVideoLinkElements.SECTION_HEADER_XPATH,
					ObjectType.Image);
			pageElement = linkText.getAttribute("src");
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), responsiveURL,
					webPage.getCurrentUrl(), e.getMessage());
		}
		if (BrowserInfoUtil.INSTANCE.isIE()) {
			linkText.click();
		} else
			linkText.click();

		return webPage.getCurrentUrl();
	}

	public String getVideoLink(String ExpectedvideoUrl) {
		Video lstVideoLnk = null;
		String pageElement = null;

		try {
			lstVideoLnk = (Video) webPage.findObjectsUsingXpath(
					BuzzerPageVideoLinkElements.Video_Loads,
					ObjectType.Video);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), ExpectedvideoUrl,null, e.getMessage());
		}
		if (lstVideoLnk != null) {

			lstVideoLnk.click();

		}
		webPage.sleep(10000);
		String url2 = webPage.getCurrentUrl();
		return url2;
	}

}
