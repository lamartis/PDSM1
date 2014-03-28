package com.outils;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.interfaces.P2mInterface;

public class DecodeurP2M {

	public static P2mInterface convert(String xml){
		StringReader reader = new StringReader(xml);
		P2mInterface p2mInterface = null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance("com.generatedClasses.presentation");
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			p2mInterface = (P2mInterface) jaxbUnmarshaller.unmarshal(reader);
		} catch (Exception e){}

		return p2mInterface;
	}
}