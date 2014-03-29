package com.outils;

import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.interfaces.M2iInterface;

public class DecodeurI2M {

	public static M2iInterface convert(String xml){
		StringReader reader = new StringReader(xml);
		M2iInterface object = null;
		try{
			JAXBContext jaxbContext = JAXBContext.newInstance("com.generatedClasses.integration");
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			object = (M2iInterface) jaxbUnmarshaller.unmarshal(reader);
		}catch(Exception e){}

		return object;
	}
}