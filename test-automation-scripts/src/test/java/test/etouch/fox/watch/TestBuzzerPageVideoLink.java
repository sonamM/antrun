package test.etouch.fox.watch;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.BuzzerPageVideoLink;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

import org.apache.commons.logging.Log;

/**
 * Test Class for testing BuzzerPage. testing
 * 
 * @author eTouch Systems Corporation
 * 
 */

@IExcelDataFiles(excelDataFiles = {
		"file1=src/test/resources/testdata/watch/crowd-goes-wild.xls",
		"file2=src/test/resources/testdata/global/header.xls",
		"file2=src/test/resources/testdata/global/footer.xls" })

public class TestBuzzerPageVideoLink extends BaseTest {

	private String buzzerPageUrl;
	private BuzzerPageVideoLink buzzerPageVideoLink;
	private static Log log = LogUtil.getLog(TestBuzzerPageVideoLink.class);

	@BeforeClass
	public void prepareBeforeClass() throws Exception {
		loadUrl();

		WebPage webPage = new WebPage();

		buzzerPageVideoLink = new BuzzerPageVideoLink(buzzerPageUrl, webPage);
	}

	private void loadUrl() {

		buzzerPageUrl = constructURL(SuiteListener.pageURLs
				.getProperty("CROWD_GOES_WILD_PAGE"));

	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "ResponsiveHeaderURL")
	public void verifyResponceHeader(String responsiveURL, String testcaseId,
			String projId, String storyId, String defectName) throws PageException// throws
			// InterruptedException{
			, InterruptedException {
		try {
			String cURL = buzzerPageVideoLink.verifyCrowdLogo(responsiveURL);

			System.out.println("current URL is:" + cURL);
			System.out.println("expected URL is:" + responsiveURL);
			Assert.assertEquals(cURL, responsiveURL,
					"error in getting crowd goes wild url not matched");
		} catch (AssertionError e) {
			buzzerPageVideoLink.logAndCreateADefect(testBedManager.getDefect(),
					defect_properties_file, testcaseId, projId, storyId, defectName,
					null, null, null, e.getMessage());
		}

	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VIDEO_CHECK")
	public void checkVideoLoads(String ExpectedvideoUrl, String testcaseId,
			String projId, String storyId, String defectName) throws PageException,
			InterruptedException {
		try {
			String ActualvideoUrl = buzzerPageVideoLink
					.getVideoLink(ExpectedvideoUrl);
			buzzerPageVideoLink.waitForPageLoad();
			Assert.assertEquals(ActualvideoUrl, ExpectedvideoUrl,
					"ERROR IN OPENING VIDEO URL");
			buzzerPageVideoLink.goBackToLink();
		} catch (AssertionError e) {
			buzzerPageVideoLink.logAndCreateADefect(testBedManager.getDefect(),
					defect_properties_file, testcaseId, projId, storyId, defectName,
					null, null, null, e.getMessage());
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_LINK_APPEND")
	public void verifyLinkAppend(String testcaseId, String projId,
			String storyId, String defectName) throws PageException {
		try {
			boolean pageURL = buzzerPageVideoLink.stringAppend();

			Assert.assertEquals(pageURL, true, "URL not Appended");
		} catch (AssertionError e) {
			buzzerPageVideoLink.logAndCreateADefect(testBedManager.getDefect(),
					defect_properties_file, testcaseId, projId, storyId, defectName,
					null, null, null, e.getMessage());
		}

	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "VIDEO_CHECK")
	public void checkViewMoreVideoLoads(String videoUrl, String testcaseId,
			String projId, String storyId, String defectName) throws PageException,
			InterruptedException {
		try {
			String video_url = buzzerPageVideoLink
					.getViewMoreVideoLink(videoUrl);
			buzzerPageVideoLink.waitForPageLoad();
			buzzerPageVideoLink.goBackToLink();
			Assert.assertEquals(video_url, videoUrl,
					"ERROR IN OPENING VIDEO URL");
		} catch (AssertionError e) {
			buzzerPageVideoLink.logAndCreateADefect(testBedManager.getDefect(),
					defect_properties_file, testcaseId, projId, storyId, defectName,
					null, null, null, e.getMessage());
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_BROKEN_LINK")
	public void testBrokenLinksOnPage(String testcaseId, String projId,
			String storyId, String defectName) throws PageException {
		try {
			boolean bLink = buzzerPageVideoLink.brokenLink();
			Assert.assertFalse(bLink,
					"error in getting crowd goes wild url not matched");
		} catch (AssertionError e) {
			buzzerPageVideoLink.logAndCreateADefect(testBedManager.getDefect(),
					defect_properties_file, testcaseId, projId, storyId, defectName,
					null, null, null, e.getMessage());
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "LINKTEXT")
	public void validateViewMoreText(String linkText, String testcaseId,
			String projId, String storyId, String defectName) throws PageException,
			InterruptedException
{
		try {
			String aLinkTxt = buzzerPageVideoLink.getViewMoreLinkText(linkText);
			Assert.assertEquals(aLinkTxt, linkText,
					"error in getting view more linktext");
		} catch (AssertionError e) {
			buzzerPageVideoLink.logAndCreateADefect(testBedManager.getDefect(),
					defect_properties_file, testcaseId, projId, storyId, defectName,
					null, null, null, e.getMessage());
		}
	}
}