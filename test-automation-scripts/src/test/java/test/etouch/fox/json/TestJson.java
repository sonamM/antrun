package test.etouch.fox.json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.etouch.cisco.common.BaseTest;
import com.etouch.taf.core.exception.ResourceLoadException;
import com.etouch.taf.core.exception.ValidationException;
import com.etouch.taf.tools.json.schemavalidator.IReader;
import com.etouch.taf.tools.json.schemavalidator.IValidator;
import com.etouch.taf.tools.json.schemavalidator.JsonDataReader;
import com.etouch.taf.tools.json.schemavalidator.JsonSchemaReader;
import com.etouch.taf.tools.json.schemavalidator.JsonValidator;
import com.etouch.taf.util.FileUtils;
import com.etouch.taf.util.LogUtil;

/**
 * 
 * @author eTouch Systems Corporation
 *
 */

public class TestJson extends BaseTest {
	
	static Log log = LogUtil.getLog(TestJson.class);
	
	Properties prop;
	IValidator validator;	
	IReader readschema;
	IReader readdata;
	
	@BeforeClass(alwaysRun = true)
	@Parameters(value = {"jsonPropFileName"})
	public void loadJsonPropFileName(String jsonProFileName){

		validator = new JsonValidator();
		readschema = new JsonSchemaReader();
		readdata = new JsonDataReader();
		try {
			prop = FileUtils.readPropertyFile(jsonProFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
		try {
			String schema = prop.getProperty("product.schema");
			readschema.loadFromResource(schema);
		} catch (ResourceLoadException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
	}

	
	@Test
	public void testJsonProductLoadFromResourceProperties(){
		String data = prop.getProperty("product.data");
		try {
			readdata.loadFromResource(data);
		} catch (ResourceLoadException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
		try {
			Assert.assertTrue(validator.validate(readschema.getNode(),readdata.getNode()), "Validation Failed");
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			log.error(e.toString());
		}
	}
	
}
