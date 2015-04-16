package test.etouch.fox.watch;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.SignInPage;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.infra.mail.IEmailValidator;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

/**
 * Test Class for testing SignUpModalPage page.
 *
 * @author eTouch Systems Corporation
 *
 */
@IExcelDataFiles(excelDataFiles = { "file1=src/test/resources/testdata/watch/crowd-goes-wild.xls", "file2=src/test/resources/testdata/global/header.xls",
        "file2=src/test/resources/testdata/global/footer.xls" })
public class TestSignInFunctionality extends BaseTest {

	private static Log log = LogUtil.getLog(TestSignInFunctionality.class);
	private WebPage webPage;
	private SignInPage	signInPage;
	private String	   signInPageUrl;
	Properties props = null;
	IEmailValidator emailValidator;

	@BeforeClass
	@Parameters(value = {"mailConfigPropFileName"})
	public void prepareBeforeClass(String mailConfigPropFileName) throws Exception {
		loadUrl();
		webPage = new WebPage();
		signInPage = new SignInPage(signInPageUrl, webPage);
		//TODO: verify if mailConfigPropFileName should be moved to SuiteListener
		try {
			props = FileUtils.readPropertyFile(mailConfigPropFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
	}


	private void loadUrl() {
		signInPageUrl = constructURL(SuiteListener.pageURLs.getProperty("SIGNIN_PAGE_URL"));
	}

//	/**
//	 * TC 1
//	 *
//	 * @param welcomeframe
//	 * @param testcaseId
//	 * @param projId
//	 * @param storyId
//	 */
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 1)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "SignIn")
//	public void testSignIn(String welcomeframe, String testcaseId, String projId, String storyId, String defectName) {
//		String welcomeframeText;
//		// boolean flag=false;
//		 try {
//		System.out.println("in first test case welcomeframe ::"+welcomeframe);
//		//signInPage.scrollWindow();
//		//Point positionBeforeClick = signInPage.getScrollPosition();
//		//int BeforeClick = positionBeforeClick.getY();
//		//log.info("BeforeClick ::" + BeforeClick);
//		welcomeframeText = signInPage.clickSignIn(welcomeframe);
//		Point positionAfterClick = signInPage.getScrollPosition();
//		int AfterClick = positionAfterClick.getY();
//		log.info("AfterClick ::" + AfterClick);
//		Assert.assertEquals(welcomeframeText, welcomeframe);
//		//Assert.assertTrue(AfterClick >= BeforeClick);
//		} catch (AssertionError e) {
//		 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//		 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//		 }
//	}
//
//	/**
//	 * TC 1
//	 *
//	 * @param ExpSignUpText
//	 * @param testcaseId
//	 * @param projId
//	 * @param storyId
//	 */
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "DigitalSignUp")
//	public void testDigitalSignUp(String ExpSignUpText, String testcaseId, String projId, String storyId, String defectName) {
//		 try {
//		String ActualsignUpText = signInPage.clicksignUpFrame(ExpSignUpText);
//		Assert.assertEquals(ActualsignUpText, ExpSignUpText);
//		 } catch (AssertionError e) {
//		 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//		 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//		 }
//	}
//
//	/**
//	 * TC 2
//	 *
//	 * @param ExpErrormessage
//	 * @param testcaseId
//	 * @param projId
//	 * @param storyId
//	 */
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 3)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VALIDATE_FIRST_NAME_EMPTY")
//	public void firstNameEmptyField(String inputValue, String ExpErrormessage, String testcaseId, String projId, String storyId, String defectName) {
//		 try {
//		String ActualErrormsg = signInPage.validateFirstNameForEmpty(inputValue, ExpErrormessage);
//		Assert.assertEquals(ActualErrormsg, ExpErrormessage);
//		 } catch (AssertionError e) {
//		 e.getMessage();
//		 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//		 defect_properties_file, testcaseId, projId, storyId, defectName,e.getMessage());
//		 }
//	}
//
//	/**
//	 * TC 2
//	 *
//	 * @param SpecialChar
//	 *
//	 * @param ExpErromessage
//	 * @param testcaseId
//	 * @param projId
//	 * @param storyId
//	 */
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 4)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VALIDATE_FIRST_NAME_SPECIALCHAR")
//	public void firstNamewithSpecialChar(String SpecialChar, String ExpErromessage, String testcaseId, String projId, String storyId, String defectName) {
//		 try {
//		String ActualErrormsg = signInPage.validateFirsNameSpecialChar(SpecialChar, ExpErromessage);
//		log.info("expected error msg:" + ExpErromessage);
//		log.info("actual error msg:" + ActualErrormsg);
//		Assert.assertEquals(ActualErrormsg, ExpErromessage);
//		 } catch (AssertionError e) {
//		 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//		 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//		 }
//	}
//		/**
//		 * TC 2
//		 *
//		 * @param text
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 5)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VALIDATE_FIRST_NAME")
//		public void firstNamewithProperChar(String text, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			boolean actualMsg = signInPage.validateFirstName(text, true);
//			Assert.assertTrue(actualMsg);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 3 This function will check for if last name field is entered or not
//		 * after clicking on Screen Name
//		 *
//		 * @param lnameText
//		 * @param expectedMsg
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 6)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VALIDATE_LAST_NAME")
//		public void testLastNameText(String lnameText, String expectedMsg, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualMsg = signInPage.validateLastNameForSignUp(lnameText, expectedMsg);
//			Assert.assertEquals(actualMsg, expectedMsg);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 4 This function will check for if Screen name field is entered or not
//		 * after click of EmailAddress
//		 *
//		 * @param snameText
//		 * @param expectedMsg
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 7)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VALIDATE_SCREEN_NAME")
//		public void testScreenNameText(String snameText, String expectedMsg, String testcaseId, String projId, String storyId, String defectName) {
//			try {
//			String actualMsg = signInPage.validateScreenNameForSignUp(snameText, expectedMsg);
//			Assert.assertEquals(actualMsg, expectedMsg);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId, defectName,e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 5
//		 *
//		 * @param inputValue
//		 * @param expectedValue
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 8)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_EMAIL")
//		public void testEmail(String inputValue, String expectedValue, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualValue = signInPage.checkEmail(inputValue, expectedValue);
//			Assert.assertEquals(actualValue, expectedValue);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC-6 This function will check for if password field is entered or not
//		 * before clicking on retype password
//		 *
//		 * @param passowrdText
//		 * @param expectedMsg
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 9)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VALIDATE_PASSWORD")
//		public void testPasswordText(String passowrdText, String expectedMsg, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualMsg = signInPage.validatePasswordForSignUp(passowrdText, expectedMsg);
//			Assert.assertEquals(actualMsg, expectedMsg);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 7 This function will check for if password field is entered or not
//		 * before clicking on retype password
//		 *
//		 * @param retypePassowrd
//		 * @param expectedMsg
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 *
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 10)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VALIDATE_RE_PASSWORD")
//		public void testRetypePasswordText(String retypePassowrd, String expectedMsg, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualMsg = signInPage.validateReTypePasswordForSignUp(retypePassowrd, expectedMsg);
//			Assert.assertEquals(actualMsg, expectedMsg);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 8
//		 *
//		 */
//		@Test(priority = 11)
//		public void testClickFirstCheckBox() {
//			 try {
//			boolean valid = signInPage.clickFirstCheckBox(true);
//			Assert.assertTrue(valid);
//			 } catch (AssertionError e) {
//			 // signInPage.logAndCreateADefect(testBedManager.getRally(),
//			 // rally_properties_file, testcaseId, projId, storyId,defectName,
//			 // e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 8
//		 *
//		 * @param expectedErrorMessage
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 12)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Validate_Checkbox")
//		public void testValidateCheckBox(String expectedErrorMessage, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualErrorMessage = signInPage.validateCheckBox(expectedErrorMessage);
//			Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 8
//		 *
//		 */
//		@Test(priority = 13)
//		public void testClickSecondCheckBox() {
//			// try {
//			boolean select = signInPage.clickSecondCheckBox(true);
//			Assert.assertTrue(select);
//			 //} catch (AssertionError e) {
//			 //signInPage.logAndCreateADefect(testBedManager.getRally(),
//			 // rally_properties_file, testcaseId, projId, storyId, defectName,
//			  //e.getMessage());
//			// }
//		}
//
//		/**
//		 * TC 8
//		 *
//		 * @param expectedUrl
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 14)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_PrivacyPolicy")
//		public void testLinkPrivacyPolicy(String expectedUrl, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualUrl = signInPage.clickLinkPrivacyPolicy(expectedUrl);
//			Assert.assertEquals(expectedUrl, actualUrl);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 9
//		 *
//		 * @param expectedUrl
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 15)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_TermsOfUse")
//		public void testlinkTermsOfUse(String expectedUrl, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualUrl = signInPage.clickLinkTermsOfUse(expectedUrl);
//			log.info("actual url -----------------" + actualUrl);
//			log.info("expected  url -----------------" + expectedUrl);
//			Assert.assertEquals(actualUrl, expectedUrl);
//			// signInPage.goBackToUrl();
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 9
//		 *
//		 * @param expectedUrl
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 16)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_Microsoft")
//		public void testlinkMicrosoft(String expectedUrl, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualUrl = signInPage.clickLinkMicrosoft(expectedUrl);
//			log.info("actual url -----------------" + actualUrl);
//			log.info("expected  url -----------------" + expectedUrl);
//			Assert.assertEquals(actualUrl, expectedUrl);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		// /**
//		// * TC 9
//		// * @throws PageException
//		// * @throws InterruptedException
//		// */
//		// @Test
//		// public void testclickSecondCheckBox() throws PageException,
//		// InterruptedException {
//		// try {
//		// boolean select = signInPage.clickSecondCheckBox();
//		// // Assert.assertTrue(select,"Please select check box.");
//		// log.info("---------------3---------------");
//		// } catch (AssertionError e) {
//		// e.getMessage();
//		// //
//		// buzzerPageVideoLink.logAndCreateADefect(testBedManager.getRally(),rally_properties_file,
//		// // testcaseId, projId, storyId,e.getMessage());
//		// }
//		// }
//		/**
//		 * TC 9
//		 *
//		 */
//		@Test(priority = 17)
//		public void testButtonSignUp() {
//			// try {
//			signInPage.clicksignUpButton();
//			// } catch (AssertionError e) {
//			// // signInPage.logAndCreateADefect(testBedManager.getRally(),
//			// // rally_properties_file, testcaseId, projId, storyId,
//			// // e.getMessage());
//			// }
//		}
//
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 18)
//        @ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_link")
//        public void testClickLink(String xpath,String expectedURL,String testcaseId, String projId, String storyId, String defectName)
//                throws InterruptedException {
//            try {
//                String actualURL = signInPage.clickSubLink(xpath,((WebDriver)TestBedManager.getTestBed().getDriver()),expectedURL);
//                Assert.assertEquals(actualURL, expectedURL, "URL is not matched.");
//            } catch (AssertionError e) {
//                signInPage.logAndCreateADefect(testBedManager.getDefect(),
//                        defect_properties_file, testcaseId, projId, storyId, defectName,
//                        e.getMessage());
//            }
//        }
//		// TC-10
//		/**
//		 *
//		 */
//		//@Test(priority = 19)
//		public void testClickAcceptButton() {
//			// try {
//			signInPage.clickAcceptButton();
//			// } catch (AssertionError e) {
//			// // signInPage.logAndCreateADefect(testBedManager.getRally(),
//			// // rally_properties_file, testcaseId, projId, storyId,defectName,
//			// // e.getMessage());
//			// }
//		}
//
//		/**
//		 * TC-10
//		 * Test case to check the registration mail is received and the mail body contains the
//		 * registration link.
//		 * @param checkUrlPattern
//		 * @param emailSubjectText
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 20)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "EMAIL_DATA", dataKey = "EMAIL_PATTERN_TEXT")
//		public void testEmailRegistrationLinkisPresent(String checkUrlPattern, String emailSubjectText, String testcaseId, String projId, String storyId, String defectName){
//			try {
//				Assert.assertTrue(signInPage.signIn_EmailRegisLinkPresent(props, checkUrlPattern, emailSubjectText), "Validation Failed");
//			} catch (Exception e) {
//				signInPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, e.getMessage());
//			}
//		}
//
//		/**
//		 * TC 11
//		 *
//		 * @param inputComment
//		 * @param expectedAction
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		// @Test(dataProvider = "tafDataProvider", dataProviderClass =
//		// TafExcelDataProvider.class, priority = 21)
//		// @ITafExcelDataProviderInputs(excelFile = "file1", excelsheet =
//		// "CGWHeader", dataKey = "CHECK_VERIFY_EMAIL")
//		public void testVerify_Email(String inputComment, String expectedAction, String testcaseId, String projId, String storyId, String defectName) {
//			// try {
//			log.info("\n inputComment ::" + inputComment + "\n expectedAction ::" + expectedAction);
//			String actualValue = signInPage.check_VerifyEmail(inputComment, expectedAction);
//			Assert.assertEquals(actualValue, expectedAction);
//			Boolean isPopupOpen = signInPage.closeVerifyEmail_popUp(false);
//			Assert.assertFalse(isPopupOpen);
//			// } catch (AssertionError e) {
//			// signInPage.logAndCreateADefect(testBedManager.getRally(),
//			// rally_properties_file, testcaseId, projId, storyId, e.getMessage());
//			// }
//		}
//
//		/**
//		 * TC-11
//		 * Test case to invoke the registration link from the mail body.Then checks for the text data on
//		 * on the new web page
//		 *
//		 * @param checkUrlPattern
//		 * @param emailSubjectText
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 * @param textData
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 22)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "EMAIL_DATA", dataKey = "EMAIL_PATTERN_REGISTRATION_TEXT")
//		public void testEmailRegistrationPage(String checkUrlPattern, String emailSubjectText, String testcaseId, String projId, String storyId, String defectName, String textData){
//			try {
//				Assert.assertTrue(signInPage.signIn_VerifyEmailRegistrationPage(props, checkUrlPattern, emailSubjectText, textData), "TEXT NOT MATCHED");
//
//			} catch(AssertionError e){
//				signInPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, e.getMessage());
//			}
//		}
//
//		/**
//		 * TC 12
//		 *
//		 * @param forgotpassword
//		 * @param welcometext
//		 * @param junkMail
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 * @throws InterruptedException
//		 */
//		//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 23)
//		//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "ForgetPassword")
//		public void testForgetPassword(String forgotpassword, String welcometext, String testcaseId, String projId, String storyId, String defectName) {
//			String forgetpasswordtext;
//			String Actualwelcometext;
//			try {
//			forgetpasswordtext = signInPage.forgetpassword(forgotpassword);
//			Assert.assertEquals(forgetpasswordtext, forgotpassword);
//			signInPage.clickBacklink();
//			Actualwelcometext = signInPage.validateWelcome(welcometext);
//			Assert.assertEquals(Actualwelcometext, welcometext);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		/**
//		 * TC 12
//		 *
//		 * @param forgotpassword
//		 * @param welcometext
//		 * @param ImproperMail
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 * @throws InterruptedException
//		 */
//		//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 24)
//		//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "ImProperMailID")
//		public void emailwithImproperID(String forgotpassword, String welcometext, String ImproperMail, String testcaseId, String projId, String storyId, String defectName) {
//			String Actualwelcometext;
//			String forgetResetText;
//			// try {
//			signInPage.forgetpassword(forgotpassword);
//			Actualwelcometext = signInPage.validateWelcome(welcometext);
//			Assert.assertEquals(Actualwelcometext, welcometext);
//			signInPage.entermail(ImproperMail);
//			forgetResetText = signInPage.passwordReset(forgotpassword);
//			Assert.assertEquals(forgetResetText, forgotpassword);
//			// } catch (AssertionError e) {
//			// signInPage.logAndCreateADefect(testBedManager.getRally(),
//			// rally_properties_file, testcaseId, projId, storyId, e.getMessage());
//			// }
//		}
//
//		/**
//		 * TC 12
//		 *
//		 * @param mailid
//		 * @param confirmationMSG
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 25)
//		//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "ProperMailID")
//		public void emailwithProperID(String mailid, String confirmationMSG, String testcaseId, String projId, String storyId, String defectName) {
//			// try {
//			signInPage.enterproperID(mailid);
//			String ActualconfirmMsg = signInPage.confirmationMSG(confirmationMSG);
//			Assert.assertEquals(ActualconfirmMsg, confirmationMSG);
//			// } catch (AssertionError e) {
//			// signInPage.logAndCreateADefect(testBedManager.getRally(),
//			// rally_properties_file, testcaseId, projId, storyId, e.getMessage());
//			// }
//		}
//
//		/**
//		 * TC-12
//		 * Test case to check if password reset mail is received and the mail body contains the
//		 * password reset link.
//		 *
//		 * @param checkUrlPattern
//		 * @param emailSubjectText
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 26)
//		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "EMAIL_DATA", dataKey = "RESET_PSWD_EMAIL_PATTERN")
//		public void testPasswordResetEmailLinkPresent(String checkUrlPattern, String emailSubjectText, String testcaseId, String projId, String storyId, String defectName){
//			try {
//				Assert.assertTrue(signInPage.signIn_EmailRegisLinkPresent(props, checkUrlPattern, emailSubjectText), "Validation Failed");
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				signInPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, e.getMessage());
//			}
//		}
//
//		// 71, 72, 73
//		/**
//		 * @param inputValue
//		 * @param expectedValue
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//	//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 27)
//	//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SIGNIN")
//		public void verify_signIn(String inputValue, String expectedValue, String testcaseId, String projId, String storyId, String defectName) {
//			// try {
//			String signin_errors = signInPage.verify_signIn(inputValue, expectedValue);
//			Assert.assertEquals(signin_errors, expectedValue);
//			// } catch (AssertionError e) {
//			// signInPage.logAndCreateADefect(testBedManager.getRally(),
//			// rally_properties_file, testcaseId, projId, storyId, e.getMessage());
//			// }
//		}
//
//		// 74, 75
//		/**
//		 * @param inputValue
//		 * @param expectedValue
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 28)
//		//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SIGNIN_EMAIL")
//		public void testSignIn_Email(String inputValue, String expectedValue, String testcaseId, String projId, String storyId, String defectName) {
//			// try {
//			String actualValue = signInPage.signIn_checkEmail(inputValue, expectedValue);
//			Assert.assertEquals(actualValue, expectedValue);
//			// } catch (AssertionError e) {
//			// signInPage.logAndCreateADefect(testBedManager.getRally(),
//			// rally_properties_file, testcaseId, projId, storyId, e.getMessage());
//			// }
//		}
//
//		// 76
//		/**
//		 * @param inputValue
//		 * @param expectedValue
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//	//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 29)
//	//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_EMPTY_PASSWORD")
//		public void testSignIn_EmptyPassword(String inputValue, String expectedValue, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualValue = signInPage.signIn_emptyPassword(inputValue, expectedValue);
//			Assert.assertEquals(actualValue, expectedValue);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		// 77
//		/**
//		 * @param inputValue
//		 * @param expectedValue
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 30)
//		//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_EMPTY_PASSWORD")
//		public void testSignIn_InvalidPassword(String inputValue, String expectedValue, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualValue = signInPage.signIn_emptyPassword(inputValue, expectedValue);
//			Assert.assertEquals(actualValue, expectedValue);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		// 78
//		/**
//		 * @param inputUserNameValue
//		 * @param inputPasswordValue
//		 * @param expectedValue
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 31)
//		//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_INVALID_USERNAME")
//		public void testSignIn_InvalidUser(String inputUserNameValue, String inputPasswordValue, String expectedValue, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actualValue = signInPage.signIn_invalidUser(inputUserNameValue, inputPasswordValue, expectedValue);
//			Assert.assertEquals(actualValue, expectedValue);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		// 79
//		/**
//		 * @param inputValue
//		 * @param expectedValue
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 32)
//		//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CLEAR_PASSWORD")
//		public void testSignIn_clearPassword(String inputValue, String expectedValue, String testcaseId, String projId, String storyId, String defectName) {
//			try {
//			String actualValue = signInPage.signIn_clearPassword(inputValue, expectedValue);
//			Assert.assertEquals(actualValue, expectedValue);
//			 } catch (AssertionError e) {
//			 signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//			 }
//		}
//
//		// 80, 81, 82
//		/**
//		 * @param inputValue1
//		 * @param inputValue2
//		 * @param expected_ScreenName
//		 * @param testcaseId
//		 * @param projId
//		 * @param storyId
//		 */
//		//@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 33)
//		//@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VALID_SIGNIN")
//		public void testSignIn_Success(String inputValue1, String inputValue2, String expected_ScreenName, String testcaseId, String projId, String storyId, String defectName) {
//			 try {
//			String actual_ScreenName = signInPage.signIn_success(inputValue1, inputValue2, expected_ScreenName);
//			Assert.assertEquals(actual_ScreenName, expected_ScreenName);
//			 } catch (AssertionError e) {
//			signInPage.logAndCreateADefect(testBedManager.getDefect(),
//			 defect_properties_file, testcaseId, projId, storyId,defectName, e.getMessage());
//
//		}
//	}
}
