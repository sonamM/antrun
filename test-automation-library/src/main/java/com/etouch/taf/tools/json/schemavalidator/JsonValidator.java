/*
 * 
 */
package com.etouch.taf.tools.json.schemavalidator;

import org.apache.commons.logging.Log;

import com.etouch.taf.core.exception.ReportException;
import com.etouch.taf.core.exception.ValidationException;
import com.etouch.taf.util.LogUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.report.ProcessingReport;
import com.github.fge.jsonschema.report.ProcessingMessage;

// TODO: Auto-generated Javadoc
/**
 * This class validates JSON data against schema.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class JsonValidator implements IValidator {
	
	/** The log. */
	private static Log log = LogUtil.getLog(JsonValidator.class);
	
	/** The report. */
	ProcessingReport report;
	
	/* (non-Javadoc)
	 * @see com.etouch.taf.tools.json.schemavalidator.IValidator#validate(java.lang.Object, java.lang.Object)
	 */
	public boolean validate(Object schema,Object data) throws ValidationException {

		final boolean success;
		
		try{
		
			final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();

			final JsonSchema jsonschema = factory.getJsonSchema((JsonNode)schema);
        
			report = jsonschema.validate((JsonNode)data);
		
			success = report.isSuccess();
        
		}catch(Exception exp){
			throw new ValidationException(exp.toString());
		}
		
        return success;
	}
	
	/* (non-Javadoc)
	 * @see com.etouch.taf.tools.json.schemavalidator.IValidator#generateReport()
	 */
	public void generateReport() throws ValidationException {
		try{
			log.info("start generate report");
			for (final ProcessingMessage message : report)
				log.info(message);
			log.info("end generate report");
		}catch(Exception exp){
			throw new ValidationException(exp.toString());
		}
	}

	
}
