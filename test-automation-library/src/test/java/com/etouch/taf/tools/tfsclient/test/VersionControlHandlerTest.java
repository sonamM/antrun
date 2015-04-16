package com.etouch.taf.tools.tfsclient.test;

import static org.junit.Assert.*;

import java.io.File;

import junit.framework.Assert;

import com.etouch.taf.core.TestBed;
import com.etouch.taf.core.TestBedManager;
import com.etouch.taf.core.config.TFSConfig;
import com.etouch.taf.core.driver.web.test.ChromeDriverTest;
import com.etouch.taf.core.test.util.TafTestUtil;
import com.etouch.taf.tools.tfsclient.VersionControlHandler;
import com.etouch.taf.util.LogUtil;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class VersionControlHandlerTest {
	
	private static Log log = LogUtil.getLog(VersionControlHandlerTest.class);
	private static TFSConfig tfsConfig = null;
	
	@Before
	public void setUp()
	{

		TafTestUtil.initialize();		
		tfsConfig = TestBedManager.INSTANCE.getTFSConfig();		
	}	

	@Test
	public void test() {
		try
		{
			VersionControlHandler.cloneProjectFromTFS();
			boolean isCloned = TafTestUtil.checkFolderExists(tfsConfig.getMappingLocalPath());
			Assert.assertTrue(isCloned);
		}catch(Exception ex)
		{
			log.error(ex.getMessage());
			ex.printStackTrace();
		}
	}	

}
