package test.etouch.fox.watch;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.CrowdGoesWildPage;
import com.etouch.fox.watch.pages.elements.CrowdGoesWildPageElements;
import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

/**
 * 
 * Test case to test the responsive UI Layout
 * Test data should be in the following requirement
 * 
 * TEXT - Populate the Array with the one text element from each of the column available on Layout
 * LOCATION - Populate the Array with the respective locations for the elements added on the TEXT array
 * XPATH - Populate the Array with the repective xpath to load the elements added on the TEXT array
 * 
 * @author etguest
 *
 */
public class TestCrowdGoesWildResponsivePage extends BaseTest{

	private String crowdGoesWildPageUrl;
	private CrowdGoesWildPage crowdGoesWildPage;
	private WebPage webPage ;
	private static Log log = LogUtil.getLog(TestCrowdGoesWildResponsivePage.class);
	
	@BeforeClass
	public void prepareBeforeClass() throws Exception{
		loadUrl();
		webPage = new WebPage();
		crowdGoesWildPage = new CrowdGoesWildPage(crowdGoesWildPageUrl, webPage);
	}

	private void loadUrl() {
		crowdGoesWildPageUrl = constructURL(SuiteListener.pageURLs.getProperty("CROWD_GOES_WILD_PAGE"));
	}

	@Test
	public void testResponsiveLayout()
	{
		int cols = 0;
		try{
			
			//TODO : Check the better way to idenfity the IPHONE platform.
			if(BrowserInfoUtil.INSTANCE.isAndroid())
			{

				/****************** IPHONE LAYOUT TEST START *****************************/
				String[] iphoneText = {"Sample PHotos" };
				Point[] iphoneLocations = {new Point(4, 212) };
				String[] iphoneXPaths = {CrowdGoesWildPageElements.Col1_XPATH,CrowdGoesWildPageElements.Col2_XPATH,CrowdGoesWildPageElements.Col3_XPATH};


				cols = crowdGoesWildPage.getNumberOfColumns(iphoneText,iphoneLocations,iphoneXPaths);
				try{
					// Run Test Case for table 
					Assert.assertEquals(cols, CrowdGoesWildPageElements.COLS_FOR_IPHONE_LAYOUT);
					
				}catch(Exception e)
				{
					log.info("Test cases failed for Iphone layout");
				}
				/****************** IPHONE LAYOUT TEST END *****************************/
			}
			else
			{
				/*
				 * Running the Responsive UI Test cases 
				 * 1. Test the Desktop layout first
				 *     a) Load the Test data
				 *     b) get the number of columns
				 */
				
				/****************** DESKTOP LAYOUT TEST START *****************************/
				//Define the Test data for the Desktop Application
				String[] desktopText = {"Sample PHotos","Adrian Peterson","TV LISTINGS"};
				Point[] deskTopLocations = {new Point(10, 384),new Point(634, 633), new Point(943, 90)};
				String[] deskTopXPaths = {CrowdGoesWildPageElements.Col1_XPATH,CrowdGoesWildPageElements.Col2_XPATH,CrowdGoesWildPageElements.Col3_XPATH};
				try{
					cols = crowdGoesWildPage.getNumberOfColumns(desktopText,deskTopLocations,deskTopXPaths);
					// Run Test Case for Desktop 
					Assert.assertEquals(cols, CrowdGoesWildPageElements.COLS_FOR_DESKTOP_LAYOUT);
					Assert.assertTrue(crowdGoesWildPage.loadAndCheckAllElements(desktopText,deskTopLocations,deskTopXPaths));
				}catch(Exception e)
				{
					log.info("Test cases failed for Desktop layout");
				}
				

				/****************** DESKTOP LAYOUT TEST END *****************************/


				/****************** TABLET LAYOUT TEST START *****************************/

				// Defined the Test data for the Tablet Format
				String[] tabletText = {"Sample PHotos","Adrian Peterson"};
				Point[] tabletLocations = {new Point(4, 339),new Point(486, 534)};
				String[] tabletXPaths = {CrowdGoesWildPageElements.Col1_XPATH,CrowdGoesWildPageElements.Col2_XPATH};

				//resize the window to tablet layout
				webPage.getDriver().manage().window().setSize(new Dimension(750,500));
				cols = crowdGoesWildPage.getNumberOfColumns(tabletText,tabletLocations,tabletXPaths);

				try{
					// Run Test Case for tablet 
					Assert.assertEquals(cols, CrowdGoesWildPageElements.COLS_FOR_TABLET_LAYOUT);
				}catch(Exception e)
				{
					log.info("Test cases failed for Tablet layout");
				}
				/****************** TABLET LAYOUT TEST END *****************************/


				/****************** IPHONE LAYOUT TEST START *****************************/
				String[] iphoneText = {"Sample PHotos" };
				Point[] iphoneLocations = {new Point(4, 212) };
				String[] iphoneXPaths = {CrowdGoesWildPageElements.Col1_XPATH,CrowdGoesWildPageElements.Col2_XPATH,CrowdGoesWildPageElements.Col3_XPATH};

				//resize the window to Iphone layout
				webPage.getDriver().manage().window().setSize(new Dimension(275,500));

				cols = crowdGoesWildPage.getNumberOfColumns(iphoneText,iphoneLocations,iphoneXPaths);
				try{
					// Run Test Case for table 
					Assert.assertEquals(cols, CrowdGoesWildPageElements.COLS_FOR_IPHONE_LAYOUT);
				}catch(Exception e)
				{
					log.info("Test cases failed for Iphone layout");
				}
				/****************** IPHONE LAYOUT TEST END *****************************/
			}
			

		}catch(Exception e){
			e.printStackTrace();
		}

	}
 
}
