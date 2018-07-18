package com.sarmisegetusa.main;

import java.util.ArrayList;

import com.sarmisegetusa.pojo.Record;
import com.sarmisegetusa.utils.InputOutputUtils;

/**
 * This class utilises the InputOutputUtils class to read a CSV file and write its contents to an XML file.
 * This is the starting point of the project. This class reads the CSV from input\input.csv (See the  Project Explorer window on left)
 * and writes XML to output\output.XML
 */
public class CsvToXmlConverter {
	public static void main(String[] args) throws Exception {
		
		// Read CSV
		System.out.println("READING input.csv under input folder");
		ArrayList<Record> records = InputOutputUtils.readCsv("input\\input.csv");
		System.out.println("SUCCESSFULLY READ input.csv under input folder");

		
		//Write XML
		System.out.println("WRITING output.xml under output folder");
		InputOutputUtils.writeXml(records, "output\\output.xml");
		System.out.println("SUCCESSFULLY created output.xml under output folder");
	}
}
