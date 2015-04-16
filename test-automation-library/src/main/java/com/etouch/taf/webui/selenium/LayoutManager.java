/*
 * 
 */
package com.etouch.taf.webui.selenium;

import org.apache.commons.logging.Log;
import org.openqa.selenium.Dimension;

import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.webelement.Image;


// TODO: Auto-generated Javadoc
/**
 * Renders layout information of Page Object.
 *
 * @author eTouch Systems Corporation
 * @version 1.0
 */
public class LayoutManager {

	/** The log. */
	static Log log = LogUtil.getLog(LayoutManager.class);
	
	/**
	 * Returns no of columns information based on web responsive header image size.
	 *
	 * @param img the img
	 * @return integer 1 , 2 or 3 for one column , two column and three column.
	 */
	public int getColumnLayout(Image img){

		int cols = -1;
		
		Dimension respHdrDim = img.getSize();
		
		int height = respHdrDim.getHeight();

		if (height >= 177 && height <= 213 ) {
			log.info("Layout 3 Columns, Height : " + height);
			cols = 3;
		} else if (height >= 214 && height <= 244) {
			log.info("Layout 2 Columns, Height : " + height);
			cols = 2;
		} else if (height >= 80 && height <= 150) {
			log.info("Layout 3 Columns, Height : " + height);
			cols = 1;
		}
		
		return cols;
	}

}