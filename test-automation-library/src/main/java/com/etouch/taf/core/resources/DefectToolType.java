/*
 * 
 */
package com.etouch.taf.core.resources;

// TODO: Auto-generated Javadoc
/**
 * The Enum DefectToolType.
 */
public enum DefectToolType {
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
* Instantiates a new defect tool type.
*
* @param tool the tool
*/
DefectToolType(String tool){
this.tool = tool;
}
/**
* Checks if is supported.
*
* @param toolName the tool name
* @return true, if is supported
*/
public static boolean isSupported(String toolName){
DefectToolType[] dtList = DefectToolType.values();
for(DefectToolType dt : dtList){
if(dt.getTool().equalsIgnoreCase(toolName)){
return true;
}
}
return false;
}
}
