package com.etouch.fox.email;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.watch.pages.BuzzerPage;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.infra.mail.EmailValidator;
import com.etouch.taf.infra.mail.IEmailValidator;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

@IExcelDataFiles(excelDataFiles = {
"file1=src/test/resources/testdata/watch/crowd-goes-wild.xls"})
public class TestFoxSportRegistrationEmails extends BaseTest {

	static Log log = LogUtil.getLog(TestFoxSportRegistrationEmails.class);
	Properties props = null;
	IEmailValidator emailValidator;

	private BuzzerPage buzzerPage;
	private static int index;


	@BeforeClass(alwaysRun = true)
	@Parameters(value = {"mailConfigPropFileName"})
	private void loadMailProperties(String mailConfigPropFileName) throws Exception
	{

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

	/*
	 * Test case to check the registration mail is received and the mail body contains the
	 * registration link.
	 */

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "EMAIL_DATA", dataKey = "EMAIL_PATTERN_TEXT")
	public void testEmailResitrationLinkisPresent(String checkUrlPattern, String emailSubjectText, String testcaseId, String projId, String storyId, String defectName){
		emailValidator = new EmailValidator();

		//Added the lookup test from the test data to Properties
		props.put("mailLookupString", checkUrlPattern);
		props.put("matchSubJectLike", emailSubjectText);

		try {
			Assert.assertTrue(emailValidator.validateEmail(props), "Validation Failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			buzzerPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/*
	 * Test case to invoke the registration link from the mail body.Then checks for the text data on
	 * on the new web page
	 */

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "EMAIL_DATA", dataKey = "EMAIL_PATTERN_REGISTRATION_TEXT")
	public void testEmailResitrationPage(String checkUrlPattern, String emailSubjectText, String testcaseId, String projId, String storyId, String defectName, String textData){
		emailValidator = new EmailValidator();


		//Added the lookup Text from the excel data sheet into to Properties
		props.put("mailLookupString", checkUrlPattern);
		props.put("matchSubJectLike", emailSubjectText);

		try {
			List<String> emailBodyContents = emailValidator.retriveEmailBodyContentFromMessages(props);

			List<String> checkUrls = new EmailTestHelper().retriveUrlsFromEmailBody(emailBodyContents, props);

			for(String url : checkUrls)
			{
				index = 0;
				WebPage webPage = new WebPage();
				buzzerPage = new BuzzerPage(url, webPage);
				buzzerPage.waitForPageload();

				try {
					List<String> text_data = buzzerPage.getBuzzerPopupText();
					if(text_data.size() > 0)
					{
						String[] array = text_data.toArray(new String[text_data.size()]);
						Assert.assertEquals(array[index++], textData, "TEXT NOT MATCHED");
					}

				}catch(AssertionError e){
					buzzerPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
	}

	/*
	 * Test case to check if password reset mail is received and the mail body contains the
	 * password reset link.
	 */

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "EMAIL_DATA", dataKey = "RESET_PSWD_EMAIL_PATTERN")
	public void testPasswordResetEmailLinkPresent(String checkUrlPattern, String emailSubjectText, String testcaseId, String projId, String storyId, String defectName){
		emailValidator = new EmailValidator();

		//Added the lookup test from the test data to Properties
		props.put("mailLookupString", checkUrlPattern);
		props.put("matchSubJectLike", emailSubjectText);

		try {
			Assert.assertTrue(emailValidator.validateEmail(props), "Validation Failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			buzzerPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
}
