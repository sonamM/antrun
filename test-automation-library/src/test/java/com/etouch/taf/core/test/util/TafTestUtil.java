package com.etouch.taf.core.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;

import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.core.exception.DriverException;
import com.etouch.taf.util.CommonUtil;
import com.etouch.taf.util.LogUtil;

public class TafTestUtil {	
	
	static Log log=LogUtil.getLog(TafTestUtil.class);
	
	public static void initialize(){
    	CommonUtil.sop(" On initialize");    	
 
    	String configFileName = "..\\test-automation-library\\src\\test\\resources\\testConfig.yml";
  
    	InputStream in=null;
    	String[] tArray  = {"",""};
		try{
			in = convertFileToInputStream(configFileName);
			CommonUtil.sop(" Dev config file input stream is ready");
		} catch (DriverException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			TestBedManager.INSTANCE.setConfig(in,tArray);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			log.error(e1.getMessage());
			e1.printStackTrace();
		} 
		finally
		{
			try{
				if(in!=null)
					in.close();
			}
			catch(IOException iex)
			{
				log.error(iex.getMessage());
			}
					
		}
		
		//TestBedManager.INSTANCE.executeTestNG();
    }
	
	/**
	 * This method helps to convert from file to InputStream
	 * @param fileName
	 * @return
	 * @throws DriverException
	 */
	 
	private static InputStream convertFileToInputStream(String fileName) throws DriverException
	{
		InputStream ipStream=null;
		if(fileName != null){
			
			try {
				ipStream = new FileInputStream(new File(fileName));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			log.error(" File name is null - " + fileName);
			throw new DriverException(
					"failed to read profile configuration/TestNG, file name is missing");
		}
		return ipStream;
	}
	
	/*
	 * This method checks if the input directory exists or not.
	 */
	public static boolean checkFolderExists(String directory) {
	    File dir = new File(directory);
	    File[] dir_contents = dir.listFiles();
	    if(dir_contents!=null && dir_contents.length >0)
	    	return true;
	    else
	    	return false;	    
	}
}



