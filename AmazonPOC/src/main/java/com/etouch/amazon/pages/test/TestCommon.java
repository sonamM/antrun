/*
 * 
 */
package com.etouch.amazon.pages.test;


import org.testng.annotations.Test;

import com.etouch.amazon.common.BaseTest;
import com.etouch.taf.util.CommonUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class TestCommon.
 */
public class TestCommon extends BaseTest{
	
	/**
	 * Test common.
	 */
	@Test
	public void testCommon(){
		CommonUtil.sop(" Message from TestCommon");
	}

}
