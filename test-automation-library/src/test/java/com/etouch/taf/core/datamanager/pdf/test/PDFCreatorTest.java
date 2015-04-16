package com.etouch.taf.core.datamanager.pdf.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.junit.Test;

import com.etouch.taf.core.datamanager.pdf.PDFCreator;
import com.etouch.taf.util.LogUtil;

public class PDFCreatorTest {
	
	/** The Log object **/
	private static Log log = LogUtil.getLog(PDFCreatorTest.class);
	
	/** The resulting PDF file. */
    private static final String RESULT = "C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\image_types.pdf";
    
    /** Paths to images. */
    private static final String[] RESOURCES = {
        /*"bruno_ingeborg.jpg",
        "map.jp2",
        "info.png",
        "close.bmp",
        "movie.gif",
        "butterfly.wmf",
        "animated_fox_dog.gif",
        "marbles.tif",
        "amb.jb2"*/
    	"Img1.png",
    	"Img3.png",
    	"Img4.png",
    	"Img8.png"
    	
    };

	private static final String IMGSOURCE = "C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\";

	@Test
	public void testCreatePDF() {
		
		boolean isPDFCreated = false;
		
		try{
				new PDFCreator().createPdf(RESOURCES, IMGSOURCE, RESULT);
				isPDFCreated = true;
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
		Assert.assertTrue(isPDFCreated);
	}

}
