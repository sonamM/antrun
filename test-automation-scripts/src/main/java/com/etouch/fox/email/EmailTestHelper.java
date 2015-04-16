package com.etouch.fox.email;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import com.etouch.taf.infra.mail.IEMailConstants;

public class EmailTestHelper {


	public List<String> retriveUrlsFromEmailBody(List<String> emailBodyContents, Properties prop)
	{

		List<String> matchedLinks = new ArrayList<String>();
		String mailLookupString = prop.getProperty(IEMailConstants.MAIL_LOOKUP_STRING);

		for(String emailBodyContent : emailBodyContents )
		{
			StringTokenizer tokens = new StringTokenizer(emailBodyContent, "<> ", false);
			while(tokens.hasMoreTokens())
			{
				String token = tokens.nextToken();
				if(token.contains(mailLookupString))
				{
					boolean addedHreftoken = false;
					String hferLinkAvailable ="";
					if(token.contains("href="))
					{
						token = token.toString().split("&amp;gt;"+mailLookupString)[0].split("href=")[1];
						String delimiter = "\"" ;
						StringTokenizer tokensinner = new StringTokenizer(token, delimiter, false);
						while(tokensinner.hasMoreTokens())
						{
							String tokeninner = tokensinner.nextToken();
							if(tokeninner.contains(mailLookupString))
							{
								addedHreftoken = true;
								hferLinkAvailable = tokeninner;
							}

						}
					}

					token = token.replaceAll("3D", "");
					if(addedHreftoken)
					{
						addedHreftoken = false;
						matchedLinks.add(hferLinkAvailable);
						break;
					}
					else
					{
						matchedLinks.add(token);
						break;
					}

				}
			}
		}


		return matchedLinks;
	}

}
