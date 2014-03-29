package com.traitement.integration;

import java.util.Properties;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import javax.servlet.ServletContext;
import com.interfaces.M2iInterface;
import com.outils.ServletContextSingleton;
import fr.projet9.producteur.Producer;

public abstract class TraitementI implements Callable<Void> {

	ServletContext servletContext = ServletContextSingleton.getServletcontext();

	ExecutorService poolProducers = (ExecutorService) servletContext.getAttribute("poolProducers");

	Properties properties = (Properties) servletContext.getAttribute("properties");
	Producer producerM2P  = (Producer) servletContext.getAttribute("producerM2P");
	Producer producerM2I  = (Producer) servletContext.getAttribute("producerM2I");

	String accountsFolder   = properties.getProperty("com.folder.accounts");
	String projectUrl       = properties.getProperty("com.url.project");

	M2iInterface requete;
	String responseXMLMessage, idMessage, idCorrelation;

	public TraitementI(M2iInterface object, String idMessage, String correlationId){
		this.requete = object;
		this.idMessage = idMessage;
		this.idCorrelation = correlationId;
	}
}
