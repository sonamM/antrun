package com.etouch.fox.watch.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.rest.ResultType;
import org.apache.commons.logging.Log;











import com.etouch.fox.common.pages.CommonPage;
import com.etouch.fox.common.pages.FoxSportsFooterPage;
import com.etouch.fox.listener.SuiteListener;
import com.etouch.fox.watch.pages.elements.GlobalNavPageElement;
import com.etouch.taf.core.exception.PageException;
import com.etouch.taf.core.resources.ObjectType;
import com.etouch.taf.util.BrowserInfoUtil;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;
import com.etouch.taf.webui.selenium.webelement.Link;
import com.etouch.taf.webui.selenium.webelement.Text;
import com.etouch.taf.webui.selenium.webelement.TextBox;

public class GlobalNavPage extends CommonPage {
	
	private FoxSportsFooterPage foxSportsFooterPage;
	private static Log log = LogUtil.getLog(GlobalNavPage.class);
	boolean flag=false;
	
	public GlobalNavPage(String sbPageUrl, WebPage webPage) {
		super(sbPageUrl, webPage);
		this.foxSportsFooterPage = new FoxSportsFooterPage(this.webPage);
		loadPage();
	}
	
//	public Link mouserHovertest(String xpath,WebDriver webDriver,String expectedText) throws InterruptedException{
//        Link link = null;
//        String pageElement = null;
//     String actualResult = null;
//		try 
//		{
//			link = webPage.findPageObjectByXPath(xpath, IPageObjectType.Link );
//			pageElement = link.getText();
//			actualResult = link.getText();
//			link.hover(webDriver);	        
//	        webPage.sleep(500);
//	        log.info("the text is : "+link.getText());
//	        
//		}
//		catch (PageException e) 
//		{
//			log.error(e.getMessage());
//            setErrMessage(
//						ResultType.ERROR,
//						pageElement,
//						webPage.getCurrentUrl(),
//						expectedText,
//						actualResult,
//						e.getMessage());
//		}
//		return link;
//	}
//	
//	public String enterCodeAndFullScheduleClick(WebDriver webDriver,String codevalue) throws InterruptedException
//	{
//		String url = null;
//        String pageElement = null;
//        String expectedResult =null;
//    
//		try 
//		{
//			TextBox txtZipCode=webPage.findPageObjectByXPath(GlobalNavPageElement.local_zip_code,-1,null,IPageObjectType.TextBox);
//			webPage.sleep(3000);
//			txtZipCode.enterText(codevalue);
//			webPage.sleep(500);	
//			Link linkFullSchedule=webPage.findPageObjectByXPath(GlobalNavPageElement.Full_schedule,-1,null,IPageObjectType.Link);
//			webPage.sleep(3000);
//			
//			if (BrowserInfoUtil.INSTANCE.isSafari()
//				|| BrowserInfoUtil.INSTANCE.isChrome()
//				|| BrowserInfoUtil.INSTANCE.isIE8()
//				|| BrowserInfoUtil.INSTANCE.isIE9()
//				|| BrowserInfoUtil.INSTANCE.isIE10())
//			{
//				linkFullSchedule.clickEvent(webDriver);
//			}
//			else 
//			{
//				linkFullSchedule.click();
//			}
//		
//			webPage.sleep(500);	
//			url=webDriver.getCurrentUrl();
//			if (BrowserInfoUtil.INSTANCE.isSafari())
//			{
//				webPage.navigateToUrl(SuiteListener.pageURLs.getProperty("CROWD_GOES_WILD_PAGE"));
//			}
//			else
//			{
//				webPage.getBackToUrl();
//			}
//		}
//		catch (PageException e) 
//		{
//			log.error(e.getMessage());
//            setErrMessage(
//						ResultType.ERROR,
//						pageElement,
//						webPage.getCurrentUrl(),
//						expectedResult,
//						url,
//						e.getMessage());
//		}
//		
//		return url;
//	}
//	
//	public boolean mouserHoverOfftest(WebDriver webDriver) throws InterruptedException{
//       
//		 String pageElement = null;
//	        String expectedResult =null;
//		try 
//		{
//			 Link link = webPage.findPageObjectByXPath(GlobalNavPageElement.Hover_off, IPageObjectType.Link );
//			 link.hover(webDriver);
//			 webPage.sleep(500);	
//			 flag=true;
//		} 
//		catch (PageException e) 
//		{
//			log.error(e.getMessage());
//			 flag=false;
//			setErrMessage(
//						ResultType.ERROR,
//						pageElement,
//						webPage.getCurrentUrl(),
//						expectedResult,
//						String.valueOf(flag),
//						e.getMessage());
//
//           
//		}  
//		return flag;	
//	}
//	
//	public Link elementAttributeValue(String xpath,WebDriver webDriver,String url) throws InterruptedException{
//        Link link = null;
//        String actualResult = null;
//		try 
//		{
//			link = webPage.findPageObjectByXPath(xpath, IPageObjectType.Link );
//			link.getAttribute("href");
//			actualResult = link.getAttribute("href");
//			webPage.sleep(500);	
//		} 
//		catch (PageException e) 
//		{
//			log.error(e.getMessage()); 
//            setErrMessage(
//						ResultType.ERROR,
//						actualResult,
//						webPage.getCurrentUrl(),
//						url,
//						actualResult,
//						e.getMessage());
//		}
//       
//        log.info("href is: "+ link.getAttribute("href"));
//        return link;
//	}
//	
//	public ArrayList<String> validateImage(String xpath)
//	{
//	   
//		ArrayList<String> value=new ArrayList<String>();
//		List<Text> elements;
//		String actualResult=null;
//		String links =null;
//		try 
//		{
//			elements = webPage.findPageObjectsByXPath(xpath,IPageObjectType.Text);
//			for(Text ele:elements)
//			{
//				 links=ele.getAttribute("src");
//				value.add(links);
//			}
//		} 
//		catch (PageException e) 
//		{
//			log.error(e.getMessage());
//            setErrMessage(
//						ResultType.ERROR,
//						links,
//						webPage.getCurrentUrl(),
//						null,
//						actualResult,
//						e.getMessage());
//		}
//		
//		return value;   
//	}
//	
//	public String clickSubLink(WebDriver webDriver,String xpath,String expectedURL) throws InterruptedException{
//		String url = null;
//		try 
//		{
//			 Link link = webPage.findPageObjectByXPath(xpath, IPageObjectType.Link );
//			 webPage.sleep(3000);	
//
//				if (BrowserInfoUtil.INSTANCE.isSafari()
//						|| BrowserInfoUtil.INSTANCE.isChrome()
//						|| BrowserInfoUtil.INSTANCE.isIE8()
//						|| BrowserInfoUtil.INSTANCE.isIE9()
//						|| BrowserInfoUtil.INSTANCE.isIE10())
//				{
//		        	link.clickEvent(webDriver);
//				}
//		        else 
//		        {
//		        	link.click();
//		        }
//		        webPage.openNewTab();   
//		        url=webDriver.getCurrentUrl();
//		        webPage.sleep(3000);
//		} 
//		catch (PageException e) 
//		{
//			log.error(e.getMessage());
//			setErrMessage(
//						ResultType.ERROR,
//						null,
//						webPage.getCurrentUrl(),
//						expectedURL,
//						url,
//						e.getMessage());
//		}
//		
//	
//        return url;
//	}	
}
