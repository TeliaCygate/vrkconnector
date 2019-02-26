package com.propentus.sp2.componentlibrary.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


/**
 * Contains various useful methods for entity manipulation
 */
public class EntityUtil {
	
	/***
	 * Convert XML String to JAXB annotated Object presentation
	 * @param t
	 * @param xml
	 * @return
	 * @throws JAXBException
	 */
	public static <T> T XMLtoObject(Class<T> t, String xml) throws JAXBException {
		//Read xml string to reader
		StringReader reader = new StringReader(xml);
		
		JAXBContext context = JAXBContext.newInstance(t);
	    Unmarshaller unMarshaller = context.createUnmarshaller();
	    return (T) unMarshaller.unmarshal(reader);
	}
	
	/***
	 * Convert JAXB annotated Object to XML String
	 * @param obj
	 * @return
	 * @throws JAXBException
	 */
	public static <T> String ObjectToXML(Object obj) throws JAXBException {
		//Read xml string to reader
		
		StringWriter sw = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
	    Marshaller marshaller = context.createMarshaller();
	    marshaller.marshal(obj, sw);
	    return sw.toString();
	}
	
	/**
	 * Create traversable XML-document from XML string
	 * @param xml
	 * @return
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document createXMLDoc(String xml) throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilderFactory factory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		StringBuilder xmlStringBuilder = new StringBuilder();
		xmlStringBuilder.append(xml);
		ByteArrayInputStream input =  new ByteArrayInputStream(
		   xmlStringBuilder.toString().getBytes("UTF-8"));
		Document doc = builder.parse(input);
		
		return doc;
	}
	

}
