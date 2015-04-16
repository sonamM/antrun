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
 * Annotation for supplying excel files, sheets as arguments to the TestNG's data provider.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface IExcelDataFiles {

	/**
	 * String of comma separated list of File, Sheets. Example: input1="File,Sheets",input2="File,Sheets"
	 * If, no sheets are given, all available sheets will be read.
	 *
	 * @return the string[]
	 */
	String[] excelDataFiles();

}

