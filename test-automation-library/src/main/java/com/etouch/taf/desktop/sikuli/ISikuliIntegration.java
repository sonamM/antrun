/*
 * 
 */
package com.etouch.taf.desktop.sikuli;

import java.net.URL;

import org.sikuli.api.MultiStateTarget;
import org.sikuli.api.ScreenRegion;

// TODO: Auto-generated Javadoc
/**
 * Interface to integrate test cases with Sikuli API.
 *  
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public interface ISikuliIntegration {

	/**
	 * Retrieve the default Desktop screen image.
	 *
	 * @return the screen region
	 * @throws Exception the exception
	 */
	public ScreenRegion defaultScreen() throws Exception;
	
	/**
	 * Retrieve the desktop screen area using the co-ordinates supplied.
	 *
	 * @param x the x
	 * @param y the y
	 * @param width the width
	 * @param height the height
	 * @return the screen region
	 * @throws Exception the exception
	 */
	public ScreenRegion defaultScreenByCoordinates(int x, int y, int width, int height) throws Exception;
	
	/**
	 * Find the Target image using the URL
	 * if one url is supplied then return screen area based on that
	 * if multiple url is input then create a instance of MultiStateTarget using that. 
	 * Then use the state array and add the state for the MultiStateTarget in the same sequence.
	 *
	 * @param screenRegionToSearch the screen region to search
	 * @param images the images
	 * @param state the state
	 * @return the screen region
	 * @throws Exception the exception
	 */
	public ScreenRegion findScreenRegionByImage(ScreenRegion screenRegionToSearch, URL[] images,String... state) throws Exception;
	
	/**
	 * Wait for the page to load for the given wait time, and then try to find the image on the Screen region.
	 * if one url is supplied then return screen area based on that image.
	 * if multiple url is input then create a instance of MultiStateTarget using that. 
	 * Then use the state array and add the state for the MultiStateTarget in the same sequence.
	 *
	 * @param screenRegionToSearch the screen region to search
	 * @param wait the wait
	 * @param images the images
	 * @param state the state
	 * @return the screen region
	 * @throws Exception the exception
	 */
	public ScreenRegion waitAndLoadScreenRegionByImage(ScreenRegion screenRegionToSearch, int wait,URL[] images,String... state) throws Exception;
}
