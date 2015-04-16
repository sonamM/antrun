package test.etouch.fox.watch;

import java.util.List;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.BuzzerPage;
import com.etouch.taf.core.datamanager.excel.TafExcelDataProvider;
import com.etouch.taf.core.datamanager.excel.TestParameters;
import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
//import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

/**
 * Test Class for testing BuzzerPage.
 * 
 * @author eTouch Systems Corporation
 * 
 */

@IExcelDataFiles(excelDataFiles = {
		"file1=src/test/resources/testdata/watch/test-excel-file.xls",
		"file2=src/test/resources/testdata/global/header.xls",
		"file2=src/test/resources/testdata/global/footer.xls" })

public class TestBuzzerPage extends BaseTest {

	private String buzzerPageUrl;
	private BuzzerPage buzzerPage;
	private static Log log = LogUtil.getLog(TestBuzzerPage.class);
	private static int index;

	
	@BeforeClass
	public void prepareBeforeClass() throws Exception {
		loadUrl();
		WebPage webPage = new WebPage();
		buzzerPage = new BuzzerPage(buzzerPageUrl, webPage);
	}

	private void loadUrl() {

		buzzerPageUrl = constructURL(SuiteListener.pageURLs.getProperty("CROWD_GOES_WILD_PAGE"));
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_URL")
	public void testPageUrlLoad(TestParameters testParams) {
	//public void testPageUrlLoad(String checkUrl, String testcaseId, String projId, String storyId, String defectName, String defectSeverity, String defectOwner, String defectNotes) {
		try{
//			System.out.println(testParams.getParamMap().get("URL"));
//			System.out.println(testParams.getParamMap().get("TESTCASEID"));
//			System.out.println(testParams.getParamMap().get("PROJECTID"));
//			System.out.println(testParams.getParamMap().get("STORYID"));
//			System.out.println(testParams.getParamMap().get("DEFECTNAME"));
//			System.out.println(testParams.getParamMap().get("DEFECTSEVERITY"));
//			System.out.println(testParams.getParamMap().get("DEFECTOWNER"));
//			System.out.println(testParams.getParamMap().get("DEFECTNOTES"));
			//Assert.assertEquals(buzzerPage.getPageUrl(), checkUrl,"Wrong URL");
			Assert.assertEquals("abc", testParams.getParamMap().get("URL"),"Wrong URL");
		}catch(AssertionError e){
			buzzerPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testParams.getParamMap().get("TESTCASEID"), testParams.getParamMap().get("PROJECTID"), 
					testParams.getParamMap().get("STORYID"), testParams.getParamMap().get("DEFECTNAME"), testParams.getParamMap().get("DEFECTSEVERITY"), testParams.getParamMap().get("DEFECTOWNER"), 
					testParams.getParamMap().get("DEFECTNOTES"), e.getMessage());
		}
	
	}
	
	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_TEXT")
	public void testAText(TestParameters testParams) {
		try {
			System.out.println(testParams.getParamMap().get("TEXT"));
			System.out.println(testParams.getParamMap().get("TESTCASEID"));
			System.out.println(testParams.getParamMap().get("PROJECTID"));
			System.out.println(testParams.getParamMap().get("STORYID"));
			System.out.println(testParams.getParamMap().get("DEFECTNAME"));
//			List<String> text_data = buzzerPage.getBuzzerText(textData);
//			String[] array = text_data.toArray(new String[text_data.size()]);
//			Assert.assertEquals(array[index++], textData, "TEXT NOT MATCHED");
		}catch(AssertionError e){			
			
//			buzzerPage.logAndCreateADefect(testBedManager.getDefect(), defect_properties_file, testcaseId, projId, storyId, defectName, defectSeverity, defectOwner, defectNotes, e.getMessage());		
		}		
	}
	

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "CHECK_PROPERTY")
	public void testGetAllProperty(TestParameters testParams) {		
		try{
			System.out.println(testParams.getParamMap().get("RGBA1"));
			System.out.println(testParams.getParamMap().get("PIXEL1"));
			System.out.println(testParams.getParamMap().get("RGBA2"));
			System.out.println(testParams.getParamMap().get("PIXEL2"));
			System.out.println(testParams.getParamMap().get("RGBA3"));
			System.out.println(testParams.getParamMap().get("PIXEL3"));
			System.out.println(testParams.getParamMap().get("TEXT"));
			System.out.println(testParams.getParamMap().get("TESTCASEID"));
			System.out.println(testParams.getParamMap().get("PROJECTID"));
			System.out.println(testParams.getParamMap().get("STORYID"));
			System.out.println(testParams.getParamMap().get("DEFECTNAME"));
//			String text = buzzerPage.getAllProperty(headerColor,headerSize,dateColor,dateSize,bodyColor,bodySize);
//			Assert.assertEquals(text, headerColor + "," + headerSize + "," + dateColor + ","
//							+ dateSize + "," + bodyColor + "," + bodySize,"ERROR WHILE GETTING PROPERTY");
		}catch(AssertionError e){
//			buzzerPage.logAndCreateADefect(testBedManager.getRally(), rally_properties_file, testcaseId, projId, storyId, defectName, e.getMessage());
		}
	}

	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "PUBLISH_DATE_ORDER")
	public void testPublishedDatesOrder(TestParameters testParams) {
		try{
			System.out.println(testParams.getParamMap().get("TESTCASEID"));
			System.out.println(testParams.getParamMap().get("PROJECTID"));
			System.out.println(testParams.getParamMap().get("STORYID"));
			System.out.println(testParams.getParamMap().get("DEFECTNAME"));
		//Assert.assertTrue(buzzerPage.isPubDatesInOrder(false),buzzerPage.getErrMessage());
		}catch(AssertionError e){
		//	buzzerPage.logAndCreateADefect(testBedManager.getRally(), rally_properties_file, testcaseId, projId, storyId, defectName, e.getMessage());
		}
	}

//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "IMAGE_SRC")
//	public void testBuzzerImage(String imageSrc, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException {
//		try{
//			String buzzer_src = buzzerPage.getBuzzerImg(imageSrc);
//			Assert.assertEquals(buzzer_src, imageSrc, buzzerPage.getErrMessage());			
//		}catch(AssertionError e){
//			
//			
//			buzzerPage.logAndCreateADefect(testBedManager.getRally(), rally_properties_file, testcaseId, projId, storyId, defectName, e.getMessage());
//		}		
//	}
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "SCREENSHOT")
//	public void testscreenshot(String testcaseId, String projId, String storyId, String defectName) throws InterruptedException, PageException {
//		try
//		{
//			Integer size1 = buzzerPage.getSize();
//			buzzerPage.waitForPageload();
//			Integer size2 = buzzerPage.getscreenShot(testBedManager.getDriver().getSeleniumDriver());
//	
//			buzzerPage.captureScreenShot(testBedManager.getDriver().getSeleniumDriver());
//			Assert.assertFalse(true, buzzerPage.getErrMessage());		
//			Assert.assertTrue((size1 + 3) >= size2, "Headlines exceeds the limits");
//		} catch(AssertionError e){
//			buzzerPage.logAndCreateADefect(testBedManager.getRally(), rally_properties_file, testcaseId, projId, storyId, defectName, e.getMessage());
//		}	
//	}
//	
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Header1024")
//	public void testwreadAllPageObjectsFor1024(String xpath, String element, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException, PageException {
//		log.info("-------------Finding all the Page Objects for 1024-------------");
//		this.testwbufferReadAllPages(xpath, element, 1024, testcaseId, projId, storyId, defectName);
//
//	}
//
//	public void testwbufferReadAllPages(String xpath, String element, int screenSize, String testcaseId, String projId, String storyId, String defectName) throws InterruptedException, PageException {
//		try{
//			int assertValue = buzzerPage.readAllPageObjects(
//					testBedManager.getDriver().getSeleniumDriver(), xpath, element, screenSize);
//			switch (assertValue) {
//			case 1:
//				Assert.assertEquals(assertValue, 1);
//				break;
//			case 2:
//				Assert.assertEquals(assertValue, 2);
//				break;
//			case 3:
//				Assert.assertEquals(assertValue, 3);
//				break;
//			case -1:
//				Assert.assertEquals(assertValue, -1);
//				break;
//			default:
//				break;
//			}
//		}catch(AssertionError e){
//			buzzerPage.logAndCreateADefect(testBedManager.getRally(), rally_properties_file, testcaseId, projId, storyId, defectName, e.getMessage());
//		}	
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Header1023")
//	public void testwreadAllPageObjectsFor1023(String xpath, String element, String testcaseId, String projId, String storyId, String defectName)
//			throws InterruptedException, PageException {
//		log.info("-------------Finding all the Page Objects for 1023-------------"); 
//		buzzerPage.readAllPageObjects(testBedManager.getDriver().getSeleniumDriver(), xpath, element, 1023);
//		this.testwbufferReadAllPages(xpath, element, 1023, testcaseId, projId, storyId, defectName);
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Header686")
//	public void testwreadAllPageObjectsFor686(String xpath, String element, String testcaseId, String projId, String storyId, String defectName)
//			throws InterruptedException, PageException {
//		log.info("-------------Finding all the Page Objects for 686-------------"); 
//		buzzerPage.readAllPageObjects(testBedManager.getDriver().getSeleniumDriver(), xpath, element, 686);
//		this.testwbufferReadAllPages(xpath, element, 686, testcaseId, projId, storyId, defectName);
//	}
//
//	@Test(dataProvider = "tafDataProvider", dataProviderClass = TafExcelDataProvider.class)
//	@ITafExcelDataProviderInputs(excelFile = "file1", excelsheet = "CGWHeader", dataKey = "Header685")
//	public void testwreadAllPageObjectsFor685(String xpath, String element, String testcaseId, String projId, String storyId, String defectName)
//			throws InterruptedException, PageException {
//		log.info("-------------Finding all the Page Objects for 685-------------");
//		buzzerPage.readAllPageObjects(testBedManager.getDriver().getSeleniumDriver(), xpath, element, 685);
//		this.testwbufferReadAllPages(xpath, element, 685, testcaseId, projId, storyId, defectName);
//		
//	}

}
