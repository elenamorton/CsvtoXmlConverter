package com.sarmisegetusa.pojo;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 
 * This class stores an employee's first name, last name and their role
 *
 */
public class Record {
	final private int INITIAL_CAPACITY = 100;
	final private boolean ACCESS_ORDER = false; //set to insert_order
	final private float LOAD_FACTOR = (float)0.75;
	
	/** Employee Fields */
	private LinkedHashMap<String, String> fields;

	/** Constructor **/
	public Record() {
		fields = new LinkedHashMap<String, String>(INITIAL_CAPACITY, LOAD_FACTOR, ACCESS_ORDER);
	}
	
	/** Public methods */
	
	public LinkedHashMap<String, String> getFields() {
		return fields;
	}

	public void setFields(LinkedHashMap<String, String> fields) {
		this.fields = fields;
	}

	public void addField(String key, String value) {
		fields.put(key, value);
	}

}
