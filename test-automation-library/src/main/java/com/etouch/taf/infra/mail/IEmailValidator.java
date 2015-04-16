/*
 * 
 */
package com.etouch.taf.infra.mail;

import java.util.List;
import java.util.Properties;

import com.etouch.taf.core.exception.ValidationException;


// TODO: Auto-generated Javadoc
/**
 * EmailValidator Interface exposes API to integrate with Mails.
 * 
 * 
 * Important Properties
 * Allowed values are SUBJECT,TOADDRESS,FROMADDRESS
 * mailFilterCriteria=FROMADDRESS
 *
 * if mailFilterCriteria is used as SUBJECT use the below parameter to
 * search a text on the subject
 * matchSubJectLike=Gmail
 *
 * if mailFilterCriteria is used as FROMADDRESS
 * matchFromAddress=mail-noreply@google.com
 *
 * if mailFilterCriteria is used as TOADDRESS
 * matchToAddress=testautomationmails@gmail.com
 * 
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */

public interface IEmailValidator {

	/**
	 * valiteEmail does the following
	 * 
	 * 1. First groups all the mail messages from the INBOX where the criteria is matched.
	 * 2. Retrive the body content of each email
	 * 2. Then inspects the email body for the text data which is passed thru "mailLookupString"
	 * 3. If the text data is found on all the grouped mail from step 1 then retruns TRUE or FLASE.
	 *
	 * @param props the props
	 * @return true, if successful
	 * @throws ValidationException the validation exception
	 */
	public boolean validateEmail(Properties props) throws ValidationException ;
	
	
	/**
	 * retriveEmailBodyContentFromMessages does the following
	 * 
	 * 1. First groups all the mail messages from the INBOX where the criteria is matched.
	 * 2. Retrive the body content of each email
	 * 3. Return all the mail body content in List.
	 *
	 * @param props the props
	 * @return the list
	 * @throws ValidationException the validation exception
	 */
	
	public List<String> retriveEmailBodyContentFromMessages(Properties props) throws ValidationException ;
}
