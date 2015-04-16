package com.etouch.taf.core.datamanager.doc.test;

import static org.junit.Assert.*;

import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.datamanager.doc.DocReader;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;

public class DocReaderTest {
	
	/** The Log object **/
	private static Log log = LogUtil.getLog(DocReaderTest.class);
	
	private final String filePath = "C:\\Lavanya\\Project\\Lavanya_Resume.doc";
	
	DocReader dr = null;
	
	@Before
	public void setUp()
	{
		dr = new DocReader(filePath);
	}
	

	@Test
	public void testReadParagraps() {
		try
		{
			String str = dr.readParagraphs();
			//CommonUtil.sop(str);
			Assert.assertNotNull(str);
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
		}
		
	}
	
	@Test
	public void testReadHeader() {
		String str = dr.readHeader(2);
		CommonUtil.sop(str);
		Assert.assertNotNull(str);
	}
	
	@Test
	public void testReadFooter() {
		
		String str = dr.readFooter(2);
		CommonUtil.sop(str);
		Assert.assertNotNull(str);
		
	}
	
	@Test
	public void testReadImages() {
		boolean isImageExtracted = false;		
		List<byte[]> images = dr.readImages();
		if(images!=null && images.size()>0)
		{
			isImageExtracted = true;
			CommonUtil.sop(String.valueOf(images.size()));
		}
		Assert.assertTrue(isImageExtracted);
		
	}
	
	@Test
	public void testReadDocumentSummary() {
		
		String str = dr.readDocumentSummary();
		CommonUtil.sop(str);
		Assert.assertNotNull(str);
		
	}		
	

}
