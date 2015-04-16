//package com.etouch.taf.core.datamanager.excel;
package com.etouch.taf.core.datamanager.excel;

import java.util.HashMap;

// TODO: Auto-generated Javadoc
/**
 * Read test data(Excel row) and assigned to TestParameters.
 *
 * @author eTouch
 */
public class TestParameters {
	
	/** The param map. */
	HashMap<String, String> paramMap;
	
	/**
	 * Instantiates a new test parameters.
	 */
	public TestParameters(){
		paramMap = new HashMap<String, String>();
	}
	
	/**
	 * Sets the param map.
	 *
	 * @param colName the col name
	 * @param colVal the col val
	 */
	public void setParamMap(String colName, String colVal){
		paramMap.put(colName, colVal);
	}
	
	/**
	 * Gets the param map.
	 *
	 * @return the param map
	 */
	public HashMap<String, String> getParamMap(){
		return paramMap;
	}
	
}
