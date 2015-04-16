package com.etouch.taf.core.datamanager.txt.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.junit.Before;
import org.junit.Test;

import com.etouch.taf.core.datamanager.txt.TextReader;
import com.etouch.taf.util.LogUtil;

public class TextReaderTest {
	
	private static Log log = LogUtil.getLog(TextReaderTest.class);
	
	TextReader trd = null;
	
	@Before
	public void setup()
	{
		trd = new TextReader("C:\\Lavanya\\Project\\eTouch\\eTap_framework\\eTap_Framework_flow.txt");
	}

	@Test
	public void test() {
		if(trd!=null)
		Assert.assertNotNull(trd.readText());
	}

}
