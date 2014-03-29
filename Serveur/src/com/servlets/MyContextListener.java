package com.servlets;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.outils.LoggerSingleton;
import com.outils.ServletContextSingleton;

import fr.projet9.consumer.Consumer;
import fr.projet9.producteur.Producer;

public class MyContextListener implements ServletContextListener {
	Producer producerM2P;
	Producer producerM2I;
	Consumer consumerI2M;
	ExecutorService poolProducers;
	Properties prop;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		producerM2I.closeConnection();
		producerM2P.closeConnection();
		consumerI2M.closeConnection();
		
		poolProducers.shutdown();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		ServletContext servletContext = arg0.getServletContext();

		/////////Sauvegarder l'objet ServletContext//////////
		ServletContextSingleton.getInstance(servletContext);

		/////////Sauvegarder l'objet Properties////////////// 
		try {
			
			Context ctx = new InitialContext();
			String string = (String) ctx.lookup("java:comp/env/properties");

			prop = new Properties();
			FileInputStream fis = new FileInputStream(servletContext.getRealPath("/META-INF/" + string));
			prop.load(fis);
			servletContext.setAttribute("properties", prop);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//////////Lancer le consomateur////////////
		consumerI2M = new Consumer("metierI2M");
		consumerI2M.doConnection("ReqIM"); 
		System.out.println("Consumer on ReqIM queue inisialized");
		
		//////////Lancer le Producteur////////////
		producerM2P = new Producer("ReqMP");
		producerM2I = new Producer("ReqMI");
		
		servletContext.setAttribute("producerM2P", producerM2P);
		servletContext.setAttribute("producerM2I", producerM2I);
		
		/////////Charger en ServletContext le poolProducers/////////
		poolProducers = Executors.newFixedThreadPool(4);
		servletContext.setAttribute("poolProducers", poolProducers);

		////////Initialiser le Logger//////////////////////////////
		LoggerSingleton.initialize(prop.getProperty("log.location"));
		LoggerSingleton.getInstance().addInfoLog("initialized with success");
	}

}
