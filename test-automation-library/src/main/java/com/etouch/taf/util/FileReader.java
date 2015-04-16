package com.etouch.taf.util;

import org.apache.commons.logging.Log;
import org.apache.http.HttpResponse;

import com.etouch.taf.core.datamanager.doc.DocReader;
import com.etouch.taf.core.datamanager.doc.DocxReader;
import com.etouch.taf.core.datamanager.excel.XlsReader;
import com.etouch.taf.core.datamanager.excel.XlsxReader;
import com.etouch.taf.core.datamanager.pdf.PDFFileReader;
import com.etouch.taf.core.datamanager.txt.TextReader;

public class FileReader {
	
	private static Log log = LogUtil.getLog(FileReader.class);
	
	//private HttpResponse response;
	private String fileType = null;
	
	public FileReader(HttpResponse response)
	{
		//this.response = response;
		this.fileType = response.getEntity().getContentType().getValue();
		
	}
	
	public String getMIMEType()
	{
		return fileType;
	}
	
	public Object getReader(String filePath)
	{
		Object reader = null;
		if(fileType.equals(UtilConstants.PDF_TYPE))
		{
			return new PDFFileReader();
		}
		else if(fileType.equals(UtilConstants.XLS_TYPE))
		{
			reader = new XlsReader(filePath);
			
		}
		else if(fileType.equals(UtilConstants.XLSX_TYPE))
		{
			reader = new XlsxReader(filePath);
			
		}
		else if(fileType.equals(UtilConstants.DOC_TYPE))
		{
			reader = new DocReader(filePath);
		}
		else if(fileType.equals(UtilConstants.DOCX_TYPE))
		{
			reader = new DocxReader(filePath);
		}
		else if(fileType.equals(UtilConstants.TXT_TYPE))
		{
			
			reader = new TextReader(filePath);
		}
		else{
			
			reader = null;
		}
		
		return reader;
		
	}
	

}
