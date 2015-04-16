package com.etouch.taf.core.datamanager.pdf.test;

import static org.junit.Assert.*;

import java.io.IOException;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.junit.Test;

import com.etouch.taf.core.datamanager.pdf.PDFFileReader;
import com.etouch.taf.core.test.util.TafTestUtil;
import com.etouch.taf.mobile.experitest.cloud.ExperitestCloudDriver;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;

public class PDFFileReaderTest {
	
	private static Log log = LogUtil.getLog(PDFFileReaderTest.class);
	
	 /** The original PDF that will be parsed. **/
    public static final String INPUT1 = "C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\tempfile.pdf";
    
    /** The resulting text file. */
    private static final String RESULT1 = "C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\tempfile.txt";
    
    /** The original PDF that will be parsed. **/
    private static final String INPUT2 = "C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\image_types.pdf";
    
    /** The resulting image destination path */
    private static final String RESULT2 = "C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\Images\\Img%s.png";
    
    
	@Test
	public void testParsePDFtoText() {
		boolean isTxtCreated = false;
		try{
			new PDFFileReader().parsePDFtoText(INPUT1, RESULT1);
			isTxtCreated = true;			
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
		Assert.assertTrue(isTxtCreated);
		
	}
	
	@Test
	public void testParsePDF() {		
		try{
			 String str = new PDFFileReader().parsePdf(INPUT1);
			 Assert.assertNotNull(str);
			 CommonUtil.sop(str);
						
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
	}
	
	
	@Test
	public void testExtractImages() {		
		try{
			 new PDFFileReader().extractImages(INPUT2, RESULT2);
			 boolean isFolderExists = TafTestUtil.checkFolderExists("C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\Images");
			 Assert.assertNotNull(isFolderExists);
						
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
	}
	 

}
