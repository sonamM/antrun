/*
 * 
 */
package com.etouch.taf.infra.mail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.search.FlagTerm;

import org.apache.commons.logging.Log;

import com.etouch.taf.core.exception.ValidationException;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * EmailValidator exposes API to integrate with Mails.
 * 
 * 
 * 
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */

public class EmailValidator implements IEmailValidator
{

	/** The log. */
	private static Log log = LogUtil.getLog(EmailValidator.class);

	/**
	 * Read the mail box for a given user and return a list of Messages 
	 * based on the matched filter criteria.
	 *
	 * @param props the props
	 * @return the message[]
	 * @throws Exception the exception
	 */

	public Message[] readMail(Properties props) throws Exception
	{


		String mailServerName = props.getProperty(IEMailConstants.MAIL_SERVER_PROP_NAME);
		String userName = props.getProperty(IEMailConstants.USER_NAME_PROP_NAME);
		String password = props.getProperty(IEMailConstants.USER_PASSWORD_PROP_NAME);
		String protocol = props.getProperty(IEMailConstants.PROTOCOL_PROP_NAME);

		log.info(IEMailConstants.MAIL_SERVER_PROP_NAME +" --> "+mailServerName);
		log.info(IEMailConstants.USER_NAME_PROP_NAME +" --> "+userName);
		log.info(IEMailConstants.USER_PASSWORD_PROP_NAME +" --> "+password);
		log.info(IEMailConstants.PROTOCOL_PROP_NAME +" --> "+protocol);

		Session session = Session.getDefaultInstance(new Properties(),null);
		Store store = session.getStore(protocol); 

		store.connect(mailServerName, userName,password);

		/*Folder folder = store.getFolder(IEMailConstants.READ_MAIL_BOX_NAME);
		folder.open(Folder.READ_WRITE);*/
		
		Folder inbox = store.getFolder("INBOX");
		inbox.open(Folder.READ_WRITE);
		
		IMailSearchCriteria criterria = getMailSearcher(props);
		Message[] messages = null;
		
		messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
		List<Message> messageList = new ArrayList<Message>();
		
		for(Message mail : messages)
		{
			if(criterria.isMatch(mail, props))
			{
				messageList.add(mail);
			}

		}
		
		// Convert to MimeMessage after search 
		/*messages = (MimeMessage[]) carpetaInbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));
		for (int i = 0 ; i< messages.length ; i++){
		    // Create a new message using MimeMessage copy constructor
		    MimeMessage cmsg = new MimeMessage(messages[i]);
		    // Use this message to read its contents 
		    Object obj = cmsg.getContent(); 
		// ....
		}*/

		System.out.println("Total Message:" + inbox.getMessageCount());
		System.out.println("Unread Message:" + inbox.getUnreadMessageCount());

		/*List<Message> messageList = new ArrayList<Message>();
		IMailSearchCriteria criterria = getMailSearcher(props);
		Message[]  messages=null;
		for(Message mail : folder.getMessages())
		{
			if(criterria.isMatch(mail, props))
			{
				messageList.add(mail);
			}

		}*/
		Message[] mails = messageList.toArray(new Message[messageList.size()]);

		return mails;
	}
	
	/**
	 * Read mail through smtp.
	 *
	 * @param props the props
	 * @return the message[]
	 * @throws Exception the exception
	 */
	public Message[] readMailThroughSMTP(Properties props) throws Exception
	{


		String mailServerName = props.getProperty(IEMailConstants.MAIL_SERVER_PROP_NAME);
		String userName = props.getProperty(IEMailConstants.USER_NAME_PROP_NAME);
		String password = props.getProperty(IEMailConstants.USER_PASSWORD_PROP_NAME);
		String protocol = props.getProperty(IEMailConstants.PROTOCOL_PROP_NAME);

		log.info(IEMailConstants.MAIL_SERVER_PROP_NAME +" --> "+mailServerName);
		log.info(IEMailConstants.USER_NAME_PROP_NAME +" --> "+userName);
		log.info(IEMailConstants.USER_PASSWORD_PROP_NAME +" --> "+password);
		log.info(IEMailConstants.PROTOCOL_PROP_NAME +" --> "+protocol);
		
		Properties smtpProps = new Properties();
		//smtpProps.setProperty("mail.smtp.host", "smtp.gmail.com");
		smtpProps.setProperty("mail.smtp.host", mailServerName);
		smtpProps.setProperty("mmail.smtp.socketFactory.port","465");//465
		smtpProps.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		smtpProps.setProperty("mail.smtp.auth","true");
		smtpProps.setProperty("mail.smtp.port","465");//465

		Session session = Session.getDefaultInstance(smtpProps,null);
		
		Transport transport = session.getTransport(protocol);
		
		transport.connect(mailServerName, 25, userName, password);
		Store store = session.getStore("imaps"); 
		
		//store.connect("mailhost.ihs.com","ULD49133","Monday123");
		store.connect(mailServerName,userName,password);

		Folder folder = store.getFolder(IEMailConstants.READ_MAIL_BOX_NAME);
		folder.open(Folder.READ_WRITE);

		//System.out.println("Total Message:" + folder.getMessageCount());
		//System.out.println("Unread Message:" + folder.getUnreadMessageCount());

		List<Message> messageList = new ArrayList<Message>();
		IMailSearchCriteria criterria = getMailSearcher(props);
		Message[]  messages=null;
		for(Message mail : folder.getMessages())
		{
			if(criterria.isMatch(mail, props))
			{
				messageList.add(mail);
			}

		}
		messages = messageList.toArray(new Message[messageList.size()]);

		return messages;
	}	
	

	/**
	 * Validate mail messages.
	 *
	 * @param messages the messages
	 * @param props the props
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean validateMailMessages(Message[]  messages,Properties props) throws Exception
	{
		boolean isMailFound = false;
		boolean result = true;
		if(messages.length > 0)
			isMailFound = true;

		if (!isMailFound) {
			log.error("NO EMAILS TO READ");
			throw new Exception("Could not find any mail");

		} 
		else 
		{
			for (Message mail : messages)
			{
				StringBuffer buffer = new StringBuffer();

				buffer = readMailContents(mail);

				if(!inspectMail(buffer,props))
				{
					log.error("EMAIL NOT CONTAINTING THE REQUIRED TEXT");
					result = false;
					break;
				}

			}
		}
		return result;
	}

	/**
	 * Read mail contents.
	 *
	 * @param mail the mail
	 * @return the string buffer
	 * @throws Exception the exception
	 */
	private StringBuffer readMailContents(Message mail) throws Exception
	{
		StringBuffer buffer = new StringBuffer();
		String line;
		BufferedReader reader = new BufferedReader(new InputStreamReader(mail.getInputStream()));

		while ((line = reader.readLine()) != null)
		{
			buffer.append(line+" ");
		}


		return buffer;
	}

	/**
	 * Inspect mail.
	 *
	 * @param mailContent the mail content
	 * @param props the props
	 * @return true, if successful
	 */
	public boolean inspectMail(StringBuffer mailContent,Properties props)
	{

		boolean result = false;

		String mailLookupString = props.getProperty(IEMailConstants.MAIL_LOOKUP_STRING);

		if(mailContent.toString().contains(mailLookupString))
			result = true;

		return result;
	}

	/**
	 * Gets the mail searcher.
	 *
	 * @param props the props
	 * @return the mail searcher
	 */
	public IMailSearchCriteria getMailSearcher(Properties props)
	{
		return MailSearchCriteriaFactory.getMailSearchCrieteria(props);

	}

	/* (non-Javadoc)
	 * @see com.etouch.taf.infra.mail.IEmailValidator#validateEmail(java.util.Properties)
	 */
	public boolean validateEmail(Properties props) throws ValidationException {
		// TODO Auto-generated method stub
		boolean result=false;
		try
		{

			Message[]  messages = readMail(props);

			result = validateMailMessages(messages, props);

		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ValidationException("Mail Validation failed");
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see com.etouch.taf.infra.mail.IEmailValidator#retriveEmailBodyContentFromMessages(java.util.Properties)
	 */
	public List<String> retriveEmailBodyContentFromMessages(Properties props)
			throws ValidationException {
		List<String> matchedLinks = new ArrayList<String>();
		try
		{
			Message[]  messages = readMail(props);
			matchedLinks= retriveEmailBodyContentFromMessages(messages, props);

		}catch(Exception e)
		{
			e.printStackTrace();
			throw new ValidationException("Mail Validation failed");
		}
		return matchedLinks;
	}


	/**
	 * Retrive email body content from messages.
	 *
	 * @param messages the messages
	 * @param prop the prop
	 * @return the list
	 * @throws Exception the exception
	 */
	private List<String> retriveEmailBodyContentFromMessages(Message[]  messages , Properties prop) throws Exception{

		List<String> emailBodyContent = new ArrayList<String>();
		boolean isMailFound = false;

		if(messages.length > 0)
			isMailFound = true;

		if (!isMailFound) {
			throw new Exception("Could not find any mail");

		} 
		else 
		{
			for (Message mail : messages)
			{
				StringBuffer buffer = new StringBuffer();
				buffer = readMailContents(mail);
				emailBodyContent.add(buffer.toString());

			}
		}
		return emailBodyContent;
	}

}
