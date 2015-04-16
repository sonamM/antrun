package com.etouch.taf.core.datamanager.txt;

import java.io.BufferedReader;
import java.io.FileReader;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;

public class TextReader {
	
	private static Log log = LogUtil.getLog(TextReader.class);
	
	String filePath = null;
	
	public TextReader(String filePath)
	{
		this.filePath = filePath;
	}
	
	public String readText()
	{
		String fileText = null;
		BufferedReader br = null;
		try{
			br = new BufferedReader(new FileReader(filePath));
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();	
	        while (line != null) {
	            sb.append(line);
	            sb.append(System.getProperty("line.separator"));
	            line = br.readLine();
	        }
	        fileText = sb.toString();
	    }catch(Exception ex)
	    {
	    	log.error(ex.getMessage());
	    }
		finally
		{
			try{
				if(br!=null)
					br.close();
			}catch(Exception ex)
			{
				log.error(ex.getMessage());
			}
		}
		
		return fileText;
	}
	public static void main(String args[])
	{
		System.out.println(new TextReader("C:\\Lavanya\\Project\\eTouch\\eTap_framework\\eTap_Framework_flow.txt").readText());
	}
	
}
