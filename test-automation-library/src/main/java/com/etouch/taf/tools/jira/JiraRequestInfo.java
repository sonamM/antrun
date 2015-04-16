/*
 * 
 */
package com.etouch.taf.tools.jira;

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
public class JiraRequestInfo {
	
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
	boolean attachmentPresent =true ;
	
	/**
	 * Instantiates a new jira request info.
	 */
	public JiraRequestInfo(){
		pageSize = -1;
		limit = -1;
	}
	
	
	/// constructor for JiraRequestInfo class///
	/**
	 * Instantiates a new jira request info.
	 *
	 * @param reqType the req type
	 * @param key the key
	 * @param reqEntries the req entries
	 */
	public JiraRequestInfo(String reqType, String key, Map<String, String> reqEntries){
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

}
