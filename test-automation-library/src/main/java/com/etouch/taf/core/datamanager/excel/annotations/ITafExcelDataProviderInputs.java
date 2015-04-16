/*
 * 
 */
package com.etouch.taf.core.datamanager.excel.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO: Auto-generated Javadoc
/**
 * Annotation to be used with each test method to denote excel file, excel sheet
 * and data key of test data needed for that method.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ITafExcelDataProviderInputs {
	
	/**
	 * Excel file.
	 *
	 * @return the string
	 */
	String excelFile();
	
	/**
	 * Excelsheet.
	 *
	 * @return the string
	 */
	String excelsheet();
	
	/**
	 * Data key.
	 *
	 * @return the string
	 */
	String dataKey();
}
