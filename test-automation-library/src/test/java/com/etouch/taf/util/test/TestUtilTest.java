package com.etouch.taf.util.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.junit.Test;

import com.etouch.taf.tools.tfsclient.test.VersionControlHandlerTest;
import com.etouch.taf.util.LogUtil;
import com.etouch.taf.util.TestUtil;

public class TestUtilTest {	
	private static Log log = LogUtil.getLog(TestUtilTest.class);

	@Test
	public void testPickConfigFile() {
		String env = "stage";
		String configFileName = TestUtil.pickConfigFile(env);
		try{
			Assert.assertEquals("stageConfig.yml", configFileName);			
		}catch(AssertionError e)
		{
			log.error(e.getMessage());
		}
	}
	
	@Test
	public void testEmptyCnfigFile() {
		String env = "";
		String configFileName = TestUtil.pickConfigFile(env);
		try{
			Assert.assertEquals("devConfig.yml", configFileName);			
		}catch(AssertionError e)
		{
			log.error(e.getMessage());
		}
	}
	
	@Test
	public void testNullConfigFile() {
		String env = null;
		String configFileName = TestUtil.pickConfigFile(env);
		try{
			Assert.assertEquals("devConfig.yml", configFileName);			
		}catch(AssertionError e)
		{
			log.error(e.getMessage());
		}
	}

}
