package com.etouch.fox.watch.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.json.simple.JSONArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.rest.ResultType;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.json.simple.JSONArray;
import com.etouch.fox.common.pages.CommonPage;
import com.etouch.fox.common.pages.FoxSportsFooterPage;
import com.etouch.fox.watch.pages.elements.CrowdGoesWildPageElements;
import com.etouch.taf.core.exception.DateException;
import com.etouch.taf.core.exception.ListException;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.DateUtil;
import com.etouch.taf.util.JSONUtil;
import com.etouch.taf.util.JSUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.LayoutManager;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Image;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.webui.selenium.webelement.Text;
import com.etouch.taf.webui.selenium.webelement.TextBox;
import com.etouch.taf.webui.selenium.webelement.Video;

/**
 * Page Class for CrowdGoesWild page. It calls the Framework APIs.
 *
 * Test Class resembles the test specification. Page Class resembles the test
 * implementation
 *
 * @author eTouch Systems Corporation
 *
 */
public class CrowdGoesWildPage extends CommonPage {
	private FoxSportsFooterPage	foxSportsFooterPage;
	private static int	        linkTextIndex	 = 1;
	private static Log	        log	             = LogUtil.getLog(CrowdGoesWildPage.class);
	int	                        count1	         = 0;
	int	                        count2	         = 0;
	JavascriptExecutor	        jsx	             = (JavascriptExecutor) webPage.getDriver();
	String	                    pageElementXpath	= null;

	/**
	 * @param sbPageUrl
	 * @param webPage
	 */
	public CrowdGoesWildPage(String sbPageUrl, WebPage webPage) {
		super(sbPageUrl, webPage);
		this.foxSportsFooterPage = new FoxSportsFooterPage(this.webPage);
		loadPage();
	}

	/**
	 * @param xpath
	 * @return
	 */
	public String getBuzzerTitle(String xpath) throws PageException {
		Text txt = (Text) webPage.findObjectsUsingXpath(xpath, ObjectType.Text, -1, WaitCondition.VISIBLE);
		return txt.getText();
	}

	/**
	 * @return
	 */
	public FoxSportsFooterPage getFoxSportsFooterPage() {
		return foxSportsFooterPage;
	}

	/**
	 * @return
	 */
	public List<String> getHeadersText() throws PageException{
		List<String> lst = new ArrayList<String>();
		List<Text> lstText = webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.BUZZER_HEADER, ObjectType.Text);
		for (Text txt : lstText) {
			lst.add(txt.getText());
		}
		return lst;
	}

	/**
	 * @param elementsText
	 * @param location
	 * @param xpaths
	 * @return
	 */
	public int getNumberOfColumns(String[] elementsText, Point[] location, String[] xpaths) throws PageException {
		int numberOfColumns = 0;
		if (elementsText == null || location == null || xpaths == null)
			throw new PageException("Input not valid");
		int index = 0;
		for (String xpath : xpaths) {
			Text element = (Text) webPage.findObjectsUsingXpath(xpath, ObjectType.Text, 2, WaitCondition.EXIST);
			if (element != null) {
				if (element.isDisplayed()) {
					if (elementsText[index].equalsIgnoreCase(element.getText())) {
						if (element.getCoordinates().x == location[index].x && element.getCoordinates().y == location[index].y)
							numberOfColumns++;
					}
				}
			}
			index++;
		}
		return numberOfColumns;
	}

	/**
	 * @param elementsText
	 * @param location
	 * @param xpaths
	 * @return
	 */
	public boolean loadAndCheckAllElements(String[] elementsText, Point[] location, String[] xpaths) throws PageException {
		boolean allElementFound = true;
		if (elementsText == null || location == null || xpaths == null)
			throw new PageException("Input not valid");
		int index = 0;
		for (String xpath : xpaths) {
			Text element = (Text) webPage.findObjectsUsingXpath(xpath, ObjectType.Text, 2, WaitCondition.EXIST);
			if (element != null) {
				if (element.isDisplayed()) {
					if (elementsText[index].equalsIgnoreCase(element.getText())) {
						if (!(element.getCoordinates().x == location[index].x && element.getCoordinates().y == location[index].y)) {
							allElementFound = false;
							break;
						}
					}
				} else {
					allElementFound = false;
					break;
				}
			} else {
				allElementFound = false;
				break;
			}
			index++;
		}
		return allElementFound;
	}

	/*
	 * public boolean isPubDatesInOrder_old(boolean bln) {
	 * List<String> lst = new ArrayList<String>(); List<Text> lstText =
	 * webPage.findPageObjectsByClassName
	 * (CrowdGoesWildPageElements.BUZZER_PUBDATE, ObjectType.Text);
	 * for(Text txt : lstText){ lst.add(getDateString(txt.getText())); } try {
	 *
	 * boolean result = (new DateUtil()).isDateInOrder(lst, bln);
	 *
	 * if(!result) setErrMessage("The published date is not in order"); return
	 * result; } catch (ListException e) { // TODO Auto-generated catch block
	 * setErrMessage(e.getMessage()); return false; } catch (DateException e) {
	 * // TODO Auto-generated catch block setErrMessage(e.getMessage()); return
	 * false; } }
	 */
	// The implementation should return the result to the test class either
	// true/false or string to verify.
	// change the code accordingly
	/**
	 * @return
	 */
	public List<Video> getVideoLink() throws PageException {
		List<Video> lstVideoLnk = webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.VIDEO_CHECK, ObjectType.Video);
		Video videoElement = lstVideoLnk.get(0);
		videoElement.click();
		return lstVideoLnk;
	}

	/**
	 * @param ecpected_no_of_columns
	 * @return
	 */
	public int countNumberOfColumns(String ecpected_no_of_columns) {
		int assertValue = 0;
		String actualResult = null;
		try {
			webPage.sleep(2000);
			Image sectionHeader = null;
			LayoutManager layOut = new LayoutManager();
			pageElementXpath = CrowdGoesWildPageElements.SECTION_HEADER_XPATH;
			sectionHeader = (Image) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Image);
			webPage.sleep(2000);
			log.info("Header Image Height :--------------------------" + sectionHeader.getHeight());
			log.info("Header Image width :--------------------------" + sectionHeader.getWidth());
			log.info("Header Image size :--------------------------" + sectionHeader.getSize());
			log.info("No of Columns --------------------------------- " + layOut.getColumnLayout(sectionHeader));
			webPage.sleep(2000);
			assertValue = layOut.getColumnLayout(sectionHeader);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), ecpected_no_of_columns, actualResult, e.getMessage());
		}
		return assertValue;
	}

	/**
	 * @param width
	 * @param height
	 */
	public void columnLayout(int width, int height) {
		if (!(BrowserInfoUtil.INSTANCE.isAndroid() || BrowserInfoUtil.INSTANCE.isIOS())){
		webPage.sleep(5000);
		webPage.resize(width, height);
		webPage.sleep(5000);
		}
	}

	/**
	 * @param expected_src
	 * @return
	 */
	public String checkBuzzerHeaderLoad(String expected_src) {
		String actual_src = null;
		String actualResult = null;
		try {
			pageElementXpath = CrowdGoesWildPageElements.BUZZER_HEADER_IMAG;
			Image buzzer_image = (Image) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Image);
			actual_src = buzzer_image.getAttribute("src");
			log.info("Image Src:---------------" + buzzer_image.getAttribute("src"));
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expected_src, actualResult, e.getMessage());
		}
		return actual_src;
	}

	/**
	 * @param expected_text
	 * @return
	 */
	public String checkBuzzerComponentLoad(String expected_text) {
		String actual_text = null;
		String actualResult = null;
		try {
			pageElementXpath = CrowdGoesWildPageElements.BUZZER_COMPONENT;
			Text text = (Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text);
			actual_text = text.getText();
			log.info("Date Time Text:---------------" + text.getText());
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expected_text, actualResult, e.getMessage());
		}
		return actual_text;
	}

	/**
	 * @param xpath
	 * @param expected_headlines
	 * @return
	 */
	public String checkBuzzerHeadlinesLoadWithSize(String xpath, String expected_headlines) {
		String actual_headlines = null;
		String actualResult = null;
		try {
			pageElementXpath = xpath;
			Text txt_headlines = (Text) webPage.findObjectsUsingXpath(xpath, ObjectType.Text);
			actual_headlines = txt_headlines.getText();
			log.info("Headlines Text:---------------" + txt_headlines.getText());
			log.info("Headline Size:-----------------" + txt_headlines.getSize());
			Dimension headlinesDim = txt_headlines.getSize();
			int width = headlinesDim.getWidth();
			if (width <= 608 && width >= 429) {
				count1++;
				log.info("No of Big Images : " + count1);
			} else if (width >= 209 && width <= 298) {
				count2++;
				log.info("No of Small Images : " + count2);
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expected_headlines, actualResult, e.getMessage());
		}
		return actual_headlines;
	}

	/**
	 * @param xpath
	 * @param expected_headlines
	 * @return
	 */
	public String checkBuzzerHeadlinesLoad(String xpath, String expected_headlines) {
		String actual_headlines = null;
		String actualResult = null;
		try {
			pageElementXpath = xpath;
			Text txt_headlines = (Text) webPage.findObjectsUsingXpath(xpath, ObjectType.Text);
			actual_headlines = txt_headlines.getText();
			log.info("Headlines Text:---------------" + txt_headlines.getText());
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expected_headlines, actualResult, e.getMessage());
		}
		return actual_headlines;
	}

	/**
	 * @param xpath
	 * @param expected_src
	 * @return
	 */
	public String checkBuzzerImagesLoad(String xpath, String expected_src) {
		String actual_src = null;
		String actualResult = null;
		try {
			pageElementXpath = xpath;
			Image buzzer_images = (Image) webPage.findObjectsUsingXpath(xpath, ObjectType.Image);
			actual_src = buzzer_images.getAttribute("src");
			log.info("Image Size--------------------" + buzzer_images.getSize());
			log.info("Image Src:---------------" + buzzer_images.getAttribute("src"));
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expected_src, actualResult, e.getMessage());
		}
		return actual_src;
	}

	/**
	 *
	 * @param expectedText
	 * @return String value for header text
	 */
	public String getHeaderText(String expectedText) {
		String lstText = "";
		try {
			webPage.sleep(50000);
			jsx.executeScript("window.scrollBy(0,350)", "");
			pageElementXpath = CrowdGoesWildPageElements.headerTag;
			lstText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Actual Header Text:: " + lstText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedText, lstText, e.getMessage());
		}
		return lstText;
	}

	/**
	 *
	 * @param color
	 * @return String value for header text
	 */
	public boolean getHeaderHoverText(String color) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.headerTag;
			Link link = (Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link);
			link.hover();
			webPage.sleep(10000);
			value = link.getCssValue("color");
			log.info("Actual Header color:: " + value);
			if (value.equalsIgnoreCase(color)) {
				flag = true;
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), color, value, e.getMessage());
		}
		return flag;
	}

	/**
	 *
	 * @param expectedDateString
	 * @return String value for DateText
	 */
	public String getDateStringFromHomePage(String expectedDateString) {
		String dateText = "";
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.dateText;
			dateText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			webPage.sleep(5000);
			log.info("Actual Date Text:: " + dateText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedDateString, dateText, e.getMessage());
		}
		return dateText;
	}

	/**
	 *
	 * @param regExpression
	 * @return String value for DateText
	 */
	public boolean getDateFormatString(String regExpression) {
		boolean match = false;
		boolean expected = true;
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.dateText;
			String dateText = ((Text)webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.dateText, ObjectType.Text)).getText();
			Pattern pattern = Pattern.compile(CrowdGoesWildPageElements.regExpression);
			Matcher matcher = pattern.matcher(dateText);
			log.info("Input String matches regex - " + matcher.matches());
			match = matcher.matches();
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(expected), String.valueOf(match), e.getMessage());
		}
		return match;
	}

	/**
	 *
	 * @param expectedString
	 * @return String value for DateText
	 */
	public String getSorceAndBylineString(String expectedString) {
		String sorceText = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.byLine;
			sorceText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			webPage.sleep(5000);
			log.info("Actual Sorce Text:: " + sorceText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedString, sorceText, e.getMessage());
		}
		return sorceText;
	}

	/**
	 *
	 * @param expectedDescription
	 * @return String value for Description Text
	 */
	public String getDescriptionText(String expectedDescription) {
		String descrText = "";
		try {
			webPage.sleep(5000);
			pageElementXpath = CrowdGoesWildPageElements.descriptionText;
			descrText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			webPage.sleep(5000);
			log.info("Actual Description Text:: " + descrText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedDescription, descrText, e.getMessage());
		}
		return descrText;
	}

	/**
	 *
	 * @param imageName
	 * @return String value for URL of Icon
	 */
	public boolean getMoreIcon(String imageName) {
		boolean found = false;
		String actualurl = "";
		try {
			webPage.sleep(5000);
			pageElementXpath = CrowdGoesWildPageElements.moreIcon;
			Text descrText = (Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text);
			WebElement showMoreIcon = webPage.getDriver().findElement(By.xpath(pageElementXpath));
			webPage.sleep(5000);
			actualurl = showMoreIcon.getCssValue("background-image");
			found = actualurl.contains(imageName.trim());
			log.info("More Image Loaded:: " + found);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), imageName, actualurl, e.getMessage());
		}
		return found;
	}

	/**
	 *
	 * @param expectedString
	 * @return String value for ViewMore Text
	 */
	public String getViewMoreLinkText(String expectedString) {
		String descrText = "";
		try {
			webPage.sleep(5000);
			pageElementXpath = CrowdGoesWildPageElements.viewMoreLink;
			descrText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			webPage.sleep(5000);
			log.info("View More Link:: " + descrText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedString, descrText, e.getMessage());
		}
		return descrText;
	}

	/**
	 * @param expected
	 * @return
	 */
	public boolean testDecorationOnViewMore(String expected) {
		boolean flag = false;
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.viewMoreLink;
			Link link = (Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link);
			link.hover();
			webPage.sleep(15000);
			String value = link.getCssValue("text-decoration");
			log.info("Text-Decoration:: " + value);
			if (value.equalsIgnoreCase(expected)) {
				flag = true;
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), null, null, e.getMessage());
		}
		return flag;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public String getViewMoreClickedL1ink(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.viewMoreLink;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(10000);
			url = webPage.getCurrentUrl();
			log.info("View More clicked :: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public boolean getWindowSizeOnClick(String expectedURL) {
		boolean flag = false;
		try {
			webPage.sleep(30000);
			jsx.executeScript("window.scrollBy(0,350)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.viewMoreLink;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(5000);
			String url = webPage.getCurrentUrl();
			Set<String> windows = webPage.getDriver().getWindowHandles();
			if (windows.size() == 1) {
				flag = true;
				log.info("window size:: " + windows.size());
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(true), String.valueOf(flag), e.getMessage());
		}
		return flag;
	}

	/**
	 * @param homePageUrl
	 */
	public void goBackToLink(String homePageUrl) {
		if (BrowserInfoUtil.INSTANCE.isSafari())
			navigatePage(homePageUrl);
		else
			webPage.getBackToUrl();
	}

	/**
	 * @param homePageUrl
	 */
	public void navigatePage(String homePageUrl) {
		webPage.navigateToUrl(homePageUrl);
	}

	/**
	 *
	 * @param expectedValue
	 * @return String value for ViewMore Text
	 */
	public String getTagText(String expectedValue) {
		String tagText = "";
		try {
			webPage.sleep(30000);
			jsx.executeScript("window.scrollBy(0,350)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.tagLink;
			tagText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Actual Tag Text:: " + tagText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedValue, tagText, e.getMessage());
		}
		return tagText;
	}

	/**
	 * @param color
	 * @return
	 */
	public boolean testHighlightColorForTag(String color) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(5000);
			pageElementXpath = CrowdGoesWildPageElements.tagLink;
			Link link = (Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link);
			link.hover();
			webPage.sleep(10000);
			value = link.getCssValue("color");
			log.info("Actual Tag color:: " + color);
			if (value.equalsIgnoreCase(color)) {
				flag = true;
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), color, value, e.getMessage());
		}
		return flag;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public String getTagClickedLink(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.tagLink;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(10000);
			url = webPage.getCurrentUrl();
			log.info("Actual Tag url:: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public String getHeaderLinkClickedLink(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(50000);
			jsx.executeScript("window.scrollBy(0,200)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.headerTag;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(5000);
			url = webPage.getCurrentUrl();
			log.info("Actual Header URL:: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 * @param expectedVideoUrl
	 * @return
	 */
	public boolean getWindowSizeOnClickOFHeader(String expectedVideoUrl) {
		boolean flag = false;
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.headerTag;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(10000);
			String url = webPage.getCurrentUrl();
			Set<String> windows = webPage.getDriver().getWindowHandles();
			if (windows.size() == 1) {
				flag = true;
				log.info("Actual window size:: " + windows.size());
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(true), String.valueOf(flag), e.getMessage());
		}
		return flag;
	}

	/**
	 *
	 * @param expected
	 * @return String value for header text
	 */
	public String getHeaderTextFortwoColumn(String expected) {
		String lstText = "";
		try {
			webPage.sleep(30000);
			jsx.executeScript("window.scrollBy(0,250)", "");
			pageElementXpath = CrowdGoesWildPageElements.headerTag;
			lstText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Actual Header Text:: " + lstText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expected, lstText, e.getMessage());
		}
		return lstText;
	}

	/**
	 *
	 * @param color
	 * @return String value for header text
	 */
	public boolean getHeaderHoverTextForTwoColumns(String color) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.headerTag;
			Link link = (Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link);
			link.hover();
			webPage.sleep(10000);
			value = link.getCssValue("color");
			if (value.equalsIgnoreCase(color)) {
				flag = true;
				log.info("Actual Header color:: " + value);
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), color, value, e.getMessage());
		}
		return flag;
	}

	/**
	 *
	 * @param expected
	 * @return String value for DateText
	 */
	public String getDateStringForTwoColumn(String expected) {
		String dateText = "";
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.dateText;
			dateText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Actual Date String:: " + dateText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expected, dateText, e.getMessage());
		}
		return dateText;
	}

	/**
	 *
	 * @param expected
	 * @return String value for ViewMore Text
	 */
	public String getViewMoreLinkTextForTwoColumns(String expected) {
		String descrText = "";
		try {
			webPage.sleep(5000);
			pageElementXpath = CrowdGoesWildPageElements.viewMoreLink;
			descrText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Actual view more Description String:: " + descrText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expected, descrText, e.getMessage());
		}
		return descrText;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public String getViewMoreClickedLink(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.viewMoreLink;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(10000);
			url = webPage.getCurrentUrl();
			log.info("Actual URL On View More Click:: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public String getVideoLinkForTwoColumns(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(30000);
			jsx.executeScript("window.scrollBy(0,400)", "");
			webPage.sleep(40000);
			pageElementXpath = CrowdGoesWildPageElements.VideoLink;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(20000);
			url = webPage.getCurrentUrl();
			log.info("Actual URL On Video Link Click:: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public String getStoryLinkForTwoColumns(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(40000);
			jsx.executeScript("window.scrollBy(0,700)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.storyLink;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(20000);
			url = webPage.getCurrentUrl();
			log.info("Actual URL On Story Link Click:: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 *
	 * @param expectedText
	 * @param expectedValue
	 * @return
	 */
	public String validateShowMoreForTwoColumns(String expectedText) {
		String showmoreText = null;
		try {
			webPage.sleep(50000);
			jsx.executeScript("window.scrollBy(0,4500)", "");
			pageElementXpath = CrowdGoesWildPageElements.ShowMore_Xpath;
			showmoreText = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Actual Show More Text:: " + showmoreText);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedText, showmoreText, e.getMessage());
			log.error(getErrMessage());
		}
		return showmoreText;
	}

	/**
	 *
	 * @param expectedText
	 * @return String value for header text
	 */
	public String getHeaderTextForOneColumn(String expectedText) {
		String lstText = "";
		try {
			webPage.sleep(50000);
			jsx.executeScript("window.scrollBy(0,200)", "");
			pageElementXpath = CrowdGoesWildPageElements.headerTag;
			lstText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Actual Header Text:: " + lstText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedText, lstText, e.getMessage());
		}
		return lstText;
	}

	/**
	 *
	 * @param color
	 * @return String value for header text
	 */
	public boolean getHeaderHoverTextForOneColumn(String color) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.headerTag;
			Link link = (Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link);
			link.hover();
			value = link.getCssValue("color");
			webPage.sleep(10000);
			if (value.equalsIgnoreCase(color)) {
				flag = true;
			}
			log.info("Actual Header color:: " + value);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), color, value, e.getMessage());
		}
		return flag;
	}

	/**
	 *
	 * @param expectedDate
	 * @return String value for DateText
	 */
	public String getDateStringForOneColumn(String expectedDate) {
		String dateText = "";
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.dateText;
			dateText = ((Text)webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			webPage.sleep(5000);
			log.info("Actual Date String:: " + dateText);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedDate, dateText, e.getMessage());
		}
		return dateText;
	}

	/**
	 *
	 * @return String value for ViewMore Text
	 */
	public boolean getViewMoreLinkTextForOneColumn() {
		boolean isViewMorePresent = false;
		try {
			jsx.executeScript("window.scrollBy(0,100)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.viewMoreLink;
			Text view_More_Text = (Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text);
			Assert.assertNotNull(view_More_Text, "View More element Not found");
			isViewMorePresent = view_More_Text.isElementVisible();
			log.info("Actual View More String Present:: " + isViewMorePresent);
		} catch (PageException e) {
			log.info("Actual View More String Present:: " + isViewMorePresent);
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(false), String.valueOf(isViewMorePresent), e.getMessage());
		}
		return isViewMorePresent;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public String getVideoLinkForOneColumn(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(10000);
			jsx.executeScript("window.scrollBy(0,50)", "");
			webPage.sleep(40000);
			pageElementXpath = CrowdGoesWildPageElements.VideoLink;
			((Link) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Link)).click();
			webPage.sleep(20000);
			url = webPage.getCurrentUrl();
			log.info("Actual URL On Video Link Click:: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public String getStoryLinkForOneColumn(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(40000);
			jsx.executeScript("window.scrollBy(0,700)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.storyLink;
			((Link) webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.storyLink, ObjectType.Link)).click();
			webPage.sleep(20000);
			url = webPage.getCurrentUrl();
			log.info("Actual URL On Story Link Click:: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 *
	 * @param expectedText
	 * @param expectedValue
	 * @return
	 */
	public String validateShowMoreForOneColumn(String expectedText) {
		String showmoreText = null;
		try {
			webPage.sleep(50000);
			jsx.executeScript("window.scrollBy(0,4500)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.ShowMore_Xpath;
			showmoreText = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Actual Show More String:: " + showmoreText);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedText, showmoreText, e.getMessage());
			log.error(getErrMessage());
		}
		return showmoreText;
	}

	/**
	 * @return
	 */
	public int countHeadlines() {
		List<Text> lstText = null;
		String actualResult = null;
		try {
			pageElementXpath = CrowdGoesWildPageElements.HeadLine_Xpath;
			lstText = webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text);
			try {
				actualResult = String.valueOf(lstText.size());
				log.info("Number Of Headings:: " + actualResult);
			} catch (Exception ignore) {
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), null, actualResult, e.getMessage());
		}
		return lstText.size();
	}

	/**
	 * @param webDriver
	 * @param value
	 */
	public void clickOnShowMoreButton(WebDriver webDriver, int value) {
		webPage.sleep(30000);
		pageElementXpath = CrowdGoesWildPageElements.ShowMore_Xpath;
		if (value == 2) {
			jsx.executeScript("window.scrollBy(0,3500)", "");
		}
		WebElement ShowMore = webPage.getDriver().findElement(By.xpath(pageElementXpath));
		if (BrowserInfoUtil.INSTANCE.isSafari() || BrowserInfoUtil.INSTANCE.isFF() || BrowserInfoUtil.INSTANCE.isAndroid()) {
			ShowMore.click();
		} else {
			JSUtil.JSClickByElement(webDriver, ShowMore);
		}
		webPage.sleep(5000);
	}

	/**
	 * @param afterClickCount
	 * @param beforeClickCount
	 * @return
	 */
	public int getNewlyAddedHeadlines(int afterClickCount, int beforeClickCount) {
		return (afterClickCount - beforeClickCount);
	}

	/**
	 * @param bln
	 * @return
	 */
	public boolean isPubDatesInOrder(boolean bln) {
		List<String> lst = new ArrayList<String>();
		String pageUrl = null;
		String pageElement = null;
		String actualResult = null;
		String expectedResult = null;
		List<Text> lstText =null;
        try {
	        lstText = webPage.findObjectsUsingClass(CrowdGoesWildPageElements.BUZZER_PUBDATE, ObjectType.Text);
        } catch (PageException e1) {
        	log.error(e1.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), String.valueOf(bln), actualResult, e1.getMessage());
	        e1.printStackTrace();
        }
        try {
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
		} catch (ListException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement, pageUrl, expectedResult, actualResult, e.getMessage());
			return false;
		} catch (DateException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement, webPage.getCurrentUrl(), null, actualResult, e.getMessage());
			return false;
		}
	}

	/**
	 * @return
	 */
	public boolean clickingShowMore() {
		boolean found = true;
		int i = 0;
//		try {
			while (found) {
				webPage.sleep(10000);
				if (i != 0) {
					jsx.executeScript("window.scrollBy(0,3500)", "");
				}
				clickOnShowMoreButton(webPage.getDriver(), 1);
				i++;
				pageElementXpath = CrowdGoesWildPageElements.ShowMore_Xpath;

				try{
				Text ShowMore = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text));
				}catch(PageException e1){
//					System.out.println("msg ::"+e1.getMessage());
//					e1.printStackTrace(System.out);
					found = false;
					break;
				}

//				Assert.assertNotNull(ShowMore, "Show More element Not found");
//				boolean showmoreText = ShowMore.isDisplayed();
//				if (!showmoreText) {
//					found = false;
//				}
			}
			log.info("Is show more Present:: " + found);
//		} catch (PageException e) {
//			found=false;
//			log.error(e.getMessage());
//			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), null, null, e.getMessage());
//		}
		return found;
	}

	/**
	 * @param webDriver
	 * @return
	 */
	public String getFourthLink(WebDriver webDriver) {
		String url = "";
		WebElement fourthLink;
		try {
			webPage.sleep(40000);
			jsx.executeScript("window.scrollBy(0,800)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.FOURTHLINK;
			Text link = (Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text);
			fourthLink = webPage.getDriver().findElement(By.xpath(pageElementXpath));
			if (BrowserInfoUtil.INSTANCE.isChrome() || BrowserInfoUtil.INSTANCE.isSafari() || BrowserInfoUtil.INSTANCE.isIE9() || BrowserInfoUtil.INSTANCE.isIE8() || BrowserInfoUtil.INSTANCE.isIE10()) {
				//JSUtil.JSClickByElement(webDriver, fourthLink);
				link.clickEvent();
			} else {
				fourthLink.click();
			}
			log.info("URL :: " + url);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), null, url, e.getMessage());
			log.error(getErrMessage());
		}
		webPage.sleep(20000);
		url = webPage.getCurrentUrl();
		return url;
	}

	/**
	 *
	 * @param expectedText
	 * @param expectedValue
	 * @return
	 */
	public String validateShowMoreForThreeColumn(String expectedText) {
		String showmoreText = null;
		try {
			webPage.sleep(50000);
			 jsx.executeScript("window.scrollBy(0,4500)", "");
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.ShowMore_Xpath;
			showmoreText = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getText();
			log.info("Show More Text:: " + showmoreText);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedText, showmoreText, e.getMessage());
			log.error(getErrMessage());
		}
		return showmoreText;
	}

	/**
	 *
	 * @param expectedText
	 * for secondary nav links
	 * @return
	 */
	public String validateSecondayNavElelments(String xpathValues,
			String expectedText) {
		String secondaryNavText = null;
		try {
			loadPage();
			webPage.sleep(30000);
			pageElementXpath = xpathValues;
			secondaryNavText = ((Text) webPage.findObjectsUsingXpath(
					pageElementXpath, ObjectType.Text)).getText();
			log.info("Secondary Nav Text:: " + secondaryNavText);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), expectedText, secondaryNavText,
					e.getMessage());
			log.error(getErrMessage());
		}
		return secondaryNavText;
	}

	/**
	 *
	 * @param color
	 * @return String value for Video Text
	 */
	public boolean getVideoHoverText(String color) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_VIDEO;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(By.xpath(pageElementXpath));
			if(BrowserInfoUtil.INSTANCE.isSafari()){
				videoText.hover();
				value=Color.fromString(videoText.getCssValue("color")).asHex();
			}else{
				value = videoText.textColor();
			}
			if (value.equalsIgnoreCase(color)) {
				flag = true;
			}
			log.info("video color:: " + value);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), color, value, e.getMessage());
		}
		return flag;
	}

	/**
	 *
	 * @param color
	 * @return String value for Video Text
	 */
	public String getVideoHoverTitleText(String text) {
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_VIDEO_TITLE;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			if(BrowserInfoUtil.INSTANCE.isSafari()){
				videoText.hover();
				value = videoText.getAttribute("title");
			}else{
				value = videoText.textTitle();
			}
			log.info("video Title:: " + value);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), text, value, e.getMessage());
		}
		return value;
	}


	// START tc36 to tc-43
	/**
	 *
	 * @return
	 */
	public Object headerLoad() {
		Text msnHeader = null;
		try {
			msnHeader = (Text) webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.MSN_HEADER, ObjectType.Text);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(), null, null, e.getMessage());
		}
		return msnHeader;
	}

	/**
	 *
	 * @param webDriver
	 * @param expectedURL
	 * @return
	 */
	public String msnLogoLoad(WebDriver webDriver, String expectedURL) {
		String url = null;
		try {
			Link link = (Link) webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.MSN_LOGO, ObjectType.Link);
			webPage.sleep(1000);
			log.info("MSN Link Text----------------------------" + link.getText());
			if (BrowserInfoUtil.INSTANCE.isSafari()) {
				link.clickEvent();
			} else {
				link.click();
			}
			webPage.toggleWindow();
			url = webDriver.getCurrentUrl();
			webPage.sleep(1000);
			webPage.close_toggleWindow();
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 *
	 * @param xpath
	 * @param webDriver
	 * @param expectedText
	 * @return
	 */
	public Link mouserHovertest(String xpath, WebDriver webDriver, String expectedText) {
		Link link = null;
		String pageElement = null;
		String actualResult = null;
		try {
			// mouse over
			link = (Link) webPage.findObjectsUsingXpath(xpath, ObjectType.Link);
			pageElement = link.getText();
			actualResult = link.getText();
			link.hover();
			webPage.sleep(500);
			log.info("Mouse over text decoration is--------------------- : " + link.getCssValue("text-decoration"));
			log.info("Mouse over text is-------------------------- : " + link.getText());
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement, webPage.getCurrentUrl(), expectedText, actualResult, e.getMessage());
		}
		return link;
	}

	/**
	 *
	 * @param xpath
	 * @param webDriver
	 * @param expectedURL
	 * @return
	 */
	public String clickSubLink(String xpath, WebDriver webDriver, String expectedURL) {
		String url = null;
		try {
			Link link = (Link) webPage.findObjectsUsingXpath(xpath, ObjectType.Link);
			webPage.sleep(1000);
			log.info("Sub link text clicked----------------------------" + link.getText());
			if (BrowserInfoUtil.INSTANCE.isSafari()) {
				link.clickEvent();
			} else {
				link.click();
			}
			webPage.toggleWindow();
			url = webDriver.getCurrentUrl();
			webPage.sleep(1000);
			webPage.close_toggleWindow();
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 *
	 * @param webDriver
	 * @param data
	 * @param xpath
	 * @param expectedURL
	 * @param goBackUrl
	 * @return
	 */
	public String enterTextSearchField(WebDriver webDriver, String data, String xpath, String expectedURL, String goBackUrl) {
		String url = null;
		String pageElement = null;
		try {
			TextBox txtZipCode = (TextBox) webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.SEARCH_TEXTBOX, ObjectType.TextBox, -1, WaitCondition.CLICKABLE );
			txtZipCode.click();
			txtZipCode.enterText(data);
			webPage.sleep(1000);
			Link link = (Link) webPage.findObjectsUsingXpath(xpath, ObjectType.Link);
			webPage.sleep(1000);
			log.info("Search Field Text clicked----------------------------" + link.getText());
			link.click();
			webPage.sleep(1000);
			url = webDriver.getCurrentUrl();
			webPage.sleep(1000);
			if (BrowserInfoUtil.INSTANCE.isSafari())
			{
				webPage.navigateToUrl(goBackUrl);
			}
			else
			{
				webPage.getBackToUrl();
				if(BrowserInfoUtil.INSTANCE.isChrome())
	            {
	                webPage.getBackToUrl();
	            }
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement, webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 *
	 * @param webDriver
	 * @return
	 */
	public String clickWebButton(WebDriver webDriver) {
		String url = null;
		String pageElement = null;
		String expectedResult = null;
		try {
			Link linkWeb = (Link) webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.BOTTON_WEB, ObjectType.Link);
			log.info("Wbe Link Text-----------------------" + linkWeb.getText());
			webPage.sleep(1000);
			if (BrowserInfoUtil.INSTANCE.isSafari()) {
				linkWeb.clickEvent();
			} else {
				linkWeb.click();
			}
			webPage.sleep(1000);
			webPage.toggleWindow();
			url = webDriver.getCurrentUrl();
			webPage.sleep(1000);
			webPage.close_toggleWindow();
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElement, webPage.getCurrentUrl(), expectedResult, url, e.getMessage());
		}
		return url;
	}

	// END tc37 to tc-42
	
	//TC-44
	/**
	 * 
	 * @param driver
	 */
	  public Boolean msnHeaderScroll(WebDriver driver)
	   {
	          Boolean flag=false;

	             try {
	                    if (!BrowserInfoUtil.INSTANCE.isFF()) {
	                           webPage.sleep(15000);
	                           JavascriptExecutor jsx = (JavascriptExecutor) driver;
	                           jsx.executeScript("window.scrollBy(0,400)", "");
	                           flag = true;
	                    } else {
	                           Actions dragger = new Actions(driver);
	                           WebElement draggablePartOfScrollbar = driver.findElement(By
	                                        .xpath(CrowdGoesWildPageElements.SCROLL_CHECK));
	                           dragger.moveToElement((WebElement) draggablePartOfScrollbar)
	                                        .moveByOffset(500, 500).perform();
	                           flag = true;
	                    }

	                    webPage.sleep(20000);
	                    return flag;
	             }

	             catch (Exception e) {
	            	 flag = false;
	                 setErrMessage(ResultType.ERROR, null, webPage.getCurrentUrl(),null, null, e.getMessage());
	             }
	             return flag;
	       }


	/**
	 * @param expectedURL
	 * @return
	 */
	public String getVideoSecondaryNavClicked(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_VIDEO;
			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isIE8()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE10()) {
				((Link) webPage.findObjectsUsingXpath(pageElementXpath,
						ObjectType.Link)).clickEvent();
			} else {
				((Link) webPage.findObjectsUsingXpath(pageElementXpath,
						ObjectType.Link)).click();
			}
			webPage.sleep(20000);
			url = webPage.getCurrentUrl();
			log.info("Actual URL On Video Link Clicked :: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 *
	 * @param color
	 * @return String value for CAST Text
	 */
	public boolean checkifMenuExpands(String Value) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_CAST;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			if (BrowserInfoUtil.INSTANCE.isSafari()) {
				videoText.hover();
				webPage.sleep(10000);
				pageElementXpath = CrowdGoesWildPageElements.CAST_LI;
				WebElement element2 = webPage.getDriver().findElement(
						By.xpath(pageElementXpath));
				Text videoText_2 = (Text) webPage.findObjectsUsingXpath(
						pageElementXpath, ObjectType.Text);
				log.info("Sub Cast Link:: " + videoText_2.getText());
				flag = element2.isEnabled();
				webPage.sleep(5000);
			} else {
				videoText.textHover();
				webPage.sleep(15000);
				Actions build1 = new Actions(webPage.getDriver());
				pageElementXpath = CrowdGoesWildPageElements.CAST_LI;
				WebElement element2 = webPage.getDriver().findElement(
						By.xpath(pageElementXpath));
				build1.moveToElement(element2).build().perform();
				log.info("Sub Cast Link:: " + element2.getText());
				flag = element2.isEnabled();
				webPage.sleep(5000);
			}

		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), String.valueOf(flag), Value,
					e.getMessage());
		}
		return flag;
	}

	/**
	 *
	 * @param color
	 * @return String value for header text
	 */
	public boolean getBorderColor(String color) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_CAST;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			if (BrowserInfoUtil.INSTANCE.isSafari()) {
				videoText.hover();
				webPage.sleep(10000);
				pageElementXpath = CrowdGoesWildPageElements.CAST_LI;
				WebElement element2 = webPage.getDriver().findElement(
						By.xpath(pageElementXpath));
//				videoText.click();
				value = Color.fromString(videoText.getCssValue("color")).asHex();
				webPage.sleep(5000);
			} else {
				videoText.textHover();
				webPage.sleep(10000);
				Actions build1 = new Actions(webPage.getDriver());
				pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_CAST_ANCHOR;
				Text subelement = (Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text);
				WebElement element2 = webPage.getDriver().findElement(
						By.xpath(pageElementXpath));
				build1.moveToElement(element2).build().perform();
				webPage.sleep(10000);
				value = subelement.borderColor();
			}

			log.info("Border color:: " + value);
			webPage.sleep(5000);
			if (value.equalsIgnoreCase(color)) {
				flag = true;
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), color, value, e.getMessage());
		}
		return flag;
	}
	/**
	 *
	 * @param color
	 * @return String value for header text
	 */
	public boolean getSubLinkTextColor(String color) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_CAST;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			videoText.textHover();
			webPage.sleep(15000);

			if (BrowserInfoUtil.INSTANCE.isSafari()) {
				videoText.click();
				videoText.hover();
				webPage.sleep(10000);
				pageElementXpath = CrowdGoesWildPageElements.CAST_LI;
				WebElement element2 = webPage.getDriver().findElement(By.xpath(pageElementXpath));
				webPage.sleep(10000);
				value = Color.fromString(videoText.getCssValue("color")).asHex();
				webPage.sleep(5000);
			} else {
				videoText.textHover();
				webPage.sleep(10000);
				Actions build1 = new Actions(webPage.getDriver());
				pageElementXpath = CrowdGoesWildPageElements.CAST_LI;
				Text subelement = (Text) webPage.findObjectsUsingXpath(pageElementXpath,ObjectType.Text);
				WebElement element2 = webPage.getDriver().findElement(
						By.xpath(pageElementXpath));
				build1.moveToElement(element2).build().perform();
				webPage.sleep(15000);
				value = subelement.textColor();
			}
			log.info("Text color:: " + value);
			if (value.equalsIgnoreCase(color)) {
				flag = true;
			}
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), color, value, e.getMessage());
		}
		return flag;
	}
	/**
	 * @param expectedURL
	 * @return
	 */
	public String getCastSecondaryNavClicked(String expectedURL) {
		String url = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_CAST;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			videoText.textHover();
			webPage.sleep(15000);

			Actions build1 = new Actions(webPage.getDriver());
			pageElementXpath = CrowdGoesWildPageElements.CAST_LI;
			Text subelement = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element2 = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			build1.moveToElement(element2).build().perform();
			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE10()) {
				subelement.clickEvent();
			} else {
				element2.click();
			}

			webPage.sleep(10000);
			url = webPage.getCurrentUrl();
			webPage.sleep(10000);
			log.info("Actual URL On Cast Sub Link Click:: " + url);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), expectedURL, url, e.getMessage());
		}
		return url;
	}

	/**
	 * TC 29
	 *
	 * @param color
	 * @return String value for header text
	 */
	public String getSubLinkText(String text) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_CAST;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			videoText.textHover();
			webPage.sleep(10000);

			Actions build1 = new Actions(webPage.getDriver());
			pageElementXpath = CrowdGoesWildPageElements.CAST_LI;
			Text subelement = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element2 = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			build1.moveToElement(element2).build().perform();
			// webPage.sleep(5000);
			value = element2.getText();
			log.info("Sub Link Text present:: " + element2.getText());
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.TUNE_IN_HEADER;
			Text tuneInText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);

			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE10()) {
				tuneInText.clickEvent();
			} else {
				tuneInText.click();
			}

			webPage.sleep(5000);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), text, String.valueOf(flag),
					e.getMessage());
		}
		return value;
	}

	/**
	 * TC 29
	 *
	 * @param color
	 * @return String value for Video Text
	 */
	public boolean getVideoClickedAndHoverText(String color) {
		boolean flag = false;
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_VIDEO;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);

			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE10()) {
				videoText.clickEvent();
			} else {
				videoText.click();
			}
			webPage.sleep(10000);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			value = Color.fromString(element.getCssValue("color")).asHex();
			webPage.sleep(5000);
			if (value.equalsIgnoreCase(color)) {
				flag = true;
			}
			log.info("video color:: " + value);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), color, value, e.getMessage());
		}
		return flag;
	}

	/**
	 * TC 30
	 *
	 * @param color
	 * @return String value for header text
	 */
	public String getCloseLinkText(String text) {
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_CAST;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			videoText.textHover();
			webPage.sleep(15000);

			Actions build1 = new Actions(webPage.getDriver());
			pageElementXpath = CrowdGoesWildPageElements.CAST_CLOSE;
			Text subelement = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element2 = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			build1.moveToElement(element2).build().perform();

			value = element2.getText();

			log.info("Close Text present:: " + value);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), text, value, e.getMessage());
		}
		return value;
	}

	/**
	 * TC 30
	 *
	 * @param color
	 * @return String value for header text
	 */
	public String getSubLinkTextOnClickOfClose(String text) {
		String value = "";
		try {
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.SECONDARY_NAV_CAST;
			Text videoText = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			videoText.textHover();
			webPage.sleep(15000);

			Actions build1 = new Actions(webPage.getDriver());
			pageElementXpath = CrowdGoesWildPageElements.CAST_LI;
			Text subelement = (Text) webPage.findObjectsUsingXpath(pageElementXpath,
					ObjectType.Text);
			WebElement element2 = webPage.getDriver().findElement(
					By.xpath(pageElementXpath));
			build1.moveToElement(element2).build().perform();
			webPage.sleep(10000);
			pageElementXpath = CrowdGoesWildPageElements.CAST_CLOSE;
			Link tuneInText = (Link) webPage.findObjectsUsingXpath(pageElementXpath,ObjectType.Link);
			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE10()) {
				tuneInText.clickEvent();
			} else {
				tuneInText.click();
			}
			webPage.sleep(5000);
			if (!subelement.isElementVisible()) {
				value = subelement.getText();
			}
			log.info("Sub Link Text present:: " + value);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), text, value, e.getMessage());
		}
		return value;
	}

	// TC 35 - 37 and 45 -47
	/**
	 *
	 * @param xpathValues
	 * @param expectedText
	 * @return
	 */
	// start TC
	private String validateHeaderImage(String pageElementXpath, String expectedImage) {
		String actualImageSrc = null;
		try {
			// webPage.sleep(50000);
			// pageElementXpath = CrowdGoesWildPageElements.HEADER_IMG;
			actualImageSrc = ((Image) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Image)).getAttribute("src");
			log.info("actualImageSrc:: " + actualImageSrc);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedImage, actualImageSrc, e.getMessage());
			log.error(getErrMessage());
		}
		return actualImageSrc;
	}

	private String validateHeaderImageLink(String pageElementXpath, String expectedImageLink) {
		String actualImageLink = null;
		try {
			// webPage.sleep(50000);
			// pageElementXpath = CrowdGoesWildPageElements.HEADER_IMG;
			((Image) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Image)).click();
			actualImageLink = webPage.getCurrentUrl();
			// webPage.getBackToUrl();
			log.info("actualImageSrc:: " + actualImageLink);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), expectedImageLink, actualImageLink, e.getMessage());
			log.error(getErrMessage());
		}
		return actualImageLink;
	}

	public String validate_three_HeaderImage(String expectedImage) {
		// webPage.resize(1366, 768);
		pageElementXpath = CrowdGoesWildPageElements.HEADER_IMG;
		String headerImage = validateHeaderImage(pageElementXpath, expectedImage);
		// webPage.getDriver().manage().window().maximize();
		return headerImage;
	}

	public String validate_three_HeaderImageLink(String expectedImageLink) {
		// webPage.resize(1366, 768);
		pageElementXpath = CrowdGoesWildPageElements.HEADER_IMG;
		String headerImageLink = validateHeaderImageLink(pageElementXpath, expectedImageLink);
		// webPage.getDriver().manage().window().maximize();
		return headerImageLink;
	}

	public String validate_Two_HeaderImage(String expectedImage) {
		// webPage.resize(1024, 768);
		pageElementXpath = CrowdGoesWildPageElements.HEADER_IMG_TWO_COL;
		String headerImage = validateHeaderImage(pageElementXpath, expectedImage);
		// webPage.getDriver().manage().window().maximize();
		return headerImage;
	}

	public String validate_Two_HeaderImageLink(String expectedImageLink) {
		// webPage.resize(1024, 768);
		pageElementXpath = CrowdGoesWildPageElements.HEADER_IMG_TWO_COL;
		String headerImageLink = validateHeaderImageLink(pageElementXpath, expectedImageLink);
		// webPage.getDriver().manage().window().maximize();
		return headerImageLink;
	}

	public String validate_One_HeaderImage(String expectedImage) {
		// webPage.resize(400, 768);
		pageElementXpath = CrowdGoesWildPageElements.HEADER_IMG_ONE_COL;
		String headerImage = validateHeaderImage(pageElementXpath, expectedImage);
		// webPage.getDriver().manage().window().maximize();
		return headerImage;
	}

	public String validate_One_HeaderImageLink(String expectedImageLink) {
		// webPage.resize(400, 768);
		pageElementXpath = CrowdGoesWildPageElements.HEADER_IMG_ONE_COL;
		String headerImageLink = validateHeaderImageLink(pageElementXpath, expectedImageLink);
		// webPage.getDriver().manage().window().maximize();
		return headerImageLink;
	}

	public boolean validateTuneInHeader(boolean isHeaderPresent) {
		boolean tuneInHeader = false;
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.TUNE_IN_HEADER;
			tuneInHeader = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).isDisplayed();
			log.info("Tune IN Header is " + tuneInHeader);
			log.info("Tune in Header presence is :: " + tuneInHeader);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), Boolean.toString(isHeaderPresent), Boolean.toString(tuneInHeader), e.getMessage());
			log.error(getErrMessage());
		}
		return tuneInHeader;
	}

	public String validateTuneInHeaderFontStyle(String fontStyle) {
		String elementFontStyle = null;
		try {
			// log.info("here 12");
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.TUNE_IN_HEADER;
			elementFontStyle = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getCssValue("font-family");
			log.info("Font style is " + elementFontStyle);
			log.info("Tune in Header Font style is " + elementFontStyle);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), "Font style is " + elementFontStyle, null, e.getMessage());
			log.error(getErrMessage());
		}
		return elementFontStyle;
	}

	public String validateTuneInHeaderFontColor(String fontColor) {
		String hex = null;
		try {
			// log.info("here 12");
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.TUNE_IN_HEADER;
			String elementFontColor = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getCssValue("color");
			hex = Color.fromString(elementFontColor).asHex();
			log.info("Font color is " + hex);
			log.info("Tune in Header Font color is " + hex);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), "Font color is " + hex, null, e.getMessage());
			log.error(getErrMessage());
		}
		return hex;
	}

	public String validateTuneInHeaderFontSize(String fontSize) {
		String elementFontSize = null;
		try {
			// log.info("here 12");
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.TUNE_IN_HEADER;
			elementFontSize = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text)).getCssValue("font-size");
			log.info("Font style is " + elementFontSize);
			log.info("Tune in Header Font Size is " + elementFontSize);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath, webPage.getCurrentUrl(), "Font Size is " + elementFontSize, null, e.getMessage());
			log.error(getErrMessage());
		}
		return elementFontSize;
	}

	public boolean validate_Three_TuneInHeader(boolean isHeaderPresent) {
		// webPage.getDriver().manage().window().maximize();
		boolean headerPresent = validateTuneInHeader(isHeaderPresent);
		webPage.getDriver().manage().window().maximize();
		return headerPresent;
	}

	public String validate_Three_TuneInHeaderFontStyle(String fontStyle) {
		// webPage.getDriver().manage().window().maximize();
		String actualFontSize = validateTuneInHeaderFontStyle(fontStyle);
		// webPage.getDriver().manage().window().maximize();
		return actualFontSize;
	}

	public String validate_Three_TuneInHeaderFontColor(String fontColor) {
		// webPage.getDriver().manage().window().maximize();
		String actualFontSize = validateTuneInHeaderFontColor(fontColor);
		// webPage.getDriver().manage().window().maximize();
		return actualFontSize;
	}

	public String validate_Three_TuneInHeaderFontSize(String fontSize) {
		// webPage.getDriver().manage().window().maximize();
		String actualFontSize = validateTuneInHeaderFontSize(fontSize);
		// webPage.getDriver().manage().window().maximize();
		return actualFontSize;
	}

	public boolean validate_Two_TuneInHeader(boolean isHeaderPresent) {
		// webPage.resize(1024, 768);
		boolean headerPresent = validateTuneInHeader(isHeaderPresent);
		// webPage.getDriver().manage().window().maximize();
		return headerPresent;
	}

	public String validate_Two_TuneInHeaderFontSize(String fontSize) {
		// webPage.resize(1024, 768);
		String actualFontSize = validateTuneInHeaderFontSize(fontSize);
		// webPage.getDriver().manage().window().maximize();
		return actualFontSize;
	}

	public boolean validate_One_TuneInHeader(boolean isHeaderPresent) {
		// webPage.resize(400, 768);
		boolean headerPresent = validateTuneInHeader(isHeaderPresent);
		// webPage.getDriver().manage().window().maximize();
		return headerPresent;
	}

	public String validate_One_TuneInHeaderFontSize(String fontSize) {
		// webPage.resize(400, 768);
		String actualFontSize = validateTuneInHeaderFontSize(fontSize);
		// webPage.getDriver().manage().window().maximize();
		return actualFontSize;
	}

	/**
	 * @param expectedURL
	 * @return
	 */
	public boolean getBuzzerSecondaryNavClicked(String expectedValue) {
		String beforePositionValue = "";
		String afterPositionValue = "";
		boolean flag=true;
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.BUZZER_LINK;
			Text secondaryNavText = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text));
			WebElement element1 = webPage.getDriver().findElement(By.xpath(pageElementXpath));
			pageElementXpath = CrowdGoesWildPageElements.BUZZER_IMAGE;
			Point element2 = webPage.getDriver().findElement(By.xpath(pageElementXpath)).getLocation();
			Point p1 = getScrollPosition();
			beforePositionValue="("+p1.getX()+","+p1.getY()+")";
			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE10())
			{
				secondaryNavText.clickEvent();
			} else {
				element1.click();
			}
			webPage.sleep(10000);
			Point ele=getScrollPosition();
			beforePositionValue="("+ele.getX()+","+ele.getY()+")";
			if(beforePositionValue.equalsIgnoreCase(afterPositionValue)){
				flag=false;
			}
			log.info("Actual Position On Click:: " + afterPositionValue);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), expectedValue, String.valueOf(flag), e.getMessage());
		}
		return flag;
	}


	/**
	 * @param expectedValue
	 * @return
	 */
	public boolean getINFOSecondaryNavClicked(String expectedValue) {
		String beforePositionValue = "";
		String afterPositionValue = "";
		boolean flag=true;
		try {
			webPage.sleep(20000);
			pageElementXpath = CrowdGoesWildPageElements.INFO_LINK;
			Text secondaryNavText = ((Text) webPage.findObjectsUsingXpath(pageElementXpath, ObjectType.Text));
			WebElement element1 = webPage.getDriver().findElement(By.xpath(pageElementXpath));
			pageElementXpath = CrowdGoesWildPageElements.INFO_IMAGE;
			Point element2 = webPage.getDriver().findElement(By.xpath(pageElementXpath)).getLocation();
			Point p1 = getScrollPosition();
			beforePositionValue="("+p1.getX()+","+p1.getY()+")";
			if (BrowserInfoUtil.INSTANCE.isSafari()
					|| BrowserInfoUtil.INSTANCE.isIE9()
					|| BrowserInfoUtil.INSTANCE.isIE10())
			{
				secondaryNavText.clickEvent();
			} else {
				element1.click();
			}
			webPage.sleep(10000);
			Point ele=getScrollPosition();
			afterPositionValue="("+ele.getX()+","+ele.getY()+")";
			if(beforePositionValue.equalsIgnoreCase(afterPositionValue)){
				flag=false;
			}
			log.info("Actual Position On Click:: " + afterPositionValue);
		} catch (PageException e) {
			log.error(e.getMessage());
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), expectedValue, String.valueOf(flag), e.getMessage());
		}
		return flag;
	}

	public Point getScrollPosition() {
		  JavascriptExecutor js = (JavascriptExecutor) webPage.getDriver();

		  Long ycoordinate = (Long) js.executeScript("return window.pageYOffset", "");
		  Long xcoordinate = (Long) js.executeScript("return window.pageXOffset", "");
		  return new Point(xcoordinate.intValue(), ycoordinate.intValue());
	}

	/**
	 *
	 * @param expectedText
	 * for secondary nav links
	 * @return
	 */
	public String validateSecondayNavElelmentsForOneColumn(String xpathValues,
			String expectedText) {
		String secondaryNavText = null;
		try {
			webPage.sleep(30000);
			pageElementXpath = xpathValues;
			secondaryNavText = ((Text) webPage.findObjectsUsingXpath(
					pageElementXpath, ObjectType.Text)).getText();
			log.info("Secondary Nav Text:: " + secondaryNavText);
		} catch (PageException e) {
			setErrMessage(ResultType.ERROR, pageElementXpath,
					webPage.getCurrentUrl(), expectedText, secondaryNavText,
					e.getMessage());
			log.error(getErrMessage());
		}
		return secondaryNavText;
	}
	
//	public int checkImageCountinFeed(String feedUrl) {
//
//		int imgCount = 0;
//
//		JSONObject jsonObj;
//
//		try {
//
//			jsonObj = JSONUtil.readJSONFeed(feedUrl);
//
//			JSONArray buzzerComps = (JSONArray) ((JSONObject) jsonObj
//					.get("feedContent")).get("entries");
//
//			log.info("buzzerComps--------------------------------------------------- ::"
//					+ buzzerComps);
//
//			for (Object entry : buzzerComps) {
//
//				if (entry instanceof JSONObject) {
//
//					JSONObject priImage = (JSONObject) ((JSONObject) entry)
//							.get("primaryImage");
//
//					if (null != priImage && !priImage.isEmpty()) {
//
//						log.info("priImage ::" + priImage);
//
//						imgCount++;
//
//					}
//
//				}
//
//			}
//
//			log.info("imgCount ::" + imgCount);
//
//		} catch (IOException e) {
//
//			log.error("The feed url was not read. IO exception Occured");
//
//			e.printStackTrace();
//
//		} catch (ParseException e) {
//
//			log.error("The feed url was not read. parser exception Occured");
//
//			e.printStackTrace();
//
//		}
//
//		return imgCount;
//
//	}
	
	 
}