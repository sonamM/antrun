/*
 * 
 */
package com.etouch.amazon.pages.test;

import javax.validation.constraints.AssertTrue;

import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.tools.defect.IDefectManager;
import com.etouch.taf.tools.rally.VideoRecorder;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.DateUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.SoftAssertor;
import com.etouch.amazon.common.BaseTest;

import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.TestParameters;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.core.exception.PageException;
import com.etouch.amazon.common.BaseTest;
import com.etouch.amazon.pages.AmazonMainPage;
import com.etouch.taf.webui.selenium.WebPage;

import java.io.IOException;
import java.awt.AWTException;


// TODO: Auto-generated Javadoc
/**
 * The Class TestAmazonMainPage.
 */
@IExcelDataFiles(excelDataFiles = { "file1=src/test/resources/testdata/amazon.xls" })
//@IExcelDataFiles(excelDataFiles = { "file1=stageData" })
public class TestAmazonMainPage extends BaseTest {
	
	/** The url. */
	private String url = "http://www.amazon.com/";
	
	/** The web page. */
	private WebPage webPage;
	
	/** The main page. */
	private AmazonMainPage mainPage;

	//required for jira
	/** The url3. */
	String url3 =TestBedManager.INSTANCE.getDefectConfig().getUrl3();
	
	/** The issue url. */
	String issueUrl = TestBedManager.INSTANCE.getDefectConfig().getIssueUrl();
	
	/** The username. */
	String username = TestBedManager.INSTANCE.getDefectConfig().getUsername();
	
	/** The password. */
	String password = TestBedManager.INSTANCE.getDefectConfig().getPassword();
	
	/** The keys. */
	String keys = TestBedManager.INSTANCE.getDefectConfig().getKeys();
	
	//required for rally
	/** The Constant DEFECT_PROP. */
	private static final String DEFECT_PROP = null;
	
	/** The Constant STORY_ID. */
	private static final String STORY_ID = null;
	
	/** The project id. */
	String PROJECT_ID = TestBedManager.INSTANCE.getDefectConfig().getProjectId();
	
	/** The defect owner. */
	String DEFECT_OWNER =TestBedManager.INSTANCE.getDefectConfig().getDefectOwner();
	
	/** The workspace id. */
	String WORKSPACE_ID  =TestBedManager.INSTANCE.getDefectConfig().getWorkspaceId();
	
	VideoRecorder videoRecorder = null;
	
	/**
	 * Prepare before class.
	 *
	 * @throws Exception the exception
	 */
	@BeforeClass
	public void prepareBeforeClass() throws Exception {
		try {
			
			webPage = new WebPage();
			mainPage = new AmazonMainPage(url, webPage);
			videoRecorder = new VideoRecorder("..\\AmazonPOC\\src\\test\\resources\\testdata\\videos\\");		
			
		}

		catch (Exception e) {
			CommonUtil.sop("errr is " + e);
			SoftAssertor.addVerificationFailure(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.etouch.amazon.common.BaseTest#tearDown()
	 */
	@AfterClass(alwaysRun = true)
	public void tearDown() {

		WebDriver driver = (WebDriver) TestBedManager.INSTANCE
				.getCurrentTestBed().getDriver();
		CommonUtil.sop("At tear down "+ driver);
		try {
			driver.wait(150000);
		} catch (Exception e) {
			//SoftAssertor.addVerificationFailure(e.getMessage());
		}
		driver.close();
		driver.quit();
		//mainPage.stopRecording();

	}
	
	

	// Testing for preSigIn 
	//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 1)
	//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "Authentication")
	/**
	 * Test pre sign in.
	 */
	@Test
	//public void testPreSignIn(TestParameters inputs) throws PageException {
	public void testPreSignIn()	{
		boolean isRecordingStopped = false;
	try {
			
			CommonUtil.sop("Starting test case 1");
			videoRecorder.startRecording();
			CommonUtil.sop("Recording feature on");
			
			//CommonUtil.sop (" test data from xls : " + inputs.getParamMap().get("uname") );
			String actualURL = "";
			String expectedURL = "";
			mainPage.PreSignIn();
			actualURL = mainPage.getPageUrl();
			
		if (actualURL == "https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dgno_signin");
		{
			
			CommonUtil.sop("this is same for test 1");
		}
		
		//SoftAssertor.assertFail("Failing test method1 for test results");	
		//SoftAssertor.assertEquals(actualURL, "www.yahoo.com");
			videoRecorder.stopRecording();
			videoRecorder.deleteRecording();
			isRecordingStopped = true;
			CommonUtil.sop("Stopped Recording at the end");

		} catch (AssertionError e) {
			SoftAssertor.addVerificationFailure(e.getMessage());
			CommonUtil.sop("the test case 1 failed");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			SoftAssertor.addVerificationFailure(e.getMessage());
			e.printStackTrace();
			
		}
		catch(Exception e)
		{
			SoftAssertor.addVerificationFailure(e.getMessage());
			e.printStackTrace();
		}
	
		finally
		{
			if(!isRecordingStopped)
				videoRecorder.stopRecording();
			SoftAssertor.displayAssertErrors();
			
		}
	}

	//@Test
	/**
	 * Test sign in.
	 *
	 * @param inputs the inputs
	 * @throws PageException the page exception
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 1)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "AMAZON", dataKey = "AuthenticationFail")
	public void testSignIn(TestParameters inputs){
		
		boolean isRecordingStopped = false;

	//public void testSignIn() throws PageException {
		try {
			CommonUtil.sop("Starting test case 2");
			videoRecorder.startRecording();
			CommonUtil.sop("Recording feature on");
			
			String actualURL = "";
			String expectedURL = "";
			
			//CommonUtil.sop("User Name is: " + TestBedManagerConfiguration.INSTANCE.getWebConfig().getUserName());
			//CommonUtil.sop("Password is: " + TestBedManagerConfiguration.INSTANCE.getWebConfig().getPassword());

			// actualURL =
			// "https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fcss%2Fhomepage.html%3Fie%3DUTF8%26ref_%3Dgno_yam_ya";
			mainPage.SignIn();
			CommonUtil.sop("this is here 2");
			actualURL = webPage.getCurrentUrl();
			expectedURL = "https://www.amazon.com/gp/yourstore/home?ie=UTF8&ref_=gno_signin&";
			
			if (actualURL == "https://www.amazon.com/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26ref_%3Dgno_signin");
			{
				
				CommonUtil.sop("this is same for test 2");
			}
			
			Assert.assertEquals(actualURL,"https://www.google.com", "URL did not matched");
			
			//SoftAssertor.assertEquals(actualURL,"https://www.google.com", "URL did not matched");	
			//SoftAssertor.assertFail("Failing test method2 for test results");
			
			videoRecorder.stopRecording();
			videoRecorder.deleteRecording();
			isRecordingStopped = true;
			CommonUtil.sop("Stopped Recording at the end");

		} catch (AssertionError e) {
			CommonUtil.sop("the test case 2 failed");
			
			String SEARCH_DEFECT_NAME = inputs.getParamMap().get("SearchDefectName");	
			String SEARCH_TEST_ID =  inputs.getParamMap().get("RallyTestCaseID");
			String DEFECT_SEVERITY =  inputs.getParamMap().get("DefectSeverity");
			String DEFECT_NOTES =  inputs.getParamMap().get("DefectNotes")  + "Video Link: "+ videoRecorder.getVideoLink();
			String attachmentPath = "..\\AmazonPOC\\src\\test\\resources\\testdata\\screenshots";
			
			CommonUtil.sop("Defect Notes is: " + DEFECT_NOTES);
			
			//mainPage.getScreenshot();
			videoRecorder.createScreenshot(attachmentPath, "error");
			
			mainPage.logAndCreateADefect(TestBedManager.INSTANCE.getDefect(),DEFECT_PROP,SEARCH_TEST_ID, WORKSPACE_ID, PROJECT_ID,  STORY_ID, SEARCH_DEFECT_NAME, DEFECT_SEVERITY,DEFECT_OWNER,DEFECT_NOTES,e.getMessage(), attachmentPath);	
			
			//defect logging method for jira
			//mainPage.logAndCreateADefect(TestBedManager.INSTANCE.getDefect(),url3, issueUrl, username, password,keys);		
			
			SoftAssertor.addVerificationFailure(e.getMessage());
		    e.printStackTrace();

		}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			SoftAssertor.addVerificationFailure(e.getMessage());
			e.printStackTrace();
		}
		catch(PageException e)
		{
			SoftAssertor.addVerificationFailure(e.getMessage());
			e.printStackTrace();
		}
		catch(Exception e)
		{
			SoftAssertor.addVerificationFailure(e.getMessage());
			e.printStackTrace();
		}
		finally
		{	
			if(!isRecordingStopped)
				videoRecorder.stopRecording();
			SoftAssertor.displayAssertErrors();
		}

	}

}
