package test.etouch.fox.watch;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.VideoCreatorPage;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

@IExcelDataFiles(excelDataFiles = {
		"file1=src/test/resources/testdata/watch/crowd-goes-wild.xls",
		"file2=src/test/resources/testdata/global/header.xls",
		"file2=src/test/resources/testdata/global/footer.xls" })
public class TestVideoCreator extends BaseTest {

	private String videoCreatorPageUrl;
	private VideoCreatorPage videoCreatorPage;
	private static Log log = LogUtil.getLog(TestVideoCreator.class);
	private WebPage webPage = null;

	@BeforeClass
	public void prepareBeforeClass() throws Exception {
		loadUrl();
		webPage = new WebPage();
		videoCreatorPage = new VideoCreatorPage(videoCreatorPageUrl, webPage);
		webPage.certificateErrorClick();
	}

	private void loadUrl() {
		videoCreatorPageUrl = constructURL(SuiteListener.pageURLs.getProperty("VIDEO_CREATOR"));
	}

//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 1)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIDEO_CREATOR")
//	public void testAVideoCreatorURL(String testcaseId, String projId,
//			String storyId, String defectName) {
//		try {
//			Assert.assertEquals(videoCreatorPageUrl, ((WebDriver)TestBedManager.getTestBed().getDriver()).getCurrentUrl(), "URL is not matched");
//		} catch (AssertionError e) {
//			videoCreatorPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Login_VideoCreator")
//	public void testLogin(String username, String password, String testcaseId,
//			String projId, String storyId, String defectName) throws PageException {
//		try {
//			boolean value = videoCreatorPage.enterCredentials(username,
//					password);
//			Assert.assertTrue(value);
//		} catch (AssertionError e) {
//			videoCreatorPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 3)
//	// dependsOnMethods="testLogin")
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "NavigateURL_VideoCreator")
//	public void testCreateVideo(String navigateUrl, String testcaseId,
//			String projId, String storyId, String defectName) throws PageException {
//		try {
//			String actualURL = videoCreatorPage
//					.navigateVideoCreator(navigateUrl);
//
//			Assert.assertEquals(navigateUrl, actualURL, "URL is not matched.");
//		} catch (AssertionError e) {
//			videoCreatorPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//
//	}
//
//	/**
//	 * testSelectPrimaryCategory to select the primary category
//	 * 
//	 * @throws InterruptedException
//	 * @throws PageException
//	 * */
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 4)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "SELECT_PRIM_CATAGORY")
//	public void testSelectPrimaryCategory(String testcaseId, String projId,
//			String storyId, String defectName) throws InterruptedException, PageException {
//		try {
//			boolean value = videoCreatorPage.selectPrimaryCategory();
//			Assert.assertTrue(value);
//		} catch (AssertionError e) {
//			videoCreatorPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}
//
//	/**
//	 * @throws InterruptedException
//	 * @throws PageException
//	 * 
//	 * */
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 5)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "HIDE_COMMENTS")
//	public void testClickHideCommentsCheckBox(String testcaseId, String projId,
//			String storyId, String defectName) throws InterruptedException, PageException {
//		try {
//			boolean value = videoCreatorPage.clickHideCommentsCheckBox();
//			Assert.assertTrue(value);
//		} catch (AssertionError e) {
//			videoCreatorPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}

}
