/*
 * 
 */
package com.etouch.taf.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.yaml.snakeyaml.Yaml;

import com.etouch.taf.core.config.TestBedManagerConfiguration;
import com.etouch.taf.util.CommonUtil;

// TODO: Auto-generated Javadoc
/**
 * This Class ConfigurationReader, helps to read the yaml configuration file and 
 * load the values as POJO class(TestBedManagerConfiguration)
 * It is a Singleton class.
 */
public class ConfigurationReader {

	/**
	 * Read config.
	 *
	 * @param ipStream the ip stream
	 * @return the test bed manager configuration
	 */
	public static TestBedManagerConfiguration readConfig(InputStream ipStream) {
		TestBedManagerConfiguration config = null;
		try {

			Yaml yaml = new Yaml();
			// read the config file and load it into TestBedManagerConfiguration

			config = yaml.loadAs(ipStream, TestBedManagerConfiguration.class);
			

		} catch (Throwable e) {
			System.out.println(" Error occured during file load "
					+ e.getMessage());
		}
		finally{
			// Close the ipStreams
			if(ipStream!=null){
			try {
				ipStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		}
		return config;
	}
}
