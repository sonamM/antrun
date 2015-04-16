/*
 * 
 */
package com.etouch.amazon.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.testng.Assert;

import com.etouch.taf.core.exception.DateException;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.core.resources.DefectParameters;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.tools.defect.IDefectManager;
import com.etouch.taf.tools.rally.RallyConstants;
import com.etouch.taf.tools.rally.Rally;
import com.etouch.taf.tools.rally.RequestInfo;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.DateUtil;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.tools.jira.JiraConstants;
import com.etouch.taf.tools.jira.Jira;
import com.etouch.taf.tools.jira.JiraRequestInfo;
import com.microsoft.tfs.util.base64.Base64;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.*;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommonPage.
 *
 * @author eTouch Systems Corporation
 */
public abstract class CommonPage {

	/** The page url. */
	protected String pageUrl;
	
	/** The web page. */
	protected WebPage webPage;
	
	/** The err message. */
	protected String errMessage;
    //required for screen recorder
	/** The screen recorder. */
    private ScreenRecorder screenRecorder;
	
	/** The log. */
	private static Log log = LogUtil.getLog(CommonPage.class);
	
	/**
	 * Instantiates a new common page.
	 */
	public CommonPage(){
		
	}

	/**
	 * Instantiates a new common page.
	 *
	 * @param sbPageUrl the sb page url
	 * @param webPage the web page
	 */
	public CommonPage(String sbPageUrl, WebPage webPage){
		this.pageUrl=sbPageUrl;
		this.webPage=webPage;
	}

	/**
	 * Gets the err message.
	 *
	 * @return the err message
	 */
	public String getErrMessage() {
		CommonUtil.sop("Error Message + "  + errMessage );
		return errMessage;
	}

	/**
	 * Sets the err message.
	 *
	 * @param errMessage the new err message
	 */
	public void setErrMessage(String errMessage) {
		this.errMessage = errMessage;
	}

	/**
	 * Sets the err message.
	 *
	 * @param errorType the error type
	 * @param pageElement the page element
	 * @param pageUrl the page url
	 * @param expectedResult the expected result
	 * @param actualResult the actual result
	 * @param messageStr the message str
	 */
	//TODO: ...taf.core.logging
	//commented for safari test	
	public void setErrMessage(String errorType,
			String pageElement,
			String pageUrl,
			String expectedResult,
			String actualResult,
			String messageStr)
	{

		CommonUtil.sop("\n\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\nPage Exception in ????????????????????????? ::" + Thread.currentThread().getStackTrace()[2].getMethodName()
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
		CommonUtil.sop("Got Page Exception:-" + errMessage);

	}

	/**
	 * Load page.
	 */
	protected void loadPage() {
		webPage.loadPage(pageUrl);
		
	}

	
	/*
	 * Log error and create/add a defect
	 */
	/**
	 * Log and create a defect.
	 *
	 * @param defect the defect
	 * @param fileName the file name
	 * @param testcaseId the testcase id
	 * @param workspaceId the workspace id
	 * @param projId the proj id
	 * @param storyId the story id
	 * @param defectName the defect name
	 * @param defectSeverity the defect severity
	 * @param defectOwner the defect owner
	 * @param defectNotes the defect notes
	 * @param errorMsg the error msg
	 */
	public void logAndCreateADefect(IDefectManager defect, String fileName, String testcaseId, String workspaceId, String projId, String storyId, String defectName, String defectSeverity, String defectOwner, String defectNotes, String errorMsg, String attachmentPath){
		try{
			String defectNote = defectNotes + " : " + errorMsg;
			// to create defect and add attatchment 
		    defect.createDefectBuilder(defectName, testcaseId, workspaceId, projId, defectSeverity, defectOwner, defectNote, storyId, attachmentPath);
			
			System.out.println("Defect Logged ");
			//added to update testcase result 
			
			defect.updateTestCaseResult(defectName, testcaseId, workspaceId, projId, defectSeverity, defectOwner, defectNotes, storyId);
			System.out.println("Testcase Results updated ");
			
			}
			catch(Exception e){
			System.out.println("exception in common page log method");
			
		}	
		}

	//log and defect method for Jira defect --added by sonam
		/**
	 * Log and create a defect.
	 *
	 * @param defect the defect
	 * @param url the url
	 * @param issueUrl the issue url
	 * @param username the username
	 * @param password the password
	 * @param keys the keys
	 */
	public void logAndCreateADefect(IDefectManager defect,String url, String issueUrl, String username, String password,
				String keys){
			
			if (defect!= null){
				
			System.out.println("Executing the defect in Jira");
			
			defect.createAJiraDefectBuilder( url, issueUrl,  username, password,keys);
			
				}
		 	}
		

		///////// to start and stop video recording  // -- added by sonam
		
		
		/* *//**
		 * Start recording.
		 *//*
		public void startRecording() 
	       {
				String videoFilePath = "..\\AmazonPOC\\src\\test\\resources\\testdata\\videos\\";
				File videoFolder = new File(videoFilePath);
	           try{                  
	            GraphicsConfiguration gc = GraphicsEnvironment
	               .getLocalGraphicsEnvironment()
	               .getDefaultScreenDevice()
	               .getDefaultConfiguration();
	 
	           	this.screenRecorder = new ScreenRecorder(gc,
	           	   new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
	               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
	                    QualityKey, 1.0f,
	                    KeyFrameIntervalKey, 15 * 60),
	               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
	                    FrameRateKey, Rational.valueOf(30)),
	               null);
	            
	            this.screenRecorder = new ScreenRecorder(gc,null,
	 	           	   new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
	 	               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	 	                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
	 	                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
	 	                    QualityKey, 1.0f,
	 	                    KeyFrameIntervalKey, 15 * 60),
	 	               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
	 	                    FrameRateKey, Rational.valueOf(30)),
	 	               null,videoFolder);
	            
	            
	           	this.screenRecorder.start();
	        
	           }catch(IOException e){
	           e.printStackTrace();
	           }catch(AWTException e){
	        	   e.printStackTrace();  
	           }
	       }
	 
	       *//**
       	 * Stop recording.
       	 *//*
       	public void stopRecording() 
	       {
	    	 try{
	    		 this.screenRecorder.stop();
	    	 }catch(Exception e){
	    		  e.printStackTrace(); 
	    	 }
	       }*/

	 /////////////////Screenshot //////// -- added by sonam
	/*       
	       *//**
 	 * Gets the screenshot.
 	 *
 	 * @return the screenshot
 	 *//*
 	public void getScreenshot() {
				try{
			       // Thread.sleep(10000);
			        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			        ImageIO.write(image, "jpg", new File("..\\AmazonPOC\\src\\test\\resources\\testdata\\screenshots\\sample2.png"));
			      
	       }catch(IOException e){
	           e.printStackTrace();
	           }catch(AWTException e){
	        	   e.printStackTrace();  
	           }
	       }*/

}
