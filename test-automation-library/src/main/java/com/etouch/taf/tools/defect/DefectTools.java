/*
 * 
 */
package com.etouch.taf.tools.defect;

// TODO: Auto-generated Javadoc
/**
 * The Enum DefectTools.
 */
public enum DefectTools {
	
	/** The rally. */
	RALLY("Rally"),
	
	/** The jira. */
	JIRA("Jira");
	
	/** The tool. */
	private String tool;
	
	/**
	 * Gets the tool.
	 *
	 * @return the tool
	 */
	public String getTool() {
		return tool;
	}

	/**
	 * Instantiates a new defect tools.
	 *
	 * @param tool the tool
	 */
	DefectTools(String tool){
		this.tool = tool;
	}
	
	/**
	 * Checks if is supported.
	 *
	 * @param toolName the tool name
	 * @return true, if is supported
	 */
	public static boolean isSupported(String toolName){
		DefectTools[] dtList = DefectTools.values();
		for(DefectTools dt : dtList){
			if(dt.getTool().equalsIgnoreCase(toolName)){
				return true;
			}
		}
		return false;
	}
}
