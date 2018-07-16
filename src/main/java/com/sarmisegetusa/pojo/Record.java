package com.sarmisegetusa.pojo;

import java.util.HashMap;

/**
 * 
 * This class stores an employee's first name, last name and their role
 *
 */
public class Record {

	/** Employee Fields */
	private HashMap<String, String> fields;

	/** Constructor **/
	public Record() {
		fields = new HashMap<String, String>();
	}
	
	/** Public methods */
	
	public HashMap<String, String> getFields() {
		return fields;
	}

	public void setFields(HashMap<String, String> fields) {
		this.fields = fields;
	}

	public void addField(String key, String value) {
		fields.put(key, value);
	}

}
