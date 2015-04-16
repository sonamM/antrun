package test.etouch.fox.watch;

import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.CrowdGoesWildPage;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Link;

/**
 * Test Class for testing CrowdGoesWild page.
 *
 * @author eTouch Systems Corporation
 *
 */
@IExcelDataFiles(excelDataFiles = { "file1=src/test/resources/testdata/watch/crowd-goes-wild.xls", "file2=src/test/resources/testdata/global/header.xls",
        "file2=src/test/resources/testdata/global/footer.xls" })
public class TestCrowdGoesWild extends BaseTest {
	private static Log	      log	= LogUtil.getLog(TestCrowdGoesWild.class);
	private String	          crowdGoesWildPageUrl;
	private CrowdGoesWildPage	crowdGoesWildPage;

	/**
	 * @throws Exception
	 */
	@BeforeClass(alwaysRun = true)
	public void prepareBeforeClass() throws Exception {
		loadUrl();
		WebPage webPage = new WebPage();
		crowdGoesWildPage = new CrowdGoesWildPage(crowdGoesWildPageUrl, webPage);
	}

	private void loadUrl() {
		crowdGoesWildPageUrl = constructURL(SuiteListener.pageURLs.getProperty("CROWD_GOES_WILD_PAGE"));
	}

	// --------------------------------------------- Three column layout
	/**
	 * @param width
	 * @param height
	 * @param ecpected_no_of_columns
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" })
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "THREE_COLMUN_LAYOUT")
	public void testThreeColumanLayout(String width, String height, String ecpected_no_of_columns, String testcaseId, String projId, String storyId, String defectName) {
		try {
			crowdGoesWildPage.columnLayout(Integer.valueOf(width), Integer.valueOf(height));
			int ecpected_no_of_columns_int = Integer.valueOf(ecpected_no_of_columns);
			int actual_no_of_columns = crowdGoesWildPage.countNumberOfColumns(ecpected_no_of_columns);
			Assert.assertEquals(actual_no_of_columns, ecpected_no_of_columns_int, "NUMBER OF COLUMNS NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumanLayout \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * TC 15 for Buzzer header component load
	 *
	 * @param expected_src
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" })
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_HEADER")
	public void testThreeColumn_BuzzerHeader_TC15_A(String expected_src, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual_src = crowdGoesWildPage.checkBuzzerHeaderLoad(expected_src);
			Assert.assertEquals(actual_src, expected_src, "SOURCE NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumn_BuzzerHeader \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * for Buzzer component load
	 *
	 * @param expected_text
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" })
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_COMPONENT")
	public void testThreeColumn_BuzzerComponent_TC15_B(String expected_text, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual_text = crowdGoesWildPage.checkBuzzerComponentLoad(expected_text);
			Assert.assertEquals(actual_text, expected_text, "TEXT NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumn_BuzzerComponent \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * Initial load of 3 large headlines and 7 small headlines
	 *
	 *
	 * @param xpath
	 * @param expected_headlines
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" })
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_HEADLINES_10")
	public void testThreeColumn_LoadHeadlines_TC15_C(String xpath, String expected_headlines, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual_headlines = crowdGoesWildPage.checkBuzzerHeadlinesLoadWithSize(xpath, expected_headlines);
			Assert.assertEquals(actual_headlines, expected_headlines, "HEADLINES NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumn_LoadHeadlines \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * TC16
	 *
	 * @param textData
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" })
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_TEXT")
	public void testHeaderText_TC16_A(String textData, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String text_data = crowdGoesWildPage.getHeaderText(textData);
			Assert.assertEquals(text_data, textData);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHeaderText \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param textDataColor
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" })
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_TEXT_COLOR")
	public void testHeaderHoverText_TC16_B(String textDataColor, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.getHeaderHoverText(textDataColor);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHeaderHoverText \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expectedDateString
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_DATE_TEXT")
	public void testCheckDateText_TC16_C(String expectedDateString, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualString = crowdGoesWildPage.getDateStringFromHomePage(expectedDateString);
			Assert.assertEquals(actualString, expectedDateString);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testCheckDateText \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param regExpression
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_DATE_FORMAT")
	public void testFormatOfDateText_TC16_D(String regExpression, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.getDateFormatString(regExpression);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testFormatOfDateText \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expectedString
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_BYLINE")
	public void testBylineAndSorce_TC16_E(String expectedString, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualString = crowdGoesWildPage.getSorceAndBylineString(expectedString);
			Assert.assertEquals(actualString, expectedString);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testBylineAndSorce \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expectedDescription
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_DESC_TEXT")
	public void testDescriptionText_TC16_F(String expectedDescription, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualString = crowdGoesWildPage.getDescriptionText(expectedDescription);
			Assert.assertEquals(actualString, expectedDescription);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testDescriptionText \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expectedImageName
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_MORE_ICON")
	public void testMoreIconLoads_TC16_G(String expectedImageName, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.getMoreIcon(expectedImageName);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testMoreIconLoads \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIEW_MORE")
	public void testViewMoreLinkLoads_TC16_H(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.getViewMoreLinkText(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testViewMoreLinkLoads \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIEW_MORE_DECOR")
	public void testTextDecorationOnViewMore_TC16_I(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.testDecorationOnViewMore(expected);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTextDecorationOnViewMore \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// 27,28
	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIEW_MORE_CLICK")
	public void testNewHeadlineCheck_TC16_J(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getViewMoreClickedLink(ExpectedvideoUrl);
			Assert.assertEquals(actualUrl, ExpectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testNewHeadlineCheck \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	// add code for 28
	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIEW_MORE_CLICK")
	public void testnewHeadlineInSameWindow_TC16_K(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		boolean flag = false;
		try {
			boolean actual = crowdGoesWildPage.getWindowSizeOnClick(ExpectedvideoUrl);
			Assert.assertTrue(actual);
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testnewHeadlineInSameWindow \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_TAG")
	public void testTagLoads_TC16_L(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.getTagText(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTagLoads \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_TAG_COLOR")
	public void testHighlightOnTag_TC16_M(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.testHighlightColorForTag(expected);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHighlightOnTag \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_TAG_LINK_CLICK")
	public void testTagLinkFunctional_TC16_N(String expected, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getTagClickedLink(expected);
			Assert.assertEquals(actualUrl, expected, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTagLinkFunctional \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_TEXT_CLICK")
	public void testHeaderTextLinkFunctional_TC16_O(String expected, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getHeaderLinkClickedLink(expected);
			log.info("ENDed TC ##  testHeaderTextLinkFunctional .>.>.>.>.>.>.>.>.>.>.>.>.>");
			Assert.assertEquals(actualUrl, expected, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHeaderTextLinkFunctional \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_TEXT_CLICK")
	public void testHeaderClickInSameWindow_TC16_P(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		boolean flag = false;
		try {
			boolean actual = crowdGoesWildPage.getWindowSizeOnClickOFHeader(ExpectedvideoUrl);
			Assert.assertTrue(actual);
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHeaderClickInSameWindow \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// -----------------------------------------------------------------END
	// TC16-----------------------------------------------------------------------------
	// -------------------------------------------------------------------START
	// TC17-----------------------------------------------------------------------
	/**
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHRONOLOGICAL_ORDER")
	public void testChronologicalOrder_TC17_A(String testcaseId, String projId, String storyId, String defectName) {
		try {
			Assert.assertTrue(crowdGoesWildPage.isPubDatesInOrder(false), crowdGoesWildPage.getErrMessage());
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testChronologicalOrder \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_FOUR_LINK")
	public void testStoryHeadlineCheckForThreeColumn_TC17_B(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		try {
			actualUrl = crowdGoesWildPage.getFourthLink(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()));
			Assert.assertEquals(actualUrl, ExpectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testStoryHeadlineCheckForThreeColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Show_More_Text")
	public void testShowMoreLinkLoadsForThreeColumn_TC17_C(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.validateShowMoreForThreeColumn(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkLoadsForThreeColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param headerCount
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "HEADLINE_COUNT")
	public void testShowMoreLinkClickedForThreeColumn_TC17_D(String headerCount, String testcaseId, String projId, String storyId, String defectName) {
		try {
			int HeaderCount = Integer.parseInt(headerCount);
			int countBeforeClick = crowdGoesWildPage.countHeadlines();
			crowdGoesWildPage.clickOnShowMoreButton(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()),1 );
			int countAfterClick = crowdGoesWildPage.countHeadlines();
			int countOfHeaders = crowdGoesWildPage.getNewlyAddedHeadlines(countAfterClick, countBeforeClick);
			Assert.assertEquals(countOfHeaders, HeaderCount);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkClickedForThreeColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	
	/**
	 * @param isShowMore
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "SHOW_MORE_EXIST")
	public void testShowMoreLinkExistForThreeColumn_TC17_E(String isShowMore, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.clickingShowMore();
			Assert.assertFalse(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkExistForTwoColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// ----------------------------------------------------------END
	// TC17--------------------------------------------------------------------------------------
	// --------------------------------------------- Three column layout
	// ----------------------------------------------------------Start of Test
	//----------------------------------------------------------Start of Test Case 22------------
	/**
	 * @param headerCount
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SECONDARY_NAV_ELEMENT")
	public void testSecondaryNavElements_TC22(String XpathOfExpected,String expectedLinkText, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualText=crowdGoesWildPage.validateSecondayNavElelments(XpathOfExpected,expectedLinkText);
			Assert.assertEquals(actualText, expectedLinkText);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	//----------------------------------------------------------End of Test Case 22------------


//----------------------------------------------------------Start of Test Case 23------------
/**
 *
 * @param textDataColor
 * @param projId
 * @param storyId
 * @param defectName
 */
@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SECONDARY_NAV_VIDEO_COLOR")
public void testColorForVideoLinkHover_TC23_A(String textDataColor, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
{
	try {
		boolean actual = crowdGoesWildPage.getVideoHoverText(textDataColor);
		Assert.assertTrue(actual);
	} catch (AssertionError e) {
		crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
	}
}

/**
 *
 * @param textDataColor
 * @param projId
 * @param storyId
 * @param defectName
 */
@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SECONDARY_NAV_VIDEO_TITLE")
public void testTitleTextForVideoLinkHover_TC23_B(String expectedText, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
{
	try {
		String actualText = crowdGoesWildPage.getVideoHoverTitleText(expectedText);
		Assert.assertEquals(actualText, expectedText);
	} catch (AssertionError e) {
		crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
	}
}

/**
 * @param ExpectedvideoUrl
 * @param testcaseId
 * @param projId
 * @param storyId
 * @param defectName
 */
@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIDEO_LINK_FUNCTIONAL")
public void testVideoLinkedClicked_TC23_C(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName){
	String actualUrl = null;
	try {
		actualUrl = crowdGoesWildPage.getVideoSecondaryNavClicked(ExpectedvideoUrl);
		Assert.assertEquals(actualUrl, ExpectedvideoUrl, "ERROR IN OPENING URL");
		crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
	} catch (AssertionError e) {
		crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
	}
}

//----------------------------------------------------------End of Test Case 23------------
//----------------------------------------------------------Start of Test Case 24------------
/**
 *
 * @param true if menu expands expands
 * @param projId
 * @param storyId
 * @param defectName
 */
@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CAST_EXPANDS")
public void testToCheckIfMenuExpands_TC24_A(String textData, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
{
	try {
		boolean actual = crowdGoesWildPage.checkifMenuExpands(textData);
		Assert.assertTrue(actual);
	} catch (AssertionError e) {
		crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
	}
}


/**
 *
 * @param true if Border color is #009245
 * @param projId
 * @param storyId
 * @param defectName
 */
@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CAST_BORDER_COLOR")
public void testToCheckBorderColor_TC24_B(String expected, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
{
	try {
		boolean actual = crowdGoesWildPage.getBorderColor(expected);
		Assert.assertTrue(actual);
	} catch (AssertionError e) {
		crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
	}
}

/**
 *
 * @param true if text color is #009245
 * @param projId
 * @param storyId
 * @param defectName
 */
@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CAST_TEXT_COLOR")
public void testToHighlightTextColor_TC24_C(String expected, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
{
	try {
		boolean actual = crowdGoesWildPage.getSubLinkTextColor(expected);
		Assert.assertTrue(actual);
	} catch (AssertionError e) {
		crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
	}
}


/**
 * @param ExpectedvideoUrl
 * @param testcaseId
 * @param projId
 * @param storyId
 * @param defectName
 */
@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CAST_TEXT_FUNCTIONAL")
public void testSecondaryNavSUBLinkClicked_TC24_D(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName){
	String actualUrl = null;
	try {
		actualUrl = crowdGoesWildPage.getCastSecondaryNavClicked(ExpectedvideoUrl);
		Assert.assertEquals(actualUrl, ExpectedvideoUrl, "ERROR IN OPENING URL");
		crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
	} catch (AssertionError e) {
		crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
	}
}
//----------------------------------------------------------End of Test Case 24------------
// ---------------------------------------------------------TC 33
	// -----------------------
	/**
	 *
	 * @param expectedImageSrc
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_THREE_HEADER_IMAGE")
	public void testThreeColumnHeaderImage_TC33_A(String expectedImageSrc, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.validate_three_HeaderImage(expectedImageSrc);
			log.info("Expected Image is ::\n" + expectedImageSrc + " and actual is \n" + actual);
			Assert.assertTrue(actual.contains(expectedImageSrc), "testThreeColumnHeaderImage Failed");
		} catch (AssertionError e) {
			log.info("testThreeColumnHeaderImage assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumnHeaderImage \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedImageLink
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_THREE_HEADER_IMAGE_LINK")
	public void testThreeColumnHeaderImageLink_TC33_B(String expectedImageLink, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualLink = crowdGoesWildPage.validate_three_HeaderImageLink(expectedImageLink);
			log.info("Expected Image Link is ::\n" + expectedImageLink + " and actual is \n" + actualLink);
			Assert.assertEquals(actualLink, expectedImageLink, "testThreeColumnHeaderImageLink Failed");
		} catch (AssertionError e) {
			log.info("testThreeColumnHeaderImageLink assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumnHeaderImageLink \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// -------------------------------------------------------start
	// TC-36-----------------------------------------------------------------------------
	/**
	 *
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "MSN_Header_Loads")
	public void testHaederLoad_TC36_A(String testcaseId, String projId, String storyId, String defectName) {
		try {
			Object headerObject = crowdGoesWildPage.headerLoad();
			Assert.assertNotNull(headerObject, "MSN Header Not Loaded");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHaederLoad \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedURL
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "MSN_Logo_Link")
	public void testMsnLogoLink_TC36_B(String expectedURL, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String msnLogoLink = crowdGoesWildPage.msnLogoLoad(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedURL);
			Assert.assertEquals(msnLogoLink, expectedURL, "URL is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testMsnLogoLink \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------start
	// TC-37-----------------------------------------------------------------------------

	/**
	 *
	 * @param xpath1
	 * @param expectedText
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Mouse_Over_More")
	public void testHoverMore_TC37_A(String xpath1, String expectedText, String testcaseId, String projId, String storyId, String defectName) {
		try {
			Link link = crowdGoesWildPage.mouserHovertest(xpath1, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedText);
			Assert.assertEquals(link.getText(), expectedText, " Text is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHoverMore \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param xpath
	 * @param expectedURL
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_Sub_Link_More")
	public void testElementClickMore_TC37_B_C(String xpath, String expectedURL, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualURL = crowdGoesWildPage.clickSubLink(xpath, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedURL);
			Assert.assertEquals(actualURL, expectedURL, "URL is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testElementClickMore \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------start
	// TC-38-----------------------------------------------------------------------------

	/**
	 *
	 * @param xpath1
	 * @param expectedText
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Mouse_Over_Outlook")
	public void testHoverOutlook_TC38_A(String xpath1, String expectedText, String testcaseId, String projId, String storyId, String defectName) {
		try {
			Link link = crowdGoesWildPage.mouserHovertest(xpath1, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedText);
			Assert.assertEquals(link.getText(), expectedText, " Text is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHoverOutlook \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param xpath
	 * @param expectedURL
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_Sub_Link_Outlook")
	public void testElementClickOutlook_TC38_B_C(String xpath, String expectedURL, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualURL = crowdGoesWildPage.clickSubLink(xpath, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedURL);
			Assert.assertEquals(actualURL, expectedURL, "URL is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testElementClickOutlook \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------start
	// TC-39-----------------------------------------------------------------------------

	/**
	 *
	 * @param xpath1
	 * @param expectedText
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Mouse_Over_Mobile")
	public void testHoverMobile_TC39_A(String xpath1, String expectedText, String testcaseId, String projId, String storyId, String defectName) {
		try {
			Link link = crowdGoesWildPage.mouserHovertest(xpath1, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedText);
			Assert.assertEquals(link.getText(), expectedText, " Text is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHoverMobile \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param xpath
	 * @param expectedURL
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_Link_Mobile")
	public void testElementClickMobile_TC39_B_C(String xpath, String expectedURL, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualURL = crowdGoesWildPage.clickSubLink(xpath, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedURL);
			Assert.assertEquals(actualURL, expectedURL, "URL is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testElementClickMobile \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------start
	// TC-40-----------------------------------------------------------------------------

	/**
	 *
	 * @param xpath1
	 * @param expectedText
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Mouse_Over_Bing")
	public void testHoverBing_TC40_A(String xpath1, String expectedText, String testcaseId, String projId, String storyId, String defectName) {
		try {
			Link link = crowdGoesWildPage.mouserHovertest(xpath1, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedText);
			Assert.assertEquals(link.getText(), expectedText, " Text is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHoverBing \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param xpath
	 * @param expectedURL
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_Link_Bing")
	public void testElementClickBing_TC40_B_C(String xpath, String expectedURL, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualURL = crowdGoesWildPage.clickSubLink(xpath, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedURL);
			Assert.assertEquals(actualURL, expectedURL, "URL is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testElementClickBing \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------start
	// TC-41-----------------------------------------------------------------------------

	/**
	 *
	 * @param xpath1
	 * @param expectedText
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Mouse_Over_Rewards")
	public void testHoverRewards_TC41_A(String xpath1, String expectedText, String testcaseId, String projId, String storyId, String defectName) {
		try {
			Link link = crowdGoesWildPage.mouserHovertest(xpath1, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedText);
			Assert.assertEquals(link.getText(), expectedText, " Text is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHoverRewards \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param xpath
	 * @param expectedURL
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_Link_Rewards")
	public void testElementClickRewards_TC41_B_C(String xpath, String expectedURL, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualURL = crowdGoesWildPage.clickSubLink(xpath, ((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), expectedURL);
			Assert.assertEquals(actualURL, expectedURL, "URL is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testElementClickRewards \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------start
	// TC-42-----------------------------------------------------------------------------

	/**
	 *
	 * @param xpath
	 * @param text
	 * @param expectedURL
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Search_Enter_Text")
	public void testSearchFieldEnterText_TC42_A_B_C(String xpath, String text, String expectedURL, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualURL = crowdGoesWildPage.enterTextSearchField(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), text, xpath, expectedURL, crowdGoesWildPageUrl);
			Assert.assertEquals(actualURL, expectedURL, "URL is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testSearchFieldEnterText \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------start
	// TC-43-----------------------------------------------------------------------------

	/**
	 *
	 * @param expectedURL
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Click_Web_Button")
	public void testClickWebButton_TC43_A_B(String expectedURL, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualURL = crowdGoesWildPage.clickWebButton(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()));
			Assert.assertEquals(actualURL, expectedURL, "URL is not matched.");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testClickWebButton \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// -------------------------------------------------------END
	// TC36 TO TC-43-----------------------------------------------------------------------------
	
	// -------------------------------------------------------START
	// TC-44-----------------------------------------------------------------------------
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "MSN_Header_Hide")
    public void testMsnHeaderHide_TC44(String testcaseId, String projId, String storyId, String defectName)
    {
		try 
		{
			Boolean flag = crowdGoesWildPage.msnHeaderScroll(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()));
            Assert.assertTrue(flag, "Cannot be scrolled");

		} 
		catch (AssertionError e) 
		{
			log.info("\n\n\nAssertion ERROR in TC ##  testMsnHeaderHide \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
    }
	
	// -------------------------------------------------------END
	// TC-44-----------------------------------------------------------------------------
	// -------------------------------------------------------START
	// TC-45-----------------------------------------------------------------------------
	/**
	 *
	 * @param expectedHeaderPresence
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_THREE_TUNE_IN_HEADER")
	public void testThreeColumnTuneInHeader_TC45_A(String expectedHeaderPresence, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean headerVisibility = crowdGoesWildPage.validate_Three_TuneInHeader(Boolean.parseBoolean(expectedHeaderPresence));
			log.info("Expected header presence is ::\n" + expectedHeaderPresence + " and actually its \n" + headerVisibility);
			Assert.assertEquals(headerVisibility, Boolean.parseBoolean(expectedHeaderPresence));
		} catch (AssertionError e) {
			log.info("testThreeColumnHeaderImageLink assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumnTuneInHeader \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedFontStyle
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_THREE_TUNE_IN_HEADER_FONT_STYLE")
	public void testThreeColumnTuneInHeaderFontStyle_TC45_B(String expectedFontStyle, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String headerFontStyle = crowdGoesWildPage.validate_Three_TuneInHeaderFontStyle(expectedFontStyle);
			log.info("Expected header Font Style is ::\n" + expectedFontStyle + " and actually its \n" + headerFontStyle);
			Assert.assertEquals(headerFontStyle, expectedFontStyle);
		} catch (AssertionError e) {
			log.info("testThreeColumnTuneInHeaderFontStyle assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumnTuneInHeaderFontStyle \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedFontColor
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_THREE_TUNE_IN_HEADER_FONT_COLOR")
	public void testThreeColumnTuneInHeaderFontColor_TC45_C(String expectedFontColor, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String headerFontColor = crowdGoesWildPage.validate_Three_TuneInHeaderFontColor(expectedFontColor);
			log.info("Expected header Font color is ::\n" + expectedFontColor + " and actually its \n" + headerFontColor);
			Assert.assertEquals(headerFontColor, expectedFontColor);
		} catch (AssertionError e) {
			log.info("testThreeColumnTuneInHeaderFontColor assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumnTuneInHeaderFontColor \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedFontSize
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "browser" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_THREE_TUNE_IN_HEADER_FONT_SIZE")
	public void testThreeColumnTuneInHeaderFontSize_TC45_D(String expectedFontSize, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String headerFontSize = crowdGoesWildPage.validate_Three_TuneInHeaderFontSize(expectedFontSize);
			log.info("Expected header Font Size is ::\n" + expectedFontSize + " and actually its \n" + headerFontSize);
			Assert.assertEquals(headerFontSize, expectedFontSize);
		} catch (AssertionError e) {
			log.info("testThreeColumnTuneInHeaderFontSize assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testThreeColumnTuneInHeaderFontSize \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// -------------------------------------------------------END
	// TC-45-----------------------------------------------------------------------------
	// end----------------------------------------------------------------------------------------
	// ----------------------------------------------Two column layout
	// start---------------------------------------------------------------------------------
	/**
	 * @param width
	 * @param height
	 * @param ecpected_no_of_columns
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TWO_COLMUN_LAYOUT")
	public void testTwoColumnLayout(String width, String height, String ecpected_no_of_columns, String testcaseId, String projId, String storyId, String defectName) {
		log.info("************************************************************* Ipad *************************************************************");
		try {
			 crowdGoesWildPage.columnLayout(Integer.valueOf(width),Integer.valueOf(height));
			int ecpected_no_of_columns_int = Integer.valueOf(ecpected_no_of_columns);
			int actual_no_of_columns = crowdGoesWildPage.countNumberOfColumns(ecpected_no_of_columns);
			Assert.assertEquals(actual_no_of_columns, ecpected_no_of_columns_int, "NUMBER OF COLUMNS NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumnLayout \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// ----------------------------------------------------------------------START
	// TC18-----------------------------------------------------------------------
	// for Buzzer header component load
	/**
	 * @param expected_src
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_HEADER")
	public void testTwoColumn_BuzzerHeader_TC18_A(String expected_src, String testcaseId, String projId, String storyId, String defectName) {
		log.info("************************************************************* Ipad *************************************************************");
		try {
			String actual_src = crowdGoesWildPage.checkBuzzerHeaderLoad(expected_src);
			Assert.assertEquals(actual_src, expected_src, "SOURCE NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumn_BuzzerHeader \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// for Buzzer component load
	/**
	 * @param expected_text
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_COMPONENT")
	public void testTwoColumn_BuzzerComponent_TC18_B(String expected_text, String testcaseId, String projId, String storyId, String defectName) {
		log.info("************************************************************* Ipad *************************************************************");
		try {
			String actual_text = crowdGoesWildPage.checkBuzzerComponentLoad(expected_text);
			Assert.assertEquals(actual_text, expected_text, "TEXT NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumn_BuzzerComponent \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// for 5 headlines load
	/**
	 * @param xpath
	 * @param expected_headlines
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_HEADLINES_5")
	public void testTwoColumn_BuzzerLoadHeadlines_TC18_C(String xpath, String expected_headlines, String testcaseId, String projId, String storyId, String defectName) {
		log.info("************************************************************* Ipad *************************************************************");
		try {
			String actual_headlines = crowdGoesWildPage.checkBuzzerHeadlinesLoad(xpath, expected_headlines);
			Assert.assertEquals(actual_headlines, expected_headlines, "HEADLINES NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumn_BuzzerLoadHeadlines \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// for 5 images load
	/**
	 * @param xpath
	 * @param expected_src
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_IMAGES_TWOCOLUMN")
	public void testTwoColumn_BuzzerLoadImages_TC18_D(String xpath, String expected_src, String testcaseId, String projId, String storyId, String defectName) {
		log.info("************************************************************* Ipad *************************************************************");
		try {
			String actual_src = crowdGoesWildPage.checkBuzzerImagesLoad(xpath, expected_src);
			Assert.assertEquals(actual_src, expected_src, "SOURCE NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumn_BuzzerLoadImages \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// -------------------------------------------------------------------END
	// TC18-----------------------------------------------------------------------------
	// -------------------------------------------------------------------START
	// TC19----------------------------------------------------------------------------
	/**
	 * @param textData
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_TEXT")
	public void testHeaderTextLoadsForTwoColumn_TC19(String textData, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String text_data = crowdGoesWildPage.getHeaderTextFortwoColumn(textData);
			Assert.assertEquals(text_data, textData);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHeaderTextLoadsForTwoColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param textDataColor
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_TEXT_COLOR")
	public void testHeaderHoverTextForTwoColumns_TC19(String textDataColor, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.getHeaderHoverTextForTwoColumns(textDataColor);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHeaderHoverTextForTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expectedDateString
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_DATE_TEXT")
	public void testCheckDateTextForTwoColumns_TC19(String expectedDateString, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualString = crowdGoesWildPage.getDateStringForTwoColumn(expectedDateString);
			Assert.assertEquals(actualString, expectedDateString);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testCheckDateTextForTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIEW_MORE")
	public void testViewMoreLinkLoadsForTwoColumns_TC19(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.getViewMoreLinkTextForTwoColumns(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testViewMoreLinkLoadsForTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIEW_MORE_CLICK")
	public void testNewHeadlineCheckForTwoColumns_TC19(String expectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getViewMoreClickedLink(expectedvideoUrl);
			Assert.assertEquals(actualUrl, expectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testNewHeadlineCheckForTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	/**
	 * @param expectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIDEO_LINK")
	public void testVideoHeadlineCheckForTwoColumns_TC19(String expectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getVideoLinkForTwoColumns(expectedvideoUrl);
			Assert.assertEquals(actualUrl, expectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testVideoHeadlineCheckForTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	/**
	 * @param expectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_STORY_LINK")
	public void testStoryHeadlineCheckForTwoColumns_TC19(String expectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getStoryLinkForTwoColumns(expectedvideoUrl);
			Assert.assertEquals(actualUrl, expectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testStoryHeadlineCheckForTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_TAG")
	public void testTagLoadsTwoColumns_TC19(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.getTagText(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTagLoadsTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_TAG_COLOR")
	public void testHighlightOnTagTwoColumns_TC19(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.testHighlightColorForTag(expected);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHighlightOnTagTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_TAG_LINK_CLICK")
	public void testTagLinkFunctionalTwoColumns_TC19(String expected, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getTagClickedLink(expected);
			Assert.assertEquals(actualUrl, expected, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testTagLinkFunctionalTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Show_More_Text")
	public void testShowMoreLinkLoadsForTwoColumns_TC19(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.validateShowMoreForTwoColumns(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkLoadsForTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param headerCount
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "HEADLINE_COUNT")
	public void testShowMoreLinkClickedForTwoColumn_TC19(String headerCount, String testcaseId, String projId, String storyId, String defectName) {
		try {
			int HeaderCount = Integer.parseInt(headerCount);
			int countBeforeClick = crowdGoesWildPage.countHeadlines();
			crowdGoesWildPage.clickOnShowMoreButton(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), 1);
			int countAfterClick = crowdGoesWildPage.countHeadlines();
			int countOfHeaders = crowdGoesWildPage.getNewlyAddedHeadlines(countAfterClick, countBeforeClick);
			log.info("Number of header in the webpage are :" + countAfterClick);
			Assert.assertEquals(countOfHeaders, HeaderCount);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkClickedForTwoColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHRONOLOGICAL_ORDER")
	public void testChronologicalOrderTwoColumns_TC19(String testcaseId, String projId, String storyId, String defectName) {
		try {
			Assert.assertTrue(crowdGoesWildPage.isPubDatesInOrder(false), crowdGoesWildPage.getErrMessage());
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testChronologicalOrderTwoColumns \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param headerCount
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "HEADLINE_COUNT")
	public void testShowMoreLinkClickedAgainForTwoColumn_TC19(String headerCount, String testcaseId, String projId, String storyId, String defectName) {
		try {
			int HeaderCount = Integer.parseInt(headerCount);
			int countBeforeClick = crowdGoesWildPage.countHeadlines();
			crowdGoesWildPage.clickOnShowMoreButton(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), 2);
			int countAfterClick = crowdGoesWildPage.countHeadlines();
			int countOfHeaders = crowdGoesWildPage.getNewlyAddedHeadlines(countAfterClick, countBeforeClick);
			log.info("Number of header in the webpage are :" + countAfterClick);
			Assert.assertEquals(countOfHeaders, HeaderCount);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkClickedAgainForTwoColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param isShowMore
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "SHOW_MORE_EXIST")
	public void testShowMoreLinkExistForTwoColumn_TC19(String isShowMore, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.clickingShowMore();
			Assert.assertFalse(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkExistForTwoColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------------------END
	// TC19--------------------------------------------------------------------------
	
	// -------------------------------------------------------------------START
	// TC34--------------------------------------------------------------------------

	/**
	 *
	 * @param expectedImageSrc
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_TWO_HEADER_IMAGE")
	public void testTwoColumnHeaderImage_TC34_A(String expectedImageSrc, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.validate_Two_HeaderImage(expectedImageSrc);
			log.info("Expected Image is ::\n" + expectedImageSrc + " and actual is \n" + actual);
			Assert.assertTrue(actual.contains(expectedImageSrc), "testThreeColumnHeaderImage Failed");
		} catch (AssertionError e) {
			log.info("testTwoColumnHeaderImage assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumnHeaderImage \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedImageLink
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_TWO_HEADER_IMAGE_LINK")
	public void testTwoColumnHeaderImageLink_TC34_B(String expectedImageLink, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualLink = crowdGoesWildPage.validate_Two_HeaderImageLink(expectedImageLink);
			log.info("Expected Image Link is ::\n" + expectedImageLink + " and actual is \n" + actualLink);
			Assert.assertEquals(actualLink, expectedImageLink, "testThreeColumnHeaderImageLink Failed");
		} catch (AssertionError e) {
			log.info("testTwoColumnHeaderImageLink assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumnHeaderImageLink \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	// -------------------------------------------------------------------START
	// TC46--------------------------------------------------------------------------

	

	/**
	 *
	 * @param expectedHeaderPresence
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_TWO_TUNE_IN_HEADER")
	public void testTwoColumnTuneInHeader_TC46_A(String expectedHeaderPresence, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean headerVisibility = crowdGoesWildPage.validate_Two_TuneInHeader(Boolean.parseBoolean(expectedHeaderPresence));
			log.info("Expected header presence is ::\n" + expectedHeaderPresence + " and actually its \n" + headerVisibility);
			Assert.assertEquals(headerVisibility, Boolean.parseBoolean(expectedHeaderPresence));
		} catch (AssertionError e) {
			log.info("testTwoColumnTuneInHeader assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumnTuneInHeader \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedFontSize
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_TWO_TUNE_IN_HEADER_FONT_SIZE")
	public void testTwoColumnTuneInHeaderFontSize_TC46_B(String expectedFontSize, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String headerFontSize = crowdGoesWildPage.validate_Two_TuneInHeaderFontSize(expectedFontSize);
			log.info("Expected header Font Size is ::\n" + expectedFontSize + " and actually its \n" + headerFontSize);
			Assert.assertEquals(headerFontSize, expectedFontSize);
		} catch (AssertionError e) {
			log.info("testTwoColumnTuneInHeaderFontSize assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testTwoColumnTuneInHeaderFontSize \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	
	// ----------------------------------------------------------Start of Test
	// Case 25------------
	/**
	 * @param headerCount
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SECONDARY_NAV_ELEMENT")
	public void testTwoColumnSecondaryNavElements_TC25(String XpathOfExpected,String expectedLinkText, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			String actualText=crowdGoesWildPage.validateSecondayNavElelmentsForOneColumn(XpathOfExpected,expectedLinkText);
			Assert.assertEquals(actualText, expectedLinkText);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// ----------------------------------------------------------End of Test
	// Case 25------------
	// ----------------------------------------------------------Start of Test
	// Case 26------------
	/**
	 *
	 * @param textDataColor
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SECONDARY_NAV_VIDEO_COLOR_ON_CLICK")
	public void testColorForVideoLinkHoverForTwoColumns_TC26_A(String textDataColor, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			boolean actual = crowdGoesWildPage.getVideoClickedAndHoverText(textDataColor);
			Assert.assertTrue(actual);
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIDEO_LINK_FUNCTIONAL")
	public void testVideoLinkedClickedForTwoColumns_TC26_B(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		try {
			actualUrl = crowdGoesWildPage.getVideoSecondaryNavClicked(ExpectedvideoUrl);
			Assert.assertEquals(actualUrl, ExpectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
			throw e;
		}
	}

	// ----------------------------------------------------------End of Test
	// Case 26------------
	// ----------------------------------------------------------Start of Test
	// Case 27------------
	/**
	 *
	 * @param true if menu expands expands
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CAST_EXPANDS")
	public void testToCheckIfMenuExpandsForTwoColumns_TC27_A(String textData, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			boolean actual = crowdGoesWildPage.checkifMenuExpands(textData);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param true if text present
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SUB_LINK_PRESENT")
	public void testToCheckIfSubLinkPresent_TC27_B(String expected, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			String actual = crowdGoesWildPage.getSubLinkText(expected);
			Assert.assertEquals(actual, expected, "TEXT NOT MATCHED");
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "ipad" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CAST_TEXT_FUNCTIONAL")
	public void testSecondaryNavSUBLinkClickedForTwoColumns_TC27_C(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName){
		String actualUrl = null;
		try {
			actualUrl = crowdGoesWildPage.getCastSecondaryNavClicked(ExpectedvideoUrl);
			Assert.assertEquals(actualUrl, ExpectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
			throw e;
		}
	}

	// ----------------------------------------------------------End of Test
	// Case 27------------
	// ----------------------------------------------Two column layout
	// end---------------------------------------------------------------------------------
	// ----------------------------------------------One column layout
	// start---------------------------------------------------------------------------------
	// Comment out following test cases and run them on Mobile emulator
	/**
	 * @param width
	 * @param height
	 * @param ecpected_no_of_columns
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "ONE_COLMUN_LAYOUT")
	public void testOneColumnLayout(String width, String height, String ecpected_no_of_columns, String testcaseId, String projId, String storyId, String defectName) {
		log.info("############################################ mobile ##########################################");
		try {
			crowdGoesWildPage.columnLayout(Integer.valueOf(width),Integer.valueOf(height));
			int ecpected_no_of_columns_int = Integer.valueOf(ecpected_no_of_columns);
			int actual_no_of_columns = crowdGoesWildPage.countNumberOfColumns(ecpected_no_of_columns);
			Assert.assertEquals(actual_no_of_columns, ecpected_no_of_columns_int, "NUMBER OF COLUMNS NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumnLayout \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// ---------------------------------------------------------------START
	// TC20---------------------------------------------------------------------------------
	// for Buzzer header component load
	/**
	 * @param expected_src
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_HEADER")
	public void testOneColumn_BuzzerHeader_TC20_A(String expected_src, String testcaseId, String projId, String storyId, String defectName) {
		log.info("############################################ mobile ##########################################");
		try {
			String actual_src = crowdGoesWildPage.checkBuzzerHeaderLoad(expected_src);
			Assert.assertEquals(actual_src, expected_src, "SOURCE NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumn_BuzzerHeader \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// for Buzzer component load
	/**
	 * @param expected_text
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_COMPONENT")
	public void testOneColumn_BuzzerComponent_TC20_B(String expected_text, String testcaseId, String projId, String storyId, String defectName) {
		log.info("############################################ mobile ##########################################");
		try {
			String actual_text = crowdGoesWildPage.checkBuzzerComponentLoad(expected_text);
			Assert.assertEquals(actual_text, expected_text, "TEXT NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumn_BuzzerComponent \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// for 5 headlines load
	/**
	 * @param xpath
	 * @param expected_headlines
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_HEADLINES_5")
	public void testOneColumn_BuzzerLoadHeadlines_TC20_C(String xpath, String expected_headlines, String testcaseId, String projId, String storyId, String defectName) {
		log.info("############################################ mobile ##########################################");
		try {
			String actual_headlines = crowdGoesWildPage.checkBuzzerHeadlinesLoad(xpath, expected_headlines);
			Assert.assertEquals(actual_headlines, expected_headlines, "HEADLINES NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumn_BuzzerLoadHeadlines \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// for 5 images load
	/**
	 * @param xpath
	 * @param expected_src
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "TEST_BUZZER_IMAGES_ONECOLUMN")
	public void testOneColumn_BuzzerLoadImages_TC20_D(String xpath, String expected_src, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual_src = crowdGoesWildPage.checkBuzzerImagesLoad(xpath, expected_src);
			Assert.assertEquals(actual_src, expected_src, "SOURCE NOT MATCHED");
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumn_BuzzerLoadImages \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// -------------------------------------------------------------------END
	// TC20----------------------------------------------------------------------------
	// -------------------------------------------------------------------START
	// TC21--------------------------------------------------------------------------
	/**
	 * @param textData
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_TEXT")
	public void testHeaderTextLoadsForOneColumn_TC21(String textData, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String text_data = crowdGoesWildPage.getHeaderTextForOneColumn(textData);
			Assert.assertEquals(text_data, textData);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHeaderTextLoadsForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param textDataColor
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_HEADER_TEXT_COLOR")
	public void testHeaderHoverTextForOneColumn_TC21(String textDataColor, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.getHeaderHoverTextForOneColumn(textDataColor);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testHeaderHoverTextForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expectedDateString
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_DATE_TEXT")
	public void testCheckDateTextForOneColumn_TC21(String expectedDateString, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualString = crowdGoesWildPage.getDateStringForOneColumn(expectedDateString);
			Assert.assertEquals(actualString, expectedDateString);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testCheckDateTextForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIEW_MORE_EXIST")
	public void testViewMoreLinkLoadsForOneColumn_TC21(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.getViewMoreLinkTextForOneColumn();
			Assert.assertFalse(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testViewMoreLinkLoadsForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param expectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIDEO_LINK")
	public void testVideoHeadlineCheckForOneColumn_TC21(String expectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getVideoLinkForOneColumn(expectedvideoUrl);
			Assert.assertEquals(actualUrl, expectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testVideoHeadlineCheckForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	/**
	 * @param expectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_STORY_LINK")
	public void testStoryHeadlineCheckForOneColumn_TC21(String expectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		boolean flag = false;
		try {
			actualUrl = crowdGoesWildPage.getStoryLinkForOneColumn(expectedvideoUrl);
			Assert.assertEquals(actualUrl, expectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
			flag = true;
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testStoryHeadlineCheckForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
		Assert.assertTrue(flag, "URL is not matched");
		flag = false;
	}

	/**
	 * @param expected
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Show_More_Text")
	public void testShowMoreLinkLoadsForOneColumn_TC21(String expected, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.validateShowMoreForOneColumn(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkLoadsForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	//
	/**
	 * @param headerCount
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "HEADLINE_COUNT")
	public void testShowMoreLinkClickedForOneColumn_TC21(String headerCount, String testcaseId, String projId, String storyId, String defectName) {
		try {
			int HeaderCount = Integer.parseInt(headerCount);
			int countBeforeClick = crowdGoesWildPage.countHeadlines();
			crowdGoesWildPage.clickOnShowMoreButton(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()), 1);
			int countAfterClick = crowdGoesWildPage.countHeadlines();
			int countOfHeaders = crowdGoesWildPage.getNewlyAddedHeadlines(countAfterClick, countBeforeClick);
			log.info("Number of header in the webpage are :" + countAfterClick);
			Assert.assertEquals(countOfHeaders, HeaderCount);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkClickedForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 *
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHRONOLOGICAL_ORDER")
	public void testChronologicalOrderForOneColumn_TC21(String testcaseId, String projId, String storyId, String defectName) {
		try {
			Assert.assertTrue(crowdGoesWildPage.isPubDatesInOrder(false), crowdGoesWildPage.getErrMessage());
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testChronologicalOrderForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param headerCount
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "HEADLINE_COUNT")
	public void testShowMoreLinkClickedAgainForOneColumn_TC21(String headerCount, String testcaseId, String projId, String storyId, String defectName) {
		try {
			int HeaderCount = Integer.parseInt(headerCount);
			int countBeforeClick = crowdGoesWildPage.countHeadlines();
			crowdGoesWildPage.clickOnShowMoreButton(((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()),1);
			int countAfterClick = crowdGoesWildPage.countHeadlines();
			int countOfHeaders = crowdGoesWildPage.getNewlyAddedHeadlines(countAfterClick, countBeforeClick);
			log.info("Number of header in the webpage are :" + countAfterClick);
			Assert.assertEquals(countOfHeaders, HeaderCount);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkClickedAgainForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param isShowMore
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "SHOW_MORE_EXIST")
	public void testShowMoreLinkExistForOneColumn_TC21(String isShowMore, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean actual = crowdGoesWildPage.clickingShowMore();
			Assert.assertFalse(actual);
		} catch (AssertionError e) {
			log.info("\n\n\nAssertion ERROR in TC ##  testShowMoreLinkExistForOneColumn \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// --------------------------------------------------------------------END
	// TC21----------------------------------------------------------------------------
	
	// ----------------------------------------------------------Start of Test
	// Case 28------------
	/**
	 * @param headerCount
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 * @throws InterruptedException
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SECONDARY_NAV_ELEMENT_ONE_COLUMN")
	public void testOneColumnSecondaryNavElements_TC28(String XpathOfExpected,String expectedLinkText, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			String actualText=crowdGoesWildPage.validateSecondayNavElelmentsForOneColumn(XpathOfExpected,expectedLinkText);
			Assert.assertEquals(actualText, expectedLinkText);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	//----------------------------------------------------------End of Test Case 28------------
	
	//----------------------------------------------------------Start of Test Case 29------------
	/**
	 *
	 * @param textDataColor
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SECONDARY_NAV_VIDEO_COLOR_ON_CLICK")
	public void testColorForVideoLinkHoverForOneColumn_TC29_A(String textDataColor, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			boolean actual = crowdGoesWildPage.getVideoClickedAndHoverText(textDataColor);
			Assert.assertTrue(actual);
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_VIDEO_LINK_FUNCTIONAL")
	public void testVideoLinkedClickedForOneColumn_TC29_B(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		try {
			actualUrl = crowdGoesWildPage.getVideoSecondaryNavClicked(ExpectedvideoUrl);
			Assert.assertEquals(actualUrl, ExpectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	//----------------------------------------------------------End of Test Case 29------------
	
	//----------------------------------------------------------Start of Test Case 30------------
	/**
	 *
	 * @param true if menu expands expands
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CAST_EXPANDS")
	public void testToCheckIfMenuExpandsForOneColumn_TC30_A(String textData, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			boolean actual = crowdGoesWildPage.checkifMenuExpands(textData);
			Assert.assertTrue(actual);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	
	
	/**
	 *
	 * @param true if text present
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CLOSE_BUTTON")
	public void testToCheckIfCloseLinkPresentForOneColumn_TC30_B(String expected, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			String actual = crowdGoesWildPage.getCloseLinkText(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	/**
	 *
	 * @param true if text present
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_SUB_LINK_PRESENT")
	public void testToCheckIfSubLinkPresentForOneColumn_TC30_C(String expected, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException
	{
		try {
			String actual = crowdGoesWildPage.getSubLinkTextOnClickOfClose(expected);
			Assert.assertEquals(actual, expected);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	
	
	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" })
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_CAST_TEXT_FUNCTIONAL")
	public void testSecondaryNavSUBLinkClickedForOneColumn_TC30_D(String ExpectedvideoUrl, String testcaseId, String projId, String storyId, String defectName) {
		String actualUrl = null;
		try {
			actualUrl = crowdGoesWildPage.getCastSecondaryNavClicked(ExpectedvideoUrl);
			Assert.assertEquals(actualUrl, ExpectedvideoUrl, "ERROR IN OPENING URL");
			crowdGoesWildPage.goBackToLink(crowdGoesWildPageUrl);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	// ----------------------------------------------------------End of Test
	// Case 30------------
	// ----------------------------------------------------------START of Test
	// Case 35------------
	/**
	 *
	 * @param expectedImageSrc
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_ONE_HEADER_IMAGE")
	public void testOneColumnHeaderImage_TC35_A(String expectedImageSrc, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actual = crowdGoesWildPage.validate_One_HeaderImage(expectedImageSrc);
			log.info("Expected Image is ::\n" + expectedImageSrc + " and and actual is \n" + actual);
			Assert.assertTrue(actual.contains(expectedImageSrc), "testThreeColumnHeaderImage Failed");
		} catch (AssertionError e) {
			log.info("testOneColumnHeaderImage assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumnHeaderImage \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedImageLink
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_ONE_HEADER_IMAGE_LINK")
	public void testOneColumnHeaderImageLink_TC35_B(String expectedImageLink, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String actualLink = crowdGoesWildPage.validate_One_HeaderImageLink(expectedImageLink);
			log.info("Expected Image Link is ::\n" + expectedImageLink + " and actual is \n" + actualLink);
			Assert.assertEquals(actualLink, expectedImageLink, "testThreeColumnHeaderImageLink Failed");
		} catch (AssertionError e) {
			log.info("testOneColumnHeaderImageLink assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumnHeaderImageLink \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	// ----------------------------------------------------------End of Test
	// Case 35------------
	// ----------------------------------------------------------START of Test
	// Case 47------------
	/**
	 *
	 * @param expectedHeaderPresence
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_ONE_TUNE_IN_HEADER")
	public void testOneColumnTuneInHeader_TC47_A(String expectedHeaderPresence, String testcaseId, String projId, String storyId, String defectName) {
		try {
			boolean headerVisibility = crowdGoesWildPage.validate_One_TuneInHeader(Boolean.parseBoolean(expectedHeaderPresence));
			log.info("Expected header presence is ::\n" + expectedHeaderPresence + " and actually its \n" + headerVisibility);
			Assert.assertEquals(headerVisibility, Boolean.parseBoolean(expectedHeaderPresence));
		} catch (AssertionError e) {
			log.info("testOneColumnTuneInHeader assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumnTuneInHeader \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}

	/**
	 *
	 * @param expectedFontSize
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" } )
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "COLUMN_ONE_TUNE_IN_HEADER_FONT_SIZE")
	public void testOneColumnTuneInHeaderFontSize_TC47_B(String expectedFontSize, String testcaseId, String projId, String storyId, String defectName) {
		try {
			String headerFontSize = crowdGoesWildPage.validate_One_TuneInHeaderFontSize(expectedFontSize);
			log.info("Expected header Font Size is ::\n" + expectedFontSize + " and actually its \n" + headerFontSize);
			Assert.assertEquals(headerFontSize, expectedFontSize);
		} catch (AssertionError e) {
			log.info("testOneColumnTuneInHeaderFontSize assertion failed.");
			log.info("\n\n\nAssertion ERROR in TC ##  testOneColumnTuneInHeaderFontSize \n\n\n");
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	// ----------------------------------------------------------END of Test
	// Case 47------------
	
	//----------------------------------------------------------Start of Test Case 31------------
	/**
	 * @param ExpectedvideoUrl
	 * @param testcaseId
	 * @param projId
	 * @param storyId
	 * @param defectName
	 */
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" })
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_BUZZER_FUNCTIONAL_POSITION")
	public void testSecondaryNavBuzzerLinkClickedForOneColumn_TC31(String expectedPosition, String testcaseId, String projId, String storyId, String defectName){
		try {
			boolean actualPosition = crowdGoesWildPage.getBuzzerSecondaryNavClicked(expectedPosition);
			Assert.assertTrue(actualPosition);
		} catch (AssertionError e) {
			crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
		}
	}
	//----------------------------------------------------------End Of Test Case 31
	
	
	//----------------------------------------------------------Start of Test Case 32------------
		/**
		 * @param ExpectedvideoUrl
		 * @param testcaseId
		 * @param projId
		 * @param storyId
		 * @param defectName
		 * @throws PageException
		 */
		@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class, groups = { "mobile" })
		@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_BUZZER_FUNCTIONAL_POSITION")
		public void testSecondaryNavINFOLinkClickedForOneColumn_TC32(String expectedPosition, String testcaseId, String projId, String storyId, String defectName){
			
			try {
			boolean	actualPosition = crowdGoesWildPage.getINFOSecondaryNavClicked(expectedPosition);
			Assert.assertTrue(actualPosition);
			} catch (AssertionError e) {
				crowdGoesWildPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, null, null, null, e.getMessage());
				throw e;
			}
		}
		//----------------------------------------------------------End Of Test Case 32
	
	
	// ----------------------------------------------One column layout
	// end---------------------------------------------------------------------------------

}