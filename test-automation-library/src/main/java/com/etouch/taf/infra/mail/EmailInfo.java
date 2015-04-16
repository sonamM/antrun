//package com.etouch.taf.infra.mail;

package com.etouch.taf.infra.mail;

import org.apache.commons.logging.Log;

import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * 
 * EmailInfo object carries email information including sender / recipients details.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class EmailInfo {
	
	/** The log. */
	static Log log = LogUtil.getLog(EmailInfo.class);
	
	/** The user name. */
	String userName = null;
	
	/** The pass word. */
	String passWord = null;
	
	/** The host. */
	String host = null;
	
	/** The port. */
	String port = null;
	
	/** The starttls. */
	String starttls = null; 
	
	/** The auth. */
	String auth = null; 
	
	/** The debug. */
	boolean debug = false; 
	
	/** The socket factory class. */
	String socketFactoryClass = null;
	
	/** The fallback. */
	String fallback = null;
	
	/** The from. */
	String from = null;
	
	/** The to. */
	String[] to = null;
	
	/** The cc. */
	String[] cc = null;
	
	/** The bcc. */
	String[] bcc = null;
	
	/** The subject. */
	String subject = null; 
	
	/** The text. */
	String text = null;
	
	/** The attachment path. */
	String attachmentPath = null;
	
	/** The attachment name. */
	String attachmentName = null;
	
	/**
	 * Gets the user name.
	 *
	 * @return the user name
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * Sets the user name.
	 *
	 * @param userName the new user name
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * Gets the pass word.
	 *
	 * @return the pass word
	 */
	public String getPassWord() {
		return passWord;
	}
	
	/**
	 * Sets the pass word.
	 *
	 * @param passWord the new pass word
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	/**
	 * Gets the host.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}
	
	/**
	 * Sets the host.
	 *
	 * @param host the new host
	 */
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * Gets the port.
	 *
	 * @return the port
	 */
	public String getPort() {
		return port;
	}
	
	/**
	 * Sets the port.
	 *
	 * @param port the new port
	 */
	public void setPort(String port) {
		this.port = port;
	}
	
	/**
	 * Gets the starttls.
	 *
	 * @return the starttls
	 */
	public String getStarttls() {
		return starttls;
	}
	
	/**
	 * Sets the starttls.
	 *
	 * @param starttls the new starttls
	 */
	public void setStarttls(String starttls) {
		this.starttls = starttls;
	}
	
	/**
	 * Gets the auth.
	 *
	 * @return the auth
	 */
	public String getAuth() {
		return auth;
	}
	
	/**
	 * Sets the auth.
	 *
	 * @param auth the new auth
	 */
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	/**
	 * Checks if is debug.
	 *
	 * @return true, if is debug
	 */
	public boolean isDebug() {
		return debug;
	}
	
	/**
	 * Sets the debug.
	 *
	 * @param debug the new debug
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}
	
	/**
	 * Gets the socket factory class.
	 *
	 * @return the socket factory class
	 */
	public String getSocketFactoryClass() {
		return socketFactoryClass;
	}
	
	/**
	 * Sets the socket factory class.
	 *
	 * @param socketFactoryClass the new socket factory class
	 */
	public void setSocketFactoryClass(String socketFactoryClass) {
		this.socketFactoryClass = socketFactoryClass;
	}
	
	/**
	 * Gets the fallback.
	 *
	 * @return the fallback
	 */
	public String getFallback() {
		return fallback;
	}
	
	/**
	 * Sets the fallback.
	 *
	 * @param fallback the new fallback
	 */
	public void setFallback(String fallback) {
		this.fallback = fallback;
	}
	
	/**
	 * Gets the from.
	 *
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	
	/**
	 * Sets the from.
	 *
	 * @param from the new from
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * Gets the to.
	 *
	 * @return the to
	 */
	public String[] getTo() {
		return to;
	}
	
	/**
	 * Sets the to.
	 *
	 * @param to the new to
	 */
	public void setTo(String[] to) {
		this.to = to;
	}
	
	/**
	 * Gets the cc.
	 *
	 * @return the cc
	 */
	public String[] getCc() {
		return cc;
	}
	
	/**
	 * Sets the cc.
	 *
	 * @param cc the new cc
	 */
	public void setCc(String[] cc) {
		this.cc = cc;
	}
	
	/**
	 * Gets the bcc.
	 *
	 * @return the bcc
	 */
	public String[] getBcc() {
		return bcc;
	}
	
	/**
	 * Sets the bcc.
	 *
	 * @param bcc the new bcc
	 */
	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}
	
	/**
	 * Gets the subject.
	 *
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	
	/**
	 * Sets the subject.
	 *
	 * @param subject the new subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	
	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}
	
	/**
	 * Gets the attachment path.
	 *
	 * @return the attachment path
	 */
	public String getAttachmentPath() {
		return attachmentPath;
	}
	
	/**
	 * Sets the attachment path.
	 *
	 * @param attachmentPath the new attachment path
	 */
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
	/**
	 * Gets the attachment name.
	 *
	 * @return the attachment name
	 */
	public String getAttachmentName() {
		return attachmentName;
	}
	
	/**
	 * Sets the attachment name.
	 *
	 * @param attachmentName the new attachment name
	 */
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

}
