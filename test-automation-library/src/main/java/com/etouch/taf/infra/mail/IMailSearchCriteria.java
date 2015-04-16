/*
 * 
 */
package com.etouch.taf.infra.mail;

import java.util.Properties;

import javax.mail.Message;

// TODO: Auto-generated Javadoc
/**
 * The Interface IMailSearchCriteria.
 */
public interface IMailSearchCriteria {

	/**
	 * Checks if is match.
	 *
	 * @param message the message
	 * @param prop the prop
	 * @return true, if is match
	 */
	public boolean isMatch(Message message,Properties prop);
}
