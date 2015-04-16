/*
 * 
 */
package com.etouch.taf.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.etouch.taf.util.LogUtil;
import com.etouch.taf.webui.selenium.WebPage;

// TODO: Auto-generated Javadoc
/**
 * The Class FileDownload.
 */
public class FileDownload  {

	/** The web page. */
	private WebPage webPage;
	
	/** The max wait. */
	final int MAX_WAIT = 55;
	
	/** The log. */
	static Log log = LogUtil.getLog(FileDownload.class);
	
	/** The file output stream. */
	FileOutputStream fileOutputStream = null;
	
	/** The response. */
	HttpResponse response = null;
	
	/** The file name. */
	String fileName = "tempfile";
	
	/** The output file path. */
	String outputFilePath = null;
    
	/**
	 * Download file.
	 *
	 * @param downloadUrl the download url
	 * @param filePath the file path
	 * @return the http response
	 * @throws Exception the exception
	 */
	public HttpResponse downloadFile(String downloadUrl, String filePath) throws Exception {
		
		try{
	       			
			HttpClient httpClient = HttpClientBuilder.create().build();

			//get the HTTP status of the url to check if url exists
	        HttpGet httpGet = new HttpGet(downloadUrl);
	        response = httpClient.execute(httpGet);
	        
	        System.out.println("Http Response ------> "+response);
	         
	     //   String content_disposition = response.getFirstHeader("content-disposition").getValue();
	        
	        Pattern regex = Pattern.compile("(?<=filename=\").*?(?=\")");
	     //   Matcher regexMatcher = regex.matcher(content_disposition);
	       /* if (regexMatcher.find()) {
	            fileName = regexMatcher.group();
	            System.out.println("FileName ----->" +fileName);
	        }*/
	        
	        HttpEntity entity = response.getEntity();
	        //check if entity response object is not null
	        if (entity != null) {
	        	outputFilePath = filePath+fileName;
	        	
	            //Create file object
	        	File outputFile = new File(outputFilePath);            
	            
	            //get the entity content of the file to be downloaded
	            InputStream inputStream = entity.getContent();
	            
	            //Write the entity content out to the output stream
	            fileOutputStream = new FileOutputStream(outputFile);
	            
	            System.out.println(" File Path" + outputFilePath);
	            
	            int read = 0;
	            byte[] bytes = new byte[2048];
	            
	            //start writing to output stream only if byte size is not equal to -1
	            while ((read = inputStream.read(bytes)) != -1) {
	                fileOutputStream.write(bytes, 0, read);
	                System.out.println("Writing the file contents to local directory->>>>>"+read);
	            }
		            
	            //Print the file size and content type of the downloaded file
	            System.out.println("File size is ------> " + outputFile.length() + " bytes");
        	}
		}
        catch(FileNotFoundException e) {
            System.out.println("File downloading failed!!!");
            e.printStackTrace();
        }
		finally{
			 //close the file stream after reading
            fileOutputStream.close();
			
		}
		return response;	
    }
	
	public static void main(String args[])
	{
		//String downloadUrl = "http://www.hdfcbank.com/assets/pdf/neft_rtgs_form.pdf";
		String downloadUrl = "file://localhost/C:/Lavanya/Project/eTouch/eTap_framework/emp1.xls";
		String filePath = "C:\\Lavanya\\Project\\eTouch\\eTap_framework\\FileDownload\\";
		try{
		HttpResponse response = new FileDownload().downloadFile(downloadUrl, filePath);
		System.out.println(response.getEntity().getContentType().getValue());
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}