/*
 * 
 */
package com.etouch.taf.infra.mail;

// TODO: Auto-generated Javadoc
/**
 * Interface for holding Email integration constants.
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public final class IEMailConstantUtil {

	
	/** The Constant MAIL_FILTER_CRITERIA. */
	public static final String MAIL_FILTER_CRITERIA="mailFilterCriteria";
	
	/** The Constant MATCH_MAIL_SUBJECT. */
	public static final String MATCH_MAIL_SUBJECT= "matchSubJectLike";
	
	/** The Constant MATCH_MAIL_TOADD. */
	public static final String MATCH_MAIL_TOADD= "matchToAddress";
	
	/** The Constant MATCH_MAIL_FROMADD. */
	public static final String MATCH_MAIL_FROMADD= "matchFromAddress";
	
	
	
	/** The Constant CRITERIA_SUBJECT_KEY. */
	public static final String CRITERIA_SUBJECT_KEY="SUBJECT";
	
	/** The Constant CRITERIA_TOADDRESS_KEY. */
	public static final String CRITERIA_TOADDRESS_KEY="TOADDRESS";
	
	/** The Constant CRITERIA_FROMADRESS_KEY. */
	public static final String CRITERIA_FROMADRESS_KEY="FROMADDRESS";
	
	
	/** The Constant READ_MAIL_BOX_NAME. */
	public static final String READ_MAIL_BOX_NAME="INBOX";
	
	/** The Constant MAIL_SERVER_PROP_NAME. */
	public static final String MAIL_SERVER_PROP_NAME="mailServerName";
	
	/** The Constant USER_NAME_PROP_NAME. */
	public static final String USER_NAME_PROP_NAME="userName";
	
	/** The Constant USER_PASSWORD_PROP_NAME. */
	public static final String USER_PASSWORD_PROP_NAME="password";
	
	/** The Constant PROTOCOL_PROP_NAME. */
	public static final String PROTOCOL_PROP_NAME="protocol";
	
	/** The Constant MAIL_LOOKUP_STRING. */
	public static final String MAIL_LOOKUP_STRING="mailLookupString";
	
	/** The Constant MAIL_REPORT_DIR. */
	public static final String MAIL_REPORT_DIR = System.getProperty("user.dir")+"\\XSLT_Reports";
	
	/** The Constant MAIL_REPORT_NAME. */
	public static final String MAIL_REPORT_NAME = System.getProperty("user.dir")+"\\email_xslt_reports.zip";
}
