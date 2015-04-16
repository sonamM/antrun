/*
 * 
 */
package com.etouch.taf.tools.defect;

import com.etouch.taf.core.resources.DefectParameters;
import com.etouch.taf.tools.rally.RallyConstants;
import com.etouch.taf.tools.rally.RequestInfo;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDefectManager.
 */
public interface IDefectManager {
	
	/**
	 * Creates the defect builder.
	 *
	 * @param defName the def name
	 * @param testcaseId the testcase id
	 * @param workspaceId the workspace id
	 * @param projId the proj id
	 * @param DefSeverity the def severity
	 * @param DefOwner the def owner
	 * @param DefNotes the def notes
	 * @param storyId the story id
	 */
	
	public void createDefectBuilder(String defName, String testcaseId, String workspaceId, String projId, String DefSeverity,
			String DefOwner, String DefNotes, String storyId, String attachmentPath);
	
	//added for updating testcase result - create a new abstract class to add testcase related
	/**
	 * Update test case result.
	 *
	 * @param defName the def name
	 * @param testcaseId the testcase id
	 * @param workspaceId the workspace id
	 * @param projId the proj id
	 * @param DefSeverity the def severity
	 * @param DefOwner the def owner
	 * @param DefNotes the def notes
	 * @param storyId the story id
	 */
	public void updateTestCaseResult(String defName, String testcaseId, String workspaceId, String projId, String DefSeverity,
			String DefOwner, String DefNotes, String storyId);
	
	/**
	 * Verify defect exists.
	 *
	 * @param testcaseId the testcase id
	 * @param projId the proj id
	 * @param storyId the story id
	 * @param defName the def name
	 * @return true, if successful
	 */
	public boolean verifyDefectExists(String testcaseId, String projId, String storyId, String defName);
	
	/**
	 * Verify ifdefect closed.
	 *
	 * @return true, if successful
	 */
	public boolean verifyIfdefectClosed();
	
	/**
	 * Reopen defect.
	 */
	public void reopenDefect();
	
	/**
	 * Gets the defect status.
	 *
	 * @return the defect status
	 */
	public String getDefectStatus();
		
	/**
	 * Query defect id.
	 *
	 * @param testcaseId the testcase id
	 * @param storyId the story id
	 * @param projId the proj id
	 * @param defName the def name
	 * @return the string
	 */
	public String queryDefectID(String testcaseId, String storyId, String projId, String defName);
	
	/**
	 * Query defect status.
	 *
	 * @param testcaseId the testcase id
	 * @param storyId the story id
	 * @param projId the proj id
	 * @param defName the def name
	 * @return the string
	 */
	public String queryDefectStatus(String testcaseId, String storyId, String projId, String defName);
	
	// generic method to Update/set any of the defect field/attribute
	/**
	 * Update defect.
	 *
	 * @param testcaseId the testcase id
	 * @param projId the proj id
	 * @param storyId the story id
	 * @param defName the def name
	 * @param updateKey the update key
	 * @param updateValue the update value
	 * @return true, if successful
	 */
	public boolean updateDefect(String testcaseId, String projId, String storyId, String defName, DefectParameters.IDefect updateKey, String updateValue);
	//generic method to Query/retrieve any defect field/attribute
	/**
	 * Query defect.
	 *
	 * @param testcaseId the testcase id
	 * @param storyId the story id
	 * @param projId the proj id
	 * @param defName the def name
	 * @param queryByParam the query by param
	 * @return the string
	 */
	public String queryDefect(String testcaseId, String storyId, String projId, String defName, DefectParameters.IDefect queryByParam);	
	
	//jira
	/**
	 * Creates the a jira defect builder.
	 *
	 * @param url the url
	 * @param issueUrl the issue url
	 * @param username the username
	 * @param password the password
	 * @param keys the keys
	 */
	public void createAJiraDefectBuilder(String url, String issueUrl,String username, String password, String keys);	

	
}
