package com.etouch.fox.common.pages;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.openqa.selenium.remote.server.rest.ResultType;
import org.testng.Assert;

import com.etouch.fox.common.list.AttributeList;
import com.etouch.fox.common.list.ElementList;
import com.etouch.fox.watch.pages.elements.CrowdGoesWildPageElements;
import com.etouch.taf.core.exception.DateException;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.core.resources.DefectParameters;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.tools.defect.DefectManager;
import com.etouch.taf.tools.rally.RallyConstants;
import com.etouch.taf.tools.rally.Rally;
import com.etouch.taf.tools.rally.RequestInfo;
import com.etouch.taf.util.DateUtil;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Link;

/**
 *
 * @author eTouch Systems Corporation
 *
 */
public abstract class CommonPage {

	protected String pageUrl;
	protected WebPage webPage;
	protected String errMessage;

	private static Log log = LogUtil.getLog(CommonPage.class);
	
	public CommonPage(){
		
	}

	/**
	 * @param sbPageUrl
	 * @param webPage
	 */
	public CommonPage(String sbPageUrl, WebPage webPage){
		System.out.println("in commonpage constructor");
		this.pageUrl=sbPageUrl;
		this.webPage=webPage;
		System.out.println("done with in commonpage constructor");
	}

	/**
	 * @return
	 */
	public String getErrMessage() {
		System.out.println("Error Message + "  + errMessage );
		return errMessage;
	}

	/**
	 * @param errMessage
	 */
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	/**
	 * @param errorType
	 * @param pageElement
	 * @param pageUrl
	 * @param expectedResult
	 * @param actualResult
	 * @param messageStr
	 */
	//TODO: ...taf.core.logging
	public void setErrMessage(ResultType errorType,
			String pageElement,
			String pageUrl,
			String expectedResult,
			String actualResult,
			String messageStr)
	{

		System.out.println("\n\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nPage Exception in ????????????????????????? ::" + Thread.currentThread().getStackTrace()[2].getMethodName()
		        + "\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n\n");
		String message = "";
		try
		{
			if(errorType != null)
			{
				message += "\n # Error Type: " + errorType;
			}
			if(pageElement != null)
			{
				message += "\n # Page Element: " + pageElement;
			}
			if(pageUrl != null)
			{
				message += "\n # Page URL: " + pageUrl;
			}
			if(expectedResult != null)
			{
				message += "\n # Expected Result: " + expectedResult;
			}
			if(actualResult != null)
			{
				message += "\n # Actual Result: " + actualResult;
			}
			if(messageStr != null)
			{
				message += "\n # Message: " + messageStr;
			}
			message += "";
		}
		catch (Exception ex)
		{
			message = "An error occured while setting Error Message: " + ex.toString();
		}
		finally
		{
			this.errMessage = message;
		}
		System.out.println("Got Page Exception:-" + errMessage);

	}

	protected void loadPage() {
		webPage.loadPage(pageUrl);
		
	}

	public List<String> getBrokenLinksFromPage() throws PageException{
		List<String> lst = new ArrayList<String>();
		List<Link> lstLnk = webPage.findObjectsUsingTag(ElementList.ANCHOR, ObjectType.Link);
		for(Link lnk : lstLnk){
			String linkUrl = lnk.getAttribute(AttributeList.HREF);
			try {
				if(lnk.isLink(linkUrl)){
					if(lnk.isLinkBroken(linkUrl)){
						lst.add(linkUrl);
					}
				}
			} catch (PageException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return lst;
	}

	public List<String> getLinks() throws PageException{
		List<String> lstValue=new ArrayList<String>();
		List<Link> lstLnk = webPage.findObjectsUsingXpath(CrowdGoesWildPageElements.BUZZER_HEADER, ObjectType.Link);
		for(Link lnk:lstLnk){
			String str=lnk.getAttribute(AttributeList.HREF);
			lstValue.add(str);
		}
		return lstValue;
	}	
	
	/*
	 * Log error and create/add a defect
	 */
	public void logAndCreateADefect(DefectManager defect, String fileName, String testcaseId, String projId, String storyId, String defectName, String defectSeverity, String defectOwner, String defectNotes, String errorMsg){
		//log the error
		//setErrMessage("GOT PAGE EXCEPTION: " + errorMsg);
		//log.error(getErrMessage());

		/*Properties prop = null;
		try {
			prop = FileUtils.readPropertyFile("resources/defect.properties");
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		if(prop != null)
		{
			defectOwner = (String)prop.get("DEFECT_OWNER");
			defectSeverity = (String)prop.get("DEFECT_SEVERITY");
			defectNotes = (String)prop.getProperty("DEFECT_NOTES");
			
		}*/
		
		String defectNote = defectNotes + " : " + errorMsg;
		
		if(defect!=null){
			
			if(!defect.verifyDefectExists(testcaseId, projId, storyId, defectName)){
				defect.createDefectBuilder(defectName, testcaseId, projId, defectSeverity, defectOwner, defectNote, storyId);
				
			}else{
				if(defect.verifyIfdefectClosed()){
					defect.reopenDefect();					
				}
			}
			
		//		String queryVal = defect.queryDefect(testcaseId, storyId, projId, defectName, DefectParameters.RallyParams.State);
		//		boolean isUpdated = defect.updateDefect(testcaseId, projId, storyId, defectName, DefectParameters.RallyParams.Description, "new Defect description");
		}

		//re-throw the Assertion error
		Assert.fail(errorMsg);
	}

}
