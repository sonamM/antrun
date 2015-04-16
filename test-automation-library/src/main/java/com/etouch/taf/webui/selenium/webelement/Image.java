/*
 * 
 */
package com.etouch.taf.webui.selenium.webelement;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * Renders Image Page Object.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 */
public class Image extends Element {
	
	/** The log. */
	static Log log = LogUtil.getLog(Image.class);
	
	/** The pt x. */
	private int ptX;
	
	/** The pt y. */
	private int ptY;
	
	/** The height. */
	private int height;
	
	/** The width. */
	private int width;

	/**
	 * Initialize image page object.
	 *
	 * @param webElement the web element
	 */
	public Image(WebElement webElement) {
		super(webElement);
		setImageCoordinates();
		setImageSize();
	}
	
	/**
	 * sets image x and y coordinates.
	 */
	private void setImageCoordinates(){
		Point pt = getCoordinates();
		this.ptX = pt.x; 
		this.ptY = pt.y;
	}

	/**
	 * sets image size, height and width.
	 */
	private void setImageSize(){
		Dimension d = getSize();
		this.height=d.getHeight();
		this.width=d.getWidth();
	}

	/**
	 * Returns x coordinate of image.
	 * @return x coordinate of image
	 */
	public int getPtX() {
		return ptX;
	}

	/**
	 * Returns y coordinate of image.
	 * @return y coordinate of image
	 */
	public int getPtY() {
		return ptY;
	}

	/**
	 * Returns height of image.
	 * @return height of image
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Returns width of image.
	 * @return width of image
	 */
	public int getWidth() {
		return width;
	}

}
