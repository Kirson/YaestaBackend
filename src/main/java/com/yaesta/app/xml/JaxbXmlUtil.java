package com.yaesta.app.xml;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

public class JaxbXmlUtil {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static String marshal(String rootName, Object objValue) {
		try {
			StringWriter stringWriter = new StringWriter();
			String xml;
			JAXBContext jc = JAXBContext.newInstance();
			Marshaller m = jc.createMarshaller();

			JAXBElement jx = new JAXBElement(new QName(rootName), objValue.getClass(), objValue);
			m.marshal(jx, stringWriter);
		
			xml = stringWriter.toString();
			return xml;
		} catch (JAXBException ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
