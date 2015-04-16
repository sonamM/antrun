package test.etouch.fox.sikuli;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.watch.pages.BuzzerPage;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.desktop.sikuli.ISikuliIntegration;
import com.etouch.taf.desktop.sikuli.SikuliIntegration;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

public class TestFoxSportsVideo extends BaseTest {

	private BuzzerPage buzzerPage;
	private static final String weburl = "http://stg1.foxsports.com/watch/crowd-goes-wild/video";
	private ISikuliIntegration sikuliIntegration;
	static Log log = LogUtil.getLog(TestFoxSportsVideo.class);
	
	@Test
	public void TestVideo()
	{
		try{
			
			//initialize the mouse handler 
			Mouse mouse = new DesktopMouse();
			
			//initialize the Sikuli Integration API.
			sikuliIntegration = new SikuliIntegration();

			/* Initail the Web driver and the page to test */
			WebPage webPage = new WebPage();
			buzzerPage = new BuzzerPage(weburl, webPage);
			buzzerPage.waitForPageload();
			((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver()).manage().window().maximize();

			/* Adjust the scroll bar in the page */
			JavascriptExecutor jse = (JavascriptExecutor)((WebDriver)TestBedManager.INSTANCE.getTestBed().getDriver());
			jse.executeScript("window.scrollBy(0,200)", "");

			/* 
			 * This wait is added to complete the advertising videos on the page 
			 */
			wait(40);
			
			/* Capture the desktop screen region where the video is played */
			ScreenRegion searchArea = sikuliIntegration.defaultScreenByCoordinates(0,200,1000,500);
			
			/* This is required to bring back the button on the page which goes hidden */
			mouse.hover(searchArea.getCenter());
			
			/* 
			 * Create a button gruop i.e play and pause button.
			 * At a given time only one will be available on the screen. 
			 * Identify the corrent button and execute action on them.
			 */
			URL[] images = new URL[]{ImagesResource.PLAY_BUTTON,ImagesResource.PAUSE_BUTTON};
			String[] states = new String[]{"play","pause"};
			ScreenRegion playPauseArea = sikuliIntegration.waitAndLoadScreenRegionByImage(searchArea, 5000, images, states);
			 
			
			mouse.hover(searchArea.getCenter());
			mouse.click(playPauseArea.getCenter());
			
			wait(10);
			
			mouse.hover(searchArea.getCenter());
			mouse.click(playPauseArea.getCenter());
			
		}catch(Exception e)
		{
			log.error("Test case failed ::: "+e.getMessage());
		}
		
	
	}
	
	public static void wait(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
		}               
	}
}
