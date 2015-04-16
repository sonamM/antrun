/*
 * 
 */
package com.etouch.taf.core.resources;

import com.etouch.taf.tools.rally.RallyConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class DefectParameters.
 */
public class DefectParameters {
	
	/**
	 * The Interface IDefect.
	 */
	public interface IDefect{
		
		/**
		 * Gets the param type.
		 *
		 * @return the param type
		 */
		public String getParamType();
	}
	
	/**
	 * The Enum RallyParams.
	 */
	public enum RallyParams implements IDefect{
		
		/** The Object id. */
		ObjectID(RallyConstants.OBJECTID),
		
		/** The Name. */
		Name(RallyConstants.NAME),
		
		/** The State. */
		State(RallyConstants.STATE),
		
		/** The Priority. */
		Priority(RallyConstants.PRIORITY),
		
		/** The Severity. */
		Severity(RallyConstants.SEVERITY),
		
		/** The Owner. */
		Owner(RallyConstants.OWNER),
		
		/** The Description. */
		Description(RallyConstants.DESCRIPTION),
		
		/** The State_ open. */
		State_Open(RallyConstants.STATUS_OPEN);
		
		/** The rparam. */
		private String rparam;
		
		/* (non-Javadoc)
		 * @see com.etouch.taf.core.resources.DefectParameters.IDefect#getParamType()
		 */
		public String getParamType() {
			return rparam;
		}

		/**
		 * Instantiates a new rally params.
		 *
		 * @param param the param
		 */
		RallyParams(String param){
			this.rparam = param;
		}
	}
	
//	public enum JiraParams implements IDefect{
//				
//		public String getParamType() {
//			return null;
//		}
//	}
}
