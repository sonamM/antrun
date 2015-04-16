package com.etouch.fox.watch.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.rest.ResultType;

import com.etouch.fox.common.pages.CommonPage;
import com.etouch.fox.common.pages.FoxSportsFooterPage;
import com.etouch.fox.watch.pages.elements.BuzzerPageElements;
import com.etouch.taf.core.exception.DateException;
import com.etouch.taf.core.exception.ListException;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.DateUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.ScreenShotUtil;
import com.etouch.taf.webui.selenium.LayoutManager;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Element;
import com.etouch.taf.webui.selenium.webelement.Image;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.webui.selenium.webelement.Text;

/**
 * Page Class for BuzzerPage. It calls the Framework APIs.
 * change1
 * Test Class resembles the test specification. Page Class resembles the test
 * implementation
 * 
 * @author eTouch Systems Corporation
 * 
 */
public class BuzzerPage extends CommonPage {
	private FoxSportsFooterPage foxSportsFooterPage;
	private ScreenShotUtil screenShot = null;
	private static int indexElement = 1;
	private static Log log = LogUtil.getLog(BuzzerPage.class);

	public BuzzerPage(String sbPageUrl, WebPage webPage) {
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

	public List<String> getBuzzerText(String textData) {
		List<String> lst = new ArrayList<String>();
		List<Text> lstText = null;
		String actualResult = null;

		try {
			
			lstText = webPage.findObjectsUsingXpath(BuzzerPageElements.Text_CHECK, ObjectType.Text);

			for (Text txt : lstText) {
				lst.add(txt.getText());
				actualResult = txt.getText();
			}

		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, actualResult,webPage.getCurrentUrl(), textData, actualResult,e.getMessage());
		}
		return lst;

	}

	public String getAllProperty(String headerColor, String headerSize,
								 String dateColor, String dateSize, String bodyColor, String bodySize) 
	{
		String property = null;
		String expected = null;
		String pageElement = null;
		Text text_header = null;
		Text text_date = null;
		Text text_body = null;
		try {

			text_header = (Text) webPage.findObjectsUsingXpath(
					BuzzerPageElements.Text_HEADER + indexElement
							+ "]/div[1]/a/h3", ObjectType.Text);

			text_date = (Text) webPage.findObjectsUsingXpath(
					BuzzerPageElements.Text_DATE + indexElement
							+ "]/div[1]/div", ObjectType.Text);

			text_body = (Text) webPage.findObjectsUsingXpath(
					BuzzerPageElements.Text_BODY + indexElement
							+ "]/div[2]/div/p", ObjectType.Text);

			String color_header = text_header.getCssValue("color");
			String size_header = text_header.getCssValue("font-size");

			String color_date = text_date.getCssValue("color");
			String size_date = text_date.getCssValue("font-size");

			String color_body = text_body.getCssValue("color");
			String size_body = text_body.getCssValue("font-size");
			try {
				pageElement = text_header.getText() + "" + text_date.getText() + "" + text_body.getText();
				expected = headerColor + "," + headerSize + "," + dateColor + "," + dateSize + "," + bodyColor + "," + bodySize;

			} catch (Exception ignore) {
			}
			indexElement++;

			property = color_header + "," + size_header + "," + color_date + "," + size_date + "," + color_body + "," + size_body;

		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), expected, property, e.getMessage());
		}

		return property;

	}

	public boolean isPubDatesInOrder(boolean bln) throws PageException {
		List<String> lst = new ArrayList<String>();
		String pageUrl = null;
		String pageElement = null;
		String actualResult = null;
		String expectedResult = null;

		List<Text> lstText = webPage.findObjectsUsingClass(BuzzerPageElements.BUZZER_PUBDATE, ObjectType.Text);
		try{
			for (Text txt : lstText) {
				lst.add(new DateUtil().getDateString(txt.getText()));
				pageElement = txt.getText();
				actualResult = txt.getText();
			}
			boolean result = (new DateUtil()).isDateInOrder(lst, bln);
			pageUrl = webPage.getCurrentUrl();
			if (!result)
				setErrMessage("The published date is not in order");
			
			return result;
		}catch (ListException e){
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement, pageUrl,expectedResult, actualResult, e.getMessage());
			return false;
		}catch (DateException e){
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), null, actualResult, e.getMessage());
			return false;
		}
	}

	public String getBuzzerImg(String expectedSrc) throws InterruptedException {
		String buzzerImg_Src = null;
		Image lstBuzzer = null;
		try {

			lstBuzzer = (Image) webPage.findObjectsUsingXpath(
					BuzzerPageElements.BUZZER_IMAGE, ObjectType.Image);
			webPage.sleep(5000);

			buzzerImg_Src = lstBuzzer.getAttribute("src");
		} 
		catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, buzzerImg_Src,webPage.getCurrentUrl(), expectedSrc, buzzerImg_Src,e.getMessage());
		}

		return buzzerImg_Src;
	}

	public Integer getSize() throws PageException {

		List<Text> lstText = null;

		String actualResult = null;

		try {
			lstText = webPage.findObjectsUsingXpath(
					BuzzerPageElements.TextVideo_CHECK, ObjectType.Text);
			try {
				actualResult = String.valueOf(lstText.size());

			} catch (Exception ignore) {
			}

		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(),
					null, actualResult, e.getMessage());
		}
		return lstText.size();
	}

	public Integer getscreenShot(WebDriver webDriver)
			throws InterruptedException, PageException {
		Integer size2 = null;
		Link lstLink = null;
		String pageElement = null;
		try {

			JavascriptExecutor jsx = (JavascriptExecutor) webDriver;
			if (BrowserInfoUtil.INSTANCE.isIE10()
					|| BrowserInfoUtil.INSTANCE.isIE9()) {
				jsx.executeScript("window.scrollBy(0,2700)", "");
			} else if (BrowserInfoUtil.INSTANCE.isAndroid()
					|| BrowserInfoUtil.INSTANCE.isIOS()) {
				jsx.executeScript("window.scrollBy(0,4250)", "");
			}

			webPage.sleep(10000);
			lstLink = (Link) webPage.findObjectsUsingXpath(BuzzerPageElements.SHOWMORE, ObjectType.Link);
			log.info("Show More Link Text" + lstLink.getText());
			pageElement = lstLink.getText();

			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isChrome()
					|| BrowserInfoUtil.INSTANCE.isIE8()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE10()
					|| BrowserInfoUtil.INSTANCE.isIOS()) {
				lstLink.clickEvent();
				webPage.sleep(2000);
				jsx.executeScript("window.scroll(4250,0)", "");
			} else {
				lstLink.click();

			}
			size2 = getSize();

		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement,webPage.getCurrentUrl(), null, null, e.getMessage());
		}
		return size2;

	}

	public Image getCoordinates() throws PageException {
		Image imgElement = null;
		List<Element> pageElementList = null;

		try {
			pageElementList = webPage.findObjectsUsingXpath(
					BuzzerPageElements.XPATH_IMAGEELEMENT_NASCAR,
					ObjectType.Text);

			WebElement currentWebElement = pageElementList.get(0)
					.getWebElement();

			imgElement = new Image(currentWebElement);
		} catch (Exception e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(),null, null, e.getMessage());
		}
		return imgElement;
	}

	public int readAllPageObjects(WebDriver driver, String xpath,
			String element, int size) throws InterruptedException,
			PageException {
		int assertValue = 0;

		Image sectionHeader = null;
		LayoutManager layOut = new LayoutManager();
		try {
			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isFF()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE8()
					|| BrowserInfoUtil.INSTANCE.isIE10()
					|| BrowserInfoUtil.INSTANCE.isChrome()) {

				webPage.resize(size, 600);

			}

			Image mainPageHeader = getCoordinates();
			log.info(element + " X Co-ordinate is :" + mainPageHeader.getPtX());
			log.info(element + " y Co-ordinate is :" + mainPageHeader.getPtY());
			System.out.println(element + "Height is :"
					+ mainPageHeader.getHeight());
			log.info(element + "Width is  :" + mainPageHeader.getWidth());

			sectionHeader = (Image) webPage.findObjectsUsingXpath(
					BuzzerPageElements.SECTION_HEADER_XPATH,
					ObjectType.Image);

			log.info("No of Columns -- "
					+ layOut.getColumnLayout(sectionHeader));
			webPage.sleep(2000);

			assertValue = layOut.getColumnLayout(sectionHeader);

		} catch (Exception e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(),null, null, e.getMessage());
		}
		return assertValue;

	}

	public void waitForPageload() {
		webPage.sleep(2000);
	}

	public Boolean captureScreenShot(WebDriver webDriver) {
		screenShot = new ScreenShotUtil();
		Boolean value = true;
		log.info("\n\n testBedManager.getDriver() :: " + webDriver.toString());

		try {
			if (!isPubDatesInOrder(false)) {
				value = false;

				screenShot.takeScreenShot(webDriver,
						"DemoFileForScreenshot.png");

				return value;
			}

		} catch (Exception e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(),null, null, e.getMessage());
		}
		return value;
	}

	
	public List<String> getBuzzerPopupText() {
		List<String> lst = new ArrayList<String>();
		List<Text> lstText;
		try {
			lstText = webPage.findObjectsUsingXpath(
					BuzzerPageElements.POPUP_XPATH, ObjectType.Text,5,WaitCondition.ALLVISIBLE);
		
			for (Text txt : lstText) {
				System.out.println("BuzzerPage.getBuzzerText() lstText "+txt.getText());
				lst.add(txt.getText());
			}

		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage("Got Page Exception : " + e.getMessage());

		}
		return lst;

	}
}
