package com.etouch.cisco.common;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.TestParameters;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.core.resources.ObjectValType;
import com.etouch.taf.core.resources.WaitCondition;
import com.etouch.taf.tools.defect.DefectManager;
import com.etouch.taf.util.LogUtil;
import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.common.pages.CommonPage;
import com.etouch.taf.webui.selenium.webelement.*;
import com.etouch.taf.webui.selenium.WebPage;

@IExcelDataFiles(excelDataFiles = { "file1=src/test/resources/testdata/cisco.xls" })
public class TestCiscoMainPage extends BaseTest {
	private static Log log = LogUtil.getLog(ECUCal.class);
	//private String url = "https://tools-stage-was7.cisco.com/wsrp/pwc019/mobile/view";
	private String url="https://tools.cisco.com/wsrp/pwc019/mobile/view";
	private CiscoMainPage mainPage;
	private CiscoMainPage_iPad mainPages;
	private CiscoMainPage_iPhone mainPagesiPhone;
	private CiscoMainPage_Android mainPagesAndroid;
	private String device = "";
	
	//Testing Start- Kanika 
	private static String DEFECT_PROP = "src/test/resources/defect.properties";
	private static final String PROJECT_ID="16693935825"; // This is the Sample Project Id
	private static final String SEARCH_TEST_ID= "17571508382"; 
			//"177776520703" ;//"17721865"; // This the TestCase Id for Search.
	
	private static final String STORY_ID=""; // provide the story id here if the defect is related to any story. 
	private static final String DEFECT_OWNER = "/user/16693935729"; //currently this is rpandey
	private static String DEFECT_SEVERITY="Major Problem"; //override it as per severity
	private static String DEFECT_NOTES="Automation test assertionerror"; 
	private static final String SEARCH_DEFECT_NAME="search_def_new12";
	
	//Testing End - Kanika
	@BeforeClass
	public void prepareBeforeClass() throws Exception {
		try {
			WebPage webPage = new WebPage();
			device = TestBedManager.INSTANCE.getCurrentTestBed().getDeviceName();
			System.out.println(device);
			 
			if(device!=null && device.startsWith("iPa")) 
		{
			mainPages = new CiscoMainPage_iPad();
			
		}
		else if(device!=null && device.startsWith("iPh")) 
		{
			mainPagesiPhone = new CiscoMainPage_iPhone();
			
		}
		else if(device!=null && device.equalsIgnoreCase("Android")) 
		{
			mainPagesAndroid = new CiscoMainPage_Android();
			
		}

		else{
		mainPage = new CiscoMainPage(url, webPage);
		}
			
		} catch (Exception e) {
			System.out.println("errr is " + e);
		}
	}
	
	@AfterClass(alwaysRun=true)
public void tearDown(){
		
WebDriver driver=(WebDriver)TestBedManager.INSTANCE.getCurrentTestBed().getDriver();		
try {
	driver.wait(150000);
} catch (Exception e) {
}
driver.close();
driver.quit();
		

}

	//Testing for Login 
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 1)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "Authentication")
	public void testSignIn(TestParameters inputs) throws PageException {
		try {
			System.out.println("Starting test case 1");
			String actualURL = "";
			if(device!=null && device.startsWith("iPa")) {
				Thread.sleep(10000);
				mainPages.SignIn(inputs);
				mainPages.logAndCreateADefect(TestBedManager.INSTANCE.getDefect(),DEFECT_PROP,SEARCH_TEST_ID, PROJECT_ID,  STORY_ID, "Invalid Signin_Ipad", DEFECT_SEVERITY,DEFECT_OWNER,DEFECT_NOTES,"Sign in failed in ipad");
			}
			else if(device!=null && device.startsWith("iPh")) 
			{
				Thread.sleep(10000);
				mainPagesiPhone.SignIn(inputs);
				actualURL = mainPagesiPhone.getPageUrl();
				
			}
			
			else if(device!=null && device.equalsIgnoreCase("Android")) 
			{
			System.out.println("Inside sign in android");
			mainPagesAndroid.SignIn(inputs);
			}

			else
			{
				mainPage.SignIn(inputs);
				actualURL = mainPage.getPageUrl();
				//testing
				actualURL = "test";
			}
			System.out.println("The expected URL: "+ inputs.getParamMap().get("expected")+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 1 failed");
			mainPage.logAndCreateADefect(TestBedManager.INSTANCE.getDefect(),DEFECT_PROP,SEARCH_TEST_ID, PROJECT_ID,  STORY_ID, SEARCH_DEFECT_NAME, DEFECT_SEVERITY,DEFECT_OWNER,DEFECT_NOTES,e.getMessage());
			
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/*
	//Lease Tab 
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
	public void calCostLeaseTab(TestParameters inputs) {
		try {
			System.out.println("Starting test case 2");
			String actualURL = "";
			if(device!=null && device.startsWith("iP")) {
				mainPages.calCostLeaseTab(inputs);
				actualURL = mainPages.getPageUrl();
			}
			else
			{
					mainPage.calCostLeaseTab(inputs);
					actualURL = mainPage.getPageUrl();
			}
			
			System.out.println("The expected URL: "+ inputs.getParamMap().get("expected")+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 2 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
	
	//Purchase Tab
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 22)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void calCostPurchaseTab(TestParameters inputs) {
		try {
			System.out.println("Starting test case 28");
			String actualURL = "";
			if(device!=null && device.startsWith("iPa")) {
				mainPages.calCostPurchaseTab(inputs);
				actualURL = mainPages.getPageUrl();
			}
			else if(device!=null && device.startsWith("iPh")) {
				//mainPages.SignIn(inputs);
				//mainPages.ValidECU(inputs);
				//mainPagesiPhone.calCostPurchaseTab(inputs);
				actualURL = mainPagesiPhone.getPageUrl();
			}
			else
			{
				mainPage.calCostPurchaseTab(inputs);
				actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "+ inputs.getParamMap().get("expected")+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 28 failed");
			mainPage.logAndCreateADefect(TestBedManager.INSTANCE.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
/*
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 23)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
	public void SaveDuplicateTab(TestParameters inputs) {
		try {
			String actualURL="";
			System.out.println("Starting test case 29");
			if(device!=null && device.startsWith("iP")) {
				mainPages.DuplicateReport(inputs);
				actualURL = mainPages.getPageUrl();
			}else{
				mainPage.DuplicateReport(inputs);
				actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 29 failed");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 24)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "DuplicatePurchaseTab")
	public void cancelDupliacteReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 30");
			String actualURL=null;
			
			if(device!=null && device.startsWith("iP")) {
				mainPages.CancelDuplicateReport(inputs);
				actualURL = mainPages.getPageUrl();
			}else{
				mainPage.CancelDuplicateReport(inputs);
				 actualURL = mainPage.getPageUrl();
			}
			
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 30 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 29)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "SharePurchaseReport")
	public void shareReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 35");
			String actualURL=null;
			
			if(device!=null && device.startsWith("iPa")) {
				mainPages.sharePurchaseReport(inputs);
				actualURL = mainPages.getPageUrl();
			}
			else if(device!=null && device.startsWith("iPh")) {
				mainPagesiPhone.sharePurchaseReport(inputs);
				actualURL = mainPages.getPageUrl();
			}
			else{
			
			mainPage.sharePurchaseReport(inputs);
			 actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 35 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
/*
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 30)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CancelSharePurchaseReport")
	public void cancelshareReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 36");
			String actualURL=null;
			
			if(device!=null && device.startsWith("iP")) {
				mainPages.sharePurchaseReport(inputs);
				actualURL = mainPages.getPageUrl();
			}else{
				mainPage.shareCancelPurchaseReport(inputs);
				actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 36 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", "This is the sample defect","","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 31)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "ShareLeaseTab")
	public void shareLeaseReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 37");
			String actualURL=null;
			
			if(device!=null && device.startsWith("iP")) {
				mainPages.shareLeaseReport(inputs);
				actualURL = mainPages.getPageUrl();
			}else{
				mainPage.shareLeaseReport(inputs);
				 actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 37 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 32)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CancelShareLeaseReport")
	public void cancelshareLeaseReport(TestParameters inputs) {
		try {
			System.out.println("Starting test case 38");
			String actualURL=null;
			
			if(device!=null && device.startsWith("iP")) {
				mainPages.shareCancelLeaseReport(inputs);
				actualURL = mainPages.getPageUrl();
			}else{
			mainPage.shareCancelLeaseReport(inputs);
			 actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 38 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 39)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "EditDataECU")
	public void editDataCalECU(TestParameters inputs) {
		try {
			System.out.println("Starting test case 45");
			String actualURL=null;
			
			if(device!=null && device.startsWith("iP")) {
				mainPages.EditDataCalECU(inputs);
				actualURL = mainPages.getPageUrl();
			}else{
				mainPage.EditDataCalECU(inputs);
				actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 45 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 47)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LogOut")
	public void logout(TestParameters inputs) {
		try {
			System.out.println("Starting test case 53");
			String actualURL=null;
			
			if(device!=null && device.startsWith("iP")) {
				mainPages.Logout(inputs);
				actualURL = mainPages.getPageUrl();
			}else{
				mainPage.Logout(inputs);
				actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 53 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 48)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LogOutCancel")
	public void logoutCancel(TestParameters inputs) {
		try {
			System.out.println("Starting test case 54");
			String actualURL=null;
			
			if(device!=null && device.startsWith("iP")) { 
				mainPages.LogoutCancel(inputs);
				actualURL = mainPages.getPageUrl();
			}else{
				mainPage.LogoutCancel(inputs);
				 actualURL = mainPage.getPageUrl();
			}
			System.out.println("The expected URL: "
					+ inputs.getParamMap().get("expected")
					+ " and the actual url is: " + actualURL);
			Assert.assertEquals(actualURL,
					inputs.getParamMap().get("expected"), "URL did not matched");
		} catch (AssertionError e) {
			System.out.println("the test case 54 failed");
			mainPage.logAndCreateADefect(testBedManager.getDefect(), "", "7149", "16835742194", "", "SP_005", e.getMessage(),"","","");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	*/
}