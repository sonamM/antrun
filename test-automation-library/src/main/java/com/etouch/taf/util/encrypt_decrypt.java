/*
 * 
 */
package com.etouch.taf.util;

import com.microsoft.tfs.util.base64.Base64;

// TODO: Auto-generated Javadoc
/**
 * The Class encrypt_decrypt.
 */
public class encrypt_decrypt{
	
	/**
	 * Gets the encoded value.
	 *
	 * @param value the value
	 * @return the encoded value
	 */
	public static String getEncodedValue(String value){
		String orig = value;
		 byte[] encoded = Base64.encodeBase64(orig.getBytes());
		 return new String(encoded);
	}

	/**
	 * Gets the decoded value.
	 *
	 * @param value1 the value1
	 * @return the decoded value
	 */
	public static String getDecodedValue(String value1){

	  String encoded = value1;
        byte[] decoded = Base64.decodeBase64(value1.getBytes());
       return new String(decoded);
    }


}