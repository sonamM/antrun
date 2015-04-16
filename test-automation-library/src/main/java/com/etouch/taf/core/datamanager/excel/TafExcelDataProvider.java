/*
 * 
 */
package com.etouch.taf.core.datamanager.excel;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.etouch.taf.core.datamanager.excel.annotations.IExcelDataFiles;
import com.etouch.taf.core.datamanager.excel.annotations.ITafExcelDataProviderInputs;
import com.etouch.taf.core.exception.TafDataProviderException;
import com.etouch.taf.util.ExcelUtil;
import com.etouch.taf.util.LogUtil;

// TODO: Auto-generated Javadoc
/**
 * TafExcelDataProvider reads data from Excel based on file,sheet and data key.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class TafExcelDataProvider {
	
	/** The log. */
	private static Log log = LogUtil.getLog(TafExcelDataProvider.class);
	
	/** The Constant EQUALS_TO_SIGN. */
	private static final String EQUALS_TO_SIGN = "=";

	/**
	 * Gets the data from file.
	 *
	 * @param testMethod the test method
	 * @return the data from file
	 * @throws TafDataProviderException the taf data provider exception
	 */
	@DataProvider(name="tafDataProvider")
	public static Object[][] getDataFromFile(Method testMethod) throws TafDataProviderException {
		// Construct TestDataKey from the Method
		TestDataKey testDataKey = constructTestDataKey(testMethod);
		
		// Check if the TestDataContainer already has an entry and load test data for all the methods in that class
		if(!TestDataContainer.getInstance().hasTestData(testDataKey)){
			// Synchronize it on the class as we plan to load it the very first time the data provider is called from a test class 
			synchronized (testMethod.getDeclaringClass()) {
				if(!TestDataContainer.getInstance().hasTestData(testDataKey)){
					readTestData(testMethod.getDeclaringClass());					
				} 
			}
		} 
		Object[][] obj = TestDataContainer.getInstance().getTestData(testDataKey);
		return TestDataContainer.getInstance().getTestData(testDataKey);
		
//		return new Object[][]{
//			{new TestParameters("testurl", "testid", "projid", "storyid", "defectName", "defectSeverity", "defectOwner", "defectNotes")}	
//		};
	}

	/**
	 * Construct test data key.
	 *
	 * @param testMethod the test method
	 * @return the test data key
	 */
	private static TestDataKey constructTestDataKey(Method testMethod){		
		// Resolve annotation
		ITafExcelDataProviderInputs dataProviderInputs = testMethod.getAnnotation(ITafExcelDataProviderInputs.class);
		
		if (dataProviderInputs == null){
			throw new IllegalArgumentException(
					"Test Method has no TafExcelDataProviderInputs annotation.");
		}
		
		if (dataProviderInputs.excelFile() == null || dataProviderInputs.excelsheet() == null || dataProviderInputs.dataKey() == null){
			throw new IllegalArgumentException(
					"Test Method has a malformed TafExcelDataProviderInputs annotation.");
		}		
		
		// Construct data key after trimming any white spaces
		TestDataKey testDataKey = new TestDataKey(dataProviderInputs.excelFile().trim(), dataProviderInputs.excelsheet().trim(), dataProviderInputs.dataKey().trim());
		
		return testDataKey;
	}
	
	/**
	 * Loads all the test data associated with the test class and keeps it in
	 * {@link TestDataContainer}, when the very first call to the data provider
	 * is made from any of the test methods.
	 * 
	 * Test data files, sheets are read from {@link ExcelDataFiles} annotation
	 * and
	 *
	 * @param callingTestClass the calling test class
	 * @throws TafDataProviderException the taf data provider exception
	 */
	private static void readTestData(Class<?> callingTestClass) throws TafDataProviderException {

		// Resolve the files from 
		resolveExcelFiles(callingTestClass);
		
		List<TestDataKey> testKeyList = collectAllTestMethodsAndPrepareTestKeys(callingTestClass);
		
		// Go through each file and create test data key list - Each sheet is
		// expected to have "key list" defined.. Convert the given keys to
		// TestDataKey Object {<filename>-<sheetname>-<datakey>}
		for(TestDataKey testDataKey:testKeyList){
			String filePath = TestDataContainer.getInstance().getDataFile(testDataKey.getDataFileName());
			TestParameters[][] testDataChunk = ExcelUtil.readExcelDataParams(filePath, testDataKey.getDataSheetName(), testDataKey.getDataKey());
			TestDataContainer.getInstance().addTestData(testDataKey, testDataChunk);
		}	
	}
	
	/**
	 * Collect all test methods and prepare test keys.
	 *
	 * @param declaringClass the declaring class
	 * @return the list
	 */
	private static List<TestDataKey> collectAllTestMethodsAndPrepareTestKeys(Class<?> declaringClass) {
		List<TestDataKey> testKeyList = new ArrayList<TestDataKey>();
		for (Method method : declaringClass.getMethods()) {
			// Filer only the testng Test methods that use Taf Data Provider
			if (method.isAnnotationPresent(Test.class)
					&& method
							.isAnnotationPresent(ITafExcelDataProviderInputs.class)) {
				testKeyList.add(constructTestDataKey(method));
			}
		}
		return testKeyList;
	}

	/**
	 * Resolves the class level annotation {@link ExcelDataFiles}.
	 *
	 * @param callingTestClass the calling test class
	 * @throws TafDataProviderException the taf data provider exception
	 */
	private static void resolveExcelFiles(Class<?> callingTestClass)
			throws TafDataProviderException {

		// Get the declaring class to find the excel files
		IExcelDataFiles excelFilesArg = callingTestClass.getAnnotation(IExcelDataFiles.class);
		
		// Perform validation
		if (excelFilesArg == null){
			throw new IllegalArgumentException(
					"Test Class has no ExcelDataFiles annotation.");
		}
		
		if (excelFilesArg.excelDataFiles() == null || excelFilesArg.excelDataFiles().length == 0){
			throw new IllegalArgumentException(
					"Test Class has a malformed ExcelDataFiles annotation.");
		}
		
		// Resolve files and sheets to a Map		
		for (String excelFileInfo:excelFilesArg.excelDataFiles()) {
			String[] excel = excelFileInfo.split(EQUALS_TO_SIGN);

			if (excel.length > 2
					|| excel.length < 0) {
				throw new IllegalArgumentException(
						"Test Class has a malformed ExcelDataFiles annotation.");

			}
			
			// TODO: Prefix class name with file key to maintain uniqueness
			if(!TestDataContainer.getInstance().hasDataFile(excel[0])){
				synchronized (callingTestClass) {
					if(!TestDataContainer.getInstance().hasDataFile(excel[0])){
						TestDataContainer.getInstance().addDataFile(excel[0], excel[1]);
					}
				}
			}
		}
	}

}
