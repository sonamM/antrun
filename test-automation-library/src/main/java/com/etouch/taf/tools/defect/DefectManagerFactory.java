/*
 * 
 */
package com.etouch.taf.tools.defect;

import org.apache.commons.logging.Log;

import com.etouch.taf.core.exception.DefectException;
import com.etouch.taf.tools.jira.Jira;
import com.etouch.taf.tools.jira.JiraConstants;
import com.etouch.taf.tools.jira.JiraInfo;
import com.etouch.taf.tools.rally.RallyConstants;
import com.etouch.taf.tools.rally.RallyInfo;
import com.etouch.taf.tools.rally.Rally;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating DefectManager objects.
 */
public class DefectManagerFactory {
	
	/** The log. */
	static Log log = LogUtil.getLog(DefectManagerFactory.class);

	/**
	 * Manage defect.
	 *
	 * @param defect the defect
	 * @return the i defect manager
	 * @throws DefectException the defect exception
	 */
	public static IDefectManager manageDefect(String defect) throws DefectException {
		
		if(defect.equalsIgnoreCase(DefectTools.RALLY.getTool())){
			RallyInfo rInfo = new RallyInfo(RallyConstants.RALLYURL, RallyConstants.RALLYUSERNAME, RallyConstants.RALLYPASSWD, RallyConstants.RALLYAPP);
			try {
				return new Rally(rInfo);
			} catch (DefectException e) {
				log.error(e.getMessage());
				throw new DefectException(e.getMessage());
			}
		}else if(defect.equals(DefectTools.JIRA.getTool())){
			JiraInfo jInfo = new JiraInfo(JiraConstants.CREATE_ISSUE_URL, JiraConstants.USERNAME,JiraConstants.PASSWORD);
			try{
				System.out.println("the values returned are:");
				System.out.println("logging defect in jira");
				return new Jira(jInfo);
			}catch (Exception e){
				log.error(e.getMessage());
			}
		
		return null;
		}
		return null;
	}

}
