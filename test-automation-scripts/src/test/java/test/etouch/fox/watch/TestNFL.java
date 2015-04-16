package test.etouch.fox.watch;
import org.apache.commons.logging.Log;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.FantasyFootballPage;
import com.etouch.fox.watch.pages.NFLPage;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

public class TestNFL extends BaseTest{
	// comment
	private String nflPageUrl;
	private NFLPage nflPage;
	private static Log log = LogUtil.getLog(TestNFL.class);
	private WebPage webPage;
	

	@BeforeClass
	public void prepareBeforeClass() throws Exception{
		loadUrl();
		WebPage webPage = new WebPage();
		nflPage = new NFLPage(nflPageUrl, webPage);
	}

	private void loadUrl() {
		nflPageUrl = constructURL(SuiteListener.pageURLs.getProperty("NFL"));
	}
	
   @Test
   public void testVideoLink(){
	   System.out.println("NFL Page..." + nflPageUrl);
	   // Here put the assert statement to check the condition.
   }
	

}
