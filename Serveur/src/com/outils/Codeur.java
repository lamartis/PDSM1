package com.outils;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Codeur {

	public static String convert(Object gnc){
		StringWriter xmlMessage = new StringWriter();
		try {
			JAXBContext context = JAXBContext.newInstance(gnc.getClass());
			Marshaller marshaller = context.createMarshaller();
			marshaller.marshal(gnc, xmlMessage);
		} catch (JAXBException e) {}
		return  xmlMessage.toString();
	}
}
