/*
 * 
 */
package com.etouch.taf.tools.rally;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * This class stores Request information.
 * @author eTouch Systems Corporation
 * @version 1.0
 *
 */
public class RequestInfo {
	
	/** The request type. */
	String requestType;
	
	/** The fetch. */
	String fetch[]; 
	
	/** The query filter. */
	ArrayList<String> queryFilter;
	
	/** The ref field. */
	String refField;
	
	/** The query order. */
	Hashtable<String,String> queryOrder;
	
	/** The page size. */
	int pageSize;
	
	/** The limit. */
	int limit;
	
	/** The entry. */
	Map<String,Map<String,String>> entry;
	
	/** The attachment present. */
	boolean attachmentPresent;

	/** The img file path. */
	String imgFilePath;
	
	/** The img file name. */
	String imgFileName;
	
	/** The access mode. */
	String accessMode;
	
	/** The project oid. */
	String projectOID;
	
	/** The scope down. */
	boolean scopeDown;

	/**
	 * Checks if is attachment present.
	 *
	 * @return true, if is attachment present
	 */
	public boolean isAttachmentPresent() {
		return attachmentPresent;
	}

	/**
	 * Sets the attachment present.
	 *
	 * @param attachmentPresent the new attachment present
	 */
	public void setAttachmentPresent(boolean attachmentPresent) {
		this.attachmentPresent = attachmentPresent;
	}
	
	/**
	 * Gets the access mode.
	 *
	 * @return the access mode
	 */
	public String getAccessMode() {
		return accessMode;
	}

	/**
	 * Sets the access mode.
	 *
	 * @param accessMode the new access mode
	 */
	public void setAccessMode(String accessMode) {
		this.accessMode = accessMode;
	}

	/**
	 * Gets the img file path.
	 *
	 * @return the img file path
	 */
	public String getImgFilePath() {
		return imgFilePath;
	}

	/**
	 * Sets the img file path.
	 *
	 * @param imgFilePath the new img file path
	 */
	public void setImgFilePath(String imgFilePath) {
		this.imgFilePath = imgFilePath;
	}

	/**
	 * Gets the img file name.
	 *
	 * @return the img file name
	 */
	public String getImgFileName() {
		return imgFileName;
	}

	/**
	 * Sets the img file name.
	 *
	 * @param imgFileName the new img file name
	 */
	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	/**
	 * Instantiates a new request info.
	 */
	public RequestInfo(){
		pageSize = -1;
		limit = -1;
	}
	
	/**
	 * Instantiates a new request info.
	 *
	 * @param reqType the req type
	 * @param key the key
	 * @param reqEntries the req entries
	 */
	public RequestInfo(String reqType, String key, Map<String, String> reqEntries){
		setRequestType(reqType);
		for(Map.Entry<String, String> entry: reqEntries.entrySet()){
			addEntry(key, entry.getKey(), entry.getValue());
		}
	}
	
	/**
	 * Gets the request type.
	 *
	 * @return the request type
	 */
	public String getRequestType() {
		return requestType;
	}
	
	/**
	 * Sets the request type.
	 *
	 * @param requestType the new request type
	 */
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	/**
	 * Gets the fetch.
	 *
	 * @return the fetch
	 */
	public String[] getFetch() {
		return fetch;
	}
	
	/**
	 * Sets the fetch.
	 *
	 * @param fetch the new fetch
	 */
	public void setFetch(String[] fetch) {
		this.fetch = fetch;
	}	
	
	/**
	 * Gets the query filter.
	 *
	 * @return the query filter
	 */
	public ArrayList<String> getQueryFilter() {
		return queryFilter;
	}

	/**
	 * Sets the query filter.
	 *
	 * @param queryFilter the new query filter
	 */
	public void setQueryFilter(ArrayList<String> queryFilter) {
		this.queryFilter = queryFilter;
	}
	
	/**
	 * Gets the ref field.
	 *
	 * @return the ref field
	 */
	public String getRefField() {
		return refField;
	}

	/**
	 * Sets the ref field.
	 *
	 * @param refField the new ref field
	 */
	public void setRefField(String refField) {
		this.refField = refField;
	}
	
	/**
	 * Adds the order.
	 *
	 * @param field the field
	 * @param order the order
	 */
	public void addOrder(String field,String order) {
		if(queryOrder == null)
			queryOrder = new Hashtable<String, String>();
		queryOrder.put(field,order);
	}

	/**
	 * Gets the query order.
	 *
	 * @return the query order
	 */
	public Map<String, String> getQueryOrder() {
		return queryOrder;
	}

	/**
	 * Gets the page size.
	 *
	 * @return the page size
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * Sets the page size.
	 *
	 * @param pageSize the new page size
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * Gets the limit.
	 *
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * Sets the limit.
	 *
	 * @param limit the new limit
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	/**
	 * Adds the entry.
	 *
	 * @param key the key
	 * @param name the name
	 * @param value the value
	 */
	public void addEntry(String key, String name,String value){
		
		if(entry == null)
			entry = new HashMap<String, Map<String,String>>();
		
		Map<String, String> map = null;
		if(entry.containsKey(key))
			map = entry.get(key);
		
		if(map == null)
			map =  new HashMap<String, String>();
		
		map.put(name, value);
		
		entry.put(key, map
				);
	}
	
	/**
	 * Gets the entry.
	 *
	 * @return the entry
	 */
	public Map<String, Map<String,String>> getEntry() {
		return entry;
	}
	
	/**
	 * Sets the entry.
	 *
	 * @param newEntry the new entry
	 */
	public void setEntry(Map<String, Map<String,String>> newEntry) {
		this.entry = newEntry;
	}

	/**
	 * Gets the project oid.
	 *
	 * @return the project oid
	 */
	public String getProjectOID() {
		return projectOID;
	}

	/**
	 * Sets the project oid.
	 *
	 * @param projectOID the new project oid
	 */
	public void setProjectOID(String projectOID) {
		this.projectOID = projectOID;
	}

	/**
	 * Checks if is scope down.
	 *
	 * @return true, if is scope down
	 */
	public boolean isScopeDown() {
		return scopeDown;
	}

	/**
	 * Sets the scope down.
	 *
	 * @param scopeDown the new scope down
	 */
	public void setScopeDown(boolean scopeDown) {
		this.scopeDown = scopeDown;
	}


}
