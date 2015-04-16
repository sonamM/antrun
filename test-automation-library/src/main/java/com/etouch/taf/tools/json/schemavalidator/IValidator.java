/*
 * 
 */
package com.etouch.taf.tools.json.schemavalidator;

import com.etouch.taf.core.exception.ValidationException;

// TODO: Auto-generated Javadoc
/**
 * Contract for validating data.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public interface IValidator {
	
	/**
	 * Validate.
	 *
	 * @param schema the schema
	 * @param data the data
	 * @return true, if successful
	 * @throws ValidationException the validation exception
	 */
	boolean validate(Object schema,Object data) throws ValidationException;

	/**
	 * Generate report.
	 *
	 * @throws ValidationException the validation exception
	 */
	void generateReport() throws ValidationException;
	
}
