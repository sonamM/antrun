package com.etouch.cisco.common;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
import com.etouch.taf.util.LogUtil;
import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.common.pages.CommonPage;
import com.etouch.taf.webui.selenium.webelement.*;
import com.etouch.taf.webui.selenium.WebPage;

@IExcelDataFiles(excelDataFiles = { "file1=src/test/resources/testdata/cisco.xls" })
public class Validation extends BaseTest {
	private static Log log = LogUtil.getLog(ECUCal.class);
	private String url = "https://tools-stage-was7.cisco.com/wsrp/pwc019/mobile/view";
	private CiscoMainPage mainPage;

	@BeforeClass
	public void prepareBeforeClass() throws Exception {
		try {
			WebPage webPage = new WebPage();
			mainPage = new CiscoMainPage(url, webPage);
		} catch (Exception e) {
			System.out.println("error is " + e);
		}
	}

	//Testing for the invalid ECU
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CalInvalidECU")
		public void testInvalidECU(TestParameters inputs) {
			try {
				System.out.println("Starting test case 2");
				mainPage.SignIn(inputs);
				mainPage.invalidECU(inputs);
				String actualURL = mainPage.getPageUrl();
				System.out.println(actualURL);
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 2 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 3)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CalInvalidECU1")
		public void testInvalidECU1(TestParameters inputs) {
			try {
				System.out.println("Starting test case 3");
				mainPage.invalidECU(inputs);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 3 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 4)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CalBlankECU")
		public void testBlankECU(TestParameters inputs) {
			try {
				System.out.println("Starting test case 4");
				mainPage.invalidECU(inputs);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 4 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 12)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
		public void blankLeasereport(TestParameters inputs) {
			try {
				System.out.println("Starting test case 13");
				mainPage.blankLeaseReport(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 13 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 13)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidLease")
		public void invalidLease(TestParameters inputs) {
			try {
				System.out.println("Starting test case 14");
				mainPage.invalidLease(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 14 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 14)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidLease1")
		public void invalidLease1(TestParameters inputs) {
			try {
				System.out.println("Starting test case 15");
				mainPage.invalidLease(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 15 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 10)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidLease2")
		public void invalidLease2(TestParameters inputs) {
			try {
				System.out.println("Starting test case 16");
				mainPage.invalidLease(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 16 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 11)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "DuplicateLease")
		public void SaveDuplicateLeaseReport(TestParameters inputs) {
			try {
				System.out.println("Starting test case 17");
				mainPage.DuplicateLeaseReport(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 17 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 12)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "DuplicateLease")
		public void cancelDuplicateLeaseReport(TestParameters inputs) {
			try {
				System.out.println("Starting test case 18");
				mainPage.cancelDuplicateLeaseReport(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 18 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Testing for the valid ECU
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 5)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "CalECU")
		public void testValidECU(TestParameters inputs) {
			try {
				System.out.println("Starting test case 5");
				mainPage.ValidECU(inputs);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 5 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/*//Testing for the multiple ECU
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 5)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "MultipleECU")
		public void testMultipleECU(TestParameters inputs) {
			try {
				System.out.println("Starting test case 6");
				mainPage.multipleECU(inputs);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 6 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
		//Testing for the lease tab
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 6)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
		public void validateHWCostHR(TestParameters inputs) {
			try {
				System.out.println("Starting test case 7");
				boolean val =  mainPage.verifyHWCost(inputs);
				Assert.assertEquals(val,true,"Hardware Cost Per Hour donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 7 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 7)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
		public void validatePowerLease(TestParameters inputs) {
			try {
				System.out.println("Starting test case 8");
				boolean val =  mainPage.verifyPower(inputs);
				Assert.assertEquals(val,true,"Power cost donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 8 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 8)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
		public void validateITMLease(TestParameters inputs) {
			try {
				System.out.println("Starting test case 9");
				boolean val =  mainPage.verifyITMLease(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Total IT Management Hours donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 9 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 9)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
		public void validateNFLease(TestParameters inputs) {
			try {
				System.out.println("Starting test case 10");
				boolean val =  mainPage.verifyNFLease(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Network Fee Per Hour donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 10 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 10)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
		public void validateOPEXHRLease(TestParameters inputs) {
			try {
				System.out.println("Starting test case 11");
				boolean val =  mainPage.verifyOPEXHRLease(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Total OPEX Per Hour donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 11 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 11)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
		public void validateECULease(TestParameters inputs) {
			try {
				System.out.println("Starting test case 12");
				boolean val =  mainPage.verifyECUHRLease(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Total ECU Per Hour donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 12 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
				
		//Testing for the Purchase tab
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 13)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validateAIData(TestParameters inputs) {
			try {
				System.out.println("Starting test case 19");
				boolean val =  mainPage.verifyAIData(inputs);
				//Thread.sleep(1000);
				System.out.println("value is "+val);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(val,true,"Additional Infrastructure cost donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 19 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 14)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validateCAPEXLabel(TestParameters inputs) {
			try {
				System.out.println("Starting test case 20");
				boolean val =  mainPage.verifyCAPEX(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"CAPEX donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 20 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 15)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validateCAPEXHRLabel(TestParameters inputs) {
			try {
				System.out.println("Starting test case 21");
				boolean val =  mainPage.verifyCAPEXHR(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"CAPEX PER HOUR donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 21 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 16)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validatePowerLabel(TestParameters inputs) {
			try {
				System.out.println("Starting test case 22");
				boolean val =  mainPage.verifyPOWER(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"POWER donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 22 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 17)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validateITM(TestParameters inputs) {
			try {
				System.out.println("Starting test case 23");
				boolean val =  mainPage.verifyITM(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"IT Management donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 23 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 18)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validateNf(TestParameters inputs) {
			try {
				System.out.println("Starting test case 24");
				boolean val =  mainPage.verifyNF(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Network Fee donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 24 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 19)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validateOPEX(TestParameters inputs) {
			try {
				System.out.println("Starting test case 25");
				boolean val =  mainPage.verifyOPEX(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"OPEX donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 25 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 20)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validateOPEXHR(TestParameters inputs) {
			try {
				System.out.println("Starting test case 26");
				boolean val =  mainPage.verifyOPEXHR(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"OPEX Per Hour donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 26 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 21)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void validateTotalECUHR(TestParameters inputs) {
			try {
				System.out.println("Starting test case 27");
				boolean val =  mainPage.verifyTotalECUHR(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Total ECU Per Hour donot match");
			} catch (AssertionError e) {
				System.out.println("the test case 27 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 26)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidPurchaseTab")
		public void invalidPurchaseData(TestParameters inputs) {
			try {
				System.out.println("Starting test case 32");
				mainPage.InvalidPurchaseTab(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 32 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 27)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidPurchaseTab1")
		public void invalidPurchaseData1(TestParameters inputs) {
			try {
				System.out.println("Starting test case 33");
				mainPage.InvalidPurchaseTab(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 33 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 28)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "InvalidPurchaseTab2")
		public void invalidPurchaseData2(TestParameters inputs) {
			try {
				System.out.println("Starting test case 34");
				mainPage.InvalidPurchaseTab(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 34 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 33)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "BlankToLeaseReport")
		public void shareLeaseReportBlankTo(TestParameters inputs) {
			try {
				System.out.println("Starting test case 39");
				mainPage.shareBlankToLease(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 39 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 34)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "BlankToPurchaseReport")
		public void sharePurchseReportBlankTo(TestParameters inputs) {
			try {
				System.out.println("Starting test case 40");
				mainPage.shareBlankToPurchase(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 40 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 35)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "ShareLeaseReportBlankSub")
		public void shareLeaseReportBlankSub(TestParameters inputs) {
			try {
				System.out.println("Starting test case 41");
				mainPage.shareBlankLease(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 41 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 36)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "SharePurchaseReportBlankSub")
		public void sharePurchseReportBlankSub(TestParameters inputs) {
			try {
				System.out.println("Starting test case 42");
				mainPage.shareBlankToPurchase(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 42 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 37)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "ShareLeaseReportBlankMsg")
		public void shareLeaseReportBlankMsg(TestParameters inputs) {
			try {
				System.out.println("Starting test case 43");
				mainPage.shareBlankLease(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 43 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 38)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "SharePurchaseReportBlankMsg")
		public void sharePurchseReportBlankMsg(TestParameters inputs) {
			try {
				System.out.println("Starting test case 44");
				mainPage.shareBlankToPurchase(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 44 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Testing for Feedback
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 40)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "FeedbackRating")
		public void feedbackRatings(TestParameters inputs) {
			try {
				System.out.println("Starting test case 46");
				mainPage.FeedbackRatings(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 46 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 41)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "FeedbackMessage")
		public void feedbackMessage(TestParameters inputs) {
			try {
				System.out.println("Starting test case 47");
				mainPage.FeedbackSubmission(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 47 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 42)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "FeedbackMessageBlank")
		public void feedbackMessageBlank(TestParameters inputs) {
			try {
				System.out.println("Starting test case 48");
				mainPage.FeedbackSubmission(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 48 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 25)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "PurchaseTab")
		public void blankPurchaseReport(TestParameters inputs) {
			try {
				System.out.println("Starting test case 31");
				mainPage.BlankReport(inputs);
				//Thread.sleep(1000);
				String actualURL = mainPage.getPageUrl();
				System.out.println("The expected URL: "
						+ inputs.getParamMap().get("expected")
						+ " and the actual url is: " + actualURL);
				Assert.assertEquals(actualURL,
						inputs.getParamMap().get("expected"), "URL did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 31 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 43)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "SharePurchaseReportMsg")
		public void shareReportMsg(TestParameters inputs) {
			try {
				System.out.println("Starting test case 49");
				boolean val = mainPage.ShareReportMsg(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Feedback message length exceeds 140 characters");
			} catch (AssertionError e) {
				System.out.println("the test case 49 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority =44)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "ShareLeaseReportMsg")
		public void shareReportLeaseMsg(TestParameters inputs) {
			try {
				System.out.println("Starting test case 50");
				boolean val = mainPage.ShareReportLeaseMsg(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Feedback message length exceeds 500 characters");
			} catch (AssertionError e) {
				System.out.println("the test case 50 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 45)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "SharePurchaseReportSub")
		public void shareReportSub(TestParameters inputs) {
			try {
				System.out.println("Starting test case 51");
				boolean val = mainPage.ShareReportSub(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Feedback Subject length exceeds 140 characters");
			} catch (AssertionError e) {
				System.out.println("the test case 51 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 46)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "ShareLeaseReportSub")
		public void shareReportLeaseSub(TestParameters inputs) {
			try {
				System.out.println("Starting test case 52");
				boolean val = mainPage.ShareReportLeaseSub(inputs);
				//Thread.sleep(1000);
				Assert.assertEquals(val,true,"Feedback Subject length exceeds 140 characters");
			} catch (AssertionError e) {
				System.out.println("the test case 52 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 22)
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CISCO", dataKey = "LeaseTab")
		public void validateLeaseTab(TestParameters inputs) {
			try {
				System.out.println("Starting test case 28");
				String res = mainPage.validateLeaseTabValues(inputs);
				String[] rslt = res.split(",");
				Assert.assertEquals(rslt[0],"hwcost", "HW Cost per hour did not matched");
				Assert.assertEquals(rslt[1],"power", "Power per hour did not matched");
				Assert.assertEquals(rslt[2],"itm", "IT management cost per hour did not matched");
				Assert.assertEquals(rslt[3],"nfee", "Network Fee per hour did not matched");
				Assert.assertEquals(rslt[4],"opex", "OPEX per hour did not matched");
				Assert.assertEquals(rslt[5],"totalecuhr", "Total ECU per hour did not matched");
			} catch (AssertionError e) {
				System.out.println("the test case 28 failed");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

}