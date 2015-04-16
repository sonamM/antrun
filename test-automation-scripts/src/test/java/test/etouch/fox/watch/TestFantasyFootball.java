package test.etouch.fox.watch;

import org.apache.commons.logging.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.FantasyFootballPage;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

public class TestFantasyFootball extends BaseTest{
	
	private String fantasyFootballPageUrl;
	private FantasyFootballPage fantasyFootballPage;
	private static Log log = LogUtil.getLog(WebPage.class);
	private WebPage webPage;
	

	@BeforeClass
	public void prepareBeforeClass() throws Exception{
		loadUrl();
		WebPage webPage = new WebPage();
		fantasyFootballPage = new FantasyFootballPage(fantasyFootballPageUrl, webPage);
	}

	private void loadUrl() {
		fantasyFootballPageUrl = SuiteListener.pageURLs.getProperty("FANTASY_FOOTBALL");
	}
	
   @Test
   public void testVideoLink(){
	   // Here put the assert statement to check the condition.
   }
	

}
