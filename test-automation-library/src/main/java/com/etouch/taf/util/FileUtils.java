/*
 * 
 */
package com.etouch.taf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.Log;

// TODO: Auto-generated Javadoc
/**
 * This class contains utility methods for reading property file data.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class FileUtils {
	
	/** The log. */
	private static Log log = LogUtil.getLog(FileUtils.class);

	/**
	 * Deletes the given file. If the file is a directory, recursively deletes all the files and finally deletes the directory.
	 *
	 * @param file the file
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void delete(File file) throws IOException {
		// Check if the file instance is not null
		if (null == file) {
			System.out.println("FileUtils::delete() -> Ingnoring null parameter");
			return;
		}

		System.out.println("Trying to delete file/directory "
				+ file.getAbsolutePath());

		if (file.exists()) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				// directory is empty, then delete it
				if (files.length == 0) {
					file.delete();
				} else {
					for (File tmpFile : files) {
						delete(tmpFile);
					}
				}
			} else {
				file.delete();
			}
		}
	}
	
	/**
	 * Loads a given property file into {@link Properties}.
	 *
	 * @param filePath the file path
	 * @return the properties
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties readPropertyFile(String filePath)
			throws FileNotFoundException, IOException {
		
		if (null == filePath || filePath.trim().length() == 0) {
			return null;
		}
		
		Properties props = new Properties();

		// Create the file
		File propFile = new File(filePath);

		// Load the properties
		if (propFile.isFile() && propFile.exists()) {
			System.out.println("Loading property file from "
					+ propFile.getAbsolutePath());
			props.load(new FileInputStream(propFile));
		}

		return props;

	}
	
	/**
	 * Loads the given file from class path, if exists.
	 *
	 * @param fileName the file name
	 * @return the properties
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static Properties readPropertyFileFromClassPath(String fileName)
			throws IOException {
		
		if (null == fileName || fileName.trim().length() == 0) {
			return null;
		}
		
		Properties props = new Properties();
		InputStream inStream = ClassLoader.getSystemResourceAsStream(fileName);

		if (inStream == null) {
			// Trying to load from context class loader
			inStream = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream(fileName);
		}

		props.load(inStream);
		return props;
	}
}
