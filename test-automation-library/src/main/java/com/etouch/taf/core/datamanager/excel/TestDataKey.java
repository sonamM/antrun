/*
 * 
 */
package com.etouch.taf.core.datamanager.excel;

import java.util.Map;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * 
 * Class to store excel data file name, sheet name and data key. Objects of this
 * class are to be used as the "KEY" for the elements added to {@link Map} in
 * {@link TestDataContainer}
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
public class TestDataKey {
	
	/** The log. */
	private static Log log = LogUtil.getLog(TestDataKey.class);
	
	/** The data file name. */
	private String dataFileName;
	
	/** The data sheet name. */
	private String dataSheetName;
	
	/** The data key. */
	private String dataKey;

	/**
	 * Instantiates a new test data key.
	 *
	 * @param dataFileName the data file name
	 * @param dataSheetName the data sheet name
	 * @param dataKey the data key
	 */
	public TestDataKey(String dataFileName, String dataSheetName, String dataKey) {
		super();
		this.dataFileName = dataFileName;
		this.dataSheetName = dataSheetName;
		this.dataKey = dataKey;
	}

	/**
	 * Gets the data file name.
	 *
	 * @return the data file name
	 */
	public String getDataFileName() {
		return dataFileName;
	}

	/**
	 * Gets the data sheet name.
	 *
	 * @return the data sheet name
	 */
	public String getDataSheetName() {
		return dataSheetName;
	}

	/**
	 * Gets the data key.
	 *
	 * @return the data key
	 */
	public String getDataKey() {
		return dataKey;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dataFileName == null) ? 0 : dataFileName.hashCode());
		result = prime * result + ((dataKey == null) ? 0 : dataKey.hashCode());
		result = prime * result
				+ ((dataSheetName == null) ? 0 : dataSheetName.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestDataKey other = (TestDataKey) obj;
		if (dataFileName == null) {
			if (other.dataFileName != null)
				return false;
		} else if (!dataFileName.equals(other.dataFileName))
			return false;
		if (dataKey == null) {
			if (other.dataKey != null)
				return false;
		} else if (!dataKey.equals(other.dataKey))
			return false;
		if (dataSheetName == null) {
			if (other.dataSheetName != null)
				return false;
		} else if (!dataSheetName.equals(other.dataSheetName))
			return false;
		return true;
	}

}
