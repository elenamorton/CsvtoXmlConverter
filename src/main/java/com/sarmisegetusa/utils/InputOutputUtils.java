package com.sarmisegetusa.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sarmisegetusa.pojo.Record;

public class InputOutputUtils {
	
	/**
	 * This method reads a CSV file and creates a list of Record elements.
	 * 
	 * @param path - path to the CSV file to be read
	 * @return - List of records. Each record is created from a line in the CSV file
	 * @throws Exception
	 */
	public static ArrayList<Record> readCsv(String path) throws Exception {
		ArrayList<Record> content = new ArrayList<Record>();
		Scanner scanner = new Scanner(new File(path));

		// Headers. Change for Dynamic CSV
		String headers[] = scanner.nextLine().split("");
		
		while (scanner.hasNextLine()) { // Read every line in file
			String values[] = scanner.nextLine().split(",");
			// Create Record
			Record record = new Record();

			for (int i = 0; i < headers.length; i++) {
				record.addField(headers[i], values[i]);
			}
			
			content.add(record);
		}
		scanner.close();
		return content;
	}

	/**
	 * This method receives a List of records and writes the records as XML to a file
	 * @param records -  List of records to be written as XML
	 * @param path - path to write the XML file
	 * @throws Exception
	 */
	public static void writeXml(ArrayList<Record> records, String path) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element mainRootElement = document.createElement("RECORDS"); // Creates <RECORDS>
			document.appendChild(mainRootElement);

			// Iterate through records
			for (Record record : records) {
				mainRootElement.appendChild(createRecordElement(document, record));
			}

			// output DOM XML to console
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(document);
			StreamResult writer = new StreamResult(new File(path));
			transformer.transform(source, writer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Creates a <RECORD> XML element out of a Record object
	 * 
	 * @param document - XML document to create the element in
	 * @param record - record to create
	 * @return the record element that was created
	 */
	private static Element createRecordElement(Document document, Record record) {
		Element recordElement = document.createElement("RECORD");
		recordElement.appendChild(createSimpleXmlElement(document, "FIRST_NAME", record.getFirstName()));
		recordElement.appendChild(createSimpleXmlElement(document, "LAST_NAME", record.getLastName()));
		recordElement.appendChild(createSimpleXmlElement(document, "ROLE", record.getRole()));
		return recordElement;
	}

	/**
	 * Creates an XML element that looks like this: <NAME>VALUE</NAME>
	 * 
	 * @param doc - XML document to create the element in
	 * @param name - name of tag name to use for the element tag
	 * @param value - value to put inside the name tag
	 * @return the name element that was created (i.e. <name>value</name>)
	 */
	private static Node createSimpleXmlElement(Document doc, String name, String value) {
		Element node = doc.createElement(name);
		node.appendChild(doc.createTextNode(value));
		return node;
	}
}
