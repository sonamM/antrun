package test.etouch.fox.watch;

import java.util.List;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.GlobalNavPage;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Link;

@IExcelDataFiles(excelDataFiles = {
		"file1=src/test/resources/testdata/watch/crowd-goes-wild.xls",
		"file2=src/test/resources/testdata/global/header.xls",
		"file2=src/test/resources/testdata/global/footer.xls" })
public class TestGlobalNav extends BaseTest {

	private String globalNavPageUrl;
	private GlobalNavPage globalNavPage;
	private static Log log = LogUtil.getLog(TestGlobalNav.class);
	private WebPage webPage;

	@BeforeClass
	public void prepareBeforeClass() throws Exception {
		loadUrl();
		webPage = new WebPage();
		globalNavPage = new GlobalNavPage(globalNavPageUrl, webPage);
	}

	private void loadUrl() {
		globalNavPageUrl = constructURL(SuiteListener.pageURLs.getProperty("CROWD_GOES_WILD_PAGE"));
	}

//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 1)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Watch_Mouse_Over")
//	public void testHoverAWatch(String xpath1, String expectedText,
//			String testcaseId, String projId, String storyId, String defectName)
//			throws InterruptedException, PageException {
//		try {
//			Link link = globalNavPage.mouserHovertest(xpath1, ((WebDriver)TestBedManager.getTestBed().getDriver()), expectedText);
//			Assert.assertEquals(expectedText, link.getText(),
//					" Text is matched.");
//		} catch (AssertionError e) {
//			globalNavPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 2)
//	// dependsOnMethods="testHoverAWatch")
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Full_Schedule_URL")
//	public void testEnterCodeAndFullScheduleClick(String expectedURL,
//			String codevalue, String testcaseId, String projId, String storyId, String defectName)
//			throws InterruptedException {
//		try {
//			String actualURL = globalNavPage.enterCodeAndFullScheduleClick(
//					((WebDriver)TestBedManager.getTestBed().getDriver()), codevalue);
//			Assert.assertEquals(expectedURL, actualURL, "URL is matched.");
//		} catch (AssertionError e) {
//			globalNavPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName, 
//					e.getMessage());
//		}
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 3)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "HOVER_OFF_CHECK")
//	public void testLHoverOffFantasy(String testcaseId, String projId,
//			String storyId, String defectName) throws InterruptedException {
//		try {
//			boolean value = globalNavPage.mouserHoverOfftest(((WebDriver)TestBedManager.getTestBed().getDriver()));
//			Assert.assertTrue(value);
//		} catch (AssertionError e) {
//			globalNavPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 4)
//	// dependsOnMethods="testHoverAWatch")
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Fantasy_Mouse_Over")
//	public void testHoverFantasy(String xpath1, String expectedText,
//			String testcaseId, String projId, String storyId, String defectName)
//			throws InterruptedException {
//		try {
//			Link link = globalNavPage.mouserHovertest(xpath1,
//					((WebDriver)TestBedManager.getTestBed().getDriver()), expectedText);
//			Assert.assertEquals(expectedText, link.getText(),
//					" Text is matched.");
//		} catch (AssertionError e) {
//			globalNavPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 5)
//	// dependsOnMethods="testHoverFantasy")
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Link_GetAttribute")
//	public void testElementAttributeValue(String xpath1, String url,
//			String testcaseId, String projId, String storyId, String defectName)
//			throws InterruptedException {
//		try {
//			Link link = globalNavPage.elementAttributeValue(xpath1,
//					((WebDriver)TestBedManager.getTestBed().getDriver()), url);
//			Assert.assertEquals(url, link.getAttribute("href"),
//					"URL is matched.");
//		} catch (AssertionError e) {
//			globalNavPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 6)
//	// dependsOnMethods="testHoverFantasy")
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Validate_Image_Source")
//	public void testCheckImageSource(String xpathToImage, String expected,
//			String testcaseId, String projId, String storyId, String defectName) {
//		try {
//			List<String> src = globalNavPage.validateImage(xpathToImage);
//			Assert.assertEquals(expected, src.get(0));
//		} catch (AssertionError e) {
//			globalNavPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, priority = 7)
//	// dependsOnMethods="testHoverFantasy")
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Hoops_Dynasty_URL")
//	public void testElementClick(String expectedURL, String xpath,
//			String testcaseId, String projId, String storyId, String defectName)
//			throws InterruptedException {
//		try {
//			String actualURL = globalNavPage.clickSubLink(
//					((WebDriver)TestBedManager.getTestBed().getDriver()), xpath, expectedURL);
//			Assert.assertEquals(expectedURL, actualURL, "URL is matched.");
//		} catch (AssertionError e) {
//			globalNavPage.logAndCreateADefect(testBedManager.getDefect(),
//					defect_properties_file, testcaseId, projId, storyId, defectName,
//					e.getMessage());
//		}
//	}

}