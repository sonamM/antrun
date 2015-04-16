/*
 * 
 */
package com.etouch.taf.desktop.sikuli;

import java.net.URL;

import org.apache.commons.logging.Log;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.MultiStateTarget;
import org.sikuli.api.ScreenRegion;

import com.etouch.taf.util.LogUtil;


// TODO: Auto-generated Javadoc
/**
 * Implementation for the  interface to integrate test cases with Sikuli API.
 *  
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class SikuliIntegration implements ISikuliIntegration {

	/** The log. */
	private static Log log = LogUtil.getLog(SikuliIntegration.class);

	
	/* (non-Javadoc)
	 * @see com.etouch.taf.desktop.sikuli.ISikuliIntegration#findScreenRegionByImage(org.sikuli.api.ScreenRegion, java.net.URL[], java.lang.String[])
	 */
	public ScreenRegion findScreenRegionByImage(ScreenRegion screenRegionToSearch,
			URL[] images, String... state) throws Exception
	{

		ScreenRegion region = null;
		try{

			if(images.length>0)
			{
				if(images.length==1)
				{
					region = screenRegionToSearch.find(new ImageTarget(images[0]));	
				}
				else
				{
					MultiStateTarget target = new MultiStateTarget();
					for (int i = 0; i < images.length; i++)
					{
						target.addState(new ImageTarget(images[i]), state[i]);
					}
					region = screenRegionToSearch.find(target);	
				}
			}
		}catch(Exception e)
		{
			log.error(" Exception occured while retriving region " + e.getMessage());
			throw e;
		}

		return region;
	}

	
	/* (non-Javadoc)
	 * @see com.etouch.taf.desktop.sikuli.ISikuliIntegration#waitAndLoadScreenRegionByImage(org.sikuli.api.ScreenRegion, int, java.net.URL[], java.lang.String[])
	 */
	public ScreenRegion waitAndLoadScreenRegionByImage(
			ScreenRegion screenRegionToSearch,  int wait,URL[] images,String... state)throws Exception {


		ScreenRegion region = null;

		try{

			if(images.length>0)
			{
				if(images.length==1)
				{
					region = screenRegionToSearch.wait(new ImageTarget(images[0]),wait);	
				}
				else
				{
					MultiStateTarget target = new MultiStateTarget();
					for (int i = 0; i < images.length; i++)
					{
						target.addState(new ImageTarget(images[i]), state[i]);
					}
					region = screenRegionToSearch.wait(target,wait);	
				}
			}

		}catch(Exception e)
		{
			log.error(" Exception occured while retriving region " + e.getMessage());
			throw e;
		}


		return region;

	}

	
	/* (non-Javadoc)
	 * @see com.etouch.taf.desktop.sikuli.ISikuliIntegration#defaultScreen()
	 */
	public ScreenRegion defaultScreen() throws Exception {
		return new DesktopScreenRegion();
	}

	
	/* (non-Javadoc)
	 * @see com.etouch.taf.desktop.sikuli.ISikuliIntegration#defaultScreenByCoordinates(int, int, int, int)
	 */
	public ScreenRegion defaultScreenByCoordinates(int x, int y, int width,
			int height) throws Exception {
		return new DesktopScreenRegion(x,y,width,height);
	}

	 
}
