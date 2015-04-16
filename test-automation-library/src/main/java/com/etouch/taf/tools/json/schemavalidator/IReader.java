/*
 * 
 */
package com.etouch.taf.tools.json.schemavalidator;

import com.etouch.taf.core.exception.ResourceLoadException;

// TODO: Auto-generated Javadoc
/**
 * Reader contract for loading resource.
 * 
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public interface IReader {

	/**
	 * Load from resource.
	 *
	 * @param resource the resource
	 * @throws ResourceLoadException the resource load exception
	 */
	void loadFromResource(String resource) throws ResourceLoadException;	

	/**
	 * Load from url.
	 *
	 * @param url the url
	 * @throws ResourceLoadException the resource load exception
	 */
	void loadFromURL(String url) throws ResourceLoadException;
	
	/**
	 * Load from path.
	 *
	 * @param path the path
	 * @throws ResourceLoadException the resource load exception
	 */
	void loadFromPath(String path) throws ResourceLoadException;
	
	/**
	 * Load from string.
	 *
	 * @param json the json
	 * @throws ResourceLoadException the resource load exception
	 */
	void loadFromString(String json) throws ResourceLoadException;
	
	/**
	 * Gets the node.
	 *
	 * @return the node
	 */
	Object getNode();

}
