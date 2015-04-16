package com.etouch.taf.core.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.etouch.taf.core.driver.web.test.ChromeDriverTest;
import com.etouch.taf.core.driver.web.test.FirefoxDriverTest;
import com.etouch.taf.core.driver.web.test.IEDriverTest;

@RunWith(Suite.class)
@SuiteClasses({ChromeDriverTest.class, FirefoxDriverTest.class, IEDriverTest.class})
public class TestSuite {

}
