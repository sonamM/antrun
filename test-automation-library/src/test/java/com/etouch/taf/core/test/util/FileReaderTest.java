package com.etouch.taf.core.test.util;

import static org.junit.Assert.*;

import org.apache.http.HttpResponse;
import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.datamanager.pdf.PDFFileReader;
import com.etouch.taf.util.FileDownload;
import com.etouch.taf.util.FileReader;

public class FileReaderTest {
	
	FileReader reader = null;
	String downloadUrl = "http://www.hdfcbank.com/assets/pdf/neft_rtgs_form.pdf";
	String filePath = "C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\";
	
	@Before
	public void setup()
	{	
		try{
		HttpResponse response = new FileDownload().downloadFile(downloadUrl, filePath);
		System.out.println(response.getEntity().getContentType().getValue());
		reader = new FileReader(response);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}

	@Test
	public void test() {
		PDFFileReader fileReader = (PDFFileReader)reader.getReader(filePath+"\\tempfile");
		try{
				System.out.println(fileReader.parsePdf(filePath+"\\tempfile"));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}

}
